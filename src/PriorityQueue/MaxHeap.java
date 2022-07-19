package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
	Question : 널리 잘 알려진 자료구조 중 최대 힙이 있다. 최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
	배열에 자연수 x를 넣는다.
	배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
	프로그램은 처음에 비어있는 배열에서 시작하게 된다.

	input			 
	13
	0
	1
	2
	0
	0
	3
	2
	1
	0
	0
	0
	0
	0
	
	output
	0
	2
	1
	3
	2
	1
	0
	0
*/

public class MaxHeap {

	public static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // 정수형 우선순위 큐(값 기준 내림차순 정렬)
	public static int N; // 최초 몇개로 구성할 것인지에 관한 변수
	public static int[] arr; // 들어온 값을 담는 배열
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력 담기
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 배열 셋팅
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(arr[i] == 0) {
				sb.append(q.size() == 0 ? 0 : q.poll()).append("\n"); // 내림차순 정렬 후, 0일 경우 큐에서 값을 뽑아냄
			} else {
				q.add(arr[i]);
			}
		}
		
		System.out.println(sb.toString());
	}

}
