package LCMGCD;

import java.util.*;

/*
 * Question : 
	두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
	배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
	예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 * 
 * 
 * Solution : 1. 재귀적으로 반복해서 나누어 지는 수를 판별하는 문제
 * 			  2. 최소 공배수 -> 전체를 곱한다음에 최대 공약수로 나눔 -> answer[0]이 최대 공약수
 * 			  3. 최대 공약수 -> 재귀적으로 반복하여 값 리턴
 * 
 * */

class Solution {
	
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        answer[0] = gcd(max, min);
        answer[1] = (n*m)/answer[0];
        
        return answer;
    }
    
    public int gcd(int a, int b) {
    	if(b == 0) return a;
    	
    	return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int n = 3;
    	int m = 12;
		System.out.println(sol.solution(n, m));
	}
}