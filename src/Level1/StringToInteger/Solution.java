package Level1.StringToInteger;

import java.util.*;

/*
 * Question : 
	���ڿ� s�� ���ڷ� ��ȯ�� ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ��ϼ���.
 * 
 * 	Solution : 1. parsing
 *  
 * */

public class Solution {
	
    public int solution(String s) {
        return Integer.parseInt(s);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "1234";
		System.out.println(sol.solution(s));
	}
}
