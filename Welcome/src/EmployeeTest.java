import java.math.BigDecimal;
import java.math.RoundingMode;


public class EmployeeTest {

	public static void main(String [] args){
	Employee bob = new Employee("Bob", "Jones", "34500.00");
	Employee susan = new Employee("Susan", "Baker", "37809.00");
	
	System.out.println("Employee 1: " + bob.toString());
	System.out.println("Employee 2: " + susan.toString());
	
	System.out.println();
	
	BigDecimal salaryFactor = new BigDecimal("1.10");
	bob.setSalary(bob.getSalary().multiply(salaryFactor).setScale(2, RoundingMode.HALF_UP));
	bob.setSalary(susan.getSalary().multiply(salaryFactor).setScale(2, RoundingMode.HALF_UP));

	System.out.println("Employee 1: " + bob.toString());
	System.out.println("Employee 2: " + susan.toString());

	}
}
