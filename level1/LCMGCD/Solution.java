package LCMGCD;

import java.util.*;

/*
 * Question : 
	�� ���� �Է¹޾� �� ���� �ִ������� �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� ������. 
	�迭�� �� �տ� �ִ�����, �״��� �ּҰ������ �־� ��ȯ�ϸ� �˴ϴ�. 
	���� ��� �� �� 3, 12�� �ִ������� 3, �ּҰ������ 12�̹Ƿ� solution(3, 12)�� [3, 12]�� ��ȯ�ؾ� �մϴ�.
 * 
 * 
 * Solution : 1. ��������� �ݺ��ؼ� ������ ���� ���� �Ǻ��ϴ� ����
 * 			  2. �ּ� ����� -> ��ü�� ���Ѵ����� �ִ� ������� ���� -> answer[0]�� �ִ� �����
 * 			  3. �ִ� ����� -> ��������� �ݺ��Ͽ� �� ����
 * 
 * */

class Solution {
	
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        answer[0] = gcd(max, min);
        answer[1] = (n*m)/answer[0];
        
        return answer;
    }
    
    public int gcd(int a, int b) {
    	if(b == 0) return a;
    	
    	return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int n = 3;
    	int m = 12;
		System.out.println(sol.solution(n, m));
	}
}