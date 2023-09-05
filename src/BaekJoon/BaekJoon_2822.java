package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Question : 상근이는 퀴즈쇼의 PD이다. 이 퀴즈쇼의 참가자는 총 8개 문제를 푼다. 
	참가자는 각 문제를 풀고, 그 문제를 풀었을 때 얻는 점수는 문제를 풀기 시작한 시간부터 경과한 시간과 난이도로 결정한다. 
	문제를 풀지 못한 경우에는 0점을 받는다. 참가자의 총 점수는 가장 높은 점수 5개의 합이다. 

	상근이는 잠시 여자친구와 전화 통화를 하느라 참가자의 점수를 계산하지 않고 있었다. 참가자의 8개 문제 점수가 주어졌을 때, 총 점수를 구하는 프로그램을 작성하시오.

	input			 
	20
	30
	50
	48
	33
	66
	0
	64
	
	output
	261
	3 4 5 6 8
	
	Solution : 1. Map과 List를 적절히 활용하여 sort를 도출하면 되는 문제였다.

*/

public class BaekJoon_2822 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=1; i<=8; i++) {
			map.put(Integer.parseInt(br.readLine()), i);
		}
		
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += list.get(i);
		}
		
		sb.append(sum).append("\n");
		
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=4; i>=0; i--) {
			list2.add(map.get(list.get(i)));
		}
		
		Collections.sort(list2);
		for(int t : list2) {
			sb.append(t).append(' ');
		}
		
		System.out.println(sb.toString());
		
	}

}
