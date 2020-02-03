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

import Hw_2.Frigate;
/**
 * class GUI FrigateInit implements Runnable
 * @author Eliran and Maria
 */
public class FrigateInit implements Runnable{
	
	private JTextField textFieldFrigateInit1,textFieldFrigateInit2,textFieldFrigateInit3;
	private JButton btn1,btn2,btn3,btn4;
	private JLabel label1,label2,label3,label4,label5,label6,label7;
	private JLabel labelFrigateImage;
	private Image newImg= new ImageIcon(this.getClass().getResource("/Frigate.png")).getImage();
	private final Image frigateImage = newImg.getScaledInstance(390, 450, Image.SCALE_SMOOTH);
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	private String frigateUploadImage="/Frigate.png";
	private JFrame frameOfFrigate;
	private JSeparator separator;
	private double speed;
	private int seats;
	private boolean windD;
	private String model,color;
	private JRadioButton radioF1,radioF2,blue,yellow,red;;
	private Image newImg2,newImg3 ,newImg4;
	private JPanel frigateInitPanel=new JPanel();
	private JPanel frigateInitPanel2 = new JPanel();
	
	
	/**
	 * Run function,activates when thread of FrigateInit started or when it is called directly by object from the class 
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
					if (radioF1.isSelected() == false && radioF2.isSelected() == false)
						throw new Exception();
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					model=textFieldFrigateInit1.getText();
					seats=Integer.parseInt(textFieldFrigateInit2.getText());
					speed=Double.parseDouble(textFieldFrigateInit3.getText());
					MainPage.initialization(new Frigate (model,seats,speed,windD), frigateUploadImage,color);
					frigateReset();
					Thread t=new Thread(new Progress(2,frameOfFrigate));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfFrigate,"Wrong insertion.");
					frigateReset();
				}
			}
		});
		newImg = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg));
		frigateInitPanel2.add(btn1);
		
		btn2 = new JButton("Reset");
		btn2.setBounds(251, 571, 109, 39);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frigateReset();
			}
		});
		newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		frigateInitPanel2.add(btn2);
		
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameOfFrigate.dispose();
				frigateReset();
			}
		});
		newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		frigateInitPanel2.add(btn3);
		
	
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
	                    frigateUploadImage=path;
	                    labelFrigateImage.setIcon(MainPage.ResizeImage(path));
	                }
	        }
	    });
		btn4.setBounds(220, 413, 108, 34);
		frigateInitPanel2.add(btn4);
		
		frameOfFrigate.setVisible(true);
		frigateInitPanel.setVisible(true);
		frigateInitPanel2.setVisible(true);
	}
	
	/**
	 * Reset all the fields that related to frigate class
	 */
	private void frigateReset()
	{
		textFieldFrigateInit1.setText("");
		textFieldFrigateInit2.setText("");
		textFieldFrigateInit3.setText("");
		radioF1.setSelected(false);
		radioF2.setSelected(false);
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelFrigateImage.setIcon(new ImageIcon(frigateImage));
		frigateUploadImage="/Frigate.png";
	}
	
	/**
	 * Initialization of Frigate frame	 
	 */
	private void init() {
		frameOfFrigate = new JFrame("Frigate Initialization");
		frameOfFrigate.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfFrigate.setBounds(85, 30, 1155, 700);
		frameOfFrigate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfFrigate.getContentPane().setLayout(null);
		frameOfFrigate.setVisible(false);
		
		frigateInitPanel.setBackground(Color.LIGHT_GRAY);
		frigateInitPanel.setBounds(370, 0, 562, 653);
		frigateInitPanel.setLayout(null);
		frigateInitPanel.setVisible(false);
		
		frigateInitPanel2.setBackground(new Color(70,130,180));
		frigateInitPanel2.setBounds(0, 0, 390, 653);
		frigateInitPanel2.setLayout(null);
		frigateInitPanel2.setVisible(false);
		
	//--------------------Labels--------------------
		
		label1 = new JLabel("Frigate Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(155, 20, 300, 30);
		frigateInitPanel.add(label1);
		
		label2 = new JLabel("Model:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 85, 89, 23);
		frigateInitPanel.add(label2);
		
		label3 = new JLabel("Max number of seats:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label3.setBounds(150, 160, 200, 23);
		frigateInitPanel.add(label3);
		
		label4 = new JLabel("Speed:");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label4.setBounds(150, 230, 89, 23);
		frigateInitPanel.add(label4);
		
		label5 = new JLabel("Wind direction:");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label5.setBounds(150, 300, 200, 23);
		frigateInitPanel.add(label5);
		
		label6 = new JLabel("Add picture:");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label6.setForeground(Color.BLACK);
		label6.setBounds(23, 400, 187, 48);		
		frigateInitPanel2.add(label6);
		
		label7= new JLabel("");
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label7.setIcon(new ImageIcon((Image1)));
		label7.setBounds(23, 470, 187, 48);
		frigateInitPanel2.add(label7);
		
		labelFrigateImage = new JLabel("");
		labelFrigateImage.setBounds(0, 0, 370, 374);
		labelFrigateImage.setIcon(new ImageIcon(frigateImage));
		frigateInitPanel2.add(labelFrigateImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		frigateInitPanel.add(separator);
		
		
	//--------------------text Field--------------------
		
		textFieldFrigateInit1 = new JTextField("",10);
		textFieldFrigateInit1.setBounds(150, 120, 210, 36);
		frigateInitPanel.add(textFieldFrigateInit1);
		
		
		textFieldFrigateInit2 = new JTextField("",10);
		textFieldFrigateInit2.setBounds(150, 190, 210, 36);
		frigateInitPanel.add(textFieldFrigateInit2);
		
		
		textFieldFrigateInit3 = new JTextField("",10);
		textFieldFrigateInit3.setBounds(150, 260, 210, 36);
		frigateInitPanel.add(textFieldFrigateInit3);
		
		ButtonGroup Frigategroup=new ButtonGroup();

		Frigategroup.add(radioF1);
		radioF1=new JRadioButton("True");
		radioF1.setBounds(169,330, 52, 23);
		frigateInitPanel.add(radioF1);
		
		Frigategroup.add(radioF2);
		radioF2=new JRadioButton("False");
		radioF2.setBounds(281,330, 55, 25);
		frigateInitPanel.add(radioF2);
				
		radioF1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioF1.isSelected())
					windD=true;
				radioF2.setSelected(false);
			}
		});
		
		radioF2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioF2.isSelected())
					windD=false;
				radioF1.setSelected(false);
			}
		});
		
		radioF1.setBackground(Color.LIGHT_GRAY);
		radioF2.setBackground(Color.LIGHT_GRAY);
		
		ButtonGroup Frigatecolorgroup=new ButtonGroup();
		
		Frigatecolorgroup.add(red);
		red=new JRadioButton();
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(70,130,180));
		frigateInitPanel2.add(red);

		Frigatecolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(70,130,180));
		frigateInitPanel2.add(yellow);
		
		Frigatecolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(70,130,180));
		frigateInitPanel2.add(blue);
						
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
		
		frameOfFrigate.add(frigateInitPanel);
		frameOfFrigate.add(frigateInitPanel2);

	}

}
