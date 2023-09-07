package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 김지민은 N명이 참가하는 스타 토너먼트에 진출했다. 토너먼트는 다음과 같이 진행된다. 일단 N명의 참가자는 번호가 1번부터 N번까지 배정받는다. 
	그러고 난 후에 서로 인접한 번호끼리 스타를 한다. 이긴 사람은 다음 라운드에 진출하고, 진 사람은 그 라운드에서 떨어진다. 
	만약 그 라운드의 참가자가 홀수명이라면, 마지막 번호를 가진 참가자는 다음 라운드로 자동 진출한다. 
	다음 라운드에선 다시 참가자의 번호를 1번부터 매긴다. 이때, 번호를 매기는 순서는 처음 번호의 순서를 유지하면서 1번부터 매긴다. 
	이 말은 1번과 2번이 스타를 해서 1번이 진출하고, 3번과 4번이 스타를 해서 4번이 진출했다면, 4번은 다음 라운드에서 번호 2번을 배정받는다. 
	번호를 다시 배정받은 후에 한 명만 남을 때까지 라운드를 계속 한다.

	마침 이 스타 대회에 임한수도 참가했다. 김지민은 갑자기 스타 대회에서 우승하는 욕심은 없어지고, 몇 라운드에서 임한수와 대결하는지 궁금해졌다. 
	일단 김지민과 임한수는 서로 대결하기 전까지 항상 이긴다고 가정한다. 1 라운드에서 김지민의 번호와 임한수의 번호가 주어질 때, 과연 김지민과 임한수가 몇 라운드에서 대결하는지 출력하는 프로그램을 작성하시오.

	input			 
	16 1 2
	
	output
	1
	
	Solution : 1. N/2 + N%2 한 값이 같아질 경우 라운드가 동일한 것이다.
			   2. 출력되지 않는 케이스는 범위 내에서는 찾을 수 없으나 N, M이 라운드보다 큰 수를 넣었을 경우 출력 불가로 판정하였다.
	
*/

public class BaekJoon_1057 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int round = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N > round || M > round) { // 둘 중 하나가 라운드보다 커지면 출력 불가.
			System.out.println(-1);
			
			System.exit(0);
		} else {
			int count = 0;
			while(N != M) {
				N = N/2 + N%2;
				M = M/2 + M%2;
				count++;
			}
			
			System.out.println(count);
		}
		
	}

}
