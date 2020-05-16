/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.bo;

import datos.LibroDao;
import java.util.List;
import negocio.clases.Libro;

/**
 *
 * @author enzoq
 */
public class LibroBo {

    private LibroDao dao;

    public LibroBo() {
        this.dao = new LibroDao();
    }

    public int insert(Libro lb) {
        lb.setPrecio(lb.getPrecio() + (lb.getPrecio() * 0.13));
        return dao.insert(lb);
    }

    public List<Libro> getAll() {
        return dao.getAllLibros();
    }

    public LibroDao getDao() {
        return dao;
    }

    public void setDao(LibroDao dao) {
        this.dao = dao;
    }

    public int update(Libro lb) {
        return getDao().update(lb);

    }

    public int delete(Libro lb) {
        return getDao().delete(lb);
    }

    public Libro getById(int codigo) {
        return getDao().getById(codigo);

    }

    public List<Libro> getByName(String text) {
        return getDao().getByName(text);

    }

}
