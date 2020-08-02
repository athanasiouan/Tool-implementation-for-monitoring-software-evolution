package Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JTextPane;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class errorFile2 extends JFrame{
    
    public errorFile2() {
    	setTitle("Error");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 408);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtpnLawSevenIs = new JLabel("The file you have selected does not have the proper form!");
		txtpnLawSevenIs.setForeground(Color.RED);
		txtpnLawSevenIs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnLawSevenIs.setBackground(SystemColor.menu);
		txtpnLawSevenIs.setBounds(190, 105, 564, 94);
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

