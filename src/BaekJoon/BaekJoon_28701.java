package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 은하는 수업 때 
	$1$부터 
	$N$까지 수의 합과 
	$1$부터 
	$N$까지 수의 세제곱의 합과 관련된 다음 공식을 배웠습니다.
	
	 
	$(1 + 2 + \cdots + N)^2 = 1^3 + 2^3 + \cdots + N^3$ 
	믿을 수 없었던 은하는 직접 코딩을 해서 검증해 보기로 했습니다. 
	$1$부터 
	$N$까지 수의 합과 그 수를 제곱한 수, 또 
	$1$부터 
	$N$까지 수의 세제곱의 합을 차례대로 출력하세요.

	input			 
	5
	
	output
	15
	225
	225
	
	Solution : 1. 2번과 3번은 결과가 같음.
	
*/

public class BaekJoon_28701 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += i;
		}
		
		sb.append(sum).append("\n");
		sb.append((int)Math.pow(sum, 2)).append("\n");
		sb.append((int)Math.pow(sum, 2));
		
		System.out.println(sb.toString());
	}

}
