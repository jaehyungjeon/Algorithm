package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
	Question : 요세푸스 문제는 다음과 같다.

	1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 
	한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
	원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
	
	N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
	
	input			 
	7 3
		
	output
	<3, 6, 2, 7, 5, 1, 4>

	Solution : 1. Deque를 이용하는 문제이다.
			   2. 앞까지 for문 돌려서 뒤에 붙이고 poll하여 append 시킨다.
			   3. 마지막 큐의 값을 꺼내고 '>'를 붙여서 리턴해준다.
	
*/

public class BackJoon_1158 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		sb.append("<");
		
		while(queue.size() > 1) {
			for(int i=0; i<K-1; i++) {
				queue.addLast(queue.pollFirst());
			}
			sb.append(queue.pollFirst()).append(", ");
		}
		
		sb.append(queue.poll()).append(">");
		
		System.out.println(sb.toString());
	}

}
