package application;

//import java.util.Scanner;

public class Manipulations {
	
	public int StringToInt(String string) {
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) < '0') return -1;
			if(string.charAt(i) > '9') return -1;
		}
		return Integer.parseInt(string);
	}
	
	/*public boolean checkProductID(String command) {
		if(command.charAt(0) != 'p') return false;
		int index = StringToInt(command.substring(1));
		if(index < 0) return false;
		if(index > productList.length || index < 1) {
			System.out.println("There are no products with this ID. Check the list and try again.");
			printOutProductList();
			return false;
		}
		System.out.println(productList[--index].getInfoLine());
		return true;
	}*/
	
	public boolean waitForUserID = false;
	public boolean waitForProductID = false;
	
	public void buy(int stage) {
		if(waitForProductID) {
			
		} else if(waitForUserID) {
			System.out.println("Now enter ID of the product.");
			waitForUserID = false;
			waitForProductID = true;
		} else {
			System.out.println("To purchase a product, enter your user ID.");
			waitForUserID = true;
		}
		/*switch (stage) {
			case 0:
				System.out.println("To purchase a product, enter your user ID.");
				break;
			case 1:
				//System.out.println("To purchase a product, enter its ID.");
		}*/
		//System.out.println("To purchase a product, enter its ID.");
		/*Scanner in = new Scanner(System.in);
		
		boolean oneMoreTime = true;
		while(oneMoreTime) {
			String command = in.nextLine();
			//checkMainCommands(command);
			
			System.out.println("Enter your next command");
		}
		in.close();*/
	}
}