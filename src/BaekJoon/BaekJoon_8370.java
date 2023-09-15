package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : Byteland Airlines recently extended their aircraft fleet with a new model of a plane. 
	The new acquisition has n1 rows of seats in the business class and n2 rows in the economic class. 
	In the business class each row contains k1 seats, while each row in the economic class has k2 seats.

	Write a program which:
	
	reads information about available seats in the plane,
	calculates the sum of all seats available in that plane,
	writes the result.

	input			 
	2 5 3 20
	
	output
	70
	
	Solution : 1. (n1 * k1) + (n2 * k2) 
	
*/

public class BaekJoon_8370 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken());
		int k1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int k2 = Integer.parseInt(st.nextToken());
		
		System.out.println((n1 * k1) + (n2 * k2));
	}

}
