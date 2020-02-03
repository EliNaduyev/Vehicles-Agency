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

import Hw_2.ElectricBicycle;

/**
 * class GUI ElectricBicycleInit implements Runnable
 * @author Eliran and Maria
 */
public class ElectricBicycleInit implements Runnable {
	
	private JTextField textFieldElectricBicycleInit1,textFieldElectricBicycleInit2,textFieldElectricBicycleInit3,textFieldElectricBicycleInit4;
	private JButton btn1,btn2,btn3,btn4;
	private JLabel label1,label2,label3,label4,label5,label6,label9,label10;
	private JLabel labelElectricBicycleImage;
	private Image newImg= new ImageIcon(this.getClass().getResource("/Electric Bicycle.jpg")).getImage();
	private final Image electricBicycleImage = newImg.getScaledInstance(390, 450, Image.SCALE_SMOOTH);
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	private String electricBicycleUploadImage="/Electric Bicycle.jpg";
	private JFrame frameOfElectricBicycle;
	private JSeparator separator;
	private double speed;
	private float avgLifeTime;
	private int seats;
	
	private String model,road,color;
	private JRadioButton radioEB1,radioEB2,blue,yellow,red;
	
	private JPanel electricBicycleInitPanel=new JPanel();
	private JPanel electricBicycleInitPanel2 = new JPanel();
	
	private Image newImg1,newImg2 ,newImg3,newImg4;

	/**
	 * Run function,activates when thread of ElectricBicycleInit started or when it is called directly by object from the class 
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
					if (radioEB1.isSelected() == false && radioEB2.isSelected() == false)
						throw new Exception();
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldElectricBicycleInit1.getText();
					seats=Integer.parseInt(textFieldElectricBicycleInit2.getText());
					speed=Double.parseDouble(textFieldElectricBicycleInit3.getText());
					avgLifeTime=Float.parseFloat(textFieldElectricBicycleInit4.getText());
					MainPage.initialization(new ElectricBicycle(model,seats,speed,avgLifeTime,road), electricBicycleUploadImage,color);
					electricBicycleReset();
					Thread t=new Thread(new Progress(2,frameOfElectricBicycle));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfElectricBicycle,"Wrong insertion.");
					electricBicycleReset();
				}
			}
		});
		btn1.setBounds(10, 571, 113, 39);
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		electricBicycleInitPanel2.add(btn1);
	
		btn2 = new JButton("Reset");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				electricBicycleReset();
			}
		});
		btn2.setBounds(251, 571, 109, 39);
		newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		electricBicycleInitPanel2.add(btn2);
	
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameOfElectricBicycle.dispose();
				electricBicycleReset();
			}
		});
		newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		electricBicycleInitPanel2.add(btn3);
	
		btn4 = new JButton("Upload");
		newImg4 = upload.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
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
		                electricBicycleUploadImage=path;
		                labelElectricBicycleImage.setIcon(MainPage.ResizeImage(path));
		            }
		    }
		});
		btn4.setBounds(220, 413, 108, 34);
		electricBicycleInitPanel2.add(btn4);
		
		frameOfElectricBicycle.setVisible(true);
		electricBicycleInitPanel.setVisible(true);
		electricBicycleInitPanel2.setVisible(true);
		
	}
	
	/**
	 * Reset all the fields that related to electric bicycle class
	 */
	private void electricBicycleReset()
	{
		textFieldElectricBicycleInit1.setText("");
		textFieldElectricBicycleInit2.setText("");
		textFieldElectricBicycleInit3.setText("");
		textFieldElectricBicycleInit4.setText("");
		radioEB1.setSelected(false);
		radioEB2.setSelected(false);
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelElectricBicycleImage.setIcon(new ImageIcon(electricBicycleImage));
		electricBicycleUploadImage="/Electric Bicycle.jpg";
	}
	
