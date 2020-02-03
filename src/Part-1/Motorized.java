/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_2;

/**
 * interface Motorized
 * @author Eliran and Maria
 */
public interface Motorized {
	
	/**
	 * change average lifetime of the engine
	 * @param life_time: lifetime of engine
	 */
	public void  setAverageLifeTime(float life_time);
	
	/**
	 * change average fuel consumption 
	 * @param fuel:fuel
	 */
	public void setAverageFuelConsumption(double fuel);
	
	/**
	 * info about average lifetime
	 * @return lifetime
	 */
	public float getAverageLifeTime();
	
	/**
	 * info about average fuel consumption
	 * @return average fuel consumption
	 */
	public double getAverageFuelConsumption();
	
}
