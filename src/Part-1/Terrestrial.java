/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

/**
 * interface Terrestrial
 * @author Eliran and Maria
 */
public interface Terrestrial {
	
	/**
	 * info about number of wheels
	 */
	public int getWheels();
	
	/**
	 * info about the the road the vehicle intended travel on it 
	 */
	public String getRoad();
	
	/**
	 * A boolean function that compare the fields of all who derive of it
	 */
	public boolean equal(Object obj);
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString();


}
