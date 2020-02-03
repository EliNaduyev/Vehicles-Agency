/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import Hw_3.AmphibiousInit;

public class TerraMarineFactory implements VehicleFactory{
	/**
	 * Factory that create vehicles include of marine and terrestrial parts.
	 * @param type- specific vehicle from the factory that we want to create.
	 *  @return Thread 
	 */
	@Override
	public Thread createVehicle(String type) {
		Thread amphibious=new Thread(new AmphibiousInit());
		return amphibious;
	}

}
