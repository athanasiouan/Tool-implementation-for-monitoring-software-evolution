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

public class secondLaw extends JFrame {
	
	private JCheckBox btnValid, btnNotValid;

    public secondLaw(int [] maintenance, float [] operationComplexity, float [] dataComplexity, History h) {
        setTitle("Second Law");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //Charts
        JPanel charts = new JPanel();
        charts.setLayout(new GridLayout(1, 3));
        
        //Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        //create charts
        JFreeChart barChart1 = ChartFactory.createBarChart("Maintenance Actions", "Version ID", "Number of Actions", createDataset1(maintenance),PlotOrientation.VERTICAL, false, true, false);
        JFreeChart lineChart1 = ChartFactory.createLineChart("Operations Complexity", "Version ID", "Complexity", createDataset(operationComplexity),PlotOrientation.VERTICAL, false, true, false);
        JFreeChart lineChart2 = ChartFactory.createLineChart("Data Structures Complexity", "Version ID", "Complexity", createDataset(dataComplexity),PlotOrientation.VERTICAL, false, true, false);
        
        ChartPanel chartPanel = new ChartPanel(barChart1);
        ChartPanel chartPanel2 = new ChartPanel(lineChart1);
        ChartPanel chartPanel3 = new ChartPanel(lineChart2);
        
        chartPanel.setPreferredSize(new java.awt.Dimension(350, 350));
        chartPanel2.setPreferredSize(new java.awt.Dimension(350, 350));
        chartPanel3.setPreferredSize(new java.awt.Dimension(350, 350));
        // add to contentPane
        charts.add(chartPanel);
        charts.add(chartPanel2);
        charts.add(chartPanel3);
        add(charts, BorderLayout.CENTER);
        
        JButton btnComment = new JButton("Comments");
        btnComment.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            comment c = new comment(h, 1);
            c.setVisible(true);
        }});;
        btnNotValid = new JCheckBox("Not Valid");
        btnNotValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(1, false);
            btnValid.setSelected(false);
        }});
        
        btnValid = new JCheckBox("Valid");
        btnValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(1, true);
            btnNotValid.setSelected(false);
        }});
               
        buttons.add(btnValid);
        buttons.add(btnNotValid);
        buttons.add(btnComment);
        
        add(buttons, BorderLayout.SOUTH);
    }
    
    private CategoryDataset createDataset1(int [] temp) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < temp.length ; i++){
        	dataset.addValue(temp[i], "1", String.valueOf(i + 1));
        }
        return dataset;  
    }
    private CategoryDataset createDataset(float [] temp) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < temp.length ; i++){
        	dataset.addValue(temp[i], "1", String.valueOf(i + 1));
        }
        return dataset;  
    }    
}
