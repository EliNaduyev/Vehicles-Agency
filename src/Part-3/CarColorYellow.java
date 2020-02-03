/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import java.awt.Color;

import Hw_2.IVehicle;

/**
 * class CarColorYellow implements ColorDecorator and coloring the Vehicle in yellow color
 * @author Eliran and Maria
 */
public class CarColorYellow extends ColorDecorator{
	
	/**
	 * constructor of class CarColorYellow
	 * @param v the vehicle object
	 */
	public CarColorYellow(IVehicle v) {
		super(v);
	}

	/**
	 * returns the color of the vehicle
	 * @return color of the vehicle
	 */
	@Override
	public Color getColor() {
		return Color.YELLOW;
	}
	
	/**
	 * not supported function for this class  
	 */
	@Override
	public void setStatus(String s) {return;}

}
