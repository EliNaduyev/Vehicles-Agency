/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class Jeep
 * @author Eliran and Maria
 */
public class Jeep extends Vehicle implements Motorized ,Commercial,Terrestrial,Cloneable {
	private double avg_fuel;
	private float life_time;
	
	/**
	 * constructor of class Jeep
	 * @param model The model of the vehicle
	 * @param avgFuel The average fuel of the vehicle
	 * @param speed The maximum speed 
	 * @param avgLifeTime The average life time of the vehicle
	 */
	public Jeep(String model,double avgFuel, double speed,float avgLifeTime) {
		super(model, 5, speed);
		avg_fuel=avgFuel;
		life_time=avgLifeTime;
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public Jeep clone() {
		Jeep tmp=new Jeep(super.getModel(), avg_fuel, super.getMaxSpeed(),life_time);
		tmp.movement(super.getDistance());
		return tmp;
		}
	

	/**
	 * returns the license type
	 * @return license type
	 */
	@Override
	public String getLicenseType() {return "MINI";}
	
	/**
	 * update average life time
	 * @param life_time The average life time of the vehicle
	 */
	@Override
	public void setAverageLifeTime(float life_time) {this.life_time=life_time;}
	
	/**
	 * update average fuel
	 * @param fuel The average fuel of the vehicle
	 */
	@Override
	public void setAverageFuelConsumption(double fuel) {avg_fuel=fuel;}
	
	/**
	 * returns average life time
	 * @return average life time
	 */
	@Override
	public float getAverageLifeTime() {return life_time;}
	
	/**
	 * returns average fuel
	 * @return average fuel
	 */
	@Override
	public double getAverageFuelConsumption() {return avg_fuel;}
	
	/**
	 * returns number of wheels
	 * @return number of wheels
	 */
	@Override
	public int getWheels() {return 4;}

	/**
	 * returns info about the the road the vehicle intended travel on it  
	 * @return paved or dirt
	 */
	@Override
	public String getRoad() {return "dirt";}
	
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
		if (!(obj instanceof Jeep))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (this.life_time != ((Jeep)obj).life_time) {return false;}
		if (this.avg_fuel != ((Jeep)obj).avg_fuel) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		return "Jeep:"+ super.toString() +"Number of wheels: 4 , and the road is: dirt, license type: MINI. Engine: "
				+ avg_fuel + "L, life time of " + life_time +" years. ";}


	
}
