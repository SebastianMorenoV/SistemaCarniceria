/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstrategiaReporte;

import DTOs.GastoDTO;
import DTOs.MetodoPagoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Sebastian Moreno
 */
public class ReporteService {

    public byte[] generarPDFVenta(VentaDTO venta) {
        try {
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, baos);

            doc.open();

            // Título
            Font tituloFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Ticket de Venta", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);
            doc.add(Chunk.NEWLINE);

            // Información general
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            doc.add(new Paragraph("Fecha y Hora: " + venta.getFechaHora().format(formatter)));
            doc.add(new Paragraph("Empleado: " + venta.getEmpleado().getNombre()));
            doc.add(new Paragraph("Identificador de ticket: " + venta.getId()));
            doc.add(Chunk.NEWLINE);

            // Tabla de productos
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{4, 2, 2, 2});

            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio Unitario");
            tabla.addCell("Importe");

            for (ProductoVentaDTO p : venta.getListadoProductosVenta()) {
                tabla.addCell(p.getProducto().getNombre());
                tabla.addCell(String.format("%.2f", p.getCantidad()));
                tabla.addCell(String.format("$ %.2f", p.getPrecioUnitario()));
                tabla.addCell(String.format("$ %.2f", p.getImporte()));
            }

            doc.add(tabla);
            doc.add(Chunk.NEWLINE);

            // Totales
            doc.add(new Paragraph("Subtotal: $" + String.format("%.2f", venta.getSubtotal())));
            doc.add(new Paragraph("IVA: $" + String.format("%.2f", venta.getIva())));
            doc.add(new Paragraph("Total: $" + String.format("%.2f", venta.getTotal())));
            doc.add(Chunk.NEWLINE);

            // Información del pago
            if (venta.getPago() != null && venta.getPago().getMetodoPago() != null) {
                MetodoPagoDTO metodo = venta.getPago().getMetodoPago();
                doc.add(new Paragraph("Método de pago:"));

                if (metodo.getNuevoEfectivo() != null) {
                    doc.add(new Paragraph("- Efectivo"));
                    doc.add(new Paragraph("  Monto recibido: $" + String.format("%.2f", venta.getPago().getMonto())));
                    double cambio = venta.getPago().getMetodoPago().getNuevoEfectivo().getPagoCon();
                    doc.add(new Paragraph("  Cambio: $" + String.format("%.2f", cambio)));
                } else if (metodo.getNuevaTarjeta() != null) {
                    doc.add(new Paragraph("- Tarjeta"));
                    doc.add(new Paragraph("  Monto cargado: $" + String.format("%.2f", venta.getPago().getMonto())));
                }
            }

            doc.close();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF de la venta", e);
        }
    }

    public byte[] generarPDFGasto(List<GastoDTO> gastos) {
        try {
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, baos);

            doc.open();

            // Título
            Font tituloFont = new Font(Font.HELVETICA, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Gastos", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);
            doc.add(Chunk.NEWLINE);

            // Tabla de resumen de gastos
            PdfPTable tabla = new PdfPTable(6); // columnas: Folio, Fecha, Categoría, Proveedor, Monto, Método
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{2, 2, 2, 3, 2, 2});

            tabla.addCell("Folio");
            tabla.addCell("Fecha");
            tabla.addCell("Categoría");
            tabla.addCell("Proveedor");
            tabla.addCell("Monto");
            tabla.addCell("Método");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            double totalGastos = 0.0;

            for (GastoDTO gasto : gastos) {
                tabla.addCell(gasto.getFolio());
                tabla.addCell(gasto.getFechaGasto().format(formatter));
                tabla.addCell(gasto.getCategoria());
                tabla.addCell(gasto.getProveedor() != null ? gasto.getProveedor().getNombre() : "No especificado");
                tabla.addCell("$ " + String.format("%.2f", gasto.getMontoGasto()));
                tabla.addCell(gasto.getMetodoPago());

                totalGastos += gasto.getMontoGasto();
            }

            doc.add(tabla);
            doc.add(Chunk.NEWLINE);

            // Total de gastos
            Font boldFont = new Font(Font.HELVETICA, 12, Font.BOLD);
            Paragraph total = new Paragraph("Total de gastos: $ " + String.format("%.2f", totalGastos), boldFont);
            total.setAlignment(Element.ALIGN_RIGHT);
            doc.add(total);

            doc.close();
            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error al generar el PDF del reporte de gastos", e);
        }
    }

}
