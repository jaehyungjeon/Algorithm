package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question :To celebrate the Lunar New Year of the Rat, Douglas decides to count the number of rats living in his area. 
	It is impossible for him to find all rats, as they tend to be well hidden. 
	However, on the first day of the new year, Douglas manages to capture n1 rats, and marks each of them with an ear tag before releasing them. 
	On the second day of the new year, Douglas captures n2 rats, and observes that n12 of them had been marked during the first day.

	Douglas is asking for your help to estimate the total number of rats in his area. 
	Looking up in your statistics textbook, you propose using the Chapman estimator N, given by:
	
	N := ⌊(n1 + 1)(n2 + 1)/(n12 + 1) - 1⌋
	
	where ⌊x⌋ is the floor of a real number x, i.e., the closest integer less than or equal to x.

	input			 
	15 18 11
	
	output
	24
	
	Solution : 1. 
	
*/

public class BaekJoon_18301 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n12 = Integer.parseInt(st.nextToken());
		
		System.out.println((int)Math.floor((n1+1)*(n2+1)/(n12+1) - 1));  
	}

}
