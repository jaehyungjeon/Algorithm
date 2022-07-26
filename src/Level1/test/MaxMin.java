package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MaxMin {
	
	private static List<Integer> arr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		while(st.hasMoreElements()) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int max = 0;
		int index = 0;
		if(!arr.isEmpty()) {
			for(int i=0; i<arr.size(); i++) {
				if(arr.get(i) > max) {
					max = arr.get(i);
					index = (i+1);
				}
			}
		}
		
		System.out.println("max : " + max);
		System.out.println("index : " + index);
	}
}
