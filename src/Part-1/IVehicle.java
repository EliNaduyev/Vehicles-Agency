/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_2;

import java.awt.Color;

/**
 * interface IVehicle
 * @author Eliran and Maria
 *
 */
public interface IVehicle {

public Vehicle clone();
	
	/**
	 * add to The total distance the vehicle passed
	 * @param dis:distance the vehicle passed
	 */
	public void movement(double dis);
	
	/**
	 * info about model
	 * @return model 
	 */
	public String getModel();
	
	/**
	 * info about total distance 
	 * @return total distance
	 */
	public double getDistance( );
	
	/**
	 * info about max seats
	 * @return max seats 
	 */
	public int getMaxSeats();
	
	/**
	 * info about max speed 
	 * @return max speed 
	 */
	public double getMaxSpeed();
	
	/**
	 * A boolean function that compare the fields of all who derive of it
	 */
	public boolean equal(Object obj);
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString();
	
	/**
	 * @return returns the color of the vehicle
	 */
	public Color getColor();
	
	/**
	 * updating the status of the vehicle
	 * @param s the new status
	 */
	public void setStatus(String s);
	
	/**
	 * change the country flag the you sailing with
	 * @param name 
	 */
	public void setCountryFlag(String name);


}
