package airlinemagmentsysytem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Bookflight extends JFrame {
    private static final long serialVersionUID = 1L;
    JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;

    public Bookflight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setTitle("Book Flight");
        setSize(800, 550);
        setLocationRelativeTo(null);

        JLabel lblFlightCode = new JLabel("FLIGHT CODE");
        lblFlightCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblFlightCode.setBounds(60, 30, 150, 27);
        add(lblFlightCode);
        


        textField_6 = new JTextField();
        textField_6.setBounds(200, 30, 150, 27);
        add(textField_6);

        JLabel lblPassport = new JLabel("PASSPORT NO");
        lblPassport.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPassport.setBounds(60, 80, 150, 27);
        add(lblPassport);

        textField = new JTextField();
        textField.setBounds(200, 80, 150, 27);
        add(textField);

        JLabel lblPnr = new JLabel("PNR NO");
        lblPnr.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPnr.setBounds(60, 120, 150, 27);
        add(lblPnr);

        textField_1 = new JTextField();
        textField_1.setBounds(200, 120, 150, 27);
        add(textField_1);

        JLabel lblAddress = new JLabel("ADDRESS");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblAddress.setBounds(60, 170, 150, 27);
        add(lblAddress);

        textField_2 = new JTextField();
        textField_2.setBounds(200, 170, 150, 27);
        add(textField_2);

        JLabel lblNationality = new JLabel("NATIONALITY");
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNationality.setBounds(60, 220, 150, 27);
        add(lblNationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 220, 150, 27);
        add(textField_3);

        JLabel lblName = new JLabel("NAME");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblName.setBounds(60, 270, 150, 27);
        add(lblName);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 270, 150, 27);
        add(textField_4);

        JLabel lblGender = new JLabel("GENDER");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblGender.setBounds(60, 320, 150, 27);
        add(lblGender);

        JRadioButton male = new JRadioButton("MALE");
        male.setBackground(Color.WHITE);
        male.setBounds(200, 320, 70, 27);
        add(male);

        JRadioButton female = new JRadioButton("FEMALE");
        female.setBackground(Color.WHITE);
        female.setBounds(280, 320, 70, 27);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lblPhone = new JLabel("PH NO");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPhone.setBounds(60, 370, 150, 27);
        add(lblPhone);

        textField_5 = new JTextField();
        textField_5.setBounds(200, 370, 150, 27);
        add(textField_5);

        JButton btnSave = new JButton("SAVE");
        btnSave.setBounds(60, 420, 100, 30);
        btnSave.setBackground(Color.BLACK);
        btnSave.setForeground(Color.WHITE);
        add(btnSave);

        btnSave.addActionListener(e -> {
            String flightCode = textField_6.getText();
            String passport = textField.getText();
            String pnr = textField_1.getText();
            String address = textField_2.getText();
            String nationality = textField_3.getText();
            String name = textField_4.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String phone = textField_5.getText();

            try {
                Conn c = new Conn();
                String str = "INSERT INTO passenger (passport_no, pnr_no, address, nationality, name, gender, phone, flight_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = c.c.prepareStatement(str);
                ps.setString(1, passport);
                ps.setString(2, pnr);
                ps.setString(3, address);
                ps.setString(4, nationality);
                ps.setString(5, name);
                ps.setString(6, gender);
                ps.setString(7, phone);
                ps.setString(8, flightCode);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Passenger Added Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        JButton btnFlightInfo = new JButton("FLIGHT INFO");
        btnFlightInfo.setBounds(180, 420, 140, 30);
        btnFlightInfo.setBackground(Color.BLUE);
        btnFlightInfo.setForeground(Color.WHITE);
        add(btnFlightInfo);

        btnFlightInfo.addActionListener(e -> {
            setVisible(false);
            new Flightinfo();
        });

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBounds(340, 420, 140, 30);
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        add(btnCancel);

        btnCancel.addActionListener(e -> {
            setVisible(false);
            new Cancel(); // You must define this class.
        });

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(400, 20, 400, 30);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 80, 350, 350);
        add(image);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Bookflight();
    }
}
