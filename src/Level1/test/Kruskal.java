package test;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

	static int V, E; // V : ����, E : ����
	static int[][] graph;
	static int[] parent; // �� ����� �θ�
	static int final_cost; // ���������� ���� �� �ּ� ���� Ʈ�� ���.
	
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
		
		// ������ ������� �������� ���� -> �迭�� 3��° ��, index = 2�� �ּ� ���� ����� ��Ÿ���� ����
		Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		// makeSet
		for(int i=0; i<V; i++) {
			parent[i] = i;
		}
		
		// ���� ������ Kruskal Algorithm ����
		for(int i=0; i<E; i++) {
			if(find(graph[i][0] - 1) != find(graph[i][1] -1)) {
				System.out.println("<���õ� ����>");
				System.out.println(Arrays.toString(graph[i]));
				union(graph[i][0] - 1, graph[i][1] - 1);
				final_cost += graph[i][2];
				System.out.println("<�� ��尡 ����Ű�� �ִ� �θ�>");
				System.out.println(Arrays.toString(parent) + "\n");
				continue;
			}
		}
		
		System.out.println("���� ��� : " + final_cost);
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
