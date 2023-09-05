package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 올림픽은 참가에 의의가 있기에 공식적으로는 국가간 순위를 정하지 않는다. 
	그러나, 많은 사람들이 자신의 국가가 얼마나 잘 하는지에 관심이 많기 때문에 비공식적으로는 국가간 순위를 정하고 있다. 두 나라가 각각 얻은 금, 은, 동메달 수가 주어지면, 보통 다음 규칙을 따라 어느 나라가 더 잘했는지 결정한다.

	금메달 수가 더 많은 나라 
	금메달 수가 같으면, 은메달 수가 더 많은 나라
	금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라 
	각 국가는 1부터 N 사이의 정수로 표현된다. 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1로 정의된다. 
	만약 두 나라가 금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다. 
	예를 들어, 1번 국가가 금메달 1개, 은메달 1개를 얻었고, 2번 국가와 3번 국가가 모두 은메달 1개를 얻었으며, 
	4번 국가는 메달을 얻지 못하였다면, 1번 국가가 1등, 2번 국가와 3번 국가가 공동 2등, 4번 국가가 4등이 된다. 이 경우 3등은 없다. 
	
	각 국가의 금, 은, 동메달 정보를 입력받아서, 어느 국가가 몇 등을 했는지 알려주는 프로그램을 작성하시오. 

	input			 
	4 3
	1 1 2 0
	2 0 1 0
	3 0 1 0
	4 0 0 1
	
	output
	26
	
	Solution : 1. 먼저 금-은-동 순서대로 정렬을 실시
			   2. 찾고자하는 국가가 위치하는 지점을 탐색
			   3. 중복되는 부분이 있으면 break 후 rank+1 (같은 등수이나 증가가 없기 때문)

*/

public class BaekJoon_8979 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int nation = Integer.parseInt(st.nextToken());
		int dupl = 0;
		int rank = 0;
		int[][] arr = new int[N][4]; // Nation, G, S, B
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // Nation
			arr[i][1] = Integer.parseInt(st.nextToken()); // G
			arr[i][2] = Integer.parseInt(st.nextToken()); // S
			arr[i][3] = Integer.parseInt(st.nextToken()); // B
		}
		
		Arrays.sort(arr, (o1, o2) ->{
			if(o1[1] == o2[1]) { // 금메달이 같을 경우...
				if(o2[2] == o1[2]) { // 은메달이 같을 경우..
					return o2[3] - o1[3];
				}
				return o2[2] - o1[2];
			}
			return o2[1] - o1[1];
		});
		
		for(int i=0; i<N; i++) {
			if(arr[i][0] == nation) {
				dupl = i;
				break;
			}
		}
		
		for(int i=N-1; i>0; i--) {
			if(arr[i][1] == arr[dupl][1] && arr[i][2] == arr[dupl][2] && arr[i][3] == arr[dupl][3]) {
				break;
			}
			rank++;
		}
		
		System.out.println(rank+1);
	}

}
