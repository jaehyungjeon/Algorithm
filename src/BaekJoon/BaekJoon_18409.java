package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/*
	Question : 長さ N の英小文字からなる文字列 S が与えられる．S のうち母音字の個数，つまり a，i，u，e，o の個数の総和を求めよ．

	input			 
	8
	joiyosen
	
	output
	4
	
	Solution : 1. 모음이 있으면 카운트 증가
	
*/

public class BaekJoon_18409 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
		br.readLine();
		
		int count = 0;
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			if(list.contains(str.charAt(i))) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
