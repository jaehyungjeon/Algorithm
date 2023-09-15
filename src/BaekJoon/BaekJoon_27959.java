package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 밤고는 
	$100$원 동전을 
	$N$개 갖고 있고, 그 돈으로 가격이 
	$M$원인 초코바를 사 먹으려고 한다. 밤고는 갖고 있는 돈으로 초코바를 사 먹을 수 있는지 알고 싶어 한다.
	
	밤고가 가진 돈이 초코바의 가격 이상이면 밤고는 초코바를 살 수 있다. 밤고가 가진 돈이 초코바를 사기에 충분한지 판단해주자.

	input			 
	30 300
	
	output
	Yes
	
	Solution : 1. N * 100 >= M
	
*/

public class BaekJoon_27959 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N*100 >= M) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
