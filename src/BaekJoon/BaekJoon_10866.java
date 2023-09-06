package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
	Question : 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

	명령은 총 여덟 가지이다.
	
	push_front X: 정수 X를 덱의 앞에 넣는다.
	push_back X: 정수 X를 덱의 뒤에 넣는다.
	pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 덱에 들어있는 정수의 개수를 출력한다.
	empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
	front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	
	input			 
	15
	push_back 1
	push_front 2
	front
	back
	size
	empty
	pop_front
	pop_back
	pop_front
	size
	empty
	pop_back
	push_front 3
	empty
	front
		
	output
	2
	1
	2
	0
	2
	1
	-1
	0
	1
	-1
	0
	3

	Solution : 1. Deque를 이용하는 문제이다.
			   2. 쉬우므로 설명은 생략한다.
	
*/

public class BaekJoon_10866 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case "push_front" :
					queue.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case "push_back" :
					queue.addLast(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front" :
					sb.append(queue.isEmpty() ? -1 : queue.pollFirst());
					sb.append("\n");
					break;
				case "pop_back" :
					sb.append(queue.isEmpty() ? -1 : queue.pollLast());
					sb.append("\n");
					break;
				case "size" :
					sb.append(queue.size());
					sb.append("\n");
					break;
				case "empty" :
					sb.append(queue.isEmpty() ? 1 : 0);
					sb.append("\n");
					break;
				case "front" :
					sb.append(queue.isEmpty() ? -1 : queue.getFirst());
					sb.append("\n");
					break;
				case "back" :
					sb.append(queue.isEmpty() ? -1 : queue.getLast());
					sb.append("\n");
				default:
					break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
