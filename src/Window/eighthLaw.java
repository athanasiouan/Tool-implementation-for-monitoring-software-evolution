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

public class eighthLaw extends JFrame {
	
	private JCheckBox btnValid, btnNotValid;

    public eighthLaw(){}
	
	public eighthLaw(int[] operation, double[] estimation, History h) {
		setTitle("Eighth Law");
	    setLayout(new BorderLayout());
	    
	    //Charts
	    JPanel charts = new JPanel();
	    charts.setLayout(new GridLayout(1, 1));
	    
	    //Buttons
	    JPanel buttons = new JPanel();
	    buttons.setLayout(new FlowLayout());
        
	    //create charts
	    JFreeChart lineChart = ChartFactory.createLineChart("Number of Operations Estimations", "Version ID", "Number of Operations", createDataset(operation, estimation),PlotOrientation.VERTICAL, true, true, false);
	    
	    ChartPanel chartPanel = new ChartPanel(lineChart);
	    
	    // add to contentPane
	    charts.add(chartPanel);
	    add(charts, BorderLayout.CENTER);
	    
	    JButton btnComment = new JButton("Comments");
        btnComment.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            comment c = new comment(h, 7);
            c.setVisible(true);
        }});
        btnNotValid = new JCheckBox("Not Valid");
        btnNotValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(7, false);
            btnValid.setSelected(false);
        }});
        
        btnValid = new JCheckBox("Valid");
        btnValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(7, true);
            btnNotValid.setSelected(false);
        }});
	           
	    buttons.add(btnValid);
	    buttons.add(btnNotValid);
	    buttons.add(btnComment);
	    
	    add(buttons, BorderLayout.SOUTH);
    }
	
    private CategoryDataset createDataset(int [] temp1, double [] temp2) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < temp1.length ; i++){
        	dataset.addValue(temp1[i], "Actual Operations", String.valueOf(i + 1));
        	dataset.addValue(temp2[i], "Estimated Operations", String.valueOf(i + 1));
        }
        return dataset;  
    }
	
}
