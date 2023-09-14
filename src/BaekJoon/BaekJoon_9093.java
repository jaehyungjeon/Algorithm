package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	Question : 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

	input			 
	2
	I am happy today
	We want to win the first prize

	output
	I ma yppah yadot
	eW tnaw ot niw eht tsrif ezirp
	
	Solution : 1. 스택을 활용하여 순서를 뒤집어준다.

*/

public class BaekJoon_9093 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			char[] charArr = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<Character>();
			
			for(int j=0; j<charArr.length; j++) {
				char c = charArr[j];
				if(c == ' ') {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(c);
					
					stack.clear();
				} else if(j == charArr.length-1) {
					sb.append(c);
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				} else {
					stack.add(c);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
