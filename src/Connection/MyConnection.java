
package Connection;
import java.sql.*;
import com.mysql.jdbc.MySQLConnection;

public class MyConnection 
{
    static Connection con = null;
    
    static
    {
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver load....");
        } catch (ClassNotFoundException e) 
        {
            System.out.println(e);
        }
    }
    
    public static Connection getConnection()
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
            System.out.println("Driver found......");
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        return con;
    }
}
