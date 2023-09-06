package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 상근이는 길을 걷다가 신기한 기계를 발견했다. 기계는 매우 매우 큰 화면과 버튼 하나로 이루어져 있다.

	기계를 발견했을 때, 화면에는 A만 표시되어져 있었다. 버튼을 누르니 글자가 B로 변했다. 
	한 번 더 누르니 BA로 바뀌고, 그 다음에는 BAB, 그리고 BABBA로 바뀌었다. 상근이는 화면의 모든 B는 BA로 바뀌고, A는 B로 바뀐다는 사실을 알게되었다.
	
	버튼을 K번 눌렀을 때, 화면에 A와 B의 개수는 몇 개가 될까?

	input			 
	4
	
	output
	2 3
	 
	Solution : 1. 횟수가 반복될수록 이전값과 더해주는 규칙
			   2. 배열을 구성하여 짝수/홀수로 값을 계속 재배치 해준다.

*/

public class BaekJoon_9625 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[2];
		int[] B = new int[2];
		// N == 0
		A[0] = 1;
		A[1] = 0;
		
		// N == 1
		B[0] = 0;
		B[1] = 1;
		
		if(N == 0) {
			sb.append(A[0]).append(' ').append(B[0]);
		} else if(N == 1) {
			sb.append(A[1]).append(' ').append(B[1]);
		} else {
			for(int i=2; i<=N; i++) {
				// 짝수일 경우
				if(i%2 == 0) {
					A[i%2] = A[i%2] + A[i%2+1];
					B[i%2] = B[i%2] + B[i%2+1];
				} else {
					A[i%2] = A[i%2] + A[i%2-1];
					B[i%2] = B[i%2] + B[i%2-1];
				}
				
				if(i == N) {
					sb.append(A[i%2]).append(' ').append(B[i%2]);
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
