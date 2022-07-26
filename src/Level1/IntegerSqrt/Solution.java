package IntegerSqrt;

import java.util.*;

/*
 * Question : 
	임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
	n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 * 
 * 	Solution : 1. 올림값과 내림값이 같으면 제곱근 true, 아니면 false
 * 			   2. true일 경우 +1 해서 제곱
 * 			   3. 아닐 경우 -1 리턴
 *  
 * */

public class Solution {
	
    public long solution(long n) {
        long answer = 0;
        
        boolean tmp = false;
        if(Math.floor(Math.sqrt(n)) == Math.ceil(Math.sqrt(n))) {
        	tmp = true;
        };
        
        if(tmp) {
        	answer = (long)Math.pow(((long)Math.sqrt(n) + 1), 2);
        } else {
        	answer = -1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	long n = 121;
		System.out.println(sol.solution(n));
	}
}
