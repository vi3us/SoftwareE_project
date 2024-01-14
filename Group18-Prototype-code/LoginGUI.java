import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class LoginGUI implements ActionListener {
    // Creates a frame that we can put all of the components in it
    JFrame frame = new JFrame("Login");

    // Rest of the components
    JButton loginButton = new JButton("Login");
    JButton signUpButton = new JButton("Sign Up");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel loginMessage = new JLabel("");

    // Creates an instance of the datatables that we can extract user information from
    TestData database = TestData.getInstance();

    LoginGUI() {

        // Setting the size and position of each component then adding it to the frame
        usernameLabel.setBounds(50,100,75,25);
        frame.add(usernameLabel);
        
        passwordLabel.setBounds(50,150,75,25);
        frame.add(passwordLabel);

        loginMessage.setBounds(65,270,300,35);
        loginMessage.setFont(new Font(null,Font.ITALIC,20));
        frame.add(loginMessage);

        usernameField.setBounds(125,100,200,25);
        frame.add(usernameField);

        passwordField.setBounds(125,150,200,25);
        frame.add(passwordField);

        loginButton.setBounds(120,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        signUpButton.setBounds(230,200,100,25);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);
        frame.add(signUpButton);

        // Default settings for frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the GUI frame, you can change this if you want it to be bigger or smaller
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Actionlistener, this is used to control button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Gets the username and password entered into the username and password fields
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            User user = new User(username, password);
            Boolean login = user.login();

            // Searches the login data table for an id that matches the username entered in the username field
            if (login == false) { // If an id for the username cannot be found
                loginMessage.setForeground(Color.red);
                loginMessage.setText("Incorrect username or password");
            }
            else { // Otherwise get the array from that row
                String usertype = user.getRole();
                loginMessage.setForeground(Color.green);
                loginMessage.setText("Login Successful");
                // Get the usertype from the users data table, search by the id we already obtained
                if (usertype.equals("1")) { // 1 means the user is part of the scheduling team
                    SchedulingTeam currentuser = new SchedulingTeam(username, password);
                    SchedulingTeamGUI schedulingteam = new SchedulingTeamGUI(currentuser); // Create scheduling team GUI and pass in the id
                }
                else if (usertype.equals("2")) { // 2 means the user is a trainer
                    Trainer currentuser = new Trainer(username, password);
                    TrainerGUI trainer = new TrainerGUI(currentuser); // Create trainer GUI and pass in the id
                }
                frame.dispose(); // Delete the current frame
            }
        }

        // If button clicked is the sign up button, then create sign up page and dispose current frame
        if (e.getSource() == signUpButton) {
            SignUpGUI signup = new SignUpGUI();
            frame.dispose();
        }
    }
}