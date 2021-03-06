/** 
 * Counter.java

 * Defines a class of Counter objects. A Counter holds a single integer
 * in the range 0..(myLimit - 1). Each time tick is called the Counter's
 * value increases, wrapping back to 0 when it reaches myLimit.

 * Note: The toString method always returns at least 2 digits, padding with
 * a leading 0 if necessary. \
 * 
 * @author Don Kreider, based on an example in Decker and Hirshfield
 * @author Scot Drysdale, converted to Java and made later modifications
 * @author Tom Cormen, also made modifications
 */
import java.text.DecimalFormat;

public class Counter {
  private int myLimit; // Upper limit on the counter
  private int myValue; // Current value

  /** 
   * Constructor for the Counter class, with initial value 0.
   * The limit is assumed to be 12. 
   */
  public Counter() {
    myLimit = 12;
    myValue = 0;
  }
  
  /** 
   * Constructor for the Counter class, with initial value 0.
   * @param limit - the upper bound for the counter 
   */
  public Counter(int limit) {
    myLimit = limit;
    myValue = 0;
  }
  
  /**
   *  Increment the value of the Counter, wrapping around if it hits the limit.
   */
  public void tick() {
    myValue++;
    if (myValue == myLimit) // Has it hit the limit?
      myValue = 0;          // Wrap if it has
  }

  /**
   * Sets the value of the Counter to newValue.  
   * If newValue is too large or is negative sets it to 0.
   * (We will learn better ways to handle errors later!)
   * 
   * @param newValue the value to reset the counter to
   */
  public void set(int newValue) {
    if(newValue >= 0 && newValue < myLimit)
    	myValue = newValue;
    else
    	myValue = 0;
  }

  /**
   *  Resets the value of the Counter to 0
   */
  public void reset() {
    set(0);        
  }

  /**
   *  return the value of the Counter.
   */
  public int getValue() {
    return myValue;
  }

  /**
   * returns a string representation, padding with a leading 0 if necessary.
   */
  public String toString() {
    DecimalFormat fmt = new DecimalFormat("00"); // Use at least 2 digits
    return fmt.format(myValue);
  }
  
  /** 
   * A main program to test the counter.  
   * (Including such testing programs is a good idea!)
   */
  public static void main(String args[]) {
    // Create variables that can reference two Counters.
    Counter c1, c2;

    c1 = new Counter(5);  // wraps at 5
    c2 = new Counter();   // wraps at 12

    final int TIMES = 50;

    System.out.println("c1\tc2\tsum");
    // Show lots of Counter values.
    for (int i = 0; i < TIMES; i++) {
      System.out.println(c1 + "\t" + c2 + "\t" + (c1.getValue() + c2.getValue()));

      // Tick both Counters.
      c1.tick();
      c2.tick();
    }
    
    c1.reset();
    c2.reset();
    System.out.println("After reset:\t" + c1 + "\t" + c2);
    c1.set(4); 
    c2.set(10);
    System.out.println("After set:\t" + c1 + "\t" + c2);
    c1.set(5); 
    c2.set(-1);
    System.out.println("After invalid:\t" + c1 + "\t" + c2);   
  }
}