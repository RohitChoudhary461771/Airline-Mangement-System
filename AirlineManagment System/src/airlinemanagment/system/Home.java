//Anaything which 'J' infront of it means it has came from swing class

package airlinemanagment.system;


import javax.swing.*;//javax is package of swing from where we are extending JFram class. Normally we use Java.util.* package.
import java.awt.*;//we import this package to include the color in frame.
import java.awt.event.*;//we import this package to include ActionListner interface which helps button to perform some action.
import java.sql.*;//To include ResultSet

public class Home extends JFrame implements ActionListener{ //whenever their is JFrame then it means we are innhereting the swing class
   
   
    public Home(){//default user defined constructor.
        
    //**** Basic things compulsary to do ****************************************************     
        
        setLayout(null);
        
        //this is used to get the photos from the respective folder.
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icons/front.jpg"));
        JLabel image=new JLabel(i1);//we cannot direct use add ,in case of image adding thats why we are using JLabel.
        image.setBounds(0,0,1500,700);
        add(image);
         
     //writting over the image
        
        JLabel heading =new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500,20,900,40);
        heading.setForeground(Color.BLUE);//font color 
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));//for changing the fonts type
        image.add(heading);
    
    // Creating the menubar
        
        JMenuBar menubar =new JMenuBar();//creating menubar using Menubar class of swing package
        setJMenuBar(menubar);
    
    //1.elment of menubar    
        JMenu details=new JMenu("Details");//Inside the menubar adding details section.
        menubar.add(details);
      
      // Inside detail section.  
      
        JMenuItem flightDetails=new JMenuItem("Flight Details");//1.1
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails=new JMenuItem("Add Customer Details");//1.2
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight=new JMenuItem("Book Flight");//1.3
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails=new JMenuItem("Journey Details");//1.4
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation=new JMenuItem("Cancel Ticket");//1.5
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
    
    //2. Element of Menubar
        
        JMenu ticket=new JMenu("Ticket");//1.1
        menubar.add(ticket);
        
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");//1.2
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//For full screen of frame we used this function.
        setVisible(true);
        
    }
    //overriding
    public void actionPerformed(ActionEvent ae){// this is used to define the functioning of buttons that is what actually that button is performing.
       String text=ae.getActionCommand();
       
       if(text.equals("Add Customer Details")){
           new AddCustomer();
       }else if(text.equals("Flight Details")){
           new FlightInfo();
       }else if(text.equals("Book Flight")) {
            new BookFlight();
        }else if(text.equals("Journey Details")) {
            new JourneyDetails();
        }else if(text.equals("Cancel Ticket")){
            new Cancel();
        }else if(text.equals("Boarding Pass")){
            new BoardingPass();
       
        
    }
         
     }
    
   public static void main(String[] args){
     new Home();//Anonymus object
   }
}
