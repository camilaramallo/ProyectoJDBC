package proyecto.ramallo.java.jdbc;

import proyecto.ramallo.java.jdbc.modelo.Producto;
import proyecto.ramallo.java.jdbc.repositorio.ProductoRepositorioImpl;
import proyecto.ramallo.java.jdbc.repositorio.Repositorio;
import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCDelete {
    public static void main(String[] args) {
        try(Connection conexion = ConexionBaseDatos.getInstance();
        ){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=============== listar ============================");
            repositorio.listar().forEach(System.out::println); //con referencia al metodo

            System.out.println("=============== obtener por id =======================");
            System.out.println(repositorio.porID(2L));

            System.out.println("=============== Eliminar producto==================");
            Producto producto = new Producto();
            producto.setId_prod(7L);
            repositorio.eliminar(producto.getId_prod());
            System.out.println("Producto editado con éxito");
            repositorio.listar().forEach(System.out::println); //con referencia al metodo


        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
