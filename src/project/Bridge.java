package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bridge {
	public static int N; // ÀÔ·Â °¹¼ö
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Long a = Long.parseLong(st.nextToken());
			Long b = Long.parseLong(st.nextToken());
			
			long result = 1;
			
			for(int j = 0; j < a; j++) {
				result *= (b - j);
				result /= (j + 1);
			}
			
			System.out.println(result);
		}
		
		System.out.println(sb);
	}
}
