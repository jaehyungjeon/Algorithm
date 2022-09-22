package Level1.MinRemove;

import java.util.*;

/*
 * Question : 
	������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���. 
	��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���. 
	������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.
 * 
 * 	Solution : 1. ������ 1�̸� �ּڰ� ���� ��� �����Ƿ� -1 ����
 * 			   2. �ƴ� ���, �ּڰ��� �̴� ��Ʈ��
 * 			   3. ���ͷ� �ּڰ��� ������ �������� �迭�� ��� ����
 *  
 * */

public class Solution {
	
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length <= 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            int min = Arrays.stream(arr).min().getAsInt(); // �ּڰ�
            answer = Arrays.stream(arr).filter(idx -> idx != min).toArray();
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {4, 3, 2, 1};
		System.out.println(sol.solution(arr));
	}
}
