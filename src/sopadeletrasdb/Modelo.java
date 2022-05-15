package sopadeletrasdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;

public class Modelo {

    Vista v;

    public String consultarDB(JTextArea a) {
         String palabra = "";
        try {
         
            Connection con = null;
            String sURL = "jdbc:mariadb://localhost:3306/sopa_de_letras";
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM `PALABRAS`");
               String cadena = "";
            while (rs.next()) {
                System.out.println(rs.getString(1));
                palabra+=rs.getString(1) + ",";
                cadena += rs.getString(1) + "\n";
            }
            a.setText(cadena);
            con.close();
            
        } catch (SQLException e) {

        }
        return palabra;
    }

    public void insertarDB(String palabra,JTextArea a) {
        try {
            Connection con = null;
            String sURL = "jdbc:mariadb://localhost:3306/sopa_de_letras";
            con = DriverManager.getConnection(sURL, "root", "");

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("INSERT INTO `palabras` (`palabra`) VALUES " + "('" + palabra + "')");
               String cadena="";
            while (rs.next()) {

                cadena += rs.getString(1) + "\n";
            }
            a.setText(cadena);
            con.close();
        } catch (SQLException e) {
        }
    }

    public void borrarDB(String palabra,JTextArea a) {
        try {
            Connection con = null;
            String sURL = "jdbc:mariadb://localhost:3306/sopa_de_letras";
            con = DriverManager.getConnection(sURL, "root", "");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("DELETE FROM palabras WHERE `palabras`.`palabra` = '" + palabra + "'");
            String cadena = "";
            while (rs.next()) {

                cadena += rs.getString(1) + "\n";
            }
            a.setText(cadena);
            con.close();
        } catch (SQLException e) {

        }
    }
}
