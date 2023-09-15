package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : You are lost in the museum and keep walking by a giant rock head that says “gum gum for jay jay” each time you walk by. 
	Print out the number of times you have walked by the giant rock head after reading in the data file.

	input			 
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	gum gum for jay jay
	
	output
	11
	
	Solution : 1. 카운트 측정.
	
*/

public class BaekJoon_26489 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			count++;
		}
		
		System.out.println(count);
	}

}
