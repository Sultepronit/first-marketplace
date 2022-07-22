package application;

public class Product extends Unit {
	static int idCount = 1;
	public String id;
	public String name;
	public double price;
	
	Product() {
		id = "P"+String.format("%04d", idCount++);
	}
	
	String[] getInfo() {
		return new String[] {id, name, String.format("%.2f",price)};
	}
}
