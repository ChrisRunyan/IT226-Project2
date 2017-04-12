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
 * @author Kevin Haas, Christopher Runyan
 */
@SuppressWarnings("serial")
public class GUIHelper extends JFrame {
	static DataInput di = new DataInput();

	JPanel setAlarm1 = new JPanel();
	JPanel setAlarm2 = new JPanel();
	JPanel setTimer = new JPanel();
	JPanel delete = new JPanel();

	JTextField f1, f2, f3, f4, f5, f6, fm;

	static JFrame alarmFrame = new JFrame();
	static JFrame timerFrame = new JFrame();
	static JFrame deleteFrame = new JFrame();

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
			
			JLabel lm=new JLabel("Message (optional)");
			setAlarm2.add(lm);
					
			fm = new JTextField();
			fm.setPreferredSize(nd);
			setAlarm2.add(fm);
			fm.addKeyListener(new KeyActionListener());

			alarmButton.setText("Save Alarm");
			setAlarm2.add(alarmButton);
			alarmButton.addActionListener(new KeyActionListener());

			finalPanel.add(clock.showClock(clockPanel));
			finalPanel.add(setAlarm1);
			finalPanel.add(setAlarm2);
			
			add(finalPanel);
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
			
			JLabel lm=new JLabel("Message (optional)");
			setTimer.add(lm);
					
			fm = new JTextField();
			fm.setPreferredSize(nd);
			setTimer.add(fm);
			fm.addKeyListener(new KeyActionListener());

			timerButton.setText("Set Timer");
			setTimer.add(timerButton);
			timerButton.addActionListener(new KeyActionListener());

			finalPanel.add(clock.showClock(clockPanel));
			finalPanel.add(setTimer);
			
