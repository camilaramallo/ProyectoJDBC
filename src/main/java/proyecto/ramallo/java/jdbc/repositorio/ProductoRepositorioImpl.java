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

        try(PreparedStatement Pstmt = getConnection().
                prepareStatement("SELECT * FROM productos WHERE id_prod= ?")){
            Pstmt.setLong(1, id);
            try (ResultSet rs = Pstmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }

            }//ejecutamos la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        //xreamos la plantilla
        String sql;
        if (producto.getId_prod() != null && producto.getId_prod() > 0) {
            sql ="UPDATE productos SET nombre=?, precio=? WHERE id_prod=?";

        } else {
            sql = "INSERT INTO productos ( nombre,precio,fecha_ingreso) VALUES(?,?,?)";
        }
        try(PreparedStatement pstmt = getConnection().prepareStatement(sql)){
            pstmt.setString(1, producto.getNombre());
            pstmt.setLong(2, producto.getPrecio());
            if (producto.getId_prod() != null && producto.getId_prod() > 0) {
                pstmt.setLong(3,producto.getId_prod());
            } else {
                pstmt.setDate(3, new Date(producto.getFecha_ingreso().getTime()));
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modificar(Producto t) {

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(PreparedStatement pstmt = getConnection().prepareStatement("DELETE FROM productos WHERE id_prod=?")){
            pstmt.setLong(1,id);
            pstmt.executeUpdate();
        }

    }
        //metodo que solo usaremos dentro de la clase
    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId_prod(rs.getLong("id_prod"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFecha_ingreso(rs.getDate("fecha_ingreso"));
        return p;
    }
}

