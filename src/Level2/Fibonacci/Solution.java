package Level2.Fibonacci;

import java.util.*;

/*
 * Question : 
	�Ǻ���ġ ���� F(0) = 0, F(1) = 1�� ��, 1 �̻��� n�� ���Ͽ� F(n) = F(n-1) + F(n-2) �� ����Ǵ� �� �Դϴ�.

	�������
	
	F(2) = F(0) + F(1) = 0 + 1 = 1
	F(3) = F(1) + F(2) = 1 + 1 = 2
	F(4) = F(2) + F(3) = 1 + 2 = 3
	F(5) = F(3) + F(4) = 2 + 3 = 5
	�� ���� �̾����ϴ�.
	
	2 �̻��� n�� �ԷµǾ��� ��, n��° �Ǻ���ġ ���� 1234567���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��� �ּ���.
 * 
 *  output : 2
 * 
 * 	Solution : 1. �迭�� ����Ǯ��
 * 			   2. ��ͷ� Ǯ���� ��� Ÿ�� ����
 * 			   3. for�� �����鼭 �ش� ��ġ�� ���������� �־��ش�. 
 * 
 * */

public class Solution {

    public int solution(int n) {
        int[] answer = new int[n + 1];
        
        for(int i=0; i<=n; i++) {
        	if(i==0) answer[i] = 0;
        	else if(i==1) answer[i] = 1;
        	else {
        		int sum = answer[i-2] + answer[i-1];
        		answer[i] = sum % 1234567;
        	}
        }
        
        return answer[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 5;
		System.out.println(sol.solution(n));
	}
}