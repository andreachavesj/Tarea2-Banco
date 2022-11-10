package Controlador;

import Modelo.*;
import Vista.Deposito;
import Vista.Retiro;

import java.time.LocalDate;
import java.util.ArrayList;

public class CuentaControlador {
    public static ArrayList<Cuenta> conjuntoCuentas=new ArrayList<Cuenta>();
    public static ArrayList<CuentaCorriente> conjuntoCuentasCorrientes =new ArrayList<CuentaCorriente>();
    public static ArrayList<CuentaAhorroProgramado> conjuntoCuentasAhorroProgramado= new ArrayList<CuentaAhorroProgramado>();
    public static ArrayList<CuentaAhorro> conjuntoCuentasAhorro= new ArrayList<CuentaAhorro>();
    public static int registrarCuentaCorriente(String identificacion, double deposito) {
        int numeroCuenta = Integer.parseInt("1"+ numeroRandomCuenta(100000, 999999));
        LocalDate fechaApertura = LocalDate.now();
            CuentaCorriente cuentaCorriente = new CuentaCorriente(identificacion, numeroCuenta, deposito, fechaApertura);
            conjuntoCuentas.add(cuentaCorriente);
            conjuntoCuentasCorrientes.add(cuentaCorriente);

        return numeroCuenta;
    }
    public static int numeroRandomCuenta(int maximo, int minimo) {
        int range = (maximo-minimo) + 1;
        return (int) (Math.random() * range) + minimo;
    }
    public static boolean verificarCedula(String identificacion) {
        boolean cedulaRegistrada=false;
        for (int i=0;i<ClienteControlador.conjuntoCedulas.size();i++){
            if (identificacion.equals(ClienteControlador.conjuntoCedulas.get(i))){
                cedulaRegistrada=true;
                break;
            }
        }
        if(cedulaRegistrada==false){
             return false;
        }else{
            return true;
        }
    }

    public static int registrarCuentaAhorroProgramado(String identificacion,double deposito, int cuentaCorriente) {
        int numeroCuentaProgramado = Integer.parseInt("3"+ numeroRandomCuenta(100000, 999999));
        LocalDate fechaApertura = LocalDate.now();
        CuentaAhorroProgramado cuentaAhorroProgramado = new CuentaAhorroProgramado(identificacion, numeroCuentaProgramado, deposito, fechaApertura, cuentaCorriente);
        conjuntoCuentas.add(cuentaAhorroProgramado);
        conjuntoCuentasAhorroProgramado.add(cuentaAhorroProgramado);

        return numeroCuentaProgramado;
    }

    public static double mostrarSaldo(String identificacion,int cuenta) {
        double saldo = 0;
        for (Cuenta conjuntoCuenta : conjuntoCuentas){
            if (conjuntoCuenta.getCedula().equals(identificacion) && conjuntoCuenta.getNumeroCuenta() == cuenta) {
                saldo= conjuntoCuenta.getSaldo();
                break;
            }
        }
        return saldo;
    }
    public static boolean verificarCliente(String identificacion, int numeroCuenta) {
        boolean clienteCorrecto=false;
        for (Cuenta conjuntoCuenta : conjuntoCuentas){
            if (conjuntoCuenta.getCedula().equals(identificacion) && conjuntoCuenta.getNumeroCuenta() == numeroCuenta) {
                conjuntoCuenta.getSaldo();
                clienteCorrecto=true;
            break;
            }
        }
        if(clienteCorrecto==false){
            return false;
        }else{
            return true;
        }
    }

    public static int registrarCuentaAhorro(String cedula,double deposito, double interes) {
        int numeroCuentaAhorro = Integer.parseInt("2"+ numeroRandomCuenta(100000, 999999));
        LocalDate fechaApertura = LocalDate.now();
        CuentaAhorro cuentaAhorro = new CuentaAhorro(cedula, numeroCuentaAhorro, deposito, fechaApertura, interes);
        conjuntoCuentas.add(cuentaAhorro);
        conjuntoCuentasAhorro.add(cuentaAhorro);

        return numeroCuentaAhorro;
    }

    public static void depositar(String cedula, int cuenta, double deposito) {
        for (CuentaCorriente conjuntoCuentaCorriente : conjuntoCuentasCorrientes){
            if (conjuntoCuentaCorriente.getCedula().equals(cedula) && conjuntoCuentaCorriente.getNumeroCuenta() == cuenta) {
                conjuntoCuentaCorriente.setSaldo(conjuntoCuentaCorriente.getSaldo()+deposito);
                Deposito.mensajeExitoso();
                break;
            }
        }
        for (CuentaAhorro conjuntoCuentaAhorro : conjuntoCuentasAhorro){
            if (conjuntoCuentaAhorro.getCedula().equals(cedula) && conjuntoCuentaAhorro.getNumeroCuenta() == cuenta) {
                conjuntoCuentaAhorro.setSaldo(conjuntoCuentaAhorro.getSaldo()+deposito);
                Deposito.mensajeExitoso();
                break;
            }
        }
        for (CuentaAhorroProgramado conjuntoCuentaAhorroProgramado : conjuntoCuentasAhorroProgramado){
            if (conjuntoCuentaAhorroProgramado.getCedula().equals(cedula) && conjuntoCuentaAhorroProgramado.getNumeroCuenta() == cuenta) {
                Deposito.mensajeError();
                break;
            }
        }
    }
    public static void retirar(String cedula, int cuenta, double retiro) {
        for (CuentaCorriente conjuntoCuentaCorriente : conjuntoCuentasCorrientes){
            if (conjuntoCuentaCorriente.getCedula().equals(cedula) && conjuntoCuentaCorriente.getNumeroCuenta() == cuenta&&(retiro<conjuntoCuentaCorriente.getSaldo())) {
                conjuntoCuentaCorriente.setSaldo(conjuntoCuentaCorriente.getSaldo()-(retiro));
                Retiro.mensajeExitoso();
                break;
            }
        }

        for (CuentaAhorro conjuntoCuentaAhorro : conjuntoCuentasAhorro){
            double saldoPermitido= (conjuntoCuentaAhorro.getSaldo()/2);
            if (conjuntoCuentaAhorro.getCedula().equals(cedula) && conjuntoCuentaAhorro.getNumeroCuenta() == cuenta&&(conjuntoCuentaAhorro.getSaldo()>=100000)&& (retiro<= saldoPermitido)){
                conjuntoCuentaAhorro.setSaldo(conjuntoCuentaAhorro.getSaldo()-retiro);
                Retiro.mensajeExitoso();
                break;
            }
        }
        for (CuentaAhorroProgramado conjuntoCuentaAhorroProgramado : conjuntoCuentasAhorroProgramado){
            if (conjuntoCuentaAhorroProgramado.getCedula().equals(cedula) && conjuntoCuentaAhorroProgramado.getNumeroCuenta() == cuenta) {
                Retiro.mensajeError();
                break;
            }
        }
    }
}
