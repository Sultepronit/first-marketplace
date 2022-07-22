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
	
	static void printOutList(Unit[] list) {	
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
		System.out.println("Amount of money:");
		
		for(int i = 0; i < 3; i++) {
			String[] info = list[i].getInfo();
			System.out.format(tableFormat, info[0], info[1]);
			System.out.format(numberFormat, info[2]);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Hello! This marketplace app have no GUI.\nJust follow simple instructions here.");
		
		createDatabase();
		
		printOutList(userList);
		printOutList(productList);	
		
		/*System.out.println(productList[1].name);
		System.out.println(productList[1].id);
		
		System.out.println(userList[2].id);
		System.out.println(userList[2].money);*/
	}

}
