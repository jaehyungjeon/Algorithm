package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

	input			 
	1
	2
	
	output
	3
	
	Solution : 1. 머리를 비우기 위해 쉬운거 풀어봤다..^^
	
*/

public class BaekJoon_2558 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<2; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		
		System.out.println(sum);
	}

}
