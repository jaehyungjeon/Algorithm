package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

	정사각형은 서로 겹치면 안 된다.
	도형은 모두 연결되어 있어야 한다.
	정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
	정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
	
	아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
	
	테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
	
	테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

	input			 
	5 5
	1 2 3 4 5
	5 4 3 2 1
	2 3 4 5 6
	6 5 4 3 2
	1 2 1 2 1
	
	output
	19
	
	Solution : 1. 진행방향에 따라서 구분지어야 하는 이슈가 있었다.
			   2. 인접 4방향으로 구현되는 depth == 4와 마지막 보라색 도형은 2번째에서 방향을 틀어서 계산해주어야 하므로 depth를 3으로 한다.
			   3. 따라서 depth가 3일때와 4일때의 조합 중 가장 큰 값을 구하면 된다.
			   4. 문제에는 완전탐색을 위한 dfs가 이용되었다.

*/

public class BaekJoon_14500 {
	
	public static int N, M;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, 1, -1, 0};
	public static int[][] arr;
	public static boolean[][] visited;
	public static int maxValue = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false;
				combination(i, j, 0, 0, arr[i][j]);
			}
		}
		
		System.out.println(maxValue);
	}

	private static void dfs(int x, int y, int depth, int sum) {
		if(depth == 4) {
			maxValue = Math.max(maxValue, sum);
			return;
		}
		
		// 인접 4방향 탐색
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			if(visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, depth+1, sum + arr[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	
	private static void combination(int x, int y, int start, int depth, int sum) {
		if(depth == 3) {
			maxValue = Math.max(maxValue, sum);
			return;
		}
		
		for(int i=start; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			combination(x, y, i+1, depth+1, sum + arr[nx][ny]);
		}
	}
}
