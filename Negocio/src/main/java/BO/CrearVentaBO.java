/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Adapters.adaptadorCrearVenta;
import DTOs.CrearVentaDTO;
import Exception.NegocioException;
import IAdapters.IAdaptadorCrearVenta;
import Interfaces.ICrearVentaBO;
import Interfaces.ICrearVentaDAO;
import fabrica.ICreadorDAO;

/**
 *
 * @author HP
 */
public class CrearVentaBO implements ICrearVentaBO {
    public IAdaptadorCrearVenta adaptador;
    private final ICrearVentaDAO crearVentaDAO;
    
    public CrearVentaBO(ICreadorDAO fabrica) {
        this.crearVentaDAO = fabrica.CrearVentaDAO();
        this.adaptador =  new adaptadorCrearVenta();
    }
    @Override
    public CrearVentaDTO crearVentaDTO() throws NegocioException {
        CrearVentaDTO crearventaDTO = new CrearVentaDTO();
        return crearventaDTO;
    }

    @Override
    public CrearVentaDTO registrarCrearVentaDTO(CrearVentaDTO creadorVenta) throws NegocioException {
        try{
        CrearVentaDTO crearVentaDTO = new CrearVentaDTO();
        crearVentaDTO.setEmpleado(creadorVenta.getEmpleado());
        crearVentaDTO.setFechaHora(creadorVenta.getFechaHora());
        crearVentaDTO.setIva(creadorVenta.getIva());
        crearVentaDTO.setListadoProductosVenta(creadorVenta.getListadoProductosVenta());
        crearVentaDTO.setMetodoPago(creadorVenta.getMetodoPago());
        crearVentaDTO.setSubtotal(creadorVenta.getSubtotal());
        crearVentaDTO.setTotal(creadorVenta.getTotal());
        return crearVentaDTO;
        }catch(Exception e){
            throw new NegocioException("Error en RegistrarCrearVentaDTO:    " + e);
        }
    }

    
}
