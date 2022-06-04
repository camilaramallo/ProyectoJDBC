package proyecto.ramallo.java.jdbc;

import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import javax.management.MBeanAttributeInfo;
import javax.sound.midi.Soundbank;
import java.sql.*;

public class ProyectoJDBC {
    public static void main(String[] args) {
        //final String databaseURL = "jdbc:h2:~/test";
        try(Connection conexion = ConexionBaseDatos.getInstance();
        ){
            Statement stmt =  conexion.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");

            while(resultado.next()){
                System.out.print(resultado.getString("nombre") );
                System.out.print("  ");
                System.out.print(resultado.getInt("precio"));
                System.out.println(" ");

            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
