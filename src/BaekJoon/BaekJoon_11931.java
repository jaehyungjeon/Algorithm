package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
	Question : N개의 수가 주어졌을 때, 이를 내림차순으로 정렬하는 프로그램을 작성하시오.

	input			 
	5
	1
	2
	3
	4
	5
	
	output
	5
	4
	3
	2
	1
	 
	Solution : 1. 음.. 이게 왜 실버..?

*/

public class BaekJoon_11931 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		for(int t : list) {
			sb.append(t).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
