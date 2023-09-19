package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
	Question : N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 
	우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.

	input			 
	5
	8
	1 2 2
	1 3 3
	1 4 1
	1 5 10
	2 4 2
	3 4 1
	3 5 1
	4 5 3
	1 5
	
	output
	4
	
	Solution : 1. 다익스트라 알고리즘 추측
			   2. 시작점과 갈곳에 대한 오름차순으로 정렬을 해주고 한번 방문한 곳은 더이상 방문되지 않도록 boolean t/f 처리 해준다.
			   3. 큐를 이용해 다음 이동할 지점에 대한 cost를 더해가며 최소비용을 구현한다.
	
*/

public class BaekJoon_1916 {
	
	public static List<Node>[] list;
	public static int[] dp;
	public static boolean[] visited;
	
	public static class Node implements Comparable<Node>{
		int togo;
		int cost;
		
		public Node(int togo, int cost) {
			// TODO Auto-generated constructor stub
			this.togo = togo;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) { // 가격별 오름차순
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		dp = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(e, cost));
		}
		
		st = new StringTokenizer(br.readLine()); 
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dp[end]);
	}
	
	public static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<Node>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		q.add(new Node(start, 0));
		dp[start] = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int togo = node.togo;
			
			if(visited[togo]) continue;
			
			visited[togo] = true;
			for(Node next : list[togo]) {
				if(dp[next.togo] >= dp[togo] + next.cost) {
					dp[next.togo] = dp[togo] + next.cost;
					q.add(new Node(next.togo, dp[next.togo]));
				}
			}
		}
	}

}
