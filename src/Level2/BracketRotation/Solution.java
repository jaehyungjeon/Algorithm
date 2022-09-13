package Level2.BracketRotation;

import java.util.*;

/*
 * Question : 
	���� ��Ģ�� ��Ű�� ���ڿ��� �ùٸ� ��ȣ ���ڿ��̶�� �����մϴ�.

	(), [], {} �� ��� �ùٸ� ��ȣ ���ڿ��Դϴ�.
	���� A�� �ùٸ� ��ȣ ���ڿ��̶��, (A), [A], {A} �� �ùٸ� ��ȣ ���ڿ��Դϴ�. ���� ���, [] �� �ùٸ� ��ȣ ���ڿ��̹Ƿ�, ([]) �� �ùٸ� ��ȣ ���ڿ��Դϴ�.
	���� A, B�� �ùٸ� ��ȣ ���ڿ��̶��, AB �� �ùٸ� ��ȣ ���ڿ��Դϴ�. ���� ���, {} �� ([]) �� �ùٸ� ��ȣ ���ڿ��̹Ƿ�, {}([]) �� �ùٸ� ��ȣ ���ڿ��Դϴ�.
	���ȣ, �߰�ȣ, �׸��� �Ұ�ȣ�� �̷���� ���ڿ� s�� �Ű������� �־����ϴ�. 
	�� s�� �������� x (0 �� x < (s�� ����)) ĭ��ŭ ȸ�������� �� s�� �ùٸ� ��ȣ ���ڿ��� �ǰ� �ϴ� x�� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. ���� ���� �������� �� -> ������ �̿��� ���
 * 			   2. ù��°�� ���� ���������� ���̴� ����
 * 			   3. [{}] �� ��쿡�� true�� �Ǵ� �����̹Ƿ� ���ÿ��� ��ġ�ϸ� pop�ϴ� ������ ����
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