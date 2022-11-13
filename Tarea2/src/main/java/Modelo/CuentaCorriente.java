package Modelo;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta{
    /**
     * Constructor con todos los atributos
     * @param cedula
     * @param numeroCuenta
     * @param saldo
     * @param apertura
     */
    public CuentaCorriente(String cedula, int numeroCuenta, double saldo, LocalDate apertura) {
        super(cedula, numeroCuenta, saldo, apertura);
    }
}