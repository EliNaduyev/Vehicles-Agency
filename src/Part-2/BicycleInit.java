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

import Hw_2.Bicycle;


/**
 * class GUI BicycleInit implements Runnable
 * @author Eliran and Maria
 */
public class BicycleInit implements Runnable {

	private JFrame frameOfBicycle;
	private JPanel bicycleInitPanel,bicycleInitPanel2;
	private JLabel label1,label2,label3,label4,label5,label6,label7;
	private String bicycleUploadImage="/bicycle.jpg";
	private JLabel labelBicycleImage;
	private JSeparator separator;
	private JTextField textFieldBicycleInit1,textFieldBicycleInit2,textFieldBicycleInit3;
	private JButton btn1,btn2,btn3,btn4;
	private String model,road,color;
	private double speed;
	private int seats;
	private JRadioButton radioB1,radioB2,blue,yellow,red;
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	
	private Image newImg1= new ImageIcon(this.getClass().getResource("/bicycle.jpg")).getImage();
	private final Image bicycleImage= newImg1.getScaledInstance(390, 450, Image.SCALE_SMOOTH);
	
	/**
	 * Run function,activates when thread of BicycleInit started or when it is called directly by object from the class 
	 */
	@Override
	public void run() 
	{
		init();
	//--------------------Buttons--------------------

		btn1 = new JButton("Continue");
		btn1.setBounds(10, 571, 113, 39);
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					if (radioB1.isSelected() == false && radioB2.isSelected() == false)
						throw new Exception();
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldBicycleInit1.getText();
					seats=Integer.parseInt(textFieldBicycleInit2.getText());
					speed=Double.parseDouble(textFieldBicycleInit3.getText());
					MainPage.initialization(new Bicycle(model,seats,speed,road), bicycleUploadImage,color);
					bicycleReset();
					Thread t=new Thread(new Progress(2,frameOfBicycle));
	    			t.start(); 
				}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfBicycle,"Wrong insertion.");
					bicycleReset();
				}
			}

		});
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		bicycleInitPanel2.add(btn1);

		btn2 = new JButton("Reset");
		btn2.setBounds(251, 571, 109, 39);
		btn2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				bicycleReset();
			}
		});
		Image newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		bicycleInitPanel2.add(btn2);

		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frameOfBicycle.dispose();
				bicycleReset();
			}
		});
		Image newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		bicycleInitPanel2.add(btn3);

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
		                bicycleUploadImage=path;
		                labelBicycleImage.setIcon(MainPage.ResizeImage(path));
		            }
		    }
		});
		Image newImg4 = upload.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(newImg4));
		btn4.setBounds(220, 413, 108, 34);
		bicycleInitPanel2.add(btn4);
		
		frameOfBicycle.setVisible(true);
		bicycleInitPanel.setVisible(true);
		bicycleInitPanel2.setVisible(true);

	}
	
	/**
	 * Reset all the fields that related to bicycle class
	 */
	private void bicycleReset()
	{
		textFieldBicycleInit1.setText("");
		textFieldBicycleInit2.setText("");
		textFieldBicycleInit3.setText("");
		radioB1.setSelected(false);
		radioB2.setSelected(false);
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelBicycleImage.setIcon(new ImageIcon(bicycleImage));
		bicycleUploadImage="/bicycle.jpg";
		
	}
	
	/**
	 * Initialization of Bicycle frame	 
	 */
	private void init() {
		frameOfBicycle = new JFrame("Bicycle Initialization");
		frameOfBicycle.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfBicycle.setBounds(85, 30, 1155, 700);
		frameOfBicycle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfBicycle.getContentPane().setLayout(null);
		
		bicycleInitPanel= new JPanel();
		bicycleInitPanel.setBackground(Color.LIGHT_GRAY);
		bicycleInitPanel.setBounds(370, 0, 562, 653);
		bicycleInitPanel.setLayout(null);

		
		bicycleInitPanel2= new JPanel();
		bicycleInitPanel2.setBackground(new Color(102,153,255));
		bicycleInitPanel2.setBounds(0, 0, 390, 653);
		bicycleInitPanel2.setLayout(null);
		
		frameOfBicycle.setVisible(false);
		bicycleInitPanel.setVisible(false);
		bicycleInitPanel2.setVisible(false);
		
		
		//---------------------------Bicycle init--------------------------------------------------------


				label1 = new JLabel("Bicycle Initialization");
				label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
				label1.setBounds(145, 20, 250, 30);
				bicycleInitPanel.add(label1);

				label2 = new JLabel("Model:");
				label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				label2.setBounds(150, 85, 89, 23);
				bicycleInitPanel.add(label2);

				label3 = new JLabel("Seats:");
				label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
				label3.setBounds(150, 160, 200, 23);
				bicycleInitPanel.add(label3);

				label4 = new JLabel("Speed:");
				label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
				label4.setBounds(150, 230, 89, 23);
				bicycleInitPanel.add(label4);

				label5 = new JLabel("Road:");
				label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
				label5.setBounds(150, 300, 200, 23);
				bicycleInitPanel.add(label5);

				label6 = new JLabel("Add picture:");
				label6.setFont(new Font("Tahoma", Font.PLAIN, 24));
				label6.setForeground(Color.BLACK);
				label6.setBounds(23, 400, 187, 48);
				bicycleInitPanel2.add(label6);
				
				label7= new JLabel("");
				Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
				Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
				label7.setIcon(new ImageIcon((Image1)));
				label7.setBounds(23, 470, 187, 48);
				bicycleInitPanel2.add(label7);

				labelBicycleImage = new JLabel("");
				labelBicycleImage.setBounds(0, 0, 370, 374);
				labelBicycleImage.setIcon(new ImageIcon(bicycleImage));
				bicycleInitPanel2.add(labelBicycleImage);
				
				separator = new JSeparator();
				separator.setBounds(100, 55, 318, 2);
				bicycleInitPanel.add(separator);


				//--------------------text Field--------------------


				textFieldBicycleInit1 = new JTextField("",10);
				textFieldBicycleInit1.setBounds(150, 120, 210, 36);
				bicycleInitPanel.add(textFieldBicycleInit1);


				textFieldBicycleInit2 = new JTextField("",10);
				textFieldBicycleInit2.setBounds(150, 190, 210, 36);
				bicycleInitPanel.add(textFieldBicycleInit2);


				textFieldBicycleInit3 = new JTextField("",10);
				textFieldBicycleInit3.setBounds(150, 260, 210, 36);
				bicycleInitPanel.add(textFieldBicycleInit3);
				
				ButtonGroup Bicyclegroup=new ButtonGroup();

				Bicyclegroup.add(radioB1);
				radioB1=new JRadioButton("dirt");
				radioB1.setBounds(169,325, 52, 23);
				bicycleInitPanel.add(radioB1);
				
				Bicyclegroup.add(radioB2);
				radioB2=new JRadioButton("paved");
				radioB2.setBounds(275,325, 70, 25);
				bicycleInitPanel.add(radioB2);
						
				radioB1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (radioB1.isSelected())
							road="dirt";
						radioB2.setSelected(false);
					}
				});
				
				radioB2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (radioB2.isSelected())
							road="paved";
						radioB1.setSelected(false);
					}
				});
				
				radioB1.setBackground(Color.LIGHT_GRAY);
				radioB2.setBackground(Color.LIGHT_GRAY);
				
				ButtonGroup Bicyclecolorgroup=new ButtonGroup();
				Bicyclecolorgroup.add(red);
				red=new JRadioButton("");
				Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
				Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
				red.setIcon(new ImageIcon((Image2)));
				red.setBounds(100,485, 25, 25);
				red.setBackground(new Color(102,153,255));
				bicycleInitPanel2.add(red);

						
				Bicyclecolorgroup.add(yellow);
				yellow=new JRadioButton("");
				Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
				Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
				yellow.setIcon(new ImageIcon((Image3)));
				yellow.setBounds(150,485, 25, 25);
				yellow.setBackground(new Color(102,153,255));
				bicycleInitPanel2.add(yellow);
				
				Bicyclecolorgroup.add(blue);
				blue=new JRadioButton("");
				Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
				Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
				blue.setIcon(new ImageIcon((Image4)));
				blue.setBounds(200,485, 25, 25);
				blue.setBackground(new Color(102,153,255));
				bicycleInitPanel2.add(blue);
								
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

				frameOfBicycle.add(bicycleInitPanel);
				frameOfBicycle.add(bicycleInitPanel2);

	}
	
}
