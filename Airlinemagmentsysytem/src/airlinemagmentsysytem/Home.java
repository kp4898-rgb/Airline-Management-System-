package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    public Home(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image= new JLabel(i1);
        image.setBounds(0,0,1600,800);
        add(image);


        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        
    }
    
   public static void main(String[] args)
   {
       new Home();
   }
}