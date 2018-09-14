import java.util.*;

class Item {
	String productName;
	int productquantity;
	double unitPrice;
	public Item(String productName, String productquantity, String unitPrice) {
		this.productName = productName;
		this.productquantity = Integer.parseInt(productquantity);
		this.unitPrice = Double.parseDouble(unitPrice);
	}
	public Item(String productName, String productquantity) {
		this.productName = productName;
		this.productquantity = Integer.parseInt(productquantity);
	}

	public String toString() {
		return this.productName + " " + this.productquantity+ " " + this.unitPrice;
	}

	public boolean equals(Item other) {
		if (!this.productName.equals(other.productName)) {
			return false;
		}
		return true;
	}
}
 class ShoppingCart {
	int size1;
	int size2, k = 1;
	Item[] catalog;
	Item[] cart;
	String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static boolean couponApplied = false;
	ShoppingCart() {
		catalog = new Item[20];
		cart = new Item[20];
		size1 = 0;
		size2 = 0;
	}
	public void addToCatalog(Item item) {
		catalog[size1++] = item;
	}
	public void addToCart(Item item) {
		if (!inCart(item)) {
		if (checkCatalog(item)) {
			cart[size2++] = item;
		}
	}
	}
	private boolean checkCatalog(Item item) {
		for (Item i : catalog) {
			if (i != null) {
				if (i.equals(item)) {
					if (item.productquantity <= i.productquantity) {
						i.productquantity = i.productquantity - item.productquantity;
						return true;
					}
				}
			}
		}
		return false;
	} 
	public void removeFromCart(Item item) {
		for (int i = 0; i < size2; i++) {
			if (item.equals(cart[i])) {
				cart[i].productquantity = cart[i].productquantity - item.productquantity;
			}	
		}		
	}
	boolean inCart (Item item) {
		for (Item s : cart) {
			if (s != null) {
				if (s.equals(item)) {
					s.productquantity = s.productquantity + item.productquantity;
					return true;
				}
			}
		}
		return false;
	}
	public void showCart() {
		for(Item i : cart) {
			if (i != null) {
				if (i.productquantity != 0) {
					System.out.println(i.productName+ " " + i.productquantity);
				}
			}
		}
	}
	public void showCatalog() {
		for(Item i : catalog) {
			if (i != null) {
			System.out.println(i);
		}
		}
	}
	double getPrice(Item item) {
		for (Item i : catalog) {
			if (i != null) {
				if(i.equals(item)) {
					return i.unitPrice;
				}
			}
		}
		return 0.0;
	}
	double getTotalAmount(){
		double total=0;
		for(int i =0; i< size2; i++){
			total += cart[i].productquantity * getPrice(cart[i]);
		}
		return total;
	}
	public double getPayableAmount() {
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal * 15/100;
		return newTotal + tax;


	}
	public void applyCoupon(String coupon) {
		// double discount = 0.0;

		if (couponApplied) {
			// System.out.println("Invalid coupon");
			return;
		}
		boolean valid = false;
		if (k == 1){
			for (String s : validCoupons) {
				if (s.equals(coupon)) {
					int num = Integer.parseInt(coupon.substring(3));
					discount = getTotalAmount() * num/100;
					valid = true;
					couponApplied = true;
					k++;
				}
			}
		}
		if (!valid) {
			System.out.println("Invalid coupon");
			return;
		}
	}
	void printInVoice() {
		System.out.println("Name   quantity   Price");
		for (Item i : cart) {
			if (i != null) {
				if (i.productquantity != 0) {
			System.out.println(i.productName+ " "+ i.productquantity+ " " + getPrice(i));
		}
	}
	}
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal * 15/100;
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:"+discount);
		System.out.println("Tax:"+ tax);
		System.out.println("Payable amount:" + getPayableAmount());
	}

}

class Solution {
	public static void main(String[] args) {
		ShoppingCart shop = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int lines = Integer.parseInt(sc.nextLine());
		for (int i=0; i < lines; i++) {
			String[] input = sc.nextLine().split(" ");
			switch(input[0]) {
				case "catalog":
				shop.showCatalog();
				break;
				case "add":
				String[] tokens1 = input[1].split(",");
				shop.addToCart(new Item(tokens1[0],tokens1[1]));
				break;
				case "remove":
				String[] tokens2 = input[1].split(",");
				shop.removeFromCart(new Item(tokens2[0],tokens2[1]));
				break;
				case "print":
				shop.printInVoice();
				break;
				case "Item":
				String[] tokens = input[1].split(",");
				shop.addToCatalog(new Item(tokens[0],tokens[1],tokens[2]));
				break;
				case "show":
				shop.showCart();
				break;
				case "totalAmount":
				System.out.println("totalAmount: " + shop.getTotalAmount());
				break;
				case "payableAmount":
				System.out.println("Payable amount: " + shop.getPayableAmount());
				break;
				case "coupon":
				shop.applyCoupon(input[1]);
				break;
				default:
				break;
			}
			
		}
		
	}
}