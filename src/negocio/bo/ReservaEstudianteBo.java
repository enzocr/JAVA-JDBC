/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.ReservaEstudianteDao;
import datos.ReservaProfesorDao;
import negocio.clases.ReservaEstudiante;

/**
 *
 * @author enzoq
 */
public class ReservaEstudianteBo {

    ReservaEstudianteDao dao;

    public ReservaEstudianteBo() {
        this.dao = new ReservaEstudianteDao();
    }

    public int insert(ReservaEstudiante re) {
        return getDao().insert(re);
    }

    public ReservaEstudianteDao getDao() {
        return dao;
    }

    public void setDao(ReservaEstudianteDao dao) {
        this.dao = dao;
    }

}
