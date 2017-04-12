package edu.ilstu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Kevin Haas, Christopher Runyan
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
	JPanel topPanel = new JPanel();
	JPanel middlePanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel finalPanel = new JPanel();
	
	JButton addAlarm = new JButton();
	JButton addTimer = new JButton();
	JButton delete = new JButton();
	
	static JTextArea showAlarms=new JTextArea();
	
	public GUI() {
		//what is added to the JFrame
		finalPanel.setLayout(new GridLayout(2, 1, 5, 5));
		
		//two panels that go into finalPanel
		middlePanel.setLayout(new GridLayout(1, 3, 5, 5));
		bottomPanel.setLayout(new GridLayout(1, 2, 5, 5));
		
		//for top panel
		addAlarm.setText("Add an Alarm");
		addAlarm.setFont(addAlarm.getFont().deriveFont(18f));
		middlePanel.add(addAlarm);
		addAlarm.addActionListener(new ActionListener1());

		addTimer.setText("Add a Timer");
		addTimer.setFont(addTimer.getFont().deriveFont(18f));
		middlePanel.add(addTimer);
		addTimer.addActionListener(new ActionListener1());

		delete.setText("<html>Delete a Timer<br />or Alarm</html>");
		delete.setFont(delete.getFont().deriveFont(18f));
		middlePanel.add(delete);
		delete.addActionListener(new ActionListener1());
		
		//for center panel
		showAlarms.setText("Current Alarms:\n");
		bottomPanel.add(showAlarms);
		showAlarms.setEditable(false);
		for(int i=0; i<GUIHelper.alarmLinkedList.size(); i++){
			if(GUIHelper.alarmLinkedList.get(i).timer==false){
				showAlarms.setText(GUIHelper.alarmLinkedList.get(i).toString());
			}
		}
		
		finalPanel.add(middlePanel);
		finalPanel.add(bottomPanel);
		add(finalPanel);
	}

	class ActionListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "Add an Alarm") {
				GUIHelper addAlarmGUI = new GUIHelper(1);
				addAlarmGUI.setTitle("Add an Alarm");
				addAlarmGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addAlarmGUI.setSize(700, 225);
				addAlarmGUI.setVisible(true);
				addAlarmGUI.setResizable(false);
			}
			if (event.getActionCommand() == "Add a Timer") {
				GUIHelper addTimerGUI = new GUIHelper(2);
				addTimerGUI.setTitle("Add a Timer");
				addTimerGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addTimerGUI.setSize(600, 175);
				addTimerGUI.setVisible(true);
				addTimerGUI.setResizable(false);
			}
			if (event.getActionCommand() == "<html>Delete a Timer<br />or Alarm</html>") {
				double size=(double)GUIHelper.alarmLinkedList.size()/2;
				
				if(size%0.5==0){
					size+=0.5;
				}
				
				GUIHelper deleteGUI = new GUIHelper(3);
				deleteGUI.setTitle("Delete");
				deleteGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				deleteGUI.setSize(550, (125+(70*(int)size)));
				deleteGUI.setVisible(true);
				deleteGUI.setResizable(false);
			}
		}
	}
}
