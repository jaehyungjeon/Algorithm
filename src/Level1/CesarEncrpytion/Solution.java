package CesarEncrpytion;

import java.util.*;

/*
 * Question : 
	어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
	예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. 
	"z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 * 
 * 	Solution : 1. 순회하려면 받은 문자 - 시작 문자(a | A) + 밀어낼 숫자(n) % 26 -> 나머지값에 + 시작문자(a | A)
 * 			   2. 공백이면 공백도 추가
 * 			   3. 합쳐서 리턴
 *  
 * */

public class Solution {
	
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(c == ' ') { // 공백
        		answer += c;
        		continue;
        	}
        	
        	if(Character.isUpperCase(c)) { // 대문자
        		answer += (char)((c - 'A' +n) % 26 + 'A');
        	} else if(Character.isLowerCase(c)) { // 소문자
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
