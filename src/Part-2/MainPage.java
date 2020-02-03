/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import Hw_2.*;
import Hw_4.*;


/**
 * class MainPage in GUI implements Runnable
 * @author Eliran and Maria
 *
 */
public class MainPage implements Runnable{
	
	private JFrame frameOfMain;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	
	private Image newImg1 = new ImageIcon(this.getClass().getResource("/xx.jpg")).getImage();
	private Image newImg2= new ImageIcon(this.getClass().getResource("/Frigate.png")).getImage();
	private Image newImg3= new ImageIcon(this.getClass().getResource("/downspyware.jpg")).getImage();
	private Image newImg4= new ImageIcon(this.getClass().getResource("/downgame.jpg")).getImage();
	private Image newImg5= new ImageIcon(this.getClass().getResource("/amphibious.jpg")).getImage();
	private Image newImg6= new ImageIcon(this.getClass().getResource("/bicycle.jpg")).getImage();
	private Image newImg7= new ImageIcon(this.getClass().getResource("/cruiseship.jpg")).getImage();
	private Image newImg8= new ImageIcon(this.getClass().getResource("/Electric Bicycle.jpg")).getImage();
	private Image newImg9= new ImageIcon(this.getClass().getResource("/Hybrid Aircraft.jpg")).getImage();

	private final Image w1 = new ImageIcon(this.getClass().getResource("/w1.png")).getImage();
	private final Image w2 = new ImageIcon(this.getClass().getResource("/w2.png")).getImage();
	private final Image w3 = new ImageIcon(this.getClass().getResource("/w3.png")).getImage();
	private final Image w4 = new ImageIcon(this.getClass().getResource("/w4.png")).getImage();

	private JSeparator separator;

	public static ArrayList<IVehicle> arrOfCars = new ArrayList<IVehicle>();
	public static ArrayList<IVehicle> arrOfMarines = new ArrayList<IVehicle>();
	public static ArrayList<String> arrOfImages = new ArrayList<String>();
	static ArrayList<JLabel> arrOfLabeles = new ArrayList<JLabel>();

	private JPanel mainPanel=new JPanel();
	

	

