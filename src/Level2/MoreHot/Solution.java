package Level2.MoreHot;

import java.util.*;

/*
 * Question : 
	�ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. 
	��� ������ ���ں� ������ K �̻����� ����� ���� Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.
	���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
	Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
	Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, ��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 	output : 2
 * 
 * 	Solution : 1. �켱���� ť�� �̿��Ͽ� ������ �迭�� ������� ��´�.
 * 			   2. poll�� ���� ������� ������, ��������� ���� ��� return -1�� ���ش�. (answer = -1 �� �� ���, ��Ÿ�� ������ ��)
 * 			   3. ���İ��� ť�� offer��Ų��.
 * 			   4. �ᱣ�� return
 *   
 * */

public class Solution {
	
	public Queue<Integer> q = new PriorityQueue<Integer>();
	
	public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int val : scoville) {
        	q.offer(val);
        }
        
        while(q.peek() <= K) {
        	if(q.size() <= 1) {
        		return -1;
        	}
        	
        	q.offer(q.poll() + (q.poll() * 2));
        	answer++;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(sol.solution(scoville, K));
	}
}