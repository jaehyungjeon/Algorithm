package Map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 숫자 카드는 정수 하나가 적혀져 있는 카드이다.
	상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
	
	input			 
	5
	6 3 2 10 -10
	8
	10 9 -5 2 3 4 5 -10
	
	output
	1 0 0 1 1 0 0 1
	
	Solution : 최초 접근은 배열의 수 만큼 데이터를 받아 비교하는 형식으로 접근하려 했으나, 데이터를 셋팅할수록 시간과 메모리 소요가 커짐
			   출력은 후에 받는 수만큼 도출 되어야 하므로 8개의 수만큼 for문 동작
			   값이 일치할 경우, writer에 1을 추가 아닐경우 0을 추가
			   비교를 어떻게 할 것인가에 관한 의문... -> 오름차순으로 정렬한 후 이진탐색으로 범위를 줄여나가면서 찾는 것이 가장 빠름
			   이진 탐색을 통해 일치 할 경우 true, 일치하지 않을 경우 false 반환
			   t/f에 맞추어 writer에 값 write한다.
*/

public class NumberCard {

	public static int N, M;
	public static int[] cardArr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		cardArr = new int[N];
		
		StringTokenizer sc = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cardArr[i] = Integer.parseInt(sc.nextToken());
		}
		
		Arrays.sort(cardArr); // 오름차순 정렬
		M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(BinarySearch(num)) bw.write("1 ");
			else bw.write("0 ");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		System.out.println(bw);
	}
	
	public static boolean BinarySearch(int num) {
		int start = 0;
		int end = N - 1;
		
		while(start <= end) {
			int center = (start + end) / 2;
			int centerValue = cardArr[center];
			
			if(num < centerValue) {
				end = center - 1;
			} else if(num > centerValue) {
				start = center + 1;
			} else {
				return true;
			}
		}
		
		return false; 
	}
}
