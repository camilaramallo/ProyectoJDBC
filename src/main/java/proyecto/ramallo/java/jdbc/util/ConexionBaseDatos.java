package proyecto.ramallo.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String dataBaseURL = "jdbc:h2:~/test";
    private static String username = "sa";
    private static  String password = "";
    private static Connection conexion;

    //creamos un metodo estatico getConnection para establecer la conexción
    public static Connection getInstance() throws SQLException {
        if(conexion == null){
            conexion = DriverManager.getConnection(dataBaseURL,username,password);
        }
        return conexion;
    }

}
