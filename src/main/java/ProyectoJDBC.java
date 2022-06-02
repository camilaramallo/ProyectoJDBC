import javax.management.MBeanAttributeInfo;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProyectoJDBC {
    public static void main(String[] args) {
        try(Connection conexion = DriverManager.getConnection("jdbc:h2:~/test","sa","");
        ){
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
