import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SchedulingTeamViewCoursesGUI implements ActionListener {
    JFrame frame = new JFrame("View All Courses");
    JLabel headings = new JLabel("[Course Name, Location, Length in Weeks, Consultant type, Start date]");
    JList<String> displayList = new JList<>();
    JButton backButton = new JButton("<-");
    JScrollPane scrollPane = new JScrollPane();
    JLabel title = new JLabel("Courses");
    
    SchedulingTeam user;
    SchedulingTeamViewCoursesGUI(SchedulingTeam useroriginal) {
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

        displayList = new JList<>(user.viewAllCourses().toArray(new String[0]));
        displayList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                   String id = String.valueOf(displayList.getSelectedIndex() + 1);
                   SchedulingTeamCourseModulesGUI coursemodules = new SchedulingTeamCourseModulesGUI(user, id);
                }
            }
        });
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
            SchedulingTeamGUI schedulingteam = new SchedulingTeamGUI(user);
            frame.dispose();
        }
    }
}