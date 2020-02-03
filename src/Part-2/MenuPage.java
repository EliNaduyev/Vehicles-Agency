/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;
import Hw_4.*;
import Hw_4.Observer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import Hw_2.*;

/**
 * class MenuPage in GUI implements Runnable
 * @author Eliran and Maria
 */
public class MenuPage extends Observer implements Runnable{
	
	private JFrame frameOfMenu;
	private JPanel menuMainGalleryPanel=new JPanel();
	private JPanel menuMainBtnsPanel=new JPanel();
	private int flag=-1;
	private final Image reset = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
	private final Image add = new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
	private final Image exit = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
	private final Image ch = new ImageIcon(this.getClass().getResource("/ch.png")).getImage();
	private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	private Image newImg1;
	private Random rand;
	private int bcount=0;
	private static int counter=0;   // why not private
	private JLabel label1;
	private static JLabel totalDis;
	private static double[] total=new double[3];

	static private volatile MenuPage instance =null;
	
	/**
	 * constructor of the class that make frame and label totalDis
	 */
	 private MenuPage() {
			frameOfMenu = new JFrame("Menu");
			totalDis= new JLabel(" 0.0");

	}
	 /**
		 * DP (singleton) allowing create only one object of the MenuPage class
		 */
	 public static MenuPage getInstance() {
		 if (instance ==null)
			 synchronized(MenuPage.class) {
				 if (instance ==null)
					 instance=new MenuPage(); 
			 }
		 
		 return instance;
		 
	 }
	/**
	 * Run function,activates when thread of MainPage started or when it is called directly by object from the class 
	 */
	
