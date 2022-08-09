package Level2.BracketChange;

import java.util.*;

/*
 * Question : 
	카카오에 신입 개발자로 입사한 "콘"은 선배 개발자로부터 개발역량 강화를 위해 다른 개발자가 작성한 소스 코드를 분석하여 문제점을 발견하고 수정하라는 업무 과제를 받았습니다. 
	소스를 컴파일하여 로그를 보니 대부분 소스 코드 내 작성된 괄호가 개수는 맞지만 짝이 맞지 않은 형태로 작성되어 오류가 나는 것을 알게 되었습니다.
	수정해야 할 소스 파일이 너무 많아서 고민하던 "콘"은 소스 코드에 작성된 모든 괄호를 뽑아서 올바른 순서대로 배치된 괄호 문자열을 알려주는 프로그램을 다음과 같이 개발하려고 합니다.
	
	용어의 정의
	'(' 와 ')' 로만 이루어진 문자열이 있을 경우, '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열이라고 부릅니다.
	그리고 여기에 '('와 ')'의 괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
	예를 들어, "(()))("와 같은 문자열은 "균형잡힌 괄호 문자열" 이지만 "올바른 괄호 문자열"은 아닙니다.
	반면에 "(())()"와 같은 문자열은 "균형잡힌 괄호 문자열" 이면서 동시에 "올바른 괄호 문자열" 입니다.
	
	'(' 와 ')' 로만 이루어진 문자열 w가 "균형잡힌 괄호 문자열" 이라면 다음과 같은 과정을 통해 "올바른 괄호 문자열"로 변환할 수 있습니다.
	
	1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
	2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
	3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
	  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
	4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
	  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
	  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
	  4-3. ')'를 다시 붙입니다. 
	  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
	  4-5. 생성된 문자열을 반환합니다.
	"균형잡힌 괄호 문자열" p가 매개변수로 주어질 때, 주어진 알고리즘을 수행해 "올바른 괄호 문자열"로 변환한 결과를 return 하도록 solution 함수를 완성해 주세요.
 * 
 * 
 * 	Solution : 1. 인터넷 참고..
 * 			   2. u : 변경해야 할 괄호 , v : 정상적인 괄호 -> u : 완벽한 형태로 만들기 위한 반복 동작 필요
 * 			   3. '(', ')' 마다 각각 left, right++ 시켜준 다음에 갯수가 일치할 경우 해당 인덱스의 다음값을 셋팅하기 위해 return 실시
 * 			   4. 실제 조합은 진행된 index 이전의 변환값 + index 이후의 정상값의 조합을 StringBuilder에 묶어서 결과를 내보낸다.
 * 
 * */

public class Solution {

	public static int index = 0;
	
    public String solution(String p) {
        String answer = "";
        
        if(p.equals("")) return p;
        
        boolean isCorrect = divide(p);
        String u = p.substring(0, index);
        String v = p.substring(index);
        if(isCorrect) return u+solution(v);
        
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v)); // 반복적으로 변환시킬 값
        sb.append(")");
        
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                sb.append(')');
            else
                sb.append('(');
        }

        answer = sb.toString();
        return answer;
    }
    
    public static boolean divide(String p) {
    	boolean isCorrect = true;
    	int left = 0;
    	int right = 0;
    	
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0; i<p.length(); i++) {
    		char c = p.charAt(i);
    		
    		if(c == '(') {
    			stack.add(c);
    			left++;
    		} else {
    			right++;
    			if(!stack.isEmpty() && stack.peek() == '(') {
    				stack.pop();
    			} else {
    				stack.add(c);
    				isCorrect = false;
    			}
    		}
    		
    		if(left == right) {
    			index = i + 1;
    			break;
    		}
    	}
    	
    	return isCorrect;		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String p = "()))((()";
		System.out.println(sol.solution(p));
	}
}