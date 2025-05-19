/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Exception.PersistenciaException;
import Interfaces.IEntradaDAO;
import entidades.Entrada;
import entidades.Producto;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO implements IEntradaDAO{
    private List<Entrada> listaEntradas = new ArrayList<>();

    private static EntradaDAO instanceEntradaDAO;

    public EntradaDAO(){

    }
    public static EntradaDAO getInstanciaDAO(){
        if(instanceEntradaDAO == null){
            instanceEntradaDAO = new EntradaDAO();
        }
        return instanceEntradaDAO;
    }

    @Override
    public Entrada registrarEntrada(Entrada entrada) throws PersistenciaException {
        listaEntradas.add(entrada);
        return entrada;
        //tengo que persistir el producto

    }

    @Override
    public List<Producto> ConsultarProductos() throws PersistenciaException {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(1, "Filete Pollo", "pollo"));
        listaProductos.add(new Producto(1, "Nuggets Pollo", "pz"));
        listaProductos.add(new Producto(1, "Carne para asar", "Selecta"));


//        listaProductos.add(new ProductoCargadoDTO((long)1,"Pierna de cerdo", "Pierna sin hueso, fresca", "Cerdo", 1.0, 40.00, true));
//        listaProductos.add(new ProductoCargadoDTO((long)2, "Carne molida", "80% carne, 20% grasa", "Res", 1.0, 45.00, true));
//        listaProductos.add(new ProductoCargadoDTO((long)3, "Costilla res", "Costilla para asar con hueso", "Res", 1.0, 62.25, true));
//        listaProductos.add(new ProductoCargadoDTO((long)4, "Chuleta ahumada", "Chuleta lista para freír", "Cerdo", 1.0, 40.00, true));
//        listaProductos.add(new ProductoCargadoDTO((long)5, "Filete de pollo", "Pechuga sin piel ni hueso", "Pollo", 1.0, 50.00, true));
        return listaProductos;
    }

   
}