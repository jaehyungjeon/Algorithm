package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

/*
	Question : 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
	정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
	
	input			 
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
	
	output
	3 0 0 1 2 0 0 2
	
	Solution : 
*/

public class NumberCard2 {

	public static int N, M;
	public static int[] arr;
	public static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer sc = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(sc.nextToken());
			
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		M = Integer.parseInt(br.readLine());
		StringTokenizer sb = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			st.append(map.getOrDefault(Integer.parseInt(sb.nextToken()), 0) + " ");
		}
		
		System.out.println(st);
	}
}
