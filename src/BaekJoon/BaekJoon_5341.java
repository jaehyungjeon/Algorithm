package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : A pyramid of blocks is constructed by first building a base layer of n blocks and then adding n-1 blocks to the next layer. 
	This process is repeated until the top layer only has one block.

	You must calculate the number of blocks needed to construct a pyramid given the size of the base.
	For example, a pyramid that has a base of size 4 will need a total of 10 blocks.

	input			 
	4
	6
	0
	
	output
	10
	21
	
	Solution : 1. n*(n+1) / 2
	
*/

public class BaekJoon_5341 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			else {
				System.out.println(N*(N+1) / 2);
			}
		}
	}

}