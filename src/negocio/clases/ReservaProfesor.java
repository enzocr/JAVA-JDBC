/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.clases;

import java.util.Date;


/**
 *
 * @author enzoq
 */
public class ReservaProfesor {
    private Integer cedulaProfe;
    private Integer codigoLibro;
    private Date fecha;
    private Integer diasPrestamo;
    
    public ReservaProfesor(){
        
    }

    public ReservaProfesor(Integer cedulaProfe, Integer codigoLibro, Date fecha, Integer diasPrestamo) {
        this.cedulaProfe = cedulaProfe;
        this.codigoLibro = codigoLibro;
        this.fecha = fecha;
        this.diasPrestamo = diasPrestamo;
    }

    public Integer getCedulaProfe() {
        return cedulaProfe;
    }

    public void setCedulaProfe(Integer cedulaProfe) {
        this.cedulaProfe = cedulaProfe;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(Integer diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }
    
    
}
