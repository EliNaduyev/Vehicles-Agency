/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * class GUI CarSuccessfullyAdded implements Runnable
 * @author Eliran and Maria
 */
public class CarSuccessfullyAdded implements Runnable{
	
	private JFrame frameOfCarSuccessfullyAdded;
	private JPanel carSuccessfullyAddedPanel=new JPanel();
	private JLabel label3,label4;
	private JButton btn1,btn2;
	private Image newImg1;
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image add = new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
	static JFrame tmp=null;
	
	/**
	 * Run function,activates when thread of CarSuccessfullyAdded started or when it is called directly by object from the class 
	 */
	@Override
	public void run() {
		init();
		
		btn1 = new JButton("add another vehicle");
		newImg1 = add.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		btn1.setBounds(500, 450, 170, 48);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Thread carSuccessfullyAdded=new Thread(new MainPage());
				carSuccessfullyAdded.start();
			}
		});
		carSuccessfullyAddedPanel.add(btn1);
		
		btn2 = new JButton("continue");
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg1));
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Thread menu=new Thread(MenuPage.getInstance());
				menu.start();

				
			}
		});
		btn2.setBounds(200, 450, 170, 48);
		carSuccessfullyAddedPanel.add(btn2);
	
		
		label3 = new JLabel("The Vehicle Was Successfully Added! ");
		label3.setBounds(230, 50, 500, 33);
		label3.setForeground(new Color(250, 239, 213));
		label3.setBackground(Color.WHITE);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 27));
		carSuccessfullyAddedPanel.add(label3);
		
		label4 = new JLabel("");
		Image Image =new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		label4.setIcon(new ImageIcon(Image));
		label4.setBounds(350, 200, 165, 128);
		carSuccessfullyAddedPanel.add(label4);
		
		frameOfCarSuccessfullyAdded.setVisible(true);
		carSuccessfullyAddedPanel.setVisible(true);
		
	}
	
	/**
	 * Initialization of the frame	 
	 */
	private void init() {
		frameOfCarSuccessfullyAdded = new JFrame("Build the agency");
		frameOfCarSuccessfullyAdded.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfCarSuccessfullyAdded.setBounds(85, 30, 1155, 700);
		frameOfCarSuccessfullyAdded.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfCarSuccessfullyAdded.getContentPane().setLayout(null);
		
		carSuccessfullyAddedPanel.setBackground(Color.DARK_GRAY);
		carSuccessfullyAddedPanel.setBounds(52, 38, 1040, 591);
		carSuccessfullyAddedPanel.setLayout(null);
		
		frameOfCarSuccessfullyAdded.setVisible(false);
		carSuccessfullyAddedPanel.setVisible(false);
		
		frameOfCarSuccessfullyAdded.add(carSuccessfullyAddedPanel);


	}

}
