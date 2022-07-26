package XIntervalNNum;

import java.util.*;

/*
 * Question : 
	함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
	다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 * 
 * 	Solution : 1. while문 돌리면서 ++ 되는 수와 x를 곱해주는 것을 배열에 담아주면 됨.
 *  
 * */

public class Solution {
	
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        int t = 0;
        while(t < n) {
        	answer[t] = (long)x * (t+1);
        	t++;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int x = 2;
    	int n = 5;
		System.out.println(sol.solution(x, n));
	}
}
