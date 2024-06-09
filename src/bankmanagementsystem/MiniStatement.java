
package bankmanagementsystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    
    
    
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,600,200);
        add(mini);
        
        JLabel bank = new JLabel(" JKT Bank");
        bank.setBounds(150,20,500,20);
        add(bank);
        
        JLabel card = new JLabel(" JKT Bank");
        card.setBounds(20,80,500,20);
        add(card);
        
        JLabel balance = new JLabel(" JKT Bank");
        balance.setBounds(20,400,300,20);
        add(balance);
        
        // to get card number i should make a hit to databse so i will make one try catch block to throw any exceptionif occurs
        
        
        //card number display garaudai xau
        try{
            Conn conn = new Conn();  //connection kholnuuu xa database sanga  
            
            ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'"); //database ma query hannu xa 
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12)); //setText ko help le values halna milxa label bhitra 
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        //aba hammi pura transactions display garauxau like kati transactions vayo vanera dekhauna ko lagi 
        //yo vanda mathi login databse ma query lai hit garekok thyeu aba esma transaction ma hit garauxau 
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
               mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("amount") + "<br><br><html>");  //yanira hami append gariraxau 
            
               if(rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                        
                    }else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is Rs : " +bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
        
        
        
        
        
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        
    }
    
    public static void main(String args[]){
        new MiniStatement("").setVisible(true);
        
        
    }
    
}
