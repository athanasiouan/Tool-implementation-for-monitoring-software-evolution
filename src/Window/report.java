package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.lang.model.element.Element;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class report extends JFrame {

    public report(){}
	
	public report(History h) {
		setTitle("Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 412);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
		JLabel txtpnWriteAShort = new JLabel("Write a short report...");
		txtpnWriteAShort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnWriteAShort.setBackground(UIManager.getColor("Button.background"));
		txtpnWriteAShort.setBounds(10, 11, 148, 26);
		contentPane.add(txtpnWriteAShort);
		
		JTextArea textField = new JTextArea();

		textField.setBounds(10, 41, 754, 235);
		contentPane.add(textField);
		textField.setColumns(10);
        
		JButton btnSaveTo = new JButton("Save");
		btnSaveTo.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
			if(!textField.getText().equals("")){
				String com = textField.getText();
	        	h.setReport(com);
	        	h.saveReport(com);
				dispose();
			}
        }});
		btnSaveTo.setBounds(20, 287, 120, 31);
		contentPane.add(btnSaveTo);
        
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            dispose();
        }});
		btnCancel.setBounds(180, 287, 120, 31);
		contentPane.add(btnCancel);

		JButton btnComments = new JButton("View Comments");
		btnComments.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            viewComments vc = new viewComments(h);
            vc.setVisible(true);
        }});
		btnComments.setBounds(350, 287, 180, 31);
		contentPane.add(btnComments);		
    }     
}
