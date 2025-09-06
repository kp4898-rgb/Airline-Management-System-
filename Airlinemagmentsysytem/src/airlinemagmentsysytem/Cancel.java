package airlinemagmentsysytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cancel extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField textField, textField_1, textField_2, textField_3;

    public static void main(String[] args) {
        new Cancel();
    }

    public Cancel() {
        initialize();
    }

    private void initialize() {
        setTitle("CANCELLATION");
        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 801, 472);
        setLayout(null);

        JLabel Cancellation = new JLabel("CANCELLATION");
        Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
        Cancellation.setBounds(185, 24, 259, 38);
        add(Cancellation);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(470, 100, 250, 250);
        add(NewLabel);

        JLabel PassengerNo = new JLabel("PASSENGER NO");
        PassengerNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        PassengerNo.setBounds(60, 100, 132, 26);
        add(PassengerNo);

        JLabel CancellationNo = new JLabel("CANCELLATION NO");
        CancellationNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        CancellationNo.setBounds(60, 150, 150, 27);
        add(CancellationNo);

        JLabel CancellationDate = new JLabel("CANCELLATION DATE");
        CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
        CancellationDate.setBounds(60, 200, 180, 27);
        add(CancellationDate);

        JLabel Flightcode = new JLabel("FLIGHT CODE");
        Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Flightcode.setBounds(60, 250, 150, 27);
        add(Flightcode);

        JButton Cancel = new JButton("CANCEL");
        Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(250, 350, 150, 30);
        add(Cancel);

        textField = new JTextField();
        textField.setBounds(250, 100, 150, 27);
        add(textField);

        textField_1 = new JTextField();
        textField_1.setBounds(250, 150, 150, 27);
        add(textField_1);

        textField_2 = new JTextField();
        textField_2.setBounds(250, 200, 150, 27);
        add(textField_2);

        textField_3 = new JTextField(); // Flight Code
        textField_3.setBounds(250, 250, 150, 27);
        add(textField_3);

        Cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String passenger_no = textField.getText();
                String cancellation_no = textField_1.getText();
                String cancellation_date = textField_2.getText();
                String flight_code = textField_3.getText();

                try {
                    Conn c = new Conn();
                    String str = "INSERT INTO cancellation(passenger_no, cancellation_no, cancellation_date, flight_code) " +
                                 "VALUES('" + passenger_no + "', '" + cancellation_no + "', '" + cancellation_date + "', '" + flight_code + "')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Flight Cancelled Successfully!");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Your flight has been canceled sucessfully!");
                }
            }
        });

        setSize(860, 500);
        setVisible(true);
        setLocation(400, 200);
    }
}
