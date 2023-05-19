package modelo;

public class Car {
	int id;
	String name;
	String brand;
	String url;
	String gear;
	String consume;
	String potency;
	String fuel;
	String doors;
	int price;
	String color;


	public Car() {
	}
	
	public Car (int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Car(int id,String name, String brand,String url, String gear, String consume, String potency, String fuel, String doors,int price, String color) {
		this.id=id;
		this.name = name;
		this.brand = brand;
		this.url = url;
		this.gear = gear;
		this.consume = consume;
		this.potency = potency;
		this.fuel = fuel;
		this.doors = doors;
		this.price = price;
		this.color = color;
		
	}



	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", brand=" + brand + ", url=" + url + ", gear=" + gear
				+ ", consume=" + consume + ", potency=" + potency + ", fuel=" + fuel + ", doors=" + doors + ", price="
				+ price + ", color=" + color + "]";
	}

	public String getConsume() {
		return consume;
	}

	public void setConsume(String consume) {
		this.consume = consume;
	}

	public String getPotency() {
		return potency;
	}

	public void setPotency(String potency) {
		this.potency = potency;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getDoors() {
		return doors;
	}

	public void setDoors(String doors) {
		this.doors = doors;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}






