package proyecto.ramallo.java.jdbc;

import proyecto.ramallo.java.jdbc.modelo.Producto;
import proyecto.ramallo.java.jdbc.repositorio.ProductoRepositorioImpl;
import proyecto.ramallo.java.jdbc.repositorio.Repositorio;
import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import javax.management.MBeanAttributeInfo;
import javax.sound.midi.Soundbank;
import java.sql.*;

public class ProyectoJDBC {
    public static void main(String[] args) {
        //final String databaseURL = "jdbc:h2:~/test";
        try(Connection conexion = ConexionBaseDatos.getInstance();
        ){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println(repositorio.porID(2L));
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
