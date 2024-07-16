package com.sf.main;

import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.Timer;

public class KeyboardHandler implements NativeKeyListener {
	private HandleOutputs ho;
	private boolean isFacingRight;
	private boolean canChangeDir;
	private boolean toggledOn;
	private Timer combo1; 
	private Timer combo2;
	
	private DriveImpactCol dc;
	
	private static ArrowDisplay ad;
	
	public KeyboardHandler() throws AWTException {
		toggledOn = true;
		canChangeDir = true;
		ho = new HandleOutputs();
		dc = new DriveImpactCol();
		
		
		combo1 = new Timer(5,(ActionEvent e)->{
	
			try {
				
				if(dc.isSufficientBlackPixels()) {
					// perform drive impact
					ho.performCombo("DriveImpact",true);
				}
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		combo1.start();
//		combo2 = new Timer(250,(ActionEvent e)->{
//			try {
//				ho.performString("CommandGrab");
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});
//		
		
		
	}
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		if(arg0.getKeyCode()==NativeKeyEvent.VC_F8) {
			toggledOn = !toggledOn;
			System.out.println("ToggledOn status: "+toggledOn);
			
		}
		
		if(toggledOn) {
			combo1.start();
		} else {
			combo1.stop();
			return;
		}
		
		if(arg0.getKeyCode()==NativeKeyEvent.VC_0) {
			canChangeDir = false;	
			System.out.println("CAN'T CHANGE DIR");
		}
		if(arg0.getKeyCode()==NativeKeyEvent.VC_9) {
			canChangeDir = true;
			System.out.println("CAN CHANGE DIR");
		}
		
		/*
Send, {0 down}
Send, {0 up}
Send, {9 down}
Send, {9 up}
		 * */
		if(!toggledOn | !canChangeDir) {
			return;
		}
		
		
		// finds direction
		if(arg0.getKeyCode()==NativeKeyEvent.VC_D && canChangeDir) {
			isFacingRight = true;
			System.out.println("IS FACING RIGHT");
		}
		if(arg0.getKeyCode()==NativeKeyEvent.VC_A && canChangeDir) {
			isFacingRight = false;
			System.out.println("IS FACING LEFT");
		}

		
		// start of combos
		if(arg0.getKeyCode() == NativeKeyEvent.VC_1) {
			System.out.println("TOUCH");
			try {
				ho.performCombo("Spin Dive Smasher",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_2) {
			System.out.println("TOUCH 2");
			try {
				ho.performCombo("Delta Red Assault",isFacingRight);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_3) {
			System.out.println("TOUCH 3");
			try {
				ho.performCombo("Bolshoi Storm Buster", isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_E) {
			System.out.println("TOUCH E");
			try {
				ho.performCombo("Screw Piledriver",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_Q) {
			System.out.println("TOUCH Q");
			try {
				ho.performCombo("CommandGrab",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_Z) {
			System.out.println("TOUCH Z");
			try {
				
				ho.performCombo("Quick Spin Knuckle",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_M) {
			System.out.println("Touch left");
			try {
				ho.performCombo("CommandGrab",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_C) {
			System.out.println("Touch C");
			try {
				ho.performCombo("JumpGrab",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		


	}
	public void test() {
		
		
	}
	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {

//		if(arg0.getKeyCode() == NativeKeyEvent.VC_SHIFT_L) {
//			combo2.stop();
//		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
	public static void run() throws AWTException {
		ad = new ArrowDisplay();	
		GlobalScreen.addNativeKeyListener(new KeyboardHandler());
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {}
	}


}
