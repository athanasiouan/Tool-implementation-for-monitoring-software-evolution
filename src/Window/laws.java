package Window;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
public class laws extends JFrame {
	
	private Parser p = new Parser();
		
    public void init(String path) {
        if(p.init(path) == true){
        	this.setVisible(true);
        }
        setTitle("Laws' Evaluation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnLaw1 = new JButton("1st Law");
        btnLaw1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(1);
        	dispose();
        }});;
        btnLaw1.setBounds(10, 11, 102, 23);
        contentPane.add(btnLaw1);
        
        JButton btnLaw2 = new JButton("2nd Law");
        btnLaw2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(2);
        	dispose();
        }});;
        btnLaw2.setBounds(10, 73, 102, 23);
        contentPane.add(btnLaw2);
		
        JButton btnLaw3 = new JButton("3rd Law");
        btnLaw3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(3);
        	dispose();
        }});;
        btnLaw3.setBounds(10, 133, 102, 23);
        contentPane.add(btnLaw3);
		
        JButton btnLaw4 = new JButton("4th Law");
        btnLaw4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(4);
        	dispose();
        }});;
        btnLaw4.setBounds(165, 11, 102, 23);
        contentPane.add(btnLaw4);
		
        JButton btnLaw5 = new JButton("5th Law");
        btnLaw5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(5);
        	dispose();
        }});;
        btnLaw5.setBounds(165, 73, 102, 23);
        contentPane.add(btnLaw5);
		
        JButton btnLaw6 = new JButton("6th Law");
        btnLaw6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(6);
        	dispose();
        }});;
        btnLaw6.setBounds(306, 11, 102, 23);
        contentPane.add(btnLaw6);
		
        JButton btnLaw7 = new JButton("7th Law");
        btnLaw7.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(7);
        	dispose();
        }});;
        btnLaw7.setBounds(306, 73, 102, 23);
        contentPane.add(btnLaw7);
		
        JButton btnLaw8 = new JButton("8th Law");
        btnLaw8.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(8);
        	dispose();
        }});;
        btnLaw8.setBounds(306, 133, 102, 23);
        contentPane.add(btnLaw8);
		
        JButton btnReport = new JButton("Report");
        btnReport.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
        	p.initLaw(9);
        	dispose();
        }});;
        btnReport.setBounds(130, 190, 170, 23);
        contentPane.add(btnReport);
    }
}
