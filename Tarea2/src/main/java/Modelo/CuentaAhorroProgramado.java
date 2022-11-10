package Modelo;

import java.time.LocalDate;

public class CuentaAhorroProgramado extends Cuenta{
    public CuentaAhorroProgramado(String cedula, int numeroCuenta, double saldo, LocalDate apertura, int cuentaCorriente) {
        super(cedula, numeroCuenta, saldo, apertura);
        this.cuentaCorriente = cuentaCorriente;
    }

    private int cuentaCorriente;

    public int getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(int cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    @Override
    public String toString() {
        return "CuentaAhorroProgramado{" +
                "cuentaCorriente=" + cuentaCorriente +
                '}';
    }
}
