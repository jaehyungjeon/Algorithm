package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 화은이는 제3회 SMUPC를 맞이하여 환영의 의미로 "WelcomeToSMUPC"가 반복적으로 적혀 있는 라벨지를 프린트했다. 
	라벨지에는 공백 없이 글자들이 이어져 있고 "WelcomeToSMUPC"의 마지막 글자인 C 이후에는 W부터 다시 "WelcomeToSMUPC"가 반복된다. 
	$N$번째 글자가 있는 곳까지 라벨지를 자르려 할 때, 
	$N$번째에는 어떤 글자가 있을지 구해보자.

	input			 
	2
	
	output
	e
	
	Solution : 1. 조건을 잘 파악하여야 함.
	
*/

public class BaekJoon_29699 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = "WelcomeToSMUPC";
		
		if(N > 14) {
			if(N%14 == 0) {
				N = 14;
			} else {
				N %= 14;
			}
		}
		System.out.println(str.charAt(N-1));
	}

}
