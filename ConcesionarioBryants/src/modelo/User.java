package modelo;

public class User {
	Creditc p= new Creditc();
	int user_id;
	String name;
	String email;
	String tel;
	String password;
	int money;
	String creditC;
	
	public User() {
		
	}
	
	public User(int user_id) {
		this.user_id=user_id;
	}
	
	public User(String name, String email, String tel, String password, int money, String creditC) {

		this.name=name;
		this.email=email;
		this.tel=tel;
		this.password=password;
		this.money=money;
		this.creditC=creditC;
	}
	
	
	
	public User(int user_id, String name, String email, String tel, String password, int money, String creditC) {
		this.user_id=user_id;
		this.name=name;
		this.email=email;
		this.tel=tel;
		this.password=password;
		this.money=money;
		this.creditC=creditC;
	}
	


	public String getCreditC() {
		return p.getPassword();
	}



	public void setCreditC(String creditC) {
		this.creditC = creditC;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user_id=" + user_id + ", name=" + name + ", email=" + email + ", tel=" + tel
				+ ", password=" + password + ", money=" + money + ", creditC=" + creditC + "]";
	}
}
