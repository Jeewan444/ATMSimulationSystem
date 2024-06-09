
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1, c2, c3, c4 , c5 , c6 , c7;
    JButton cancel,submit;
    String formnumber;
    
    SignupThree(String formnumber) {
        
        this.formnumber = formnumber;
        
        setLayout(null);
        setTitle("New Account Application Form : Page 3");
        
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,20,400,40);
        add(l1);
        
        JLabel type = new JLabel(" Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,80,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,130,190,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,130,260,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,170,260,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,170,290,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        
        JLabel cardno = new JLabel(" Card Number :");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(100,220,300,30);
        add(cardno);
        
        JLabel number = new JLabel(" XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(350,220,300,30);
        add(number);
        
        JLabel carddetails = new JLabel(" This is your 16-digits Card Number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,250,300,20);
        add(carddetails);
        
        JLabel pinno = new JLabel(" Pin Number :");
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        pinno.setBounds(100,290,200,30);
        add(pinno);
        
       
        JLabel pnumber = new JLabel(" XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(350,290,300,30);
        add(pnumber);
        
        JLabel pindetails = new JLabel(" This is your 4-digits Password");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,320,300,20);
        add(pindetails);
        
        JLabel services = new JLabel(" Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,370,250,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway" , Font.BOLD,16));
        c1.setBounds(100, 420, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway" , Font.BOLD,16));
        c2.setBounds(350, 420, 200, 30);
        add(c2);
        
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway" , Font.BOLD,16));
        c3.setBounds(100, 470, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway" , Font.BOLD,16));
        c4.setBounds(350, 470, 200, 30);
        add(c4);
        
        
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway" , Font.BOLD,16));
        c5.setBounds(100, 520, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway" , Font.BOLD,16));
        c6.setBounds(350, 520, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway" , Font.BOLD,12));
        c7.setBounds(100, 580, 700, 30);
        add(c7);
        
        
        submit = new JButton("SUBMIT");
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway" , Font.BOLD,16));
        submit.setBounds(250,630,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Raleway" , Font.BOLD,16));
        cancel.setBounds(420,630,100,30);
        cancel.addActionListener(this);

        add(cancel);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,700);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== submit){
            String accountType = null;
            
            if(r1.isSelected()){
                accountType = "Saving Account ";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random random =new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 6044420000000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
           String facility = "";
           if(c1.isSelected()){
               facility =facility + "  ATM Card ";
           }else if(c2.isSelected()){
               facility =facility + " Internet banking";
           }else if(c3.isSelected()){
               facility =facility + "  Mobile banking";
           }else if(c4.isSelected()){
               facility =facility + "  Email & SMS Alerts";
           }else if(c5.isSelected()){
               facility =facility + "  Cheque Book";
           }else if(c6.isSelected()){
               facility =facility + "  E-Statement";
           }
           
           
           //These inputs now lets pass or database bhitra ma retrieve garum 
           // Since database is external entity and runtime ma error aauxa so first ma exception handling garnu parxa
           
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account Type is Required ");
               }else {
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('"+formnumber+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                   String query2 = "insert into login values('"+formnumber+"','"+cardnumber+"','"+pinnumber+"')";

                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, " Please Note Down Your CardNumber And PIN Number. Also Don't Share it to Others ");
                   JOptionPane.showMessageDialog(null, " Card Number " +cardnumber + "\n Pin : " +pinnumber);
                   
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(false);
               }
               
               
           }catch(Exception e){
               
               System.out.println(e);
           }
           
        }else if(ae.getSource()== cancel){
            
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    
        
    public static void main(String[]args){
        new SignupThree("").setVisible(true);
    }
    
}
