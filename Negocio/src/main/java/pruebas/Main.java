/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import BO.EmpleadoBO;
import BO.ProductoBO;
import BO.VentaBO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductosVentaDTO;
import DTOs.VentaDTO;
import Exception.NegocioException;
import Exception.PersistenciaException;
import fabrica.CreadorDAO;
import fabrica.ICreadorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class Main {

    /**
     * Pruebas para la capa BO.
     */
    public static void main(String[] args) throws NegocioException {

        // AQUI ESTOY PROBANDO LA FABRICA.
        ICreadorDAO creador = new CreadorDAO();
        
        EmpleadoBO empleadoBO = new EmpleadoBO(creador);
        EmpleadoCargadoDTO empleadoConsultado = empleadoBO.consultarEmpleado();
        System.out.println("Empleado consultado : " + empleadoConsultado);
        
        VentaBO ventaBO = new VentaBO(creador);
        
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setTotal(1);
        VentaDTO ventaPersisitida = ventaBO.registrarVenta(ventaDTO);
        System.out.println("Venta persistida con datos mock." + ventaPersisitida);
        
        
         ProductosVentaDTO productosVenta = ventaBO.obtenerProductosVenta();
         System.out.println("Productos venta desde persistencia: " + productosVenta);
         
         ProductoBO productoBO = new ProductoBO(creador);
         List<ProductoCargadoDTO> listaProductosConsultado = productoBO.cargarProductos();
         for (ProductoCargadoDTO productoCargadoDTO : listaProductosConsultado) {
             System.out.println(productoCargadoDTO);
        }
         
        ///////////////////////////////////////////
    }

}
