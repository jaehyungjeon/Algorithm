package HarshadNum;

import java.util.*;

/*
 * Question : 
	���� ���� x�� �ϻ��� ���̷��� x�� �ڸ����� ������ x�� ���������� �մϴ�. 
	���� ��� 18�� �ڸ��� ���� 1+8=9�̰�, 18�� 9�� ������ �������Ƿ� 18�� �ϻ��� ���Դϴ�.
	�ڿ��� x�� �Է¹޾� x�� �ϻ��� ������ �ƴ��� �˻��ϴ� �Լ�, solution�� �ϼ����ּ���.
 * 
 * 	Solution : 1. �ڸ��� ��ŭ for���� ������ ������ ������ Ÿ������ ��ȯ�Ͽ� ���� ���� �Ѱ��� ���Ѵ�.
 * 			   2. ���� �� / �� ���� 0�� �ƴ� ���, false�� return�Ѵ�.
 *  
 * */

public class Solution {
	
    public boolean solution(int x) {
        boolean answer = true;

        int count = 0;
        String str = String.valueOf(x);
        for(int i=0; i<str.length(); i++) {
        	count += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        
        if(x%count != 0) answer = false;
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int x = 919;
		System.out.println(sol.solution(x));
	}
}
