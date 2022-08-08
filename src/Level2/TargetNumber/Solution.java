package Level2.TargetNumber;

import java.util.*;

/*
 * Question : 
	n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. DFS/BFS를 이용
 * 			   2. BFS 방식은 조금 더 봐야할듯..
 *   
 * */

public class Solution {
	
	public int count = 0;
	
	public int solution(int[] numbers, int target) {
		/* DFS 이용 */
        dfs(numbers, target, 0, 0);
        
        /* BFS 이용 */
        bfs(numbers, target);
        
        return count;
    }
    
	/* DFS */
	public void dfs(int[] numbers, int target, int depth, int sum) {
		if(depth == numbers.length) {
			if(sum == target) {
				count+=1;
			}
			return;
		}
		
		dfs(numbers, target, depth + 1, sum + numbers[depth]); // 더하기
        dfs(numbers, target, depth + 1, sum - numbers[depth]); // 빼기
	}
	
	/* BFS */
	public int bfs(int[] numbers, int target) {
		Queue<Number> q = new LinkedList<>();
		q.offer(new Number(numbers[0], 0));
		q.offer(new Number(-numbers[0], 0));
		
		while(!q.isEmpty()) {
			Number p = q.poll();
			if(p.index == numbers.length - 1) {
				if(p.sum == target) {
					count+=1;
				}
				continue;
			}
			
			q.add(new Number(p.sum + numbers[p.index + 1], p.index + 1));
			q.add(new Number(p.sum - numbers[p.index + 1], p.index + 1));
		}
		
		return count;
	}
	
	public class Number { // BFS 생성자
		int sum;
		int index;
		
		Number(int sum, int index){
			this.sum = sum;
			this.index = index;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		System.out.println(sol.solution(numbers, target));
	}
}