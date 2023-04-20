package model;



public class Message {

	private int remit;
	private int tous;
	private String message;
	
	
	
	public Message(int remit, int tous, String message) {
		this.remit=remit;
		this.tous=tous;
		this.message=message;
	
	}

	public int getRemit() {
		return remit;
	}

	public void setRemit(int remit) {
		this.remit = remit;
	}

	public int getTous() {
		return tous;
	}

	public void setTous(int tous) {
		this.tous = tous;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	@Override
	public String toString() {
		return message +"";
	}
	
	

}
