package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 1부터 N까지 정수 N개로 이루어진 순열을 나타내는 방법은 여러 가지가 있다. 예를 들어, 8개의 수로 이루어진 순열 (3, 2, 7, 8, 1, 4, 5, 6)을 배열을 이용해 표현하면  
 
	\(\begin{pmatrix} 1 & 2 &3&4&5&6&7&8 \\  3& 2&7&8&1&4&5&6 \end{pmatrix}\) 와 같다. 또는, Figure 1과 같이 방향 그래프로 나타낼 수도 있다.
	
	순열을 배열을 이용해  
	 
	\(\begin{pmatrix} 1 & \dots & i & \dots &n \\  \pi_1& \dots& \pi_i & \dots & \pi_n \end{pmatrix}\) 로 나타냈다면, i에서 πi로 간선을 이어 그래프로 만들 수 있다.
	
	Figure 1에 나와있는 것 처럼, 순열 그래프 (3, 2, 7, 8, 1, 4, 5, 6) 에는 총 3개의 사이클이 있다. 이러한 사이클을 "순열 사이클" 이라고 한다.
	
	N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.
	
	input			 
	2
	8
	3 2 7 8 1 4 5 6
	10
	2 1 3 4 5 6 7 9 10 8
	
	output
	3
	7
	
	Solution : 1. 재귀를 이용하여 구하는 문제
			   2. 다음 위치에 해당하는 boolean 배열의 T/F에 따라서 재귀를 돌릴 것인지를 판정.
			   3. 최종적으로 모두 찍는 루트면 count를 증가시키고 +1을 해줌.
	
*/

public class BaekJoon_10451 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			int[] arr = new int[N+1];
			boolean[] visited = new boolean[N+1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					int next = arr[i];
					
					while(true) {
						if(visited[next]) {
							count++;
							break;
						}
						visited[next] = true;
						next = arr[next];
					}
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
