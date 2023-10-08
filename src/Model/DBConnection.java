package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection conn;
    static Statement stmt = null;
    
    public static Connection getConnection() {
        try{
            String url = "jdbc:mysql://localhost:3306/fithub_db";
            conn = (Connection) DriverManager.getConnection(url, "root", "");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConn() throws SQLException {
        conn.close();
    }
}
