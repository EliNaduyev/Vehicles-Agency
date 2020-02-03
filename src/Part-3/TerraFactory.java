/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;


import Hw_2.*;
import Hw_3.*;
public class TerraFactory implements VehicleFactory {

	/**
	 * Factory that create terrestrial vehicles.
	 * @param type - specific vehicle from the factory that we want to create.
	 *  @return Thread 
	 */
	@Override
	public Thread createVehicle(String type) {
		
		if ("Jeep".equals(type)) {
			Thread jeep=new Thread(new JeepInit());
			return  jeep;
		}
		else if ("Bicycle".equals(type)) {
			Thread bicycle=new Thread(new BicycleInit());
			return bicycle;
			
		}
		
		else {
			Thread electricBicycle = new Thread(new ElectricBicycleInit());
			return electricBicycle;
			
		}
		
		
	}
	
	

}
