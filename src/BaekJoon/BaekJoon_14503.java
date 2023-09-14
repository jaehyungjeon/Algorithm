package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

	로봇 청소기가 있는 방은 
	$N \times M$ 크기의 직사각형으로 나타낼 수 있으며, 
	$1 \times 1$ 크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다. 방의 각 칸은 좌표 
	$(r, c)$로 나타낼 수 있고, 가장 북쪽 줄의 가장 서쪽 칸의 좌표가 
	$(0, 0)$, 가장 남쪽 줄의 가장 동쪽 칸의 좌표가 
	$(N-1, M-1)$이다. 즉, 좌표 
	$(r, c)$는 북쪽에서 
	$(r+1)$번째에 있는 줄의 서쪽에서 
	$(c+1)$번째 칸을 가리킨다. 처음에 빈 칸은 전부 청소되지 않은 상태이다.
	
	로봇 청소기는 다음과 같이 작동한다.
	
	현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
	현재 칸의 주변 
	$4$칸 중 청소되지 않은 빈 칸이 없는 경우,
	바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
	바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
	현재 칸의 주변 
	$4$칸 중 청소되지 않은 빈 칸이 있는 경우,
	반시계 방향으로 
	$90^\circ$ 회전한다.
	바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
	1번으로 돌아간다. 

	input			 
	3 3
	1 1 0
	1 1 1
	1 0 1
	1 1 1
	
	output
	1
	
	Solution : 1. 북동남서(0123)의 반시계방향은 서북동남(3012) 이므로 dx, dy도 해당 사방진에 맞추어 설정해 놓는다.
			   2. 현재위치를 청소하면 카운트를 증가시킨다.
			   3. 다음 위치를 찾고 다음위치도 청소해야 한다면 재귀를 하면서 계속 진행한다.
			   4. 더이상 위아래 기준 청소할 영역이 없으면 후진한다. -> (direction + 2) % 4 => 북 -> 남 // 남 -> 북 // 동 -> 서 // 서 -> 동
			   5. 최종적으로 카운트 된 값을 출력한다.
				
*/

public class BaekJoon_14503 {

	public static int N, M, r, c, d;
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int count = 0;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r, c, d);
		
		System.out.println(count);
	}
	
	private static void dfs(int r, int c, int d) {
		if(arr[r][c] == 0) { // 현재 위치를 청소한다.
			arr[r][c] = -1;
			count++;
		}
		
		boolean check = false;
		int origin = d;
		for(int i=0; i<4; i++) {
			int nextDirection = (d + 3) % 4;
			int nextRow = r + dx[nextDirection];
			int nextCol = c + dy[nextDirection];
			
			if(nextRow > 0 && nextCol > 0 && nextRow < N && nextCol < M) {
				if(arr[nextRow][nextCol] == 0) {
					dfs(nextRow, nextCol, nextDirection);
					check = true;
					break;
				}
			}
			d = (d+3) % 4;
		}
		
		if(!check) {
			int nextDirection = (origin + 2) % 4;
			int nextRow = r + dx[nextDirection];
			int nextCol = c + dy[nextDirection];
			
			if(nextRow > 0 && nextCol > 0 && nextRow < N && nextCol < M) {
				if(arr[nextRow][nextCol] != 1) { // 후진
					dfs(nextRow, nextCol, origin);
				}
			}
		}
		
	}

}
