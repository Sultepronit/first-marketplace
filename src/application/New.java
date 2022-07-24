package application;

public class New {
	
	static double moneyToDouble(String line) {
		double result;
		line = line.replace(",", ".");
		
		try {
			result = Double.parseDouble(line);
		}
		catch(Exception e) {
			System.out.println("Error! You must enter a number!");
			return -1.0;
		}
		
		if(result <= 0) {
			System.out.println("Error! Number must be positive!");
		}

		return result;
	}
	
	static byte prouctStatus = 0;
	static String name;
	
	static void createProduct(String line) {
		switch (prouctStatus) {
			case 0:
				System.out.println("To add new product, please, enter its name");
				prouctStatus++;
				break;
				
			case 1:
				if(line.isBlank()) {
					System.out.println("To add new product, please, enter its name");
				}
				else {
					name = line;
					System.out.println("Now enter its price");
					prouctStatus++;
				}
				break;
				
			case 2:
				double price = moneyToDouble(line);
				if(price > 0) {
					Database.productList2.add( new Product(name, price) );
					System.out.println("Succsess!");
					Database.productList2.get(Database.productList2.size() - 1).infoOut();
					System.out.println(Database.productList2.size());
					prouctStatus = 0;
				}
				
		}
		
	}
	
	static byte userStatus = 0;
	static String lastName;
	
	static void createUser(String line) {
		switch (userStatus) {
			case 0:
				System.out.println("To add new user, please, enter his first name");
				userStatus++;
				break;
				
			case 1:
				if(line.isBlank()) {
					System.out.println("To add new user, please, enter his first name");
				}
				else {
					name = line;
					System.out.println("Now enter his last name");
					userStatus++;
				}
				break;
				
			case 2:
				if(line.isBlank()) {
					System.out.println("Please enter user last name");
				}
				else {
					lastName = line;
					System.out.println("Now enter user amount of money");
					userStatus++;
				}
				break;
				
			case 3:
				double money = moneyToDouble(line);
				if(money > 0) {
					Database.userList2.add( new User(name, lastName, money) );
					System.out.println("Succsess!");
					Database.userList2.get(Database.userList2.size() - 1).infoOut();
					System.out.println(Database.userList2.size());
					userStatus = 0;
				}
				
		}
		
	}
}
