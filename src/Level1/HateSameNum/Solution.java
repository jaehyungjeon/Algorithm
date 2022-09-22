package Level1.HateSameNum;

import java.util.*;

/*
 * Question : 
	배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
	이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
	단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
	
	arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
	arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
	배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 * 
 * 	Solution : 1. 스택을 하나 만들어주고 첫번재에는 arr[0]을 넣어줌
 * 			   2. for문 돌면서 같지 않을 때, stack에 값을 주입해줌
 * 			   3. 들어온 스택 값을 arr로 변환
 * 
 * */

public class Solution {

	public Stack<Integer> stack = new Stack<Integer>();
	
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        stack.push(arr[0]);
        for(int i=0; i<arr.length; i++) {
			if(!stack.peek().equals(arr[i])) {
				stack.push(arr[i]);	
			}
        }
        
        answer = stack.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {1, 1, 3, 3, 0, 1, 1};
		System.out.println(sol.solution(arr));
	}
}
