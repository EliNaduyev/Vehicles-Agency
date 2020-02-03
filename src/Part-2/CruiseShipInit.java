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
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Hw_2.CruiseShip;

/**
 * class GUI CruiseShipInit implements Runnable
 * @author Eliran and Maria
 */
public class CruiseShipInit implements Runnable{
	
	private JFrame frameOfCruiseShip;
	private JPanel cruiseShipInitPanel,cruiseShipInitPanel2;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9;
	private String cruiseShipUploadImage="/cruiseship.jpg";
	private JLabel labelCruiseShipImage;
	private JSeparator separator;
	private JTextField textFieldCruiseShipInit1,textFieldCruiseShipInit2,textFieldCruiseShipInit3,textFieldCruiseShipInit4,
	textFieldCruiseShipInit5,textFieldCruiseShipInit6;
	private JButton btn1,btn2,btn3,btn4;
	private String model,countryFlag,color;
	private double avgFuel,speed;
	private float avgLifeTime;
	private int seats;	
	private JRadioButton blue,yellow,red;
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	
	
	private Image newImg1= new ImageIcon(this.getClass().getResource("/cruiseship.jpg")).getImage();
	private final Image cruiseShipImage=newImg1.getScaledInstance(390, 450, Image.SCALE_SMOOTH);
	
