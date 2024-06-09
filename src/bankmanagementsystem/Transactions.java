
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;
public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit, fastcash,exit,ministatement,pinchange,withdrawal,balanceenquiry;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transactions ");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(155, 415, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Cash WithDrawal");
        withdrawal.setBounds(365, 415, 150, 35);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(155, 450, 150, 35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(365, 450, 150, 35);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Pin Change");
        pinchange.setBounds(155, 485, 150, 35);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(365, 485, 150, 35);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
        exit=new JButton("Exit");
        exit.setBounds(365, 520, 150, 35);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource()== withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()== pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()== ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    
    public static void main(String[]args){
        new Transactions("").setVisible(true);
        
    }
    
}
