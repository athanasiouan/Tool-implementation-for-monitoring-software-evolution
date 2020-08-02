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

public class reportError extends JFrame{

	
    private JPanel contentPane;
    private JButton btnOk;
    private ActionListener choose = createChoiceAction();
    
    public reportError() {
    	setTitle("Error");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 812, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel txtpnLawSevenIs = new JLabel("<html>You have NOT evaluated all the laws for this file!<br>You can NOT write a report right now!</html>");
		txtpnLawSevenIs.setForeground(Color.RED);
		txtpnLawSevenIs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtpnLawSevenIs.setBackground(SystemColor.menu);
		txtpnLawSevenIs.setBounds(150, 105, 564, 94);
		contentPane.add(txtpnLawSevenIs);
		
		btnOk = new JButton("OK");
	    btnOk.addActionListener(choose);
	    btnOk.setBounds(350, 299, 120, 31);
	    contentPane.add(btnOk);
    }
    
    private ActionListener createChoiceAction() {
        ActionListener choose = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnOk){
                    dispose();
                }
            }
        };
        return choose;
    } 	
}