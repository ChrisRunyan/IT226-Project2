package edu.ilstu;
import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.*;

public class alarm {
	public LinkedList<dataInput> input = new LinkedList<dataInput>();
	public String currentTime;
	//get current time 
	public String gettime(){
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        currentTime = sdf.format(cal.getTime());
       return currentTime;
	}
	
	
	
	// set an alarm 
	public void setAlarm(String year, String month,String day, String hours, String min,LinkedList<dataInput> data ){
		dataInput a = new dataInput();
		a.setDay1(day);
		a.setHour1(hours);
		a.setMinute1(min);
		a.setYear1(year);
		a.setMonth1(month);
		data.add(a);
	}
	
	
	//read data from csv file and then put them to dataInput data
	public void readData(LinkedList<dataInput> data)throws FileNotFoundException{
		
		 Scanner reader = null;
	        try{
				reader=new Scanner(new BufferedReader(new FileReader("C:\\Users\\hoang peo\\workspace\\project1\\sss.csv")));
			}
			catch(FileNotFoundException e1){
				System.out.println("Invalid filename entered. Try again.");
			}
	        LinkedList<String> lines= new LinkedList<String>();
	        int counter = 0;
	        while(reader.hasNextLine()){
				lines.add(reader.nextLine());
				String[] splice = lines.get(counter).split(",");
				dataInput x = new dataInput();
				x.setMonth1(splice[0]);
				x.setDay1(splice[1]);
				x.setYear1(splice[2]);
				x.setHour1(splice[3]);
				x.setMinute1(splice[4]);
				data.add(x);
				counter++;
	        }
	        reader.close();
	}
	
	// print out the list of alarm from dataInput data
	public String printAlarmList(LinkedList<dataInput> data)
	{ 
		StringBuilder sb= new StringBuilder();
		
		for(int i = 0; i< data.size(); i++){
			sb.append( data.get(i).dateToString());
			sb.append('\n');
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	
	
	// save data from linkedlist to csv file, use the datainput linkedlist 
	public void saveData(LinkedList<dataInput> data){
		PrintWriter writer = null;
		try{
			writer=new PrintWriter("alarm.csv");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< data.size() ; i++){
        	sb.append(data.get(i).month);
        	sb.append(',');
        	sb.append(data.get(i).day);
        	sb.append(',');
        	sb.append(data.get(i).year);
        	sb.append(',');
        	sb.append(data.get(i).hour);
        	sb.append(',');
        	sb.append(data.get(i).minute);
	        sb.append('\n');
    }
		   writer.write(sb.toString());
	   	   writer.close();
	}
	 
	
	//return true if get right time ( can use it to get notification ) 
	public boolean checkAlarm(dataInput a){
		
		if(a.dateToString().equals(currentTime)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	// delete alarm which march key from dataInput data
	public void deleteAlarm(LinkedList<dataInput> data, String key){
		int index = 0;
		for(int i = 0 ; i < data.size(); i++){
			if(key.equals(data.get(i).dateToString())){
				index = i;
			}
		}
		data.remove(index);
	}
	
	
	
	
	
	
	
	
	
}
