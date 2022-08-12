package Level2.StockPrice;

import java.util.*;

/*
 * Question : 
	�� ������ ��ϵ� �ֽİ����� ��� �迭 prices�� �Ű������� �־��� ��, ������ �������� ���� �Ⱓ�� �� �������� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * 
 * 	Solution : 1. Stack�� �̿��� ����
 * 			   2. ���ÿ� ������ִ� peek ���� ���ϴ� ���� ���Ͽ� Ŭ ���, 1��
 * 			   3. �������� ���ÿ� ��� ����� �迭�� �־��ش�.
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