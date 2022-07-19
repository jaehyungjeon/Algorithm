package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 총 N개의 문자열로 이루어진 집합 S가 주어진다.
	입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
	
	input			 
	5 11
	baekjoononlinejudge
	startlink
	codeplus
	sundaycoding
	codingsh
	baekjoon
	codeplus
	codeminus
	startlink
	starlink
	sundaycoding
	codingsh
	codinghs
	sondaycoding
	startrink
	icerink
	
	output
	4
		
	Solution : 
		1. 문자열 비교를 진행할 배열 값 하나를 셋팅한다.
		2. 문자열을 받아서 함수를 통해 count 증가
		3. count 출력
		-- 더 좋은 방안이 있을 것 같은데....
*/

public class StringSet {

	public static String[] compare;
	public static int N, M; // 받을 정수 갯수 set
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());
		
		compare = new String[N];
		
		for(int i=0; i<N; i++) {
			compare[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			String a = br.readLine();
			stCount(a);
		}
		
		System.out.println(count);
		
		br.close();
	}

	public static int stCount(String val) {
		for(int i=0; i<N; i++) {
			if(val.equals(compare[i])) {
				count++;
			}
		}
		return count;
	}
}
