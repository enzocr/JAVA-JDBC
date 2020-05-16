/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.EstudianteDao;
import java.util.List;
import negocio.clases.Estudiante;

/**
 *
 * @author enzoq
 */
public class EstudianteBo {

    private EstudianteDao dao;

    public EstudianteBo() {
        this.dao = new EstudianteDao();
    }

    public int insert(Estudiante est) {
        est.setCarnet(2020 + est.getCedula());
        return getDao().insert(est);
    }

    public List<Estudiante> getAll() {
        return getDao().getAllEstudiante();
    }

    public int delete(Estudiante est) {
        return getDao().delete(est);
    }

    public EstudianteDao getDao() {
        return dao;
    }

    public void setDao(EstudianteDao dao) {
        this.dao = dao;
    }

    public Estudiante getById(int cedula) {
        return getDao().getById(cedula);
    }

    public List<Estudiante> getByName(String name) {
        return getDao().getByName(name);
    }

    public int update(Estudiante est) {
        return getDao().updateEstudiante(est);

    }

}
