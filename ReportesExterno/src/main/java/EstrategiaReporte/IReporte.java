/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EstrategiaReporte;

import DTOs.VentaDTO;

/**
 *
 * @author Sebastian Moreno
 */
public interface IReporte {
     public byte[] generarPDFVenta(VentaDTO venta);
}
