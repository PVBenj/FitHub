package Controller;

import Model.DBSearch;
import View.Home;
import View.Login;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



public class LoginController {
    public static void login(String userName, String passWord) {
        try{
           ResultSet rs = new DBSearch().searchLogin(userName);
           
           
           if(rs.getString("username") != null && rs.getString("password") != null) {
               if(userName.equals(rs.getString("username")) && passWord.equals(rs.getString("password"))) {
                    System.out.println("Login Successfull!");
                    Login.getFrames()[0].dispose();
                    new View.Home().setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null, "Incorrect credentials", "Warning", JOptionPane.WARNING_MESSAGE);
               }
           }else {
               JOptionPane.showMessageDialog(null, "Account is not found in the system", "Warning", JOptionPane.WARNING_MESSAGE);
               
           }
         }
        catch(Exception e) {
           e.printStackTrace();
       }
        
    }
 }

