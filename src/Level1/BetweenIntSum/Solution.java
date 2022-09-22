package Level1.BetweenIntSum;

import java.util.*;

/*
 * Question : 
	�� ���� a, b�� �־����� �� a�� b ���̿� ���� ��� ������ ���� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.
	���� ��� a = 3, b = 5�� ���, 3 + 4 + 5 = 12�̹Ƿ� 12�� �����մϴ�.
 * 
 * 	Solution : 1. min, max�� �� ���Ѵ�.
 * 			   2. �߰� ������ ���������� �� ������ ������ Ǯ�̸� �־���.. �ٸ� ������� �����غ� �� �ְڴ�.
 *  
 * */

public class Solution {

    public long solution(int a, int b) {
        long answer = 0;
        
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        
        for(int i=start; i<=end; i++) {
        	answer += i;
        }
        
        return answer;
        
//        return sumAtoB(start, end); // ���������� ������ �ҽ�..
    }
    
    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int a = 3;
    	int b = 5;
		System.out.println(sol.solution(a, b));
	}
}
