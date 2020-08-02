package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.lang.model.element.Element;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewComments extends JFrame {

    public viewComments(){}
	
	public viewComments(History h) {
		setTitle("List of Comments");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 412);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String temp = "";
		JTextArea textField = new JTextArea();
		
		for (int i = 0 ; i < 8 ; i++){
			if(h.getValid(i) == false){
				temp = temp + "VALUE OF LAW " + (i + 1) + ": INVALID - COMMENT OF LAW " + (i + 1) + ": " + h.getComment(i) + "\r\n";
			}
			else{
				temp = temp + "VALUE OF LAW " + (i + 1) + ": VALID - COMMENT OF LAW " + (i + 1) + ": " + h.getComment(i) + "\r\n";
			}
		}
		textField.setText(temp);
		textField.setBounds(10, 41, 754, 235);
		contentPane.add(textField);
		textField.setColumns(10);		
    }   
	
	public viewComments(History h, int num) {
		setTitle("Comment of LAW " + (num + 1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 412);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea textField = new JTextArea();
		textField.setText("COMMENT OF LAW " + (num + 1) + ": " + h.getComment(num));
		textField.setBounds(10, 41, 754, 235);
		contentPane.add(textField);
		textField.setColumns(10);		
    }
}
