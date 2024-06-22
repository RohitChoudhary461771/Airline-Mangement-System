package airlinemanagment.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;// importing this file rs2xml.jar file for creation of table.

public class FlightInfo extends JFrame {
    public FlightInfo(){
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JTable table =new JTable();//for creating the table 
        
        //working with database.Remeber database operation always must be written in try catch block
        
        try{
            Conn conn = new Conn();
            
            ResultSet rs= conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                //DbUtils.resultSetToTableModel(rs) this is a rs2xml jar file method which is use to create table and store database value in tha table
                //table.setModel()this is use to enter the above jar file created table in the user defined table.
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table); //we are creating jsp object for JScrollPane class which provide us scroll bar over our table which is pass as a argument to class object
                                                     
        jsp.setBounds(0,0,800,500);
        //i face the problem that table was notshowing on the frame the reason was that because I created the table but prior to this i did not the run use query in database.
        add(jsp);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    
    public static void main(String []args){
        new FlightInfo();//Ananoymus object
    }
}



