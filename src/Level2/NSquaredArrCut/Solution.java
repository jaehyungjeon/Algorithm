package Level2.NSquaredArrCut;

import java.util.*;

/*
 * Question : 
	���� n, left, right�� �־����ϴ�. ���� ������ ���ļ� 1���� �迭�� ������� �մϴ�.

	n�� n�� ũ���� ����ִ� 2���� �迭�� ����ϴ�.
	i = 1, 2, 3, ..., n�� ���ؼ�, ���� ������ �ݺ��մϴ�.
	1�� 1������ i�� i�������� ���� ���� ��� �� ĭ�� ���� i�� ä��ϴ�.
	1��, 2��, ..., n���� �߶󳻾� ��� �̾���� ���ο� 1���� �迭�� ����ϴ�.
	���ο� 1���� �迭�� arr�̶� �� ��, arr[left], arr[left+1], ..., arr[right]�� ����� �������� ����ϴ�.
	���� n, left, right�� �Ű������� �־����ϴ�. �־��� ������� ������� 1���� �迭�� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 *  output : [3,2,2,3]
 * 
 * 	Solution : 1. ������ ������� �ʾҴ��� Ÿ���� ��ȯ���� �ָ� ���� ����
 * 			   2. ��Ŀ��� �ε��� ex) (1,0), (0,1), (1,1) ���� ���� ���� ���Ƿ� row, col �� ���� ū ���� +1�� ���ִ°� ����Ʈ
 * 			   3. for���� left, right��ŭ�� ������ ���� �ٷ� �迭�� ��� ����
 * 
 * */

public class Solution {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        
        int idx = 0;
        for(long i=left; i<=right; i++) {
        	long row = (int) i/n;
        	long col = (int) i%n;
        	answer[idx++] = Math.max((int)row, (int)col) + 1;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 3;
		long left = 2;
		long right = 5;
		System.out.println(sol.solution(n, left, right));
	}
}