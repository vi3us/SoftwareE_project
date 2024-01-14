import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SchedulingTeamGUI implements ActionListener {
    // Creates a frame that we can put all of the components in it
    JFrame frame = new JFrame("My Scheduling App (Scheduling Team)");

    // Rest of the components
    JButton viewProfiles = new JButton("View all profiles");
    JButton createcourse = new JButton("View courses");
    JButton editcourse = new JButton("Create course");
    JButton logout = new JButton("Logout");
    JLabel title = new JLabel();

    SchedulingTeam user = new SchedulingTeam("","");
    SchedulingTeamGUI(SchedulingTeam useroriginal) {
        user = useroriginal;

        title.setBounds(160,0,300,100);
        title.setText("Welcome, "+SchedulingTeam.returnSingleProfile(user.getId()).get(1)+" "+SchedulingTeam.returnSingleProfile(user.getId()).get(2));
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 20));
        frame.add(title);

        viewProfiles.setBounds(10,300,150,50);
        viewProfiles.setFocusable(false);
        viewProfiles.addActionListener(this);
        frame.add(viewProfiles);

        createcourse.setBounds(220,300,150,50);
        createcourse.setFocusable(false);
        createcourse.addActionListener(this);
        frame.add(createcourse);

        editcourse.setBounds(425,300,150,50);
        editcourse.setFocusable(false);
        editcourse.addActionListener(this);
        frame.add(editcourse);

        logout.setBounds(475,10,100,34);
        logout.setFocusable(false);
        logout.addActionListener(this);
        frame.add(logout);

        try {
            BufferedImage fdmlogo = ImageIO.read(new File("Prototype-code/images/fdmlogo.png"));
            JLabel fdmlogolabel = new JLabel(new ImageIcon(fdmlogo.getScaledInstance(200, 120, Image.SCALE_FAST)));
            fdmlogolabel.setBounds(-80,-50,300,200);
            frame.add(fdmlogolabel);
        } catch (IOException e) {
            System.out.println("Error: Image could not be loaded");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewProfiles) {
            SchedulingTeamProfilesGUI schedulingteamprofiles = new SchedulingTeamProfilesGUI(user);
            frame.dispose();
        }

        if (e.getSource() == createcourse) {
            SchedulingTeamViewCoursesGUI schedulingteamview = new SchedulingTeamViewCoursesGUI(user);
            frame.dispose();
        }

        if (e.getSource() == editcourse) {
            SchedulingTeamCreateCourseGUI schedulingteamcreate = new SchedulingTeamCreateCourseGUI(user);
            frame.dispose();
        }

        if (e.getSource() == logout){
            LoginGUI login = new LoginGUI();
            frame.dispose(); 
        }
    }
}