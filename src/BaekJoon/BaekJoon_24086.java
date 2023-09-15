package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : JOI 君の 1 年前の身長は A cm であった．JOI 君の今の身長は B cm である．

	この 1 年間で JOI 君の身長は伸びたことがわかっている．
	
	JOI 君のこの 1 年間の身長の伸びは何 cm であるか出力せよ．
	
	input			 
	150
	155
	
	output
	5
	
	Solution : 1. 두 수의 차
	
*/

public class BaekJoon_24086 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		
		System.out.println(B-A);
	}

}
