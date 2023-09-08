package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다. 
	수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.

	배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오. 
	비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다. 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.

	input			 
	4
	2 1 3 1
	
	output
	2 0 3 1
	
	Solution : 1. 정렬을 이용한 문제이다.
			   2. 오름차순 정렬을 했을 경우 변경된 부분의 위치가 어디있는지를 파악하는 문제였다.
	
*/

public class BaekJoon_1015 {

	static class P {
		int idx;
		int val;
		
		public P(int idx, int val) {
			// TODO Auto-generated constructor stub
			this.idx = idx;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<P> list = new ArrayList<P>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			list.add(new P(i, Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				// TODO Auto-generated method stub
				if(o1.val < o2.val) {
					return -1;
				} else if(o1.val > o2.val) {
					return 1;
				} else {
					if(o1.idx < o2.idx) {
						return -1;
					}
					
					return 1;
				}
			}
		});
		
		int[] arr = new int[1001];
		for(int i=0; i<N; i++) {
			arr[list.get(i).idx] = i;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
