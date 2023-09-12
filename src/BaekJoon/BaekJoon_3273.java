package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다. 
	자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
	
	input			 
	9
	5 12 7 10 9 1 2 3 11
	13
	
	output
	3
	
	Solution : 1. 당연하게도 for문을 2번 돌리면 시간초과 에러가 발생한다.
			   2. 점진적으로 start와 end를 감소시키는 방법으로 카운트를 추출한다.
			   3. 배열의 쌍이므로 결국 유클리드 호재법을 통해 구하는게 제일 이상적이다.

*/

public class BaekJoon_3273 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int x = Integer.parseInt(br.readLine());
		
		int count = 0;
		int start = 0;
		int end = N-1;
		
		while(start < end) {
			if(arr[start] + arr[end] == x) {
				count++;
				start++;
				end--;
			} else if(arr[start] + arr[end] < x) {
				start++;
			} else {
				end--;
			}
		}
		
		System.out.println(count);
	}
}
