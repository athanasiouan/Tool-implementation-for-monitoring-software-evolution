package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class startWindow extends JFrame {
    private ActionListener choose = createChoiceAction();
    private JPanel contentPane;
    private JButton btnCancel,btnBrowse, btnOk;
    private JTextField txtSelectAFile;
    private laws l = new laws();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    startWindow frame = new startWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public startWindow() {
        setTitle("Software Evolution Monitor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        btnOk = new JButton("OK");
        btnOk.addActionListener(choose);
        btnOk.setBounds(208, 220, 100, 31);
        contentPane.add(btnOk);
        
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(choose);
        btnCancel.setBounds(314, 220, 100, 31);
        contentPane.add(btnCancel);
		
        txtSelectAFile = new JTextField();
        txtSelectAFile.setText("Select a file...");
        txtSelectAFile.setBounds(10, 76, 225, 20);
        contentPane.add(txtSelectAFile);
        txtSelectAFile.setColumns(10);
		
        btnBrowse = new JButton("Browse");
        btnBrowse.addActionListener(choose);
        btnBrowse.setBounds(249, 76, 100, 20);
        contentPane.add(btnBrowse);
		
    }
	
    private ActionListener createChoiceAction() {
        ActionListener choose = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnCancel){
                    System.exit(0);
                }
                if(e.getSource() == btnOk){
                    errorFile er = new errorFile();
                    er.setVisible(true);
                }
                if(e.getSource() == btnBrowse){
                    JFileChooser chooser = new JFileChooser();
                    chooser.setCurrentDirectory(new java.io.File("."));
                    chooser.setDialogTitle("Choose a File:");
                    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    chooser.setAcceptAllFileFilterUsed(false);
                    FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt files", "txt");
                    chooser.setFileFilter(filter);
                    if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        l.init(chooser.getSelectedFile().getAbsolutePath());
                    }
                }
            }
        };
        return choose;
    }
}
