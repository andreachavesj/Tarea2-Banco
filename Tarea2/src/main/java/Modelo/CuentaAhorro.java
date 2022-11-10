package Modelo;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta{
    private static double tasaInteres;
    public CuentaAhorro(String cedula, int numeroCuenta, double saldo, LocalDate apertura, double tasaInteres) {
        super(cedula, numeroCuenta, saldo, apertura);
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro(int numeroCuenta, double saldo, LocalDate apertura) {
        super(numeroCuenta, saldo, apertura);
    }

    @Override
    public String toString() {
        return "Cuenta{" + tasaInteres+
                '}';
    }
}
