package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
	Question : 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
	배열에 정수 x (x ≠ 0)를 넣는다.
	배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
	프로그램은 처음에 비어있는 배열에서 시작하게 된다.

	input			 
	18
	1
	-1
	0
	0
	0
	1
	1
	-1
	-1
	2
	-2
	0
	0
	0
	0
	0
	0
	0

	output
	-1
	1
	0
	-1
	-1
	1
	1
	-2
	2
*/

class Abs implements Comparable<Abs> {
	int num; // 일반 정수
	int abs; // 절댓값 수
	
	Abs(int num){
		this.num = num;
		this.abs = Math.abs(num);
	}
	
	@Override
	public int compareTo(Abs a) {
		if(this.abs == a.abs) { // 들어오는 수와 절댓값이 같으면
			return this.num - a.num; // 일반 수의 오름차순
		}
		
		return this.abs - a.abs; // 기본적으로 절대값 우선순위로 오름차순
	}
}

public class AbsHeap {

	public static PriorityQueue<Abs> q = new PriorityQueue<Abs>();
	public static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			
			if(value == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.poll().num);
				}
			} else {
				q.add(new Abs(value));
			}
		}
	}

}
