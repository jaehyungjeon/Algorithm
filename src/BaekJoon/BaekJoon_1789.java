package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최댓값은 얼마일까?

	input			 
	200
	
	output
	19
	
	Solution : 1. 합계가 S보다 커지는 순간에 for문을 빠져 나온다.
			   2. 이미 후위연산자로 증가가 되었으므로 -1 처리를 해준다.

*/

public class BaekJoon_1789 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		long sum = 0;
		int N = 0;
		
		for(int i=1; ; i++) {
			if(sum > S) break;
			sum += i;
			N++;
		}

		System.out.println(N-1);
	}

}
