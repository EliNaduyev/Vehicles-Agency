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

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Hw_2.HybridAircraft;

/**
 * class GUI HybridAircraftInit implements Runnable
 * @author Eliran and Maria
 */
public class HybridAircraftInit implements Runnable {
	
	private JFrame frameOfHybridAircraft;
	private JPanel hybridAircraftInitPanel,hybridAircraftInitPanel2;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
	private String hybridAircraftUploadImage="/Hybrid Aircraft.jpg";
	private JLabel labelHybridAircraftImage;
	private JSeparator separator;
	private JTextField textFieldHybridAircraftInit1,textFieldHybridAircraftInit2,textFieldHybridAircraftInit3,textFieldHybridAircraftInit4,
	textFieldHybridAircraftInit5,textFieldHybridAircraftInit6,textFieldHybridAircraftInit7;	
	private JButton btn1,btn2,btn3,btn4;
	private String model,countryFlag,color;
	private double avgFuel,speed;
	private float avgLifeTime;
	private int seats,numWheels;
	private boolean windD;
	private JRadioButton radioHA1,radioHA2,blue,yellow,red;
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	
	private Image newImg1= new ImageIcon(this.getClass().getResource("/Hybrid Aircraft.jpg")).getImage();
	private final Image hybridAircraftImage = newImg1.getScaledInstance(390, 450, Image.SCALE_SMOOTH);

	/**
	 * Run function,activates when thread of HybridAircraftInit started or when it is called directly by object from the class 
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
					if (radioHA1.isSelected() == false && radioHA2.isSelected() == false)
						throw new Exception();
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldHybridAircraftInit1.getText();
					avgFuel=Double.parseDouble(textFieldHybridAircraftInit2.getText());
					speed=Double.parseDouble(textFieldHybridAircraftInit3.getText());
					seats=Integer.parseInt(textFieldHybridAircraftInit4.getText());
					numWheels=Integer.parseInt(textFieldHybridAircraftInit5.getText());
					countryFlag=textFieldHybridAircraftInit6.getText();
					avgLifeTime=Float.parseFloat(textFieldHybridAircraftInit7.getText());
					MainPage.initialization(new HybridAircraft(model,seats,speed,avgLifeTime,avgFuel,windD,countryFlag,numWheels), hybridAircraftUploadImage,color);
					hybridAircraftReset();
					Thread t=new Thread(new Progress(2,frameOfHybridAircraft));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfHybridAircraft,"Wrong insertion.");
					hybridAircraftReset();
				}
			}
		});
		btn1.setBounds(10, 571, 113, 39);
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		hybridAircraftInitPanel2.add(btn1);
		
		btn2 = new JButton("Reset");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hybridAircraftReset();
			}
		});
		btn2.setBounds(251, 571, 109, 39);
		Image newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		hybridAircraftInitPanel2.add(btn2);
	
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameOfHybridAircraft.dispose();
				hybridAircraftReset();
			}
		});
		Image newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		hybridAircraftInitPanel2.add(btn3);
		
		btn4 = new JButton("Upload");
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
                        hybridAircraftUploadImage=path;
                        labelHybridAircraftImage.setIcon(MainPage.ResizeImage(path));
                    }
            }
        });
		Image newImg4 = upload.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(newImg4));
		btn4.setBounds(220, 413, 108, 34);
		hybridAircraftInitPanel2.add(btn4);
		
		frameOfHybridAircraft.setVisible(true);
		hybridAircraftInitPanel.setVisible(true);
		hybridAircraftInitPanel2.setVisible(true);

	}

	/**
	 * Reset all the fields that related to hybrid aircraft class
	 */
	private void hybridAircraftReset()
	{
		textFieldHybridAircraftInit1.setText("");
		textFieldHybridAircraftInit2.setText("");
		textFieldHybridAircraftInit3.setText("");
		textFieldHybridAircraftInit4.setText("");
		textFieldHybridAircraftInit5.setText("");
		textFieldHybridAircraftInit6.setText("");
		textFieldHybridAircraftInit7.setText("");
		radioHA1.setSelected(false);
		radioHA2.setSelected(false);
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelHybridAircraftImage.setIcon(new ImageIcon(hybridAircraftImage));
		hybridAircraftUploadImage="/Hybrid Aircraft.jpg";
	}
	
