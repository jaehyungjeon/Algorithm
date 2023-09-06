package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
	Question : 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

	명령은 총 다섯 가지이다.
	
	push X: 정수 X를 스택에 넣는 연산이다.
	pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	size: 스택에 들어있는 정수의 개수를 출력한다.
	empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

	input			 
	14
	push 1
	push 2
	top
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
	top
	
	output
	2
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
	
	Solution : 1. Stack의 개념을 묻는 문제. 단순하다.
	
*/

public class BaekJoon_10828 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch (command) {
				case "push" :
					int value = Integer.parseInt(st.nextToken());
					stack.push(value);
					break;
				case "top" :
					sb.append(stack.isEmpty() ? -1 : stack.peek());
					break;
				case "size" :
					sb.append(stack.size());
					break;
				case "empty" :
					sb.append(stack.isEmpty() ? 1 : 0);
					break;
				case "pop" :
					sb.append(stack.isEmpty() ? -1 : stack.pop());
					break;
				default:
					break;
			}
			
			if(!command.equals("push")) {
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
