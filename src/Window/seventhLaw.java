package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class seventhLaw extends JFrame {

    public seventhLaw(){}
    
    public seventhLaw(History h) {
		setTitle("Seventh Law");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 411);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel txtrLawSevenIs = new JLabel("Law seven is valid, because law two and law six were also valid.");
		txtrLawSevenIs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtrLawSevenIs.setBackground(UIManager.getColor("Button.background"));
		txtrLawSevenIs.setBounds(126, 97, 564, 94);
		contentPane.add(txtrLawSevenIs);
	        
	    JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            dispose();
        }});
		btnOk.setBounds(171, 306, 120, 31);
		contentPane.add(btnOk);
	        
		JButton btnComment = new JButton("Comments");
        btnComment.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            comment c = new comment(h, 6);
            c.setVisible(true);
        }});
		btnComment.setBounds(445, 306, 120, 31);	
		contentPane.add(btnComment);
    }  
}

