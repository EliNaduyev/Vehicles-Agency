/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

/**
 * interface Marine
 * @author Eliran and Maria
 */
public interface Marine{

	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public Marine clone();
	
	/**
	 * decide whether you are sailing with the direction of the wind or not
	 * @param x: the direction of the wind
	 */
	public void setWind(boolean x);
	
	/**
	 * change the country flag the you sailing with
	 * @param name 
	 */
	public void setCountryFlag(String name);
	
	/**
	 * give you the wind direction 
	 * @return boolean about wind direction 
	 */
	public boolean getWind();
	
	/**
	 * give you the country flag the you sailing with 
	 * @return name of country 
	 */
	public String getCountryFlag();
	
	/**
	 * A boolean function that compare the fields of 2 objects
	 */
	public boolean equal(Object obj);
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString();
}
