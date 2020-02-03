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
import Hw_2.Jeep;

/**
 * class GUI JeepInit implements Runnable
 * @author Eliran and Maria
 */
public class JeepInit implements Runnable{
	
	private JTextField textFieldJeepInit1,textFieldJeepInit2,textFieldJeepInit3,textFieldJeepInit4;
	private JButton btn1,btn2,btn3,btn4;
	private JLabel label1,label2,label3,label4,label5,label6,label7;
	private JLabel labelJeepImage;
	
	private Image newImg = new ImageIcon(this.getClass().getResource("/xx.jpg")).getImage();
	private final Image jeepImage = newImg.getScaledInstance(390, 450, Image.SCALE_SMOOTH);
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	private String jeepUploadImage="/xx.jpg";
	private JFrame frameOfJeep;
	private JSeparator separator;
	private double avgFuel,speed;
	private float avgLifeTime;
	private String model,color;
	private Image newImg2,newImg3 ,newImg4;
	private JRadioButton blue,yellow,red;
	
	private JPanel jeepInitPanel=new JPanel();
	private JPanel jeepInitPanel2 = new JPanel();
	 
	
	/**
	 * Run function,activates when thread of JeepInit started or when it is called directly by object from the class 
	 */
	@Override
	public void run() 
	{

		init();

	//--------------------Buttons--------------------
		
		btn1 = new JButton("Continue");
		btn1.setBounds(10, 571, 113, 39);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldJeepInit1.getText();
					avgFuel=Integer.parseInt(textFieldJeepInit2.getText());
					speed=Double.parseDouble(textFieldJeepInit3.getText());
					avgLifeTime=Float.parseFloat(textFieldJeepInit4.getText());
					MainPage.initialization(new Jeep(model,avgFuel,speed,avgLifeTime),jeepUploadImage,color);
					jeepReset();
					
					Thread t=new Thread(new Progress(2,frameOfJeep));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfJeep,"Wrong insertion.");
					jeepReset();
				}
			}
		});
		newImg = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg));
		jeepInitPanel2.add(btn1);
		
		btn2 = new JButton("Reset");
		btn2.setBounds(251, 571, 109, 39);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jeepReset();
			}
		});
		newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		jeepInitPanel2.add(btn2);
		
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameOfJeep.dispose();
				jeepReset();
			}
		});
		newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		jeepInitPanel2.add(btn3);
		
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
	                    jeepUploadImage=path;
	                    labelJeepImage.setIcon(MainPage.ResizeImage(path));
	                }
	        }
	    });
		btn4.setBounds(220, 413, 108, 34);
		jeepInitPanel2.add(btn4);
		
		frameOfJeep.setVisible(true);
		jeepInitPanel.setVisible(true);
		jeepInitPanel2.setVisible(true);

	}
	
	/**
	 * Reset all the fields that related to jeep class
	 */
	private void jeepReset()
	{
		textFieldJeepInit1.setText("");
		textFieldJeepInit2.setText("");
		textFieldJeepInit3.setText("");
		textFieldJeepInit4.setText("");
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelJeepImage.setIcon(new ImageIcon(jeepImage));
		jeepUploadImage="/xx.jpg";
	}
	/**
	 * Initialization of Jeep frame	 
	 */
	private void init()
	{
		frameOfJeep = new JFrame("Jeep Initialization");
		frameOfJeep.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfJeep.setBounds(85, 30, 1155, 700);
		frameOfJeep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfJeep.getContentPane().setLayout(null);
		frameOfJeep.setVisible(false);
		
		
		jeepInitPanel.setBackground(Color.LIGHT_GRAY);
		jeepInitPanel.setBounds(370, 0, 562, 653);
		jeepInitPanel.setLayout(null);
		jeepInitPanel.setVisible(false);
		
		
		jeepInitPanel2.setBackground(Color.DARK_GRAY);
		jeepInitPanel2.setBounds(0, 0, 390, 653);
		jeepInitPanel2.setLayout(null);
		jeepInitPanel2.setVisible(false);

	//--------------------Labels--------------------
	
		label1 = new JLabel("Jeep initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(155, 20, 210, 30);
		jeepInitPanel.add(label1);
		
		label2 = new JLabel("Model:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 85, 89, 23);
		jeepInitPanel.add(label2);
		
		label3 = new JLabel("Average fuel consumption:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(150, 160, 200, 23);
		jeepInitPanel.add(label3);
		
		label4 = new JLabel("Speed:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(150, 230, 89, 23);
		jeepInitPanel.add(label4);
		
		label5 = new JLabel("Average life time:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(150, 300, 200, 23);
		jeepInitPanel.add(label5);
		
		label6 = new JLabel("Add picture:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label6.setForeground(Color.BLACK);
		label6.setBounds(23, 400, 187, 48);
		jeepInitPanel2.add(label6);
		
		label7= new JLabel();
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label7.setIcon(new ImageIcon((Image1)));
		label7.setBounds(23, 470, 187, 48);
		jeepInitPanel2.add(label7);
		
		labelJeepImage = new JLabel("");
		labelJeepImage.setBounds(0, 0, 370, 374);
		labelJeepImage.setIcon(new ImageIcon(jeepImage));
		jeepInitPanel2.add(labelJeepImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		jeepInitPanel.add(separator);
		
	//--------------------text Field--------------------
	
		
		textFieldJeepInit1 = new JTextField("",10);
		textFieldJeepInit1.setBounds(150, 120, 210, 36);
		jeepInitPanel.add(textFieldJeepInit1);
		
		
		textFieldJeepInit2 = new JTextField("",10);
		textFieldJeepInit2.setBounds(150, 190, 210, 36);
		jeepInitPanel.add(textFieldJeepInit2);
		
		
		textFieldJeepInit3 = new JTextField("",10);
		textFieldJeepInit3.setBounds(150, 260, 210, 36);
		jeepInitPanel.add(textFieldJeepInit3);
		
		textFieldJeepInit4 = new JTextField("",10);
		textFieldJeepInit4.setBounds(150, 330, 210, 36);
		jeepInitPanel.add(textFieldJeepInit4);
		
		ButtonGroup Jeepcolorgroup=new ButtonGroup();
		Jeepcolorgroup.add(red);
		red=new JRadioButton();
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(Color.DARK_GRAY);
		jeepInitPanel2.add(red);

				
		Jeepcolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(Color.DARK_GRAY);
		jeepInitPanel2.add(yellow);
		
		Jeepcolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(Color.DARK_GRAY);
		jeepInitPanel2.add(blue);
						
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
		
		frameOfJeep.add(jeepInitPanel);
		frameOfJeep.add(jeepInitPanel2);
	}
}