			add(finalPanel);
		}
		if (promptNum == 3) {
			deleteFrame.getContentPane().add(delete);
			JPanel clockPanel=new JPanel();

			arrayOfAlarms = new JButton[GUIHelper.alarmLinkedList.size()];

			delete.add(clock.showClock(clockPanel));
			
			for (int i = 0; i < GUIHelper.alarmLinkedList.size(); i++) {
				arrayOfAlarms[i] = new JButton();
				arrayOfAlarms[i].setPreferredSize(new Dimension(250, 50));

				arrayOfAlarms[i].setText("Delete "+GUIHelper.alarmLinkedList.get(i).dateToString()+"  \""+GUIHelper.alarmLinkedList.get(i).message+"\"");

				delete.add(arrayOfAlarms[i]);

				arrayOfAlarms[i].addActionListener(new KeyActionListener());

				add(delete);
			}
		}
	}
	class KeyActionListener implements KeyListener, ActionListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE&&e.getKeyCode()!=16&&e.getKeyCode()!=9&&
					e.getKeyCode()!=13&&e.getKeyCode()!=17&&e.getKeyCode()!=18&&e.getKeyCode()!=19&&
					e.getKeyCode()!=20&&e.getKeyCode()!=27&&e.getKeyCode()!=32&&e.getKeyCode()!=33&&
					e.getKeyCode()!=34&&e.getKeyCode()!=35&&e.getKeyCode()!=36&&e.getKeyCode()!=37&&
					e.getKeyCode()!=38&&e.getKeyCode()!=39&&e.getKeyCode()!=40&&e.getKeyCode()!=45&&
					e.getKeyCode()!=46&&e.getKeyCode()!=106&&e.getKeyCode()!=107&&e.getKeyCode()!=109&&
					e.getKeyCode()!=110&&e.getKeyCode()!=111&&e.getKeyCode()!=112&&e.getKeyCode()!=113&&
					e.getKeyCode()!=114&&e.getKeyCode()!=115&&e.getKeyCode()!=116&&e.getKeyCode()!=117&&
					e.getKeyCode()!=118&&e.getKeyCode()!=119&&e.getKeyCode()!=120&&e.getKeyCode()!=121&&
					e.getKeyCode()!=122&&e.getKeyCode()!=123&&e.getKeyCode()!=144&&e.getKeyCode()!=145&&
					e.getKeyCode()!=186&&e.getKeyCode()!=187&&e.getKeyCode()!=188&&e.getKeyCode()!=189&&
					e.getKeyCode()!=190&&e.getKeyCode()!=191&&e.getKeyCode()!=192&&e.getKeyCode()!=219&&
					e.getKeyCode()!=220&&e.getKeyCode()!=221&&e.getKeyCode()!=222) {
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
				
				} else if (e.getSource().equals(fm)) {
					di.setMessage(e.getKeyChar());
				}
			}
			else if(e.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
				if (e.getSource().equals(f1)) {
					if(di.year.length()>0){
						di.setYear1(di.year.substring(0, di.year.length()-1));
					}
				
				} else if (e.getSource().equals(f2)) {
					if(di.month.length()>0){
						di.setMonth1(di.month.substring(0, di.month.length()-1));
					}
	
				} else if (e.getSource().equals(f3)) {
					if(di.day.length()>0){
						di.setDay1(di.day.substring(0, di.day.length()-1));
					}
	
				} else if (e.getSource().equals(f4)) {
					if(di.hour.length()>0){
						di.setHour1(di.hour.substring(0, di.hour.length()-1));
					}
	
				} else if (e.getSource().equals(f5)) {
					if(di.minute.length()>0){
						di.setMinute1(di.minute.substring(0, di.minute.length()-1));
					}
	
				} else if (e.getSource().equals(f6)) {
					if(di.timer.length()>0){
						di.setTimerInMinutes1(di.timer.substring(0, di.timer.length()-1));
					}
				
				} else if (e.getSource().equals(fm)) {
					if(di.message.length()>0){
						di.setMessage1(di.message.substring(0, di.message.length()-1));
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
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
					alarm.setAlarm(di.year, di.month, di.day, di.hour, di.minute, di.message);
					alarmLinkedList.add(alarm);
					alarm.saveData(GUIHelper.alarmLinkedList);
					alarm.scheduleAlarm();
					StringBuilder sbAlarms=new StringBuilder();
					sbAlarms.append("Current Alarms:\n");
					for(int i=0; i<GUIHelper.alarmLinkedList.size(); i++){
						GUIHelper.alarmLinkedList.get(i).scheduleAlarm();
						sbAlarms.append(GUIHelper.alarmLinkedList.get(i).toString()+"\n");
						GUI.showAlarms.setText(sbAlarms.toString());
					}
				}
				di.resetDay();
				di.resetHour();
				di.resetMessage();
				di.resetMinute();
				di.resetMonth();
				di.resetTimer();
				di.resetYear();
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
					alarm.setTimer(di.timer, true, di.message);
					alarmLinkedList.add(alarm);
					alarm.saveData(GUIHelper.alarmLinkedList);
					alarm.scheduleAlarm();
					StringBuilder sbAlarms=new StringBuilder();
					sbAlarms.append("Current Alarms:\n");
					for(int i=0; i<GUIHelper.alarmLinkedList.size(); i++){
						sbAlarms.append(GUIHelper.alarmLinkedList.get(i).toString()+"\n");
						GUI.showAlarms.setText(sbAlarms.toString());
					}
				}
				di.resetDay();
				di.resetHour();
				di.resetMessage();
				di.resetMinute();
				di.resetMonth();
				di.resetTimer();
				di.resetYear();
				dispose();
			}
			for (int i = 0; i < GUIHelper.alarmLinkedList.size(); i++) {
				String s = "Delete "+GUIHelper.alarmLinkedList.get(i).dateToString()+"  \""+GUIHelper.alarmLinkedList.get(i).message+"\"";

				if (s.equals(event.getActionCommand())) {
					GUIHelper.alarmLinkedList.remove(i);
					alarm.saveData(GUIHelper.alarmLinkedList);
					StringBuilder sbAlarms=new StringBuilder();
					sbAlarms.append("Current Alarms:\n");
					for(int j=0; j<GUIHelper.alarmLinkedList.size(); j++){
						sbAlarms.append(GUIHelper.alarmLinkedList.get(j).toString()+"\n");
						GUI.showAlarms.setText(sbAlarms.toString());
					}
					if(GUIHelper.alarmLinkedList.size()==0){
						GUI.showAlarms.setText(sbAlarms.toString());
					}
					di.resetDay();
					di.resetHour();
					di.resetMessage();
					di.resetMinute();
					di.resetMonth();
					di.resetTimer();
					di.resetYear();
					dispose();
				}
			}
		}
	}
}
