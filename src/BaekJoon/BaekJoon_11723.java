package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

	add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
	remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
	check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
	toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
	all: S를 {1, 2, ..., 20} 으로 바꾼다.
	empty: S를 공집합으로 바꾼다.
	 	
	input			 
	26
	add 1
	add 2
	check 1
	check 2
	check 3
	remove 2
	check 1
	check 2
	toggle 3
	check 1
	check 2
	check 3
	check 4
	all
	check 10
	check 20
	toggle 10
	remove 20
	check 10
	check 20
	empty
	check 1
	toggle 1
	check 1
	toggle 1
	check 1
	
	output
	1
	1
	0
	1
	0
	1
	0
	1
	0
	1
	1
	0
	0
	0
	1
	0
	
	Solution : 1. Integer 배열을 활용하여 해당 인덱스에 값을 넣는 방식으로 사용하였다.
			   2. 해당 배열의 인덱스의 값이 null일 경우와 아닐 경우를 기준으로 잡았다.
	
*/

public class BaekJoon_11723 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[21];
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			int num = 0;
			if(!command.equals("all") && !command.equals("empty")) { 
				num = Integer.parseInt(st.nextToken());
			}
			
			switch (command) {
				case "add" : 
					if(arr[num] == null) arr[num] = num;
					break;
				case "remove" : 
					if(arr[num] != null) arr[num] = null;
					break;
				case "check" :
					if(arr[num] != null) sb.append(1);
					else sb.append(0);
					sb.append("\n");
					break;
				case "toggle" :
					if(arr[num] == null) arr[num] = num;
					else if(arr[num] != null) arr[num] = null;
					break;
				case "all" :
					for(int i=1; i<=arr.length-1; i++) {
						arr[i] = i;
					}
					break;
				case "empty" :
					for(int i=1; i<=arr.length-1; i++) {
						arr[i] = null;
					}
					break;
				default:
					break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
