/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

public class CreateFactory {
	
	/**
	 * create factory according to type the function get.
	 * @param type - the type of the factory we want to create.
	 *  @return object symbolizes a certain factory
	 */
	
	public static VehicleFactory createVehicleFactory(String type) {
		
		if ("Terra".equals(type))
			return new TerraFactory();
		else if ("Marine".equals(type))
			return new MarineFactory();
		else if ("Air".equals(type))
			return new AirFactory();
		else if ("TerraMarine".equals(type))
			return new TerraMarineFactory();
		else
			return new AllTypeFactory();
		
		
	}
		
			
		
		
	
	
	

}
