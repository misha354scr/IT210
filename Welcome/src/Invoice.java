public class Invoice {

	private String partNo;
	private String description;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String partNo, String description, int quantity, double pricePerItem){
		this.partNo = partNo;
		this.description = description;
		this.quantity = (int)ensureNonNegative(quantity);
		this.pricePerItem = ensureNonNegative(pricePerItem);
	}
	
	public void setPartNo(String partNo){
		this.partNo = partNo;
	}
	
	public String getPartNo(){
		return partNo;
	}
	
	public void setDescription(String description){
		this.description = description;		
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setQuantity(int quantity){
		this.quantity = (int)ensureNonNegative(quantity);
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void setPricePerItem(double pricePerItem){
		this.pricePerItem = ensureNonNegative(pricePerItem);
	}
	
	public double getPricePerItem(){
		return pricePerItem;				
	}
	
	public double getInvoiceAmount(){
		return quantity * pricePerItem;
	}
	
	private double ensureNonNegative(double number){
		if (number <= 0) return 0;
		else return number;
	}
	
	public String toString(){
		return String.format("Part number: %s\n" + 
						  "Description: %s\n" + 
						  "Quantity: %d\n" + 
						  "Invoice Amount: %.2f", partNo, description, quantity, getInvoiceAmount());
	}
}
