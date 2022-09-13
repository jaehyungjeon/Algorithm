package Level2.FriendsFourBlocks;

import java.util.*;

/*
 * Question : 
	����ε� ��ä�� ����� ���� ��� ���̾��� �ű� ���� ���� ������ �ð� �Ǿ���. �̹��� ����� ���� ������ "������4���".
	���� ����� īī�������� ����� 2��2 ���·� 4���� �پ����� ��� ������鼭 ������ ��� �����̴�.
	
	board map
	���� ���� ���� ���� �־��� ���, ���̾��� 2��2�� ��ġ�� 7�� ��ϰ� ���� 2��2�� ��ġ�� 4�� ����� ��������. ���� ����� ���� 2��2�� ���Ե� �� ������, �������� ���ǿ� �����ϴ� 2��2 ����� ���� �� �ִٸ� �Ѳ����� ��������.
	
	board map
	
	����� ������ �Ŀ� ���� �ִ� ����� �Ʒ��� ������ �� ������ ä��� �ȴ�.
	
	board map
	
	���� �� ������ ä�� �Ŀ� �ٽ� 2��2 ���·� ���� ����� ����� ���̸� �ٽ� �������� �������� �ݺ��ϰ� �ȴ�.
	board map
	
	�� �ʱ� ��ġ�� ���ڷ� ǥ���ϸ� �Ʒ��� ����.
	
	TTTANT
	RRFACC
	RRRFCC
	TRRRAA
	TTMMMF
	TMMTTJ                                     
	�� ���ڴ� ���̾�(R), ����(M), ����ġ(A), ���ε�(F), �׿�(N), Ʃ��(T), ������(J), ��(C)�� �ǹ��Ѵ�
	
	�Է����� ����� ù ��ġ�� �־����� ��, �������� ����� ��� �� ������ �Ǵ��ϴ� ���α׷��� �����϶�.
 * 
 * 
 * 	Solution : 1. ���ͳ� ����..
 * 			   2. ���ٹ��� 2x2�� ���� ���� ã�� -> check Method
 * 			   3. ����鼭 count ���� -> remove Method
 * 			   4. 4�� ���� ��쿡 -> ��� visited = true�� ����
 * 			   5. ������ ���� while�� ���� -> flag��
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