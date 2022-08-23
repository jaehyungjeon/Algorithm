package Level2.NQueens;

import java.util.*;

/*
 * Question : 
	����, ���� ���̰� n�� ���簢�����ε� ü������ �ֽ��ϴ�. ü���� ���� n���� ���� ���θ� ������ �� ������ ��ġ�ϰ� �ͽ��ϴ�.
	���� �� n�� 4�ΰ�� ������ ���� ���� ��ġ�ϸ� n���� ���� ���θ� �ѹ��� ���� �� �� �����ϴ�.
	ü������ ���� ������ ������ ���� n�� �Ű������� �־��� ��, n���� ���� ���ǿ� ���� �ϵ��� ��ġ�� �� �ִ� ����� ���� return�ϴ� solution�Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. ���ؿ��� �ѹ� ���ߴ� ����
 * 			   2. dfs�� ������ �밢���� ��ġ�ϰų�, �����¿쿡 ��ġ���� ���� �� ī��Ʈ�� ������Ű�� ����
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