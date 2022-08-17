package Level2.RightBracket;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

	"()()" 또는 "(())()" 는 올바른 괄호입니다.
	")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
	'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 * 
 * 
 * 	Solution : 1. left, right를 이용해서 풀어야 할 듯..?
 * 			   2. 첫번째 -> ')'면 무조건 false
 * 			   3. 마지막 -> '('면 무조건 false
 * 			   4. stack으로 '('일때 넣으면서 카운트 증가, right일때, peek값 비교해서 하나씩 pop
 * 			   5. 아닐 경우 stack에 add -> 이건 필요동작인지 재확인 필요
 * 			   6. stack에서 값을 다 뽑아냈으면 true, 남아있으면 false 반환
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