/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.ReservaProfesorDao;
import negocio.clases.ReservaProfesor;

/**
 *
 * @author enzoq
 */
public class ReservaProfesorBo {

    ReservaProfesorDao dao;

    public ReservaProfesorBo() {
        this.dao = new ReservaProfesorDao();
    }

    public int insert(ReservaProfesor rp) {
        return getDao().insert(rp);
    }

    public ReservaProfesorDao getDao() {
        return dao;
    }

    public void setDao(ReservaProfesorDao dao) {
        this.dao = dao;
    }

}
