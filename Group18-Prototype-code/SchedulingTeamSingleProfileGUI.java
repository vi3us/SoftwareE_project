import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SchedulingTeamSingleProfileGUI implements ActionListener {
    JFrame frame = new JFrame("View Profile");

    JLabel title = new JLabel("");

    JLabel namelabel = new JLabel("Name:");
    JLabel name = new JLabel();

    JLabel DOBlabel = new JLabel("Date of Birth:");
    JLabel DOB = new JLabel();

    JLabel citylabel = new JLabel("City:");
    JLabel city = new JLabel();

    JLabel countrylabel = new JLabel("Country:");
    JLabel country = new JLabel();

    JLabel skillslabel = new JLabel("Skills:");
    JLabel skills = new JLabel();

    JLabel qualificationslabel = new JLabel("Qualifications:");
    JLabel qualifications = new JLabel();

    JLabel gradeslabel = new JLabel("Grades:");
    JLabel grades = new JLabel();

    JLabel consultantTypelabel = new JLabel("Consultant Type:");
    JLabel consultantType = new JLabel();

    SchedulingTeam curruser = new SchedulingTeam("","");


    SchedulingTeamSingleProfileGUI(SchedulingTeam useroriginal, String id) {
        curruser = useroriginal;
        //System.out.println(id);
        ArrayList<String> userProfile = SchedulingTeam.returnSingleProfile(id);
        //[UserID, FirstName, Surname, DateOfBirth, City, Country, Skills(t)/Grades(c), Qualifications(t)/ConsultantType(c), RoleID]

        title.setBounds(10,10,150,25);
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 20));
        frame.add(title);

        namelabel.setBounds(10,10,150,25);
        frame.add(namelabel);
        name.setText(userProfile.get(1) + " " + userProfile.get(2));
        name.setBounds(50,10,150,25);
        frame.add(name);

        DOBlabel.setBounds(10,30,150,25);
        frame.add(DOBlabel);
        DOB.setText(userProfile.get(3));
        DOB.setBounds(90,30,150,25);
        frame.add(DOB);

        citylabel.setBounds(10,50,150,25);
        frame.add(citylabel);
        city.setText(userProfile.get(4));
        city.setBounds(40,50,150,25);
        frame.add(city);

        countrylabel.setBounds(10,70,150,25);
        frame.add(countrylabel);
        country.setText(userProfile.get(5));
        country.setBounds(60,70,150,25);
        frame.add(country);

        if (Integer.valueOf(userProfile.get(8)) == 2){
            skillslabel.setBounds(10,200,150,25);
            frame.add(skillslabel);
            skills.setText(userProfile.get(6));
            skills.setBounds(48,200,500,25);
            frame.add(skills);

            qualificationslabel.setBounds(10,220,150,25);
            frame.add(qualificationslabel);
            qualifications.setText(userProfile.get(7));
            qualifications.setBounds(95,220,500,25);
            frame.add(qualifications);
        }
        else if(Integer.valueOf(userProfile.get(8)) == 3){
            gradeslabel.setBounds(10,200,150,25);
            frame.add(gradeslabel);
            grades.setText(userProfile.get(6));
            grades.setBounds(60,200,500,25);
            frame.add(grades);

            consultantTypelabel.setBounds(10,220,150,25);
            frame.add(consultantTypelabel);
            consultantType.setText(userProfile.get(7));
            consultantType.setBounds(110,220,500,25);
            frame.add(consultantType);
        }

        try {
            BufferedImage fdmlogo = ImageIO.read(new File("Prototype-code/images/profile.png"));
            JLabel fdmlogolabel = new JLabel(new ImageIcon(fdmlogo.getScaledInstance(150, 160, Image.SCALE_FAST)));
            fdmlogolabel.setBounds(430,20,150,160);
            frame.add(fdmlogolabel);
        } catch (IOException e) {
            System.out.println("Error: Image could not be loaded");
        }

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(615,295);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}