/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.clases;

/**
 *
 * @author enzoq
 */
public class Profesor {

    private Integer cedula;
    private String nombre;
    private Double salario;
    private String escuela;

    public Profesor() {

    }

    public Profesor(Integer cedula, String nombre, Double salario, String escuela) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.salario = salario;
        this.escuela = escuela;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

}
