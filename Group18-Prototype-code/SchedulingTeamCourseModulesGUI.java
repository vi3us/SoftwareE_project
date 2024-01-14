import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SchedulingTeamCourseModulesGUI implements ActionListener {
    JFrame frame = new JFrame("Course Modules");
    JLabel headings = new JLabel("[ModuleID, Name, CourseID, TrainerID, Week, Date]");
    JList<String> displayList = new JList<>();
    JScrollPane scrollPane = new JScrollPane();

    
    SchedulingTeam user;
    SchedulingTeamCourseModulesGUI(SchedulingTeam useroriginal, String id) {
        user = useroriginal;

        headings.setBounds(10, 10, 400,25);
        frame.add(headings);

        displayList = new JList<>(user.viewModulesByCourseID(id).toArray(new String[0]));
        scrollPane = new JScrollPane(displayList);
        scrollPane.setBounds(10,40,560,200);
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}