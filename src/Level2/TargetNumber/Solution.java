package Level2.TargetNumber;

import java.util.*;

/*
 * Question : 
	n���� ���� �ƴ� �������� �ֽ��ϴ�. �� �������� ������ �ٲ��� �ʰ� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�. ���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.
	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3
	����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־��� �� ���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. DFS/BFS�� �̿�
 * 			   2. BFS ����� ���� �� �����ҵ�..
 *   
 * */

public class Solution {
	
	public int count = 0;
	
	public int solution(int[] numbers, int target) {
		/* DFS �̿� */
        dfs(numbers, target, 0, 0);
        
        /* BFS �̿� */
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
		
		dfs(numbers, target, depth + 1, sum + numbers[depth]); // ���ϱ�
        dfs(numbers, target, depth + 1, sum - numbers[depth]); // ����
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
	
	public class Number { // BFS ������
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