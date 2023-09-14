package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 동규는 세수를 하다가 정렬이 하고 싶어졌다.

	정수 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어졌다.
	
	정수 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.

	input			 
	3 1 2
	
	output
	1 2 3
	
	Solution : 1. 정렬 사용

*/

public class BaekJoon_2752 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int t : arr) {
			System.out.print(t + " ");
		}
	}

}
