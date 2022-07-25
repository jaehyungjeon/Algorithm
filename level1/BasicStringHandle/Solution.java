package BasicStringHandle;

import java.util.*;

/*
 * Question : 
	���ڿ� s�� ���̰� 4 Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���. 
	���� ��� s�� "a234"�̸� False�� �����ϰ� "1234"��� True�� �����ϸ� �˴ϴ�.
 * 
 * 	Solution : 1. ������ �ƴ� ����, ���̰� 4, 6�� �ƴϸ� return false;
 *  
 * */

public class Solution {

	static boolean isNumeric(String str) {
		boolean result = true;
		if (str == null || str.length() == 0) {
			result = false;
		} else {
			for (int i = 0; i < str.length(); i++) {
				int c = (int) str.charAt(i);
				// ���ڰ� �ƴ϶��
				if (c < 48 || c > 57 || (str.length() != 4 && str.length() != 6)) {
					result = false;
				}
			}
		}
		
		return result;
	}
	
    public boolean solution(String s) {
        boolean answer = true;
        
        answer = isNumeric(s);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "a234";
		System.out.println(sol.solution(s));
	}
}
