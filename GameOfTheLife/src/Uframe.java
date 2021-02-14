/*
 * Mohammed Ali Anis
 * pp006
 * 1237412
 * 
 * 
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.Border;
//import Java.awt.event.ActionEvent;
//import Java.awt.event.ActionListener ;

public class Uframe extends JFrame implements ActionListener
{
	static JPanel p1;
	JPanel p2;
	JButton b1;
	JButton b2;
	static Border border = BorderFactory.createLineBorder(Color.white, 1);
	static JLabel[][] a = new JLabel[30][30] ;
	int pixel_count;
	Scanner enter = new Scanner(System.in);
	

	public static double getRandomIntegerBetweenRange(double min, double max) {
		double x = (int) (Math.random() * ((max - min) + 1)) + min;
		return x;

	}// for getRandomIntegerBetweenRange

	int b[][] = new int[30][30];
	int c[][] = new int[30][30];
		
	
	private int check(int x, int y) {

        int counter = 0;

        for (int i = -1; i <= 1; i++) 
        {
        	for (int j = -1; j <= 1; j++) 
        	{
                if (x + i > 0 && x + i < c.length) 
                {
                    if (y + j > 0 && y + j < c.length) 
                    {
                        if (!(i == 0 && j == 0))
                        {
                            counter = counter + b[x+i][y+j];
                        }
                    }
                }
            }
        }

        return counter;
    }
	
	
	public void see() 
	{
		int logic_value;
		for (int x = 0; x < a.length; x++) 
		{
			for (int y = 0; y < a.length; y++) 
			{
				if (a[x][y].getBackground() == Color.black) 
				{
					logic_value = 1;
					b[x][y]=logic_value;	
				}
				else if(a[x][y].getBackground() != Color.black)
				{
					logic_value = 0;
					b[x][y]=logic_value;
				}

		}
			logic_value=0;
		}
		

		int counter =0 ;

		for (int i = 0; i < b.length; i++) 

		{
			for (int j = 0; j < b.length; j++) 
			{
                  counter = check(i,j);
                  
				if (b[i][j]==1) 
				{
					 if(counter == 1 || counter>=4 ) { c[i][j]=0; }
					 if(counter == 2 || counter==3 ) { c[i][j]=1; }

					 counter=0;
				}
				else if (b[i][j]==0)
				{
					 if(counter == 3 ) { c[i][j]=1; }

					 counter=0;		
				}				
			}
		}

			
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int x = 0; x < a.length; x++) 
		{
			for (int y = 0; y < a.length; y++) 
			{

				if (c[x][y]== 1) 
				{
					a[x][y].setOpaque(true);
					a[x][y].setBackground(Color.black);
					
				}
				if(c[x][y]==0)
				{
					a[x][y].setOpaque(true);
					a[x][y].setBackground(Color.orange);
				}

			}
		}
		
		for (int x = 0; x < a.length; x++) 
		{
			for (int y = 0; y < a.length; y++) 
			{

				c[x][y]=0;

			}
		}
		
	}// for see Methode.

	public Uframe() {

//!!!!!!!!!!!!!!Frame Settings!!!!!!!!!!!!!!!!!!!!
		this.setSize(600, 600);
		this.setTitle("Game of Life - Spiel des Lebens");
		this.setLocation(900, 600);
		this.setAlwaysOnTop(true);
		this.setResizable(true);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

//!!!!!!!!!!!!!!Panel Setting!!!!!!!!!!!!!!!!!!!!

		p1 = new JPanel();
		p2 = new JPanel();
		b1 = new JButton("Next Generation !");
		b2 = new JButton("Generate !");
		p1.setBackground(Color.orange);
		p1.setBounds(0, 0, 600, 500);
		p2.setBounds(0, 501, 600, 100);
		this.add(p1);
		this.add(p2);
		p1.setLayout(new GridLayout(30, 30));
		p2.setLayout(null);
		
		b1.setBounds(335, 510, 130, 40);
		b1.addActionListener(this);
		b1.setForeground(Color.red);
		p2.add(b1);
		
		b2.setBounds(235, 510, 80, 40);
		p2.add(b2);
		b2.addActionListener(this);
		

		draw.grid();

		

	}// For Constructor

@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
			see();
		else if(e.getSource()==b2)
			draw.random();
	}


}// For class
