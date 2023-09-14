package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

	input			 
	WrongAnswer
	
	output
	wRONGaNSWER
	
	Solution : 1. 'a'를 차감한 값이 양수인지 음수인지를 판별하여 대소문자 변환을 시켜준다.

*/

public class BaekJoon_2744 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c - 'a' < 0) {
				sb.append(String.valueOf(c).toLowerCase());
			} else {
				sb.append(String.valueOf(c).toUpperCase());
			}
		}
		
		System.out.println(sb.toString());
	}

}
