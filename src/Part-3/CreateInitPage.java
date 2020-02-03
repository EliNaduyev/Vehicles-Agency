/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

public class CreateInitPage {
	
	/**
	 * generic function that get factory and type and create Vehicle.
	 *  @param type - the type of Vehicle we will create
	 *  @param factory - the factory that can create the desire vehicle. 
	 */
	public CreateInitPage(String type,VehicleFactory factory) {
		
		
		Thread thread= factory.createVehicle(type);
		thread.start();
	}

}
