package edu.ilstu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
 
/**
 * Displays the current time and date. Contains a method (showClock) which returns a JPanel object that can be placed inside of
 * a JFrame. showClock has to accept as a parameter a JPanel object that it will return with all the time and date information.
 * 
 * @author Christopher Runyan, Hoang Le
 */
public class ShowClock {
	public JPanel showClock(JPanel topPanel){
		ClockLabel dateLable = new ClockLabel("date");
		dateLable.setForeground(Color.BLACK);
		ClockLabel timeLable = new ClockLabel("time");
		timeLable.setForeground(Color.BLACK);
		ClockLabel dayLable = new ClockLabel("day");
		dayLable.setForeground(Color.BLACK);
		
		topPanel.add(dateLable);
		topPanel.add(timeLable);
		topPanel.add(dayLable);
	  
		return topPanel;
  }
  
  @SuppressWarnings("serial")
  private class ClockLabel extends JLabel implements ActionListener{
		SimpleDateFormat sdf;
			 
		public ClockLabel(String type) {
			setForeground(Color.green);
			 
			switch (type) {
				case "date" : sdf = new SimpleDateFormat("  MM/dd/yyyy");
			    	setFont(new Font("sans-serif", Font.PLAIN, 12));
			    	setHorizontalAlignment(SwingConstants.LEFT);
			    	break;
				case "time" : sdf = new SimpleDateFormat("kk:mm:ss ");
			        setFont(new Font("sans-serif", Font.PLAIN, 40));
			        setHorizontalAlignment(SwingConstants.CENTER);
			        break;
				case "day"  : sdf = new SimpleDateFormat("EEEE  ");
			        setFont(new Font("sans-serif", Font.PLAIN, 16));
			        setHorizontalAlignment(SwingConstants.RIGHT);
			        break;
			    default     : sdf = new SimpleDateFormat();
			        break;
			    }
			    Timer t = new Timer(1000, this);
			    t.start();
		}
			 
		public void actionPerformed(ActionEvent ae) {
			Date d = new Date();
			setText(sdf.format(d));
		}
	}
}
 
