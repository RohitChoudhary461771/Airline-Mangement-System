
package airlinemanagment.system;

import javax.swing.*;//javax is package of swing from where we are extending JFram class. Normally we use Java.util.* package.
import java.awt.*;//we import this package to include the color in frame.
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener{
  // Globally declaring so to get outputs
    
    JTextField tfname, tfphone,tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE); //This is present in awt package.
        setLayout(null);

    //Adding heading in the frame.
    
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add(heading);
    
    // Creating labels in frame
    
        //Name with label.
        
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        //Nationality
        
        JLabel lblnationality =new JLabel("Nationality");
        lblnationality.setBounds(60,130,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
    
        // aadhar
        
        JLabel lblaadhar =new JLabel("Aadhar");
        lblaadhar.setBounds(60,180,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220,180,150,25);
        add(tfaadhar);
        
        //Address
        
        JLabel lbladdress =new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
    
    // Creating radio buttons
        JLabel lblgender =new JLabel("Gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        ButtonGroup gendergroup =new ButtonGroup();//This is added so that only one radio Button selected at a single time.
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
    
    //Phone 
        
        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(60,330,150,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
    
    //Button 
        JButton save =new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,380,150,30);
        save.addActionListener(this);
        add(save);
    
    // Adding Image 
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/emp.png"));
           
        JLabel lblimage= new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);

                
        setSize(900,600);
        setLocation(290,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      // Getting the output from the text field
      
      String name =tfname.getText();
      String nationality = tfnationality.getText();
      String phone = tfphone.getText();
      String address =tfaddress.getText();
      String aadhar =tfaadhar.getText();
      String gender = null;//we cannot directly get radio button output that's why created an empty string and selective statement
      
      
      if(rbmale.isSelected()){
          gender="Male";
      }else{
          gender="Female";
      }
      
        try{
            Conn conn =new Conn();
            
            String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
            
            // Now executing this DML command whereas in Login page we have executed the DDL Command 
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new AddCustomer();//Anonymous object.
    }
}
