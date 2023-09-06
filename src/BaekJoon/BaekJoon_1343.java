package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
	Question : 민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB

	이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.
	
	폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.

	input			 
	XXXXXX
	----------
	XXXX....XXX.....XX
	
	output
	AAAABB
	----------
	-1
	
	Solution : 1. 중간에 replace 할것도 없이 전체에서 XXXX면 AAAA로 XX면 BB로 치환한 뒤 X가 포함되어있으면 -1을 반환한다.
	
*/

public class BaekJoon_1343 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String rtString = "";
		br.close();
		
		rtString = replace(str);
		
		System.out.println(rtString);
	}
	
	private static String replace(String str) {
		String replaceStr = "";
		String A = "AAAA";
		String B = "BB";
		
		str = str.replaceAll("XXXX", A);
		replaceStr = str.replaceAll("XX", B);
		
		if(replaceStr.contains("X")) return "-1";
		
		return replaceStr;
	}

}
