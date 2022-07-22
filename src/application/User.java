package application;

public class User {
	static int idCount = 1;
	String id;
	String firstName;
	String lastName;
	double money;
	
	User(String firstName, String lastName, double money) {
		id = "U"+String.format("%04d", idCount++);
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
		
	}
}
