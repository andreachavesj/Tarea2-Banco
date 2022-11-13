package Controlador;

import Modelo.*;
import Vista.Deposito;
import Vista.MostrarSaldo;
import Vista.Retiro;

import java.time.LocalDate;
import java.util.ArrayList;

public class CuentaControlador {
    /**
     * ArrayList de cuenta que guarda todas las cuentas que se creen
     */
    public static ArrayList<Cuenta> conjuntoCuentas=new ArrayList<Cuenta>();

    /**
     * Arraylist de tipo cuentaCorriente que guarda el conjunto de cuentas corrientes que se creen
     */
    public static ArrayList<CuentaCorriente> conjuntoCuentasCorrientes =new ArrayList<CuentaCorriente>();

    /**
     * ArrayList de tipo cuenta ahorro programado que guarda el conjunto cuentas de ahorro programado que se creen
     */
    public static ArrayList<CuentaAhorroProgramado> conjuntoCuentasAhorroProgramado= new ArrayList<CuentaAhorroProgramado>();

    /**
     * ArrayList de tipo cuenta ahorro que guarda el conjunto de cuentas de ahorro que se creen
     */
    public static ArrayList<CuentaAhorro> conjuntoCuentasAhorro= new ArrayList<CuentaAhorro>();

    /**
     * Funcion que permite registrar una cuenta corriente, donde siempre el numero de
     * cuenta empezara con uno y el resto de numeros será seleccionado al azar esto a modo de diferenciador entre los
     * tipos de cuenta
     * @param identificacion
     * @param deposito
     * @return int numeroCuenta
     */
    public static int registrarCuentaCorriente(String identificacion, double deposito) {
        int numeroCuenta = Integer.parseInt("1"+ numeroRandomCuenta(100000, 999999));
        LocalDate fechaApertura = LocalDate.now();
            CuentaCorriente cuentaCorriente = new CuentaCorriente(identificacion, numeroCuenta, deposito, fechaApertura);
            conjuntoCuentas.add(cuentaCorriente);
            conjuntoCuentasCorrientes.add(cuentaCorriente);

        return numeroCuenta;
    }

    /**
     * Funcion que permite crear los digitos de las cuentas de manera random donde se cuenta con un minimo y maximo
     * de numeros con los que puede crear el numero de cuenta
     * @param maximo
     * @param minimo
     * @return int numeroRandom
     */
    public static int numeroRandomCuenta(int maximo, int minimo) {
        int range = (maximo-minimo) + 1;
        return (int) (Math.random() * range) + minimo;
    }

    /**
     * Funcion que permite verificar si a existe la cedula en los registros y si no esta no permite crear cuentas
     * de ningun tipo
     * @param identificacion
     * @return boolean
     */
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

    /**
     * Funcion que permite registrar una cuenta de ahorro programadom, obtiene el numero de cuenta que empezara con
     * 3 de manera de diferenciar de las demas tipos de cuenta, además buscara que la cuenta corriente ingresada si existe
     * y concuerde con la cedula
     * @param identificacion
     * @param deposito
     * @param cuentaCorriente
     * @return int numero de cuenta
     */
    public static int registrarCuentaAhorroProgramado(String identificacion,double deposito, int cuentaCorriente) {
        int numeroCuentaProgramado = Integer.parseInt("3"+ numeroRandomCuenta(100000, 999999));
        LocalDate fechaApertura = LocalDate.now();
        CuentaAhorroProgramado cuentaAhorroProgramado = new CuentaAhorroProgramado(identificacion, numeroCuentaProgramado, deposito, fechaApertura, cuentaCorriente);
        for (CuentaCorriente conjuntoCuentaCorriente : conjuntoCuentasCorrientes){
            if (conjuntoCuentaCorriente.getCedula().equals(identificacion) && conjuntoCuentaCorriente.getNumeroCuenta() == cuentaCorriente) {
                conjuntoCuentaCorriente.setSaldo(conjuntoCuentaCorriente.getSaldo()-deposito);
                break;
            }
        }
        conjuntoCuentas.add(cuentaAhorroProgramado);
        conjuntoCuentasAhorroProgramado.add(cuentaAhorroProgramado);

        return numeroCuentaProgramado;
    }

    /**
     * Funcion que permite mostrar el saldo obteniendo la identificacion y cuenta ingresada y en caso de ser el saldo
     * 0 mostrar un mensaje especifico, ademas de la validacion de que la identificacion y cuenta si existan
     * @param identificacion
     * @param cuenta
     * @return double saldo
     */
    public static double mostrarSaldo(String identificacion,int cuenta) {
        double saldo = 0;
        for (Cuenta conjuntoCuenta : conjuntoCuentas){
            if (conjuntoCuenta.getCedula().equals(identificacion) && conjuntoCuenta.getNumeroCuenta() == cuenta &&conjuntoCuenta.getSaldo()>0) {
                saldo= conjuntoCuenta.getSaldo();
                break;
            }else if(conjuntoCuenta.getSaldo()==0){
                MostrarSaldo.sinSaldo();
            }
        }
        return saldo;
    }

    /**
     * Funcion que permite verificar si la cedula y numero de cuenta ingresados son correctos y si existen para poder
     * llevar acabo otras funciones
     * @param identificacion
     * @param numeroCuenta
     * @return boolean
     */
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

