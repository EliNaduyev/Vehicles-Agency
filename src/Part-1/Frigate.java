/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class Frigate
 * @author Eliran and Maria
 */
public class Frigate extends Vehicle implements Marine,Motorized,Cloneable{
	private double avg_fuel;
	private float life_time;
	private boolean wind_direction;
	private String flag;

	/**
	 * constructor of class DownGame
	 * @param model The model of the vehicle
	 * @param seats The maximal number of seats
	 * @param speed The maximal speed
	 * @param wind_d The frigate sailing with the wind direction?
	 */
	public Frigate(String model, int seats, double speed, boolean wind_d) {
		super(model, seats, speed);
		avg_fuel=500;
		life_time=4;
		wind_direction=wind_d;
		flag="Israel";
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public Frigate clone() {
		Frigate tmp=new Frigate(super.getModel(), super.getMaxSeats(), super.getMaxSpeed(),wind_direction);
		tmp.setAverageLifeTime(life_time);
		tmp.movement(super.getDistance());
		tmp.setCountryFlag(flag);
		return tmp;
		}
	

	/**
	 * update avarage life time
	 * @param life_time The avarage life time of the vehicle
	 */
	@Override
	public void setAverageLifeTime(float life_time) {this.life_time=life_time;}

	/**
	 * update avarage fuel
	 * @param fuel The avarage fuel of the vehicle
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
	 * @return boolean about wind direction 
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
		if (!(obj instanceof Frigate))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (this.life_time != ((Frigate)obj).life_time) {return false;}
		if (this.avg_fuel != ((Frigate)obj).avg_fuel) {return false;}
		if (this.wind_direction != ((Frigate)obj).wind_direction) {return false;}
		if (!(this.flag).equals(((Frigate)obj).flag)) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		String temp;
		if(wind_direction==true) {temp="with the wind. ";}
		else {temp="without the wind. ";}
		return "Frigate:" +super.toString()+" Under "+flag+" flag, "+temp+" Engine: "+ avg_fuel +
				"L, life time of " + life_time +" years. ";}


}
