/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class DownSpyware
 * @author Eliran and Maria
 */
public class DownSpyware extends Airborne implements Not_motorized,Cloneable {
	String power_source;
	
	/**
	 * constructor of class DownSpyware
	 * @param power_source The power source of the vehicle
	 */
	public DownSpyware(String power_source) {
		super("confidential", 1, 50, "Military");
		this.power_source=power_source;
	}

	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public DownSpyware clone() {
		DownSpyware tmp=new DownSpyware(power_source);
		tmp.movement(super.getDistance());
		return tmp;
		}
	
	
	/** 
	 * returns the power source
	 * @return power source
	 */
	@Override
	public String getPowerSource() {return power_source;}

	/** 
	 * returns the energetic type
	 * @return energetic type
	 */
	@Override
	public char getEnergeticType() {return 'C';}
	
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
		if (!(obj instanceof DownSpyware))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (!(this.power_source).equals(((DownSpyware)obj).power_source)) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {return "DownSpyware:"+ super.toString()+"power source:"+ power_source + "energetic type: C";}

}
