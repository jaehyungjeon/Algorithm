package IntegerSqrt;

import java.util.*;

/*
 * Question : 
	������ ���� ���� n�� ����, n�� � ���� ���� x�� �������� �ƴ��� �Ǵ��Ϸ� �մϴ�.
	n�� ���� ���� x�� �����̶�� x+1�� ������ �����ϰ�, n�� ���� ���� x�� ������ �ƴ϶�� -1�� �����ϴ� �Լ��� �ϼ��ϼ���.
 * 
 * 	Solution : 1. �ø����� �������� ������ ������ true, �ƴϸ� false
 * 			   2. true�� ��� +1 �ؼ� ����
 * 			   3. �ƴ� ��� -1 ����
 *  
 * */

public class Solution {
	
    public long solution(long n) {
        long answer = 0;
        
        boolean tmp = false;
        if(Math.floor(Math.sqrt(n)) == Math.ceil(Math.sqrt(n))) {
        	tmp = true;
        };
        
        if(tmp) {
        	answer = (long)Math.pow(((long)Math.sqrt(n) + 1), 2);
        } else {
        	answer = -1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	long n = 121;
		System.out.println(sol.solution(n));
	}
}
