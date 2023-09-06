package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 한상덕은 이번에 중덕 고등학교에 새로 부임한 교장 선생님이다. 교장 선생님으로서 첫 번째 일은 각 반의 수학 시험 성적의 통계를 내는 일이다.

	중덕 고등학교 각 반의 학생들의 수학 시험 성적이 주어졌을 때, 최대 점수, 최소 점수, 점수 차이를 구하는 프로그램을 작성하시오.

	input			 
	2
	5 30 25 76 23 78
	6 25 50 70 99 70 90
	
	output
	Class 1
	Max 78, Min 23, Largest gap 46
	Class 2
	Max 99, Min 25, Largest gap 25
	
	Solution : 1. 하다보니까.. 소스가 길어짐.
			   2. list 배열을 만들어서 작업했다.
			   3. sort의 gap은 따로 배열을 만들어서 넣어주었다.
	
*/

public class BaekJoon_5800 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new ArrayList[N];
		int[] maxArr = new int[N];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			list[i-1] = new ArrayList<Integer>();
			for(int j=0; j<M; j++) {
				int val = Integer.parseInt(st.nextToken());
				list[i-1].add(val);
			}
			
			Collections.sort(list[i-1]);
		}
		
		int idx = 1;
		for(List<Integer> classy : list) {
			sb.append("Class " + idx).append("\n");
			sb.append("Max ").append(classy.get(classy.size()-1)).append(", ");
			sb.append("Min ").append(classy.get(0)).append(", ");
			for(int j=1; j<classy.size(); j++) {
				maxArr[idx-1] = Math.max(maxArr[idx-1], list[idx-1].get(j) - list[idx-1].get(j-1));
			}
			sb.append("Largest gap ").append(maxArr[idx-1]).append("\n");
			idx++;
		}
		
		System.out.println(sb.toString());
	}

}
