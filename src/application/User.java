package application;

public class User {
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
	
	public String getInfo() {
		StringBuilder result = new StringBuilder(id);
		result.append(" ").append(firstName).append(" ")
		.append(lastName).append(" ").append(money);
		return result.toString();
	}
}
