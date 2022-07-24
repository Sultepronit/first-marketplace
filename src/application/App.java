package application;

import java.util.Scanner;

public class App {
	
	//static Database base = new Database(); //creates first users & products
	
	static void checkMainCommands(String command) {
		String commandNoCase = command.toLowerCase();
		do {
			if(commandNoCase.equals("exit")) { 
				oneMoreTime = false;
				System.out.println("Thank you for using our application!");
				break;
			}
			if(Buying.status > 1) {
				Buying.status = 0;
				if(commandNoCase.equals("y")) {
					Buying.confirm();
				}
				else {
					System.out.println("Canceled.\nYou may enter new command.");
				}
				break;
			}
			if(New.prouctStatus > 0) {
				New.createProduct(command);
				break;
			}
			if(New.userStatus > 0) {
				New.createUser(command);
				break;
			}
			if(Database.deleteStatus > 0) {
				Manipulations.checkUserID(commandNoCase);
				Manipulations.checkProductID(commandNoCase);
				Database.delete(commandNoCase);
				break;
			}
			if(commandNoCase.equals("products")) { 
				Database.printOutProductList();
				break;
			}
			if(commandNoCase.equals("users")) { 
				Database.printOutUserList();
				break;
			}
			if(commandNoCase.equals("new product")) { 
				New.createProduct("");
				break;
			}
			if(commandNoCase.equals("new user")) { 
				New.createUser("");
				break;
			}
			if(commandNoCase.equals("delete")) { 
				Database.delete("");
				break;
			}
			if(command == "") {
				System.out.println("Please, enter a command");
				break;
			}
			if(Manipulations.checkComplexCommand(command, commandNoCase)) {
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
				{"users", "Shows the list of all users."},
				{"(user_ID)", "Shows information about the user; lets you buy a product."},
				{"new user", "Creates new user entry."},
				{"products", "Shows the list of all products."},
				{"(product_ID)", "Shows information about the product."},
				{"new product", "Creates new product entry."},
				//{"delete", "Deletes user/product entry."},
				{"exit", "Exits this program."},
		};
		
		for(String[] command: commands) {
			System.out.format(" %-12s │ %s%n", command[0], command[1]);
		}
		System.out.println("Enter one of the commands from the list above");
		
		Scanner in = new Scanner(System.in);
		while(oneMoreTime) {
			String command = in.nextLine();
			
			if(Buying.status > 0) {
				Buying.status--;
			}
			checkMainCommands(command);
			
			//System.out.println("Enter your next command");
		}
		in.close();
	}

	public static void main(String[] args) {
		
		System.out.println("Hello! This marketplace app does not have a GUI. Just follow the simple instructions.");
		System.out.println("There are no users in database. Use command \"new user\" to add the first user.");
		System.out.println("There are no products in database. Use command \"new product\" to add the first product.");
		System.out.println("Be careful! In this version of program you can't delete an entry!");
		
		makeMenu();

	}

}