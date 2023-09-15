package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : GEC에는 여러 학교가 있다. 각 학교의 약칭과 정식 명칭은 다음과 같다.

	NLCS: North London Collegiate School
	BHA: Branksome Hall Asia
	KIS: Korea International School
	SJA: St. Johnsbury Academy
	학교 이름을 좋아하는 규빈이는, 학교 이름을 짧게 부르는 것을 싫어하기 때문에, 각 학교의 약칭이 주어졌을 때 정식 명칭을 출력하는 프로그램을 만들기로 하였다.
	
	각 학교의 약칭이 주어졌을 때, 정식 명칭을 출력하는 프로그램을 작성하시오.

	input			 
	NLCS
	
	output
	North London Collegiate School
	
	Solution : 1. 단순 비교 출력
	
*/

public class BaekJoon_27889 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		switch (str) {
			case "NLCS":
				System.out.println("North London Collegiate School");
				break;
			case "BHA" :
				System.out.println("Branksome Hall Asia");
				break;
			case "KIS" :
				System.out.println("Korea International School");
				break;
			case "SJA" :
				System.out.println("St. Johnsbury Academy");
				break;
			default:
				break;
		}
	}

}
