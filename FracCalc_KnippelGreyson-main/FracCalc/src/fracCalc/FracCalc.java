package fracCalc;

import java.util.Scanner;

public class FracCalc
{
	public static void main(String[] args)
	{
		Scanner con  = new Scanner(System.in);
		String line = "";
		
		while(!line.equals("quit"))
		{
		System.out.print("Type in an operation ==> ");	
		line = con.nextLine();
		if (!line.equals("quit"))
		{
			String result = produceAnswer(line);
			System.out.println(result);
		}
	  }
	}
	
	public static String produceAnswer(String input)
	{
		String op1 = "";
		String op = "";
		String op2 = "";
		
		
		int fs = input.indexOf(" ");
		op1 = input.substring(0, fs);
		op = input.substring(fs + 1, fs + 2);
		op2 = input.substring(fs + 3);
		
		String w1;
		String n1;
		String d1;
		
		String w2;
		String n2;
		String d2;
		
		
		if (op1.contains("_") && op1.contains("/"))
		{
			w1 = op1.substring(0, op1.indexOf("_"));
			n1 = op1.substring(op1.indexOf("_") + 1, op1.indexOf("/"));
			d1 = op1.substring(op1.indexOf("/") + 1);
		}
		else if (op1.contains("/"))
		{
			w1 = "0";
			n1 = op1.substring(0, op1.indexOf("/"));
			d1 = op1.substring(op1.indexOf("/") + 1);
		}
		else 
		{
			w1 = op1;
			n1 = "0";
			d1 = "1";
		}

		
		if (op2.contains("_") && op2.contains("/"))
		{
			w2 = op2.substring(0, op2.indexOf("_"));
			n2 = op2.substring(op2.indexOf("_") + 1, op2.indexOf("/"));
			d2 = op2.substring(op2.indexOf("/") + 1);
		}
		else if (op2.contains("/"))
		{
			w2 = "0";
			n2 = op2.substring(0, op2.indexOf("/"));
			d2 = op2.substring(op2.indexOf("/") + 1);
		}
		else 
		{
			w2 = op2;
			n2 = "0";
			d2 = "1";
		}
			
		int iw1 = Integer.parseInt(w1);
		int in1 = Integer.parseInt(n1);
		int id1 = Integer.parseInt(d1);
		
		int iw2 = Integer.parseInt(w2);
		int in2 = Integer.parseInt(n2);
		int id2 = Integer.parseInt(d2);
		
		
		if (iw1 >= 0)
			in1 = (iw1 * id1) + in1;
		else 
			in1 = (iw1 * id1) - in1;
		
		iw1 = 0;
		
		if (iw2 >= 0)
			in2 = (iw2 *id2) + in2;
		
		iw2 = 0;
		
		int cd = id1 * id2;
		
		
		in1 = in1 * id2;
		in2 = in2 * id1;
		id1 = cd;
		id2 = cd;
		 
		int nr = 0;
		int dr = 0;
		
		if (op.equals("+"))
		{
			nr = in1 + in2;
			dr = id1;
		}
		else if (op.equals("-"))
		{
			nr = in1 - in2;
			dr = id1;
		}
		else
		{
			if (op.equals("/"))
			{
				//standard 3 way swap
				int temp = in2;
				in2 = id2;
				id2 = temp;
			}
			
			if (id2 < 0)
			{
				id2 = 0 - id2;
				in2 = 0 - in2;
			}
			
			nr = in1 * in2;
			dr = id1 * id2;
		}
			
		int wr = 0;
	
		if (nr >= 0)
		{
			while (nr >= dr)
			{
				wr += 1;
				nr = nr - dr;
			}
		}
		else	
		{
			while (nr <= -dr)
			{
				wr -= 1;
				nr = nr + dr;
			}
			
			if (wr < 0)
				nr = -nr;
		}
		 
		
		 //This code is for simplifying fractions.
		 
		 for (int i = 2; i <=Math.abs(nr); i++)
		 {
		 	if (nr % i == 0 && dr % i == 0)
		 	{
		 		nr = nr / i;
		 		dr = dr / i;
		 		i = 1;
		 	}
		 }
		 
		 
		//this is the code for showing the right result
		 if (nr == 0)
		 	return wr + "";
		 else if (wr == 0)
		 {
		 	return nr + "/" + dr;
		 }
		 else
		 {
		 	return wr + "_" + nr + "/" + dr;
		 }
		 
	}
}
// TEST CASES: 1/2 - 1/2 = 0		1/2 - 1/4 = 1/4		4/32 + 8/64 = 1/4		3/12 * 1 = 1/4		5/7 / 5/7 = 1		1_1/3 + 13_1/3 = 14_2/3		

//return op2; 

//return "whole:" + iw1 + "numerator:" + in1 + " denominator:" + id1;
