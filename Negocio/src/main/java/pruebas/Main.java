/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import ADAPTER.productoVenta.IAdaptadorProductoVenta;
import ADAPTER.productoVenta.adaptadorProductoVenta;
import BO.EmpleadoBO;
import BO.ProductoBO;
import BO.VentaBO;
import DTOs.EmpleadoCargadoDTO;
import DTOs.NuevoProductoVentaDTO;
import DTOs.ProductoCargadoDTO;
import DTOs.ProductosVentaDTO;
import DTOs.VentaDTO;
import Entidades.Producto;
import Entidades.ProductoVenta;
import Exception.NegocioException;
import Exception.PersistenciaException;
import fabrica.CreadorDAO;
import fabrica.ICreadorDAO;
import java.util.ArrayList;
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

    /**
     * Pruebas para la capa BO.
     */
   
        IAdaptadorProductoVenta adapterVenta;

        List<ProductoVenta> listaProductos1 = new ArrayList<>();
        Producto producto1 = new Producto(
            "Coca-Cola",
            "Botella de 1.5L retornable",
            25.0,
            false,
            1.5,
            "Bebidas"
        );

        Producto producto2 = new Producto(
            "Carne de Res",
            "Corte de diezmillo calidad premium",
            110.0,
            true,
            1.0,
            "Carnes"
        );

        listaProductos1.add(new ProductoVenta(producto1, 4, 15, 20));
        listaProductos1.add(new ProductoVenta(producto2, 4, 10, 15));

        adapterVenta = new adaptadorProductoVenta();
        List<NuevoProductoVentaDTO> listaProductos1DTO = adapterVenta.convertirListaADTO(listaProductos1);
        System.out.println("Prueba listaDTO a lista entidades"); 
        for (NuevoProductoVentaDTO dto : listaProductos1DTO) {
            System.out.println(dto.getProducto().getNombre());
            System.out.println(dto.getCantidad());
            System.out.println(dto.getImporte());                    
            
        }
        System.out.println("----------------");
        System.out.println("Prueba lista entidades a listaDTO"); 
        List<NuevoProductoVentaDTO> listaProductos2 = new ArrayList<>();
        ProductoCargadoDTO dto1 = new ProductoCargadoDTO(
        1001L,
        "Coca-Cola",
        "Botella de 1.5L retornable",
        "Bebidas",
        1.5,
        25.0,
        false
         );

    ProductoCargadoDTO dto2 = new ProductoCargadoDTO(
        1002L,
        "Carne de Res",
        "Corte de diezmillo calidad premium",
        "Carnes",
        1.0,
        110.0,
        true
        );

    NuevoProductoVentaDTO nuevoProductoVenta1 = new NuevoProductoVentaDTO(
    dto1,
    2,              // cantidad
    25.0,           // precio unitario
    50.0            // importe (2 * 25.0)
);

NuevoProductoVentaDTO nuevoProductoVenta2 = new NuevoProductoVentaDTO(
    dto2,
    1.5,            // cantidad
    110.0,          // precio unitario
    165.0           // importe (1.5 * 110.0)
);
    listaProductos2.add(nuevoProductoVenta1);
    listaProductos2.add(nuevoProductoVenta2);
    List<ProductoVenta> listaProductos2DTO = adapterVenta.convertirListaDTOAEntidad(listaProductos2);
    for (ProductoVenta dto : listaProductos2DTO) {
            System.out.println(dto.getProducto().getNombre());
            System.out.println(dto.getCantidad());
            System.out.println(dto.getImporte());                    
            
        }
    }
    //        // AQUI ESTOY PROBANDO LA FABRICA.
//        ICreadorDAO creador = new CreadorDAO();
//        EmpleadoBO empleadoBO = new EmpleadoBO(creador);
//        EmpleadoCargadoDTO empleadoConsultado = empleadoBO.consultarEmpleado();
//        System.out.println("Empleado consultado : " + empleadoConsultado);
//        
//        VentaBO ventaBO = new VentaBO(creador);
//        
//        VentaDTO ventaDTO = new VentaDTO();
//        ventaDTO.setTotal(1);
//        VentaDTO ventaPersisitida = ventaBO.registrarVenta(ventaDTO);
//        System.out.println("Venta persistida con datos mock." + ventaPersisitida);
//        
//        
//         ProductosVentaDTO listaProductos1Venta = ventaBO.obtenerProductosVenta();
//         System.out.println("Productos venta desde persistencia: " + listaProductos1Venta);
//         
//         ProductoBO productoBO = new ProductoBO(creador);
//         List<ProductoCargadoDTO> listaProductosConsultado = productoBO.cargarProductos();
//         for (ProductoCargadoDTO productoCargadoDTO : listaProductosConsultado) {
//             System.out.println(productoCargadoDTO);
//        }
//         
//        ///////////////////////////////////////////
//        System.err.println("Prueba Adapter");
//        empleadoBO.registrarEmpleado(empleadoConsultado);
//          
    
    }



