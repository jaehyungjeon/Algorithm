package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : 인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

	연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

	일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
	
	예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.
	
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
	
	2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.
	
	2 1 0 0 1 1 0
	1 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 1 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	바이러스가 퍼진 뒤의 모습은 아래와 같아진다.
	
	2 1 0 0 1 1 2
	1 0 1 0 1 2 2
	0 1 1 0 1 2 2
	0 1 0 0 0 1 2
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
	
	연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

	input			 
	7 7
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	
	output
	27
	
	Solution : 1. dfs + bfs 혼합문제이다.
			   2. 논리는 간단하게 백트래킹을 진행하면서 0인 값을 1로 변형하여 벽을 만들어준다.
			   3. 벽이 3개 (depth로 구분)인 경우 안전지대를 탐색하는 bfs를 구현한다.
			   4. bfs를 구현하면서 범위값을 벗어나지 않기 위해 dx, dy를 선언하여 사용한다.
			   5. 벽의 위치와 바이러스의 위치를 계속적으로 변경해가면서 bfs를 동작한다.
			   6. bfs 동작이 끝난 후, 안전지대의 개수를 탐색하여 MaxValue를 리턴한다.

*/

public class BaekJoon_14502 {

	public static int N, M;
	public static int[][] arr;
	public static int[] dx = {1, 0, 0, -1};
	public static int[] dy = {0, 1, -1, 0};
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
		
		// 탐색 실시
		dfs(0);
		
		System.out.println(maxValue);
	}
	
	private static void dfs(int depth) {
		if(depth == 3) {
			bfs();
			return;
		}
		
		// 0일때 1로 바꿔주는 백트래킹을 진행한다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(depth+1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 2) {
					queue.add(new int[] {i, j});
				}
			}
		}
		
		// 원본의 변동을 제거하기 위한 clone
		int[][] cloneArr = new int[N][M];
		for(int i=0; i<N; i++) {
			cloneArr[i] = arr[i].clone();
		}
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(cloneArr[nx][ny] == 0) {
					cloneArr[nx][ny] = 2;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		
		int safe = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cloneArr[i][j] == 0) {
					safe++;
				}
			}
		}
		
		maxValue = Math.max(maxValue, safe);
	}

}
