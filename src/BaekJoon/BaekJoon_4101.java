package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 두 양의 정수가 주어졌을 때, 첫 번째 수가 두 번째 수보다 큰지 구하는 프로그램을 작성하시오.

	input			 
	1 19
	4 4
	23 14
	0 0
	
	output
	No
	No
	Yes
	
	Solution : 1. 비교만 해주면 됨.

*/

public class BaekJoon_4101 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			else if(N > M) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

}
