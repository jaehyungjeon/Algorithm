package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 톰은 마트에서 치즈 1kg 을 사서 집으로 돌아왔습니다.

	그런데 톰이 한눈을 판 사이 제리가 와서 A/B kg 만큼 훔쳐갔습니다.
	
	제리가 치즈를 훔쳐 간 후 톰이 가지고 있는 치즈의 무게는 얼마인가요?

	input			 
	2 7
	
	output
	5 7
	
	Solution : 1. 단순 계산. 
	
*/

public class BaekJoon_16430 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		System.out.print((B-A) + " " + (B));
	}

}
