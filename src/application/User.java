package application;

public class User {
	static int idCount = 1;
	public int intId;
	public String id;
	public String firstName;
	public String lastName;
	public double money;
	public String name;
	public int purchaseCount = 0;
	
	User(String firstName, String lastName, double money) {
		intId = idCount;
		id = "U"+String.format("%04d", idCount++);
		Database.userIdToIndex.add( Database.userList.size() );
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
		name = firstName + " " + lastName;
	}
	
	public String[] getInfo() {
		return new String[] {id, name, String.format("%.2f",money)};
	}
	
	public void infoOut() {
		System.out.print(id + ": " + name + ", amount of money: " + String.format("%.2f",money));
		if(purchaseCount > 0) {
			StringBuilder list = new StringBuilder("");
			int n = 0;
			for( int i = 0; i < Database.purchases.size(); i++) {
				if(n >= purchaseCount) break;
				if(intId == Database.purchases.get(i)[0]) {
					int productId = Database.purchases.get(i)[1];
					int productIndex = Database.productIdToIndex.get(productId);
					list.append(Database.productList.get(productIndex).id).append(" ");
					list.append(Database.productList.get(productIndex).name).append("\n");
					n++;
				}
			}
			purchaseCount = n;
			if(list.length() > 1) {
				System.out.print("; purchased: \n" + list.toString());
			}
		}
		System.out.println("");
	}
	
	public String moneyToString() {
		return String.format("%.2f",money);
	}
}
