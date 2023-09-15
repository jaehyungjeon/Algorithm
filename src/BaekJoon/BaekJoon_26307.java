package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : Your best friend, Charlie, participated Taiwan Online Programming Contest (TOPC), 
	which is a preliminary contest of the International Collegiate Programming Contest (ICPC).

	According to the rules, teams are ranked according to the most problems solved. 
	Teams who solve the same number of problems are ranked by the least total time. 
	The total time is the sum of the time consumed for each solved problem. 
	The time consumed for a solved problem is the time elapsed from the beginning of the contest to the submission 
	of the correct answer plus 20 penalty minutes for every rejected code for that problem. There is no time consumed for a problem that is not solved.
	
	Charlie’s team only solved one problem, and the correct answer was submitted at HH:MM AM. Fortunately, 
	they did not submit any rejected code to the judge system. Please write a program to compute the time consumed for the problem solved by Charlie’s team. 
	You may assume that TOPC started at 9:00 AM.

	input			 
	9 0
	
	output
	0
	
	Solution : 1. 9시에서 차감해주면 됨.
	
*/

public class BaekJoon_26307 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Hour = Integer.parseInt(st.nextToken());
		int Minutes = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		sum = ((Hour - 9) * 60) + Minutes;
		
		System.out.println(sum);
	}

}
