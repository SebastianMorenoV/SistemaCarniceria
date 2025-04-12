/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FactoryDAO;

import DAO.*;
import interfaces.*;

/**
 *
 * @author HP
 */
    
public interface ICreadorDAO  {
    public IProductoVentaDAO crearProductoVentaDAO();
    public IVentaDAO crearVentaDAO();
    public IEmpleadoDAO crearEmpleadoDAO();
}
