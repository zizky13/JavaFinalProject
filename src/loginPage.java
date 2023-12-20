import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class loginPage {

    JFrame frame;
    JPanel titleNamePanel, usernamePanel, passwordPanel;
    JLabel usernameLabel, passwordLabel, titleNameLabel;
    JPasswordField passwordField;
    JTextField usernameField;
    JButton loginButton;
    Font normalFont = new Font("Helvetica", Font.PLAIN, 12);

    public loginPage(){
        frame = new JFrame("WasteLessEats");
        frame.setSize(400, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(new GridLayout(4, 3));

        titleNameLabel = new JLabel("WasteLessEats",SwingConstants.CENTER);
        titleNameLabel.setFont(normalFont);
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setVisible(true);
        frame.add(titleNameLabel);

        titleNamePanel = new JPanel();
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setLayout(new GridLayout(2, 1));
        frame.add(titleNamePanel);

        usernamePanel = new JPanel(new FlowLayout());
        titleNamePanel.add(usernamePanel);

        passwordPanel = new JPanel(new FlowLayout());
        titleNamePanel.add(passwordPanel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(normalFont);
        usernamePanel.add(usernameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(normalFont);
        passwordPanel.add(passwordLabel);

        usernameField = new JTextField(15);
        usernamePanel.add(usernameField);

        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setFont(normalFont);
        frame.add(loginButton);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                boolean isValid = validateCredentials(enteredUsername, enteredPassword);

                if (isValid) {
                    frame.setVisible(false);
                    homePage home = new homePage();
                    // Perform actions after successful login
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        // Replace with your database connection code and query
        // Example: JDBC connection and SQL query
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zikar", "zikar", "abarsiaevil32");

            // Example query: Check if username and password match in the 'users' table
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                resultSet.close();
                statement.close();
                connection.close();
                return true; // Credentials are valid
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false; // Credentials are invalid or database error occurred
    }
}
