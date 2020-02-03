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

import Hw_2.DownGame;

/**
 * class GUI DownGameInit implements Runnable
 * @author Eliran and Maria
 */
public class DownGameInit implements Runnable{
	
	
	private JButton btn1,btn2,btn3,btn4;
	private JLabel label1,label2,label3;
	private JLabel labelDownGameImage;
	private Image newImage= new ImageIcon(this.getClass().getResource("/downgame.jpg")).getImage();
	private final Image downGameImage = newImage.getScaledInstance(390, 450, Image.SCALE_SMOOTH);
	private final Image enter = new ImageIcon(this.getClass().getResource("/Enter.png")).getImage();
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image upload = new ImageIcon(this.getClass().getResource("/upload.png")).getImage();
	private String downGameUploadImage="/downgame.jpg";
	private String color;
	private JFrame frameOfDownGame;
	private JRadioButton blue,yellow,red;
	private JSeparator separator;
	private Image newImg1,newImg3 ,newImg4,newImg2;
	private JPanel downGameInitPanel2= new JPanel();
	private JPanel downGameInitPanel=new JPanel();

	/**
	 * Run function,activates when thread of DownGameInit started or when it is called directly by object from the class 
	 */
	@Override
	public void run() {
		init();
	//--------------------Buttons--------------------
				
		btn1 = new JButton("Continue");
		btn1.addActionListener(new ActionListener() {
			public synchronized void actionPerformed(ActionEvent e) {
				try {
					if (red.isSelected() == false && yellow.isSelected() == false && blue.isSelected() == false)
						throw new Exception();
					MainPage.initialization(new DownGame(), downGameUploadImage,color);
					downGameReset();
					Thread t=new Thread(new Progress(2,frameOfDownGame));
	    			t.start(); 
					}
				catch(Exception c)
				{
					JOptionPane.showMessageDialog(frameOfDownGame,"Wrong insertion.");
					downGameReset();
				}
			}
		});
		btn1.setBounds(10, 571, 113, 39);
		newImg1 = enter.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		downGameInitPanel2.add(btn1);
		
		btn2 = new JButton("Reset");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				downGameReset();
			}
		});
		btn2.setBounds(251, 571, 109, 39);
		newImg2 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg2));
		downGameInitPanel2.add(btn2);
		
		btn3 = new JButton("Back");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameOfDownGame.dispose();
				downGameReset();
			}
		});
		newImg3 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg3));
		btn3.setBounds(133, 571, 108, 39);
		downGameInitPanel2.add(btn3);
		
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
                        downGameUploadImage=path;
                        labelDownGameImage.setIcon(MainPage.ResizeImage(path));
                    }
            }
        });
		newImg4 = upload.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(newImg4));
		btn4.setBounds(220, 413, 108, 34);
		downGameInitPanel2.add(btn4);
		
		frameOfDownGame.setVisible(true);
		downGameInitPanel.setVisible(true);
		downGameInitPanel2.setVisible(true);
	}
	/**
	 * Reset all the fields that related to down game class
	 */
	private void downGameReset() 
	{
		red.setSelected(false);
		yellow.setSelected(false);
		blue.setSelected(false);
		labelDownGameImage.setIcon(new ImageIcon(downGameImage));
		downGameUploadImage="/downgame.jpg";
	}
	
	/**
	 * Initialization of Down Game frame	 
	 */
	private void init() {
		frameOfDownGame = new JFrame("Down Game Initialization");
		frameOfDownGame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfDownGame.setBounds(85, 30, 1155, 700);
		frameOfDownGame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfDownGame.getContentPane().setLayout(null);
		frameOfDownGame.setVisible(false);
		
		downGameInitPanel.setBackground(Color.LIGHT_GRAY);
		downGameInitPanel.setBounds(370, 0, 562, 653);
		downGameInitPanel.setLayout(null);
		downGameInitPanel.setVisible(false);
		
		downGameInitPanel2.setBackground(new Color(230,230,250));
		downGameInitPanel2.setBounds(0, 0, 390, 653);
		downGameInitPanel2.setLayout(null);
		downGameInitPanel2.setVisible(false);

	//--------------------Labels--------------------

		label1 = new JLabel("Down Game Initialization");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label1.setBounds(100, 20, 350, 30);
		downGameInitPanel.add(label1);
		
		label2 = new JLabel("Add picture:");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label2.setForeground(Color.BLACK);
		label2.setBounds(23, 400, 187, 48);
		downGameInitPanel2.add(label2);
		
		label3= new JLabel("");
		Image newImg=new ImageIcon(this.getClass().getResource("/colorIcon.png")).getImage();
		Image Image1 = newImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		label3.setIcon(new ImageIcon((Image1)));
		label3.setBounds(23, 470, 187, 48);
		downGameInitPanel2.add(label3);
		
		labelDownGameImage = new JLabel("");
		labelDownGameImage.setBounds(0, 0, 370, 374);
		labelDownGameImage.setIcon(new ImageIcon(downGameImage));
		downGameInitPanel2.add(labelDownGameImage);
		
		separator = new JSeparator();
		separator.setBounds(100, 55, 318, 2);
		downGameInitPanel.add(separator);
		
		ButtonGroup DownGamecolorgroup=new ButtonGroup();
		DownGamecolorgroup.add(red);
		red=new JRadioButton("");
		Image newImg1=new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		Image Image2 = newImg1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		red.setIcon(new ImageIcon((Image2)));
		red.setBounds(100,485, 25, 25);
		red.setBackground(new Color(230,230,250));
		downGameInitPanel2.add(red);

				
		DownGamecolorgroup.add(yellow);
		yellow=new JRadioButton("");
		Image newImg2=new ImageIcon(this.getClass().getResource("/yellowIcon.png")).getImage();
		Image Image3 = newImg2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		yellow.setIcon(new ImageIcon((Image3)));
		yellow.setBounds(150,485, 25, 25);
		yellow.setBackground(new Color(230,230,250));
		downGameInitPanel2.add(yellow);
		
		DownGamecolorgroup.add(blue);
		blue=new JRadioButton("");
		Image newImg3=new ImageIcon(this.getClass().getResource("/blueIcon.png")).getImage();
		Image Image4 = newImg3.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		blue.setIcon(new ImageIcon((Image4)));
		blue.setBounds(200,485, 25, 25);
		blue.setBackground(new Color(230,230,250));
		downGameInitPanel2.add(blue);
						
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
		

		frameOfDownGame.add(downGameInitPanel);
		frameOfDownGame.add(downGameInitPanel2);
	}
}
