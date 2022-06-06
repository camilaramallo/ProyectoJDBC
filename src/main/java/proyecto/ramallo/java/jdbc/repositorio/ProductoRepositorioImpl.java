package proyecto.ramallo.java.jdbc.repositorio;

import proyecto.ramallo.java.jdbc.modelo.Producto;
import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{
    //creamos un metodo que devuelve la conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTOS")) {
                //iteramos el resultSet y por c/ registro de la BD creamos un obj Product y la guardamos en al lista
                while(rs.next()){
                    Producto p = crearProducto(rs);
                    productos.add(p);

                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porID(Long id) {
        Producto producto = null;

        try(PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM productos WHERE id_prod = ?")){
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();//ejecutamos la consulta
            if(rs.next()){
                producto = crearProducto(rs);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
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

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId_prod(rs.getLong("id_prod"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFecha_ingreso(rs.getDate("fecha_ingreso"));
        return p;
    }
}
