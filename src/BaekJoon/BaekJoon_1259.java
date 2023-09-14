package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
	Question : 어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.

	수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 
	123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 
	또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.

	input			 
	121
	1231
	12421
	0
	
	output
	yes
	no
	yes
	
	Solution : 1. DeQue쓰면 쉬울거같아서 사용하여 풀었다.

*/

public class BaekJoon_1259 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			else {
				Deque<Character> queue = new LinkedList<Character>();
				for(Character s : str.toCharArray()) {
					queue.add(s);
				}
				
				if(pelindrome(queue)) {
					sb.append("yes");
				} else {
					sb.append("no");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean pelindrome(Deque<Character> queue) {
		while(!queue.isEmpty()) {
			if(queue.size() > 1) {
				if(queue.getFirst().equals(queue.getLast())) {
					queue.removeFirst();
					queue.removeLast();
				} else if(!queue.getFirst().equals(queue.getLast())) {
					return false;
				}
			} else {
				return true;
			}
		}
		return true;
	}

}
