package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.

	이 아파트에 거주를 하려면 조건이 있는데, “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.

	아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 
	단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.

	input			 
2
1
3
2
3
	
	output
	6
	10
	
	Solution : 1. 구하고자 하는 인덱스의 밑의 행의 같은 열과 같은 행의 이전 열을 합한 값이 최종 위치한 값이다.
			   2. 알고 접근하면 굉장히 쉬운 문제.
	
*/

public class BaekJoon_2775 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int floor = Integer.parseInt(br.readLine());
			int room = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[floor+1][room+1];
			for(int j=0; j<=floor; j++) {
				arr[j][1] = 1;
				for(int k=2; k<=room; k++) {
					if(j==0) {
						arr[j][k] = arr[j][k-1]+1;
					} else {
						arr[j][k] = arr[j-1][k] + arr[j][k-1];
					}
				}
			}
			
			System.out.println(arr[floor][room]);
		}
	}

}
