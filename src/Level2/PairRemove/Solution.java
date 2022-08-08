package Level2.PairRemove;

import java.util.*;

/*
 * Question : 
	짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 
	그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 
	문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
	
	예를 들어, 문자열 S = baabaa 라면
	
	b aa baa → bb aa → aa →
	
	의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
 * 
 * 
 * 	Solution : 1. 스택을 이용하는 방법이 제일 빠르다.
 * 			   2. char 형태로 하나씩 스택에 받고 peek 즉, 끝값과 비교하여 일치할 경우에는 stack에서 값을 꺼낸다.
 * 			   3. 반복적으로 수행하여 stack이 비었을 경우는 1로 아닐 경우는 0으로 리턴한다.
 *   
 * */

public class Solution {

	public Stack<Character> stack = new Stack<>();
	
    public int solution(String s) {
        int answer = -1;
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(!stack.isEmpty() && stack.peek() == c) stack.pop(); 
        	else stack.push(c);
        }
        
        answer = stack.isEmpty() ? 1 : 0;
        
        return answer;
    }
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "baabaa";
		System.out.println(sol.solution(s));
	}
}