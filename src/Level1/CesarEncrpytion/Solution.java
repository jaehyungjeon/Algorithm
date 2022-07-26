package CesarEncrpytion;

import java.util.*;

/*
 * Question : 
	� ������ �� ���ĺ��� ������ �Ÿ���ŭ �о �ٸ� ���ĺ����� �ٲٴ� ��ȣȭ ����� ���� ��ȣ��� �մϴ�. 
	���� ��� "AB"�� 1��ŭ �и� "BC"�� �ǰ�, 3��ŭ �и� "DE"�� �˴ϴ�. 
	"z"�� 1��ŭ �и� "a"�� �˴ϴ�. ���ڿ� s�� �Ÿ� n�� �Է¹޾� s�� n��ŭ �� ��ȣ���� ����� �Լ�, solution�� �ϼ��� ������.
 * 
 * 	Solution : 1. ��ȸ�Ϸ��� ���� ���� - ���� ����(a | A) + �о ����(n) % 26 -> ���������� + ���۹���(a | A)
 * 			   2. �����̸� ���鵵 �߰�
 * 			   3. ���ļ� ����
 *  
 * */

public class Solution {
	
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(c == ' ') { // ����
        		answer += c;
        		continue;
        	}
        	
        	if(Character.isUpperCase(c)) { // �빮��
        		answer += (char)((c - 'A' +n) % 26 + 'A');
        	} else if(Character.isLowerCase(c)) { // �ҹ���
        		answer += (char)((c - 'a' +n) % 26 + 'a');
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "az";
    	int n = 1;
		System.out.println(sol.solution(s, n));
	}
}
