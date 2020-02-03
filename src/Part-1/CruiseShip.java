/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class CruiseShip
 * @author Eliran and Maria
 */
public class CruiseShip extends Vehicle implements Marine,Motorized,Commercial,Cloneable{
	private double avg_fuel;
	private float life_time;
	private boolean wind_direction;
	private String flag;
	
	/**
	 * constructor of class CruiseShip
	 * @param model The model of the vehicle
	 * @param seats The maximal number of seats
	 * @param speed The maximal speed
	 * @param flag The flag of the Cruise Ship
	 * @param avg_fuel The average fuel of the vehicle
	 * @param life_time The average life time of the vehicle
	 */
	public CruiseShip(String model, int seats, double speed, String flag,double avg_fuel,float life_time) {
		super(model, seats, speed);
		this.avg_fuel=avg_fuel;
		this.life_time=life_time;	
		this.wind_direction=true;
		this.flag=flag;
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public CruiseShip clone() {
		CruiseShip tmp=new CruiseShip(super.getModel(), super.getMaxSeats(),super.getMaxSpeed(), flag, avg_fuel, life_time);
		tmp.movement(super.getDistance());
		tmp.setCountryFlag(flag);
		return tmp;
		}
	

	/**
	 * returns the license type
	 * @return license type
	 */
	@Override
	public String getLicenseType() {return "Unlimited";}

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
	public void setAverageFuelConsumption(double fuel) {this.avg_fuel=fuel;}

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
	 * decide whether you are sailing with the direction of the wind or not
	 * @param x:boolean can be true or false
	 */
	@Override
	public void setWind(boolean x) {wind_direction=x;}

	/**
	 * change the country flag the you sailing with
	 * @param name 
	 */
	@Override
	public void setCountryFlag(String name) {flag=name;}
	
	/**
	 * give you the wind direction 
	 * @return boolean about wind directon 
	 */
	@Override
	public boolean getWind() {return wind_direction;}
	
	/**
	 * give you the country flag the you sailing with 
	 * @return name of country 
	 */
	@Override
	public String getCountryFlag() {return flag;}
	
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
	 * A boolean function that compare the fields of 2 objects
	 */
	public boolean equal(Object obj) {
		if (!(obj instanceof CruiseShip))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (this.life_time != ((CruiseShip)obj).life_time) {return false;}
		if (this.avg_fuel != ((CruiseShip)obj).avg_fuel) {return false;}
		if (this.wind_direction != ((CruiseShip)obj).wind_direction) {return false;}
		if (!(this.flag).equals(((CruiseShip)obj).flag)) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		String temp;
		if(wind_direction==true) {temp="with the wind. ";}
		else {temp="without the wind. ";}
		return "Cruise Ship:"+ super.toString()+" Under "+flag+" flag, "+ temp +" license type: Unlimited.  Engine:"+ avg_fuel +
				" L, life time of " + life_time +" years. ";}


}
