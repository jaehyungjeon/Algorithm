package Level2.NQueens;

import java.util.*;

/*
 * Question : 
	가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.
	예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.
	체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때, n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 백준에서 한번 접했던 문제
 * 			   2. dfs를 돌려서 대각선에 위치하거나, 상하좌우에 위치하지 않을 때 카운트를 증가시키는 공식
 * 			    
 * */

public class Solution {
	 
	public static boolean[] visited;
	public static int[] move;
	public static int answer;
	
    public int solution(int n) {
        answer = 0;
        visited = new boolean[n];
        move = new int[n];
        
        dfs(0, n);
        
        return answer;
    }
    
    public static void dfs(int depth, int n) {
    	if(n == depth) {
    		answer++;
    		return;
    	}
    	
    	for(int i=0; i<n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			move[depth] = i;
    			if(abs(depth)) dfs(depth+1, n);
    			visited[i] = false;
    		}
    	}
    }
    
    public static boolean abs(int num) {
    	for(int i=0; i<num; i++) {
    		if(move[i] == move[num]) return false;
    		else if(Math.abs(num - i) == Math.abs(move[num] - move[i])) return false;
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}