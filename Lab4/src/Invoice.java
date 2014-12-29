/** 
 * Invoice.java

 * Defines a class of Invoice objects. An Invoice has 
 * a part number, a description, a quantity, and a price per item. 
 */
public class Invoice {

	private String partNo;
	private String description;
	private int quantity;
	private double pricePerItem;
	
	/** 
	* Constructor for the Invoice class.
	* @param partNo - the part number 
	* @param description - the description 
	* @param quantity - the quantity 
	* @param pricePerItem - price per item
	*/
	public Invoice(String partNo, String description, int quantity, double pricePerItem){
		this.partNo = partNo;
		this.description = description;
		this.quantity = (int)ensureNonNegative(quantity);
		this.pricePerItem = ensureNonNegative(pricePerItem);
	}
	
	/**
	* Sets the value of the part number. 
	* @param partNo the new value of part number
	*/
	public void setPartNo(String partNo){
		this.partNo = partNo;
	}
	
	/**
	* Returns the value of the part number. 
	*/	
	public String getPartNo(){
		return partNo;
	}

	/**
	* Sets the value of the part description. 
	* @param description the new description
	*/
	public void setDescription(String description){
		this.description = description;		
	}
	
	/**
	* Returns the value of the part description. 
	*/	
	public String getDescription(){
		return description;
	}

	/**
	* Sets the value of the quantity.
	* Negative quantities are changed to zero. 
	* @param quantity the new quantity
	*/
	public void setQuantity(int quantity){
		this.quantity = (int)ensureNonNegative(quantity);
	}
	
	/**
	* Returns the value of the quantity. 
	*/		
	public int getQuantity(){
		return quantity;
	}
	
	/**
	* Sets the value of the price per item.
	* Negative quantities are changed to zero. 
	* @param pricePerItem - the new pricePerItem
	*/	
	public void setPricePerItem(double pricePerItem){
		this.pricePerItem = ensureNonNegative(pricePerItem);
	}

	/**
	* Returns the value of the quantity. 
	*/		
	public double getPricePerItem(){
		return pricePerItem;				
	}

	/**
	* Returns the invoice amount,
	* which is the quantity, multiplied by the price per item. 
	*/		
	public double getInvoiceAmount(){
		return quantity * pricePerItem;
	}

	/**
	* If the argument is greater or equal to zero, returns the argument.
	* Otherwise, returns zero.
	* @param number - the number to check
	*/		
	private double ensureNonNegative(double number){
		if (number <= 0) return 0;
		else return number;
	}

	/**
	 * returns the string representation of the Invoice object
	 */
	public String toString(){
		return String.format("Part number: %s\n" + 
						  "Description: %s\n" + 
						  "Quantity: %d\n" + 
						  "Invoice Amount: %.2f", partNo, description, quantity, getInvoiceAmount());
	}
}
