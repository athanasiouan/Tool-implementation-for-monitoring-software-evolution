package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class alreadyReport extends JFrame {

    public alreadyReport() {}
    
    public alreadyReport(History h) {
    	setTitle("Report Error");
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setBounds(100, 100, 776, 405);
    	JPanel contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(contentPane);
    	contentPane.setLayout(null);
		
    	JLabel txtpnYouHaveAlredy = new JLabel("You have already written a report for this file!");
    	txtpnYouHaveAlredy.setForeground(Color.RED);
    	txtpnYouHaveAlredy.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	txtpnYouHaveAlredy.setBackground(SystemColor.menu);
    	txtpnYouHaveAlredy.setBounds(180, 103, 600, 94);
    	contentPane.add(txtpnYouHaveAlredy);
        
        JButton btnReport = new JButton("See Report");
        btnReport.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	viewReport vr = new viewReport(h);
        	vr.setVisible(true);
        }});
        btnReport.setBounds(300, 278, 120, 31);
        contentPane.add(btnReport);
    }
}
