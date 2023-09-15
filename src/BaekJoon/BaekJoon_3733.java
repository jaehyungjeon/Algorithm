package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : A group of N persons and the ACM Chief Judge share equally a number of S shares (not necessary all of them). 
	Let x be the number of shares aquired by each person (x must be an integer). The problem is to compute the maximum value of x.

	Write a program that reads pairs of integer numbers from an input text file. 
	Each pair contains the values of 1 ≤ N ≤ 10000 and 1 ≤ S ≤ 109 in that order. 
	The input data are separated freely by white spaces, are correct, and terminate with an end of file. 
	For each pair of numbers the program computes the maximum value of x and prints that value on the standard output from the beginning of a line, 
	as shown in the example below.

	input			 
	1 100
	2 7
	10 9
	10 10
	
	output
	50
	2
	0
	0
	
	Solution : 1. EOF 구현
	
*/

public class BaekJoon_3733 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while((str = br.readLine()) != null && !str.isEmpty()) {
			StringTokenizer st = new StringTokenizer(str);
			BigInteger N = new BigInteger(st.nextToken());
			BigInteger M = new BigInteger(st.nextToken());
			
			System.out.println(M.divide(N.add(new BigInteger("1"))));
		}
	}

}
