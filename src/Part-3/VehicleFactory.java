/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import Hw_2.Vehicle;

public interface VehicleFactory {
	/**
	 * all the factories that want to create vehicles 
	 * will implements the interface .
	 * @param type - type of the vehicle we will create.
	 *  @return Thread 
	 */
	public Thread createVehicle(String type);

}
