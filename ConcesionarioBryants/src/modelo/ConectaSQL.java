package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConectaSQL extends ConnectionDB {
	private Statement stm;

	public ConectaSQL() throws SQLException {
		super();
		stm = this.conexion.createStatement();
	}
	
	
	public User logIn(String email, String password) throws SQLException {

		String sql = "select * from users where email ='" + email + "' and pass ='" + password + "'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			int id = rs.getInt(1);
			String n = rs.getNString(2);
			String e = rs.getString(3);
			String t = rs.getString(4);
			String p = rs.getString(5);
			int m = rs.getInt(6);
			String cc = rs.getString(7);

			User per = new User(id, n, e, t, p, m, cc);
			return per;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// return null;
		}
		return null;

	}
	public User getUser(String email) throws SQLException {

		String sql = "select * from users where email ='" + email + "'";
		try {
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			int id = rs.getInt(1);
			String n = rs.getNString(2);
			String e = rs.getString(3);
			String t = rs.getString(4);
			String p = rs.getString(5);
			int m = rs.getInt(6);
			String cc = rs.getString(7);

			User per = new User(id, n, e, t, p, m, cc);
			return per;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// return null;
		}
		return null;

	}
	

	public ArrayList<Car> getAllCars() {
		ArrayList<Car> cars = new ArrayList<Car>();
		String sql = "select * from car";
		try {

			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				int Cid = rs.getInt(1);
				String n = rs.getNString(2);
				String b = rs.getNString(3);
				String u = rs.getNString(4);
				String g = rs.getNString(5);
				String c = rs.getNString(6);
				String p = rs.getNString(7);
				String f = rs.getNString(8);
				String d = rs.getNString(9);
				int pri = rs.getInt(10);
				String co = rs.getNString(11);
				Car car = new Car(Cid, n, b, u, g, c, p, f, d, pri, co);
				cars.add(car);
			}
		} catch (SQLException e) {

		}
		return cars;
	}

	public Car getCar(int id) throws SQLException {
		String sql = "select * from car where car_id= " + id ;
		try {
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			int Cid = rs.getInt(1);
			String n = rs.getNString(2);
			String b = rs.getNString(3);
			String u = rs.getNString(4);
			String g = rs.getNString(5);
			String c = rs.getNString(6);
			String p = rs.getNString(7);
			String f = rs.getNString(8);
			String d = rs.getNString(9);
			int pri = rs.getInt(10);
			String co = rs.getNString(11);
			Car car = new Car(Cid, n, b, u, g, c, p, f, d, pri, co);
			return car;
		} catch (SQLException e) {

		}

		return null;

	}

	public void addUser(User u) throws SQLException {

		String sql = "insert into users values (null,'" + u.getName() + "','" + u.getEmail() + "','" + u.getTel()
				+ "','" + u.getPassword() + "','" + u.getMoney() + "','" + u.getCreditC() + "')";
		stm.executeUpdate(sql);
		System.out.println("añadido");
	}

	public void buyTotal(User u, Car c) throws SQLException {

		  if (c.getPrice()< u.getMoney()) {
		        String updateSql = "UPDATE users SET money = " + (u.getMoney() - c.getPrice()) + " WHERE user_id = " + u.getUser_id();
		        String insertSql = "INSERT INTO venta VALUES (null, " + c.getId() + ", " + u.getUser_id() + ", " + c.getPrice() + ")";

		        stm.executeUpdate(updateSql);
		        stm.executeUpdate(insertSql);
		    }
	}

//	public void buyPlaced(User u, Car c, Loan l) throws SQLException {
//		
//		if(l.getFirstPayment()<u.getMoney()) {
//			String sql="update users set money= "+(u.getMoney()-l.getFirstPayment())+" where user_id="+u.getUser_id()+ 
//					" insert into venta values (null,'" + c.getId() + "," + u.getUser_id() + "," + l.getFirstPayment() + ")";
//			stm.executeUpdate(sql);
//			
//		}
//
//	}
	public void buyPlaced(User u, Car c, Loan l) throws SQLException {
	    if (l.getFirstPayment() < u.getMoney()) {
	        String updateSql = "UPDATE users SET money = " + (u.getMoney() - l.getFirstPayment()) + " WHERE user_id = " + u.getUser_id();
	        String insertSql = "INSERT INTO venta VALUES (null, " + c.getId() + ", " + u.getUser_id() + ", " + l.getFirstPayment() + ")";

	        stm.executeUpdate(updateSql);
	        stm.executeUpdate(insertSql);
	    }
	}


	public void addMoney(User u, int money, String credit) throws SQLException {
	    String sql = "UPDATE users set money="+(u.getMoney()+money)+" WHERE user_id="+u.getUser_id();
	    stm.executeUpdate(sql);
	}

	public void change(User u, String pass) throws SQLException {
		String sql ="UPDATE users set pass='"+pass+"' WHERE user_id="+ u.getUser_id(); 
			  
		stm.executeUpdate(sql);
		System.out.println("Cambiada");
	}

}