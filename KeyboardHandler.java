package com.sf.main;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.fortnitemaincheats.KeyHandler;

public class KeyboardHandler implements NativeKeyListener{
	private HandleOutputs ho;
	private boolean isFacingRight;
	private Timer combo1; 
	private Timer combo2;
	public KeyboardHandler() throws AWTException {
		ho = new HandleOutputs();
		combo1 = new Timer(5,(ActionEvent e)->{
			
			try {
				ho.performString("Combo1");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		});
		combo2 = new Timer(250,(ActionEvent e)->{

		});
		
		
		
	}
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		
		// finds direction
		if(arg0.getKeyCode()==NativeKeyEvent.VC_D) {
			isFacingRight = true;
		}
		if(arg0.getKeyCode()==NativeKeyEvent.VC_A) {
			isFacingRight = false;
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
				ho.performCombo("Killer Bee Spin", isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_3) {
			System.out.println("TOUCH 3");
			try {
				ho.performCombo("Delta Red Assault",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_E) {
			System.out.println("TOUCH E");
			try {
				ho.performCombo("Spiral Arrow",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_Q) {
			System.out.println("TOUCH Q");
			try {
				ho.performCombo("Quick Spin Knuckle",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(arg0.getKeyCode() == NativeKeyEvent.VC_Z) {
			System.out.println("TOUCH Z");
			try {
				ho.performCombo("Combo3",isFacingRight);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// strings, use timer to prevent constant repetition
		if(arg0.getKeyCode() == NativeKeyEvent.VC_CONTROL_L) {
			combo1.start();
			System.out.println(combo1);
			
		}
		if(arg0.getKeyCode() == NativeKeyEvent.VC_SHIFT_L) {
			combo2.start();
		}
	}
	public void test() {
		
		
	}
	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == NativeKeyEvent.VC_CONTROL_L) {
			combo1.stop();
		}
		if(arg0.getKeyCode() == NativeKeyEvent.VC_SHIFT_L) {
			combo2.stop();
		}
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
	public static void run() throws AWTException {
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
