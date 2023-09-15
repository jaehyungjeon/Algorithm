package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : Napisz program, który odwraca podane słowo trzyliterowe.

	input			 
	abc
	
	output
	cba
	
	Solution : 1. 뒤집어 출력
	
*/

public class BaekJoon_8545 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		for(int i=str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
	}

}
