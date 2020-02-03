/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * class GUI ChangeAllFlags implements Runnable
 * @author Eliran and Maria
 */
public class ChangeAllFlags implements Runnable {
	
	private JFrame frameOfChangeAllFlags,tmp;
	private JPanel changeAllFlagsPanel;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8;
	private JRadioButton radio1,radio2,radio3,radio4,radio5,radio6,radio7;
	private JButton btn1;
	private Image newImg1;
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private static Lock f=new ReentrantLock();
	
	/**
	 * constructor of class ChangeAllFlags
	 * @param tmp The frame that called to the constructor
	 */
	public ChangeAllFlags(JFrame tmp)
	{
		this.tmp=tmp;
	}
	
	/**
	 * Run function,activates when thread of ChangeAllFlags started or when it is called directly by object from the class 
	 */
	@Override
	public void run() {
		
		frameOfChangeAllFlags = new JFrame("Change All Flags");
		frameOfChangeAllFlags.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfChangeAllFlags.setBounds(85, 30, 1155, 700);
		frameOfChangeAllFlags.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfChangeAllFlags.getContentPane().setLayout(null);

		changeAllFlagsPanel=new JPanel();
		changeAllFlagsPanel.setBounds(52, 50, 1040, 565);
		changeAllFlagsPanel.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.setLayout(null);
		changeAllFlagsPanel.setVisible(true);
		

	//-----------------------Labels----------------------------
		
		label1 = new JLabel("Change all flags ");
		label1.setBounds(290, 0, 275, 33);
		label1.setForeground(new Color(255, 239, 213));
		label1.setBackground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		changeAllFlagsPanel.add(label1);
		
		label2 = new JLabel("Israel");
		Image Image =new ImageIcon(this.getClass().getResource("/Israel.png")).getImage();
		label2.setIcon(new ImageIcon(Image));
		label2.setBounds(100, 95, 128, 128);
		changeAllFlagsPanel.add(label2);
		
		label3 = new JLabel("Germany");
		Image Image3 = new ImageIcon(this.getClass().getResource("/Germany.png")).getImage();
		label3.setIcon(new ImageIcon(Image3));
		label3.setBounds(320, 95, 128, 133);
		changeAllFlagsPanel.add(label3);
		
		label4 = new JLabel("Italy");
		Image Image4 =new ImageIcon(this.getClass().getResource("/Italy.png")).getImage();
        Image newImg7 = Image4.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		label4.setIcon(new ImageIcon(newImg7));
		label4.setBounds(530, 95, 133, 145);
		changeAllFlagsPanel.add(label4);
		
		label5 = new JLabel("USA");
		Image Image5 =new ImageIcon(this.getClass().getResource("/USA.png")).getImage();
		label5.setIcon(new ImageIcon(Image5));
		label5.setBounds(100, 250, 128, 120);
		changeAllFlagsPanel.add(label5);
		
		label6 = new JLabel("Greece");
		Image Image6 =new ImageIcon(this.getClass().getResource("/Greece.png")).getImage();
		label6.setIcon(new ImageIcon(Image6));
		label6.setBounds(320, 250, 128, 124);
		changeAllFlagsPanel.add(label6);
		
		label7 = new JLabel("Somalia");
		Image Image7 =new ImageIcon(this.getClass().getResource("/Somalia.png")).getImage();
		Image newImg11 = Image7.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
		label7.setIcon(new ImageIcon(newImg11));
		label7.setBounds(530, 250, 133, 123);
		changeAllFlagsPanel.add(label7);
		
		label8 = new JLabel("Pirates");
		Image Image8 = new ImageIcon(this.getClass().getResource("/Pirates.png")).getImage();
		label8.setIcon(new ImageIcon(Image8));
		label8.setBounds(320, 400, 128, 124);
		changeAllFlagsPanel.add(label8);
		
	//-----------------------Radio Buttons---------------------
		
		ButtonGroup group=new ButtonGroup();

		group.add(radio1);
		radio1=new JRadioButton("");
		radio1.setBounds(85,120, 20, 20);
		radio1.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio1);
		
		group.add(radio2);
		radio2=new JRadioButton("");
		radio2.setBounds(295,120, 20, 20);
		radio2.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio2);
		
		group.add(radio3);
		radio3=new JRadioButton("");
		radio3.setBounds(505,120, 20, 20);
		radio3.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio3);
		
		group.add(radio4);
		radio4=new JRadioButton("");
		radio4.setBounds(85,265, 20, 20);
		radio4.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio4);
		
		group.add(radio5);
		radio5=new JRadioButton("");
		radio5.setBounds(295,265, 20, 20);
		radio5.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio5);
		
		group.add(radio6);
		radio6=new JRadioButton("");
		radio6.setBounds(505,265, 20, 20);
		radio6.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio6);
		
		group.add(radio7);
		radio7=new JRadioButton("");
		radio7.setBounds(295,435, 20, 20);
		radio7.setBackground(Color.DARK_GRAY);
		changeAllFlagsPanel.add(radio7);
		
		radio1.addActionListener(new ButtonActionListener());
		radio2.addActionListener(new ButtonActionListener());
		radio3.addActionListener(new ButtonActionListener());
		radio4.addActionListener(new ButtonActionListener());
		radio5.addActionListener(new ButtonActionListener());
		radio6.addActionListener(new ButtonActionListener());
		radio7.addActionListener(new ButtonActionListener());
		
		
	//-----------------------Buttons----------------------------
		
		
		btn1 = new JButton("Back");
		newImg1 = back.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				frameOfChangeAllFlags.dispose();
			}
		});
		btn1.setBounds(290, 530, 170, 48);
		changeAllFlagsPanel.add(btn1);
		
		frameOfChangeAllFlags.add(changeAllFlagsPanel);
	
		frameOfChangeAllFlags.setVisible(true);
	}
	
	/**
	 * class ButtonActionListener listen to the click and keeps the data about flags
	 */
	class ButtonActionListener  implements ActionListener
	{
		String temp;
		public void actionPerformed(ActionEvent e)
		{
			if (radio1.isSelected()) {
				temp="Israel";
				radio1.setSelected(false);
			}
			else if (radio2.isSelected()) {
				temp="Germany";
				radio2.setSelected(false);
			}
			else if (radio3.isSelected()) {
				temp="Italy";
				radio3.setSelected(false);
			}
			else if (radio4.isSelected()) {
				temp="USA";
				radio4.setSelected(false);
			}
			else if (radio5.isSelected()) {
				temp="Greece";
				radio5.setSelected(false);
			}
			else if (radio6.isSelected()) {
				temp="Somalia";
				radio6.setSelected(false);
			}
			else if (radio7.isSelected()) {
				temp="Pirates";
				radio7.setSelected(false);
			}
			synchronized(f) 
			{
			for (int i=0;i<MainPage.arrOfMarines.size();i++) {
				(MainPage.arrOfMarines.get(i)).setCountryFlag(temp);

			}
			for (int i=0;i<MainPage.arrOfCars.size();i++) {
				(MainPage.arrOfLabeles.get(i)).setToolTipText((MainPage.arrOfCars.get(i)).toString());
			}
			}
			
			frameOfChangeAllFlags.dispose();
			Thread t=new Thread(new Progress(3,tmp));
			t.start(); 
			
			
		}	
	}
}
