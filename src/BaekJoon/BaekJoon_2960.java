package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.

	이 알고리즘은 다음과 같다.
	
	2부터 N까지 모든 정수를 적는다.
	아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
	P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
	아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
	N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
	 	
	input			 
	7 3
	
	output
	6
	
	Solution : 1. boolean을 활용해 해당 카운트가 일치할 경우 값 반환

*/

public class BaekJoon_2960 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] primeNum = new boolean[N+1];

		int count = 0;

		for(int i = 2; i <= N; i++) {
			primeNum[i] = true;
		}

		for(int i = 2; i <= N; i++) {
			for(int j = i; j <= N; j += i) {
				if(!primeNum[j])
					continue;
				primeNum[j] = false;
				count++;
				if(count == K) {
					System.out.println(j);
					
					System.exit(0);
				}
			}
		}
	}

}
