package EvenOdd;

import java.util.*;

/*
 * Question : 
	���� num�� ¦���� ��� "Even"�� ��ȯ�ϰ� Ȧ���� ��� "Odd"�� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.
 * 
 * 	Solution : 1. 3������ ������
 *  
 * */

public class Solution {
	
    public String solution(int num) {
        String answer = "";
        
        answer = (num%2 == 0) ? "Even" : "Odd";
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int num = 3;
		System.out.println(sol.solution(num));
	}
}