	@Override
	public void run() {

		frameOfMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
		frameOfMenu.setBounds(85, 30, 1155, 700);
		frameOfMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameOfMenu.getContentPane().setLayout(null);
		
		frameOfMenu.addWindowListener(new WindowAdapter() {
			public synchronized void windowActivated(WindowEvent e) {
				menuMainGalleryPanel.removeAll();
				MainPage.arrOfLabeles.clear();
				if(MainPage.arrOfImages.size()!=0)
				{
					for(int i=0;i<MainPage.arrOfImages.size();i++)
						printfoo(i);				
					for(int i=0;i<MainPage.arrOfLabeles.size();i++)
						(MainPage.arrOfLabeles.get(i)).addMouseListener(new ML(i));
					for (int j=0;j<MainPage.arrOfLabeles.size();j++)
						menuMainGalleryPanel.add(MainPage.arrOfLabeles.get(j));
				}
				frameOfMenu.repaint();
				menuMainGalleryPanel.setVisible(false);
				menuMainGalleryPanel.setVisible(true);
			}
			
		});
		
		menuMainGalleryPanel.setBounds(100, 55, 950, 400);
		menuMainGalleryPanel.setBackground(Color.DARK_GRAY);
		menuMainGalleryPanel.setLayout(new FlowLayout());
		
		menuMainBtnsPanel.setBounds(52, 38, 1030, 591);
		menuMainBtnsPanel.setBackground(Color.DARK_GRAY);
		menuMainBtnsPanel.setLayout(null);		
		
		frameOfMenu.setVisible(false);
		menuMainGalleryPanel.setVisible(false);
		menuMainBtnsPanel.setVisible(false);
		
		// -------------------Label of total distance -----------
		
		
				label1= new JLabel("Total Distance:");
				label1.setBounds(40, 420, 170, 48);
				label1.setForeground(new Color(255, 239, 213));
				label1.setBackground(Color.WHITE);
				label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				menuMainBtnsPanel.add(label1);
				
				
				totalDis.setBounds(180, 420, 170, 48);
				totalDis.setForeground(Color.RED);
				totalDis.setBackground(Color.RED);
				totalDis.setFont(new Font("Tahoma", Font.PLAIN, 20));
				menuMainBtnsPanel.add(totalDis);
		
		
		
	//---------------------Menu Frame------------------------
		
		btn1 = new JButton("add new vehicle");
		newImg1 = add.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(newImg1));
		btn1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				flag=-1;
				Thread mainPage=new Thread(new MainPage());
				mainPage.start();
			}
		});
		btn1.setBounds(40, 470, 170, 48);
		menuMainBtnsPanel.add(btn1);
		
		
		btn2 = new JButton("Reset all");
		newImg1 = reset.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(newImg1));
		btn2.addActionListener(new ActionListener() 
		{
			public synchronized void actionPerformed(ActionEvent e) 
			{
				flag=-1;
				for (int i=0;i<MainPage.arrOfCars.size();i++)
				{
    				(MainPage.arrOfCars.get(i)).movement(-((MainPage.arrOfCars.get(i)).getDistance()));
    				(MainPage.arrOfLabeles.get(i)).setToolTipText((MainPage.arrOfCars.get(i)).toString());
				}
				Thread t=new Thread(new Progress(3,frameOfMenu));
				t.start();
			}
		});
		btn2.setBounds(230, 470, 170, 48);
		menuMainBtnsPanel.add(btn2);
		
		btn3 = new JButton("Change all flags");
		newImg1 = ch.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(newImg1));
		btn3.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				flag=-1;
				Thread changeAllFlags=new Thread(new ChangeAllFlags(frameOfMenu));
				changeAllFlags.start();

			}
		});
		btn3.setBounds(430, 470, 170, 48);
		menuMainBtnsPanel.add(btn3);
		
		btn4 = new JButton("Exit");
		newImg1 = exit.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btn4.setIcon(new ImageIcon(newImg1));
		btn4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(TestDrive.getCount()!=0)
		    		JOptionPane.showMessageDialog(frameOfMenu,"Not all the test drives end, try again later");
				else if(bcount!=0)
		    		JOptionPane.showMessageDialog(frameOfMenu,"Not all the buy prosses was end, try again later");
				else
					System.exit(0);
			}
		});
		btn4.setBounds(620, 470, 170, 48);
		menuMainBtnsPanel.add(btn4);
		
		btn5 = new JButton("buy vehicle");
		btn5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			    	if (flag==-1) {
			    		JOptionPane.showMessageDialog(frameOfMenu,"Choose picture!");
			    	}
			    	else
			    	{
			    		new SwingWorker<Void, Void>() {
			    			@Override
			    			protected Void doInBackground() throws Exception 
			    			{
			    				buyVehicle(flag);
			    				return null;
			    			}
			    	}.execute();
			    }
			}	
		});
		btn5.setBounds(130, 530, 170, 48);
		menuMainBtnsPanel.add(btn5);
		
		btn6 = new JButton("test drive");
		btn6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				if (flag==-1)
					JOptionPane.showMessageDialog(frameOfMenu,"Choose picture!");
				else {
					Thread testDrive=new Thread(new TestDrive (flag,(StatusDecorator)MainPage.arrOfCars.get(flag)));
					testDrive.start();
					flag=-1;
				}
					
			}
		});
		btn6.setBounds(330, 530, 170, 48);
		menuMainBtnsPanel.add(btn6);
		
		btn7 = new JButton("Updated inventory report");
		btn7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Thread t=new Thread(new UpdatedReport());
				t.start();
			}
		});
		btn7.setBounds(520, 530, 180, 48);
		menuMainBtnsPanel.add(btn7);
		
		btn8 = new JButton("Save");
		btn8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(counter>2) {
					counter=0;
				}
				Originator originator=new Originator();
				originator.setState(MainPage.arrOfCars, MainPage.arrOfMarines, MainPage.arrOfImages);
				total[counter]=(Vehicle.getTotal());
				Memento memento=originator.createMemento();
				Caretaker caretaker=new Caretaker();
				caretaker.addMemento(memento,counter);
				counter++;
			}
		});
		btn8.setBounds(800, 470, 180, 48);
		menuMainBtnsPanel.add(btn8);
		
		btn9 = new JButton("Load");
		btn9.addActionListener(new ActionListener() 
		{
			ArrayList<ArrayList<Object>> tmp;
			public void actionPerformed(ActionEvent e) 
			{
					counter--;
					if(counter<0)
						counter=2;
					Memento memento;
					Caretaker caretaker=new Caretaker();
					memento=caretaker.getMemento(counter);
					if (memento==null) {
						JOptionPane.showMessageDialog(frameOfMenu,"You don't have saved versions!");
						counter=0;
					}
					else 
					{
						Vehicle.setTotal(total[counter]);
						totalDis.setText(Double.toString(Vehicle.getTotal()));
						tmp=memento.getState();
						MainPage.arrOfCars.clear();
						for (int i=0;i<tmp.get(0).size();i++)
							MainPage.arrOfCars.add((StatusDecorator) tmp.get(0).get(i));
						MainPage.arrOfImages.clear();
						for (int i=0;i<tmp.get(1).size();i++)
							MainPage.arrOfImages.add((String) tmp.get(1).get(i));
						MainPage.arrOfMarines.clear();
						for (int i=0;i<tmp.get(2).size();i++)
							MainPage.arrOfMarines.add((StatusDecorator) tmp.get(2).get(i));

						menuMainGalleryPanel.removeAll();
						MainPage.arrOfLabeles.clear();
						if(MainPage.arrOfImages.size()!=0)
						{
							for(int i=0;i<MainPage.arrOfImages.size();i++)
								printfoo(i);
							for(int i=0;i<MainPage.arrOfLabeles.size();i++)
								(MainPage.arrOfLabeles.get(i)).addMouseListener(new ML(i));
							for (int j=0;j<MainPage.arrOfLabeles.size();j++)
								menuMainGalleryPanel.add(MainPage.arrOfLabeles.get(j));
						}
						frameOfMenu.repaint();
						menuMainGalleryPanel.setVisible(false);
						menuMainGalleryPanel.setVisible(true);
				}
			}
		});
		btn9.setBounds(800, 530, 180, 48);
		menuMainBtnsPanel.add(btn9);
		
		TestDrive tD=new TestDrive();
		tD.addObserver(instance);
		
		frameOfMenu.add(menuMainGalleryPanel, BorderLayout.NORTH);
		frameOfMenu.add(menuMainBtnsPanel, BorderLayout.SOUTH);
		frameOfMenu.setVisible(true);
		menuMainGalleryPanel.setVisible(true);
		menuMainBtnsPanel.setVisible(true);
	}


	/**
	 * class ML listen to the click of mouse and keeps the data about labels
	 */
	class ML extends MouseAdapter{
		private int tmp;
		public ML(int i) {
			tmp=i;
		}
		public void mouseClicked(MouseEvent e) {
			flag=tmp;
		}
	}
	
	/**
	 * printing the label with photo in the menu frame
	 * @param i index
	 */
	protected void printfoo(int i) {
		String tmp=MainPage.arrOfImages.get(i);
		JLabel lbl;
		if (tmp.startsWith("/"))
		{
			Image Image = new ImageIcon(this.getClass().getResource(tmp)).getImage();
			Image newImg1 = Image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
			lbl= new JLabel(new ImageIcon(newImg1));

		}
		else {
			ImageIcon MyImage = new ImageIcon(tmp);
	        Image img = MyImage.getImage();
	        Image newImg = img.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
	        ImageIcon image = new ImageIcon(newImg);
			lbl=new JLabel (image);
		}
		lbl.setToolTipText((MainPage.arrOfCars.get(i)).toString());
		lbl.setBorder(BorderFactory.createLineBorder((MainPage.arrOfCars.get(i)).getColor()));
		MainPage.arrOfLabeles.add(lbl);
		menuMainGalleryPanel.add(lbl);
		
		frameOfMenu.addWindowListener(new WindowAdapter() {
			public synchronized void windowDeactivated(WindowEvent e) {
				CarSuccessfullyAdded.tmp=frameOfMenu;
		}
		});
	}
	
	/**
	 * A function with which we buy the vehicle
	 * @param flag The index of the vehicle that we want to buy 
	 */
	private void buyVehicle(int flag) {
		MainPage.arrOfCars.get(flag).setStatus("In purchasing processes");
		(MainPage.arrOfLabeles.get(flag)).setToolTipText((MainPage.arrOfCars.get(flag)).toString());

		bcount++;
		synchronized(MainPage.arrOfCars.get(flag))
		{
			rand=new Random();
			int sleep=5000+rand.nextInt(5000);
			try {
				Thread.sleep(sleep);	
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			JDialog.setDefaultLookAndFeelDecorated(false);
		    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this vehicle ? ", "Confirm",
		        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (response == JOptionPane.YES_OPTION) 
			{
				
				for(int j=0;j<MainPage.arrOfMarines.size();j++)
					if((MainPage.arrOfMarines.get(j)).equal(MainPage.arrOfCars.get(flag)))
						MainPage.arrOfMarines.remove(j);
				MainPage.arrOfCars.remove(flag);
				MainPage.arrOfImages.remove(flag);
				MainPage.arrOfLabeles.remove(flag);
				for(int i=0;i<MainPage.arrOfLabeles.size();i++)
					(MainPage.arrOfLabeles.get(i)).addMouseListener(new ML(i));
				menuMainGalleryPanel.removeAll();
				Thread t=new Thread(new Progress(1,frameOfMenu));
				t.start(); 
				for (int j=0;j<MainPage.arrOfLabeles.size();j++)
					menuMainGalleryPanel.add(MainPage.arrOfLabeles.get(j));
				frameOfMenu.repaint();	
			}
			else {
				MainPage.arrOfCars.get(flag).setStatus("In stock");
				(MainPage.arrOfLabeles.get(flag)).setToolTipText((MainPage.arrOfCars.get(flag)).toString());

			}
			flag=-1;
			bcount--;
		}
	}
	
	/**
	 * function that update the label of the total distance.
	 */
	@Override
	public void update() {
		String tmp;
		tmp=Double.toString(Vehicle.getTotal());
		totalDis.setText(tmp);
		
	}
	
}
	
	


