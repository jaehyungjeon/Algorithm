package Level2.BackBiggerNumFind;

import java.util.*;

/*
 * Question : 정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
			  정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 * 
 *  output : 3, 5, 5, -1
 * 
 * 	Solution : 1. 어차피 마지막은 더 큰 수가 없을 것이기에 -1을 붙이면 될 듯
 * 			   2. numbers.length - 1 만큼만 돌리면서 비교하면 될 것 -> 시간초과
 *---------------------------------------------------------------------- 
 *  Solution2 : 1. Stack을 이용
 *  			2. 감소 for문을 이용해 peek값과 비교 -> 크면 break 걸어줌
 *  			3. for문 안에서 for문보다 while문으로 필요한만큼만 돌아야 시간초과 이슈 없음
 *  
 * */

public class Solution {

	public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        // 1. 감소 for문을 이용하여 stack 값 비교
        for(int i=numbers.length-1; i>=0; i--) {
        	while(!stack.isEmpty()) {
        		if(stack.peek() > numbers[i]) {
        			answer[i] = stack.peek();
        			break;
        		} else {
        			stack.pop();
        		}
        	}
        	if(stack.isEmpty()) {
        		answer[i] = -1;
        	}
        	
        	stack.push(numbers[i]);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] numbers = {2, 3, 3, 5};
		System.out.println(sol.solution(numbers));
	}
}