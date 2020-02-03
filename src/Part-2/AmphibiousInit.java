/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Hw_2.Amphibious;

/**
 * class GUI AmphibiousInit implements Runnable
 * @author Eliran and Maria
 */
public class AmphibiousInit implements Runnable{
	
	private JFrame frameOfAmphibious;
	private JPanel amphibiousInitPanel,amphibiousInitPanel2;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
	private String amphibiousUploadImage="/amphibious.jpg";
	private JLabel labelAmphibiousImage;
	private JSeparator separator;
	private JTextField textFieldAmphibiousInit1,textFieldAmphibiousInit2,textFieldAmphibiousInit3,textFieldAmphibiousInit4,
	textFieldAmphibiousInit5,textFieldAmphibiousInit6,textFieldAmphibiousInit7;	
	private JButton btn1,btn2,btn3,btn4;
	private JRadioButton radioA1,radioA2,blue,yellow,red;
	private String model,countryFlag,color;
	private double avgFuel,speed;
	private float avgLifeTime;
	private int seats,numWheels;
	private boolean windD;
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	private Image newImg1= new ImageIcon(this.getClass().getResource("/amphibious.jpg")).getImage();
	private final Image amphibiousImage = newImg1.getScaledInstance(390, 450, Image.SCALE_SMOOTH);

