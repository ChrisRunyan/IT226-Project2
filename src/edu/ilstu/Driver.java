package edu.ilstu;
import javax.swing.JFrame;

/**
 * @author Kevin
 *
 */
public class Driver {
	public static void main(String[] args) {
		GUI newGUI = new GUI();
		newGUI.setTitle("Alarm");
		newGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newGUI.setSize(900, 500);
		newGUI.setVisible(true);
	}
}
