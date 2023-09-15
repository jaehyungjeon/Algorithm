package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : There are five ways to score points in american professional football:

	Touchdown - 6 points
	Field Goal - 3 points
	Safety - 2 points
	After touchdown
	1 point (Field Goal or Safety) - Typically called the “Point after”
	2 points (touchdown) - Typically called the “Two-point conversion”
	(https://operations.nfl.com/the-rules/nfl-video-rulebook/scoring-plays/)
	
	Given the box score values for two competing teams, calculate the point total for each team.

	input			 
1 3 0 0 1
3 1 1 1 1
	
	output
	17 26
	
	Solution : 1. 합계 계산
	
*/

public class BaekJoon_24736 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<2; t++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<5; i++) {
				int val = Integer.parseInt(st.nextToken());
				if(i == 0) {
					sum += val * 6;
				} else if(i == 1) {
					sum += val * 3;
				} else if(i == 2) {
					sum += val * 2;
				} else if(i == 3) {
					sum += val; 
				} else if(i == 4) {
					sum += val * 2;
				}
			}
			sb.append(sum).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
