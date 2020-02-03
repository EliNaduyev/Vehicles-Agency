/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

import java.util.ArrayList;

/**
 * class Memento
 * @author Eliran and Maria
 */
public class Memento {
	private ArrayList<ArrayList<Object>> listOLists = new ArrayList<ArrayList<Object>>();
	
	/**
	 * constructor of class Memento
	 * @param lol the object we want to save
	 */
	 public  Memento(ArrayList<ArrayList<Object>> lol) {
		 this.listOLists = lol;
		
	 }
	 
	 /**
	  * return the object we saved
	  * @return the object we saved
	  */
	 public ArrayList<ArrayList<Object>> getState(){return listOLists;}
	 
	 
	 
	 

}
