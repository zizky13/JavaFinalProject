import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class loginPage {

    //================== FIELDS INIT =====================
    JFrame loginFrame;
    JPanel titleNamePanel, usernamePanel, passwordPanel;
    JLabel usernameLabel, passwordLabel, titleNameLabel;
    JPasswordField passwordField;
    JTextField usernameField;
    JButton loginButton;
    Font normalFont = new Font("Helvetica", Font.PLAIN, 12);

    public loginPage(){
        //================== FRAME INIT =====================
        loginFrame = new JFrame("WasteLessEats");
        loginFrame.setSize(400, 300);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.getContentPane().setBackground(Color.white);
        loginFrame.setLayout(new GridLayout(4, 3));

        //================== TITLE NAME LABEL INIT =====================
        titleNameLabel = new JLabel("WasteLessEats",SwingConstants.CENTER);
        titleNameLabel.setFont(normalFont);
        titleNameLabel.setForeground(Color.black);
        titleNameLabel.setVisible(true);
        loginFrame.add(titleNameLabel);

        //================== TITLE NAME PANEL INIT =====================
        titleNamePanel = new JPanel();
        titleNamePanel.setBackground(Color.black);
        titleNamePanel.setLayout(new GridLayout(2, 1));
        loginFrame.add(titleNamePanel);

        //================== USERNAME PANEL INIT =====================
        usernamePanel = new JPanel(new FlowLayout());
        titleNamePanel.add(usernamePanel);

        //================== PASSWORD PANEL INIT =====================
        passwordPanel = new JPanel(new FlowLayout());
        titleNamePanel.add(passwordPanel);

        //================== USERNAME LABEL INIT =====================
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(normalFont);
        usernamePanel.add(usernameLabel);

        //================== PASSWORD LABEL INIT =====================
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(normalFont);
        passwordPanel.add(passwordLabel);

        //================== USERNAME FIELD INIT =====================
        usernameField = new JTextField(15);
        usernamePanel.add(usernameField);

        //================== PASSWORD FIELD INIT =====================
        passwordField = new JPasswordField(15);
        passwordPanel.add(passwordField);

        //================== LOGIN BUTTON INIT =====================
        loginButton = new JButton("Login");
        loginButton.setFont(normalFont);
        loginFrame.add(loginButton);
        loginFrame.setVisible(true);

        //================== LOGIN BUTTON LISTENER =====================
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                boolean isValid = validateCredentials(enteredUsername, enteredPassword);

                if (isValid) {
                    loginFrame.setVisible(false);
                    homePage home = new homePage();
                    // Perform actions after successful login
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.");
                }
            }
        });
    }


    //================== METHOD TO VALIDATE CREDENTIALS =====================
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
