package Level1.StrangeStringMake;

import java.util.*;

/*
 * Question : 
	문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
	각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 * 
 * 	Solution : 1. 배열로 문자열을 끊어서 저장
 * 			   2. 공백이면 카운트를 재배치 해야하므로 변수하나 선언
 * 			   3. 공백일 경우 empty를 0으로 초기화, 아닐경우 ++
 * 			   4. empty%2=0 이면 짝수 이므로 소문자, 홀수면 대문자 += 리턴
 *  
 * */

public class Solution {
	
    public String solution(String s) {
        String answer = "";
        
        int empty = 0;
        String[] arr = s.split("");
        
        for(String b : arr) {
        	empty = b.contains(" ") ? 0 : empty + 1; // 공백이면 초기화
        	answer += (empty%2 == 0) ? b.toLowerCase() : b.toUpperCase();
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "try hello world";
		System.out.println(sol.solution(s));
	}
}
