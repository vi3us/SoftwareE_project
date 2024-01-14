import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SchedulingTeamProfilesGUI implements ActionListener {
    JFrame frame = new JFrame("View All Profiles");

    JButton backButton = new JButton("<-");
    JList<String> displayList = new JList<>();
    JScrollPane scrollPane = new JScrollPane();
    JLabel title = new JLabel("Profiles");
    
    SchedulingTeam user;

    String[] nameList  = SchedulingTeam.returnFullNames().toArray(new String[0]);

    SchedulingTeamProfilesGUI(SchedulingTeam useroriginal) {
        user = useroriginal;

        title.setBounds(80,10,150,25);
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 20));
        frame.add(title);
        
        backButton.setBounds(10,10,50,25);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        frame.add(backButton);

        displayList = new JList<>(nameList); // pass through filter code on button press
        scrollPane = new JScrollPane(displayList);
        scrollPane.setBounds(10,70,560,300);
        frame.add(scrollPane);

        displayList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                   int pos = displayList.getSelectedIndex();
                   String id = nameList[pos].split(":")[0];
                   SchedulingTeamSingleProfileGUI singleProfileGUI = new SchedulingTeamSingleProfileGUI(user,id);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,425);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            SchedulingTeamGUI schedulingteam = new SchedulingTeamGUI(user );
            frame.dispose();
        }

    }
}