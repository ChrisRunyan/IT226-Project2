package edu.ilstu;

public class DataInput {
	String year = "";
	String month = "";
	String day = "";
	String hour = "";
	String minute = "";
	String timer = "";

	public void setYear(char c) {
		year = year + c;
	}

	public void setMinute(char c) {
		minute = minute + c;
	}

	public void setMonth(char c) {
		month = month + c;
	}

	public void setHour(char c) {
		hour = hour + c;
	}

	public void setDay(char c) {
		day = day + c;
	}

	public void setTimerInMinutes(char c) {
		timer = timer + c;
	}
	
	public void setYear1(String year) {
		this.year = year;
	}

	public void setMinute1(String min) {
		this.minute = min;
	}

	public void setMonth1(String month) {
		this.month = month;
	}

	public void setHour1(String hour) {
		this.hour = hour;
	}

	public void setDay1(String day) {
		this.day = day;
	}

	public void resetYear() {
		year = "";
	}

	public void resetMonth() {
		month = "";
	}

	public void resetDay() {
		day = "";
	}

	public void resetHour() {
		hour = "";
	}

	public void resetMinute() {
		minute = "";
	}

	public void resetTimer() {
		timer = "";
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

	public String timerToString() {
		return "Timer set for  " + timer + " minutes";
	}
}
