import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TrainerGUI implements ActionListener {
    // Creates a frame that we can put all of the components in it
    JFrame frame = new JFrame("My Scheduling App (Trainer)");

    // Rest of the components
    JButton viewSchedule = new JButton("View Schedule");
    
    JButton viewProfile = new JButton("View Profile");
    JButton logout = new JButton("Logout");

    JLabel title = new JLabel();

    Trainer user = new Trainer("","");
    // Creates a variable called id that can be used by all methods in this class, will be assigned a value in the constructor
    TrainerGUI(Trainer useroriginal) {
        user = useroriginal;

        title.setBounds(160,0,300,100);
        title.setText("Welcome, "+user.getProfile().getName());
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 20));
        frame.add(title);

        viewSchedule.setBounds(10,300,150,50);
        viewSchedule.setFocusable(false);
        viewSchedule.addActionListener(this);
        frame.add(viewSchedule);

        viewProfile.setBounds(425,300,150,50);
        viewProfile.setFocusable(false);
        viewProfile.addActionListener(this);
        frame.add(viewProfile);

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
        if (e.getSource() == viewSchedule) {
            TrainerScheduleGUI schedule = new TrainerScheduleGUI(user);
            frame.dispose();
        }

        if (e.getSource() == viewProfile) {
            TrainerProfileGUI profile = new TrainerProfileGUI(user);
            frame.dispose();
        }

        if (e.getSource() == logout){
            LoginGUI login = new LoginGUI();
            frame.dispose(); 
        }
    }
}