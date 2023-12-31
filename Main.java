package com.sf.main;

import java.awt.AWTException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private boolean isOn; 
	private KeyboardHandler kh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Street Fighter Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Turn on Keylog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!isOn) {
					// start engine
					try {
						kh = new KeyboardHandler();
						kh.run();
					} catch (AWTException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				}
				isOn = true;
			}
		});
		btnNewButton.setBounds(143, 130, 140, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
