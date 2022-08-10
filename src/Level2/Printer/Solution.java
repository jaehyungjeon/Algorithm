package Level2.Printer;

import java.util.*;

/*
 * Question : 
	�Ϲ����� �����ʹ� �μ� ��û�� ���� ������� �μ��մϴ�. �׷��� ������ �߿��� ������ ���߿� �μ�� �� �ֽ��ϴ�. 
	�̷� ������ �����ϱ� ���� �߿䵵�� ���� ������ ���� �μ��ϴ� �����͸� �����߽��ϴ�. �� ���Ӱ� ������ �����ʹ� �Ʒ��� ���� ������� �μ� �۾��� �����մϴ�.
	
	1. �μ� ������� ���� �տ� �ִ� ����(J)�� ����Ͽ��� �����ϴ�.
	2. ������ �μ� ����Ͽ��� J���� �߿䵵�� ���� ������ �� ���� �����ϸ� J�� ������� ���� �������� �ֽ��ϴ�.
	3. �׷��� ������ J�� �μ��մϴ�.
	���� ���, 4���� ����(A, B, C, D)�� ������� �μ� ����Ͽ� �ְ� �߿䵵�� 2 1 3 2 ��� C D A B ������ �μ��ϰ� �˴ϴ�.
	
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� �˰� �ͽ��ϴ�. ���� ������ C�� 1��°��, A�� 3��°�� �μ�˴ϴ�.
	
	���� ����Ͽ� �ִ� ������ �߿䵵�� ������� ��� �迭 priorities�� ���� �μ⸦ ��û�� ������ ���� ������� � ��ġ�� �ִ����� �˷��ִ� location�� �Ű������� �־��� ��, 
	���� �μ⸦ ��û�� ������ �� ��°�� �μ�Ǵ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. �켱���� ť�� ��Ƽ� �켱������ �����ͺ��� �ִ´�. (reverseOrder)
 * 			   2. ť�� �ִ񰪰� �켱������ ���� ����, ��ġ�� ������ �״�� ����
 * 			   3. ����ؼ� poll��Ų��.
 * 
 * */

public class Solution {
	
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int val : priorities) {
        	queue.offer(val);
        }
        
        while(!queue.isEmpty()) {
        	for(int i=0; i<priorities.length; i++) {
        		if(priorities[i] == queue.peek()) {
        			if(location == i) {
        				return answer;
        			}
        			answer++;
        			queue.poll();
        		}
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(sol.solution(priorities, location));
	}
}