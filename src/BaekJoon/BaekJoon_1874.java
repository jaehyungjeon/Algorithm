package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
	Question : 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
	스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

	1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
	임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
	이를 계산하는 프로그램을 작성하라.
		
	input			 
	8
	4
	3
	6
	8
	7
	5
	2
	1
	
	output
	+
	+
	+
	+
	-
	-
	+
	+
	-
	+
	+
	-
	-
	-
	-
	-
	
	Solution : 1. 스택에서 push를 하고 스택의 peek값과 같으면 pop
			   2. 그렇지 않으면 인덱스를 계속 넣어줌.
			   3. 최종적으로 peek값과 일치하지 않으면 NO

*/

public class BaekJoon_1874 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		boolean check = true;
		int idx = 1;
		
		for(int i=0; i<N; i++) {
			int K = Integer.parseInt(br.readLine());
			
			for(; idx<=K; idx++) {
				stack.push(idx);
				sb.append("+").append("\n");
			}
			
			if(stack.peek() == K) {
				stack.pop();
				sb.append("-").append("\n");
			} else {
				check = false;
			}
		}
		
		if(!check) {
			System.out.println("NO");
		} else {
			System.out.println(sb.toString());
		}

	}

}
