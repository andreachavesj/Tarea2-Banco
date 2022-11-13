package Modelo;

import java.time.LocalDate;

public class CuentaAhorroProgramado extends Cuenta{
    /**
     * Constructor con todos los atributos
     * @param cedula
     * @param numeroCuenta
     * @param saldo
     * @param apertura
     * @param cuentaCorriente
     */
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

    /**
     * Metodo toString de clase cuenta ahorro programado
     * @return
     */
    @Override
    public String toString() {
        return "CuentaAhorroProgramado{" +
                "cuentaCorriente=" + cuentaCorriente +
                '}';
    }
}
