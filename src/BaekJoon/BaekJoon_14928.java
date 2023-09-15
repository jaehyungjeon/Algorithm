package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 제연이는 그의 생일(2000년 3월 3일)을 기념해 자신이 가장 좋아하는 수를 20000303으로 나눈 나머지를 구해 그 수만큼 잠을 자기로 했다. 제연이가 얼마나 잠을 잘 수 있을지 구하자.

	input			 
	20000303200003032000030320000303200003032000030320000303200003032000030320000303
	
	output
	0
	
	Solution : 1. 수의 규칙을 이용하여 해결.
	
*/

public class BaekJoon_14928 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		long remainder = 0;
		for(int i=0; i<num.length(); i++) {
			remainder = (remainder * 10 + (Character.getNumericValue(num.charAt(i)))) % 20000303;
		}
		
		System.out.println(remainder);
	}

}
