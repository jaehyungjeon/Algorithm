package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

	국어 점수가 감소하는 순서로
	국어 점수가 같으면 영어 점수가 증가하는 순서로
	국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
	모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
	 	
	input			 
	12
	Junkyu 50 60 100
	Sangkeun 80 60 50
	Sunyoung 80 70 100
	Soong 50 60 90
	Haebin 50 60 100
	Kangsoo 60 80 100
	Donghyuk 80 60 100
	Sei 70 70 70
	Wonseob 70 70 90
	Sanghyun 70 70 80
	nsj 80 80 80
	Taewhan 50 60 90
	
	output
	Donghyuk
	Sangkeun
	Sunyoung
	nsj
	Wonseob
	Sanghyun
	Sei
	Kangsoo
	Haebin
	Junkyu
	Soong
	Taewhan
	
	Solution : 1. 정렬 문제
			   2. 기준에 따라 sort를 잘 적용해주면 된다.
	
*/

public class BaekJoon_10825 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<String>[] list = new ArrayList[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i] = new ArrayList<String>();
			for(int j=0; j<4; j++) {
				list[i].add(st.nextToken());
			}
		}
		
		Arrays.sort(list, (o1, o2) -> {
			if(o1.get(1).equals(o2.get(1))) {
				if(o1.get(2).equals(o2.get(2))) {
					if(o1.get(3).equals(o2.get(3))) {
						return o1.get(0).compareTo(o2.get(0));
					}
					return Integer.parseInt(o2.get(3)) - Integer.parseInt(o1.get(3));
				}
				return Integer.parseInt(o1.get(2)) - Integer.parseInt(o2.get(2));
			}
			return Integer.parseInt(o2.get(1)) - Integer.parseInt(o1.get(1));
		});
		
		for(List<String> t : list) {
			sb.append(t.get(0)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
