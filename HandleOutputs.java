package com.sf.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class HandleOutputs {
	private Robot bot;
	private Random rn;
	private Runtime runtime;
	public HandleOutputs() throws AWTException {
		bot = new Robot();
		rn = new Random();
		runtime = Runtime.getRuntime();
	}
	
	public void delay() {
		int max = 8;
		int min = 2;
		
		bot.delay(100);
	}

	// with direction
	public void performCombo(String t, boolean d) throws IOException {
		if(d) {
			re(t);
		} else {
			re("L"+t);
		}
	}
	
	// without direction
	public void performString(String t) throws IOException {
		re(t);
	}

	public void re(String s) throws IOException {
		String fileLoc = "C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\src\\com\\autoexec files\\"+s+".ahk";
	    String ahkPath = "C:\\Program Files\\AutoHotkey\\AutoHotkey.exe";

	    runtime.exec(new String[] { ahkPath, fileLoc} );
	    Thread.currentThread();
	    delay();
	}
}
