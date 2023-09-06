package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
	Question : 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

	명령은 총 여섯 가지이다.
	
	push X: 정수 X를 큐에 넣는 연산이다.
	pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 큐에 들어있는 정수의 개수를 출력한다.
	empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	
	input			 
	15
	push 1
	push 2
	front
	back
	size
	empty
	pop
	pop
	pop
	size
	empty
	pop
	push 3
	empty
	front
		
	output
	1
	2
	2
	0
	1
	2
	-1
	0
	1
	-1
	0
	3

	Solution : 1. Deque로 하면 편해서 사용하였다.
	
*/

public class BaekJoon_10845 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<Integer>();
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "push" :
					queue.add(Integer.parseInt(st.nextToken()));
					break;
				case "pop" :
					sb.append(queue.isEmpty() ? -1 : queue.poll());
					break;
				case "size" : 
					sb.append(queue.size());
					break;
				case "empty" : 
					sb.append(queue.isEmpty() ? 1 : 0);
					break;
				case "front" :
					sb.append(queue.isEmpty() ? -1 : queue.getFirst());
					break;
				case "back" :
					sb.append(queue.isEmpty() ? -1 : queue.getLast());
					break;
				default:
					break;
			};

			if(!command.equals("push")) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
