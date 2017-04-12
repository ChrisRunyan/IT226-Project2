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
			StringBuilder sbAlarms=new StringBuilder();
			sbAlarms.append("Current Alarms:\n");
			for(int i=0; i<GUIHelper.alarmLinkedList.size(); i++){
				GUIHelper.alarmLinkedList.get(i).scheduleAlarm();
				sbAlarms.append(GUIHelper.alarmLinkedList.get(i).toString()+"\n");
			}
			GUI.showAlarms.setFont(GUI.showAlarms.getFont().deriveFont(16f));
			GUI.showAlarms.setText(sbAlarms.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		newGUI.setTitle("Alarm");
		newGUI.setSize(640, 360);
		newGUI.setVisible(true);
		newGUI.setResizable(false);
		newGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
