/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import java.awt.Color;
import Hw_2.IVehicle;

/**
 * class CarColorBlue implements ColorDecorator and coloring the Vehicle in blue color
 * @author Eliran and Maria
 */
public class CarColorBlue extends ColorDecorator {

	/**
	 * constructor of class CarColorBlue
	 * @param v the vehicle object
	 */
	public CarColorBlue(IVehicle v) {
		super(v);
	}

	/**
	 * returns the color of the vehicle
	 * @return color of the vehicle
	 */
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	
	/**
	 * not supported function for this class  
	 */
	@Override
	public void setStatus(String s) {return;}

}
