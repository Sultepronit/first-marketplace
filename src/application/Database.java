package application;

import java.util.*;

public class Database {
	//simple database imitation
	static ArrayList<Product> productList2 = new ArrayList<Product>();
	static ArrayList<User> userList2 = new ArrayList<User>();
	
	static Product[] productList = new Product[3];
	static User[] userList = new User[3];
	static ArrayList<int[]> purchases = new ArrayList<int[]>();
	
	Database() {

	productList[0] = new Product("Oven", 1000.00);
	productList[1] = new Product("Electric kettle", 200.00);
	productList[2] = new Product("Fan", 150.00);

	userList[0] = new User("John", "McDonald", 10000.00);
	userList[1] = new User("Anna", "Yamada", 2000.00);
	userList[2] = new User("Stepan", "Muts", 359.75);
	}
	
	static void printOutList(Unit[] list, String sum) {	
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
}
