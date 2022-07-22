package test;

import java.util.Scanner;

/*
	방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

	첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
	둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
	셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
	이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
	서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
	
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

// 도착 지점, 도착 지점으로 가능 비용의 클래스
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

		V = sc.nextInt(); // 정점
		E = sc.nextInt(); // 간선

		// 출발지점
		int start = sc.nextInt();

		// 1. 인접 리스트를 이용한 그래프 초기화
		ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

		// 시작점은 1에서 할거니까 전체 V의 갯수보다 1개 더 추가한 V+1까지 담기
		for(int i=0; i<V+1; i++) { // 노드 번호가 1부터 시작하므로, 0번 인덱스 부분을 임의로 만들어 놓기만 한다.
			graph.add(new ArrayList<>());
		}

		// 그래프 값을 넣는다.
		for(int i=0; i < E; i++) {
			// a로 부터 b로 가는 값은 cost
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();

			graph.get(a).add(new Node(b, cost));
		}

		// 2. 방문 여부를 확인할 boolean 배열, start 노드부터 end 노드까지의 최소 거리를 저장할 배열
		boolean[] visited = new boolean[V+1];
		int[] dist = new int[V+1]; // 거리

		// 3. 최소 거리 정보를 담을 배열을 초기화
		for(int i=0; i<V+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[start] = 0;

		// 4. 다익스트라 알고리즘 진행
		for(int i=0; i<V; i++) {
			// 해당 노드가 가지고 있는 현재 비용
			int nodeValue = Integer.MAX_VALUE;

			// 해당 노드의 인덱스(번호)
			int nodeIdx = 0;

			// 0번 인덱스는 생각하지 않으므로 1번부터 START
			for(int j=1; j<V+1; j++) {
				// 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값
				if(!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}

			// 최종 선택된 노드를 방문처리
			visited[nodeIdx] = true;

			// 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신
			for(int j=0; j<graph.get(nodeIdx).size(); j++) {
				// 인접 노드 선택
				Node adjNode = graph.get(nodeIdx).get(j);

				// 인접 노드가 현재 가지는 최소비용과 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 최소 값으로 갱신
				if(dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
				}
			}
		}

		// 5. 최종 비용 산출
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
