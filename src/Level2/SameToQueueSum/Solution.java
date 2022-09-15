package Level2.SameToQueueSum;

import java.util.*;

/*
 * Question : 
	���̰� ���� �� ���� ť�� �־����ϴ�. �ϳ��� ť�� ��� ���Ҹ� ����(pop)�ϰ�, ����� ���Ҹ� �ٸ� ť�� ����ִ�(insert) �۾��� ���� �� ť�� ���� ���� ������ ������� �մϴ�. 
	�̶� �ʿ��� �۾��� �ּ� Ƚ���� ���ϰ��� �մϴ�. �� ���� pop�� �� ���� insert�� ���ļ� �۾��� 1ȸ ������ ������ �����մϴ�.

	ť�� ���� ������� ���Ұ� ���� ������ �����Դϴ�. �� ���������� ť�� �迭�� ǥ���ϸ�, ���Ұ� �迭 ���ʿ� �������� ���� ������� �������� �ǹ��մϴ�. 
	��, pop�� �ϸ� �迭�� ù ��° ���Ұ� ����Ǹ�, insert�� �ϸ� �迭�� ���� ���Ұ� �߰��˴ϴ�. ���� ��� ť [1, 2, 3, 4]�� �־����� ��, pop�� �ϸ� �� �տ� �ִ� ���� 1�� ����Ǿ� [2, 3, 4]�� �Ǹ�, �̾ 5�� insert�ϸ� [2, 3, 4, 5]�� �˴ϴ�.
	
	������ �� ť�� ��Ÿ���� �����Դϴ�.
	
	queue1 = [3, 2, 7, 2]
	queue2 = [4, 6, 5, 1]
	�� ť�� ��� ��� ������ ���� 30�Դϴ�. ����, �� ť�� ���� 15�� ������ �մϴ�. ���� ���, ������ ���� 2���� ����� �ֽ��ϴ�.
	
	queue2�� 4, 6, 5�� ������� �����Ͽ� queue1�� �߰��� ��, queue1�� 3, 2, 7, 2�� ������� �����Ͽ� queue2�� �߰��մϴ�. 
	�� ��� queue1�� [4, 6, 5], queue2�� [1, 3, 2, 7, 2]�� �Ǹ�, �� ť�� ���� ���� 15�� �����ϴ�. �� ����� �۾��� 7�� �����մϴ�.
	queue1���� 3�� �����Ͽ� queue2�� �߰��մϴ�. �׸��� queue2���� 4�� �����Ͽ� queue1�� �߰��մϴ�. 
	�� ��� queue1�� [2, 7, 2, 4], queue2�� [6, 5, 1, 3]�� �Ǹ�, �� ť�� ���� ���� 15�� �����ϴ�. �� ����� �۾��� 2���� �����ϸ�, �̺��� ���� Ƚ���� ��ǥ�� �޼��� �� �����ϴ�.
	���� �� ť�� ���� ���� ���� ����� ���� �ʿ��� �۾��� �ּ� Ƚ���� 2�Դϴ�.
	
	���̰� ���� �� ���� ť�� ��Ÿ���� ���� �迭 queue1, queue2�� �Ű������� �־����ϴ�. 
	�� ť�� ���� ���� ���� ����� ���� �ʿ��� �۾��� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ϼ����ּ���. ��, � ������ε� �� ť�� ���� ���� ���� ���� �� ���� ���, -1�� return ���ּ���.
 * 
 *  output : 2
 * 
 * 	Solution : 1. queue1�� queue2�� Sum�� ���� ���ϰ� �� �հ踦 ���س����� �ȴ�.
 * 			   2. �� ���� ���� ������ ���ϸ�, ���� �� �������� return -1�� ���ش�. -> return�� ���� ������ �ӵ��� ������
 * 			   3. �� ���� ���Ͽ� Ŭ ��쿡�� ū������ ���������� ���� ������Ų��.
 * 
 * */

public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        
        for(int val : queue1) {
        	q1Sum += val;
        	q1.add(val);
        }
        
        for(int val : queue2) {
        	q2Sum += val;
        	q2.add(val);
        }
        
        while(q1Sum != q2Sum) {
        	answer++;
        	
        	if(q1Sum < q2Sum) {
        		q1Sum += q2.peek();
        		q2Sum -= q2.peek();
        		q1.add(q2.poll());
        	} else if(q2Sum < q1Sum) {
        		q2Sum += q1.peek();
        		q1Sum -= q1.peek();
        		q2.add(q1.poll());
        	}
        	
        	if(answer > (queue1.length + queue2.length) * 2) return -1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] queue1= {1, 2, 1, 2};
		int[] queue2= {1, 10, 1, 2};
		System.out.println(sol.solution(queue1, queue2));
	}
}