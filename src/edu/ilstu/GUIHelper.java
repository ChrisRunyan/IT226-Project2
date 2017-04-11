package edu.ilstu;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class GUIHelper extends JFrame {
	DataInput di = new DataInput();

	JPanel setAlarm = new JPanel();
	JPanel setTimer = new JPanel();
	JPanel delete = new JPanel();

	JTextField f1, f2, f3, f4, f5, f6;

	JFrame alarmFrame = new JFrame();
	JFrame timerFrame = new JFrame();
	JFrame deleteFrame = new JFrame();

	JButton[] arrayOfAlarms;

	JButton alarmButton = new JButton();
	JButton timerButton = new JButton();

	Dimension nd = new Dimension(100, 25);
	
	static LinkedList<Alarm> alarmLinkedList=new LinkedList<Alarm>();
	
	ShowClock clock=new ShowClock();

	public GUIHelper(int promptNum) {
		if (promptNum == 1) {
			JPanel finalPanel=new JPanel();
			JPanel clockPanel=new JPanel();

			f1 = new JTextField("Year (yyyy)");
			f1.setPreferredSize(nd);
			setAlarm.add(f1);
			f1.addKeyListener(new KeyActionListener());

			f2 = new JTextField("Month (mm)");
			f2.setPreferredSize(nd);
			setAlarm.add(f2);
			f2.addKeyListener(new KeyActionListener());

			f3 = new JTextField("Day (dd)");
			f3.setPreferredSize(nd);
			setAlarm.add(f3);
			f3.addKeyListener(new KeyActionListener());

			f4 = new JTextField("Hour (24)");
			f4.setPreferredSize(nd);
			setAlarm.add(f4);
			f4.addKeyListener(new KeyActionListener());

			f5 = new JTextField("Minute (60)");
			f5.setPreferredSize(nd);
			setAlarm.add(f5);
			f5.addKeyListener(new KeyActionListener());

			alarmButton.setText("Save Alarm");
			setAlarm.add(alarmButton);
			alarmButton.addActionListener(new KeyActionListener());

			finalPanel.add(clock.showClock(clockPanel));
			finalPanel.add(setAlarm);
			finalPanel.add(setAlarm);
			
			add(finalPanel);
			//**Set alarm
		}
		if (promptNum == 2) {
			JPanel finalPanel=new JPanel();
			JPanel clockPanel=new JPanel();

			JLabel l1 = new JLabel();
			setTimer.add(l1);
			l1.setText("Enter time (minutes):");
			f6 = new JTextField("");
			f6.setPreferredSize(nd);
			setTimer.add(f6);

			f6.addKeyListener(new KeyActionListener());

			timerButton.setText("Set Timer");
			setTimer.add(timerButton);
			timerButton.addActionListener(new KeyActionListener());

			finalPanel.add(clock.showClock(clockPanel));
			finalPanel.add(setTimer);
			
			add(finalPanel);
			//**Set timer
		}
		if (promptNum == 3) {
			deleteFrame.getContentPane().add(delete);

			arrayOfAlarms = new JButton[10];

			/*
			 * 
			 * 
			 * for "i < 5" , the 5 should be changed to the amount of alarms and
			 * timers we have.
			 * 
			 * for "LINKED LIST" it should print out a list of the
			 * alarms/timers.
			 * 
			 */
			for (int i = 0; i < 5; i++) {
				arrayOfAlarms[i] = new JButton();

				arrayOfAlarms[i].setText("Alarm " + (i + 1) + " - " + "LINKED LIST");

				delete.add(arrayOfAlarms[i]);

				arrayOfAlarms[i].addActionListener(new KeyActionListener());

				getContentPane().add(delete);
			}
			//**Delete alarm associated with i and close
		}
	}
	
	class KeyActionListener implements KeyListener, ActionListener {

		// String year, month, day, hour, minute = "";
		String minute = "hi";

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				if (e.getSource().equals(f1)) {

					di.resetYear();
					f1.setText("");

				} else if (e.getSource().equals(f2)) {

					di.resetMonth();
					f2.setText("");

				} else if (e.getSource().equals(f3)) {

					di.resetDay();
					f3.setText("");

				} else if (e.getSource().equals(f4)) {

					di.resetHour();
					f4.setText("");

				} else if (e.getSource().equals(f5)) {

					di.resetMinute();
					f5.setText("");

				} else if (e.getSource().equals(f6)) {

					di.resetTimer();
					f6.setText("");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		public void keyTyped(KeyEvent e) {
			if (e.getSource().equals(f1)) {
				di.setYear(e.getKeyChar());

			} else if (e.getSource().equals(f2)) {
				di.setMonth(e.getKeyChar());

			} else if (e.getSource().equals(f3)) {
				di.setDay(e.getKeyChar());

			} else if (e.getSource().equals(f4)) {
				di.setHour(e.getKeyChar());

			} else if (e.getSource().equals(f5)) {
				di.setMinute(e.getKeyChar());

			} else if (e.getSource().equals(f6)) {
				di.setTimerInMinutes(e.getKeyChar());
			}
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "Save Alarm") {
				Alarm alarm=new Alarm();
				alarm.setAlarm(di.day, di.month, di.day, di.hour, di.minute);
				alarmLinkedList.add(alarm);
				System.out.println(di.dateToString());
				dispose();
			}
			if (event.getActionCommand() == "Set Timer") {
				System.out.println(di.timerToString());
				dispose();
			}
			if (event.getActionCommand() == "Delete") {
				System.out.println("DELETE");
				dispose();
			}

			/*
			 * for "i < 6" , 6 should be the length of the linked list of alarms
			 * and timers + 1
			 */
			for (int i = 0; i < 6; i++) {
				String s = "Alarm " + (i + 1) + " - " + "LINKED LIST";

				if (s.equals(event.getActionCommand())) {
					System.out.println("Delete Timer " + (i + 1));

					/*
					 * 
					 * CODE TO DELETE ALARM/TIMER FROM LINKED LIST
					 * 
					 */
				}
			}
		}
	}
}
