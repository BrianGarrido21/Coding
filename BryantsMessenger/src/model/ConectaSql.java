package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ConectaSql extends Connect {
	
	private Statement stm;
	
	public ConectaSql() throws SQLException {
		super();
		stm = this.conexion.createStatement();
		// TODO Auto-generated constructor stub
	}
	
	public boolean addUser(Person person) {
		String sql = "insert into usuarios values (null,'"+person.getName()+"','"+person.getEmail()+"','"+person.getPass()+"')";
		
		try {
			stm.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	
	public Person getUser(String email, String pass) {
		String sql="select * from usuarios where email ='"+email+"' and pass ='"+pass+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			String n = rs.getNString(2);
			String e = rs.getString(3);
			
			Person per = new Person(n,e);
			return per;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//return null;
		}
		return null;

	}
	public Person getUser(String email) {
		String sql="select * from usuarios where email ='"+email+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			String n = rs.getNString(2);
			String e = rs.getString(3);
			
			Person per = new Person(n,e);
			return per;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//return null;
		}
		return null;

	}
	
	public boolean addMessage(Message m) {
		String sql = "insert into mails values (null,'"+m.getRemit()+"','"+m.getTous()+"','"+m.getMessage()+"','"+m.getDate()+"')";
		System.out.println(sql);
		try {
			stm.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Message> getMessages(String email){
		ArrayList<Message> messages = new ArrayList<Message>();
		String sql="select * from mails where para ='"+email+"' order by fecha desc";
		
		ResultSet rs;
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String from = rs.getNString(2);
				String to = rs.getString(3);
				String text = rs.getString(4);
				Date fecha = rs.getDate(5);
			    messages.add(new Message(from,to,text,fecha));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return messages;
	}
	public ArrayList<Person> getPersonas(){
		ArrayList<Person> person = new ArrayList<Person>();
		String sql="select * from usuarios";
		
		ResultSet rs;
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String n=rs.getNString(2);
				String e=rs.getNString(3);
				person.add(new Person(n,e));
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return person;
	}

}
