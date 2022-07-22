package application;

public class Product {
	static int idCount = 1;
	public String id;
	public String name;
	public double price;
	
	Product() {
		id = "P"+String.format("%04d", idCount++);
	}
}
