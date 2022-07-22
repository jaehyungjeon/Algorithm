package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
	Question : 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
	
	input			 
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
	
	output
	2
	baesangwook
	ohhenrie
	
	Solution : 최초 접근은 배열의 수 만큼 데이터를 받아 비교하는 형식으로 접근하려 했으나, 데이터를 셋팅할수록 시간과 메모리 소요가 커짐
			   출력은 후에 받는 수만큼 도출 되어야 하므로 8개의 수만큼 for문 동작
			   값이 일치할 경우, writer에 1을 추가 아닐경우 0을 추가
			   비교를 어떻게 할 것인가에 관한 의문... -> 오름차순으로 정렬한 후 이진탐색으로 범위를 줄여나가면서 찾는 것이 가장 빠름
			   이진 탐색을 통해 일치 할 경우 true, 일치하지 않을 경우 false 반환
			   t/f에 맞추어 writer에 값 write한다.
*/

public class NoListenThat {
	
	public static int N, M;
	public static List<String> map = new ArrayList<String>();
	public static HashSet<String> set = new HashSet<String>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) {
				map.add(tmp);
			}
		}
		Collections.sort(map);
		System.out.println(map.size());
		for(String a : map) {
			System.out.println(a);
		}
	}
}
