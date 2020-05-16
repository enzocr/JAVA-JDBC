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
/*
 `cedula` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `carrera` varchar(45) DEFAULT NULL,
  `carnet` int(11) DEFAULT NULL,
 */
public class Estudiante {

    private int cedula;
    private String nombre;
    private String carrera;
    private int carnet;

    public Estudiante() {

    }

    public Estudiante(int cedula, String nombre, String carrera) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

}
