package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 스네이크버드는 뱀과 새의 모습을 닮은 귀여운 생물체입니다. 
	스네이크버드의 주요 먹이는 과일이며 과일 하나를 먹으면 길이가 1만큼 늘어납니다.
	과일들은 지상으로부터 일정 높이를 두고 떨어져 있으며 i (1 ≤ i ≤ N) 번째 과일의 높이는 hi입니다. 
	스네이크버드는 자신의 길이보다 작거나 같은 높이에 있는 과일들을 먹을 수 있습니다.
	스네이크버드의 처음 길이가 L일때 과일들을 먹어 늘릴 수 있는 최대 길이를 구하세요.

	input			 
	3 10
	10 11 13
	
	output
	12
	
	Solution : 1. 먹을 과일을 오름차순하여 정렬하는게 포인트였다.
			   2. 그리디 알고리즘을 이용하여 계속 탐색하면서 값이 num보다 크면 break 시켜주면 된다.
	
*/

public class BaekJoon_16435 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			if(arr[i] > num) break;
			num++;
		}
		
		System.out.println(num);
	}

}
