
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import negocio.clases.ReservaProfesor;

/**
 *
 * @author enzoq
 */
public class ReservaProfesorDao {

    private Conexion conn;
    private PreparedStatement sentence;

    public ReservaProfesorDao() {
        this.conn = new Conexion();
        this.sentence = null;
    }

    public int insert(ReservaProfesor rp) {

        try {
            if (getConn().conectarse()) {
                setSentence(getConn().getConn().prepareStatement("INSERT INTO bibliotecaicai.reserva_profesor "
                        + "VALUES(?, ?, ?, ?)"));
                getSentence().setInt(1, rp.getCedulaProfe());
                getSentence().setInt(2, rp.getCodigoLibro());
                getSentence().setTimestamp(3, new Timestamp(rp.getFecha().getTime()));
                getSentence().setInt(4, rp.getDiasPrestamo());
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
