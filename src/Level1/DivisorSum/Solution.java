package Level1.DivisorSum;

import java.util.*;

/*
 * Question : 
	정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

 * 
 * 	Solution : 1. 약수니까 나눠서 0이되는 것만 찾아서 +해주면 됨.
 *  
 * */

public class Solution {
	
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	if(n%i == 0) {
        		answer+=i;
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 12;
		System.out.println(sol.solution(n));
	}
}
