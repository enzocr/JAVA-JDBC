
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import negocio.clases.ReservaEstudiante;
import negocio.clases.ReservaProfesor;

/**
 *
 * @author enzoq
 */
public class ReservaEstudianteDao {

    private Conexion conn;
    private PreparedStatement sentence;

    public ReservaEstudianteDao() {
        this.conn = new Conexion();
        this.sentence = null;
    }

    public int insert(ReservaEstudiante re) {

        try {
            if (getConn().conectarse()) {
                setSentence(getConn().getConn().prepareStatement("INSERT INTO bibliotecaicai.reserva_estudiante "
                        + "VALUES(?, ?, ?, ?)"));
                getSentence().setInt(1, re.getCedulaEstudiante());
                getSentence().setInt(2, re.getCodigoLibro());
                getSentence().setTimestamp(3, new Timestamp(re.getFecha().getTime()));
                getSentence().setInt(4, re.getDiasPrestamo());
                getSentence().executeUpdate();
                getConn().disconnect();
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return 3;
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
