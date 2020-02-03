/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import Hw_3.DownGameInit;
import Hw_3.DownSpywareInit;

public class AirFactory implements VehicleFactory {

	
	/**
	 * Factory that create air vehicles.
	 * @param type- specific vehicle from the factory that we want to create.
	 *  @return Thread 
	 */
	@Override
	public Thread createVehicle(String type) {
		
		if ("Down Spyware".equals(type)) {
			Thread downspyware=new Thread(new DownSpywareInit());
			return downspyware;
		}
		else  {
			Thread downGame=new Thread(new DownGameInit());
			return downGame;
			
		}
		
		
	}

}
