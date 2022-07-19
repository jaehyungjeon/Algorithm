package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/*
	Question : 널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
	배열에 자연수 x를 넣는다.
	배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
	프로그램은 처음에 비어있는 배열에서 시작하게 된다.
	
	input			 
	9
	0
	12345678
	1
	2
	0
	0
	0
	0
	32
	
	output
	0
	1
	2
	12345678
	0
*/

public class MinHeap { // MAX Heap의 Reverse 문제
	//기존에는 배열을 통해 값을 담았으나 input되는 값을 정수형 변수에 바로 셋팅하여 비교하는 것이 메모리 이슈에 유리할 것으로 판단. 

	public static PriorityQueue<Integer> q = new PriorityQueue<>(); // 우선큐는 default 오름차순
	public static int N; // 최초 몇개로 구성할 것인지에 관한 변수 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
//				sb.append(q.isEmpty() ? 0 : q.poll()).append("\n");
				if(q.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(q.poll());
				}
			} else {
				q.add(input);
			}
		}
		
//		System.out.println(sb.toString());
	}
}
