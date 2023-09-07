package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
	1234567891011121314151617181920212223...
	이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

	input			 
	5
	
	output
	5
	
	Solution : 1. 타임아웃이 0.15초 이므로 String을 붙여서 계산하겠다는 생각은 버리자.
			   2. 10^n만큼 증가시켜서 나머지를 파악하면 쉽게 풀리는 문제였다.
	
*/

public class BaekJoon_1748 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = 10;
		int count = 0;
		int point = 1;
		
		for(int i=1; i<=N; i++) {
			if(i%num == 0) {
				point++;
				num *= 10;
			}
			count += point;
		}
		
		System.out.println(count);
	}

}
