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
public class ReservaEstudiante {

    private Integer cedulaEstudiante;
    private Integer codigoLibro;
    private Date fecha;
    private Integer diasPrestamo;

    public ReservaEstudiante() {

    }

    public ReservaEstudiante(Integer cedulaEstudiante, Integer codigoLibro, Date fecha, Integer diasPrestamo) {
        this.cedulaEstudiante = cedulaEstudiante;
        this.codigoLibro = codigoLibro;
        this.fecha = fecha;
        this.diasPrestamo = diasPrestamo;
    }

    public Integer getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(Integer cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
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
