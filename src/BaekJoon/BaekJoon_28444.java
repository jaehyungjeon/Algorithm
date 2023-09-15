package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : HI-ARC 학회는 일상 속의 문장들을 수식으로 표현하는 것을 즐기는 특이한 문화를 가지고 있다.

	HI-ARC 수식은 HI-ARC 학회에서 최근에 개발한 독특한 수식으로, 아래와 같은 규칙으로 계산한다.
	
	 
	$H$와 
	$I$의 곱이 첫 번째 항이다.
	 
	$A$와 
	$R$과 
	$C$의 곱이 두 번째 항이다.
	결과값은 첫 번째 항에서 두 번째 항을 뺀 값이다.
	각각의 문자에 대응되는 숫자가 입력될 때, 결과값을 출력하자!
	
	input			 
	4 6 1 2 3
	
	output
	18
	
	Solution : 1. 곱의 차
	
*/

public class BaekJoon_28444 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int I = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println((H*I) - (A*R*C));
	}

}
