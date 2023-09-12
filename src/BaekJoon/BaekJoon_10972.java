package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.

	사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.
	
	N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.
	
	1, 2, 3
	1, 3, 2
	2, 1, 3
	2, 3, 1
	3, 1, 2
	3, 2, 1

	input			 
4
1 2 3 4
	
	output
	1 2 4 3
	
	Solution : 1. 완전탐색을 이용한 문제
			   2. 탐색을 하면서 인덱스를 탐지한다.
			   3. 인덱스가 전체와 같으면 -1, 아니면 그대로 값을 반환시킨다.
			   4. 한번은 더 훑어봐야 할 문제!

*/

public class BaekJoon_10972 {

	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(nextPermulation()) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
		} else {
			sb.append(-1);
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean nextPermulation() {
		int index = arr.length - 1;
		
		while(index > 0 && arr[index-1] >= arr[index]) {
			index -= 1;
		}
		
		if(index <= 0) return false;
		
		int i = arr.length - 1;
		
		while(arr[index-1] >= arr[i]) {
			i -= 1;
		}
		
		// swap 진행
		int temp = arr[i];
		arr[i] = arr[index - 1];
		arr[index - 1] = temp;
		
		i = arr.length - 1;
		
		while(index < i) {
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
			index += 1;
			i -= 1;
		}
		
		
		return true;
	}

}
