import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class TrainerProfileGUI implements ActionListener {
    JFrame frame = new JFrame("My Profile");

    JButton backButton = new JButton("<-");

    JLabel title = new JLabel("My Profile");

    JLabel namelabel = new JLabel("Name:");
    JLabel name = new JLabel();

    JLabel DOBlabel = new JLabel("Date of Birth:");
    JLabel DOB = new JLabel();

    JLabel citylabel = new JLabel("City:");
    JLabel city = new JLabel();

    JLabel countrylabel = new JLabel("Country:");
    JLabel country = new JLabel();

    JLabel skillsLabel = new JLabel("Skills:");
    JLabel skills = new JLabel();

    JLabel qualificationsLabel = new JLabel("Qualifications:");
    JLabel qualifications = new JLabel();


    Trainer user = new Trainer("","");
    TrainerProfileGUI(Trainer useroriginal) {
        user = useroriginal;

        title.setBounds(80,10,150,25);
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 20));
        frame.add(title);

        backButton.setBounds(10,10,50,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        namelabel.setBounds(10,60,150,25);
        frame.add(namelabel);
        name.setText(user.getProfile().getName());
        name.setBounds(50,60,150,25);
        frame.add(name);

        DOBlabel.setBounds(10,80,150,25);
        frame.add(DOBlabel);
        DOB.setText(user.getProfile().getDateOfBirth().toString());
        DOB.setBounds(90,80,150,25);
        frame.add(DOB);

        citylabel.setBounds(10,100,150,25);
        frame.add(citylabel);
        city.setText(user.getProfile().getCity());
        city.setBounds(40,100,150,25);
        frame.add(city);

        countrylabel.setBounds(10,120,150,25);
        frame.add(countrylabel);
        country.setText(user.getProfile().getCountry());
        country.setBounds(60,120,150,25);
        frame.add(country);

        skillsLabel.setBounds(10,200,150,25);
        frame.add(skillsLabel);
        skills.setText(String.join(", ", (((TrainerProfileHandler) user.getProfile()).getSkills())));
        skills.setBounds(48,200,500,25);
        frame.add(skills);

        qualificationsLabel.setBounds(10,220,150,25);
        frame.add(qualificationsLabel);
        qualifications.setText(String.join(", ", (((TrainerProfileHandler) user.getProfile()).getQualifications())));
        qualifications.setBounds(95,220,500,25);
        frame.add(qualifications);

        try {
            BufferedImage fdmlogo = ImageIO.read(new File("Prototype-code/images/profile.png"));
            JLabel fdmlogolabel = new JLabel(new ImageIcon(fdmlogo.getScaledInstance(150, 160, Image.SCALE_FAST)));
            fdmlogolabel.setBounds(430,20,150,160);
            frame.add(fdmlogolabel);
        } catch (IOException e) {
            System.out.println("Error: Image could not be loaded");
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(615,295);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            TrainerGUI trainer = new TrainerGUI(user);
            frame.dispose();
        }
    }
}