package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : N개의 정수가 주어진다. 이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 같은 정수는 한 번만 출력한다.

	input			 
	10
	1 4 2 3 1 4 2 3 1 2
	
	output
	1 2 3 4
	
	Solution : 1. HashSet으로 중복되는걸 제거해서 담고 List를 Collections를 활용하여 sort 시킨다.

*/

public class BaekJoon_10867 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(N-- > 0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		
		for(int a : list) {
			System.out.print(a + " ");
		}
	}

}
