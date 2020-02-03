/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class DownGame
 * @author Eliran and Maria
 */
public class DownGame extends Airborne implements Not_motorized,Cloneable{
	char energetic_type;
	
	/**
	 * constructor of class DownGame
	 */
	public DownGame() {super("toy", 0, 10, "Civilian");}

	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	@Override
	public DownGame clone() {
		DownGame tmp=new DownGame();
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
		if (!(obj instanceof DownGame))
			return false;
		if((super.equal(obj))==false) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		return "DownGame:"+ super.toString()+ "power source: manual, energetic type: A";}

	


}

