package Level2.NumberExpression;

import java.util.*;

/*
 * Question : 
	Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다. 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.

	1 + 2 + 3 + 4 + 5 = 15
	4 + 5 + 6 = 15
	7 + 8 = 15
	15 = 15
	자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 * 
 * 	Solution : 1. 합계 변수 놓고 연속된 숫자의 합을 구해서 15이면 break시키는게 포인트
 * 			   2. 최초 for문은 sum을 0으로 초기화 하면서 동작수행하기 위한 for
 * 			   3. 두번째 for문이 실제 값 계산 후 비교
 * 
 * 
 * */

public class Solution {

    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	int sum = 0;
        	for(int j=i; j<=n; j++) {
        		sum += j;
        		if(sum >= n) {
        			if(sum == n) answer++;
        			break;
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 15;
		System.out.println(sol.solution(n));
	}
}