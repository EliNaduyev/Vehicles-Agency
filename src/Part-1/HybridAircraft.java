/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class HybridAircraft
 * @author Eliran and Maria
 */
public class HybridAircraft extends Airborne implements Terrestrial,Marine,Motorized,Cloneable   {
	
	private	String flag;
	private int numWheels;
	private double avg_fuel;
	private boolean wind_d;
	private float life_time;
	
	/**
	 *constructor of class Hybrid Aircraft
	 * @param model The model of the vehicle
	 * @param seats The maximal number of seats
	 * @param speed The maximal speed
	 * @param life_time The average life time of the vehicle
	 * @param avg_fuel The average fuel of the vehicle
	 * @param wind_d  The Hybrid Aircraft sailing with the wind direction?
	 * @param flag The flag of the Hybrid Aircraft
	 * @param numWheels The number of wheels
	 */
	public HybridAircraft(String model, int seats, double speed,float life_time,double avg_fuel,boolean wind_d,String flag,int numWheels) 
	{
		super(model, seats, speed, "Military");
		this.life_time=life_time;
		this.avg_fuel=avg_fuel;
		this.wind_d=wind_d;
		this.flag=flag;
		this.numWheels=numWheels;
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public HybridAircraft clone() {
		
		HybridAircraft tmp=new HybridAircraft(super.getModel(), super.getMaxSeats(), 
				super.getMaxSpeed(),life_time,avg_fuel,wind_d,flag, numWheels);
		tmp.movement(super.getDistance());
		tmp.setCountryFlag(flag);
		return tmp;
		}
	

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
	public void setWind(boolean x) {this.wind_d=x;}

	/**
	 * change the country flag the you sailing with
	 * @param name 
	 */
	@Override
	public void setCountryFlag(String name) {this.flag=name;}

	/**
	 * give you the wind direction 
	 * @return boolean about wind direction 
	 */
	@Override
	public boolean getWind() {return wind_d;}

	/**
	 * give you the country flag the you sailing with 
	 * @return name of country 
	 */
	@Override
	public String getCountryFlag() {return flag;}

	/**
	 * returns number of wheels
	 * @return number of wheels
	 */
	@Override
	public int getWheels() {return numWheels;}

	/**
	 * returns info about the the road the vehicle intended travel on it  
	 * @return paved or dirt
	 */
	@Override
	public String getRoad() {return "paved";}
	
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
	public boolean equal(Object obj) 
	{
		if (!(obj instanceof HybridAircraft))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (this.life_time != ((HybridAircraft)obj).life_time) {return false;}
		if (this.avg_fuel != ((HybridAircraft)obj).avg_fuel) {return false;}
		if (this.wind_d != ((HybridAircraft)obj).wind_d) {return false;}
		if (!(this.flag).equals(((HybridAircraft)obj).flag)) {return false;}
		if (this.numWheels != ((HybridAircraft)obj).numWheels) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() 
	{
		String temp;
		if(wind_d==true) {temp="with the wind. ";}
		else {temp="without the wind. ";}
		return "Hybrid Aircraft: "+super.toString()+" num of wheels: "+ numWheels + " , and the road is: paved. Under "
			+flag+" flag, "+temp+" Engine: "+ avg_fuel +" L, life time of " + life_time +" years. ";
	}
	

}
