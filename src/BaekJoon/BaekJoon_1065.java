package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
	등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
	N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
	 	
	input			 
	110
	
	output
	99
	
	Solution : 1. 두자리수 숫자까지는 한수가 자동으로 적용된다.
			   2. N이 1000보다 작은 숫자이기 때문에 세자리 숫자에서 각 숫자의 합이 같다는 것을 증명하면 된다. 
			   3. 중앙수의 2배가 일의자리와 백의자리 숫자의 합과 동일하면 등차수열이 적용되었다는 것이다.
			   4. 111 이전에는 등차수열이 적용되지 않기 때문에 일의자리까지 계산한 max 값인 99를 시작으로 한다.
*/

public class BaekJoon_1065 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N < 100) {
			System.out.println(N);
		} else {
			int sum = 99;
			
			for(int i=111; i<=N; i++) {
				sum += num(i);
			}
			
			System.out.println(sum);
		}
	}
	
	private static int num(int N) {
		int hundred = N / 100;
		int ten = N % 100 / 10;
		int one = N % 10;
		
		if(ten * 2 == hundred + one) {
			return 1;
		}
		
		return 0;
	}

}
