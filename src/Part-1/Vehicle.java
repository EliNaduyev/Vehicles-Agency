/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_2;

/**
 * abstract class Vehicle
 * @author Eliran and Maria
 */
public abstract class Vehicle implements IVehicle{
	private double total_distance=0;
	private String model;
	private int max_seats;
	private double max_speed;
	private static double total;
	/**
	 * constructor of abstract class Vehicle
	 * @param model:model
	 * @param seats:max seats
	 * @param speed:max speed 
	 */
	public Vehicle(String model,int seats,double speed) {
		this.model=model;
		max_seats=seats;
		max_speed=speed;
	}
	
	/**
	 * object of the class
	 *  @return new object that clone of this class
	 */
	abstract public Vehicle clone();
	
	/**
	 * add to The total distance the vehicle passed
	 * @param dis:distance the vehicle passed
	 */
	public void movement(double dis) {
		total_distance+=dis;
		total+=dis;
		}
	public static void setTotal(double dist) {
		total=dist;		
	}

	public static double getTotal() {return total;}
	
	/**
	 * info about model
	 * @return model 
	 */
	public String getModel() {return model;}
	
	/**
	 * info about total distance 
	 * @return total distance
	 */
	public double getDistance( ) {return total_distance ;}
	
	/**
	 * info about max seats
	 * @return max seats 
	 */
	public int getMaxSeats() {return max_seats;}
	
	/**
	 * info about max speed 
	 * @return max speed 
	 */
	public double getMaxSpeed() {return max_speed;}
	
	/**
	 * A boolean function that compare the fields of all who derive of it
	 */
	public boolean equal(Object obj) {
		if (!(this.model).equals(((Vehicle)obj).model)) {return false;}
		if (this.max_seats != ((Vehicle)obj).max_seats) {return false;}
		if (this.max_speed != ((Vehicle)obj).max_speed) {return false;}
		return true;
	}
	
	/**
	 * print to screen all the data about the object
	 */
	public String toString() {
		return "Model:"+model+", traveled: "+total_distance+" Km, Max speed of "+
	max_speed+" Mph, can carry max of "+max_seats+" people. ";
	}

	
}