	/**
	 * Initialization of Electric Bicycle frame	 
	 */
	private void init() {
		frameOfElectricBicycle = new JFrame("Electric Bicycle Initialization");
		frameOfElectricBicycle.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfElectricBicycle.setBounds(85, 30, 1155, 700);
		frameOfElectricBicycle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfElectricBicycle.getContentPane().setLayout(null);
		frameOfElectricBicycle.setVisible(false);
		
		electricBicycleInitPanel.setBackground(Color.LIGHT_GRAY);
		electricBicycleInitPanel.setBounds(370, 0, 562, 653);
		electricBicycleInitPanel.setLayout(null);
		electricBicycleInitPanel.setVisible(false);
		
		electricBicycleInitPanel2.setBackground(new Color(70,130,180));
		electricBicycleInitPanel2.setBounds(0, 0, 390, 653);
		electricBicycleInitPanel2.setLayout(null);
		electricBicycleInitPanel2.setVisible(false);
	
	//--------------------Labels--------------------

		label1 = new JLabel("Electric Bicycle Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(120, 20, 350, 30);
		electricBicycleInitPanel.add(label1);

		label2 = new JLabel("Model:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 85, 89, 23);
		electricBicycleInitPanel.add(label2);

		label3 = new JLabel("Seats:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(150, 160, 200, 23);
		electricBicycleInitPanel.add(label3);

		label4 = new JLabel("Speed:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(150, 230, 89, 23);
		electricBicycleInitPanel.add(label4);

		label5 = new JLabel("Average life time:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(150, 300, 180, 23);
		electricBicycleInitPanel.add(label5);

		label6=new JLabel("Road:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label6.setBounds(150, 369, 89, 23);
		electricBicycleInitPanel.add(label6);

		label9 = new JLabel("Add picture:");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label9.setForeground(Color.BLACK);
		label9.setBounds(23, 400, 187, 48);
		electricBicycleInitPanel2.add(label9);
		
		label10= new JLabel("");
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label10.setIcon(new ImageIcon((Image1)));
		label10.setBounds(23, 470, 187, 48);
		electricBicycleInitPanel2.add(label10);

		labelElectricBicycleImage = new JLabel("");
		labelElectricBicycleImage.setBounds(0, 0, 370, 374);
		labelElectricBicycleImage.setIcon(new ImageIcon(electricBicycleImage));
		electricBicycleInitPanel2.add(labelElectricBicycleImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		electricBicycleInitPanel.add(separator);


	//--------------------text Field--------------------

		textFieldElectricBicycleInit1 = new JTextField("",10);
		textFieldElectricBicycleInit1.setBounds(150, 120, 210, 36);
		electricBicycleInitPanel.add(textFieldElectricBicycleInit1);


		textFieldElectricBicycleInit2 = new JTextField("",10);
		textFieldElectricBicycleInit2.setBounds(150, 190, 210, 36);
		electricBicycleInitPanel.add(textFieldElectricBicycleInit2);


		textFieldElectricBicycleInit3 = new JTextField("",10);
		textFieldElectricBicycleInit3.setBounds(150, 260, 210, 36);
		electricBicycleInitPanel.add(textFieldElectricBicycleInit3);


		textFieldElectricBicycleInit4 = new JTextField("",10);
		textFieldElectricBicycleInit4.setBounds(150, 330, 210, 36);
		electricBicycleInitPanel.add(textFieldElectricBicycleInit4);	
		
		ButtonGroup ElectricBicyclegroup=new ButtonGroup();

		ElectricBicyclegroup.add(radioEB1);
		radioEB1=new JRadioButton("dirt");
		radioEB1.setBounds(169,390, 52, 23);
		electricBicycleInitPanel.add(radioEB1);
		
		ElectricBicyclegroup.add(radioEB2);
		radioEB2=new JRadioButton("paved");
		radioEB2.setBounds(275,390, 70, 25);
		electricBicycleInitPanel.add(radioEB2);
				
		radioEB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioEB1.isSelected())
					road="dirt";
				radioEB2.setSelected(false);
			}
		});
		
		radioEB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioEB2.isSelected())
					road="paved";
				radioEB1.setSelected(false);
			}
		});
		
		radioEB1.setBackground(Color.LIGHT_GRAY);
		radioEB2.setBackground(Color.LIGHT_GRAY);
		
		ButtonGroup ElectricBicyclecolorgroup=new ButtonGroup();
		ElectricBicyclecolorgroup.add(red);
		red=new JRadioButton("");
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(70,130,180));
		electricBicycleInitPanel2.add(red);

				
		ElectricBicyclecolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(70,130,180));
		electricBicycleInitPanel2.add(yellow);
		
		ElectricBicyclecolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(70,130,180));
		electricBicycleInitPanel2.add(blue);
						
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

		frameOfElectricBicycle.add(electricBicycleInitPanel);
		frameOfElectricBicycle.add(electricBicycleInitPanel2);
	}

}
