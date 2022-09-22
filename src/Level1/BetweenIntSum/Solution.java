package Level1.BetweenIntSum;

import java.util.*;

/*
 * Question : 
	두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
	예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 * 
 * 	Solution : 1. min, max로 합 구한다.
 * 			   2. 추가 예제로 등차수열의 합 공식을 적용한 풀이를 넣었다.. 다른 방법으로 생각해볼 수 있겠다.
 *  
 * */

public class Solution {

    public long solution(int a, int b) {
        long answer = 0;
        
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        
        for(int i=start; i<=end; i++) {
        	answer += i;
        }
        
        return answer;
        
//        return sumAtoB(start, end); // 등차수열을 적용한 소스..
    }
    
    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int a = 3;
    	int b = 5;
		System.out.println(sol.solution(a, b));
	}
}
