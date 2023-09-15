package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : Congratulations, you adopted some little puppies! Now you just need to go grab food for them at the store. 
	Your vet tells you how many pounds of food each pup will eat before your next trip to the store, 
	so you just need to calculate the total amount of food that you will need to buy. You also know how much food costs per pound, 
	so you just need to make sure that you bring the right amount of money to pay for the food. Write a program that, given the number of puppies, 
	the amount of food per puppy, and the price per pound of food, calculates the amount of money that you will need to bring.

	input			 
	3
	3 2 1
	5 .16 4.54
	3 3.7 3.6
	
	output
	$6.00
	$3.63
	$39.96
	
	Solution : 1. 세 수의 곱.
	
*/

public class BaekJoon_26575 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Double A = Double.parseDouble(st.nextToken());
			Double B = Double.parseDouble(st.nextToken());
			Double C = Double.parseDouble(st.nextToken());
			
			System.out.println("$" + String.format("%.2f", A*B*C));
		}
	}

}
