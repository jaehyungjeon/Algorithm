package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 평면에 네 개의 직사각형이 놓여 있는데 그 밑변은 모두 가로축에 평행하다. 
	이 네 개의 직사각형들은 서로 떨어져 있을 수도 있고, 겹쳐 있을 수도 있고, 하나가 다른 하나를 포함할 수도 있으며, 변이나 꼭짓점이 겹칠 수도 있다.

	이 직사각형들이 차지하는 면적을 구하는 프로그램을 작성하시오.

	input			 
	1 2 4 4
	2 3 5 7
	3 1 6 5
	7 3 8 6
	
	output
	26
	
	Solution : 1. boolean을 이용하여 해당 2차원배열의 T/F로 판정하면 된다.
			   2. 중복된 부분도 하나의 T로 처리되기 때문에 블록으로 계산한다.
			   3. 넓이는 1X1 = 1이므로 ++로 후위연산처리로 끝낸다.

*/

public class BaekJoon_2669 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] board = new boolean[101][101];
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					board[k][j] = true;
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]) sum++;
			}
		}
		
		System.out.println(sum);
	}

}
