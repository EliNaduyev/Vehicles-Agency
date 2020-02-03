/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

import Hw_2.IVehicle;
import Hw_4.*;

/**
 * class TestDrive in GUI implements Runnable
 * @author Eliran and Maria
 */
public class TestDrive implements Runnable{
	
	private  JFrame frameOfTestDrive;
	private  JPanel testDrivePanel;
	private JButton btn1,btn2;
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private Image newImg1;
	private int flag;
	private JTextField textField1;
	private JLabel label1,label2;
	private double dist;
	private IVehicle obj;
	private static int tcount=0;

	private static  ArrayList<Observer> observerList=new ArrayList<Observer>();
	private boolean state;
	private static ExecutorService pool=Executors.newFixedThreadPool(7);

	
	
	/**
	 * constructor of class TestDrive
	 * @param f index of the vehicle in database
	 * @param obj the vehicle on the index in database
	 */
	public TestDrive (int f,IVehicle obj) 
	{
		tcount++;
		this.flag=f;
		this.obj=obj;
	}
	/**
	 * constructor of class TestDrive
	 */
	public TestDrive () {
		
	}
	
	/**
	 * Run function,activates when thread of TestDrive started or when it is called directly by object from the class 
	 */
	public void run () {

		frameOfTestDrive = new JFrame("Test Drive");
		frameOfTestDrive.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfTestDrive.setBounds(85, 30, 1155, 700);
		frameOfTestDrive.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfTestDrive.getContentPane().setLayout(null);
		
		testDrivePanel=new JPanel();
		testDrivePanel.setBounds(52, 50, 1040, 565);
		testDrivePanel.setBackground(Color.DARK_GRAY);
		testDrivePanel.setLayout(null);
		testDrivePanel.setVisible(true);
		
		
	//-----------------------Buttons----------------------------
		
		
		btn1 = new JButton("Back");
		newImg1 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				flag=-1;
				textField1.setText("");
				frameOfTestDrive.dispose();
				tcount--;
			}
		});
		btn1.setBounds(430, 530, 170, 48);
		testDrivePanel.add(btn1);
		
		btn2 = new JButton("Continue");
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg1));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dist=Double.parseDouble(textField1.getText());
					frameOfTestDrive.dispose();
					SwingWorker<Void, Void> worker=new SwingWorker<Void, Void>() {
	                    @Override
	                    protected Void doInBackground() {
	                    	try {
		                    	synchronized(MainPage.arrOfCars.get(flag)) {
		                    		if(MainPage.arrOfCars.get(flag).equal(obj))
			                    		tDrive();
		                    		else 
		                    			throw new Exception();
		                    	}
	                    	}
	                    	catch (Exception e){tcount--;}
            				setState(true);
							return null;
	                    }    
	                };
					pool.execute(worker);

				}
				catch(Exception c)
				{
					c.printStackTrace();
					JOptionPane.showMessageDialog(testDrivePanel,"Wrong insertion.");
					textField1.setText("");
				}
			}
		});
		btn2.setBounds(100, 530, 170, 48);
		testDrivePanel.add(btn2);
		
	//-----------------------Text Field----------------------------
		
		
		textField1 = new JTextField("",10);
		textField1.setBounds(150, 120, 210, 36);
		testDrivePanel.add(textField1);

		
	//-----------------------Labels----------------------------
		
		label1 = new JLabel("Test Drive");
		label1.setBounds(320, 0, 275, 33);
		label1.setForeground(new Color(255, 239, 213));
		label1.setBackground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		testDrivePanel.add(label1);
		
		label2 = new JLabel("Enter the distance:");
		label2.setForeground(new Color(255, 239, 213));
		label2.setBackground(Color.WHITE);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label2.setBounds(150, 85, 200, 23);
		testDrivePanel.add(label2);
		frameOfTestDrive.add(testDrivePanel);
		frameOfTestDrive.setVisible(true);
				
	}
	
	/**
	 * the function that doing the test drive
	 */
	private void tDrive() {
		MainPage.arrOfCars.get(flag).setStatus("In test drive");
		try {
			Thread.sleep((long) (dist *100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		(MainPage.arrOfCars.get(flag)).movement(dist);
		MainPage.arrOfCars.get(flag).setStatus("In stock");
		(MainPage.arrOfLabeles.get(flag)).setToolTipText((MainPage.arrOfCars.get(flag)).toString());
		textField1.setText("");
		flag=-1;
		tcount--;
	}

	/*
	 * returns the number of test drives that activate now
	 */
	static int getCount() {return tcount;}
	
	/*
	 * add new observer to the list of observers.
	 */
	public void addObserver(Observer o) {
		observerList.add(o);
	}
	
	/*
	 * function that call notifyAllObservers function if was a test drive.
	 */
	public void setState(boolean s) {
		this.state=s;
		if (state==true) {
			notifyAllObservers();
		}
	}
	
	/*
	 * function that notify all the observers in the list that was a test drive.
	 */
	
	public void notifyAllObservers() {

		for (Observer o:observerList) {
			o.update();
		}
	}

}
		

	
	

