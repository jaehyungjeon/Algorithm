package test;

import java.util.Scanner;

/*
	����׷����� �־����� �־��� ���������� �ٸ� ��� ���������� �ִ� ��θ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ��, ��� ������ ����ġ�� 10 ������ �ڿ����̴�.

	ù° �ٿ� ������ ���� V�� ������ ���� E�� �־�����. (1 �� V �� 20,000, 1 �� E �� 300,000) ��� �������� 1���� V���� ��ȣ�� �Ű��� �ִٰ� �����Ѵ�.
	��° �ٿ��� ���� ������ ��ȣ K(1 �� K �� V)�� �־�����.
	��° �ٺ��� E���� �ٿ� ���� �� ������ ��Ÿ���� �� ���� ���� (u, v, w)�� ������� �־�����.
	�̴� u���� v�� ���� ����ġ w�� ������ �����Ѵٴ� ���̴�. u�� v�� ���� �ٸ��� w�� 10 ������ �ڿ����̴�.
	���� �ٸ� �� ���� ���̿� ���� ���� ������ ������ ���� ������ �����Ѵ�.
	
	sample input
	5 6
	1
	5 1 1
	1 2 2
	1 3 3
	2 3 4
	2 4 5
	3 4 6
 */

import java.util.ArrayList;
import java.util.Scanner;

// ���� ����, ���� �������� ���� ����� Ŭ����
class Node {
	int idx;
	int cost;

	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}

public class Backjoon_1753 {

	public static int V, E;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // ����
		E = sc.nextInt(); // ����

		// �������
		int start = sc.nextInt();

		// 1. ���� ����Ʈ�� �̿��� �׷��� �ʱ�ȭ
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

		// �������� 1���� �ҰŴϱ� ��ü V�� �������� 1�� �� �߰��� V+1���� ���
		for(int i=0; i<V+1; i++) { // ��� ��ȣ�� 1���� �����ϹǷ�, 0�� �ε��� �κ��� ���Ƿ� ����� ���⸸ �Ѵ�.
			graph.add(new ArrayList<>());
		}

		// �׷��� ���� �ִ´�.
		for(int i=0; i < E; i++) {
			// a�� ���� b�� ���� ���� cost
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();

			graph.get(a).add(new Node(b, cost));
		}

		// 2. �湮 ���θ� Ȯ���� boolean �迭, start ������ end �������� �ּ� �Ÿ��� ������ �迭
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1]; // �Ÿ�

		// 3. �ּ� �Ÿ� ������ ���� �迭�� �ʱ�ȭ
		for(int i=0; i<V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[start] = 0;

		// 4. ���ͽ�Ʈ�� �˰��� ����
		for(int i=0; i<V; i++) {
			// �ش� ��尡 ������ �ִ� ���� ���
			int nodeValue = Integer.MAX_VALUE;

			// �ش� ����� �ε���(��ȣ)
			int nodeIdx = 0;

			// 0�� �ε����� �������� �����Ƿ� 1������ START
			for(int j=1; j<V+1; j++) {
				// �ش� ��带 �湮���� �ʾҰ�, ���� ��� �Ÿ���� �� �ּڰ�
				if(!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}

			// ���� ���õ� ��带 �湮ó��
			visited[nodeIdx] = true;

			// �ش� ������ �������� ���� ����� �ּ� �Ÿ� ���� ����
			for(int j=0; j<graph.get(nodeIdx).size(); j++) {
				// ���� ��� ����
				Node adjNode = graph.get(nodeIdx).get(j);

				// ���� ��尡 ���� ������ �ּҺ��� ���� ���õ� ����� �� + ���� ��忡�� ���� ���� ���� ���� ���Ͽ� �ּ� ������ ����
				if(dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
				}
			}
		}

		// 5. ���� ��� ����
		for(int i = 1; i<V+1; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

		sc.close(); // Scanner Close

	}
}
