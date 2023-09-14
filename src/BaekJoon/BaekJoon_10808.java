package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.

	input			 
	baekjoon
	
	output
	1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
	
	Solution : 1. 배열로 풀면 간단하게 풀 수 있다.

*/

public class BaekJoon_10808 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		int[] arr = new int[26];
		
		for(char c : charArr) {
			arr[c - 'a']++;
		}
		
		for(int t : arr){
			System.out.print(t + " ");
		}
	}

}
