package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.

	어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다. 그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.
	
	사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
	
	각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오. 
	 	
	input			 
	7
	6 1 1 1 2 0 0
	
	output
	6 2 3 4 7 5 1
	
	Solution : 1. 최초로 0을 만나는 순간에 가장 앞으로 위치하게 된다.
			   2. 마지막 순서부터 차례대로 들어오면서 해당 list의 위치에 값을 꽂아넣으면 된다.
			   3. 마지막 반환은 print 수가 많아질수록 시간이 늘어나므로 StringBuilder에 담았다.
	
*/

public class BaekJoon_1138 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		List<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N; i>0; i--) {
			list.add(arr[i], i);
		}
		
		for(int t : list) {
			sb.append(t).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
