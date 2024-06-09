
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit, fastcash,exit,ministatement,pinchange,withdrawal,balanceenquiry;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select withdrawal Amount ");
        text.setBounds(200, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Rs 1000");
        deposit.setBounds(155, 415, 150, 35);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Rs 2000");
        withdrawal.setBounds(365, 415, 150, 35);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Rs 5000");
        fastcash.setBounds(155, 450, 150, 35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Rs 10000");
        ministatement.setBounds(365, 450, 150, 35);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Rs 201000");
        pinchange.setBounds(155, 485, 150, 35);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Rs 25000");
        balanceenquiry.setBounds(365, 485, 150, 35);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
        exit=new JButton("Back");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount =((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            
            try{
                
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"' ");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                        
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"' , '"+date+"' , 'Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " +amount+ " Debited Successfully");
                
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    
    
    public static void main(String[]args){
        new FastCash("").setVisible(true);
        
    }
    
}
