package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSBufferReader {

	public static int[] arr;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder(); // ¿¬¼ÓµÈ String Insert
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		//DFS
		DFS(1, 0);
		System.out.print(sb);
	}
	
	public static void DFS(int at, int depth) {
		if(M == depth) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i=at; i<=N; i++) {
			arr[depth] = i;
			
			DFS(i+1, depth+1);
		}
	}
}
