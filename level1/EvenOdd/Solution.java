package EvenOdd;

import java.util.*;

/*
 * Question : 
	정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
 * 
 * 	Solution : 1. 3항으로 끝내기
 *  
 * */

public class Solution {
	
    public String solution(int num) {
        String answer = "";
        
        answer = (num%2 == 0) ? "Even" : "Odd";
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int num = 3;
		System.out.println(sol.solution(num));
	}
}
