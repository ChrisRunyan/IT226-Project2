package edu.ilstu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Alarm {
	public String currentTime;
	String year = "";
	String month = "";
	String day = "";
	String hour = "";
	String minute = "";
	boolean timer=false;
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	
	//get current time 
	public String getCurrentTime(){
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        currentTime = sdf.format(cal.getTime());
        return currentTime;
	}
	
	public void scheduleAlarm(){
		Timer timer=new Timer();
		try {
			Date date=sdf.parse(month+"/"+day+"/"+year+" "+hour+":"+minute);
			timer.schedule(new MyTimeTask(), date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gathers all variables required for an alarm object 
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 */
	public void setAlarm(String yr, String mon, String dy, String hr, String min){
		this.year=yr;
		this.month=mon;
		this.day=dy;
		this.hour=hr;
		this.minute=min;
		this.timer=false;
	}
	
	/**
	 * Gathers all variables required for a timer object; takes minutes and adds to current time to create alarm object
	 * 
	 * @param minute
	 * @param timer
	 */
	public void setTimer(String min, boolean timer){
		Calendar cal = Calendar.getInstance();
		String currentTimeTemp=sdf.format(cal.getTime());
		this.year=currentTimeTemp.substring(6, 10);
		this.month=currentTimeTemp.substring(0, 2);
		this.day=currentTimeTemp.substring(3, 5);
		this.hour=currentTimeTemp.substring(11, 13);
		this.minute=currentTimeTemp.substring(14);
		timer=true;
		
		//if minutes for timer entered plus current minutes goes over an hour, add to hour object so all variables have possible
		//values for a time (i.e. minutes < 60, hour < 24, etc.
		if(Integer.parseInt(minute)+Integer.parseInt(min)>60){
			this.minute=Integer.toString(((Integer.parseInt(minute)+Integer.parseInt(min))%60));
			this.hour=Integer.toString((Integer.parseInt(this.hour)+1));
			if(Integer.parseInt(hour)>24){
				this.hour=Integer.toString((Integer.parseInt(this.hour)%60));
				this.day=Integer.toString((Integer.parseInt(this.day)+1));
			}
			//**check if days is over 30 or 31 depending on month
		}
		else{
			this.minute=Integer.toString(Integer.parseInt(minute)+Integer.parseInt(min));
		}
	}
	
	//read data from csv file and then put them to dataInput data
	public void readData()throws FileNotFoundException{
		Scanner reader = null;
		
	    try{
	    	reader=new Scanner(new BufferedReader(new FileReader("alarm.csv")));
		}
		catch(FileNotFoundException e1){
			//**Print to showAlarms and showTimers that file could not be read
			System.out.println("Invalid filename entered. Try again.");
		}
	        
	    LinkedList<String> lines= new LinkedList<String>();
	    int counter = 0;
	    
	    while(reader.hasNextLine()){
	    	Alarm alarmTemp=new Alarm();
	    	lines.add(reader.nextLine());
	    	String[] splice = lines.get(counter).split(",");
			DataInput x = new DataInput();
			
			x.setMonth1(splice[0]);
			x.setDay1(splice[1]);
			x.setYear1(splice[2]);
			x.setHour1(splice[3]);
			x.setMinute1(splice[4]);
			
			alarmTemp.setAlarm(x.year, x.month, x.day, x.hour, x.minute);
			GUIHelper.alarmLinkedList.add(alarmTemp);
			
			counter++;
	    }
	    
	    reader.close();
	}
	
	// print out the list of alarm from dataInput data
	public String printAlarmList(LinkedList<DataInput> data)
	{ 
		StringBuilder sb= new StringBuilder();
		
		for(int i = 0; i< data.size(); i++){
			sb.append( data.get(i).dateToString());
			sb.append('\n');
		}
		
//		System.out.println(sb.toString());
		return sb.toString();
	}

	// save data from linkedlist to csv file, use the datainput linkedlist 
	public void saveData(LinkedList<Alarm> alarmLL){
		PrintWriter writer = null;
		
		try{
			writer=new PrintWriter("alarm.csv");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< alarmLL.size() ; i++){
        	sb.append(alarmLL.get(i).month);
        	sb.append(',');
        	sb.append(alarmLL.get(i).day);
        	sb.append(',');
        	sb.append(alarmLL.get(i).year);
        	sb.append(',');
        	sb.append(alarmLL.get(i).hour);
        	sb.append(',');
        	sb.append(alarmLL.get(i).minute);
	        sb.append('\n');
		}
		
		writer.write(sb.toString());
	   	writer.close();
	}
	
	//return true if get right time ( can use it to get notification ) 
	public boolean checkAlarm(Alarm a){
		if(a.dateToString().equals(currentTime)){
			return true;
		}
		else{
			return false;
		}
	}
	
	// delete alarm which march key from dataInput data
	public void deleteAlarm(LinkedList<DataInput> data, String key){
		int index = 0;
		
		for(int i = 0 ; i < data.size(); i++){
			if(key.equals(data.get(i).dateToString())){
				index = i;
			}
		}
		
		data.remove(index);
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		
		if(timer==true){
			sb.append("Timer for ");
		}
		else{
			sb.append("Alarm for ");
		}
		sb.append(month+"/"+day+"/"+year+" "+hour+":"+minute+"\n");
		
		return sb.toString();
	}
	
	public String dateToString() {
		String tostring = "";

		tostring += month;
		tostring += "/";
		tostring += day;
		tostring += "/";
		tostring += year;
		tostring += " ";
		tostring += hour;
		tostring += ":";
		tostring += minute;

		return tostring;
	}
	
	private static class MyTimeTask extends TimerTask {
	      public void run() {
	    	  JFrame frame=new JFrame();
	    	  JOptionPane.showMessageDialog(frame, "ALARM");
	      }
	   }
}
