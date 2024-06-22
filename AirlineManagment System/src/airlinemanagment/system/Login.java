//Anaything which 'J' infront of it means it has came from swing class

package airlinemanagment.system;


import javax.swing.*;//javax is package of swing from where we are extending JFram class. Normally we use Java.util.* package.
import java.awt.*;//we import this package to include the color in frame.
import java.awt.event.*;//we import this package to include ActionListner interface which helps button to perform some action.
import java.sql.*;//To include ResultSet

public class Login extends JFrame implements ActionListener{ //whenever their is JFrame then it means we are innhereting the swing class
   JButton reset,submit,close;//declaring button globally so we can use it in other method as well earlier it was declared locally.
   JPasswordField tfpassword;//global declaration
   JTextField tfusername;//
   
    public Login(){//default user defined constructor.
        
        
        getContentPane().setBackground(Color.WHITE); //This is present in awt package.
        //By default swing provide us border layout(i.e some padding margin etc) so we need to null it and set our own layout.
        
        setLayout(null);
    //**** Username section ****************************************************  
    
        JLabel lblusername= new JLabel("Username");//lbl = label 
        lblusername.setBounds(20,20,100,20);//this is to set where the user name will display in frame.
        add(lblusername);//this is use to add username in the frame screen.
        
        // for making box infront of username lf-> label field
        
        tfusername =new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
    
    //**** password section ****************************************************    
        
        JLabel lblpassword= new JLabel("Password");//lbl = label 
        lblpassword.setBounds(20,60,100,20);//this is to set where the password will display in frame.
        add(lblpassword);//this is use to add username in the frame screen.
        setVisible(true);//This is use to make frame visible 
        
        // for making box infront of password lf-> label field
        
        tfpassword =new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        add(tfpassword);
    
    //**** Buttons section **************************************************** 
        
//      JButton reset =new JButton("Reset");//locally declare
        reset =new JButton("Reset");

        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);//this is use to perform action 
        add(reset);
        
//      JButton submit =new JButton("Submit");
        submit =new JButton("Submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        add(submit);
        
//      JButton close =new JButton("Close");
        close =new JButton("Close");
        close.setBounds(120,160,120,20);
        close.addActionListener(this);
        add(close);
        
    //**** Basic things compulsary to do **************************************************** 

        setSize(400,250);
        setLocation(500,250);//This is use to postion the frame in the screen.
        
    }
    //overriding
    public void actionPerformed(ActionEvent ae){// this is used to define the functioning of buttons that is what actually that button is performing.
       // we are checking which button is click 
        if(ae.getSource()==submit){
            // extracting the text which write in the text field.
            String username= tfusername.getText();//getText() is used to get the field text.
            String password= tfpassword.getText();
            
            try{
                Conn c =new Conn();
                 String query ="select * from login where username ='"+username+"'and password ='"+password+"'";
                 
                ResultSet rs= c.s.executeQuery(query); //ResultSet is class on whose object we are storing the query result.
                
                //checking if the query is correct or not 
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }
                else{
                    //JOption is used to show dialogue box 
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);//after dialogue box the frame will close.
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==close){
            setVisible(false);
        }
        else if(ae.getSource()==reset){
            tfusername.setText("");
            tfpassword.setText("");
        }
         
     }
    
   public static void main(String[] args){
     new Login();//Anonymus object
   }
}
