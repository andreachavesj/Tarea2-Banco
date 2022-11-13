package Modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Cuenta {

    /**
     * Atributos de la clase cuenta
     */
    private String cedula;
    private int numeroCuenta;
    private double saldo;

    private LocalDate apertura;

    /**
     * Constructor para la cuenta que no incluye cedula
     * @param numeroCuenta
     * @param saldo
     * @param apertura
     */
    public Cuenta(int numeroCuenta, double saldo, LocalDate apertura) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.apertura = apertura;
    }

    /**
     * Constructor para la clase cuenta con todos sus atributos
     * @param cedula
     * @param numeroCuenta
     * @param saldo
     * @param apertura
     */
    public Cuenta(String cedula, int numeroCuenta, double saldo, LocalDate apertura) {
        this.cedula = cedula;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.apertura = apertura;
    }

    /**
     * Getter y setter de todos los atributos
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getApertura() {
        return apertura;
    }

    public void setApertura(LocalDate apertura) {
        this.apertura = apertura;
    }

    /**
     * Metodo equals de la clase cuenta
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return numeroCuenta == cuenta.numeroCuenta && Double.compare(cuenta.saldo, saldo) == 0 && Objects.equals(apertura, cuenta.apertura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCuenta, saldo, apertura);
    }

    /**
     * Metodo toString de la clase cuenta
     * @return
     */
    @Override
    public String toString() {
        return "Cuenta{" +
                "cedula='" + cedula + '\'' +
                ", numeroCuenta=" + numeroCuenta +
                ", saldo=" + saldo +
                ", apertura=" + apertura +
                '}';
    }
}
