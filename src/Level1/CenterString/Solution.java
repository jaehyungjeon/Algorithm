package Level1.CenterString;

import java.util.*;

/*
 * Question : 
	�ܾ� s�� ��� ���ڸ� ��ȯ�ϴ� �Լ�, solution�� ����� ������. �ܾ��� ���̰� ¦����� ��� �α��ڸ� ��ȯ�ϸ� �˴ϴ�.
 * 
 * 	Solution : 1. Ȧ��, ¦����� substring �ǽ�
 * 
 * */

public class Solution {

    public String solution(String s) {
        String answer = "";
        
        if(s.length()%2 == 1) { // Ȧ��
        	answer = s.substring(s.length()/2, s.length()/2+1);
        } else { // ¦��
        	answer = s.substring(s.length()/2-1, s.length()/2+1);
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "abcde";
		System.out.println(sol.solution(s));
	}
}
