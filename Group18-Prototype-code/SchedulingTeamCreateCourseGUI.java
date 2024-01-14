import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class SchedulingTeamCreateCourseGUI implements ActionListener {
    JFrame frame = new JFrame("Create Course");

    JButton backButton = new JButton("<-");

    JLabel namelabel = new JLabel("Course name:");
    JTextField namefield = new JTextField();

    JLabel locationlabel = new JLabel("Location (City and Country):");
    JTextField locationfield = new JTextField();

    JLabel weekslabel = new JLabel("Number of weeks:");
    JTextField weeksfield = new JTextField();

    JLabel rolelabel = new JLabel("Consultant role:");
    JTextField rolefield = new JTextField();

    JLabel datelabel = new JLabel("Start date (dd/mm/yyyy):");
    JTextField datefield = new JTextField();

    JLabel usermessage = new JLabel("");

    JButton createbutton = new JButton("Create course");
    
    SchedulingTeam user;
    SchedulingTeamCreateCourseGUI(SchedulingTeam useroriginal) {
        user = useroriginal;

        backButton.setBounds(10,10,50,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        namelabel.setBounds(10,60,150,25);
        frame.add(namelabel);
        namefield.setBounds(200,60,200,25);
        frame.add(namefield);

        locationlabel.setBounds(10,110,200,25);
        frame.add(locationlabel);
        locationfield.setBounds(200,110,200,25);
        frame.add(locationfield);

        weekslabel.setBounds(10,160,200,25);
        frame.add(weekslabel);
        weeksfield.setBounds(200,160,200,25);
        frame.add(weeksfield);

        rolelabel.setBounds(10,210,150,25);
        frame.add(rolelabel);
        rolefield.setBounds(200,210,200,25);
        frame.add(rolefield);

        datelabel.setBounds(10,260,150,25);
        frame.add(datelabel);
        datefield.setBounds(200,260,200,25);
        frame.add(datefield);

        usermessage.setBounds(10,320,550,25);
        frame.add(usermessage);

        createbutton.setBounds(10,360,150,50);
        createbutton.setFocusable(false);
        createbutton.addActionListener(this);
        frame.add(createbutton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,460);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Handles checking each field and the corresponding error message 
    public boolean datachecks() {
        boolean pass = true;

        boolean isWeeksInt;

        try {
            Integer.parseInt(weeksfield.getText());
            isWeeksInt = true;
        }
        catch (NumberFormatException e) {
            isWeeksInt = false;
        }

        if (namefield.getText().trim().equals("") || locationfield.getText().trim().equals("") || weeksfield.getText().trim().equals("") || rolefield.getText().trim().equals("") || datefield.getText().trim().equals("")) {
            pass = false;
            usermessage.setForeground(Color.red);
            usermessage.setText("Error: One or more fields are blank or have empty spaces");
        }

        else if (isWeeksInt == false) {
            pass = false;
            usermessage.setForeground(Color.red);
            usermessage.setText("Error: Number of weeks is not an integer, please try again");
        }

        else if (isWeeksInt == true) {
            if (Integer.parseInt(weeksfield.getText()) < 6 || Integer.parseInt(weeksfield.getText()) > 14) {
                pass = false;
                usermessage.setForeground(Color.red);
                usermessage.setText("Error: Number of weeks must be between 6 - 14");
            }

            else if (!rolefield.getText().equals("Graduates") && !rolefield.getText().equals("Ex forces") && !rolefield.getText().equals("Returners to work")) {
                pass = false;
                usermessage.setForeground(Color.red);
                usermessage.setText("Error: Consultant role must be either 'Graduates' or 'Ex forces' or 'Returners to work'");
            }

            // Simple check for date format using regex
            else if (datefield.getText().matches("^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$") == false) {
                pass = false;
                usermessage.setForeground(Color.red);
                usermessage.setText("Error: Invalid date format, please make sure the date is valid and is in format 'dd/mm/yyyy'");
            }
        }

        return pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            SchedulingTeamGUI schedulingteam = new SchedulingTeamGUI(user);
            frame.dispose();
        }

        if (e.getSource() == createbutton) {
            if (datachecks() == true) {
                try {
                    user.createCourse(namefield.getText(),locationfield.getText(),weeksfield.getText(),rolefield.getText(), datefield.getText());
                } catch (IOException e1) {
                    System.out.println("IO Error, please contact the developers");
                }
                namefield.setText("");
                locationfield.setText("");
                weeksfield.setText("");
                rolefield.setText("");
                datefield.setText("");
                usermessage.setForeground(Color.green);
                usermessage.setText("Course created successfully");
            }
        }
    }
}