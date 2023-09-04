package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.

	두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다. 이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
	
	A의 앞에 아무 알파벳이나 추가한다.
	A의 뒤에 아무 알파벳이나 추가한다.
	이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오. 
	 	
	input			 
	adaabc aababbc
	----------------
	hello xello
	----------------
	abc topabcoder
	
	output
	2
	----------------
	1
	----------------
	0
	
	Solution : 1. 원리는 2개의 숫자가 다를 경우에 값을 증가시켜주는 것으로 생각하면 된다.
			   2. 갱신되는 카운트와 전체 길이 중 최솟값을 찾아 리턴해주면 된다.
*/

public class BaekJoon_1120 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		int length = str1.length();
		int count;
		
		for(int i=0; i<str2.length() - str1.length()+1; i++) {
			count = 0;
			for(int j=0; j<str1.length(); j++){
				if(str1.charAt(j) != str2.charAt(i+j)) {
					count++;
				}
	        }
			
			length = Math.min(length, count);
		}
			
		System.out.println(length);
	}

}
