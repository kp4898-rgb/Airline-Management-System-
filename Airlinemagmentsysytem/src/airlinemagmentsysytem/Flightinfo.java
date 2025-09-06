package airlinemagmentsysytem;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Flightinfo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private JTextField textField;

    public static void main(String[] args) {
        new Flightinfo().setVisible(true);
    }

    public Flightinfo() {
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(900, 650);
        setLayout(null);
        setLocation(400, 200);
        setVisible(true);
        
   

        JLabel heading = new JLabel("FLIGHT INFORMATION");
        heading.setFont(new Font("Tahoma", Font.PLAIN, 31));
        heading.setForeground(new Color(100, 149, 237));
        heading.setBounds(50, 20, 570, 35);
        add(heading);

        JLabel labelCode = new JLabel("FLIGHT CODE");
        labelCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labelCode.setBounds(50, 100, 200, 30);
        add(labelCode);

        textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
        add(textField);

        JButton btnShow = new JButton("SHOW");
        btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnShow.setBounds(220, 150, 120, 30);
        add(btnShow);

        JButton btnCancelFlight = new JButton("Cancel Flight");
        btnCancelFlight.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCancelFlight.setBounds(220, 190, 180, 30);
        add(btnCancelFlight);

        table = new JTable();
        table.setBackground(Color.WHITE);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(23, 250, 800, 300);
        add(pane);

        // Column labels
        String[] labels = {"FLIGHT CODE", "FLIGHT NAME", "SOURCE", "DESTINATION", "CAPACITY", "CLASS CODE", "CLASS NAME"};
        int[] labelX = {23, 145, 275, 367, 497, 587, 700};

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = new JLabel(labels[i]);
            lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
            lbl.setBounds(labelX[i], 220, 120, 14);
            add(lbl);
        }

        // Show button action
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String code = textField.getText().trim();

                if (code.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a flight code.");
                    return;
                }

                try {
                    Conn c = new Conn();
                    String query = "SELECT f_code, f_name, src, dst, capacity, class_code, class_name " +
                                   "FROM flight, sector WHERE f_code = '" + code + "'";
                    ResultSet rs = c.s.executeQuery(query);

                    if (rs.next()) {
                        // Move back to before first so all data is shown
                        rs.beforeFirst();
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    } else {
                        JOptionPane.showMessageDialog(null, "No flight found for this code.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Flightinfo.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Cancel button action
        btnCancelFlight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new Cancel().setVisible(true);
                dispose();
            }
        });
    }
}
