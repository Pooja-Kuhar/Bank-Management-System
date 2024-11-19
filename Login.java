package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
  
    Login(){
        setTitle("BANK MANAGEMENT SYSTEM");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/background.jpg"));
        Image i2 = i1.getImage().getScaledInstance(950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 950, 950);
        add(l11);
        
        l1 = new JLabel("WELCOME TO YOUR ACCOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(50,100,650,40);
        l11.add(l1);
        
        l2 = new JLabel("Card No:");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,250,375,30);
        l11.add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,250,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf1);
        
        l3 = new JLabel("PIN:");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,320,375,30);
        l11.add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,320,230,30);
        l11.add(pf2);
                
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLUE);
        add(b1);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLUE);
        add(b2);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLUE);
        add(b3);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 18));
        b1.setBounds(190,400,120,40);
        l11.add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setBounds(400,400,120,40);
        l11.add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 18));
        b3.setBounds(190,480,330,40);
        l11.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(950,1000);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }

    
}



