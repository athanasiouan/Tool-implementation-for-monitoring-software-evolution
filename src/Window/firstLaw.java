package Window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class firstLaw extends JFrame {

	private JCheckBox btnValid, btnNotValid;
	
    public firstLaw(int [] numOfOperation, int [] numOfData, int [] counter, int min, int max, History h) {
        setTitle("First Law");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //Charts
        JPanel charts = new JPanel();
        charts.setLayout(new GridLayout(1, 3));
        
        //Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        
        //create charts
        JFreeChart barChart1 = ChartFactory.createBarChart("Operation Changes", "Version ID", "Number of Changes", createDataset1(numOfOperation),PlotOrientation.VERTICAL, false, true, false);
        JFreeChart barChart2 = ChartFactory.createBarChart("Data Structure Changes", "Version ID", "Number of Changes", createDataset1(numOfData),PlotOrientation.VERTICAL, false, true, false);
        JFreeChart barChart3 = ChartFactory.createBarChart("Versions per Year", "Year", "Number of Versions", createDataset(counter, max, min),PlotOrientation.VERTICAL, false, true, false);
        
        ChartPanel chartPanel = new ChartPanel(barChart1);
        ChartPanel chartPanel2 = new ChartPanel(barChart2);
        ChartPanel chartPanel3 = new ChartPanel(barChart3);
        
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
            comment c = new comment(h, 0);
            c.setVisible(true);
        }});
        
        btnNotValid = new JCheckBox("Not Valid");
        btnNotValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(0, false);
            btnValid.setSelected(false);
        }});
        
        btnValid = new JCheckBox("Valid");
        btnValid.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
        {
            h.setValid(0, true);
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
    private CategoryDataset createDataset(int [] temp, int max, int min) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int x = min;
        for(int i = 0 ; i < temp.length ; i++){
        	dataset.addValue(temp[i], "1", String.valueOf(x));
        	x++;
        }
        return dataset;  
    }
}