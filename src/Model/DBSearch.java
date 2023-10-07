package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBSearch {
    
    public ResultSet searchLogin(String username) {
        
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = DBConnection.getConnection();
            String name = username;
            
            ps = conn.prepareStatement("SELECT username, password FROM adminlogin WHERE username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if((rs.next())) {
                System.out.println("username: " + rs.getString("username") + " " + "password: " + rs.getString("password"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        } 

        return rs;
    }
}
