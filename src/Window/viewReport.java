package Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class viewReport extends JFrame{
	
    public viewReport(){}
	
	public viewReport(History h) {
		setTitle("View Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 807, 412);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String temp = h.getReport();
		JTextArea textField = new JTextArea();
		textField.setText(temp);
		textField.setBounds(10, 41, 754, 235);
		contentPane.add(textField);
		textField.setColumns(10);		
    } 

}
