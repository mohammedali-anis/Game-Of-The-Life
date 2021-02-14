/*
 * Mohammed Ali Anis
 * pp006
 * 1237412
 * 
 * 
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;
import javax.swing.*;


public class draw extends Uframe 
{
	
	public static void random() 
	{
		
		
		for(int i=0 ; i<a.length ; i++)
		{
			for(int j=0 ; j<a.length ; j++) 
			{
				if(Math.random()<0.4)
				{
				a[i][j].setOpaque(true);
				a[i][j].setBackground(Color.black);
				}
				
			}
			
		}
		
	
	   }
	
	public static void grid() 
	{
		
		
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a.length; j++) 
			{
					a[i][j]= new JLabel();
					a[i][j].setBackground(Color.orange);
					a[i][j].setBorder(border);
					 p1.add(a[i][j]);		
			}
		}		
		
	}
	
	
	

}
