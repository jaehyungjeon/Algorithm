package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : 철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
	토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.

	창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
	보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
	대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
	철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
	
	토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
	며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
	단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
	
	input			 
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
	
	output
	4
	
	Solution : 1. BFS를 이용하여 구하는 문제로 앞선 토마토 문제와 거의 유사하게 접근하면 될 것 같다.
			   2. 1로 지정된 위치의 row, col을 찾고 해당 위치에서 계속 탐색 실시한다.
			   3. 1이 마지막 위치일 경우, -1로 이동하는 반복을 수행하게 되므로 탐색이 순차적으로 진행된다.
			   4. 3차원 배열이므로 총 6개의 케이스가 벗어나는지 확인하여야 한다.
	
*/

public class BaekJoon_7569 {

	public static int N, M, H;
	public static int[][][] arr;
	public static int[] dx = {0, 0, 0, 0, 1, -1};
	public static int[] dy = {0, 0, -1, 1, 0, 0};
	public static int[] dh = {1, -1, 0, 0, 0, 0};
	public static Queue<int[]> queue = new LinkedList<int[]>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 1) {
						queue.offer(new int[] {i, j, k});
					}
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int z = q[0];
			int x = q[1];
			int y = q[2];
			
			for(int i=0; i<6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dh[i];
				
				if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H) continue;
				if(arr[nz][nx][ny] == 0) {
					arr[nz][nx][ny] = arr[z][x][y] + 1;
					queue.add(new int[] {nz, nx, ny});
				}
			}
		}
		
		int maxValue = Integer.MIN_VALUE;
		if(zeroCheck()) {
			return -1;
		} else {
			for(int i=0; i<H; i++) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<M; k++) {
						maxValue = Math.max(maxValue, arr[i][j][k]);
					}
				}
			}
			return maxValue - 1;
		}
	}
	
	private static boolean zeroCheck() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(arr[i][j][k] == 0) return true;
				}
			}
		}
		return false;
	}
}
