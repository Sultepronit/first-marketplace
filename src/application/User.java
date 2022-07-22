package application;

public class User extends Unit {
	static int idCount = 1;
	String id;
	String firstName;
	String lastName;
	double money;
	String name;
	
	User(String firstName, String lastName, double money) {
		id = "U"+String.format("%04d", idCount++);
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
		name = firstName + " " + lastName;
	}
	
	String getId() {
		return id;
	}
	
	String[] getInfo() {
		return new String[] {id, name, String.format("%.2f",money)};
	}
}
