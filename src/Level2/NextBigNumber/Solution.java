package Level2.NextBigNumber;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

	조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
	조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
	조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
	예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
	
	자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 나는 dfs로 풀었다..
 * 			   2. n보다 큰 숫자를 계속해서 더해가면서 1의 갯수가 일치할 경우의 값을 바로 리턴시키면 됨.
 * 			   3. 다른 소스보다 속도적으로 빠를듯..?
 * 
 * 
 * */

public class Solution {

	public static int answer;
	
    public int solution(int n) {
    	answer = 0;
        int cnt = count(n);
        
        dfs(n+1, cnt);
        return answer;
    }

    public static void dfs(int n, int cnt) {
    	int tmp = count(n);
    	
    	if(tmp == cnt) {
    		answer = n;
    	} else {
    		dfs(n+1, cnt);
    	}
    }
    
    public static int count(int n) {
    	int count = 0;
    	String Binary = Integer.toBinaryString(n);
        for(int i=0; i<Binary.length(); i++) {
        	if(Binary.charAt(i) == '1') {
        		count++;
        	}
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 15;
		System.out.println(sol.solution(n));
	}
}