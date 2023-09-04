package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 첫째 줄에는 별 N개, 둘째 줄에는 별 N-1개, ..., N번째 줄에는 별 1개를 찍는 문제

	input			 
	5

	output
	*****
	****
	***
	**
	*
	 
	Solution : 1. 그냥 별찍기 문제
	
*/

public class BaekJoon_2440 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				sb.append('*');
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
