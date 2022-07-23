package application;

public class Product extends Unit {
	static int idCount = 1;
	public String id;
	public String name;
	public double price;
	
	Product(String name, double price) {
		id = "P"+String.format("%04d", idCount++);
		this.name = name;
		this.price = price;
	}
	
	public String[] getInfo() {
		return new String[] {id, name, String.format("%.2f",price)};
	}
	
	public String getInfoLine() {
		return id + ": " + name + ", price: " + String.format("%.2f",price);
	}
}
