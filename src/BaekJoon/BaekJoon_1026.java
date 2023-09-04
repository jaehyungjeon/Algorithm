package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
	Question : 옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

	길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
	
	S = A[0] × B[0] + ... + A[N-1] × B[N-1]
	
	S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
	
	S의 최솟값을 출력하는 프로그램을 작성하시오.
	 	
	input			 
	5
	1 1 1 6 0
	2 7 8 3 1
	
	output
	18
	
	Solution : 1. 받은 수를 정렬한 다음에 곱해서 값을 꼐산해주면 될 듯.
			   2. A 배열은 오름차순, B 배열은 내림차순으로 정렬해준 뒤, 두 배열의 곱을 더해줌.
	
*/

public class BaekJoon_1026 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] A = new int[N];
		Integer[] B = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			sum += (A[i] * B[i]);
		}
		
		System.out.println(sum);
	}

}
