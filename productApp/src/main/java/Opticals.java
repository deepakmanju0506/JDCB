import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Opticals {

    public static void main(String[] args) {
        System.out.println("running in the method...");
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver found");
            String url = "jdbc:mysql://localhost:3306/product";
            String userName = "root";
            String password = "Xworkzodc@123";

          connection = DriverManager.getConnection(url,userName,password);
            System.out.println("connection establish success");

            String insert = "insert into opticals_info values(1,'lenskart',1300)";
            Statement statement = connection.createStatement();

            int row = statement.executeUpdate(insert);
            System.out.println("No of inserted :"+ row);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("JDBC not found :"+e.getMessage());

        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                throw  new RuntimeException(e);
            }
        }
    }
}
