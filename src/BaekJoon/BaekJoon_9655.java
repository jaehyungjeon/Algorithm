package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 돌 게임은 두 명이서 즐기는 재밌는 게임이다.
	탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
	두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.
	
	input			 
	5
	
	output
	SK
	
	Solution : 1. 3개이상일 경우 3개씩 가져오는걸 먼저 수행한다.
			   2. 카운트를 적립하여 홀수이면 상근이가, 짝수이면 창영이가 승리한다.

*/

public class BaekJoon_9655 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N > 0) {
			if(N-3 > 0) N-=3;
			else {
				N-=1;
			}
			count++;
		}
		
		if(count%2 == 0) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}

}
