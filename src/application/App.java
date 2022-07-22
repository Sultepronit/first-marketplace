package application;

public class App {
	
	//simple database imitation
	static Product[] productList = new Product[3];
	static String[] list = new String[3];
	static User[] userList = new User[3];
	static void createDatabase() {
		
	for(int i = 0; i < productList.length; i++) {
		productList[i] = new Product();
	}
	
	productList[0].id = "P0001";
	
	for(int i = 0; i < 3; i++) {
		//productList[i].id = "P000"+(i+1);
		list[i] = "P000"+(i+1);
	}
	
	//productList[0].name = "Oven";
	//productList[0].price = 1000.00;
	
	
	}

	public static void main(String[] args) {
		
		System.out.println("Hello! This marketplace app have no GUI. Just follow simple instructions here.");
		
		createDatabase();
		
		System.out.println(list[0]);
		//System.out.println(productList[0].id);
		
	}

}
