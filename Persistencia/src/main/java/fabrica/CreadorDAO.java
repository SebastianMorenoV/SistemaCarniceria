/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabrica;

import DAOS.*;
import Interfaces.*;

/**
 * Este metodo se encarga de crear objetos DAO
 * 
 * 
 * @author Admin
 */
public class CreadorDAO implements ICreadorDAO{

    //Crea una instancia de IVentaDAO basicamente
    @Override
    public IVentaDAO crearVentaDAO() {
        return VentaDAO.obtenerInstancia(); // llama al singleton
    }

    //Aca abajo pues iran igual para todos
}
