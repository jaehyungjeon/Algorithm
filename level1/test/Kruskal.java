package test;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

	static int V, E; // V : 정점, E : 간선
	static int[][] graph;
	static int[] parent; // 각 노드의 부모
	static int final_cost; // 최종적으로 연결 된 최소 신장 트리 비용.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[E][3];
				
		for(int i=0; i<E; i++) {
			graph[i][0] = sc.nextInt();
			graph[i][1] = sc.nextInt();
			graph[i][2] = sc.nextInt();
		}
		
		parent = new int[V];
		final_cost = 0;
		
		// 간선의 비용으로 오름차순 정렬 -> 배열의 3번째 즉, index = 2는 최소 신장 비용을 나타내기 때문
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		// makeSet
		for(int i=0; i<V; i++) {
			parent[i] = i;
		}
		
		// 낮은 비용부터 Kruskal Algorithm 진행
		for(int i=0; i<E; i++) {
			if(find(graph[i][0] - 1) != find(graph[i][1] -1)) {
				System.out.println("<선택된 간선>");
				System.out.println(Arrays.toString(graph[i]));
				union(graph[i][0] - 1, graph[i][1] - 1);
				final_cost += graph[i][2];
				System.out.println("<각 노드가 가리키고 있는 부모>");
				System.out.println(Arrays.toString(parent) + "\n");
				continue;
			}
		}
		
		System.out.println("최종 비용 : " + final_cost);
		sc.close();
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	}

}
