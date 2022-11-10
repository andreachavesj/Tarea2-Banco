package Controlador;

import Modelo.Cliente;

import java.util.ArrayList;

public class ClienteControlador {
    public static ArrayList<Cliente> conjuntoClientes=new ArrayList<>();
    public static ArrayList<String> conjuntoCedulas=new ArrayList<>();
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


