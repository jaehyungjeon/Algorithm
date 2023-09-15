package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Your copier broke down last week, and you need to copy a list of numbers for a class project due tomorrow! 
	Luckily, you can use your computer to copy the numbers for you. 
	Given a list of numbers, each on their own line, print out the number, a space, and then another copy of the number.

	input			 
	3
	7
	3
	10

	output
	7 7
	3 3
	10 10
	
	Solution : 1. 값 복사..?
	
*/

public class BaekJoon_26574 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			int val = Integer.parseInt(br.readLine());
			
			sb.append(val).append(' ').append(val).append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
