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
	/*for(int i = 0; i < userList.length; i++) {
		userList[i] = new User();
	}*/
	userList[0] = new User("John", "Smith", 10000.00);
	userList[1] = new User("Anna", "Yamada", 2000.00);
	userList[2] = new User("Stepan", "Muts", 359.75);
	}

	public static void main(String[] args) {
		
		System.out.println("Hello! This marketplace app have no GUI.\nJust follow simple instructions here.");
		
		createDatabase();
		
		System.out.println(productList[1].name);
		System.out.println(productList[1].id);
		
		System.out.println(userList[2].id);
		System.out.println(userList[2].money);
	}

}
