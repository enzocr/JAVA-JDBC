/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.ProfesorDao;
import java.util.List;
import negocio.clases.Profesor;

/**
 *
 * @author enzoq
 */
public class ProfesorBo {

    private ProfesorDao dao;

    public ProfesorBo() {
        this.dao = new ProfesorDao();
    }

    public ProfesorDao getDao() {
        return dao;
    }

    public void setDao(ProfesorDao dao) {
        this.dao = dao;
    }

    public int insert(Profesor p) {
        p.setSalario(p.getSalario() + 10000);
        return getDao().insert(p);
    }

    public List<Profesor> getAll() {
        return getDao().getAllProfessors();
    }

    public int delete(Profesor p) {
        return getDao().delete(p);
    }

    public int update(Profesor p) {
        return getDao().update(p);
    }

    public List<Profesor> getByName(String name) {
       return getDao().getByName(name);
    }

    public Profesor getById(int cedula) {
        return getDao().getById(cedula);
    }
}
