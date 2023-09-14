package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	Question : 7개의 자연수가 주어질 때, 이들 중 홀수인 자연수들을 모두 골라 그 합을 구하고, 고른 홀수들 중 최솟값을 찾는 프로그램을 작성하시오.

	예를 들어, 7개의 자연수 12, 77, 38, 41, 53, 92, 85가 주어지면 이들 중 홀수는 77, 41, 53, 85이므로 그 합은
	
	77 + 41 + 53 + 85 = 256
	
	이 되고,
	
	41 < 53 < 77 < 85
	
	이므로 홀수들 중 최솟값은 41이 된다.

	input			 
	12
	77
	38
	41
	53
	92
	85
	
	output
	256
	41
	
	Solution : 1. 리스트로 정렬하면 쉽다.  

*/

public class BaekJoon_2576 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<7; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value % 2 == 1) list.add(value);
		}
		
		// 오름차순으로 정렬
		Collections.sort(list);
		
		int sum = 0;
		for(int t : list) {
			sum += t;
		}
		
		if(list.isEmpty()) {
			System.out.println(-1);			
		} else {
			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}

}
