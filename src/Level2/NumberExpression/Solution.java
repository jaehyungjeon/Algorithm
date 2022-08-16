package Level2.NumberExpression;

import java.util.*;

/*
 * Question : 
	Finn�� ���� ���а��ο� ���� �ֽ��ϴ�. ���� ���θ� �ϴ� Finn�� �ڿ��� n�� ������ �ڿ������ ǥ�� �ϴ� ����� ��������� ����� �˰� �Ǿ����ϴ�. ������� 15�� ������ ���� 4������ ǥ�� �� �� �ֽ��ϴ�.

	1 + 2 + 3 + 4 + 5 = 15
	4 + 5 + 6 = 15
	7 + 8 = 15
	15 = 15
	�ڿ��� n�� �Ű������� �־��� ��, ���ӵ� �ڿ������ n�� ǥ���ϴ� ����� ���� return�ϴ� solution�� �ϼ����ּ���.
 * 
 * 	Solution : 1. �հ� ���� ���� ���ӵ� ������ ���� ���ؼ� 15�̸� break��Ű�°� ����Ʈ
 * 			   2. ���� for���� sum�� 0���� �ʱ�ȭ �ϸ鼭 ���ۼ����ϱ� ���� for
 * 			   3. �ι�° for���� ���� �� ��� �� ��
 * 
 * 
 * */

public class Solution {

    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
        	int sum = 0;
        	for(int j=i; j<=n; j++) {
        		sum += j;
        		if(sum >= n) {
        			if(sum == n) answer++;
        			break;
        		}
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 15;
		System.out.println(sol.solution(n));
	}
}