package application;

public class User extends Unit {
	static int idCount = 1;
	public int index;
	public String id;
	public String firstName;
	public String lastName;
	public double money;
	public String name;
	public int purchaseCount = 0;
	
	User(String firstName, String lastName, double money) {
		index = idCount - 1;
		id = "U"+String.format("%04d", idCount++);
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
				if(index == Database.purchases.get(i)[0]) {
					int productIndex = Database.purchases.get(i)[1];
					list.append(Database.productList[productIndex].id).append(" ");
					list.append(Database.productList[productIndex].name).append("\n");
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
