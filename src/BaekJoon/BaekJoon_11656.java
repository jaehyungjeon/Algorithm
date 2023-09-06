package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
	Question : 접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.

	baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 
	이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.
	
	문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.
	 	
	input			 
	baekjoon
	
	output
	aekjoon
	baekjoon
	ekjoon
	joon
	kjoon
	n
	on
	oon
	
	Solution : 1. substring으로 하나씩 제거해서 리스트에 넣어준다음 정렬해주면 됨.

*/

public class BaekJoon_11656 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<str.length(); i++) {
			list.add(str.substring(i));
		}
		
		Collections.sort(list);
		
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
