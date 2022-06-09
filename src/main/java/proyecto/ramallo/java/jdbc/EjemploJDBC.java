package proyecto.ramallo.java.jdbc;

import proyecto.ramallo.java.jdbc.modelo.Producto;
import proyecto.ramallo.java.jdbc.repositorio.ProductoRepositorioImpl;
import proyecto.ramallo.java.jdbc.repositorio.Repositorio;
import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) {
        //final String databaseURL = "jdbc:h2:~/test";
        try(Connection conexion = ConexionBaseDatos.getInstance();
        ){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=============== listar ============================");
            repositorio.listar().forEach(System.out::println); //con referencia al metodo

            System.out.println("=============== obtener por id =======================");
            System.out.println(repositorio.porID(2L));
            System.out.println("===============insertar nuevo producto==================");

            Producto producto = new Producto();
            producto.setNombre("mouse");
            producto.setPrecio(1000);
            producto.setFecha_ingreso(new Date());
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println); //con referencia al metodo


        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
