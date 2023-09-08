package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 학교에서 그래픽스 수업을 들은 동준이는 수업시간에 들은 내용을 바탕으로 스마트폰 게임을 만들었다. 
	게임에는 총 N개의 레벨이 있고, 각 레벨을 클리어할 때 마다 점수가 주어진다. 플레이어의 점수는 레벨을 클리어하면서 얻은 점수의 합으로, 이 점수를 바탕으로 온라인 순위를 매긴다. 
	동준이는 레벨을 난이도 순으로 배치했다. 하지만, 실수로 쉬운 레벨이 어려운 레벨보다 점수를 많이 받는 경우를 만들었다.

	이 문제를 해결하기 위해 동준이는 특정 레벨의 점수를 감소시키려고 한다. 이렇게해서 각 레벨을 클리어할 때 주는 점수가 증가하게 만들려고 한다.
	
	각 레벨을 클리어할 때 얻는 점수가 주어졌을 때, 몇 번 감소시키면 되는지 구하는 프로그램을 작성하시오. 점수는 항상 양수이어야 하고, 1만큼 감소시키는 것이 1번이다. 
	항상 답이 존재하는 경우만 주어진다. 정답이 여러 가지인 경우에는 점수를 내리는 것을 최소한으로 하는 방법을 찾아야 한다.

	input			 
	4
	5
	3
	7
	5
	
	output
	6
	
	Solution : 1. 점수를 내리는 것의 최소를 찾기 위해서는 뒤에서 부터 비교하여 diff를 계산해주는 방법이 최선이다.
			   2. 순서대로 정렬을 해주기 위해서 뒤의 배열의 차를 구한 뒤 + 1을 해주어 이전 숫자보다 -1이 되게끔 유지시켜 나간다.
			   3. diff의 합을 누산한 뒤 리턴한다.
	
*/

public class BaekJoon_2847 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int count = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-2; i >=0; i--) {
			if(arr[i] >= arr[i+1]) {
				int diff = arr[i] - arr[i+1] + 1;
				count += diff;
				arr[i] -= diff;
			}
		}
		
		System.out.println(count);
		
	}

}
