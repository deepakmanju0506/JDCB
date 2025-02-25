import java.sql.DriverManager;
import java.sql.SQLException;

public class SpecsRunner {

    public static void main(String[] args) {
        System.out.println("Running in the method....");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DriverManager Found");
            String url = "jdbc:mysql://localhost:3306/product";
            String userName = "root";
            String password = "Xworkzodc@123";
            DriverManager.getConnection(url,userName,password);
            System.out.println("connection successful");

        }catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("JDBC connection not found"+e.getMessage());
        }
    }
}
