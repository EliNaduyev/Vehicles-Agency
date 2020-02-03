/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class Bicycle
 * @author Eliran and Maria
 */
public class Bicycle extends Vehicle implements Not_motorized,Terrestrial,Cloneable {
	private String road;

	/**
	 * constructor of class Bicycle
	 * @param model The model of the vehicle
	 * @param seats The maximal number of seats
	 * @param speed The maximal speed
	 * @param road The road the vehicle intended travel on it 
	 */
	public Bicycle(String model, int seats, double speed, String road) {
		super(model, seats, speed);
		this.road=road;
	}

	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public Bicycle clone() {
		Bicycle tmp=new Bicycle(super.getModel(), super.getMaxSeats(), super.getMaxSpeed(), road);
		tmp.movement(super.getDistance());
		return tmp;
		}
	
	/** 
	 * returns the power source
	 * @return power source
	 */
	@Override
	public String getPowerSource() {return "manual";}

	/** 
	 * returns the energetic type
	 * @return energetic type
	 */
	@Override
	public char getEnergeticType() {return 'A';}
	
	/**
	 * returns number of wheels
	 * @return number of wheels
	 */
	@Override
	public int getWheels() {return 2;}

	/**
	 * returns info about the the road the vehicle intended travel on it  
	 * @return paved or dirt
	 */
	@Override
	public String getRoad() {return road;}
	
	/**
	 * @return returns the color of the vehicle
	 */
	@Override
	public Color getColor() {
		return null;
	}
	
	/**
	 * not supported function for this class 
	 */
	@Override
	public void setStatus(String s) {
		return;
	}
	
	/**
	 * not supported function for this class  
	 */
	@Override
	public void setCountryFlag(String name) {
			return;
	}
	
	/**
	 * A boolean function that compare the fields of 2 objects
	 */
	public boolean equal(Object obj) {
		if (!(obj instanceof Bicycle))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (!(this.road).equals(((Bicycle)obj).road)) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		return "Bicycle:"+ super.toString()+" num of wheels: 2, and the road is: "+ road
		+" power source: manual, energetic type: A ";}



}
