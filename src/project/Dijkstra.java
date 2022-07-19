package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
  Question : 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

	input			 
	5 6	
	1	
	5 1 1
	1 2 2
	1 3 3
	2 3 4
	2 4 5
	3 4 6
	
	output
	0
	2
	3
	7
	INF
*/

import java.util.Scanner;

class Node implements Comparable<Node> {
	int index;
	int sum;
	
	Node(int index, int sum) {
		this.index = index;
		this.sum = sum;
	}
	
	@Override
	public int compareTo(Node node) { // 우선순위 정렬을 위함
		return this.sum - node.sum;
	}
}

public class Dijkstra {

	public static int V, E, start; // V : 정점, E : 간선, start : 시작
	public static List<Node>[] map; // index 별 목적지와 cost를 담는 map 
	public static int[] dist; // 목적지 배열
	public static PriorityQueue<Node> q;
	public static boolean[] visited; // 기방문여부 파악
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt(); // 시작
		
		map = new ArrayList[V+1];
		dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE); // 초기 int MAX 값으로 셋팅
		
		for(int i=1; i<V+1; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<V+1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			map[a].add(new Node(b, cost)); // 들어온 대로 리스트의 객체를 생성
		}
		
		q = new PriorityQueue<>();
		visited = new boolean[V+1];
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node adjNode = q.poll(); // 하나씩 꺼내면서 테스트 진행
			
			if(visited[adjNode.index]) continue;
			visited[adjNode.index] = true;
			
			for(Node node : map[adjNode.index]) {
				if(dist[node.index] > dist[adjNode.index] + node.sum) {
					dist[node.index] = dist[adjNode.index] + node.sum;
					q.add(new Node(node.index, dist[node.index]));
				}
			}
		}
		
		for(int i=1; i<V+1; i++) {
			if(dist[i] != Integer.MAX_VALUE) {
				System.out.println(dist[i]);
			} else {
				System.out.println("INF");
			}
		}
		
		sc.close();
	}
}
