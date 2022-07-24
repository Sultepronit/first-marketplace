package application;

import java.util.*;

public class Database {
	//simple database imitation
	static ArrayList<Product> productList = new ArrayList<Product>();
	static ArrayList<User> userList = new ArrayList<User>();
	static ArrayList<int[]> purchases = new ArrayList<int[]>();
	
	Database() {
	productList.add( new Product("Oven", 1000.00) );
	productList.add( new Product("Electric kettle", 200.00) );
	productList.add( new Product("Fan", 150.00) );

	userList.add( new User("John", "McDonald", 10000.00) );
	userList.add( new User("Anna", "Yamada", 2000.00) );
	userList.add( new User("Stepan", "Muts", 359.75) );
	}
	
	/*static void printOutList0(Unit[] list, String sum) {	
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
	
	static void printOutList(ArrayList<Unit> list, String sum) {	
		int w1, w2 = 0, w3 = 0;//width of 3 columns
		String[][] stringList = new String[list.size()][3];
		for(int i = 0; i < list.size(); i++) {
			stringList[i] = list.get(i).getInfo();
			w2 = (w2 < stringList[i][1].length()) ? stringList[i][1].length() : w2;
			w3 = (w3 < stringList[i][2].length()) ? stringList[i][2].length() : w3;
		}
		w1 = stringList[0][0].length();
		
		String tableFormat = " %-" + w1 + "s │ %-" + w2 + "s │ ";
		String numberFormat = "%" + w3 + "s%n";
		System.out.format(tableFormat, "ID:", "Name:");
		System.out.println(sum);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.format(tableFormat, stringList[i][0], stringList[i][1]);
			System.out.format(numberFormat, stringList[i][2]);
		}
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
		System.out.println("List of all users:");
		//printOutList(userList, "Amount of money:");
		String[][] stringList = new String[userList.size()][3];
		for(int i = 0; i < userList.size(); i++) {
			stringList[i] = userList.get(i).getInfo();
		}
		printOutList2(stringList, "Amount of money:");
	}
	
	static void printOutProductList() {
		System.out.println("List of all products:");
		//printOutList(productList, "Price:");
		String[][] stringList = new String[productList.size()][3];
		for(int i = 0; i < productList.size(); i++) {
			stringList[i] = productList.get(i).getInfo();
		}
		printOutList2(stringList, "Price:");
	}
}
