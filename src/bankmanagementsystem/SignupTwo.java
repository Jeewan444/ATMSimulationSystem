package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;
//import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener {

    
    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton yes, no, yess, noo;
    JComboBox religion1,category1,incomecategory1,educategory1,occcategory1;
    String formnumber;

    SignupTwo(String formnumber) {
        
        this.formnumber = formnumber;

        setTitle("New Account Application Form : Page 2 ");
        setLayout(null);

        

        JLabel formnum = new JLabel("Additional Details ");
        formnum.setFont(new Font("Raleway", Font.BOLD, 38));
        formnum.setBounds(290, 20, 600, 40);
        add(formnum);

        JLabel additionaldetails = new JLabel(" Page 2 : Additional Details " );
        additionaldetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);
        
        
         
        JLabel religion = new JLabel(" Religion : " );
        religion.setFont(new Font("Raleway", Font.BOLD,20));
        religion.setBounds(100, 140, 120, 30);
        add(religion);
        
        String valreligion[]={"Hindu", "Buddhist", "Christian" , "Musllim" , "Sikh" , "Other"};
        religion1 = new JComboBox(valreligion);
        religion1.setBackground(Color.WHITE);
        religion1.setBounds(300,140,400,30);
        add(religion1);
        
        
        
        JLabel category = new JLabel(" Category : " );
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valcategory[]={"General", "OBC", "SC" , "ST" , "Other"};
        category1 = new JComboBox(valcategory);
        category1.setBackground(Color.WHITE);
        category1.setBounds(300,190,400,30);
        add(category1);
        
        JLabel income = new JLabel(" Income : ");
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String incomecategory[]={"Null", "<1,50,000", "<2,50,000" , "<5,00,000" , "upto 10,00,000"};
        incomecategory1 = new JComboBox(incomecategory);
        incomecategory1.setBackground(Color.WHITE);
        incomecategory1.setBounds(300,240,400,30);
        add(incomecategory1);
        
        
        
        
        JLabel educational = new JLabel(" Educational ");
        educational.setFont(new Font("Raleway", Font.BOLD,20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);
        
        
        
        JLabel qualification = new JLabel(" Qualification : ");
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(100, 320, 200, 30);
        add(qualification);
        
        String educategory[]={"Non-Graduate", "Graduae", "Post-Graduate" , "Doctrate" , "Others"};
        educategory1 = new JComboBox(educategory);
        educategory1.setBackground(Color.WHITE);
        educategory1.setBounds(300,320,400,30);
        add(educategory1);
        
       
        
        JLabel occupation = new JLabel(" Occupation : ");
        occupation.setFont(new Font("Raleway", Font.BOLD,20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String occupationcategory[]={"Salaried", "Self-employed", "Businessman" , "Student" , "Retired", "Others"};
        occcategory1 = new JComboBox(occupationcategory);
        occcategory1.setBackground(Color.WHITE);
        occcategory1.setBounds(300,390,400,30);
        add(occcategory1);
       
        JLabel panno = new JLabel(" Pan Number : ");
        panno.setFont(new Font("Raleway", Font.BOLD,20));
        panno.setBounds(100, 440, 200, 30);
        add(panno);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBackground(Color.WHITE);
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        
        JLabel aadharno = new JLabel(" Aadhar Number : ");
        aadharno.setFont(new Font("Raleway", Font.BOLD,20));
        aadharno.setBounds(100, 490, 200, 30);
        add(aadharno);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharTextField.setBackground(Color.WHITE);
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);
        
        JLabel scitizen = new JLabel(" Senior Citizen : ");
        scitizen.setFont(new Font("Raleway", Font.BOLD,20));
        scitizen.setBounds(100, 540, 200, 30);
        add(scitizen);
        
        
        yes = new JRadioButton(" Yes");
        yes.setBounds(300,540,100,30);
        yes.setBackground(Color.white);
        yes.setForeground(Color.black);
        add(yes); 
        
        no = new JRadioButton(" No");
        no.setBounds(450,540,100,30);
        no.setBackground(Color.white);
        no.setForeground(Color.black);
        add(no);
        
        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(yes);
        scgroup.add(no);
        
        
        
        
        JLabel exaccount = new JLabel(" Existing Account : ");
        exaccount.setFont(new Font("Raleway", Font.BOLD,20));
        exaccount.setBounds(100, 590, 200, 30);
        add(exaccount);
        
         
        yess = new JRadioButton(" Yes");
        yess.setBounds(300,590,100,30);
        yes.setBackground(Color.white);
        yes.setForeground(Color.black);
        add(yess); 
        
        noo = new JRadioButton(" No");
        noo.setBounds(450,590,200,30);
        noo.setBackground(Color.white);
        noo.setForeground(Color.black);
        add(noo);
        
        ButtonGroup exacount = new ButtonGroup();
        exacount.add(yess);
        exacount.add(noo);
        
        
        next = new JButton(" NEXT ");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway" , Font.BOLD,14));
        next.setBounds(590, 610, 100, 40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 710);
        setLocation(350, 10);
        setVisible(true);

        

    }

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String)religion1.getSelectedItem();
        String scategory = (String)category1.getSelectedItem();
        String sincome = (String)incomecategory1.getSelectedItem();
        String squalification = (String)educategory1.getSelectedItem();
        String soccupation = (String)occcategory1.getSelectedItem();
        

        String seniorcitizen = null;
        if (yes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (no.isSelected()) {
            seniorcitizen = "No";
        }

        
        String sexisitingaccount = null;
        if (yess.isSelected()) {
            sexisitingaccount = "Yes";
        } else if (noo.isSelected()) {
            sexisitingaccount = "No";
        }

        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        try {
                Conn c = new Conn();
                String query = " insert into signuptwo values('" +formnumber+ "' , '" + sreligion + "' , '" + scategory + "', '" + sincome + "' , '" + squalification + "' , '" + soccupation + "' , '" + seniorcitizen + "', '" + span + "' , '" + sexisitingaccount + "' , '" + saadhar + "' )";
                c.s.executeUpdate(query);
                
                //signup3 
              setVisible(false);
              new SignupThree(formnumber).setVisible(true);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void main(String args[]) {
        new SignupTwo("").setVisible(true);

    }

}
