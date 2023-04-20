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
			int id= rs.getInt(1);
			String n = rs.getNString(2);
			String e = rs.getString(3);
			
			Person per = new Person(id,n,e);
			return per;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//return null;
		}
		return null;

	}
	public Person getUser2(String email) {
		String sql="select * from usuarios where email ='"+email+"'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			int id= rs.getInt(1);
			String n = rs.getNString(2);
			String e = rs.getString(3);
			
			Person per = new Person(id,n,e);
			return per;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//return null;
		}
		return null;
	}
	
	
	public boolean addMessage(Message m) {
		String sql = "insert into mensajes values (null,'"+m.getMessage()+"','"+m.getRemit()+"','"+m.getTous()+"')";
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
	public ArrayList<Message> getMessages(String email, String email2){
		ArrayList<Message> messages = new ArrayList<Message>();
		String sql="select * from mensajes where id_remite=(select id_usuario from usuarios where email ='"+email+"') and id_destino=(select id_usuario from usuarios where email ='"+email2+"')";
		System.out.println(sql);
		ResultSet rs;
		try {
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				int from = rs.getInt(2);
				int to = rs.getInt(3);
				String text = rs.getString(4);
			    messages.add(new Message(from,to,text));
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
