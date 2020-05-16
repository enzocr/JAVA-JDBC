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
import negocio.clases.Estudiante;

/**
 *
 * @author enzoq
 */
public class EstudianteDao {

    private Conexion conn;
    private PreparedStatement sentence;

    public EstudianteDao() {
        this.conn = new Conexion();
        this.sentence = null;
    }

    public int insert(Estudiante est) {
        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement("insert into bibliotecaicai.estudiante values(?, ?, ?, ?)"));
                getSentence().setInt(1, est.getCedula());
                getSentence().setString(2, est.getNombre());
                getSentence().setString(3, est.getCarrera());
                getSentence().setInt(4, est.getCarnet());
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

    public List<Estudiante> getAllEstudiante() {
        try {
            if (getConn().conectarse()) {
                setSentence(conn.getConn().prepareStatement("select * from bibliotecaicai.estudiante"));
                List<Estudiante> all = new ArrayList<>();
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {

                    Estudiante est = new Estudiante();
                    est.setCedula(result.getInt(1));
                    est.setNombre(result.getString("nombre"));
                    est.setCarrera(result.getString("carrera"));
                    est.setCarnet(result.getInt(4));

                    all.add(est);
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

    public int updateEstudiante(Estudiante est) {
        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().
                        prepareStatement("  Update estudiante SET cedula= "
                                + "'" + est.getCedula() + "', nombre= '" + est.getNombre() + "', "
                                + "carrera= '" + est.getCarrera()+ "', carnet = '" + est.getCarnet()
                                + "' WHERE cedula = '" + est.getCedula() + "'"));

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

    public int delete(Estudiante est) {

        try {
            if (conn.conectarse()) {

                setSentence(conn.getConn().prepareStatement("DELETE FROM bibliotecaicai.estudiante WHERE cedula= ?"));
                getSentence().setInt(1, est.getCedula());
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

    public List<Estudiante> getByName(String name) {
        try {
            if (getConn().conectarse()) {

                setSentence(conn.getConn().prepareStatement("SELECT *"
                        + " FROM bibliotecaicai.estudiante "
                        + "WHERE nombre like ?"));
                this.sentence.setString(1, "%" + name + "%");
                List<Estudiante> all = new ArrayList<>();
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {

                    Estudiante est = new Estudiante();
                    est.setCedula(result.getInt(1));
                    est.setNombre(result.getString("nombre"));
                    est.setCarrera(result.getString("carrera"));
                    est.setCarnet(result.getInt(4));
                    all.add(est);
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

    public Estudiante getById(int cedula) {
        try {

            Estudiante est = new Estudiante();
            if (getConn().conectarse()) {

                setSentence(conn.getConn().prepareStatement("SELECT *"
                        + " FROM bibliotecaicai.estudiante "
                        + "WHERE cedula = ?"));
                sentence.setInt(1, cedula);
                ResultSet result = getSentence().executeQuery();
                while (result.next()) {
                    est.setCedula(result.getInt(1));
                    est.setNombre(result.getString("nombre"));
                    est.setCarrera(result.getString("carrera"));
                    est.setCarnet(result.getInt(4));

                }
                getConn().disconnect();
                if (est == null) {
                    return null;
                } else {
                    return est;
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
