package application;

public class Buying {
	static byte status = 0;
	static int userIndex = 0;
	static int productIndex = 0;
	
	static void buy() {
		System.out.print("Do you confirm the purchase of ");
		System.out.print(Database.productList.get(productIndex).name);
		System.out.print(" by ");
		System.out.print(Database.userList[userIndex].name);
		System.out.println("?\nEnter Y/N");
		status = 5;
	}
	
	static void confirm() {
		double sum = Database.userList[userIndex].money - Database.productList.get(productIndex).price;

		if(sum < 0) {
			System.out.println("Error! The price exceeds your amount of money!");
		}
		else {
			Database.userList[userIndex].money = sum;
			System.out.print("Success! Your account balance is now: ");
			System.out.println(Database.userList[userIndex].moneyToString());
			
			int[] record = {userIndex, productIndex};
			Database.purchases.add(record);
			Database.userList[userIndex].purchaseCount++;
			Database.productList.get(productIndex).purchaseCount++;
		}
		
	}	

	
}