	/**
	 * Initialization of Hybrid Aircraft frame	 
	 */
	private void init() {
		
		frameOfHybridAircraft = new JFrame("Hybrid Aircraft Initialization");
		frameOfHybridAircraft.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfHybridAircraft.setBounds(85, 30, 1155, 700);
		frameOfHybridAircraft.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfHybridAircraft.getContentPane().setLayout(null);
		
		hybridAircraftInitPanel= new JPanel();
		hybridAircraftInitPanel.setBackground(Color.LIGHT_GRAY);
		hybridAircraftInitPanel.setBounds(370, 0, 562, 653);
		hybridAircraftInitPanel.setLayout(null);

		
		hybridAircraftInitPanel2= new JPanel();
		hybridAircraftInitPanel2.setBackground(new Color(102,153,255));
		hybridAircraftInitPanel2.setBounds(0, 0, 390, 653);
		hybridAircraftInitPanel2.setLayout(null);
		
		frameOfHybridAircraft.setVisible(false);
		hybridAircraftInitPanel.setVisible(false);
		hybridAircraftInitPanel2.setVisible(false);
		
	//--------------------Labels--------------------
		
		label1 = new JLabel("Hybrid Aircraft Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(120, 13, 350, 30);
		hybridAircraftInitPanel.add(label1);
	
		label2 = new JLabel("Model:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 79, 89, 23);
		hybridAircraftInitPanel.add(label2);
		
		label3 = new JLabel("Average fuel consumption:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(150, 149, 200, 23);
		hybridAircraftInitPanel.add(label3);
	
		label4 = new JLabel("Speed:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(150, 215, 89, 23);
		hybridAircraftInitPanel.add(label4);
		
		label5 = new JLabel("Seats:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(150, 286, 89, 23);
		hybridAircraftInitPanel.add(label5);
		
		label6 = new JLabel("Number of wheels:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label6.setBounds(150, 354, 180, 23);
		hybridAircraftInitPanel.add(label6);
		
		label7=new JLabel("Flag:");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label7.setBounds(150, 427, 89, 23);
		hybridAircraftInitPanel.add(label7);
		
		label8=new JLabel("Wind direction:");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label8.setBounds(150, 571, 150, 23);
		hybridAircraftInitPanel.add(label8);
		
		label9 = new JLabel("Average life time:");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label9.setBounds(150, 495, 200, 23);
		hybridAircraftInitPanel.add(label9);
		
		label10 = new JLabel("Add picture:");
		label10.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label10.setForeground(Color.BLACK);
		label10.setBounds(23, 400, 187, 48);
		hybridAircraftInitPanel2.add(label10);
		
		label11= new JLabel("");
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label11.setIcon(new ImageIcon((Image1)));
		label11.setBounds(23, 470, 187, 48);
		hybridAircraftInitPanel2.add(label11);
		
		labelHybridAircraftImage = new JLabel("");
		labelHybridAircraftImage.setBounds(0, 0, 370, 374);
		labelHybridAircraftImage.setIcon(new ImageIcon(hybridAircraftImage));
		hybridAircraftInitPanel2.add(labelHybridAircraftImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		hybridAircraftInitPanel.add(separator);
		
		
		//--------------------text Field--------------------
		
		textFieldHybridAircraftInit1 = new JTextField("",10);
		textFieldHybridAircraftInit1.setBounds(150, 110, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit1);
		
		
		textFieldHybridAircraftInit2 = new JTextField("",10);
		textFieldHybridAircraftInit2.setBounds(150, 175, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit2);
		
		
		textFieldHybridAircraftInit3 = new JTextField("",10);
		textFieldHybridAircraftInit3.setBounds(150, 244, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit3);
		
		
		textFieldHybridAircraftInit4 = new JTextField("",10);
		textFieldHybridAircraftInit4.setBounds(150, 313, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit4);	
		
		textFieldHybridAircraftInit5 = new JTextField("",10);
		textFieldHybridAircraftInit5.setBounds(150, 382, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit5);
		
		
		textFieldHybridAircraftInit6 = new JTextField("",10);
		textFieldHybridAircraftInit6.setBounds(150, 452, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit6);
		
		
		textFieldHybridAircraftInit7 = new JTextField("",10);
		textFieldHybridAircraftInit7.setBounds(150, 524, 210, 36);
		hybridAircraftInitPanel.add(textFieldHybridAircraftInit7);
		
		ButtonGroup HybridAircraftgroup=new ButtonGroup();

		HybridAircraftgroup.add(radioHA1);
		radioHA1=new JRadioButton("True");
		radioHA1.setBounds(169,606, 52, 23);
		hybridAircraftInitPanel.add(radioHA1);
		
		HybridAircraftgroup.add(radioHA2);
		radioHA2=new JRadioButton("False");
		radioHA2.setBounds(281,606, 55, 25);
		hybridAircraftInitPanel.add(radioHA2);
				
		radioHA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioHA1.isSelected())
					windD=true;
				radioHA2.setSelected(false);
			}
		});
		
		radioHA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioHA2.isSelected())
					windD=false;
				radioHA1.setSelected(false);
			}
		});
		
		radioHA1.setBackground(Color.LIGHT_GRAY);
		radioHA2.setBackground(Color.LIGHT_GRAY);
		
		ButtonGroup HybridAircraftcolorgroup=new ButtonGroup();
		
		HybridAircraftcolorgroup.add(red);
		red=new JRadioButton("");
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(102,153,255));
		hybridAircraftInitPanel2.add(red);

				
		HybridAircraftcolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(102,153,255));
		hybridAircraftInitPanel2.add(yellow);
		
		HybridAircraftcolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(102,153,255));
		hybridAircraftInitPanel2.add(blue);
						
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
		
		frameOfHybridAircraft.add(hybridAircraftInitPanel);
		frameOfHybridAircraft.add(hybridAircraftInitPanel2);		
		

	}
}
