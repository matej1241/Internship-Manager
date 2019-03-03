package studentInternshipManager;

import java.io.Serializable;

public class LogInformation implements Serializable{

	private static final long serialVersionUID = -3960619495874322413L;
	public String logID;
	public String text;
	public String startTime;
	public String endTime;
	public String date;
	public String owner;
	public String logStatus;
	
	public LogInformation(){
	}

	public String getLogID() {
		return logID;
	}

	public void setLogID(String logID) {
		this.logID = logID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLogStatus() {
		return logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}
}
