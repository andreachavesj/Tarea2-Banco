package Controlador;

import Modelo.Cliente;

import java.util.ArrayList;

public class ClienteControlador {

    /**
     * Creacion de un arrayList que guardara de clientes que contendra todos los clientes creados
     *
     */
    public static ArrayList<Cliente> conjuntoClientes=new ArrayList<>();

    /**
     * Creacion de un arrayList que guardara todas las cedulas para validacion de que no se repita
     */
    public static ArrayList<String> conjuntoCedulas=new ArrayList<>();

    /**
     *  Funcion que permite registrar a un cliente nuevo y verificar que su numero de cedula no haya sido registrado anteriormente
     * @param nombre
     * @param cedula
     * @param direccion
     * @return boolean
     */
    public static boolean  registrarCliente(String nombre, String cedula, String direccion) {
        boolean cedulaRepetida=false;
        for (int i=0;i<conjuntoCedulas.size();i++){
            if (cedula.equals(conjuntoCedulas.get(i))){
                cedulaRepetida=true;
                break;
            }
        }
        if(cedulaRepetida==false){
            Cliente cliente = new Cliente(nombre, cedula, direccion);
            conjuntoClientes.add(cliente);
            conjuntoCedulas.add(cliente.getCedula());
            return true;
        }else{
            return false;
        }
    }

}


