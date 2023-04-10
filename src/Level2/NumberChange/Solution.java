package Level2.NumberChange;

import java.util.*;

/*
 * Question : 
	�ڿ��� x�� y�� ��ȯ�Ϸ��� �մϴ�. ����� �� �ִ� ������ ������ �����ϴ�.

	x�� n�� ���մϴ�
	x�� 2�� ���մϴ�.
	x�� 3�� ���մϴ�.
	�ڿ��� x, y, n�� �Ű������� �־��� ��, x�� y�� ��ȯ�ϱ� ���� �ʿ��� �ּ� ���� Ƚ���� return�ϵ��� solution �Լ��� �ϼ����ּ���. 
	�̶� x�� y�� ���� �� ���ٸ� -1�� return ���ּ���.
 * 
 * 
 * 	Solution : 1. Queue�� HashSet�� �̿�
 * 			   2. x + n / x * 2 / x * y �� �������� Queue�� HashSet�� ��� �ߺ� ���� �� �� ��
 * 			   3. ť�� peek���� y�� ���� ��� ����
 * 			   4. ���� ���ϵǱ� ������ ī��Ʈ ����
 * ---------------------------------------------------------------
 *  Solution : 1. DP�� �̿� -> �Ϸ� �� �ش� ������ �迭�� ���� ����
 * 			   2. ���� ���Ͽ� ���� �ּ��� ���� ���� ����
 * 			    
 * */

public class Solution {
	 
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        q.offer(x);
        
        while(!q.isEmpty()) {
        	for(int i=0; i<q.size(); i++) {
        		if(q.peek() == y) {
        			return answer;
        		}
        		method(q.poll(), y, n, q, set);
        	}
        	answer++;
        }
        
        return -1;
//        return dpMethod(x, y, n);
    }
    
    // 1. Queue�� �̿��� ���
    public void method(int num, int y, int n, Queue<Integer> q, HashSet<Integer> set) {
    	if(num+n <= y && !set.contains(num+n)) {
    		set.add(num+n);
    		q.offer(num+n);
    	}
    	if(num*2 <= y && !set.contains(num*2)) {
    		set.add(num*2);
    		q.offer(num*2);
    	}
    	if(num*3 <= y && !set.contains(num*3)) {
    		set.add(num*3);
    		q.offer(num*3);
    	}
    }

    // 2. dp�� �̿��� ���
    public int dpMethod(int x, int y, int n) {
    	int[] dp = new int[y+1];
    	
        for(int i=x; i<y+1; i++) {
        	if(i != x && dp[i] == 0) {
        		dp[i] = -1;
        		continue;
        	}
        	
        	if(i+n <= y) {
        		dp[i+n] = (dp[i+n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i+n]); 
        	}
        	
        	if(i*2 <= y) {
        		dp[i*2] = (dp[i*2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i*2]); 
        	}
        	
        	if(i*3 <= y) {
        		dp[i*3] = (dp[i*3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i*3]); 
        	}
        }
        
        return dp[y];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int x = 10;
		int y = 40;
		int n = 5;
		System.out.println(sol.solution(x, y, n));
	}
}