	/**
	 * Run function,activates when thread of CruiseShipInit started or when it is called directly by object from the class 
	 */
	@Override
	public void run() 
	{
		init();		
	//--------------------Buttons--------------------
		btn1 = new JButton("Continue");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldCruiseShipInit1.getText();
					avgFuel=Double.parseDouble(textFieldCruiseShipInit2.getText());
					speed=Double.parseDouble(textFieldCruiseShipInit3.getText());
					seats=Integer.parseInt(textFieldCruiseShipInit4.getText());
					countryFlag=textFieldCruiseShipInit5.getText();
					avgLifeTime=Float.parseFloat(textFieldCruiseShipInit6.getText());
					MainPage.initialization(new CruiseShip(model,seats,speed,countryFlag,avgFuel,avgLifeTime), cruiseShipUploadImage,color);
					cruiseShipReset();
					Thread t=new Thread(new Progress(2,frameOfCruiseShip));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfCruiseShip,"Wrong insertion.");
					cruiseShipReset();
				}
			}
		});
		btn1.setBounds(10, 571, 113, 39);
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		cruiseShipInitPanel2.add(btn1);

		btn2 = new JButton("Reset");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cruiseShipReset();
			}
		});
		btn2.setBounds(251, 571, 109, 39);
		Image newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		cruiseShipInitPanel2.add(btn2);

		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameOfCruiseShip.dispose();
				cruiseShipReset();
			}
		});
		Image newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		cruiseShipInitPanel2.add(btn3);

		btn4 = new JButton("Upload");
		Image newImg4 = upload.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(newImg4));
		btn4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) 
		    {  
		           JFileChooser file = new JFileChooser();
		           file.setCurrentDirectory(new File(System.getProperty("user.home")));
		           FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		           file.addChoosableFileFilter(filter);
		           int result = file.showSaveDialog(null);
		           if(result == JFileChooser.APPROVE_OPTION)
		            {
		                File selectedFile = file.getSelectedFile();
		                String path = selectedFile.getAbsolutePath();
		                cruiseShipUploadImage=path;
		                labelCruiseShipImage.setIcon(MainPage.ResizeImage(path));
		            }
		    }
		});
		btn4.setBounds(220, 413, 108, 34);
		cruiseShipInitPanel2.add(btn4);
		
		frameOfCruiseShip.setVisible(true);
		cruiseShipInitPanel.setVisible(true);
		cruiseShipInitPanel2.setVisible(true);
				
	}

	/**
	 * Reset all the fields that related to cruise ship class
	 */
	private void cruiseShipReset()
	{
		textFieldCruiseShipInit1.setText("");
		textFieldCruiseShipInit2.setText("");
		textFieldCruiseShipInit3.setText("");
		textFieldCruiseShipInit4.setText("");
		textFieldCruiseShipInit5.setText("");
		textFieldCruiseShipInit6.setText("");
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelCruiseShipImage.setIcon(new ImageIcon(cruiseShipImage));
		cruiseShipUploadImage="/cruiseship.jpg";
	}
	
	/**
	 * Initialization of Cruise Ship frame	 
	 */
	private void init() {
		frameOfCruiseShip = new JFrame("Cruise Ship Initialization");
		frameOfCruiseShip.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfCruiseShip.setBounds(85, 30, 1155, 700);
		frameOfCruiseShip.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfCruiseShip.getContentPane().setLayout(null);
		
		cruiseShipInitPanel= new JPanel();
		cruiseShipInitPanel.setBackground(Color.LIGHT_GRAY);
		cruiseShipInitPanel.setBounds(370, 0, 562, 653);
		cruiseShipInitPanel.setLayout(null);

		
		cruiseShipInitPanel2= new JPanel();
		cruiseShipInitPanel2.setBackground(new Color(102,153,255));
		cruiseShipInitPanel2.setBounds(0, 0, 390, 653);
		cruiseShipInitPanel2.setLayout(null);
		
		frameOfCruiseShip.setVisible(false);
		cruiseShipInitPanel.setVisible(false);
		cruiseShipInitPanel2.setVisible(false);
				
	//--------------------Labels--------------------

		label1 = new JLabel("Cruise Ship Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(120, 20, 300, 30);
		cruiseShipInitPanel.add(label1);

		label2 = new JLabel("Model:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 85, 89, 23);
		cruiseShipInitPanel.add(label2);

		label3 = new JLabel("Average fuel consumption:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(150, 160, 200, 23);
		cruiseShipInitPanel.add(label3);

		label4 = new JLabel("Speed:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(150, 230, 89, 23);
		cruiseShipInitPanel.add(label4);

		label5 = new JLabel("Seats:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(150, 300, 89, 23);
		cruiseShipInitPanel.add(label5);

		label6=new JLabel("Flag:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label6.setBounds(150, 369, 180, 23);
		cruiseShipInitPanel.add(label6);

		label7 = new JLabel("Average life time:");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label7.setBounds(150, 440, 200, 23);
		cruiseShipInitPanel.add(label7);


		label8 = new JLabel("Add picture:");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label8.setForeground(Color.BLACK);
		label8.setBounds(23, 400, 187, 48);
		cruiseShipInitPanel2.add(label8);
		
		label9= new JLabel("");
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label9.setIcon(new ImageIcon((Image1)));
		label9.setBounds(23, 470, 187, 48);
		cruiseShipInitPanel2.add(label9);

		labelCruiseShipImage = new JLabel("");
		labelCruiseShipImage.setBounds(0, 0, 370, 374);
		labelCruiseShipImage.setIcon(new ImageIcon(cruiseShipImage));
		cruiseShipInitPanel2.add(labelCruiseShipImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		cruiseShipInitPanel.add(separator);


	//--------------------text Field--------------------



		textFieldCruiseShipInit1 = new JTextField("",10);
		textFieldCruiseShipInit1.setBounds(150, 120, 210, 36);
		cruiseShipInitPanel.add(textFieldCruiseShipInit1);


		textFieldCruiseShipInit2 = new JTextField("",10);
		textFieldCruiseShipInit2.setBounds(150, 190, 210, 36);
		cruiseShipInitPanel.add(textFieldCruiseShipInit2);


		textFieldCruiseShipInit3 = new JTextField("",10);
		textFieldCruiseShipInit3.setBounds(150, 260, 210, 36);
		cruiseShipInitPanel.add(textFieldCruiseShipInit3);


		textFieldCruiseShipInit4 = new JTextField("",10);
		textFieldCruiseShipInit4.setBounds(150, 330, 210, 36);
		cruiseShipInitPanel.add(textFieldCruiseShipInit4);	

		textFieldCruiseShipInit5 = new JTextField("",10);
		textFieldCruiseShipInit5.setBounds(150, 400, 210, 36);
		cruiseShipInitPanel.add(textFieldCruiseShipInit5);


		textFieldCruiseShipInit6 = new JTextField("",10);
		textFieldCruiseShipInit6.setBounds(150, 470, 210, 36);
		cruiseShipInitPanel.add(textFieldCruiseShipInit6);
		
		ButtonGroup CruiseShipcolorgroup=new ButtonGroup();
		CruiseShipcolorgroup.add(red);
		red=new JRadioButton("");
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(102,153,255));
		cruiseShipInitPanel2.add(red);

				
		CruiseShipcolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(102,153,255));
		cruiseShipInitPanel2.add(yellow);
		
		CruiseShipcolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(102,153,255));
		cruiseShipInitPanel2.add(blue);
						
		red.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (red.isSelected())
					color="red";
				yellow.setSelected(false);
				blue.setSelected(false);
			}
		});
				
		yellow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (yellow.isSelected())
					color="yellow";
				red.setSelected(false);
				blue.setSelected(false);			
			}
		});
				
		blue.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (blue.isSelected())
					color="blue";
				red.setSelected(false);
				yellow.setSelected(false);			
			}
		});
		
		
		
		frameOfCruiseShip.add(cruiseShipInitPanel);
		frameOfCruiseShip.add(cruiseShipInitPanel2);
	}
}
