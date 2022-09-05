package Level2.FindBigSquare;

import java.util.*;

/*
 * Question : 
	1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다. 표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요. (단, 정사각형이란 축에 평행한 정사각형을 말합니다.)
	
	예를 들어
	
	1	2	3	4
	0	1	1	1
	1	1	1	1
	1	1	1	1
	0	0	1	0
	가 있다면 가장 큰 정사각형은
	
	1	2	3	4
	0	1	1	1
	1	1	1	1
	1	1	1	1
	0	0	1	0
	가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.
 * 
 * 	output : 9
 * 
 * 	Solution : 1. DP를 이용하여 푸는 문제
 * 			   2. 주변의 값을 탐색하여 가장 최소로 현재의 배열을 셋팅하는 방식
 * 			   3. row, col이 이어져 있는지에 대한 체크여부를 DP로 진행
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