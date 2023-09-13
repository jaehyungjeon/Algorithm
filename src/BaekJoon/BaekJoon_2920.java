package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

	1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
	
	연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.

	input			 
	1 2 3 4 5 6 7 8
	
	output
	ascending
	
	Solution : 1. 케이스별 분리만 해주면 됨.
	
*/

public class BaekJoon_2920 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = arr[0];
		if(start == 1) { // ascending 판정
			boolean ascending = true;
			for(int i=1; i<=8; i++) {
				if(arr[i-1] != i) ascending = false;
			}
			
			if(ascending) {
				System.out.println("ascending");
			} else {
				System.out.println("mixed");
			}
		} else if(start == 8) {
			boolean descending = true;
			for(int i=8; i>=1; i--) {
				if(arr[8-i] != i) descending = false;
			}
			
			if(descending) {
				System.out.println("descending");
			} else {
				System.out.println("mixed");
			}
		} else {
			System.out.println("mixed");
		}
	}

}