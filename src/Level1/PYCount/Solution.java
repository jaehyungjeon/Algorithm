package PYCount;

import java.util.*;

/*
 * Question : 
	대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
	'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
	
	예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
 * 
 * 	Solution : 1. charAt으로 문자열 하나씩 받아 String으로 변환
 * 			   2. p일때와 y일때 카운트 담는다.
 * 			   3. 같으면 true 아니면 false 반환
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
