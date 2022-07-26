package PYCount;

import java.util.*;

/*
 * Question : 
	�빮�ڿ� �ҹ��ڰ� �����ִ� ���ڿ� s�� �־����ϴ�. s�� 'p'�� ������ 'y'�� ������ ���� ������ True, �ٸ��� False�� return �ϴ� solution�� �ϼ��ϼ���.
	'p', 'y' ��� �ϳ��� ���� ���� �׻� True�� �����մϴ�. ��, ������ ���� �� �빮�ڿ� �ҹ��ڴ� �������� �ʽ��ϴ�.
	
	���� ��� s�� "pPoooyY"�� true�� return�ϰ� "Pyy"��� false�� return�մϴ�.
 * 
 * 	Solution : 1. charAt���� ���ڿ� �ϳ��� �޾� String���� ��ȯ
 * 			   2. p�϶��� y�϶� ī��Ʈ ��´�.
 * 			   3. ������ true �ƴϸ� false ��ȯ
 *  
 * */

public class Solution {

    boolean solution(String s) {
        boolean answer = true;
        
        int pCount = 0;
        int yCount = 0;
        for(int i=0; i<s.length(); i++) {
        	String tmp = String.valueOf(s.charAt(i));
        	
        	if(tmp.toLowerCase().equals("p")) {
        		pCount++;
        	} else if(tmp.toLowerCase().equals("y")) {
        		yCount++;
        	}
        }
        
        if(pCount == yCount) {
        	answer = true;
        } else {
        	answer = false;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "Pyy";
		System.out.println(sol.solution(s));
	}
}
