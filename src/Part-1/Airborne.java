/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

/**
 * abstract class Airborne
 * @author Eliran and Maria
 */
public abstract class Airborne extends Vehicle implements Cloneable {
	private String purpose;

	/**
	 * constructor of abstract class Airborne
	 * @param model The model of the vehicle
	 * @param seats The maximal number of seats
	 * @param speed The maximal speed
	 * @param pur The use of the vehicle (Civilian/Military)
	 */
	public Airborne(String model, int seats, double speed,String pur) {
		super(model, seats, speed);
		purpose=pur;
	}

	
	/**
	 * update purpose of use
	 * @param name The use of the vehicle (Civilian/Military)
	 */
	public void setPurpose(String name) {purpose=name;}
	
	/**
	 * get purpose of use
	 * @return Purpose of use
	 */
	public String getPurpose() {return purpose;}
	
	/**
	 * A boolean function that compare the fields of 2 objects
	 */
	public boolean equal(Object obj) {
		if((super.equal(obj))==false) {return false;}
		if (!(this.purpose).equals(((Airborne)obj).purpose)) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		return super.toString()+" for "+purpose+" using ";}
	
}

