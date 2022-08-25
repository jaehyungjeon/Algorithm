package Level2.LongJump;

import java.util.*;

/*
 * Question : 
	ȿ���̴� �ָ� �ٱ⸦ �����ϰ� �ֽ��ϴ�. ȿ���̴� �ѹ��� 1ĭ, �Ǵ� 2ĭ�� �� �� �ֽ��ϴ�. ĭ�� �� 4�� ���� ��, ȿ���̴�
	(1ĭ, 1ĭ, 1ĭ, 1ĭ)
	(1ĭ, 2ĭ, 1ĭ)
	(1ĭ, 1ĭ, 2ĭ)
	(2ĭ, 1ĭ, 1ĭ)
	(2ĭ, 2ĭ)
	�� 5���� ������� �� �� ĭ�� ������ �� �ֽ��ϴ�. �ָ��ٱ⿡ ���� ĭ�� �� n�� �־��� ��, ȿ���̰� ���� �����ϴ� ����� �� �������� �˾Ƴ�, 
	���⿡ 1234567�� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. ���� ��� 4�� �Էµȴٸ�, 5�� return�ϸ� �˴ϴ�.
 * 
 * 
 * 	Solution : 1. DP�� �̿��ϴ� ���� -> ���� ���� �տ� �־���
 * 			   2. max ������ŭ ���������� �������� �������� ���� �־��ָ� ��
 * 			   3. ���� �迭�� ���� ������ ���Ӽ��� �������شٴ� ���� ���.
 * 
 * */

public class Solution {
	
    public long solution(int n) {
        int[] answer = new int[2001];
        answer[1] = 1;
        answer[2] = 2;
        
        for(int i=3; i<2001; i++) {
        	answer[i] = (answer[i-2] + answer[i-1]) % 1234567;
        }
        
        return answer[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}