
package bankmanagementsystem;
//import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change Your  PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 26));
        text.setBounds(220,290,500,30);
        image.add(text);
        
        
        JLabel pintext = new JLabel("Enter New PIN : ");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165,340,180,24);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setForeground(Color.black);
        pin.setFont(new Font("Raleway", Font.BOLD,16));
        pin.setBounds(330, 340, 180, 20);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN : ");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165,370,180,24);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setForeground(Color.black);
        repin.setFont(new Font("Raleway", Font.BOLD,16));
        repin.setBounds(330, 370, 180, 20);
        image.add(repin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== change){
            try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered PIN doesnot match : ");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New PIN : ");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN : ");
                return;
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
            String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
            String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null," PIN Changed Successfully : ");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String[]args){
        new PinChange("").setVisible(true);
        
    }
}
