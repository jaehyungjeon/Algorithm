package Level1.DivisorSum;

import java.util.*;

/*
 * Question : 
	���� n�� �Է¹޾� n�� ����� ��� ���� ���� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

 * 
 * 	Solution : 1. ����ϱ� ������ 0�̵Ǵ� �͸� ã�Ƽ� +���ָ� ��.
 *  
 * */

public class Solution {
	
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	if(n%i == 0) {
        		answer+=i;
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 12;
		System.out.println(sol.solution(n));
	}
}
