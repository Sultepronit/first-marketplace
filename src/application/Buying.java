package application;

public class Buying {
	static byte status = 0;
	static int userIndex = 0;
	static int productIndex = 0;
	
	static void buy() {
		System.out.print("Do you confirm the purchase of ");
		System.out.print(Database.productList.get(productIndex).name);
		System.out.print(" by ");
		System.out.print(Database.userList.get(userIndex).name);
		System.out.println("?\nEnter Y/N");
		status = 5;
	}
	
	static void confirm() {
		double sum = Database.userList.get(userIndex).money - Database.productList.get(productIndex).price;

		if(sum < 0) {
			System.out.println("Error! The price exceeds your amount of money!");
		}
		else {
			Database.userList.get(userIndex).money = sum;
			System.out.print("Success! Your account balance is now: ");
			System.out.println(Database.userList.get(userIndex).moneyToString());
			
			int[] record = {
					Database.userList.get(userIndex).intId, 
					Database.productList.get(productIndex).intId
					};
			Database.purchases.add(record);
			Database.userList.get(userIndex).purchaseCount++;
			Database.productList.get(productIndex).purchaseCount++;
		}
		
	}	

	
}
