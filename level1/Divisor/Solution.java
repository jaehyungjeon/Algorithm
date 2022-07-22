package Divisor;

import java.util.HashMap;
import java.util.Map;

/*
 * Question : 
	두 정수 left와 right가 매개변수로 주어집니다. 
	left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. 
 * 
 * */

public class Solution {

	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
        	for(int j=1; j<=i; j++) {
        		int num = i%j;
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int left = 13;
    	int right = 17;
		System.out.println(sol.solution(left, right));
	}
}
