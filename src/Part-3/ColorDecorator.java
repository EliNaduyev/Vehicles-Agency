/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import java.awt.Color;

import Hw_2.*;

/**
 * abstract class ColorDecorator implements IVehicle
 * @author Eliran and Maria
 */
public abstract class ColorDecorator implements IVehicle{
	
	protected IVehicle vehicle;

	/**
	 * constructor of class ColorDecorator
	 * @param v the vehicle object
	 */
	public ColorDecorator(IVehicle v) {
		this.vehicle=v;
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public Vehicle clone() {return vehicle.clone();}

	/**
	* add to The total distance the vehicle passed
	 * @param dis:distance the vehicle passed
	 */
	public void movement(double dis) {vehicle.movement(dis);}
		
	/**
	 * info about model
	 * @return model 
	 */
	public String getModel() {return vehicle.getModel();}
	
	/**
	 * info about total distance 
	 * @return total distance
	 */
	public double getDistance() {return vehicle.getDistance();}
	
	/**
	 * info about max seats
	 * @return max seats 
	 */
	public int getMaxSeats() {return vehicle.getMaxSeats();}
	
	/**
	 * info about max speed 
	 * @return max speed 
	 */
	public double getMaxSpeed() {return vehicle.getMaxSpeed();}
	
	/**
	 * A boolean function that compare the fields of all who derive of it
	 */
	public boolean equal(Object obj) 
	{			
		IVehicle t= (IVehicle) obj;
		Vehicle tmp=t.clone();
		Vehicle.setTotal(Vehicle.getTotal()-tmp.getDistance());
		return vehicle.equal(tmp);
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString()  {return vehicle.toString();}
	
	/**
	 * returns the color of the vehicle
	 */
	abstract public Color getColor();
	
	/**
	 * change the country flag the you sailing with
	 * @param name 
	 */
	@Override
	public void setCountryFlag(String name) {
			vehicle.setCountryFlag(name);
	}
		
}

	
	
