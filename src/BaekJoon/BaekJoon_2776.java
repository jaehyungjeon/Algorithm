package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 연종이는 엄청난 기억력을 가지고 있다. 그래서 하루 동안 본 정수들을 모두 기억 할 수 있다. 하지만 이를 믿을 수 없는 동규는 그의 기억력을 시험해 보기로 한다. 
	동규는 연종을 따라 다니며, 연종이 하루 동안 본 정수들을 모두 ‘수첩1’에 적어 놓았다. 그것을 바탕으로 그가 진짜 암기왕인지 알아보기 위해, 동규는 연종에게 M개의 질문을 던졌다. 
	질문의 내용은 “X라는 정수를 오늘 본 적이 있는가?” 이다. 연종은 막힘없이 모두 대답을 했고, 동규는 연종이 봤다고 주장하는 수 들을 ‘수첩2’에 적어 두었다. 
	집에 돌아온 동규는 답이 맞는지 확인하려 하지만, 연종을 따라다니느라 너무 힘들어서 여러분에게 도움을 요청했다. 
	동규를 도와주기 위해 ‘수첩2’에 적혀있는 순서대로, 각각의 수에 대하여, ‘수첩1’에 있으면 1을, 없으면 0을 출력하는 프로그램을 작성해보자.
	
	input			 
	1
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
	
	Solution : 1. 1920문제와 동일하다. 이분탐색으로 풀어준다.
			   2. 달라진건 TestCase 하나 추가된 것 밖에 없음.

*/

public class BaekJoon_2776 {

	public static int[] arr;
	
	public static void main(String[] args) throws Exception {               
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
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
