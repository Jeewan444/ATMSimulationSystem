
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton signup,login,clear;
    JTextField cardNumberTextField;
    JPasswordField PinNumberTextField;
    
    Login(){
        setTitle("JEEWAN KUMAR AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon icon1 =new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text =new JLabel("Welcome To JK ATM");
        text.setFont(new Font("Raleway", Font.BOLD, 40));
        text.setBounds(250, 40, 500, 40);
        add(text);
        
        
        JLabel cardnumber =new JLabel("Card Number : ");
        cardnumber.setFont(new Font("Raleway", Font.BOLD, 28));
        cardnumber.setBounds(110, 150, 250, 40);
        add(cardnumber);
        
        cardNumberTextField  = new JTextField();
        cardNumberTextField.setBounds(350,150,250,40);
        add(cardNumberTextField);
        
        
        JLabel pinnumber =new JLabel("PIN Number : ");
        pinnumber.setFont(new Font("Osward", Font.BOLD, 28));
        pinnumber.setBounds(110, 240, 250, 40);
        add(pinnumber);
        
        PinNumberTextField  = new JPasswordField();
        PinNumberTextField.setBounds(350,240,250,40);
        add(PinNumberTextField);
        
        
        login = new JButton(" SIGN IN ");
        login.setBounds(350, 310, 100, 40);
        login.addActionListener(this);
        add(login);
        
        
        
        clear = new JButton(" CLEAR ");
        clear.setBounds(500, 310, 100, 40);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        add(clear);
        
        
        
        
        signup = new JButton(" SIGN UP ");
        signup.setBounds(350, 360, 250, 50);
        signup.addActionListener(this);
        add(signup);
        
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,500);
        setLocation(340,200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
            
            cardNumberTextField.setText("");
            PinNumberTextField.setText("");
            
        } else if(ae.getSource()== login){
            
            Conn conn = new Conn();
            String cardnumber= cardNumberTextField.getText();
            String pinnumber = PinNumberTextField.getText();
            String query = "select * from login where cardnumber ='"+cardnumber+"' and pinnumber ='"+pinnumber+"' ";
            
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Card or PIN ");
                }
            }catch(Exception e){
                System.out.println(e);
            
            }
        } else if (ae.getSource() == signup){
            
            setVisible(false);
            new SignUpOne().setVisible(true);
        }

        
    }
    
    
    
    public static void main(String args[]){
        new Login().setVisible(true);
    }
    
}
