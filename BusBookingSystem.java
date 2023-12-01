import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusBookingSystem extends JFrame {
    private JComboBox<String> sourceComboBox;
    private JComboBox<String> destinationComboBox;
    private JButton bookButton;

    public BusBookingSystem() {
        setTitle("Bus Booking System");
        setSize(1500, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create components
        String[] cities = {"Select City", "Hyderabad", "Bangalore", "Chennai","Delhi","Vizag"};
        sourceComboBox = new JComboBox<>(cities);
        destinationComboBox = new JComboBox<>(cities);
        bookButton = new JButton("Book Now");

        // Add components to the frame
        add(new JLabel("Source: "));
        add(sourceComboBox);
        add(new JLabel("Destination: "));
        add(destinationComboBox);
        add(bookButton);

        // Add action listener to the book button
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTicket();
            }
        });
    }

    private void bookTicket() {
        String source = (String) sourceComboBox.getSelectedItem();
        String destination = (String) destinationComboBox.getSelectedItem();

        if (source.equals("Select City") || destination.equals("Select City")) {
            JOptionPane.showMessageDialog(this, "Please select source and destination cities");
        } else if (source.equals(destination)) {
            JOptionPane.showMessageDialog(this, "Source and destination cities cannot be the same!");
        } else {
            JOptionPane.showMessageDialog(this, "Ticket booked from " + source + " to " + destination);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BusBookingSystem().setVisible(true);
            }
        });
    }
}
