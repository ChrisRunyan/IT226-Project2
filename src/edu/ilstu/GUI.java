package edu.ilstu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
	JPanel topPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel finalPanel = new JPanel();
	
	JButton addAlarm = new JButton();
	JButton addTimer = new JButton();
	JButton delete = new JButton();
	
	static JTextArea showAlarms=new JTextArea();
	static JTextArea showTimers=new JTextArea();
	
	GUIHelper addAlarmGUI = new GUIHelper(1);
	GUIHelper addTimerGUI = new GUIHelper(2);
	GUIHelper deleteGUI = new GUIHelper(3);
	
	public GUI() {
		//what is added to the JFrame
		finalPanel.setLayout(new GridLayout(2, 1, 5, 5));
		
		//two panels that go into finalPanel
		topPanel.setLayout(new GridLayout(1, 3, 5, 5));
		centerPanel.setLayout(new GridLayout(1, 2, 5, 5));
		
		//for top panel
		addAlarm.setText("Add an Alarm");
		topPanel.add(addAlarm);
		addAlarm.addActionListener(new ActionListener1());

		addTimer.setText("Add a Timer");
		topPanel.add(addTimer);
		addTimer.addActionListener(new ActionListener1());

		delete.setText("Delete a Timer/Alarm");
		topPanel.add(delete);
		delete.addActionListener(new ActionListener1());
		
		//for center panel
		showAlarms.setText("Current Alarms:\n");
		centerPanel.add(showAlarms);
		showAlarms.setEditable(false);
//		showAlarms.setFont(getFont().deriveFont(4.0f));
		
		showTimers.setText("Current Timers:\n");
		centerPanel.add(showTimers);
		showTimers.setEditable(false);
//		showTimers.setFont(getFont().deriveFont(4.0f));
		
		finalPanel.add(topPanel);
		finalPanel.add(centerPanel);
		add(finalPanel);
	}

	class ActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "Add an Alarm") {
				addAlarmGUI.setTitle("Add an Alarm");
				addAlarmGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addAlarmGUI.setSize(150, 300);
				addAlarmGUI.setVisible(true);
			}
			if (event.getActionCommand() == "Add a Timer") {
				addTimerGUI.setTitle("Add a Timer");
				addTimerGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addTimerGUI.setSize(150, 300);
				addTimerGUI.setVisible(true);
			}
			if (event.getActionCommand() == "Delete a Timer/Alarm") {
				deleteGUI.setTitle("Delete");
				deleteGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				deleteGUI.setSize(150, 300);
				deleteGUI.setVisible(true);
			}
		}
	}
}
