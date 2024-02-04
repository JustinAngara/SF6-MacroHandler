package com.sf.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArrowDisplay {

    public JFrame frame;
    private JLabel arrowLabel;  // Use a single JLabel
    private String leftArrow = "C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\left_arrow.png";
    private String rightArrow = "C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\right_arrow.png";
    Icon icon;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrowDisplay window = new ArrowDisplay();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ArrowDisplay() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(0, 0, 2560, 1440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);

        

		icon = new ImageIcon(rightArrow);
		
		arrowLabel = new JLabel();  
		arrowLabel = new JLabel(icon);
		arrowLabel.setBounds(0, 0, 2560, 1440);

        
        frame.getContentPane().add(arrowLabel);
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setFocusable(false);

    }
    public void updateIcon(String d) {
    	if(d.equals("left")) {
    		icon = new ImageIcon(leftArrow);
    	} else {
    		icon = new ImageIcon(rightArrow);
    	}
    }
}
