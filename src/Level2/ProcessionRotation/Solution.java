package Level2.ProcessionRotation;

import java.util.*;

/*
 * Question : 
	rows x columns ũ���� ����� �ֽ��ϴ�. ��Ŀ��� 1���� rows x columns������ ���ڰ� �� �پ� ������� �����ֽ��ϴ�. 
	�� ��Ŀ��� ���簢�� ����� ������ ���� �� ������, �׵θ� �κп� �ִ� ���ڵ��� �ð�������� ȸ����Ű�� �մϴ�. �� ȸ���� (x1, y1, x2, y2)�� ���� 4���� ǥ���ϸ�, �� �ǹ̴� ������ �����ϴ�.

	x1 �� y1 ������ x2 �� y2 �������� ������ �ش��ϴ� ���簢������ �׵θ��� �ִ� ���ڵ��� �� ĭ�� �ð�������� ȸ���մϴ�.
	������ 6 x 6 ũ�� ����� �����Դϴ�.
	
	grid_example.png
	
	�� ��Ŀ� (2, 2, 5, 4) ȸ���� �����ϸ�, �Ʒ� �׸��� ���� 2�� 2������ 5�� 4������ ������ �׵θ��� �ð�������� ȸ���մϴ�. �̶�, �߾��� 15�� 21�� �ִ� ������ ȸ������ �ʴ� ���� �����ϼ���.
	
	rotation_example.png
	
	����� ���� ����(�� ����) rows, ���� ����(�� ����) columns, �׸��� ȸ������ ��� queries�� �־��� ��, �� ȸ������ �迭�� ������ ��, 
	�� ȸ���� ���� ��ġ�� �ٲ� ���ڵ� �� ���� ���� ���ڵ��� ������� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 *  output : [8, 10, 25]
 * 
 * 	Solution : 1. �ð�������� ���� -> for�� ������� : col���̸�ŭ �켱���� �����ߴٰ� ���� �����ϸ� col���� �� row�� ����
 * 			   2. row �� �����ϸ� col���̸�ŭ �ٽ� back, ���� �����ϸ� �ٽ� row ���̸�ŭ back
 * 			   3. �����ϴ� for���� ������� �ݺ��ϸ� �ȴ�. -> ������, ������, ������, �న�� ��
 * 			   4. �ּڰ��� �־��ְ� return
 * 
 * */

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];

        // board ����
        int count = 1;
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		board[i][j] = count++;
        	}
        }
        
        for(int i=0; i<queries.length; i++) {
        	int startX = queries[i][0] - 1;
        	int startY = queries[i][1] - 1;
        	int endX = queries[i][2] - 1;
        	int endY = queries[i][3] - 1;
        	int tmp = board[startX][startY];
        	int min = tmp;
        	
        	// �� ����
        	for(int j=startX+1; j<=endX; j++) {
        		min = Math.min(min, board[j][startY]);
        		board[j-1][startY] = board[j][startY];
        	}
        	
        	// �� ����
        	for(int j=startY+1; j<=endY; j++) {
        		min = Math.min(min, board[endX][j]);
        		board[endX][j-1] = board[endX][j];
        	}
        	
        	// �� ����
        	for(int j=endX-1; j>=startX; j--) {
        		min = Math.min(min, board[j][endY]);
        		board[j+1][endY] = board[j][endY];
        	}
        	
        	// �� ����
        	for(int j=endY-1; j>=startY; j--) {
        		min = Math.min(min, board[startX][j]);
        		board[startX][j+1] = board[startX][j];
        	}
        	
        	// ������ �� ����
        	board[startX][startY+1] = tmp;
        	answer[i] = min;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(sol.solution(rows, columns, queries));
	}
}