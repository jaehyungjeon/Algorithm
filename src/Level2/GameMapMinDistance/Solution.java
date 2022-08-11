package Level2.GameMapMinDistance;

import java.util.*;

/*
 * Question : 
	ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
	지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
	
	위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다.
	아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
	
	첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
	두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
	
	위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로, 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.
	만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
	
	게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 
	단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 * 
 * 	output : 11
 * 
 * 	Solution : 1. BFS를 이용한 최단거리 구하기 문제 
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