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

import Hw_2.DownSpyware;

/**
 * class GUI DownSpywareInit implements Runnable
 * @author Eliran and Maria
 */
public class DownSpywareInit implements Runnable{
	
	
	private JFrame frameOfDownSpyware;
	private JPanel downSpywareInitPanel,downSpywareInitPanel2;
	private JLabel label1,label2,label3,label4;
	private String downSpywareUploadImage="/downspyware.jpg";
	private JLabel labelDownSpywareImage;
	private JSeparator separator;
	private JTextField textFieldDownSpywareInit1;
	private JButton btn1,btn2,btn3,btn4;
	private String powerSource,color;
	private JRadioButton blue,yellow,red;

	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	private Image newImg1= new ImageIcon(this.getClass().getResource("/downspyware.jpg")).getImage();
	private final Image downSpywareImage = newImg1.getScaledInstance(390, 450, Image.SCALE_SMOOTH);


	/**
	 * Run function,activates when thread of DownSpywareInit started or when it is called directly by object from the class 
	 */
	@Override
	public void run() {
		
		init();		
	//--------------------Buttons--------------------
				
		btn1 = new JButton("Continue");
		btn1.setBounds(10, 571, 113, 39);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					powerSource=textFieldDownSpywareInit1.getText();
					MainPage.initialization(new DownSpyware(powerSource), downSpywareUploadImage,color);
					downSpywareReset();
					Thread t=new Thread(new Progress(2,frameOfDownSpyware));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfDownSpyware,"Wrong insertion.");
					downSpywareReset();
				}
			}
		});
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		downSpywareInitPanel2.add(btn1);
		
		btn2 = new JButton("Reset");
		btn2.setBounds(251, 571, 109, 39);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				downSpywareReset();
			}
		});
		Image newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		downSpywareInitPanel2.add(btn2);
		
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameOfDownSpyware.dispose();
				downSpywareReset();
			}
		});
		Image newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		downSpywareInitPanel2.add(btn3);
		
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
                        downSpywareUploadImage=path;
                        labelDownSpywareImage.setIcon(MainPage.ResizeImage(path));
                    }
            }
        });
		btn4.setBounds(220, 413, 108, 34);
		downSpywareInitPanel2.add(btn4);
		
		frameOfDownSpyware.setVisible(true);
		downSpywareInitPanel.setVisible(true);
		downSpywareInitPanel2.setVisible(true);

	}
	
	/**
	 * Reset all the fields that related to down spyware class
	 */
	private void downSpywareReset()
	{
		textFieldDownSpywareInit1.setText("");
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelDownSpywareImage.setIcon(new ImageIcon(downSpywareImage));
		downSpywareUploadImage="/downspyware.jpg";
	}
	
	/**
	 * Initialization of Down Spyware frame	 
	 */
	private void init() {
		frameOfDownSpyware = new JFrame("Down Spyware Initialization");
		frameOfDownSpyware.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfDownSpyware.setBounds(85, 30, 1155, 700);
		frameOfDownSpyware.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfDownSpyware.getContentPane().setLayout(null);
		
		downSpywareInitPanel= new JPanel();
		downSpywareInitPanel.setBackground(Color.LIGHT_GRAY);
		downSpywareInitPanel.setBounds(370, 0, 562, 653);
		downSpywareInitPanel.setLayout(null);

		
		downSpywareInitPanel2= new JPanel();
		downSpywareInitPanel2.setBackground(new Color(102,153,255));
		downSpywareInitPanel2.setBounds(0, 0, 390, 653);
		downSpywareInitPanel2.setLayout(null);
		
		frameOfDownSpyware.setVisible(false);
		downSpywareInitPanel.setVisible(false);
		downSpywareInitPanel2.setVisible(false);
		
	//--------------------Labels--------------------

		label1 = new JLabel("Down Spyware Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(100, 20, 350, 30);
		downSpywareInitPanel.add(label1);
		
		label2 = new JLabel("Power source:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setBounds(150, 85, 150, 23);
		downSpywareInitPanel.add(label2);
		
		label3 = new JLabel("Add picture:");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label3.setForeground(Color.BLACK);
		label3.setBounds(23, 400, 187, 48);
		downSpywareInitPanel2.add(label3);
		
		label4= new JLabel();
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label4.setIcon(new ImageIcon((Image1)));
		label4.setBounds(23, 470, 187, 48);
		downSpywareInitPanel2.add(label4);
		
		labelDownSpywareImage = new JLabel("");
		labelDownSpywareImage.setBounds(0, 0, 370, 374);
		labelDownSpywareImage.setIcon(new ImageIcon(downSpywareImage));
		downSpywareInitPanel2.add(labelDownSpywareImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		downSpywareInitPanel.add(separator);
		
		
	//--------------------text Field--------------------
		
		textFieldDownSpywareInit1 = new JTextField("",10);
		textFieldDownSpywareInit1.setBounds(150, 120, 210, 36);
		downSpywareInitPanel.add(textFieldDownSpywareInit1);
		
		ButtonGroup DownSpywarecolorgroup=new ButtonGroup();
		
		DownSpywarecolorgroup.add(red);
		red=new JRadioButton("");
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(102,153,255));
		downSpywareInitPanel2.add(red);
				
		DownSpywarecolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(102,153,255));
		downSpywareInitPanel2.add(yellow);
		
		DownSpywarecolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(102,153,255));
		downSpywareInitPanel2.add(blue);
						
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
		
		frameOfDownSpyware.add(downSpywareInitPanel);
		frameOfDownSpyware.add(downSpywareInitPanel2);			
	}
	
}
