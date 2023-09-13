package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 크기가 N×N인 도시가 있다. 도시는 1×1크기의 칸으로 나누어져 있다. 도시의 각 칸은 빈 칸, 치킨집, 집 중 하나이다. 
	도시의 칸은 (r, c)와 같은 형태로 나타내고, r행 c열 또는 위에서부터 r번째 칸, 왼쪽에서부터 c번째 칸을 의미한다. r과 c는 1부터 시작한다.

	이 도시에 사는 사람들은 치킨을 매우 좋아한다. 따라서, 사람들은 "치킨 거리"라는 말을 주로 사용한다. 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다. 
	즉, 치킨 거리는 집을 기준으로 정해지며, 각각의 집은 치킨 거리를 가지고 있다. 도시의 치킨 거리는 모든 집의 치킨 거리의 합이다.
	
	임의의 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
	예를 들어, 아래와 같은 지도를 갖는 도시를 살펴보자.
	
	0 2 0 1 0
	1 0 1 0 0
	0 0 0 0 0
	0 0 0 1 1
	0 0 0 1 2
	0은 빈 칸, 1은 집, 2는 치킨집이다.
	
	(2, 1)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |2-1| + |1-2| = 2, (5, 5)에 있는 치킨집과의 거리는 |2-5| + |1-5| = 7이다. 따라서, (2, 1)에 있는 집의 치킨 거리는 2이다.
	(5, 4)에 있는 집과 (1, 2)에 있는 치킨집과의 거리는 |5-1| + |4-2| = 6, (5, 5)에 있는 치킨집과의 거리는 |5-5| + |4-5| = 1이다. 따라서, (5, 4)에 있는 집의 치킨 거리는 1이다.
	
	이 도시에 있는 치킨집은 모두 같은 프랜차이즈이다. 프렌차이즈 본사에서는 수익을 증가시키기 위해 일부 치킨집을 폐업시키려고 한다. 
	오랜 연구 끝에 이 도시에서 가장 수익을 많이 낼 수 있는 치킨집의 개수는 최대 M개라는 사실을 알아내었다.
	도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램을 작성하시오.
	
	input			 
	5 3
	0 0 1 0 0
	0 0 2 0 1
	0 1 2 0 0
	0 0 1 0 0
	0 0 0 0 2
	
	output
	5
	
	Solution : 1. DFS + BackTracking 활용 문제였다.
			   2. 집(1)에서 치킨집(2)위치의 거리 중 최소를 구하는 문제였다.
			   3. 최대 M개의 치킨집을 고르고 고른 치킨집의 위치에서 집까지의 거리의 합 중 최소를 구하기 때문에 백트래킹을 활용한다.
			   4. depth가 M개일때를 기준으로 최소 거리를 구하도록 한다.
			   5. 이미 방문한 곳은 넘겨야 하므로 boolean을 활용한다.
			   6. 선택되었을 때의 List를 구현하여 백트래킹 완료 후에 거리비를 구하도록 한다.
	
*/

public class BaekJoon_15686 {

	public static class Quiz {
		int row;
		int col;
		
		public Quiz(int row, int col) {
			// TODO Auto-generated constructor stub
			this.row = row;
			this.col = col;
		}
	}
	
	public static int N, M;
	public static int result = Integer.MAX_VALUE;
	public static int[][] arr;
	public static boolean[] visited;
	public static List<Quiz> house = new ArrayList<Quiz>();
	public static List<Quiz> chicken = new ArrayList<Quiz>();
	public static List<Quiz> choice = new ArrayList<Quiz>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) { // 집(1)일 경우...
					house.add(new Quiz(i, j));
				} else if(arr[i][j] == 2) { // 치킨집(2)일 경우...
					chicken.add(new Quiz(i, j));
				}
			}
		}
		
		// 치킨집의 개수만큼 boolean 배열을 생성한다.
		visited = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(result);
	}
	
	private static void dfs(int depth, int start) {
		if(M == depth) {
			int sum = 0;
			for(Quiz t : house) {
				int min = Integer.MAX_VALUE;
				for(Quiz c : choice) {
					int distance = Math.abs(t.row - c.row) + Math.abs(t.col - c.col);
					min = Math.min(distance, min);
				}
				sum += min;
			}
			
			// 합계중 최솟값을 반환하도록 한다.
			result = Math.min(result, sum);
			return;
		}
		
		// 치킨집의 개수만큼 돌린다.
		for(int i=start; i<chicken.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				choice.add(chicken.get(i));
				dfs(depth+1, i+1);
				choice.remove(choice.size()-1);
				visited[i] = false;
			}
		}
	}
	
}
