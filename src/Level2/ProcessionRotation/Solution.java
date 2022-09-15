package Level2.ProcessionRotation;

import java.util.*;

/*
 * Question : 
	rows x columns 크기인 행렬이 있습니다. 행렬에는 1부터 rows x columns까지의 숫자가 한 줄씩 순서대로 적혀있습니다. 
	이 행렬에서 직사각형 모양의 범위를 여러 번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전시키려 합니다. 각 회전은 (x1, y1, x2, y2)인 정수 4개로 표현하며, 그 의미는 다음과 같습니다.

	x1 행 y1 열부터 x2 행 y2 열까지의 영역에 해당하는 직사각형에서 테두리에 있는 숫자들을 한 칸씩 시계방향으로 회전합니다.
	다음은 6 x 6 크기 행렬의 예시입니다.
	
	grid_example.png
	
	이 행렬에 (2, 2, 5, 4) 회전을 적용하면, 아래 그림과 같이 2행 2열부터 5행 4열까지 영역의 테두리가 시계방향으로 회전합니다. 이때, 중앙의 15와 21이 있는 영역은 회전하지 않는 것을 주의하세요.
	
	rotation_example.png
	
	행렬의 세로 길이(행 개수) rows, 가로 길이(열 개수) columns, 그리고 회전들의 목록 queries가 주어질 때, 각 회전들을 배열에 적용한 뒤, 
	그 회전에 의해 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 *  output : [8, 10, 25]
 * 
 * 	Solution : 1. 시계방향으로 돈다 -> for문 진행방향 : col차이만큼 우선으로 진행했다가 끝에 도달하면 col유지 후 row로 진행
 * 			   2. row 끝 도달하면 col차이만큼 다시 back, 끝에 도달하면 다시 row 차이만큼 back
 * 			   3. 도달하는 for문을 구분지어서 반복하면 된다. -> 열증가, 행증가, 열감소, 행감소 순
 * 			   4. 최솟값을 넣어주고 return
 * 
 * */

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];

        // board 구성
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
        	
        	// 열 증가
        	for(int j=startX+1; j<=endX; j++) {
        		min = Math.min(min, board[j][startY]);
        		board[j-1][startY] = board[j][startY];
        	}
        	
        	// 행 증가
        	for(int j=startY+1; j<=endY; j++) {
        		min = Math.min(min, board[endX][j]);
        		board[endX][j-1] = board[endX][j];
        	}
        	
        	// 열 감소
        	for(int j=endX-1; j>=startX; j--) {
        		min = Math.min(min, board[j][endY]);
        		board[j+1][endY] = board[j][endY];
        	}
        	
        	// 행 감소
        	for(int j=endY-1; j>=startY; j--) {
        		min = Math.min(min, board[startX][j]);
        		board[startX][j+1] = board[startX][j];
        	}
        	
        	// 마지막 값 셋팅
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