package test;

import java.util.Scanner;

public class nQueens {
	
	private static int[] arr;
	private static int N;
	private static int count = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		arr = new int[N];
		
		nQueens(0);
		System.out.println("======= 정보 출력 =======");
		System.out.println(count);
	}
	
	public static boolean is_possible(int col) {
		for(int i=0; i<col; i++) {
			if(arr[col] == arr[i] || Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void nQueens(int depth) {
		if(N == depth) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i;
			
			if(is_possible(depth)) {
				nQueens(depth+1);
			}
		}
	}
}
