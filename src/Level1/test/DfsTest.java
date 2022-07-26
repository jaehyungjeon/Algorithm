package test;

import java.util.Scanner;

public class DfsTest {
	private static int[] arr;
	private static int N;
	private static int count = 0;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		
		arr = new int[N];
		
		// DFS 알고리즘
		nQueens(0);
		System.out.println(count);
	}	
	
	// nQueens Condition
	private static boolean is_possible(int col) {
		for(int i=0; i<col; i++) {
			if(arr[i] == arr[col] || Math.abs(arr[col] - arr[i]) == Math.abs(col - i)) {
				return false;
			}
		}
		return true;
	}
	
	
	// DFS
	private static void nQueens(int depth) {
		if(N == depth) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i+1;
			
			if(is_possible(depth)) {
				nQueens(depth+1);
			}
		}
	}
	
}
