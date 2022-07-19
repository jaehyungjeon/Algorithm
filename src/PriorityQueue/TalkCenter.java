package PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

/*
	Question : 백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다. 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다.
	만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.
	예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.
	백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.
	
	input			 
	7
	1
	5
	2
	10
	-99
	7
	5
	
	output
	1
	1
	2
	2
	2
	2
	5
*/

public class TalkCenter {

	public static int N;
	public static PriorityQueue<Integer> minQueue = new PriorityQueue<>(); 
	public static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWrite로 속도 향상
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine()); // 들어오는 수
			
			if(minQueue.size() == maxQueue.size()) {
				maxQueue.offer(num);
			} else {
				minQueue.offer(num);
			}
			
			if(!minQueue.isEmpty() && !maxQueue.isEmpty()) {
				if(minQueue.peek() < maxQueue.peek()) {
					minQueue.offer(maxQueue.poll());
					maxQueue.offer(minQueue.poll());
				}
			}
			
			bw.write(maxQueue.peek() + "\n");
//			System.out.println(maxQueue.peek()); // 시간초과...
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
