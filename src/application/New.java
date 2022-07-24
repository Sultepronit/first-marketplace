package application;

public class New {
	
	static byte prouctStatus = 0;
	
	static String name, price;
	
	static void CreateProduct(String line) {
		switch (prouctStatus) {
			case 0:
				System.out.println("To add new product, please, enter its name");
				prouctStatus++;
				break;
				
			case 1:
				name = line;
				System.out.println("Now enter its price");
				prouctStatus++;
				System.out.println(name);
				break;
		}
		
	}
}
