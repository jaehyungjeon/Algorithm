package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 부산사이버대학교 학생 성택이는 엄마의 의뢰를 받아 주어진 문자열이 현관문 비밀번호에 사용 가능한지 알아내야 한다. 성택이는 공부해야 하므로 우리가 도와주자!

	사용할 수 있는 비밀번호의 규칙은 다음과 같다.
	
	비밀번호는 6자리 이상 9자리 이하여야 한다.
	예를 들어, 123124는 올바른 비밀번호이고, 1202727161은 잘못된 비밀번호이다. 문자열이 주어졌을 때 현관문 비밀번호로 사용할 수 있는지 판단하자.
	
	input			 
	3
	1245125
	asdij
	120318739721
	
	output
	yes
	no
	no
	
	Solution : 1. length 문제

*/

public class BaekJoon_25372 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if(str.length() < 6 || str.length() > 9) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		}
	}

}
