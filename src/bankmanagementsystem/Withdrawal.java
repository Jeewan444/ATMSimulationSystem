package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;


public class Withdrawal extends JFrame implements ActionListener{
    
    JTextField samount;
    
    JButton withdraw, back;
    String pinnumber;
    
    Withdrawal(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(170,300,400,20);
        image.add(text);
        
        samount = new JTextField();
        samount.setFont(new Font("Raleway" , Font.BOLD,22));
        samount.setBounds(170,350,320,30);
        image.add(samount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setBounds(0,0,900,900);
        setVisible(true);
        
    }
    
  public void actionPerformed(ActionEvent ae){
        try{        
            String amount = samount.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(samount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }




    
    public static void main(String []args){
        new Withdrawal("").setVisible(true);
    }
}
