
package airlinemanagment.system;

//****** JDBC connectivity with mysql******************

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try{
        //1. registering the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        //2. creating connection.
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Rohit@123");
       
        //3. creating statement.
            s=c.createStatement();
            
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
