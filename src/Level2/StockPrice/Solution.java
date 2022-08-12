package Level2.StockPrice;

import java.util.*;

/*
 * Question : 
	초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 
 * 	Solution : 1. Stack을 이용한 구현
 * 			   2. 스택에 담겨져있는 peek 값이 비교하는 값과 비교하여 클 경우, 1초
 * 			   3. 나머지는 스택에 담긴 값대로 배열에 넣어준다.
 * 
 * */

public class Solution {

    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<prices.length; i++) {
        	while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
        		int idx = stack.pop();
        	   	answer[idx] = i - idx;
        	}
        	stack.push(i);
        }
        
        while(!stack.isEmpty()) {
        	int i = stack.pop();
        	answer[i] = prices.length - i - 1;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(sol.solution(prices));
	}
}