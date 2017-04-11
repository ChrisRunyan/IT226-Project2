package edu.ilstu;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class GUIHelper extends JFrame {
	DataInput di = new DataInput();

	JPanel setAlarm1 = new JPanel();
	JPanel setAlarm2 = new JPanel();
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
	
	Alarm alarm=new Alarm();
	
	Boolean validInput=true;

	public GUIHelper(int promptNum) {
		if (promptNum == 1) {
			JPanel finalPanel=new JPanel();
			JPanel clockPanel=new JPanel();

			JLabel l1=new JLabel("Year (yyyy)");
			setAlarm1.add(l1);
			
			f1 = new JTextField();
			f1.setPreferredSize(nd);
			setAlarm1.add(f1);
			f1.addKeyListener(new KeyActionListener());

			JLabel l2=new JLabel("Month (mm)");
			setAlarm1.add(l2);
			
			f2 = new JTextField();
			f2.setPreferredSize(nd);
			setAlarm1.add(f2);
			f2.addKeyListener(new KeyActionListener());

			JLabel l3=new JLabel("Day (dd)");
			setAlarm1.add(l3);
			
			f3 = new JTextField();
			f3.setPreferredSize(nd);
			setAlarm1.add(f3);
			f3.addKeyListener(new KeyActionListener());

			JLabel l4=new JLabel("Hour (24)");
			setAlarm2.add(l4);
			
			f4 = new JTextField();
			f4.setPreferredSize(nd);
			setAlarm2.add(f4);
			f4.addKeyListener(new KeyActionListener());

			JLabel l5=new JLabel("Minute (60)");
			setAlarm2.add(l5);
			
			f5 = new JTextField();
			f5.setPreferredSize(nd);
			setAlarm2.add(f5);
			f5.addKeyListener(new KeyActionListener());

			alarmButton.setText("Save Alarm");
			setAlarm2.add(alarmButton);
			alarmButton.addActionListener(new KeyActionListener());

			finalPanel.add(clock.showClock(clockPanel));
			finalPanel.add(setAlarm1);
			finalPanel.add(setAlarm2);
			
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
			JPanel clockPanel=new JPanel();

			arrayOfAlarms = new JButton[GUIHelper.alarmLinkedList.size()];

			delete.add(clock.showClock(clockPanel));
			
			for (int i = 0; i < GUIHelper.alarmLinkedList.size(); i++) {
				arrayOfAlarms[i] = new JButton();
				arrayOfAlarms[i].setPreferredSize(new Dimension(250, 50));

				arrayOfAlarms[i].setText("Delete "+GUIHelper.alarmLinkedList.get(i).toString());

				delete.add(arrayOfAlarms[i]);

				arrayOfAlarms[i].addActionListener(new KeyActionListener());

				add(delete);
			}
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
				if(di.year.equals("")){
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "You must enter a year.");
					validInput=false;
				}
				if(di.month.equals("")){
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "You must enter a month.");
					validInput=false;
				}
				if(di.day.equals("")){
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "You must enter a day.");
					validInput=false;
				}
				if(di.hour.equals("")){
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "You must enter an hour.");
					validInput=false;
				}
				if(di.minute.equals("")){
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "You must enter a minute.");
					validInput=false;
				}
				if(!di.month.equals("")){
					if(Integer.parseInt(di.month)>12){
						JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame, "Month not possible.");
						validInput=false;
					}
				}
				if(!di.day.equals("")){
					if(Integer.parseInt(di.day)>31){
						JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame, "Day not possible.");
						validInput=false;
					}
				}
				if(!di.hour.equals("")){
					if(Integer.parseInt(di.hour)>24){
						JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame, "Hour not possible.");
						validInput=false;
					}
				}
				if(!di.minute.equals("")){
					if(Integer.parseInt(di.minute)>59){
						JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame, "Minute not possible.");
						validInput=false;
					}
				}
				if(validInput){
					alarm.setAlarm(di.year, di.month, di.day, di.hour, di.minute);
					alarmLinkedList.add(alarm);
					alarm.saveData(GUIHelper.alarmLinkedList);
				}
				dispose();
			}
			if (event.getActionCommand() == "Set Timer") {
				if(di.timer.equals("")){
					JFrame frame=new JFrame();
					JOptionPane.showMessageDialog(frame, "You must enter a number.");
					validInput=false;
				}
				if(!di.timer.equals("")){
					if(Integer.parseInt(di.timer)>300){
						JFrame frame=new JFrame();
						JOptionPane.showMessageDialog(frame, "Maximum number of minutes allowed is 300.");
						validInput=false;
					}
				}
				if(validInput){
					alarm.setTimer(di.timer, true);
					alarmLinkedList.add(alarm);
					alarm.saveData(GUIHelper.alarmLinkedList);
				}
				dispose();
			}
			for (int i = 0; i < GUIHelper.alarmLinkedList.size(); i++) {
				String s = "Delete " + GUIHelper.alarmLinkedList.get(i).toString();

				if (s.equals(event.getActionCommand())) {
					GUIHelper.alarmLinkedList.remove(i);
					alarm.saveData(GUIHelper.alarmLinkedList);
					dispose();
				}
			}
		}
	}
}
