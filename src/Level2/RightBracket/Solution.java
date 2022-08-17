package Level2.RightBracket;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	��ȣ�� �ٸ��� ¦�������ٴ� ���� '(' ���ڷ� �������� �ݵ�� ¦��� ')' ���ڷ� ������ �Ѵٴ� ���Դϴ�. ���� ���

	"()()" �Ǵ� "(())()" �� �ùٸ� ��ȣ�Դϴ�.
	")()(" �Ǵ� "(()(" �� �ùٸ��� ���� ��ȣ�Դϴ�.
	'(' �Ǵ� ')' �θ� �̷���� ���ڿ� s�� �־����� ��, ���ڿ� s�� �ùٸ� ��ȣ�̸� true�� return �ϰ�, �ùٸ��� ���� ��ȣ�̸� false�� return �ϴ� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 
 * 	Solution : 1. left, right�� �̿��ؼ� Ǯ��� �� ��..?
 * 			   2. ù��° -> ')'�� ������ false
 * 			   3. ������ -> '('�� ������ false
 * 			   4. stack���� '('�϶� �����鼭 ī��Ʈ ����, right�϶�, peek�� ���ؼ� �ϳ��� pop
 * 			   5. �ƴ� ��� stack�� add -> �̰� �ʿ䵿������ ��Ȯ�� �ʿ�
 * 			   6. stack���� ���� �� �̾Ƴ����� true, ���������� false ��ȯ
 * 
 * */

public class Solution {

    boolean solution(String s) {
        boolean answer = true;

        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<Character>();
        
        if(s.charAt(0) == ')') return false;
        else if (s.charAt(s.length()-1) == '(') return false;
        else {
        	for(int i=0; i<s.length(); i++) {
        		char c = s.charAt(i);
        		
        		if(c == '(') {
        			stack.add(c);
        			left++;
        		} else {
        			right++;
        			if(!stack.isEmpty() && stack.peek() == '(') {
        				stack.pop();
        			} else {
        				stack.add(c);
        			}
        		}
        		
        		if(stack.isEmpty()) {
        			answer = true;
        		} else {
        			answer = false;
        		}
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "(())()";
		System.out.println(sol.solution(s));
	}
}