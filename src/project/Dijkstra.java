package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
  Question : ����׷����� �־����� �־��� ���������� �ٸ� ��� ���������� �ִ� ��θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, ��� ������ ����ġ�� 10 ������ �ڿ����̴�.

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
	public int compareTo(Node node) { // �켱���� ������ ����
		return this.sum - node.sum;
	}
}

public class Dijkstra {

	public static int V, E, start; // V : ����, E : ����, start : ����
	public static List<Node>[] map; // index �� �������� cost�� ��� map 
	public static int[] dist; // ������ �迭
	public static PriorityQueue<Node> q;
	public static boolean[] visited; // ��湮���� �ľ�
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt(); // ����
		
		map = new ArrayList[V+1];
		dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE); // �ʱ� int MAX ������ ����
		
		for(int i=1; i<V+1; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<V+1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			
			map[a].add(new Node(b, cost)); // ���� ��� ����Ʈ�� ��ü�� ����
		}
		
		q = new PriorityQueue<>();
		visited = new boolean[V+1];
		q.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node adjNode = q.poll(); // �ϳ��� �����鼭 �׽�Ʈ ����
			
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