	/**
	 * Run function,activates when thread of AmphibiousInit started or when it is called directly by object from the class 
	 */
	@Override
	public void run() 
	{
		init();
	//--------------------Buttons--------------------
				
		btn1 = new JButton("Continue");
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					if (radioA1.isSelected() == false && radioA2.isSelected() == false)
						throw new Exception();
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldAmphibiousInit1.getText();
					avgFuel=Double.parseDouble(textFieldAmphibiousInit2.getText());
					speed=Double.parseDouble(textFieldAmphibiousInit3.getText());
					seats=Integer.parseInt(textFieldAmphibiousInit4.getText());
					numWheels=Integer.parseInt(textFieldAmphibiousInit5.getText());
					countryFlag=textFieldAmphibiousInit6.getText();
					avgLifeTime=Float.parseFloat(textFieldAmphibiousInit7.getText());
					MainPage.initialization(new Amphibious(model,seats,speed,numWheels,countryFlag,windD,avgFuel,avgLifeTime), amphibiousUploadImage,color);
					amphibiousReset();
					Thread t=new Thread(new Progress(2,frameOfAmphibious));
				    t.start(); 
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfAmphibious,"Wrong insertion.");
					amphibiousReset();
				}
			}
		});
		btn1.setBounds(10, 571, 113, 39);
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		amphibiousInitPanel2.add(btn1);
				
		btn2 = new JButton("Reset");
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				amphibiousReset();
			}
		});
		btn2.setBounds(251, 571, 109, 39);
		Image newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		amphibiousInitPanel2.add(btn2);
				
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
						frameOfAmphibious.dispose();
						amphibiousReset();
			}
		});
		Image newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		amphibiousInitPanel2.add(btn3);
				
		btn4 = new JButton("Upload");
		btn4.addActionListener(new ActionListener() 
		{
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
		          amphibiousUploadImage=path;
		          labelAmphibiousImage.setIcon(MainPage.ResizeImage(path));
		      }
		   }
		 });
		Image newImg4 = upload.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(newImg4));
		btn4.setBounds(220, 413, 108, 34);
		amphibiousInitPanel2.add(btn4);	
		
		frameOfAmphibious.setVisible(true);
		amphibiousInitPanel.setVisible(true);
		amphibiousInitPanel2.setVisible(true);
	}
	
	/**
	 * Reset all the fields that related to amphibious class
	 */
	private void amphibiousReset()
	{
		textFieldAmphibiousInit1.setText("");
		textFieldAmphibiousInit2.setText("");
		textFieldAmphibiousInit3.setText("");
		textFieldAmphibiousInit4.setText("");
		textFieldAmphibiousInit5.setText("");
		textFieldAmphibiousInit6.setText("");
		textFieldAmphibiousInit7.setText("");
		radioA1.setSelected(false);
		radioA2.setSelected(false);
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelAmphibiousImage.setIcon(new ImageIcon(amphibiousImage));
		amphibiousUploadImage="/amphibious.jpg";
	}
	
	/**
	 * Initialization of Amphibious frame	 
	 */
	private void init() {

		frameOfAmphibious = new JFrame("Amphibious Initialization");
		frameOfAmphibious.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfAmphibious.setBounds(85, 30, 1155, 700);
		frameOfAmphibious.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfAmphibious.getContentPane().setLayout(null);
		
		amphibiousInitPanel= new JPanel();
		amphibiousInitPanel.setBackground(Color.LIGHT_GRAY);
		amphibiousInitPanel.setBounds(370, 0, 562, 653);
		amphibiousInitPanel.setLayout(null);

		amphibiousInitPanel2= new JPanel();
		amphibiousInitPanel2.setBackground(new Color(102,153,255));
		amphibiousInitPanel2.setBounds(0, 0, 390, 653);
		amphibiousInitPanel2.setLayout(null);
		
		frameOfAmphibious.setVisible(false);
		amphibiousInitPanel.setVisible(false);
		amphibiousInitPanel2.setVisible(false);
				
	//--------------------Labels--------------------
				
		label1 = new JLabel("Amphibious Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(120, 13, 300, 30);
		amphibiousInitPanel.add(label1);
			
		label2 = new JLabel("Model:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 79, 89, 23);
		amphibiousInitPanel.add(label2);
				
		label3 = new JLabel("Average fuel consumption:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(150, 149, 200, 23);
		amphibiousInitPanel.add(label3);
			
		label4 = new JLabel("Speed:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(150, 215, 89, 23);
		amphibiousInitPanel.add(label4);
				
		label5 = new JLabel("Seats:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(150, 286, 89, 23);
		amphibiousInitPanel.add(label5);
				
		label6 = new JLabel("Number of wheels:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label6.setBounds(150, 354, 180, 23);
		amphibiousInitPanel.add(label6);
			
		label7=new JLabel("Flag:");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label7.setBounds(150, 427, 89, 23);
		amphibiousInitPanel.add(label7);
				
		label8=new JLabel("Wind direction:");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label8.setBounds(150, 571, 150, 23);
		amphibiousInitPanel.add(label8);
				
		label9 = new JLabel("Average life time:");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label9.setBounds(150, 495, 200, 23);
		amphibiousInitPanel.add(label9);
				
		label10 = new JLabel("Add picture:");
		label10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label10.setForeground(Color.BLACK);
		label10.setBounds(23, 400, 187, 48);
		amphibiousInitPanel2.add(label10);
		
		label11= new JLabel();
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label11.setIcon(new ImageIcon((Image1)));
		label11.setBounds(23, 470, 187, 48);
		amphibiousInitPanel2.add(label11);
				
		labelAmphibiousImage = new JLabel("");
		labelAmphibiousImage.setBounds(0, 0, 370, 374);
		labelAmphibiousImage.setIcon(new ImageIcon(amphibiousImage));
		amphibiousInitPanel2.add(labelAmphibiousImage);
				
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		amphibiousInitPanel.add(separator);
				
				
	//--------------------text Fields--------------------
				
		textFieldAmphibiousInit1 = new JTextField("",10);
		textFieldAmphibiousInit1.setBounds(150, 110, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit1);
		
		textFieldAmphibiousInit2 = new JTextField("",10);
		textFieldAmphibiousInit2.setBounds(150, 175, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit2);
			
		textFieldAmphibiousInit3 = new JTextField("",10);
		textFieldAmphibiousInit3.setBounds(150, 244, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit3);
				
		textFieldAmphibiousInit4 = new JTextField("",10);
		textFieldAmphibiousInit4.setBounds(150, 313, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit4);	
				
		textFieldAmphibiousInit5 = new JTextField("",10);
		textFieldAmphibiousInit5.setBounds(150, 382, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit5);

		textFieldAmphibiousInit6 = new JTextField("",10);
		textFieldAmphibiousInit6.setBounds(150, 452, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit6);

		textFieldAmphibiousInit7 = new JTextField("",10);
		textFieldAmphibiousInit7.setBounds(150, 524, 210, 36);
		amphibiousInitPanel.add(textFieldAmphibiousInit7);
				
		ButtonGroup Amphibiousgroup=new ButtonGroup();

		Amphibiousgroup.add(radioA1);
		radioA1=new JRadioButton("True");
		radioA1.setBounds(169,606, 52, 23);
		amphibiousInitPanel.add(radioA1);
				
		Amphibiousgroup.add(radioA2);
		radioA2=new JRadioButton("False");
		radioA2.setBounds(281,606, 55, 25);
		amphibiousInitPanel.add(radioA2);
						
		radioA1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (radioA1.isSelected())
					windD=true;
				radioA2.setSelected(false);
			}
		});
				
		radioA2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (radioA2.isSelected())
					windD=false;
				radioA1.setSelected(false);
			}
		});
				
		radioA1.setBackground(Color.LIGHT_GRAY);
		radioA2.setBackground(Color.LIGHT_GRAY);
		
		ButtonGroup Amphibiouscolorgroup=new ButtonGroup();

		Amphibiouscolorgroup.add(red);
		red=new JRadioButton();
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(102,153,255));
		amphibiousInitPanel2.add(red);

				
		Amphibiouscolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(102,153,255));
		amphibiousInitPanel2.add(yellow);
		
		Amphibiouscolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(102,153,255));
		amphibiousInitPanel2.add(blue);
						
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
				
		frameOfAmphibious.add(amphibiousInitPanel);
		frameOfAmphibious.add(amphibiousInitPanel2);
	}
}
