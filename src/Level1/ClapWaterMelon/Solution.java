package ClapWaterMelon;

import java.util.*;

/*
 * Question : 
	���̰� n�̰�, "���ڼ��ڼ��ڼ�...."�� ���� ������ �����ϴ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
	������� n�� 4�̸� "���ڼ���"�� �����ϰ� 3�̶�� "���ڼ�"�� �����ϸ� �˴ϴ�.
 * 
 * 	Solution : 1. 2�� ������ ������ 0 : �� / 1 : ��
 *  
 * */

public class Solution {
	
    public String solution(int n) {
        String answer = "";
        
        for(int i=0; i<n; i++) {
        	if(i%2 == 0) {
        		answer += "��";
        	} else {
        		answer += "��";
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 3;
		System.out.println(sol.solution(n));
	}
}
