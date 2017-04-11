package edu.ilstu;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

/**
 * @author Kevin Haas, Christopher Runyan
 *
 */
public class Driver {
	public static void main(String[] args) {
		GUI newGUI = new GUI();
		Alarm alarm=new Alarm();
				
		try {
			alarm.readData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		newGUI.setTitle("Alarm");
		newGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newGUI.setSize(640, 360);
//		newGUI.setSize(650, 400);
		newGUI.setVisible(true);
		newGUI.setResizable(false);
	}
}
