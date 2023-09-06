package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 어떤 반에 있는 학생들의 생일이 주어졌을 때, 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.

	input			 
	5
	Mickey 1 10 1991
	Alice 30 12 1990
	Tom 15 8 1993
	Jerry 18 9 1990
	Garfield 20 9 1990
	
	output
	Tom
	Jerry
	
	Solution : 1. 배열로 받아서 정렬을 해주면 될 듯.
			   2. 정렬에 대한 이해문제였다.
*/

public class BaekJoon_5635 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][4];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			arr[i][2] = st.nextToken();
			arr[i][3] = st.nextToken();
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			int o1Year = Integer.parseInt(o1[3]);
			int o2Year = Integer.parseInt(o2[3]);
			
			if(o1Year == o2Year) {
				int o1Month = Integer.parseInt(o1[2]);
				int o2Month = Integer.parseInt(o2[2]);
				
				if(o1Month == o2Month) {
					return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
				}
				
				return o1Month - o2Month;
			}
			
			return o1Year - o2Year;
		});
		
		sb.append(arr[N-1][0]).append("\n").append(arr[0][0]);
		
		System.out.println(sb.toString());
	}

}
