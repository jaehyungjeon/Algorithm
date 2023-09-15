package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 十進法で 2 桁の整数 N が与えられる．

	N の十の位の数字と一の位の数字が同じである場合は 1 を，そうでない場合は 0 を出力せよ．
	
	input			 
	22
	
	output
	22
	
	Solution : 1. 두 수가 같으면 1 아니면 0
	
*/

public class BaekJoon_27324 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		if(str.charAt(0) == str.charAt(1)) {
			System.out.println(1);
		} else {
			System.out.println(0); 
		}
	}

}
