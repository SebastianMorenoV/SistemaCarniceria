/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DAOS.PagoDAO;
import Entidades.Pago;
import Exception.PersistenciaException;

/**
 *
 * @author Sebastian Moreno
 */
public interface IPagoDAO {
     static IPagoDAO obtenerInstanciaDAO() {
        return new PagoDAO(); // o podrías usar singleton aquí
    }
    public Pago registrarPago(Pago pago) throws PersistenciaException;

    public Pago consultarPagoPorId(Long id) throws PersistenciaException;
}
