package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
	
	input			 
	5
	4 1 5 2 3
	5
	1 3 7 9 5
		
	output
	1
	1
	0
	0
	1

	Solution : 1. 그냥 탐색하면 당연히 시간초과가 나올 것이다. 따라서, 이분탐색을 실시해준다.
			   2. 탐색 할 때, 당연히 배열은 오름차순 sort해야 한다.
	
*/

public class BaekJoon_1920 {

	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	public static int binarySearch(int key) {
		int lo = 0;
		int hi = arr.length - 1;
 
		while(lo <= hi) {
			int mid = (lo + hi) / 2; // 중간에서 쪼개기
			if(key < arr[mid]) {
				hi = mid - 1;
			} else if(key > arr[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
 
		return -1;
	}
}
