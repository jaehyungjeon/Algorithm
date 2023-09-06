package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
	Question : 타임머신을 개발하는 정이는 오랜 노력 끝에 타임머신을 개발하는데 성공하였다. 
	미래가 궁금한 정이는 자신이 개발한 타임머신을 이용하여 500년 후의 세계로 여행을 떠나게 되었다. 
	500년 후의 세계에서도 프로그래밍을 하고 싶었던 정이는 백준 사이트에 접속하여 문제를 풀기로 하였다. 
	그러나 미래세계는 A진법을 사용하고 있었고, B진법을 사용하던 정이는 문제를 풀 수가 없었다. 뛰어난 프로그래머였던 정이는 A진법으로 나타낸 숫자를 B진법으로 변환시켜주는 프로그램을 작성하기로 하였다.

	N진법이란, 한 자리에서 숫자를 표현할 때 쓸 수 있는 숫자의 가짓수가 N이라는 뜻이다. 
	예를 들어 N이 17일 때 한 자릿수에서 사용할 수 있는 수는 0, 1, 2, ... , 16으로 총 17가지가 된다.

	input			 
	17 8
	2
	2 16
	
	output
	6 2
	
	Solution : 1. A진법인 수를 Math.pow를 이용해 10진법으로 변환
			   2. 변환된 수를 다시 B진법으로 변환하는데 스택을 이용.
			   3. 스택에는 나머지값들을 넣고 pop을 통해 값들을 하나씩 붙여주면 됨.
	
*/

public class BaekJoon_11576 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int total = 0;
		
		int format1 = Integer.parseInt(st.nextToken());
		int format2 = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		String[] numArr = br.readLine().split(" "); 
		
		for(int i=N-1; i>=0; i--) {
			total += (Math.pow(format1, i) * Integer.parseInt(numArr[(N-1) - i]));
		}
		
		while(total > 0) {
			stack.push(total % format2);
			total /= format2;
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
