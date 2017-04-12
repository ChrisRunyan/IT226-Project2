package edu.ilstu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Christopher Runyan
 */
class MyTimeTask extends TimerTask {
	Alarm alarm;
	Alarm alarmTemp=new Alarm();
	JFrame frame=new JFrame();
	  
	JPanel topPanel=new JPanel();
	JPanel bottomPanel=new JPanel();
	JPanel finalPanel=new JPanel();
	JButton sleep=new JButton();
	JButton dismiss=new JButton();
	JLabel label=new JLabel();
	JLabel snoozedLabel=new JLabel();
	
	public MyTimeTask(Alarm a){
		this.alarm=a;
	}
	
	public void run() {
		frame.setSize(300, 150);
    	frame.setVisible(true);
    	  
    	if(alarm.message!=""&&alarm.message!=null){
    		label.setText("Alarm: "+alarm.message);
    	}
    	else{
    		label.setText(alarm.toString());
    	}
    	  
    	snoozedLabel.setText("(Snoozed "+alarm.returnSnoozed()+" times)");
    	sleep.setText("Snooze");
    	dismiss.setText("Dismiss");
    	sleep.addActionListener(new ActionListener1());
    	dismiss.addActionListener(new ActionListener1());
    	finalPanel.setLayout(new GridLayout(2, 1, 5, 5));
    	topPanel.add(label);
    	topPanel.add(snoozedLabel);
    	bottomPanel.add(sleep);
    	bottomPanel.add(dismiss);
    	finalPanel.add(topPanel);
    	finalPanel.add(bottomPanel);
    	frame.setResizable(false);
    	frame.add(finalPanel);
    }
      
	class ActionListener1 implements ActionListener {
		@Override
    	public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand() == "Snooze") {
				alarm.addToSnoozed();
    			alarmTemp.snoozed=alarm.returnSnoozed();
    			System.out.println(alarmTemp.returnSnoozed());
    			alarmTemp.setTimer("1", true, alarm.message);
    			GUIHelper.alarmLinkedList.remove(alarm);
    			GUIHelper.alarmLinkedList.add(alarmTemp);
				alarmTemp.saveData(GUIHelper.alarmLinkedList);
				alarmTemp.scheduleAlarm();
				StringBuilder sbAlarms=new StringBuilder();
				sbAlarms.append("Current Alarms:\n");
				for(int i=0; i<GUIHelper.alarmLinkedList.size(); i++){
					sbAlarms.append(GUIHelper.alarmLinkedList.get(i).toString()+"\n");
				}
				GUI.showAlarms.setText(sbAlarms.toString());
				frame.dispose();
    			}
    			if (event.getActionCommand() == "Dismiss") {
    				GUIHelper.alarmLinkedList.remove(alarm);
    				alarm.saveData(GUIHelper.alarmLinkedList);
    				StringBuilder sbAlarms=new StringBuilder();
    				sbAlarms.append("Current Alarms:\n");
					for(int j=0; j<GUIHelper.alarmLinkedList.size(); j++){
						sbAlarms.append(GUIHelper.alarmLinkedList.get(j).toString()+"\n");
					}
					GUI.showAlarms.setText(sbAlarms.toString());
					frame.dispose();
    			}	
			}
      	}
}