    /**
     * Funcion que permite registrar una cuenta de ahorro, utilizando la funcion de verificar cedula, obtiene el
     * numero de cuenta que empezara con 2 a manera de diferenciador
     * @param cedula
     * @param deposito
     * @param interes
     * @return int numeroCuentaAhorro
     */
    public static int registrarCuentaAhorro(String cedula,double deposito, double interes) {
        int numeroCuentaAhorro = Integer.parseInt("2"+ numeroRandomCuenta(100000, 999999));
        LocalDate fechaApertura = LocalDate.now();
        CuentaAhorro cuentaAhorro = new CuentaAhorro(cedula, numeroCuentaAhorro, deposito, fechaApertura, interes);
        conjuntoCuentas.add(cuentaAhorro);
        conjuntoCuentasAhorro.add(cuentaAhorro);

        return numeroCuentaAhorro;
    }

    /**
     * Funcion que permite realizar depositos, verificando que la cuenta y la cedula exista, ademas si es
     * una cuenta de ahorro programado no permitir depositos e incluirlo a movimientos
     * @param cedula
     * @param cuenta
     * @param deposito
     */
    public static void depositar(String cedula, int cuenta, double deposito) {
        LocalDate fechaDeposito = LocalDate.now();
        String descripcion= "Deposito a cuenta";
        for (CuentaCorriente conjuntoCuentaCorriente : conjuntoCuentasCorrientes){
            if (conjuntoCuentaCorriente.getCedula().equals(cedula) && conjuntoCuentaCorriente.getNumeroCuenta() == cuenta) {
                conjuntoCuentaCorriente.setSaldo(conjuntoCuentaCorriente.getSaldo()+deposito);
                Deposito.mensajeExitoso();
                Movimientos movimientos= new Movimientos(cuenta, fechaDeposito, descripcion, deposito);
                break;
            }
        }
        for (CuentaAhorro conjuntoCuentaAhorro : conjuntoCuentasAhorro){
            if (conjuntoCuentaAhorro.getCedula().equals(cedula) && conjuntoCuentaAhorro.getNumeroCuenta() == cuenta) {
                conjuntoCuentaAhorro.setSaldo(conjuntoCuentaAhorro.getSaldo()+deposito);
                Deposito.mensajeExitoso();
                Movimientos movimientos= new Movimientos(cuenta, fechaDeposito, descripcion, deposito);
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

    /**
     * Funcion que permite realizar retiros verificando que exista la cuenta y cedula ademas que el monto ingresado sea
     * menor o igual al saldo en la cuenta corriente, el monto ingresado sea menor o igual al 50% del saldo y solo se
     * realizaran retiros si el saldo es mayor o igual a 100 mil y en ahorro programado no se permite realizar retiros
     * hasta que la fecha de retiro sea un año despues de la fecha de creacion
     * @param cedula
     * @param cuenta
     * @param retiro
     */
    public static void retirar(String cedula, int cuenta, double retiro) {
        boolean respuestaBuena= true;
        LocalDate fechaRetiro = LocalDate.now();
        String descripcion= "Retiro a cuenta";
        for (CuentaCorriente conjuntoCuentaCorriente : conjuntoCuentasCorrientes){
            if (conjuntoCuentaCorriente.getCedula().equals(cedula) && conjuntoCuentaCorriente.getNumeroCuenta() == cuenta&&(retiro<conjuntoCuentaCorriente.getSaldo())) {
                conjuntoCuentaCorriente.setSaldo(conjuntoCuentaCorriente.getSaldo()-(retiro));
                Retiro.mensajeExitoso();
                Movimientos movimientos= new Movimientos(cuenta, fechaRetiro, descripcion, retiro);
                respuestaBuena=true;
                break;
            }
            else{
                respuestaBuena= false;
            }
        }
        for (CuentaAhorro conjuntoCuentaAhorro : conjuntoCuentasAhorro){
            double saldoPermitido= (conjuntoCuentaAhorro.getSaldo()/2);
            if (conjuntoCuentaAhorro.getCedula().equals(cedula) && conjuntoCuentaAhorro.getNumeroCuenta() == cuenta&&(conjuntoCuentaAhorro.getSaldo()>=100000)&& (retiro<= saldoPermitido)){
                conjuntoCuentaAhorro.setSaldo(conjuntoCuentaAhorro.getSaldo()-retiro);
                Movimientos movimientos= new Movimientos(cuenta, fechaRetiro, descripcion, retiro);
                respuestaBuena=true;
                break;
            }
            else{
                respuestaBuena=false;
            }
        }
        for (CuentaAhorroProgramado conjuntoCuentaAhorroProgramado : conjuntoCuentasAhorroProgramado){
            if (conjuntoCuentaAhorroProgramado.getCedula().equals(cedula) && conjuntoCuentaAhorroProgramado.getNumeroCuenta() == cuenta&&(retiro<conjuntoCuentaAhorroProgramado.getSaldo())&&(conjuntoCuentaAhorroProgramado.getApertura().plusYears(1).isBefore(fechaRetiro))) {
                conjuntoCuentaAhorroProgramado.setSaldo(conjuntoCuentaAhorroProgramado.getSaldo()-retiro);
                Retiro.mensajeExitoso();
                Movimientos movimientos= new Movimientos(cuenta, fechaRetiro, descripcion, retiro);
                respuestaBuena=true;
                break;
            }
            else {
                respuestaBuena=false;
            }
        }
        if(respuestaBuena==false){
            Retiro.mensajeError();
        }else{
            Retiro.mensajeExitoso();
        }
    }
}
