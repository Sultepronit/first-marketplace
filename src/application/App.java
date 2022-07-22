package application;

import java.util.Scanner;

public class App {
	
	static Manipulations tool = new Manipulations(); 
	
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
	
	static void printOutList(Unit[] list, String sum) {	
		//System.out.println("┌───────┬───────────────────────────────────┐");	
		
		int w1, w2 = 0, w3 = 0;//width of 3 columns
		String[][] stringList = new String[list.length][3];
		for(int i = 0; i < list.length; i++) {
			stringList[i] = list[i].getInfo();
			w2 = (w2 < stringList[i][1].length()) ? stringList[i][1].length() : w2;
			w3 = (w3 < stringList[i][2].length()) ? stringList[i][2].length() : w3;
		}
		w1 = stringList[0][0].length();
		
		String tableFormat = " %-" + w1 + "s │ %-" + w2 + "s │ ";
		String numberFormat = "%" + w3 + "s%n";
		System.out.format(tableFormat, "ID:", "Name:");
		System.out.println(sum);
		
		for(int i = 0; i < list.length; i++) {
			System.out.format(tableFormat, stringList[i][0], stringList[i][1]);
			System.out.format(numberFormat, stringList[i][2]);
		}
	}
	
	static void printOutUserList() {
		System.out.println("List of all users:");
		printOutList(userList, "Amount of money:");
	}
	
	static void printOutProductList() {
		System.out.println("List of all products:");
		printOutList(productList, "Price:");
	}
	
	static boolean checkProductID(String command) {
		if(command.charAt(0) != 'p') return false;
		int index = tool.StringToInt(command.substring(1));
		if(index < 0) return false;
		if(index > productList.length || index < 1) {
			System.out.println("There are no products with this ID. Check the list and try again.");
			printOutProductList();
			return false;
		}
		System.out.println(productList[--index].getInfoLine());
		if(tool.waitForProductID) {
			//tool.buy(1);
		}
		return true;
	}
	
	static boolean checkUserID(String command) {
		if(command.charAt(0) != 'u') return false;
		int index = tool.StringToInt(command.substring(1));
		if(index < 0) return false;
		if(index > userList.length || index < 1) {
			System.out.println("There are no users with this ID. Check the list and try again.");
			printOutUserList();
			return false;
		}
		System.out.println(userList[--index].getInfoLine());
		if(tool.waitForUserID) {
			//tool.buy(1);
		}
		return true;
	}
	
	/*static String scan() {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		scanner.close();
		return string;
	}*/
	
	static byte buyingProcess = 0;
	
	static void buy() {
		if(buyingProcess == 0) {
			System.out.println("To purchase a product, enter your user ID.");
			buyingProcess = 1;
		}
		
		//Scanner scanner = new Scanner(System.in);
		//String command = scanner.nextLine();
		/*if( checkProductID(command.toLowerCase()) ) {
			System.out.println("Now enter the product ID.");
		}*/
		
		//if(checkUserID(commandNoCase)) break;
		 
		/*while(oneMoreTime) {
			String command = in.nextLine();
			checkMainCommands(command);
			
			//System.out.println("Enter your next command");
		}*/
		//scanner.close();
	}
	
	static void checkMainCommands(String command) {
		String commandNoCase = command.toLowerCase();
		do {
			if(commandNoCase.equals("products")) { 
				printOutProductList();
				break;
			}
			
			if(commandNoCase.equals("users")) { 
				printOutUserList();
				break;
			}
			
			if(commandNoCase.equals("buy")) { 
				//tool.buy(0);
				//System.out.println("To purchase a product, enter your user ID.");
				buy();
				break;
			}
			
			if(checkProductID(commandNoCase)) break;
			
			if(checkUserID(commandNoCase)) break;
			
			if(commandNoCase.equals("exit")) { 
				oneMoreTime = false;
				System.out.println("Thank you for using our application!");
				break;
			}
			
			if(commandNoCase.equals("(product_id)") || commandNoCase.equals("product_id")) { 
				System.out.println("\"" + command + "\" is not a command. Enter ID of actual product.");
				printOutProductList();
				break;
			}
			
			if(commandNoCase.equals("(user_id)") || commandNoCase.equals("user_id")) { 
				System.out.println("\"" + command + "\" is not a command. Enter ID of actual user.");
				printOutUserList();
				break;
			}
			
			System.out.println("\"" + command + "\" is not a command. Use one of the list.");
			makeMenu();
		}
		while(false);
	}
	
	static boolean oneMoreTime = true;
	static void makeMenu() {

		String[][] commands = {
				//{"Command:", "Description:"},
				{"products", "Shows the list of all products"},
				{"users", "Shows the list of all users"},
				{"(product_ID)", "Shows information about the product"},
				{"(user_ID)", "Shows information about the user"},
				{"buy", "Lets you buy something [you need to know product_ID and user_ID]"},
				{"exit", "Exits from this programm"},
		};
		
		for(String[] command: commands) {
			//" %-9s │ %-"
			System.out.format(" %-12s │ %s%n", command[0], command[1]);
			//System.out.println(command[1]);
		}
		
		System.out.println("Enter one of the commands from the list above");
		
		Scanner in = new Scanner(System.in);
		 
		while(oneMoreTime) {
			String command = in.nextLine();
			//String command = scan();
			checkMainCommands(command);
			
			//System.out.println("Enter your next command");
		}
		in.close();
	}

	public static void main(String[] args) {
		
		System.out.println("Hello! This marketplace app does not have a GUI. Just follow the simple instructions.");
		
		createDatabase();
		makeMenu();

	}

}
