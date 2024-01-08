
package csc380_project;

import java.sql.*;

public class Conn {
    
    public Connection connect(){
        
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINEMA", "root", "W@2915djkq#");
            
        } catch (Exception e){
            e.getMessage();
        }
        return con;
    } 
   
    
}//End claas
