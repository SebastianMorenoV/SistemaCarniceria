/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapters;

import IAdapters.IAdaptadorTicket;
import IAdapters.IAdaptadorEmpleado;
import DTOs.EmpleadoCargadoDTO;
import DTOs.TicketDTO;
import entidades.Empleado;
import entidades.Ticket;

/**
 *
 * @author HP
 */
public class AdaptadorTicket implements IAdaptadorTicket {
    private IAdaptadorEmpleado adapter;

    @Override
    public TicketDTO convertirTicketADTO(Ticket ticket) {
      EmpleadoCargadoDTO  Empleado = adapter.convertirADTO(ticket.getCajero());
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setCajero(Empleado);
        ticketDTO.setIva(ticket.getIva());
        ticketDTO.setFechaHora(ticket.getFechaHora());
        // se ocupa otro mapper.
        //ventaDTO.setListadoProductosVenta(listadoProductosVenta);
        ticketDTO.setTotal(ticket.getTotal());
        ticketDTO.setSubtotal(ticket.getSubtotal());
        
        return ticketDTO;}

    @Override
    public Ticket convertirTicketAEntidad(TicketDTO ticketDTO) {
        Empleado empleado = adapter.convertirAEntidad(ticketDTO.getCajero());
        Ticket ticketEntidad = new Ticket();
        // se ocupa otro mapper.
        //ventaDTO.setListadoProductosVenta(listadoProductosVenta);
        ticketEntidad.setCajero(empleado);
        ticketEntidad.setIva(ticketDTO.getIva());
        ticketEntidad.setFechaHora(ticketDTO.getFechaHora());
        // se ocupa otro mapper.
        //ventaDTO.setListadoProductosVenta(listadoProductosVenta);
        ticketEntidad.setTotal(ticketDTO.getTotal());
        ticketEntidad.setSubtotal(ticketDTO.getSubtotal());
        return ticketEntidad;
    }
    

}
