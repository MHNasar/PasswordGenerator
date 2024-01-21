import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomPasswordGenerator extends JFrame implements ActionListener {
    private JTextField passwordField;
    private JButton generateButton;

    public RandomPasswordGenerator() {
        setTitle("Random Password Generator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // Text field to display the generated password
        passwordField = new JTextField();
        passwordField.setEditable(false);

        // Button to trigger the password generation
        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(this);

        // Add components to the panel
        panel.add(passwordField);
        panel.add(generateButton);

        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomPasswordGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            // Generate a random password when the button is clicked
            String generatedPassword = generateRandomPassword(10); // Change the length as needed
            passwordField.setText(generatedPassword);
        }
    }

    // Method to generate a random password of a specified length
    private String generateRandomPassword(int length) {
        // Define the characters that can be used in the password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Generate the password by randomly selecting characters from the set
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString(); // Return the generated password
    }
}
