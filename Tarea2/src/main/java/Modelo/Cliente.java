package Modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

    /**
     * Atributos de la clase cliente
     */
    private String nombre;
 private String cedula;
 private String direccion;
 public ArrayList<Cuenta> Cuentas;


    /**
     * Constructor con todos los atributos de la clase
     * @param nombre
     * @param cedula
     * @param direccion
     * @param cuentas
     */
    public Cliente(String nombre, String cedula, String direccion, ArrayList<Cuenta> cuentas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        Cuentas = cuentas;
    }

    /**
     * Constructor que permite crear nuevo cliente sin tener cuentas asociadas
     * @param nombre
     * @param cedula
     * @param direccion
     */
    public Cliente(String nombre, String cedula, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    /**
     * Getter y setter de cada atributo
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return Cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        Cuentas = cuentas;
    }

    /**
     * Metodo equals de la clase cliente
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(cedula, cliente.cedula) && Objects.equals(direccion, cliente.direccion) && Objects.equals(Cuentas, cliente.Cuentas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cedula, direccion, Cuentas);
    }

    /**
     * Metodo toString de la clase cliente
     * @return
     */
    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion +
                '\n';
    }
}
