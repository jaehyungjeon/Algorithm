package test;

import java.util.ArrayList;
import java.util.Scanner;

class TestNode {
	int idx;
	int cost;
	
	TestNode(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class DijkstraTest {

	public static int V, E; // 정점, 간선
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		int start = sc.nextInt();
		
		ArrayList<ArrayList<TestNode>> graph = new ArrayList<ArrayList<TestNode>>();
		
		for(int i=0; i<V+1; i++) {
			graph.add(new ArrayList<>());
		}
	
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			graph.get(a).add(new TestNode(b, cost));
		}
		
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1];
		
		for(int i=0; i<V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[start] = 0;
		
		for(int i=0; i<V; i++) {
			int nodeValue = Integer.MAX_VALUE;
			
			int nodeIdx = 0;
			
			for(int j=1; j<V+1; j++) {
				if(!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			
			visited[nodeIdx] = true;
			
			for(int j=0; j<graph.get(nodeIdx).size(); j++) {
				TestNode adjNode = graph.get(nodeIdx).get(j);
				
				if(dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
				}
			}
		}
		
		for(int i=1; i<V+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

		sc.close();
	}
}
