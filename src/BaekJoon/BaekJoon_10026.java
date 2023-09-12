package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

	크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
	
	예를 들어, 그림이 아래와 같은 경우에
	
	RRRBB
	GGBBB
	BBBRR
	BBRRR
	RRRRR
	적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
	
	그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
	
	input			 
	5
	RRRBB
	GGBBB
	BBBRR
	BBRRR
	RRRRR
	
	output
	4 3
	
	Solution : 1. 전형적인 DFS를 활용한 문제로 범위밖으로 넘어가지 않는 선에서 조건을 준다.
			   2. temp값 즉, 앞선 자료와 같은 값일경우 계속 탐색을 진행한다.
			   3. String으로 board를 구성하면 안나와서 char로 변경하였더니 정상 동작하였다.
	
*/

public class BaekJoon_10026 {

	public static int N;
	public static char[][] board;
	public static boolean[][] visited;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, 1, -1, 0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		board = new char[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		// 정상인 경우
		int normalCount = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					normalCount++;
				}
			}
		}

		int uNormalCount = 0;
		visited = new boolean[N+1][N+1];
		
		// 비정상인 경우
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == 'G') {
					board[i][j] = 'R'; // G -> R
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					uNormalCount++;
				}
			}
		}
		
		sb.append(normalCount).append(' ').append(uNormalCount);
		
		System.out.println(sb.toString());
	}
	
	private static void dfs(int i, int j) {
		visited[i][j] = true;
		char temp = board[i][j];
		for(int k=0; k<4; k++) {
			int bi = i + dx[k];
			int bj = j + dy[k];
			
			if(bi < 0 || bj < 0 || bi > N || bj > N) continue;
			
			if(!visited[bi][bj] && board[bi][bj] == temp) {
				dfs(bi, bj);
			}
		}
	}

}
