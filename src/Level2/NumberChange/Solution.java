package Level2.NumberChange;

import java.util.*;

/*
 * Question : 
	자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

	x에 n을 더합니다
	x에 2를 곱합니다.
	x에 3을 곱합니다.
	자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 
	이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 * 
 * 
 * 	Solution : 1. Queue와 HashSet을 이용
 * 			   2. x + n / x * 2 / x * y 의 계산로직을 Queue와 HashSet에 담아 중복 제거 및 값 비교
 * 			   3. 큐의 peek값이 y와 같을 경우 리턴
 * 			   4. 강제 리턴되기 전까지 카운트 증가
 * ---------------------------------------------------------------
 *  Solution : 1. DP를 이용 -> 완료 후 해당 지점의 배열의 값을 도출
 * 			   2. 값을 비교하여 각각 최소일 때의 값을 주입
 * 			    
 * */

public class Solution {
	 
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        q.offer(x);
        
        while(!q.isEmpty()) {
        	for(int i=0; i<q.size(); i++) {
        		if(q.peek() == y) {
        			return answer;
        		}
        		method(q.poll(), y, n, q, set);
        	}
        	answer++;
        }
        
        return -1;
//        return dpMethod(x, y, n);
    }
    
    // 1. Queue를 이용한 방식
    public void method(int num, int y, int n, Queue<Integer> q, HashSet<Integer> set) {
    	if(num+n <= y && !set.contains(num+n)) {
    		set.add(num+n);
    		q.offer(num+n);
    	}
    	if(num*2 <= y && !set.contains(num*2)) {
    		set.add(num*2);
    		q.offer(num*2);
    	}
    	if(num*3 <= y && !set.contains(num*3)) {
    		set.add(num*3);
    		q.offer(num*3);
    	}
    }

    // 2. dp를 이용한 방식
    public int dpMethod(int x, int y, int n) {
    	int[] dp = new int[y+1];
    	
        for(int i=x; i<y+1; i++) {
        	if(i != x && dp[i] == 0) {
        		dp[i] = -1;
        		continue;
        	}
        	
        	if(i+n <= y) {
        		dp[i+n] = (dp[i+n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i+n]); 
        	}
        	
        	if(i*2 <= y) {
        		dp[i*2] = (dp[i*2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i*2]); 
        	}
        	
        	if(i*3 <= y) {
        		dp[i*3] = (dp[i*3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i*3]); 
        	}
        }
        
        return dp[y];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int x = 10;
		int y = 40;
		int n = 5;
		System.out.println(sol.solution(x, y, n));
	}
}