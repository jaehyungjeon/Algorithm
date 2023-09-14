package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 16진수 수를 입력받아서 10진수로 출력하는 프로그램을 작성하시오.

	input			 
	A
	
	output
	10
	
	Solution : 1. 자바에서 제공하는 16진수 변환을 사용.

*/

public class BaekJoon_1550 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Integer.parseInt(br.readLine(), 16));
	}
}
