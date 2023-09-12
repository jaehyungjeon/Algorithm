package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
	Question : 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.

	먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
	
	알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
	문자열의 시작과 끝은 공백이 아니다.
	'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
	태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 
	단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
	
	input			 
	baekjoon online judge
	--------------------------
	<open>tag<close>
	
	output
	noojkeab enilno egduj
	--------------------------
	<open>gat<close>
	
	Solution : 1. 괄호 안의 데이터의 순서가 변경되면 안되므로 큐를 이용하자..
			   2. 예외케이스를 찾아서 처리하느라 시간이 좀 걸림.
			   3. 단순한 생각으로 큐, 스택을 이용하여 괄호가 아닌 문자에 대해서는 스택에 담아 reverse 처리하였음.

*/

public class BaekJoon_17413 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		Queue<Character> queue = new LinkedList<Character>();
		
		for(char c : arr) {
			queue.add(c);
		}
		
		while(!queue.isEmpty()) {
			Character c = queue.peek();
			if(c == '<') {
				sb.append(queue.poll());
				
				if(!queue.isEmpty()) {
					while(true) {
						Character next = queue.peek();
						sb.append(queue.poll());
						if(next == null || next == '>') break;
					}
				}
			} else if(c == ' ') {
				sb.append(queue.poll());
			} else {
				Stack<Character> stack = new Stack<Character>();
				
				while(true) {
					Character next = queue.peek();
					if (next == null || next == ' ' || next == '<') break;
					else {
						stack.add(queue.poll());
					}
					
				}
				
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
