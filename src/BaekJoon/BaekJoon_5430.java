package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/*
	Question : 선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

	함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.
	
	함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.
	
	배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

	input			 
	4
	RDD
	4
	[1,2,3,4]
	DD
	1
	[42]
	RRD
	6
	[1,1,2,3,5,8]
	D
	0
	[]
	
	output
	[2,1]
	error
	[1,2,3,5,8]
	error
	
	Solution : 1. deque를 사용하여 reverse 시에는 뒤의 값을, 아닐 시에는 앞의 값을 제거하는 순서로 진행해주면 된다.
			   2. 최종적으로 reverse 상태인 경우에는 뒤에서부터 값을 꺼내주면서 리턴해주면 역순 출력이 가능하다.
	
*/

public class BaekJoon_5430 {

	public static Deque<Integer> queue;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String numArr = br.readLine();
			queue = new LinkedList<Integer>();
			for(String s : numArr.substring(1, numArr.length()-1).split(",")) {
				if(!s.equals("")) {
					queue.add(Integer.valueOf(s));
				}
			}
			
			sb.append(acMethod(command)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static String acMethod(String command) {
		boolean reverse = false;
		StringBuilder sb = new StringBuilder();
		
		for(char comm : command.toCharArray()) {
			if(comm == 'R') {
				reverse = !reverse;
			} else {
				if(queue.size() < 1) return "error";
				
				if(reverse) { // 역순이면 마지막꺼 삭제
					queue.removeLast();
				} else {
					queue.removeFirst();
				}
			}
		}
		
		sb.append("[");
		while(!queue.isEmpty()) {
			sb.append(reverse ? queue.removeLast() : queue.removeFirst());
			if(queue.size() != 0) {
				sb.append(",");
			}
		}
		sb.append("]");
		
		return sb.toString();
	}
}
