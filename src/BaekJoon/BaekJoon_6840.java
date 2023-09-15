package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	Question : In the story Goldilocks and the Three Bears, each bear had a bowl of porridge to eat while sitting at his/her favourite chair. 
	What the story didn’t tell us is that Goldilocks moved the bowls around on the table, so the bowls were not at the right seats anymore. 
	The bowls can be sorted by weight with the lightest bowl being the Baby Bear’s bowl, 
	the medium bowl being the Mama Bear’s bowl and the heaviest bowl being the Papa Bear’s bowl. 
	Write a program that reads in three weights and prints out the weight of Mama Bear’s bowl. You may assume all weights are positive integers less than 100.

	input			 
	10
	5
	8
	
	output
	8
	
	Solution : 1. 중간값
	
*/

public class BaekJoon_6840 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<3; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(1));
	}

}
