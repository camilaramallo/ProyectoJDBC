package proyecto.ramallo.java.jdbc.repositorio;

import proyecto.ramallo.java.jdbc.modelo.Producto;
import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        return null;
    }

    @Override
    public Producto porID(Long id) {
        return null;
    }

    @Override
    public void guardar(Producto t) {

    }

    @Override
    public void modificar(Producto t) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
