package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sixthLaw extends JFrame {
	
	private JCheckBox btnValid, btnNotValid;
    
    public sixthLaw(int [] operation, int [] data, History h) {
		setTitle("Sixth Law");
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLayout(new BorderLayout());
	    
	    //Charts
	    JPanel charts = new JPanel();
	    charts.setLayout(new GridLayout(1, 2));
	    
	    //Buttons
	    JPanel buttons = new JPanel();
	    buttons.setLayout(new FlowLayout());
	    
	    //create charts
	    JFreeChart lineChart1 = ChartFactory.createLineChart("Operations Number", "Version ID", "Number of Operations", createDataset(operation),PlotOrientation.VERTICAL, false, true, false);
	    JFreeChart lineChart2 = ChartFactory.createLineChart("Data Structures Number", "Version ID", "Number of Data Structures", createDataset(data),PlotOrientation.VERTICAL, false, true, false);
	    
	    ChartPanel chartPanel1 = new ChartPanel(lineChart1);
	    ChartPanel chartPanel2 = new ChartPanel(lineChart2);
	    
	    chartPanel1.setPreferredSize(new java.awt.Dimension(350, 350));
	    chartPanel2.setPreferredSize(new java.awt.Dimension(350, 350));
	    // add to contentPane
	    charts.add(chartPanel1);
	    charts.add(chartPanel2);
	    add(charts, BorderLayout.CENTER);
	    
	    JButton btnComment = new JButton("Comments");
        btnComment.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            comment c = new comment(h, 5);
            c.setVisible(true);
        }});
        btnNotValid = new JCheckBox("Not Valid");
        btnNotValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(5, false);
            btnValid.setSelected(false);
        }});
        
        btnValid = new JCheckBox("Valid");
        btnValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(5, true);
            btnNotValid.setSelected(false);
        }});
	           
	    buttons.add(btnValid);
	    buttons.add(btnNotValid);
	    buttons.add(btnComment);
	    
	    add(buttons, BorderLayout.SOUTH);
    }
    
    private CategoryDataset createDataset(int [] temp) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < temp.length ; i++){
        	dataset.addValue(temp[i], "1", String.valueOf(i + 1));
        }
        return dataset;  
    }    
}