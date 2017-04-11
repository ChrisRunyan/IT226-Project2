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
			for(int i=0; i<GUIHelper.alarmLinkedList.size(); i++){
				alarm.scheduleAlarm();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		newGUI.setTitle("Alarm");
		newGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newGUI.setSize(640, 360);
		newGUI.setVisible(true);
		newGUI.setResizable(false);
	}
}
