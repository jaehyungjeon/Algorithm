package Level2.ExpectDraw;

import java.util.*;

/*
 * Question : 
	△△ 게임대회가 개최되었습니다. 이 대회는 N명이 참가하고, 토너먼트 형식으로 진행됩니다. N명의 참가자는 각각 1부터 N번을 차례대로 배정받습니다. 
	그리고, 1번↔2번, 3번↔4번, ... , N-1번↔N번의 참가자끼리 게임을 진행합니다. 각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다. 
	이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다. 
	만약 1번↔2번 끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고, 3번↔4번에서 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다. 게임은 최종 한 명이 남을 때까지 진행됩니다.

	이때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다. 
	게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 
	처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요. 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
 * 
 *  output : 3
 * 
 * 	Solution : 1. 1-2 / 3-A / 5-6 / B-8 : 1라운드
 * 			   2. 1-A / 6-B : 2라운드
 * 			   3. A-B : 3라운드 -> return 3
 * 			   4. 2로 나눈 몫 + 2로 나눈 나머지 -> 현재의 포지션을 구함
 * 			   5. 같아지는 경우 만나는 지점
 * 
 * */

public class Solution {

    public int solution(int n, int a, int b) {
        int answer = 0;
        
        while(true) {
        	a = a/2 + a%2;
        	b = b/2 + b%2;
        	answer++;
        	if(a==b) {
        		break;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println(sol.solution(n, a, b));
	}
}