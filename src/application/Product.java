package application;

public class Product {
	static int idCount = 1;
	public int index;
	public String id;
	public String name;
	public double price;
	public int purchaseCount = 0;
	
	Product(String name, double price) {
		index = idCount - 1;
		Database.productIndexChanges.add( Database.productList.size() );
		id = "P"+String.format("%04d", idCount++);
		this.name = name;
		this.price = price;
	}
	
	public String[] getInfo() {
		return new String[] {id, name, String.format("%.2f",price)};
	}
	
	public void infoOut() {
		System.out.print(id + ": " + name + ", price: " + String.format("%.2f",price));
		if(purchaseCount > 0 && Buying.status < 1) {
			StringBuilder list = new StringBuilder("");
			int n = 0;
			for( int i = 0; i < Database.purchases.size(); i++) {
				if(n >= purchaseCount) break;
				if(index == Database.purchases.get(i)[1]) {
					int userIndex = Database.purchases.get(i)[0];
					list.append(Database.userList.get(userIndex).id).append(" ");
					list.append(Database.userList.get(userIndex).name).append("\n");
					n++;
				}
			}
			purchaseCount = n;
			if(list.length() > 1) {
				System.out.print("; was purchased by: \n" + list.toString());
			}
		}
		System.out.println("");
	}
	
}
