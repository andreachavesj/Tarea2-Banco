package Modelo;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta{

    /**
     * Atributo tasa de interes de la clase hija de la clase cuenta
     */
    private static double tasaInteres;

    /**
     * Constructor con todos los atributos
     * @param cedula
     * @param numeroCuenta
     * @param saldo
     * @param apertura
     * @param tasaInteres
     */
    public CuentaAhorro(String cedula, int numeroCuenta, double saldo, LocalDate apertura, double tasaInteres) {
        super(cedula, numeroCuenta, saldo, apertura);
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro(int numeroCuenta, double saldo, LocalDate apertura) {
        super(numeroCuenta, saldo, apertura);
    }

    /**
     * Metodo toString de la clase cuenta ahorro
     * @return
     */
    @Override
    public String toString() {
        return "Cuenta{" + tasaInteres+
                '}';
    }
}
