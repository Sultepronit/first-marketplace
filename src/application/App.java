package application;

public class App {
	
	//simple database imitation
	static Product[] productList = new Product[3];
	static User[] userList = new User[3];
	static void createDatabase() {
		
	//products///////////////////////
	for(int i = 0; i < productList.length; i++) {
		productList[i] = new Product();
		//productList[i].id = "P000"+(i+1);
	}
	
	productList[0].name = "Oven";
	productList[0].price = 1000.00;
	
	productList[1].name = "Electric kettle";
	productList[1].price = 200.00;
	
	productList[2].name = "Fan";
	productList[2].price = 150.00;
	
	//users///////////////////////////
	userList[0] = new User("John", "McDonald", 10000.00);
	userList[1] = new User("Anna", "Yamada", 2000.00);
	userList[2] = new User("Stepan", "Muts", 359.75);
	}

	public static void main(String[] args) {
		
		System.out.println("Hello! This marketplace app have no GUI.\nJust follow simple instructions here.");
		
		createDatabase();
		/*String leftAlignFormat = "│ %-15s │ %-4d │\n";
		for (int i = 0; i < 5; i++) {
		    System.out.format(leftAlignFormat, "some data" + i, i * i);
		}*/
		
		//System.out.println("┌───────┬───────────────────────────────────┐");
		
		//String tableFormat = " %-5s │ %-13s │%n";
		String tableFormat = " %-5s │ %-13s │ ";
		System.out.format(tableFormat, "ID:", "Name:");
		System.out.println("Amount of money:");
		for(int i = 0; i < 3; i++) {
			System.out.format(tableFormat, userList[i].id, userList[i].name);
			System.out.format("%8.2f%n", userList[i].money, "%n"); 
		}		
		
		/*System.out.println(productList[1].name);
		System.out.println(productList[1].id);
		
		System.out.println(userList[2].id);
		System.out.println(userList[2].money);*/
	}

}
