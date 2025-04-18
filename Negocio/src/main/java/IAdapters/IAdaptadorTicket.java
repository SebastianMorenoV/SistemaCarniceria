/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IAdapters;

import DTOs.TicketDTO;
import entidades.Ticket;

/**
 *
 * @author HP
 */
public interface IAdaptadorTicket {
    public TicketDTO convertirTicketADTO(Ticket ticket);
    public Ticket convertirTicketAEntidad(TicketDTO ticketDTO);

}
