package com.sf.main;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DriveImpactCol {
	/*
	juri color codes
	completely black (0,0,0)
	
 	rectangle
 	
 	xi, yi: 
 	x: 416-2049
 	y: 342-973
 	
 	xi: 416
 	width: 1633
 	
 	yi: 342
 	height: 631
 	
	 * */
	private int x1;
	private int x2;
	
	private int y1;
	private int y2;
	private int blackPixelThreshold;
	private static JLabel label;
	static JFrame frame = new JFrame("Screenshot");
	public DriveImpactCol() {
		x1 = 416;
		y1 = 342; 
		x2 = 2049;
		y2 = 973;
		
		blackPixelThreshold=500;
	}
	public boolean isSufficientBlackPixels() throws AWTException {
	    Robot robot = new Robot();
	    BufferedImage screenshot = robot.createScreenCapture(new Rectangle(x1, y1, x2 - x1, y2 - y1));

	    int blackPixelCount = 0;
	    for (int y = 0; y < screenshot.getHeight(); y += 2) {
	        for (int x = 0; x < screenshot.getWidth(); x += 2) {
	            int rgb = screenshot.getRGB(x, y);

	            int red = (rgb >> 16) & 0xFF;
	            int green = (rgb >> 8) & 0xFF;
	            int blue = rgb & 0xFF;

	            if (red == 0 && green == 0 && blue == 0) {
	                blackPixelCount++;
	                
	            }
	        }
	    }
	    if(blackPixelCount>15000) {
	    	System.out.println(blackPixelCount);
	    }
	    // Check if black pixel count is within the specified range
	    return blackPixelCount >= 8000;
	}


}
