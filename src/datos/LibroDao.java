/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import negocio.clases.Libro;

/**
 *
 * @author enzoq
 */
public class LibroDao {

    private Conexion conn;
    private PreparedStatement sentence;

    public LibroDao() {
        this.conn = new Conexion();
        this.sentence = null;
    }

    public int insert(Libro lb) {
        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement("insert into bibliotecaicai.libro values(?, ?, ?, ?, ?)"));
                getSentence().setInt(1, lb.getCodigo());
                getSentence().setString(2, lb.getNombre());
                getSentence().setString(3, lb.getAutor());
                getSentence().setInt(4, lb.getAno());
                getSentence().setDouble(5, lb.getPrecio());
                getSentence().executeUpdate();
                getConn().disconnect();

                return 0;

            } else {
                return 1;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (sqle.getSQLState().startsWith("23")) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public List<Libro> getAllLibros() {
        try {
            if (getConn().conectarse()) {
                setSentence(conn.getConn().prepareStatement("select * from bibliotecaicai.libro"));
                List<Libro> all = new ArrayList<>();
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {

                    Libro lb = new Libro();
                    lb.setCodigo(result.getInt(1));
                    lb.setNombre(result.getString("nombre"));
                    lb.setAutor(result.getString("autor"));
                    lb.setAno(result.getInt(4));
                    lb.setPrecio(result.getDouble(5));

                    all.add(lb);
                }
                getConn().disconnect();
                return all;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }

    public PreparedStatement getSentence() {
        return sentence;
    }

    public void setSentence(PreparedStatement sentence) {
        this.sentence = sentence;
    }

    public int update(Libro lb) {
        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement(""
                        + "UPDATE bibliotecaicai.libro "
                        + "SET nombre = ?, autor = ?, ano = ?, precio = ? "
                        + "WHERE codigo = ?"));

                getSentence().setString(1, lb.getNombre());
                getSentence().setString(2, lb.getAutor());
                getSentence().setInt(3, lb.getAno());
                getSentence().setDouble(4, lb.getPrecio());
                getSentence().setInt(5, lb.getCodigo());
                getSentence().executeUpdate();
                getConn().disconnect();

                return 0;

            } else {
                return 1;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            if (sqle.getSQLState().startsWith("23")) {
                return 2;
            } else {
                return 3;
            }
        }

    }

    public int delete(Libro lb) {

        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement("DELETE FROM bibliotecaicai.libro WHERE codigo= ?"));
                getSentence().setInt(1, lb.getCodigo());
                int result = getSentence().executeUpdate();
                getConn().disconnect();
                if (result == 0) {
                    return 0;
                } else {
                    return 1;
                }

            } else {
                return 2;
            }
        } catch (SQLIntegrityConstraintViolationException sql) {
            sql.printStackTrace();
            return 4;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return 3;
        }
    }

    public List<Libro> getByName(String name) {
        try {
            if (getConn().conectarse()) {

                setSentence(conn.getConn().prepareStatement("SELECT *"
                        + " FROM bibliotecaicai.libro "
                        + "WHERE nombre like ?"));
                this.sentence.setString(1, "%" + name + "%");
                List<Libro> all = new ArrayList<>();
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {

                    Libro l = new Libro(result.getInt(1),
                            result.getString("nombre"),
                            result.getString("autor"),
                            result.getInt(4),
                            result.getDouble(5));

                    all.add(l);
                }
                getConn().disconnect();
                return all;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Libro getById(int codigo) {
        try {

            Libro lb = new Libro();
            if (getConn().conectarse()) {

                setSentence(conn.getConn().prepareStatement("SELECT *"
                        + " FROM bibliotecaicai.libro "
                        + "WHERE codigo = ?"));
                sentence.setInt(1, codigo);
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {
                    lb.setCodigo(result.getInt(1));
                    lb.setNombre(result.getString("nombre"));
                    lb.setAutor(result.getString("autor"));
                    lb.setAno(result.getInt(4));
                    lb.setPrecio(result.getDouble(5));
                }
                getConn().disconnect();
                if (lb == null) {
                    return null;
                } else {
                    return lb;
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
