package application;

public class Exp {
	public byte status = 0;
	
	public User user;// = new User();
	public Product product;// = new Product();
	
	public void buy() {
		System.out.println("Do you confirm the purchase of poduct");
		product.getInfoLine();
		System.out.println("by user");
		user.getInfoLine();
		System.out.println("? Enter Y/N.");
	}
	
}
