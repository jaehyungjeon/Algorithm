package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

	input			 
	10
	
	output
	2
	
	Solution : 1. 숫자를 5로 나눈것의 몫을 계속해서 합산하는 규칙을 가지고 있다.
			   2. N이 1이 되는 순간 while문을 나온다.

*/
public class BaekJoon_1676 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N >= 5){
			count += N / 5;
			N /= 5;
		}
		
		System.out.println(count);
	}
}
