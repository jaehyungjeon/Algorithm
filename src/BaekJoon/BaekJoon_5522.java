package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : JOI군은 카드 게임을 하고 있다. 이 카드 게임은 5회의 게임으로 진행되며, 그 총점으로 승부를 하는 게임이다.

	JOI군의 각 게임의 득점을 나타내는 정수가 주어졌을 때, JOI군의 총점을 구하는 프로그램을 작성하라.
	
	input
	1
	2
	3
	4
	5
	
	output
	15
	
	Solution : 1. 

*/

public class BaekJoon_5522 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		
		System.out.println(sum);
	}

}
