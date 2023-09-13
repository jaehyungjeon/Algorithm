package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
	
	창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
	보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 
	대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
	철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
	
	토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
	며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
	단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
	
	input			 
	6 4
	0 0 0 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 0
	0 0 0 0 0 1
	
	output
	8
	
	Solution : 1. BFS를 이용하여 구하는 문제.
			   2. 1로 지정된 위치의 row, col을 찾고 해당 위치에서 계속 탐색 실시한다.
			   3. 1이 마지막 위치일 경우, -1로 이동하는 반복을 수행하게 되므로 탐색이 순차적으로 진행된다.
	
*/

public class BaekJoon_7576 {

	public static int N, M, count;
	public static int[][] arr;
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, 1, -1, 0};
	public static Queue<int[]> queue = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		count = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int di = q[0];
			int dj = q[1];
			for(int k=0; k<4; k++) {
				int nx = di + dx[k];
				int ny = dj + dy[k];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(arr[nx][ny] == 0) { // 익어야 하는 토마트
					arr[nx][ny] = arr[di][dj] + 1;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		if(validCheck()) {
			return -1;
		} else {
			for(int k=0; k<M; k++) {
				for(int t=0; t<N; t++) {
					if(maxValue < arr[k][t]) {
						maxValue = arr[k][t];
					}
				}
			}
			
			return maxValue - 1;
		}
	}
	
	private static boolean validCheck() {
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 0) return true;
			}
		}
		return false;
	}
}
