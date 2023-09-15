package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 연세대학교의 영문명은 YONSEI, 슬로건은 Leading the Way to the Future이다.

	이를 출력하는 프로그램을 작성해보도록 하자.

	input			 
	0
	
	output
	YONSEI
	
	Solution : 1. 단순 출력
	
*/

public class BaekJoon_15680 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if(str.equals("0")) {
			System.out.print("YONSEI");	
		} else if(str.equals("1")) {
			System.out.println("Leading the Way to the Future");
		}
		
	}

}
