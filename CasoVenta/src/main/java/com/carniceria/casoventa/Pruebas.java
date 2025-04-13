/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.carniceria.casoventa;

import DTOs.*;
import Implementacion.RealizarVenta;
/**
 *
 * @author Lap-064
 */
public class Pruebas {

    public static void main(String[] args) {
        RealizarVenta r = new RealizarVenta();
        
        //Prueba de que el patron strategy funcione.
        //Se espera que al correr imprima mensaje de depuracion de flujo efectivo.
        MetodoPagoDTO efectivo = new MetodoPagoDTO(new NuevoEfectivoDTO(200, 500));
        r.procesarPago(efectivo);
        
         //Se espera que al correr imprima mensaje de depuracion de flujo tarjeta.
        MetodoPagoDTO tarjeta = new MetodoPagoDTO(new NuevaTarjetaDTO("Juanito", "1234", "02/23", 123, 500));
        r.procesarPago(tarjeta);
    }
}
