package Level1.SecretMap;

import java.util.*;

/*
 * Question : 
	�׿��� ��� ���ε��� ������ ���ܳ��� ��Ҹ� �˷��� ��������� �տ� �־���. �׷��� �� ��������� ���ڷ� ��ȣȭ�Ǿ� �־� ��ġ�� Ȯ���ϱ� ���ؼ��� ��ȣ�� �ص��ؾ� �Ѵ�. 
	������ ���� ��ȣ�� �ص��� ����� ������� �޸� �Բ� �߰��ߴ�.
	
	������ �� ���� ���̰� n�� ���簢�� �迭 ���·�, �� ĭ�� "����"(" ") �Ǵ� "��"("#") �� ������ �̷���� �ִ�.
	��ü ������ �� ���� ������ ���ļ� ���� �� �ִ�. ���� "���� 1"�� "���� 2"��� ����. ���� 1 �Ǵ� ���� 2 �� ��� �ϳ��� ���� �κ��� ��ü ���������� ���̴�. 
	���� 1�� ���� 2���� ��� ������ �κ��� ��ü ���������� �����̴�.
	"���� 1"�� "���� 2"�� ���� ���� �迭�� ��ȣȭ�Ǿ� �ִ�.
	��ȣȭ�� �迭�� ������ �� �����ٿ��� �� �κ��� 1, ���� �κ��� 0���� ��ȣȭ���� �� ������� �������� �ش��ϴ� ���� �迭�̴�.
	
	�׿��� ���ε��� ������ �տ� ���� �� �ֵ���, ��������� ��ȣ�� �ص��ϴ� �۾��� ������ ���α׷��� �ۼ��϶�.
 * 
 * 	Solution : 1. �迭�� ��� Ȱ���ұ ���� ����
 * 			   2. arr1�� arr2���� ������ �Ϳ� ���Ͽ� or ��å���� �� �����Ͽ� 2������ ��ȯ
 * 			   3. replace ���� 1->#, 0->" " ���� ǥ��
 * 			   4. ���� ���� �̾����� �����Ƿ� while�� �ݺ����� �� �ֱ� 
 * 
 * */

public class Solution {
	
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        
        for(int i=0; i<n; i++) {
        	answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        	answer[i] = answer[i].replace("1", "#");
        	answer[i] = answer[i].replace("0", " ");
        	
        	while(answer[i].length() < n) {
        		answer[i] = ' ' + answer[i];
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 5;
    	int[] arr1 = {9, 20, 28, 18, 11};
    	int[] arr2 = {30, 1, 21, 17, 28};
		System.out.println(sol.solution(n, arr1, arr2));
	}
}
