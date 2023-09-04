package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	Question : 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다. 지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.

	지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
	
	첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
	왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
	오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
	큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다. (이 위치는 가장 처음 큐에서의 위치이다.) 
	이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
	
	input			 
	10 3
	1 2 3
	
	output
	0
	
	Solution : 1. LinkedList를 이용한 카운트 조회이다.
			   2. 큐의 전체 크기와 현재값의 인덱스를 비교하여 앞으로 더할것인지 뒤에다 추가할 것인지를 판정한다(최소값 조회를 위함)
			   3. 도는만큼의 값을 구한다.
*/

public class BaekJoon_1021 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		// 큐에 수만큼을 담는다.
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		int firstValue = 1;
		
		st = new StringTokenizer(br.readLine());
		while(M-- > 0) {
			int val = Integer.parseInt(st.nextToken());
			
			while(firstValue != val) {
				int index = queue.indexOf(val);
				int size = queue.size();
				
				if(index < size - index) {
					queue.addLast(queue.removeFirst());
				} else {
					queue.addFirst(queue.removeLast());
				}
				firstValue = queue.getFirst();
				answer++;
			}
			
			queue.removeFirst();
			if(queue.isEmpty()) break;
			firstValue = queue.getFirst();
		}
		
		System.out.println(answer);
	}
}
