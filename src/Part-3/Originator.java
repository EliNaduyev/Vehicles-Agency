/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import java.awt.Color;
import java.util.ArrayList;

import Hw_2.IVehicle;
import Hw_2.Marine;
import Hw_2.Vehicle;
import Hw_3.MainPage;

/**
 * class Originator
 * @author Eliran and Maria
 */
public class Originator {
	
	private ArrayList<ArrayList<Object>> listOLists = new ArrayList<ArrayList<Object>>();
	
	/**
	 * constructor of class ColorDecorator
	 */
	public Originator() {
		for (int i=0;i<3;i++)
			listOLists.add(i,new ArrayList<Object>());
	}
	
	/**
	 * the function saves the objects to one big object
	 * @param arrOfCars array of vehicles
	 * @param arrOfMarines array of vehicles from type Marine
	 * @param arrOfImages array of images
	 */
	public  void setState(ArrayList<IVehicle> arrOfCars,ArrayList<IVehicle> arrOfMarines,ArrayList<String> arrOfImages) {
		for (int i=0;i<MainPage.arrOfCars.size();i++) {
			IVehicle tmp;
			Vehicle car=arrOfCars.get(i).clone();
			if (arrOfCars.get(i).getColor() == Color.BLUE)
				tmp=new StatusDecorator(new  CarColorBlue(car));
			else if (arrOfCars.get(i).getColor() == Color.RED)
				tmp=new StatusDecorator(new CarColorRed(car));
			else
				tmp=new StatusDecorator(new CarColorYellow(car));
			Vehicle.setTotal(Vehicle.getTotal()-tmp.getDistance());
			listOLists.get(0).add(tmp);
			listOLists.get(1).add(arrOfImages.get(i));
			if(car instanceof Marine)
				listOLists.get(2).add(tmp);
		 }
	 }
	 
	/**
	 * returns the saved object
	 * @return the saved object
	 */
	 public ArrayList<ArrayList<Object>> getState(){return listOLists;}
	
	 /**
	  * create the memento
	  */
	 public Memento createMemento() {
		 return new Memento(listOLists);
	 }
	 
	 /**
	  * save the memento
	  * @param memento the memento
	  */
	 public void setMemento(Memento memento) {
		 this.listOLists=memento.getState();
	 }
	
	
	
	

}
