package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class comment extends JFrame {
	
	public comment(){}
	
	public comment(History h, int pos) {
		setTitle("Comment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 814, 443);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtpnWriteAComment = new JLabel("Write a comment...");
		txtpnWriteAComment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnWriteAComment.setBackground(SystemColor.menu);
		txtpnWriteAComment.setBounds(74, 46, 148, 26);
		contentPane.add(txtpnWriteAComment);
		
		JTextArea textField = new JTextArea();
		textField.setColumns(10);
		textField.setBounds(75, 83, 657, 235);
		contentPane.add(textField);		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	dispose();			
        }});
		btnCancel.setBounds(208, 368, 120, 31);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
			if(!textField.getText().equals("")){
				String com = textField.getText();
	        	h.setComment(com, pos);
				dispose();
			}
        }});
		
		btnOk.setBounds(75, 368, 120, 31);
		contentPane.add(btnOk);
	}

}