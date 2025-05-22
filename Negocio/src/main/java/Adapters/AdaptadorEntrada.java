/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import DTOs.EmpleadoCargadoDTO;
import DTOs.EntradaDTO;
import DTOs.ProductoEntradaDTO;
import DTOs.ProveedorDTO;
import IAdapters.IAdaptadorEntrada;
import entidades.Empleado;
import entidades.Entrada;
import entidades.ProductoEntrada;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AdaptadorEntrada implements IAdaptadorEntrada {

    @Override
    public EntradaDTO convertirADTO(Entrada entrada) {
        List<ProductoEntradaDTO> productosEntradaDTO = new ArrayList();
        
        AdaptadorEmpleado empleado = new AdaptadorEmpleado();
        
        EmpleadoCargadoDTO empleadoDTO = empleado.convertirADTO(entrada.getEmpleado());
        
        AdaptadorProveedor proveedor = new AdaptadorProveedor();
        ProveedorDTO proveedorDTO = proveedor.ConvertirADTO(entrada.getProveedor());
        System.out.println("CONVERTIR DTO ADAPTADOR ENTRADA " + entrada.getListaProductosEntrada());
        
        AdaptadorProductoEntrada productosEntrada = new AdaptadorProductoEntrada();
        
        for (ProductoEntrada produtoEntrada : entrada.getListaProductosEntrada()) {
            productosEntradaDTO.add(productosEntrada.convertirADTO(produtoEntrada));
        }

        EntradaDTO entradaDTO = new EntradaDTO();
        entradaDTO.setId(entrada.getId());
        entradaDTO.setFechaHora(entrada.getFechaHora());
        entradaDTO.setEmpleado(empleadoDTO);
        entradaDTO.setListaProductosEntrada(productosEntradaDTO);
        entradaDTO.setProveedor(proveedorDTO);
        return entradaDTO;
    }

    @Override
    public Entrada convertirAEntidad(EntradaDTO entrada) {
        //lista de ProductosEntradaEntidad
        List<ProductoEntrada> productosEntradaEntidad = new ArrayList();
        
        AdaptadorEmpleado empleado = new AdaptadorEmpleado();
        Empleado empleadoEntidad = empleado.convertirAEntidad(entrada.getEmpleado());
        
        AdaptadorProveedor proveedor = new AdaptadorProveedor();
        Proveedor proveedorEntidad = proveedor.ConvertirAEntidadEntrada(entrada.getProveedor());  
        
        AdaptadorProductoEntrada productosEntrada = new AdaptadorProductoEntrada();
        for (ProductoEntradaDTO produtoEntradaDTO : entrada.getListaProductosEntrada()) {
            productosEntradaEntidad.add(productosEntrada.convertirAEntidad(produtoEntradaDTO));
        }

        Entrada entradaEntidad = new Entrada();
        entradaEntidad.setId(entrada.getId());
        entradaEntidad.setFechaHora(entrada.getFechaHora());
        entradaEntidad.setEmpleado(empleadoEntidad);
        entradaEntidad.setProveedor(proveedorEntidad);
        entradaEntidad.setListaProductosEntrada(productosEntradaEntidad);
        entradaEntidad.setTotal(entrada.getTotal());
        entradaEntidad.setSubtotal(entrada.getSubtotal());
        return entradaEntidad;
    }

}
