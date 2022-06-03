import javax.management.MBeanAttributeInfo;
import java.sql.*;

public class ProyectoJDBC {
        private final static String dataBaseURL = "jdbc:h2:~/test";
    public static void main(String[] args) {
        try(Connection conexion = DriverManager.getConnection(dataBaseURL,"sa","");
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
