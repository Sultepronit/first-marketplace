package application;

//import java.util.Scanner;

public class Manipulations {
	
	static int StringToInt(String string) {
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) < '0') return -1;
			if(string.charAt(i) > '9') return -1;
		}
		return Integer.parseInt(string);
	}
	
	static boolean checkUserID(String command) {
		if(command.charAt(0) != 'u') return false;
		int index = StringToInt(command.substring(1));
		if(index < 0) return false;
		if(index > Database.userList.length || index < 1) {
			System.out.println("There are no users with this ID. Check the list and try again.");
			Database.printOutUserList();
			return false;
		}
		System.out.println(Database.userList[--index].getInfoLine());
		System.out.println("You can buy something now by entering the product ID.");
		Buying.userIndex = index;
		Buying.status = 2;
		return true;
	}
	
	static boolean checkProductID(String command) {
		if(command.charAt(0) != 'p') return false;
		int index = StringToInt(command.substring(1));
		if(index < 0) return false;
		if(index > Database.productList.length || index < 1) {
			System.out.println("There are no products with this ID. Check the list and try again.");
			Database.printOutProductList();
			Buying.status++;//let user buy product after he enter proper ID 
			return false;
		}
		System.out.println(Database.productList[--index].getInfoLine());
		if(Buying.status > 0) {
			Buying.productIndex = index;
			Buying.buy();
		}

		return true;
	}
	
	public boolean checkComplexCommand(String command, String commandNoCase) {
		
		if(checkUserID(commandNoCase)) {
			return true;
		}
		if(checkProductID(commandNoCase)) {
			return true;
		}
		if(commandNoCase.equals("(product_id)") || commandNoCase.equals("product_id")) { 
			System.out.println("\"" + command + "\" is not a command. Enter ID of actual product.");
			Database.printOutProductList();
			return true;
		}
		if(commandNoCase.equals("(user_id)") || commandNoCase.equals("user_id")) { 
			System.out.println("\"" + command + "\" is not a command. Enter ID of actual user.");
			Database.printOutUserList();
			return true;
		}
		
		return false;
	}
	
}
