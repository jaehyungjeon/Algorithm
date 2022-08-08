package Level2.PairRemove;

import java.util.*;

/*
 * Question : 
	¦���� �����ϱ��, ���ĺ� �ҹ��ڷ� �̷���� ���ڿ��� ������ �����մϴ�. ���� ���ڿ����� ���� ���ĺ��� 2�� �پ� �ִ� ¦�� ã���ϴ�. 
	�״���, �� ���� ������ ��, �յڷ� ���ڿ��� �̾� ���Դϴ�. �� ������ �ݺ��ؼ� ���ڿ��� ��� �����Ѵٸ� ¦���� �����ϱⰡ ����˴ϴ�. 
	���ڿ� S�� �־����� ��, ¦���� �����ϱ⸦ ���������� ������ �� �ִ��� ��ȯ�ϴ� �Լ��� �ϼ��� �ּ���. ���������� ������ �� ������ 1��, �ƴ� ��� 0�� �������ָ� �˴ϴ�.
	
	���� ���, ���ڿ� S = baabaa ���
	
	b aa baa �� bb aa �� aa ��
	
	�� ������ ���ڿ��� ��� ������ �� �����Ƿ� 1�� ��ȯ�մϴ�.
 * 
 * 
 * 	Solution : 1. ������ �̿��ϴ� ����� ���� ������.
 * 			   2. char ���·� �ϳ��� ���ÿ� �ް� peek ��, ������ ���Ͽ� ��ġ�� ��쿡�� stack���� ���� ������.
 * 			   3. �ݺ������� �����Ͽ� stack�� ����� ���� 1�� �ƴ� ���� 0���� �����Ѵ�.
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