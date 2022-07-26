package XIntervalNNum;

import java.util.*;

/*
 * Question : 
	�Լ� solution�� ���� x�� �ڿ��� n�� �Է� �޾�, x���� ������ x�� �����ϴ� ���ڸ� n�� ���ϴ� ����Ʈ�� �����ؾ� �մϴ�. 
	���� ���� ������ ����, ������ �����ϴ� �Լ�, solution�� �ϼ����ּ���.
 * 
 * 	Solution : 1. while�� �����鼭 ++ �Ǵ� ���� x�� �����ִ� ���� �迭�� ����ָ� ��.
 *  
 * */

public class Solution {
	
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        int t = 0;
        while(t < n) {
        	answer[t] = (long)x * (t+1);
        	t++;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int x = 2;
    	int n = 5;
		System.out.println(sol.solution(x, n));
	}
}
