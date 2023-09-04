package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 영문 문장을 입력받아 모음의 개수를 세는 프로그램을 작성하시오. 모음은 'a', 'e', 'i', 'o', 'u'이며 대문자 또는 소문자이다.

	input			 
	How are you today?
	Quite well, thank you, how about yourself?
	I live at number twenty four.
	#

	output
	7
	14
	9
	 
	Solution : 1. 대소문자 구분 없음.
	
*/

public class BaekJoon_1264 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int count = 0;
			String str = br.readLine();
			
			if(str.equals("#")) break;
			
			for(int i=0; i<str.length(); i++) {
				switch (String.valueOf(str.charAt(i)).toLowerCase()) {
				case "a" :
				case "e" :
				case "i" :
				case "o" :
				case "u" :
					count++;
					break;
				default:
					break;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
