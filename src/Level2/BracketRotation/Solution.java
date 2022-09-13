package Level2.BracketRotation;

import java.util.*;

/*
 * Question : 
	다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.

	(), [], {} 는 모두 올바른 괄호 문자열입니다.
	만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
	만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
	대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 
	이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 제일 먼저 생각나는 것 -> 스택을 이용한 방식
 * 			   2. 첫번째를 빼서 마지막에다 붙이는 형태
 * 			   3. [{}] 일 경우에도 true가 되는 형태이므로 스택에서 일치하면 pop하는 구조로 실행
 * 
 * */

public class Solution {

	public int solution(String s) {
		int answer = 0;

		for(int i=0; i<s.length(); i++) {
			if(check(s)) answer++;
			s = s.substring(1, s.length()) + s.charAt(0);
		}

		return answer;
	}

	public boolean check(String s) {
		Stack<Character> stack = new Stack<Character>();

		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);

			try {
				switch(c) {
					case '[' :
						stack.push(c);
						break;
					case ']' :
						if(stack.peek() != '[') return false;
						else stack.pop();
						break;
					case '(' :
						stack.push(c);
						break;
					case ')' :
						if(stack.peek() != '(') return false;
						else stack.pop();
						break;
					case '{' :
						stack.push(c);
						break;
					case '}' :
						if(stack.peek() != '{') return false;
						else stack.pop();
						break;
					}
			} catch (Exception e) {
				return false;
			}
		}
		
		return stack.isEmpty() ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "}]()[{";
		System.out.println(sol.solution(s));
	}
}