	/**
	 * Run function,activates when thread of MainPage started or when it is called directly by object from the class 
	 */
	public void run() {
		
		init();

	//--------------------Buttons-------------------
		
		btn1 = new JButton("Jeep");
		btn1.addActionListener(new ActionListener() 
		 {
			public void actionPerformed(ActionEvent e) 
			{
				new CreateInitPage("Jeep",CreateFactory.createVehicleFactory("Terra"));
			}
		 });
		btn1.setBounds(10, 320, 170, 48);
		mainPanel.add(btn1);
		
		btn2 = new JButton("Frigate");
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new CreateInitPage("Frigate",CreateFactory.createVehicleFactory("Marine"));
			}
		});
		btn2.setBounds(225, 320, 170, 48);
		mainPanel.add(btn2);
		
		btn3 = new JButton("Down Spyware");
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new CreateInitPage("Down Spyware",CreateFactory.createVehicleFactory("Air"));
			}
		});
		btn3.setBounds(10, 532, 170, 48);
		mainPanel.add(btn3);
		
		btn4= new JButton("Down Game");
		btn4.addActionListener(new ActionListener() 
		{
			public synchronized void actionPerformed(ActionEvent e) 
			{
				new CreateInitPage("Down Game",CreateFactory.createVehicleFactory("Air"));
			}
		});
		btn4.setBounds(429, 320, 170, 48);
		mainPanel.add(btn4);
		
		btn5 = new JButton("Amphibious");
		btn5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				new CreateInitPage("",CreateFactory.createVehicleFactory("TerraMarine"));

			}
		});
		btn5.setBounds(225, 532, 170, 48);
		mainPanel.add(btn5);
		
		btn6 = new JButton("Bicycle");
		btn6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
			new CreateInitPage("Bicycle",CreateFactory.createVehicleFactory("Terra"));

				
			}
		});
		btn6.setBounds(429, 532, 170, 48);
		mainPanel.add(btn6);
		
		btn7 = new JButton("Cruise Ship");
		btn7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				new CreateInitPage("Cruise Ship",CreateFactory.createVehicleFactory("Marine"));

			}
		});
		btn7.setBounds(642, 532, 170, 48);
		mainPanel.add(btn7);
		
		btn8 = new JButton("Electric Bicycle");
		btn8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					
				new CreateInitPage("Electric Bicycle",CreateFactory.createVehicleFactory("Terra"));

			}
		});
		btn8.setBounds(642, 320, 170, 48);
		mainPanel.add(btn8);


		btn9 = new JButton("Hybrid Aircraft");
		btn9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				new CreateInitPage("",CreateFactory.createVehicleFactory("All"));
			}
		});
		btn9.setBounds(850, 532, 170, 48);
		mainPanel.add(btn9);
		
		frameOfMain.setVisible(true);
	}

	
	/**
	 * resize the image 
	 * @param ImagePath the path of image
	 * @return resized image
	 */
	public static ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(370, 374, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
	
	/**
	 * main function
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread mainPage = new Thread(new MainPage());
		mainPage.start();
		
	}
	
	/**
	 * initialization function, initialize the database 
	 * @param obj object that extends class Vehicle
	 * @param s path or name of image
	 * @param m object that extends class Marine or null
	 */
	protected static synchronized void initialization(IVehicle obj,String s,String color) {
		IVehicle tmp;
		switch (color) 
		{
			case "blue":
				tmp=new StatusDecorator(new CarColorBlue(obj));
				break;
			case "red":
				tmp=new StatusDecorator(new CarColorRed(obj));
				break;
			default:
				tmp=new StatusDecorator(new CarColorYellow(obj));
				break;
		}
		arrOfCars.add(tmp);
		if (obj instanceof Marine)
			arrOfMarines.add(tmp);
		arrOfImages.add(s);
	}
	
	/**
	 * Initialization of MainPage frame	 
	 */
	private void init() {
		frameOfMain = new JFrame("Build the agency");
		frameOfMain.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfMain.setBounds(85, 30, 1155, 700);
		frameOfMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfMain.getContentPane().setLayout(null);

		//--------------------Panels--------------------
		
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setBounds(52, 38, 1030, 591);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
	//--------------------Labels--------------------
		
		JLabel label20 = new JLabel("");
		label20.setBounds(0, 0, 101, 106);
		mainPanel.add(label20);
		
		JLabel labe21 = new JLabel("");
		labe21.setBounds(134, 5, 101, 101);
		mainPanel.add(labe21);
		
		JLabel labe22 = new JLabel("");
		labe22.setBounds(558, 5, 101, 101);
		mainPanel.add(labe22);
		
		JLabel labe23= new JLabel("");
		labe23.setBounds(721, 0, 101, 106);
		mainPanel.add(labe23);
		
		Image newImg20 = w1.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		label20.setIcon(new ImageIcon(newImg20));
		
		Image newImg21 = w2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		labe21.setIcon(new ImageIcon(newImg21));
		
		Image newImg22 = w3.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		labe22.setIcon(new ImageIcon(newImg22));
		
		Image newImg23 = w4.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		labe23.setIcon(new ImageIcon(newImg23));
		
		label1 = new JLabel("Welcome To Vehicle Agency!");
		label1.setBounds(235, 20, 350, 33);
		label1.setForeground(new Color(255, 239, 213));
		label1.setBackground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainPanel.add(label1);
		
		label2 = new JLabel("jeep");
		Image Image12 = newImg1.getScaledInstance(170, 160, Image.SCALE_SMOOTH);
		label2.setIcon(new ImageIcon((Image12)));
		label2.setBounds(10, 150, 170, 170);
		mainPanel.add(label2);
		
		label3 = new JLabel("amphibious");
		Image Image16 = newImg5.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
		label3.setIcon(new ImageIcon((Image16)));
		label3.setBounds(225, 385, 170, 140);
		mainPanel.add(label3);
		
		label4 = new JLabel("frigate");
		Image Image13 = newImg2.getScaledInstance(170, 160, Image.SCALE_SMOOTH);
		label4.setIcon(new ImageIcon((Image13)));
		label4.setBounds(225, 150, 170, 170);
		mainPanel.add(label4);
		
		label5 = new JLabel("down spyware");
		Image Image15 = newImg3.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
		label5.setIcon(new ImageIcon((Image15)));
		label5.setBounds(10, 385, 170, 140);
		mainPanel.add(label5);
		
		label6 = new JLabel("bicycle");
		Image Image17 = newImg6.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
		label6.setIcon(new ImageIcon((Image17)));
		label6.setBounds(429, 385, 170, 140);
		mainPanel.add(label6);
		
		label7 = new JLabel("cruise ship");
		Image Image18 = newImg7.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
		label7.setIcon(new ImageIcon((Image18)));
		label7.setBounds(642, 385, 170, 140);
		mainPanel.add(label7);
		
		label8 = new JLabel("down game");
		Image Image14 = newImg4.getScaledInstance(170, 160, Image.SCALE_SMOOTH);
		label8.setIcon(new ImageIcon((Image14)));
		label8.setBounds(429, 150, 170, 170);
		mainPanel.add(label8);
		
		label9 = new JLabel("electric bicycle");
		Image Image10 = newImg8.getScaledInstance(170, 160, Image.SCALE_SMOOTH);
		label9.setIcon(new ImageIcon((Image10)));
		label9.setBounds(642, 154, 170, 160);
		mainPanel.add(label9);
		
		label10 = new JLabel("hybrid aircraft");
		Image Image11 = newImg9.getScaledInstance(170, 140, Image.SCALE_SMOOTH);
		label10.setIcon(new ImageIcon((Image11)));
		label10.setBounds(850, 385, 170, 142);
		mainPanel.add(label10);
		
		separator = new JSeparator();
		separator.setBounds(0, 117, 822, 2);
		mainPanel.add(separator);
		
		frameOfMain.add(mainPanel);
	}
}