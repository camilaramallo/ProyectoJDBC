import javax.management.MBeanAttributeInfo;
import java.sql.*;

public class ProyectoJDBC {
    public static void main(String[] args) {
        final String databaseURL = "jdbc:h2:~/test";
        try(Connection conexion = DriverManager.getConnection(databaseURL,"sa","");
        ){
            Statement stmt =  conexion.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");

            while(resultado.next()){
                System.out.println(resultado.getString("nombre"));
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
