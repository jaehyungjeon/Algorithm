package Level2.LineMethod;

import java.util.*;

/*
 * Question : 
	n���� ����� �Ϸķ� ���� ���� �ֽ��ϴ�. n���� ����鿡�Դ� ���� 1������ n������ ��ȣ�� �Ű��� �ֽ��ϴ�. n���� ����� ���� ���� ����� �������� ����� �ֽ��ϴ�. 
	���� �� 3���� ����� �ִٸ� ������ ���� 6���� ����� �ֽ��ϴ�.

	[1, 2, 3]
	[1, 3, 2]
	[2, 1, 3]
	[2, 3, 1]
	[3, 1, 2]
	[3, 2, 1]
	����� �� n��, �ڿ��� k�� �־��� ��, ����� ���� �ϴ� ����� ���� ������ ���� ���� ��, k��° ����� return�ϴ� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. num = �ִ� ����� �� / idx = answer ��ȯ�� ���� �ε���
 * 			   2. ����Ʈ�� n������ ���� ����
 * 			   3. while���� ����, ������ �´� ����Ʈ ���� ������ -> �ش� �κ��� ������ ���ͳ� ����
 * 			   4. ����Ʈ�� �������鼭 ���� ����
 * 			   5. �������� k�� ��ȯ
 * 
 * */

public class Solution {
	
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
		List<Integer> list = new ArrayList<>();
        long num = 1;
        int idx = 0;
		for(int i=1; i<=n; i++) {
			list.add(i);
			num *= i;
		}
		
        k--;
        while(idx < answer.length) {
        	num /= (n--);
        	int i = (int)(k/num);
        	answer[idx++] = list.get(i);
        	list.remove(i);
        	k %= num;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 3;
		long k = 5;
		System.out.println(sol.solution(n, k));
	}
}