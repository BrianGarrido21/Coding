package model;

import java.util.Date;

public class Message {

	private String remit;
	private String tous;
	private String message;
	private Date date;
	
	
	public Message(String remit, String tous, String message,Date date) {
		this.remit=remit;
		this.tous=tous;
		this.message=message;
		this.date= date;
	}

	public String getRemit() {
		return remit;
	}

	public void setRemit(String remit) {
		this.remit = remit;
	}

	public String getTous() {
		return tous;
	}

	public void setTous(String tous) {
		this.tous = tous;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
