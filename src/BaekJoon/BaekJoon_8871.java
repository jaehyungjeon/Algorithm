package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Wyobraźmy sobie przez chwilę, że w tym roku konkurs SKI'10 składa się z n punktowanych rund i jednej rundy próbnej. 
	Ile zgodnie z regulaminem może się pojawić zadań w czasie całych zawodów?

	input			 
	5
	
	output
	12 18
	
	Solution : 1. (N+1) * 2 || (N+1) * 3
	
*/

public class BaekJoon_8871 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) + 1;
		
		System.out.println(N*2 + " " + N*3);
	}

}
