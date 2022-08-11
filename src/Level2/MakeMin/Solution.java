package Level2.MakeMin;

import java.util.*;

/*
 * Question : 
	���̰� ���� �迭 A, B �ΰ��� �ֽ��ϴ�. �� �迭�� �ڿ����� �̷���� �ֽ��ϴ�.
	�迭 A, B���� ���� �� ���� ���ڸ� �̾� �� ���� ���մϴ�. �̷��� ������ �迭�� ���̸�ŭ �ݺ��ϸ�, �� ���� ���� ���� �����Ͽ� ���մϴ�. 
	�̶� ���������� ������ ���� �ּҰ� �ǵ��� ����� ���� ��ǥ�Դϴ�. (��, �� �迭���� k��° ���ڸ� �̾Ҵٸ� ������ k��° ���ڴ� �ٽ� ���� �� �����ϴ�.)
	
	���� ��� A = [1, 4, 2] , B = [5, 4, 4] ���
	
	A���� ù��° ������ 1, B���� ù��° ������ 5�� �̾� ���Ͽ� ���մϴ�. (������ �� : 0 + 5(1x5) = 5)
	A���� �ι�° ������ 4, B���� ����° ������ 4�� �̾� ���Ͽ� ���մϴ�. (������ �� : 5 + 16(4x4) = 21)
	A���� ����° ������ 2, B���� �ι�° ������ 4�� �̾� ���Ͽ� ���մϴ�. (������ �� : 21 + 8(2x4) = 29)
	��, �� ��찡 �ּҰ� �ǹǷ� 29�� return �մϴ�.
	
	�迭 A, B�� �־��� �� ���������� ������ �ּڰ��� return �ϴ� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 	output : 29
 * 
 * 	Solution : 1. 2���� �迭���� ���� ū �� * ���� �������� ���������� ���ؼ� �����ָ� �ɵ�.
 * 
 * */

public class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) {
        	answer += A[i] * B[(B.length-1) - i]; 
        }
        return answer;
    }
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		System.out.println(sol.solution(A, B));
	}
}