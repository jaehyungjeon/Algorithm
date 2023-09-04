package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 체스판은 8×8크기이고, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있다. 가장 왼쪽 위칸 (0,0)은 하얀색이다. 
	체스판의 상태가 주어졌을 때, 하얀 칸 위에 말이 몇 개 있는지 출력하는 프로그램을 작성하시오. 
	 	
	input			 
	.F.F...F
	F...F.F.
	...F.F.F
	F.F...F.
	.F...F..
	F...F.F.
	.F.F.F.F
	..FF..F.
	
	output
	1
	
	Solution : 1. 체스판은 행과 행사이에 교차로 배정되어 있다는 사실을 인지하여야 한다.
			   2. 원리는 간단하게 체스판의 행을 홀/짝일때 배열의 값을 비교해주면 되는 문제였다.
*/

public class BaekJoon_1100 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean check = true;
		int count = 0;
		
		for(int i=0; i<8; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if(check && j%2 == 0 && c == 'F') {
					count++;
				}
				
				if(!check && j%2 == 1 && c == 'F') {
					count++;
				}
			}
			check = !check;
		}
		
		System.out.println(count);
	}

}
