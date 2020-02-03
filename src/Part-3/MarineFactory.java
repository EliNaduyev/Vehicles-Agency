/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;


import Hw_3.*;
import Hw_2.*;
public class MarineFactory implements VehicleFactory {

	/**
	 * Factory that create marine vehicles.
	 * @param type - specific vehicle from the factory that we want to create.
	 *  @return Thread 
	 */
	@Override
	public Thread createVehicle(String type) {
		
		
		if ("Frigate".equals(type)) {
			Thread frigate = new Thread(new FrigateInit());
			return frigate;
		}
		else {
			Thread cruiseship=new Thread(new CruiseShipInit());
			return cruiseship;
		}
		
		
	}

}
