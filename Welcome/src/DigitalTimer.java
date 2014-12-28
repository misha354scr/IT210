public class DigitalTimer {

	/**
	 * Creates a timer initialized to 00:00
	 */
	private Counter hours;
	private Counter minutes;
	
	public DigitalTimer(){
		hours = new Counter(24);
		minutes = new Counter(60);
	}	
	
	/**
	 * Creates a timer initialized to hours:minutes
	 * Precondition: 0 <= hours <= 23 and 0 <= minutes <= 59
	 *  
	 * @param hours value for hours part of timer
	 * @param minutes value of minutes part of timer
	 */
	public DigitalTimer(int hours, int minutes)
	{
		this.hours = new Counter(24);
		this.hours.set(hours);
		
		this.minutes = new Counter(60);
		this.minutes.set(minutes);		
	}
	
	
	/**
	 * @return the time in hours:minutes format
	 */
	public String toString(){
		return String.format(hours.toString() + ":" + minutes.toString());
	}
	
	
	/**
	 * Increases the time by a minute, wrapping if necessary
	 */
	public void tick(){
		minutes.tick();
		
		if (minutes.getValue() == 0)
			hours.tick();
	} //end of tick()	
	
	
	/**
	 * Sets the current time to hours:minutes.
	 * Precondition: 0 <= hours <= 23 and 0 <= minutes <= 59
	 * 
	 * @param hours value for hours part of timer 
	 * @param minutes value for minutes part of timer
	 */
	public void set(int hours, int minutes){
		this.minutes.set(minutes);
		this.hours.set(hours);		
	}
	
}
