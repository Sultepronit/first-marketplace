package application;

import java.util.*;

public class Database {
	//simple database imitation
	static ArrayList<Product> productList = new ArrayList<Product>();
	static ArrayList<User> userList = new ArrayList<User>();
	static ArrayList<int[]> purchases = new ArrayList<int[]>();

	static List<Integer> productIndexChanges = new ArrayList<>();

	//static ArrayList<int[]> userIndexChanges = new ArrayList<int[]>();
	
	//creates first users & products
	/*Database() {
	productList.add( new Product("Oven", 1000.00) );
	productList.add( new Product("Electric kettle", 200.00) );
	productList.add( new Product("Fan", 150.00) );

	userList.add( new User("John", "McDonald", 10000.00) );
	userList.add( new User("Anna", "Yamada", 2000.00) );
	userList.add( new User("Stepan", "Muts", 359.75) );
	}*/
	
	static void printOutList2(String[][] list, String sum) {	
		int w1, w2 = 0, w3 = 0;//width of 3 columns
		for(int i = 0; i < list.length; i++) {
			w2 = (w2 < list[i][1].length()) ? list[i][1].length() : w2;
			w3 = (w3 < list[i][2].length()) ? list[i][2].length() : w3;
		}
		w1 = list[0][0].length();
		
		String tableFormat = " %-" + w1 + "s │ %-" + w2 + "s │ ";
		String numberFormat = "%" + w3 + "s%n";
		System.out.format(tableFormat, "ID:", "Name:");
		System.out.println(sum);
		
		for(int i = 0; i < list.length; i++) {
			System.out.format(tableFormat, list[i][0], list[i][1]);
			System.out.format(numberFormat, list[i][2]);
		}
	}
	
	static void printOutUserList() {
		if(userList.size() < 1) {
			System.out.println("There are no users in database. Please add the first user.");
		}
		else {
			System.out.println("List of all users:");
			String[][] stringList = new String[userList.size()][3];
			for(int i = 0; i < userList.size(); i++) {
				stringList[i] = userList.get(i).getInfo();
			}
			printOutList2(stringList, "Amount of money:");
		}
	}
	
	static void printOutProductList() {
		if(productList.size() < 1) {
			System.out.println("There are no products in database. Please add the first product.");
		}
		else {
			System.out.println("List of all products:");
			String[][] stringList = new String[productList.size()][3];
			for(int i = 0; i < productList.size(); i++) {
				stringList[i] = productList.get(i).getInfo();
			}
			printOutList2(stringList, "Price:");
		}
	}
	
	static byte deleteStatus = 0;
	static int userToDelete = -1;
	static int productToDelete = -1;
	
	static void deleteEnd() {
		deleteStatus = 0;
		userToDelete = -1;
		productToDelete = -1;
	}
	
	static void deleteUser() {
		userList.remove(userToDelete);
	}
	
	static void deleteProduct() {
		productList.remove(productToDelete);
		productIndexChanges.set(productToDelete, -1);
		for(int i = productToDelete + 1; i < productIndexChanges.size(); i++) {
			int value = productIndexChanges.get(i) - 1;
			productIndexChanges.set(i, value);
		}
		for(int i = 0; i < productIndexChanges.size(); i++) {
			System.out.println(i + " " + productIndexChanges.get(i));
		}
	}
	
	static void delete(String command) {
		switch (deleteStatus) {
			case 0:
				System.out.println("Enter the user/product ID you want to delete");
				deleteStatus++;
				break;
				
			case 1:
				if(userToDelete >= 0 || productToDelete >= 0) {
					System.out.println("Do you confirm removal? Enter Y/N");
					deleteStatus++;
				}
				else {
					System.out.println("Canceled.\nYou may enter new command.");
					deleteEnd();
				}
				break;
				
			case 2: 
				if(command.equals("y")) {
					if(userToDelete >= 0) {
						deleteUser();
					}
					else {
						deleteProduct();
					}
					System.out.println("Deleted.");
				}
				else {
					System.out.println("Canceled.\nYou may enter new command.");
				}
				deleteEnd();
				
		}
		
		
	}
}
