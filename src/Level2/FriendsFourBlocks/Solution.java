package Level2.FriendsFourBlocks;

import java.util.*;

/*
 * Question : 
	블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
	같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.
	
	board map
	만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다. 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
	
	board map
	
	블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
	
	board map
	
	만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.
	board map
	
	위 초기 배치를 문자로 표시하면 아래와 같다.
	
	TTTANT
	RRFACC
	RRRFCC
	TRRRAA
	TTMMMF
	TMMTTJ                                     
	각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다
	
	입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.
 * 
 * 
 * 	Solution : 1. 인터넷 참고..
 * 			   2. 접근법은 2x2인 것을 먼저 찾음 -> check Method
 * 			   3. 지우면서 count 증가 -> remove Method
 * 			   4. 4각 블럭일 경우에 -> 경로 visited = true로 변경
 * 			   5. 있을때 까지 while문 동작 -> flag값
 * 
 * 
 * */

public class Solution {

	public static boolean visited[][];
	
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        
        for(int i=0; i<m; i++) {
        	map[i] = board[i].toCharArray();
        }
        
        boolean flag = true;
        while(flag) {
        	visited = new boolean[m][n];
        	flag = false;
        	for(int i=0; i<m-1; i++) {
        		for(int j=0; j<n-1; j++) {
        			if(map[i][j] == '#') continue;
        			if(check(i,j,map)) {
        				visited[i][j] = true;
        				visited[i][j+1] = true;
        				visited[i+1][j] = true;
        				visited[i+1][j+1] = true;
        				flag = true;
        			}
        		}
        	}
        	answer += remove(m, n, map);
        	visited = new boolean[m][n];
        }
        
        return answer;
    }
    
    public static boolean check(int x, int y, char[][] board) {
    	char ch = board[x][y];
    	if(ch == board[x][y+1] && ch == board[x+1][y] && ch == board[x+1][y+1]) return true;
    	return false;
    }
    
    public static int remove(int m, int n, char[][] board) {
    	int count = 0;
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			if(visited[i][j]) {
    				board[i][j] = '.';
    			}
    		}
    	}
    	
    	for(int i=0; i<n; i++) {
    		Queue<Character> q = new LinkedList<>();
    		for(int j=m-1; j>=0; j--) {
    			if(board[j][i] == '.') count++;
    			else q.add(board[j][i]);
    		}
    		
    		int idx = m-1;
    		while(!q.isEmpty()) {
    			board[idx--][i] = q.poll();
    		}
    		
    		for(int j=idx; j>=0; j--) board[j][i] = '#';
    	}
    	
    	return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(sol.solution(m, n, board));
	}
}