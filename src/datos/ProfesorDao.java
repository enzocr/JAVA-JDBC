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
import negocio.clases.Profesor;

/**
 *
 * @author enzoq
 */
public class ProfesorDao {

    private Conexion conn;
    private PreparedStatement sentence;

    public ProfesorDao() {
        this.conn = new Conexion();
        this.sentence = null;
    }

    public int insert(Profesor p) {
        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement("insert into bibliotecaicai.profesor values(?, ?, ?, ?)"));
                getSentence().setInt(1, p.getCedula());
                getSentence().setString(2, p.getNombre());
                getSentence().setDouble(3, p.getSalario());
                getSentence().setString(4, p.getEscuela());
                getSentence().executeUpdate();
                getConn().disconnect();

                return 0;

            } else {
                return 1;
            }
        } catch (SQLException sqle) {
            if (sqle.getSQLState().startsWith("23")) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public List<Profesor> getAllProfessors() {
        try {
            if (getConn().conectarse()) {
                setSentence(conn.getConn().prepareStatement("select * from bibliotecaicai.profesor"));
                List<Profesor> all = new ArrayList<>();
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {
                    Profesor p = new Profesor();
                    p.setCedula(result.getInt(1));
                    p.setNombre(result.getString("nombre"));
                    p.setSalario(result.getDouble(3));
                    p.setEscuela(result.getString("escuela"));
                    all.add(p);
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

    public int delete(Profesor p) {

        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement("DELETE FROM bibliotecaicai.profesor WHERE cedula= ?"));
                getSentence().setInt(1, p.getCedula());
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

    public int update(Profesor p) {

        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement(""
                        + "UPDATE bibliotecaicai.profesor "
                        + "SET nombre = ?, salario = ?, escuela = ? "
                        + "WHERE cedula = ?"));
                getSentence().setString(1, p.getNombre());
                getSentence().setDouble(2, p.getSalario());
                getSentence().setString(3, p.getEscuela());
                getSentence().setInt(4, p.getCedula());
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

    public List<Profesor> getByName(String name) {
        try {
            if (getConn().conectarse()) {

                setSentence(conn.getConn().prepareStatement("SELECT *"
                        + " FROM bibliotecaicai.profesor "
                        + "WHERE nombre like ?"));
                this.sentence.setString(1, "%" + name + "%");
                List<Profesor> all = new ArrayList<>();
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {
                    Profesor p = new Profesor();
                    p.setCedula(result.getInt(1));
                    p.setNombre(result.getString("nombre"));
                    p.setSalario(result.getDouble(3));
                    p.setEscuela(result.getString("escuela"));
                    all.add(p);
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

    public Profesor getById(int cedula) {
        try {

            Profesor p = new Profesor();
            if (getConn().conectarse()) {

                setSentence(conn.getConn().prepareStatement("SELECT *"
                        + " FROM bibliotecaicai.profesor "
                        + "WHERE cedula = ?"));
                sentence.setInt(1, cedula);
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {
                    p.setCedula(result.getInt(1));
                    p.setNombre(result.getString("nombre"));
                    p.setSalario(result.getDouble(3));
                    p.setEscuela(result.getString("escuela"));

                }
                getConn().disconnect();
                if (p == null) {
                    return null;
                } else {
                    return p;
                }
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

}
