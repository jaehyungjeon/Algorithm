package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 홍준은 참 팬이 많다. 이를 본 구사과는 BOJ 슬랙에서 이모티콘을 만들었다.

	선풍기 모양의 이모티콘은 :fan: 이고, 홍준의 이모티콘은 :(홍준의 아이디): 이다. 
	홍준의 아이디가 주어지면 구사과가 만든 이모티콘을 출력하는 프로그램을 작성하여라. 자세한 출력 방식은 입출력 형식을 참고하면 된다.

	input			 
	appa
	
	output
	:fan::fan::fan:
	:fan::appa::fan:
	:fan::fan::fan:
	
	Solution : 1. for를 이용한 반복문 실행.
	
*/

public class BaekJoon_14581 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i == 1 && j == 1) {
					System.out.print(":".concat(str).concat(":"));
				} else {
					System.out.print(":fan:");
				}
			}
			System.out.println();
		}
	}

}
