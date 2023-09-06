package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
	Question : 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

	동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
	
	input			 
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
	
	output
	6

	Solution : 1. 큰수부터 나누기를 해주면 최소값이 될 것.
	
*/

public class BaekJoon_11047 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		int price = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 내림차순 정렬
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		
		while(price > 0) {
			for(int t : arr) {
				count += (price / t);
				price %= t;
			}
		}
		
		System.out.println(count);
	}

}
