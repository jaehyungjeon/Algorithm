package Level1.StringToInteger;

import java.util.*;

/*
 * Question : 
	문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.
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
