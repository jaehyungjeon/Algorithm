package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 우리나라 고유의 윷놀이는 네 개의 윷짝을 던져서 배(0)와 등(1)이 나오는 숫자를 세어 도, 개, 걸, 윷, 모를 결정한다. 
	네 개 윷짝을 던져서 나온 각 윷짝의 배 혹은 등 정보가 주어질 때 도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 걸(배 세 개, 등 한 개), 윷(배 네 개), 모(등 네 개) 중 어떤 것인지를 결정하는 프로그램을 작성하라.

	input			 
	0 1 0 1
	1 1 1 0
	0 0 1 1
	
	output
	B
	A
	B
	
	Solution : 1. 윷놀이 케이스만 놓고 비교하면 됨.

*/

public class BaekJoon_2490 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while((str = br.readLine()) != null) {
			char[] arr = str.toCharArray();
			int count = 0;
			for(char t : arr) {
				if(t == '0') count++;
			}
			
			switch(count) {
				case 0 :
					System.out.println("E");
					break;
				case 1 :
					System.out.println("A");
					break;
				case 2 :
					System.out.println("B");
					break;
				case 3 :
					System.out.println("C");
					break;
				case 4 : 
					System.out.println("D");
					break;
				default :
					break;
			}
		}
	}
}
