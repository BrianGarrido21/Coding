package model;

public class Person {

	@Override
	public String toString() {
		return name +" "+email;
	}

	private String name;
	private String email;
	private String pass;
	
	public Person() {
		
	}
	public Person(String name,String email,String pass) {
		this.name = name;
		this.email = email;
		this.pass = pass;
	}

	public Person(String name,String email) {
		this.name= name;
		this.email = email;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass= pass;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email= email;
	}

	
}


