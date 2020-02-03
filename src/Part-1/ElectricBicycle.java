/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

import java.awt.Color;

/**
 * class ElectricBicycle
 * @author Eliran and Maria
 */
public class ElectricBicycle extends Vehicle implements Terrestrial,Motorized,Cloneable {
	
	private double avg_fuel;
	private String road;
	private float life_time;
	
	/**
	 * constructor of class Electric Bicycle
	 * @param model The model of the vehicle
	 * @param seats The maximal number of seats
	 * @param speed The maximal speed
	 * @param life_time The average life time of the vehicle
	 * @param road The road the vehicle intended travel on it 
	 */
	public ElectricBicycle(String model,int seats,double speed,float life_time,String road) 
	{
		super(model, seats, speed);
		this.life_time=life_time;
		this.avg_fuel=20;
		this.road=road;
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	public ElectricBicycle clone() {
		ElectricBicycle tmp=new ElectricBicycle(super.getModel(), super.getMaxSeats(), super.getMaxSpeed(), life_time,road);
		tmp.movement(super.getDistance());
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
		if (!(obj instanceof ElectricBicycle))
			return false;
		if((super.equal(obj))==false) {return false;}
		if (this.avg_fuel != ((ElectricBicycle)obj).avg_fuel) {return false;}
		if (!(this.road).equals(((ElectricBicycle)obj).road)) {return false;}
		if (this.life_time != ((ElectricBicycle)obj).life_time) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		return "Electric Bicycle: " + super.toString()+" num of wheels: 2" + " , and the road is:"+ road
				+" Engine: "+ avg_fuel +" L, life time of " + life_time +" years. ";

	}



}
