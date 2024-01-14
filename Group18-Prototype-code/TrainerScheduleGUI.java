

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TrainerScheduleGUI implements ActionListener {
    JFrame frame = new JFrame("My Schedule");

    JLabel headings = new JLabel("[ModuleID, Name, CourseID, TrainerID, Week, Date]");

    JButton backButton = new JButton("<-");
    JList<String> displayList = new JList<>();
    JScrollPane scrollPane = new JScrollPane();
    JLabel title = new JLabel("My Schedule");
    
    Trainer user = new Trainer("","");
    TrainerScheduleGUI(Trainer useroriginal) {
        user = useroriginal;

        title.setBounds(80,10,150,25);
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 20));
        frame.add(title);

        backButton.setBounds(10,10,50,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        headings.setBounds(10, 60, 550, 25);
        frame.add(headings);

        displayList = new JList<>(user.viewPersonalSchedule().toArray(new String[0]));
        scrollPane = new JScrollPane(displayList);
        scrollPane.setBounds(10,100,560,300);
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,455);
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