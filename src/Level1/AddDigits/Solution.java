package AddDigits;

import java.util.*;

/*
 * Question : 
	자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
	예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 * 
 * 	Solution : 1. 타입변환해서 배열만큼 더해준다.
 *  
 * */

public class Solution {
	
    public int solution(int n) {
        int answer = 0;
        
        String[] arr = String.valueOf(n).split("");
        
        for(int i=0; i<arr.length; i++) {
        	answer += Integer.parseInt(arr[i]);
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 123;
		System.out.println(sol.solution(n));
	}
}
