import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.SortedMap;

public class Lotion {

    public static void main(String[] args) {
        System.out.println("Running in method...");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found");
            String url = "jdbc:mysql://localhost:3306/product";
            String userName = "root";
            String password = "Xworkz@123";

            DriverManager.getConnection(url,userName,password);
            System.out.println("connection establishment success");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("JDBC connection not found"+e.getMessage());
        }
    }
}
