package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alreadyEvaluated extends JFrame {

    public alreadyEvaluated() {}
    
    public alreadyEvaluated(String word, History h, int num) {
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setBounds(100, 100, 776, 405);
    	JPanel contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	setContentPane(contentPane);
    	contentPane.setLayout(null);
		
    	JLabel txtpnYouHaveAlredy = new JLabel("<html>You have already evaluated this law.<br>You chose that this law was " + word + ".</html>");
    	txtpnYouHaveAlredy.setForeground(Color.RED);
    	txtpnYouHaveAlredy.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	txtpnYouHaveAlredy.setBackground(SystemColor.menu);
    	txtpnYouHaveAlredy.setBounds(203, 103, 343, 94);
    	contentPane.add(txtpnYouHaveAlredy);
		
    	JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            dispose();
        }});
        btnOK.setBounds(125, 278, 120, 31);
        contentPane.add(btnOK);
		
        JButton btnAgain = new JButton("Evaluate Again");
        btnAgain.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.undone(num);
            h.initLaw(num);
            dispose();
        }});
        btnAgain.setBounds(300, 278, 120, 31);
        contentPane.add(btnAgain);
        
        JButton btnComment = new JButton("See Comment");
        btnComment.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.getComment(num - 1);
            viewComments vc = new viewComments(h, num - 1);
            vc.setVisible(true);
        }});
        btnComment.setBounds(475, 278, 120, 31);
        contentPane.add(btnComment);
    }
}