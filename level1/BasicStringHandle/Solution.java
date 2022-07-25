package BasicStringHandle;

import java.util.*;

/*
 * Question : 
	문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
	예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 * 
 * 	Solution : 1. 정수가 아닐 경우와, 길이가 4, 6이 아니면 return false;
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
				// 숫자가 아니라면
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
