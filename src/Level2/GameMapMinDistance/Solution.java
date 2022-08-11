package Level2.GameMapMinDistance;

import java.util.*;

/*
 * Question : 
	ROR ������ �� ������ ����� �����ϸ�, ��� �� ������ ���� �ı��ϸ� �̱�� �����Դϴ�. ����, �� ���� ��� �� ������ �ִ��� ���� �����ϴ� ���� �����մϴ�.
	���ݺ��� ����� �� ���� ������ �Ǿ� ������ �����Ϸ��� �մϴ�. ������ 5 x 5 ũ���� �ʿ�, ����� ĳ���Ͱ� (��: 1, ��: 1) ��ġ�� �ְ�, ��� �� ������ (��: 5, ��: 5) ��ġ�� �ִ� ����� �����Դϴ�.
	
	�� �׸����� ������ �κ��� ������ �����־� �� �� ���� ���̸�, ��� �κ��� �� �� �ִ� ���Դϴ�. ĳ���Ͱ� ������ ���� ��, ��, ��, �� �������� �� ĭ�� �̵��ϸ�, ���� ���� ��� ���� �� �� �����ϴ�.
	�Ʒ� ���ô� ĳ���Ͱ� ��� �� �������� ���� �� ���� ����� ��Ÿ���� �ֽ��ϴ�.
	
	ù ��° ����� 11���� ĭ�� ������ ��� �� ������ �����߽��ϴ�.
	�� ��° ����� 15���� ĭ�� ������ ����� ������ �����߽��ϴ�.
	
	�� ���ÿ����� ù ��° ������� �� ������ ����� ������ �����ϴ� ����� �����Ƿ�, �� ����� ��� �� �������� ���� ���� ���� ����Դϴ�.
	����, ��� ���� �ڽ��� �� ���� ������ ���� �����ξ��ٸ� ��� �� ������ �������� ���� ���� �ֽ��ϴ�. ���� ���, ������ ���� ��쿡 ����� ĳ���ʹ� ��� �� ������ ������ �� �����ϴ�.
	
	���� ���� ���� maps�� �Ű������� �־��� ��, ĳ���Ͱ� ��� �� ������ �����ϱ� ���ؼ� �������� �ϴ� ĭ�� ������ �ּڰ��� return �ϵ��� solution �Լ��� �ϼ����ּ���. 
	��, ��� �� ������ ������ �� ���� ���� -1�� return ���ּ���.
 * 
 * 	output : 11
 * 
 * 	Solution : 1. BFS�� �̿��� �ִܰŸ� ���ϱ� ���� 
 * 
 * */

public class Solution {

	public static int[][] p;
	public static List<Integer> list = new ArrayList<Integer>();
	public static int[][] visited;

	public static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
	
    public int solution(int[][] maps) {
        int answer = 0;
        
        p = maps;
        visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        
        bfs(visited);
        
        answer = visited[maps.length - 1][maps[0].length - 1];
        
        if(answer == 0) {
        	return -1;
        }
        
        return answer;
    }
     
    public static int bfs(int[][] visited) {
    	Queue<int[]> q = new ArrayDeque<int[]>();
    	q.offer(new int[] {0, 0});
    	
    	int count = 0;
    	while(!q.isEmpty()) {
    		int[] curr = q.poll();
    		int r = curr[0];
    		int c = curr[1];
    		
    		for(int[] d : dir) {
    			int nr = r+d[0];
    			int nc = c+d[1];
    			
    			if(nr >= 0 && nr < p.length && nc >= 0 && nc < p[0].length && visited[nr][nc] == 0 && p[nr][nc] == 1) {
    				visited[nr][nc] = visited[r][c] + 1;
    				
    				q.add(new int[] {nr, nc});
    			}
    		}
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(sol.solution(maps));
	}
}