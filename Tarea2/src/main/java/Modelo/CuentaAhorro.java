package Modelo;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta{
    public CuentaAhorro(String cedula, int numeroCuenta, double saldo, LocalDate apertura, double tasaInteres) {
        super(cedula, numeroCuenta, saldo, apertura);
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro(int numeroCuenta, double saldo, LocalDate apertura) {
        super(numeroCuenta, saldo, apertura);
    }
    private double tasaInteres;
}
