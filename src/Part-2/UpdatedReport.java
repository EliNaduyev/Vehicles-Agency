/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.*;

/**
 * class UpdatedReport in GUI implements Runnable
 * @author Eliran and Maria
 */
public class UpdatedReport implements Runnable{
	private JFrame  frameOfReport;
	private JPanel galleryPanel;
	private JPanel descriptionPanel;
	private final Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
	static ArrayList<JLabel> arrOfReportLabeles = new ArrayList<JLabel>();

	private JEditorPane txt;
	private JButton btn1;
	private Image newImg1;
	
	private static Lock l=new ReentrantLock();
	
	/**
	 * Run function,activates when thread of UpdatedReport started or when it is called directly by object from the class 
	 */
	public void run() {
		
		frameOfReport = new JFrame ("Updated Inventory Report");
		frameOfReport.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfReport.setBounds(85, 30, 1155, 700);
		frameOfReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfReport.getContentPane().setLayout(null);
			
		galleryPanel=new JPanel();
		galleryPanel.setBounds(52, 50, 1040, 400);
		galleryPanel.setBackground(Color.DARK_GRAY);
		galleryPanel.setLayout(new FlowLayout());
		
		descriptionPanel=new JPanel();
		descriptionPanel.setBounds(52, 450, 1040, 170);
		descriptionPanel.setBackground(Color.DARK_GRAY);
		descriptionPanel.setLayout(null);
		
		frameOfReport.addWindowListener(new WindowAdapter() {
			public synchronized void windowActivated(WindowEvent e) {
				galleryPanel.removeAll();
				arrOfReportLabeles.clear();
				if(MainPage.arrOfImages.size()!=0)
				{
					for(int i=0;i<MainPage.arrOfImages.size();i++)
						printfoo(i);				
					for(int i=0;i<arrOfReportLabeles.size();i++)
						(arrOfReportLabeles.get(i)).addMouseListener(new ME(i));
					for (int j=0;j<arrOfReportLabeles.size();j++)
						galleryPanel.add(arrOfReportLabeles.get(j));
				}
				frameOfReport.repaint();
				galleryPanel.setVisible(false);
				galleryPanel.setVisible(true);
			}
			public synchronized void windowDeactivated(WindowEvent e) {
					galleryPanel.removeAll();
			}
			
		});
		
		
	//------------------Buttons-------------------
		
		btn1 = new JButton("Back");
		newImg1 = back.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameOfReport.dispose();
			}
		});
		btn1.setBounds(200, 530, 170, 48);
		frameOfReport.add(btn1);
		
		synchronized(l) 
		{
			for (int i=0;i<arrOfReportLabeles.size();i++)
				galleryPanel.add(arrOfReportLabeles.get(i));

			for(int i=0;i<arrOfReportLabeles.size();i++)
				(arrOfReportLabeles.get(i)).addMouseListener(new ME(i));
		}
		txt= new JEditorPane();
		txt.setEditable(false);
		txt.setVisible(false);
		txt.setBounds(350,40, 350, 150);
		txt.setBackground(Color.DARK_GRAY);
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		descriptionPanel.add(txt);
		
		galleryPanel.setVisible(true);
		descriptionPanel.setVisible(true);
		frameOfReport.add(galleryPanel);
		frameOfReport.add(descriptionPanel);
		frameOfReport.setVisible(true);
	}
	/**
	 * class Me listen to the mouse and prints the data about labels
	 */
	 class ME extends MouseAdapter{
		private int tmp;
		public ME(int i) {
			tmp=i;
		}
		public void mouseEntered(MouseEvent e) {
			txt.setVisible(true);
			txt.setText(MainPage.arrOfCars.get(tmp).toString());
		}
		
		public void mouseExited(MouseEvent e)
		{
			txt.setVisible(false);

		}
	}

	/**
	 * printing the label with photo in the frame
	 * @param i index
	 */
	private void printfoo(int i) {
		String tmp= MainPage.arrOfImages.get(i);
		JLabel lbl;
		if (tmp.startsWith("/"))
		{
			Image Image = new ImageIcon(this.getClass().getResource(tmp)).getImage();
			Image newImg1 = Image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
			lbl=new JLabel(new ImageIcon(newImg1));
	
		}
		else 
		{
			ImageIcon MyImage = new ImageIcon(tmp);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
			lbl=new JLabel (image);
	
		}
		lbl.setBorder(BorderFactory.createLineBorder((MainPage.arrOfCars.get(i)).getColor()));
		UpdatedReport.arrOfReportLabeles.add(lbl);
	}
}
