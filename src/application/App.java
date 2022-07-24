package application;

import java.util.Scanner;

public class App {
	
	static Database base = new Database();
	//static Manipulations tool = new Manipulations(); 
	//static Buying buying = new Buying();
	
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
				{"products", "Shows the list of all products"},
				{"users", "Shows the list of all users"},
				{"(product_ID)", "Shows information about the product"},
				{"(user_ID)", "Shows information about the user; lets you buy a product"},
				{"exit", "Exits from this programm"},
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
		
		makeMenu();

	}

}