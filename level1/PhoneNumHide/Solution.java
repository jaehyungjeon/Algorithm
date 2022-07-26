package PhoneNumHide;

import java.util.*;

/*
 * Question : 
	���α׷��ӽ� ������� �������� ��ȣ�� ���� �������� ���� �� ������ ��ȭ��ȣ�� �Ϻθ� �����ϴ�.
	��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, 
	��ȭ��ȣ�� �� 4�ڸ��� ������ ������ ���ڸ� ���� *���� ���� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

 * 
 * 	Solution : 1. char �迭�� ��ȯ�� ������ 4���� ������ �������� *�� ��ȯ���ָ� ��
 * 			   2. return�� �ش� char �迭�� String���� ��ȯ�Ͽ� ���
 *  
 * */

public class Solution {
	
    public String solution(String phone_number) {
        char[] c = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++) {
        	c[i] = '*';
        }
        
        return String.valueOf(c);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String phone_number = "01033324444";
		System.out.println(sol.solution(phone_number));
	}
}
