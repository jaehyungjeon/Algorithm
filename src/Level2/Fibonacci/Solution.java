package Level2.Fibonacci;

import java.util.*;

/*
 * Question : 
	피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

	예를들어
	
	F(2) = F(0) + F(1) = 0 + 1 = 1
	F(3) = F(1) + F(2) = 1 + 1 = 2
	F(4) = F(2) + F(3) = 1 + 2 = 3
	F(5) = F(3) + F(4) = 2 + 3 = 5
	와 같이 이어집니다.
	
	2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 * 
 *  output : 2
 * 
 * 	Solution : 1. 배열로 문제풀이
 * 			   2. 재귀로 풀었을 경우 타임 에러
 * 			   3. for문 돌리면서 해당 위치에 나머지값을 넣어준다. 
 * 
 * */

public class Solution {

    public int solution(int n) {
        int[] answer = new int[n + 1];
        
        for(int i=0; i<=n; i++) {
        	if(i==0) answer[i] = 0;
        	else if(i==1) answer[i] = 1;
        	else {
        		int sum = answer[i-2] + answer[i-1];
        		answer[i] = sum % 1234567;
        	}
        }
        
        return answer[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 5;
		System.out.println(sol.solution(n));
	}
}