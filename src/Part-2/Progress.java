/*
 * Home Work 4:
    Eliran Naduyev 312089105
    Maria Garber 320767023
 */

package Hw_3;


import java.awt.Color;
import java.awt.Font;
import java.util.Random;


import javax.swing.*;

/**
 * class Progress in GUI implements Runnable
 * @author Eliran and Maria
 */
public class Progress implements Runnable{

	private JFrame f,tmp;
	private  JPanel progressPanel;
	private int num;
	private Random rand=new Random();
	private int sleep=3000+rand.nextInt(5000);
	
	/**
	 * constructor of class Progress
	 * @param num number of the option (the frame that call the thread)
	 * @param tmp the frame that we want to print a message into
	 */
	public Progress(int num,JFrame tmp)
	{
		this.num=num;
		this.tmp=tmp;
	}


	/**
	 * Run function,activates when thread of Progress started or when it is called directly by object from the class 
	 */
	@Override
	public void run() {
		f=new JFrame("Loading...");
        f.setBounds(480, 200, 400, 400);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        progressPanel=new JPanel();
        progressPanel.setBounds(50, 50, 50, 50);
        progressPanel.setBackground(Color.BLACK);
        progressPanel.setBackground(new Color(24, 24, 23));
        progressPanel.setLayout(null);

        Icon icon = new ImageIcon("Image/loadingGif.gif");
        JLabel lbl=new JLabel(icon);
        lbl.setBounds(75,90,250,250);
        
        JLabel lbl1=new JLabel("Updating database... Please wait");
        lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbl1.setForeground(Color.WHITE);
        lbl1.setBounds(40,30,300,25);
        progressPanel.add(lbl1);
        progressPanel.add(lbl);
        
        progressPanel.setVisible(true);
        f.add(progressPanel);
        f.setVisible(true);
        
		try 
		{
			tmp.setEnabled(false);
			f.setEnabled(false);
			Thread.sleep(sleep);	
			f.setEnabled(true);
			tmp.setEnabled(true);

		} 
		catch (InterruptedException e2) {
			e2.printStackTrace();
		}

		f.dispose();
		
		switch (num)
		{
		case 1:
			JOptionPane.showMessageDialog(f,"You have successfully bought a vehicle");
			break;
		case 2:
			Thread addNewVehicle=new Thread(new CarSuccessfullyAdded());
			addNewVehicle.start();
			break;
		case 3:
			break;
		}
	}
			   
}




