package Level1.Average;

import java.util.*;

/*
 * Question : 
	정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

 * 
 * 	Solution : 1. 전체 합 / 전체 갯수
 *  
 * */

public class Solution {
	
    public double solution(int[] arr) {
        double answer = 0;
        
        for(int i=0; i<arr.length; i++) {
        	answer += arr[i];
        }
        
        answer /= arr.length;
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {1, 2, 3, 4};
		System.out.println(sol.solution(arr));
	}
}
