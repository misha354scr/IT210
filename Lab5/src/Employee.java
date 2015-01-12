import java.math.BigDecimal;
import java.text.NumberFormat;

/** 
 * Employee.java

 * Defines a class of Employee objects. An Employee has 
 * a first name, a last name, and salary. 
 */
public class Employee {
	private String firstName;
	private String lastName;
	private BigDecimal salary;
	
	/** 
	* Constructor for the Employee class.
	* @param firstName - first name
	* @param lastName - last name
	* @param salary - salary. no commas or dollar signs
	*/
	public Employee(String firstName, String lastName, String salary){
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = new BigDecimal(salary);
	}
	
	/**
	 * Sets the value of the first name to firstName.  
	 * @param firstName new value of the first name
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName; 
	}
	
	/**
	 * returns a a string holding the first name.
	 * @return a string holding the first name
	 */
	public String getFirstName(){
		return firstName;
	}

	/**
	 * Sets the value of the last name to lastName.  
	 * @param lastName new value of the first name
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	/**
	 * Returns the value of the last name.  
	 * @return firstName new value of the first name
	 */
	public String getLastName(){
		return this.lastName;
	}
	
	public BigDecimal getSalary(){
		return salary;
	}
	
	public void setSalary(BigDecimal salary){
		this.salary = salary;
	}
	
	public void setSalary(String salary){
		this.salary = new BigDecimal(salary);
	}
	
	public String toString(){
		return firstName + " " + lastName + " " +  NumberFormat.getCurrencyInstance().format(salary);
	}	
}

//Enter a number: 50739
//Digits in 50739 5 0 7 3 9
