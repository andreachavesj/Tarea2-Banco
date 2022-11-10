package Modelo;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta{
    public CuentaCorriente(String cedula, int numeroCuenta, double saldo, LocalDate apertura) {
        super(cedula, numeroCuenta, saldo, apertura);
    }
}