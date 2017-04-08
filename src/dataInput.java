
public class dataInput {

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
		tostring += "--";
		tostring += day;
		tostring += "--";
		tostring += year;
		tostring += " at  ";
		tostring += hour;
		tostring += "::";
		tostring += minute;

		return tostring;
	}

	public String timerToString() {
		return "Timer set for  " + timer + " minutes";
	}

}
