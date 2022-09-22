package Level1.LackMoneyCal;

import java.util.*;

/*
 * Question : 
	새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 
	이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다.
	즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
	놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
	단, 금액이 부족하지 않으면 0을 return 하세요.
	
 * 
 * 	Solution : 1. 풀이 자체는 어렵지 않았으나, 리턴이 long 타입이라는 점을 감안하여 코딩을 하였어야 함.
 * 			   2. 전체를 담는 변수를 int로 할 경우 long타입 변수와 비교가 상이할 수 있기 때문에 long으로 선언하여 계산값 넣어 사용해야 함.
 * 
 * */

public class Solution {

    public long solution(int price, int money, int count) {
        long answer = 0;

        long tot = 0;
        for(int i=1; i<=count; i++) {
        	tot += (price * i);
        }
        
        if(tot > money) answer = tot - money;
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int price = 3;
    	int money = 20;
    	int count = 4;
		System.out.println(sol.solution(price, money, count));
	}
}
