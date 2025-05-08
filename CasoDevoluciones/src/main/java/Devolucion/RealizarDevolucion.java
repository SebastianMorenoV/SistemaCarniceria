package Devolucion;

import DTOs.Devolucion.CrearDevolucionDTO;
import DTOs.Devolucion.DevolucionDTO;
import Exception.DevolucionException;
import Interfaces.IDevolucionBO;
import Interfaces.IVentaBO;
import java.util.List;


/**
 *
 * @author Sebastian Moreno
 */
public class RealizarDevolucion implements IRealizarDevolucion {
    private IDevolucionBO devolucionBO;
    private IVentaBO ventaBO;
        
    
    @Override
    public DevolucionDTO registrarDevolucion(CrearDevolucionDTO devolucionDTO) throws DevolucionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DevolucionDTO> consultarDevoluciones() throws DevolucionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DevolucionDTO> consultarDevolucionesPorFiltro(CrearDevolucionDTO devolucionDTO) throws DevolucionException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarTicket(String ticket) {
       //logica para validar el ticket
       if(ticket != null){
           System.out.println("Ticket Validado.");
           return true;
       }
       
       return false;
    }

    @Override
    public void validarProductoRepetido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarCamposLlenos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void calcularResumen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validarValoresCampos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
