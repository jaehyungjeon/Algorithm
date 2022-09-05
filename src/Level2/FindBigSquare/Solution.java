package Level2.FindBigSquare;

import java.util.*;

/*
 * Question : 
	1�� 0�� ä���� ǥ(board)�� �ֽ��ϴ�. ǥ 1ĭ�� 1 x 1 �� ���簢������ �̷���� �ֽ��ϴ�. ǥ���� 1�� �̷���� ���� ū ���簢���� ã�� ���̸� return �ϴ� solution �Լ��� �ϼ��� �ּ���. (��, ���簢���̶� �࿡ ������ ���簢���� ���մϴ�.)
	
	���� ���
	
	1	2	3	4
	0	1	1	1
	1	1	1	1
	1	1	1	1
	0	0	1	0
	�� �ִٸ� ���� ū ���簢����
	
	1	2	3	4
	0	1	1	1
	1	1	1	1
	1	1	1	1
	0	0	1	0
	�� �Ǹ� ���̴� 9�� �ǹǷ� 9�� ��ȯ�� �ָ� �˴ϴ�.
 * 
 * 	output : 9
 * 
 * 	Solution : 1. DP�� �̿��Ͽ� Ǫ�� ����
 * 			   2. �ֺ��� ���� Ž���Ͽ� ���� �ּҷ� ������ �迭�� �����ϴ� ���
 * 			   3. row, col�� �̾��� �ִ����� ���� üũ���θ� DP�� ����
 * 
 * 
 * */

public class Solution {

    public int solution(int[][] board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        
        if(row < 2 || col < 2) {
        	return 1;
        }
        
        if(row*col == 0) {
        	return 0;
        }
        
        for(int i=1; i<row; i++) {
        	for(int j=1; j<col; j++) {
        		if(board[i][j] != 0) {
        			board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
        		}
        		
        		if(answer < board[i][j]) answer = board[i][j];
        	}
        }
        
        return answer*answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int m = 6;
    	int n = 4;
    	int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(sol.solution(board));
	}
}