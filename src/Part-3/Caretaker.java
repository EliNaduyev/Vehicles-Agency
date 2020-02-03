/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */
package Hw_4;

/**
 * class Caretaker
 * @author Eliran and Maria
 */
public class Caretaker {
	
	private static Memento[] stateList=new Memento[3];

	/**
	 * constructor of class Caretaker
	 * @param m the memento
	 * @param index the index where we want to save it
	 */
	public void addMemento(Memento m,int index) {
		stateList[index]= m;
	}
	
	/**
	 * returns the last memento that was saved 
	 * @param index the index where the last saved object is
	 * @return the last memento that was saved 
	 */
	public Memento getMemento(int index) {
		Memento m=stateList[index];
		stateList[index]=null;
		return m;
		}
}
