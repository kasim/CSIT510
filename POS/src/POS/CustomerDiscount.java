package POS;

public class CustomerDiscount implements Discount {
	private float discount;
	CustomerDiscount(float _discount) {
		discount = _discount;
	}
	public float discount() {
		// TODO Auto-generated method stub
		return discount;
	}
	public String discountMessage() {
		String message = "\tMembership Discount: " + discount*100 + "%" + "\n";
		return message;
	}
}
