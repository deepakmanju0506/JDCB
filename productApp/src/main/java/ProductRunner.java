import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductRunner {

    public static void main(String[] args) {
        
        System.out.println("Running in the Method...");
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found");

            String url = "jdbc:mysql://localhost:3306/product";
            String userName = "root";
            String password = "Xworkzodc@123";

           connection =DriverManager.getConnection(url,userName,password);
            System.out.println("Connection establishment success");

            String insert = "insert into p_info values(4,'laptop',70000.0)";
            Statement statement = connection.createStatement();

            int row = statement.executeUpdate(insert);
            System.out.println("No of inserted :"+ row);
        }catch(ClassNotFoundException | SQLException e){

            System.out.println("JDBC not Found :"+e.getMessage());

        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
