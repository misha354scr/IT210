import java.math.BigDecimal;

public class Slip {
	private int salesPersonID;
	private int productID;
	int quantity;
	double amount;

	public Slip(int productID, int salesPersonID, int quantity, double amount){
		this.salesPersonID = salesPersonID;
		this.productID = productID;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public int getSalesPersonID(){
		return salesPersonID;
	}
	
	public int getProductID(){
		return productID;
	}

}
