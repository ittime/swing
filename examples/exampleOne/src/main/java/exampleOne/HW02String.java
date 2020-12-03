package exampleOne;

/***
 * 
 * *** WHAT THE FACK ****
 * * tray to learn somthing from this code.
 * http://web.mst.edu/~chaman/courses/CS342/Demos/1Demo02LabelButtonTextFieldSlider/1StringTextFieldLabel/HW02String.java
 */

/** Example for two text fields and a label in the frame*/

import java.awt.*;     
import javax.swing.*;  	 
import java.awt.event.*; 
import java.lang.System.*; 

/** This program takes input from JTextField.
 Read input from JTextField, input has last tokens as an integer.
 In the input, find the percentage of occurrence of the string at the 
 selected location (last element) and change all occurrences of the 
 selected string from lowercase (uppercase) to uppercase(lowercase).
 Input: a b c d a b c a b a  4
 Input: A b c d A b c A b A  4
 Percntage Modified = 40.0
 */


public class HW02String extends JApplet implements ActionListener
{
	String str= " ", tokenChanged = " " ;	//String variable
	JLabel label;       	// JLabel variable
	JTextField textField;  	// JTextField variable
	int  freq=0;
	int num=0;
	boolean invalidLocation = false;
	String[] tokens, original,processed;
	String in="", out="";
	boolean debug=false;
	double percentage;
	Container c ;//= getContentPane();       // container variable

	// initialize variables
	public void init()
	{
		c = getContentPane();       
		c.setLayout(new FlowLayout());
		c.add(label=new JLabel("Enter your data and press Enter:" )); 
		textField = new JTextField("a b c d a b c a b a  4", 50) ;		
		textField.addActionListener(this);
		c.add(textField);
	}

   	// process user's action 
   	public void actionPerformed( ActionEvent e)
	{ 
		str = textField.getText();
	 //	textField.setText( " " );  // clear data entry field
		processInput();
	}

	// process the input string
	public void processInput()
	{
		tokens = str.split("\\s+");
		
	if (debug)	for(String st:tokens)
			System.out.println(st);
		
		original = new String[tokens.length];
		processed = new String[tokens.length];
		//	original=Arrays.copyOf(tokens,0);
			System.arraycopy(tokens,0, original,0,tokens.length);
		
		if (debug) for(String st:original)
			System.out.println(st);
		
		try {
		num = Integer.parseInt(tokens[(tokens.length)-1]);
		}
		catch (Exception ex){invalidLocation=true;}
		if (debug)
				System.out.println(num);
		
		if (invalidLocation|(num > (tokens.length-2))) 
			invalidLocation = true; 
		else
		{	
			/*
			if (tokens[num].equals(tokens[num].toLowerCase()) )
				tokenChanged= tokens[num].toUpperCase();
			else tokenChanged= tokens[num].toLowerCase();
			 */
			
		   processToken();
		if (debug) 
			System.out.println(tokenChanged);
			
			String temp=tokens[num];
			
				for (int k=0; k<tokens.length-1;k++)	
					if (tokens[k].equals(temp)) {tokens[k]=tokenChanged;freq++;}
			if (debug)
				System.out.println(tokenChanged);			
					//	original=Arrays.copyOf(tokens,0);
					System.arraycopy(tokens,0, processed,0,tokens.length);
			
		if (debug) for(String st:processed)
			System.out.println(st);	
		
				for (int k=0; k<tokens.length;k++)	
					{
					in += " "+original[k];
					out += " "+processed[k];
					}
		
		if (debug)System.out.println(in);	
		if (debug)System.out.println(out);	
		
		percentage = (double)freq / (tokens.length-1)*100;
		}
		
		//repaint();	// refresh the window
		repaint();

	}
	
	/** change the case of cahracters ii the token: Character bases */
			public void processToken()
			{	tokenChanged="";
				String temp=tokens[num];
				char [] xx= new char[temp.length()];
				if (debug)
					System.out.println(temp);	

				for (int k=0;k<temp.length();k++)
				{	xx[k]=temp.charAt(k);
					if (Character.isUpperCase(temp.charAt(k)))  
					  xx[k]=Character.toLowerCase(xx[k]);  			
					else   
					  xx[k]=Character.toUpperCase(xx[k]);  					
				}	
				tokenChanged= new String(xx);
				if (debug)
					System.out.println(tokenChanged);	
			}
				
	/** Display the results: original, modified, percentage on the screen */
					public void paint(Graphics g)
					{
						super.paint(g);
						if (invalidLocation) 
							g.drawString("\t\t\t\tSelect a valid location", 10,200);
						else
						{
							g.drawString("Original:  "+str,10,100);
							g.drawString("ExtraSpaceReduced:  "+in, 10,115);
							g.drawString("Modified:  "+out, 10,150);
							g.drawString("Modified Tokens:  "+percentage +" percent", 10,200);
						}
					/*Cleanup*/	
						str = "";in =""; out=""; num=0;freq=0; invalidLocation=false; tokenChanged="";
					}

  }

/*
change the case of cahracters ii the token: Character bases 
 public void processToken()
 {	tokenChanged="";
 String temp=tokens[num];
 String [] xx= new String[temp.length()];
 if (debug)
 System.out.println(temp);	
 
 for (int k=0;k<temp.length();k++)
 {	xx[k]=Character.toString(temp.charAt(k));
 if (Character.isUpperCase(temp.charAt(k)))  
 xx[k]=xx[k].toLowerCase();  			
 else   
 xx[k]=xx[k].toUpperCase();  
 tokenChanged+=xx[k];
 }	
 
 if (debug)
 System.out.println(tokenChanged);	
			}

 
 */
