package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.

	한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
	
	input			 
	BaekjoonOnlineJudge
	
	output
	BaekjoonOn
	lineJudge
	
	Solution : 1. 10으로 나눈 나머지가 0이 아닐때 담아준다.
	
*/

public class BaekJoon_11721 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		
		for(int i=1; i<=arr.length; i++) {
			if(i % 10 != 0) {
				sb.append(arr[i-1]);
			} else {
				sb.append(arr[i-1]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
