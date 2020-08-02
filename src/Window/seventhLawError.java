package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class seventhLawError extends JFrame{
    
    public seventhLawError() {
    	setTitle("Error");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 408);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel txtpnLawSevenIs = new JLabel("You have NOT evaluated law 2 or law 6!");
		txtpnLawSevenIs.setForeground(Color.RED);
		txtpnLawSevenIs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnLawSevenIs.setBackground(SystemColor.menu);
		txtpnLawSevenIs.setBounds(250, 105, 564, 94);
		contentPane.add(txtpnLawSevenIs);
		
		JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            dispose();
        }});
	    btnOk.setBounds(350, 299, 120, 31);
	    contentPane.add(btnOk);
    }    
}
