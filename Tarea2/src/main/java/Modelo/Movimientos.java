package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Movimientos {

    /**
     * Atributos de la clase movimientos
     */
    private int cuenta;
    private LocalDate fechaMovimiento;
    private String descripcion;
    private double monto;

    /**
     * Constructor de la clase movimientos con todos sus atributos
     * @param cuenta
     * @param fechaMovimiento
     * @param descripcion
     * @param monto
     */
    public Movimientos(int cuenta, LocalDate fechaMovimiento, String descripcion, double monto) {
        this.cuenta = cuenta;
        this.fechaMovimiento = fechaMovimiento;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    /**
     * Getter y setter de todos los atributos
     * @return
     */
    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public LocalDate getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDate fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }


    /**
     * Metodo equals de la clase movimientos
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimientos that = (Movimientos) o;
        return cuenta == that.cuenta && Double.compare(that.monto, monto) == 0 && Objects.equals(fechaMovimiento, that.fechaMovimiento) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuenta, fechaMovimiento, descripcion, monto);
    }

    /**
     * Metodo toString de la clase movimientos
     * @return
     */
    @Override
    public String toString() {
        return "Movimientos{" +
                "cuenta=" + cuenta +
                ", fechaMovimiento=" + fechaMovimiento +
                ", descripcion='" + descripcion + '\'' +
                ", monto=" + monto +
                '}';
    }
}
