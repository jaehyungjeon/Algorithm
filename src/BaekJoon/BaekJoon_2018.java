package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 
	이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.

	예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.

	N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

	input			 
	15
	
	output
	4
	
	Solution : 1. 연속된 수의 합.
			   2. 같으면 카운트 증가
			   3. 다르면 sum을 누산해서 같을 경우 카운트 증가. 단, 합계가 N보다 크지 않아아 하므로 크면 break.
	
*/

public class BaekJoon_2018 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int count = 0;
		
		for(int i=1; i<=N; i++) {
			sum = i;
			if(i == N) {
				count++;
			} else {
				for(int j=i+1; j<=N; j++) {
					sum += j;
					if(sum > N) break;
					if(sum == N) count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
