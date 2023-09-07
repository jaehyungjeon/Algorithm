package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 돌 게임은 두 명이서 즐기는 재밌는 게임이다.

	탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 지게 된다.
	
	두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.

	input			 
	4
	
	output
	SK
	
	Solution : 1. 3부터 빼서 계산해주면 논리상 순서가 다 맞음..
			   2. 간단한 문제.
	
*/

public class BaekJoon_9656 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		while(N > 0) {
			if(N > 3) {
				N-=3;
				count++;
			} else {
				N-=1;
				count++;
			}
		}
		
		if(count % 2 == 0) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}
