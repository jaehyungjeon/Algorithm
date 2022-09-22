package Level1.NaturalNumBackArray;

import java.util.*;

/*
 * Question : 
	�ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���. 
	������� n�� 12345�̸� [5,4,3,2,1]�� �����մϴ�.
 * 
 * 	Solution : 1. �迭�� �������� ����ְ�
 * 			   2. Arrays ��ƿ�� �̿��Ͽ� int�� ��ȯ�ϸ鼭 �迭�� �����ִ� ���
 * 			   3. �ּ�ó���� �κ��� ���� ���ϴ� �ٸ� �̷� �ڵ�����
 *  
 * */

public class Solution {
	
    public int[] solution(long n) {
        int[] answer = {};
        String[] arr = String.valueOf(n).split("");
        
        String[] reverseArr = new String[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) { 
        	reverseArr[j] = arr[i]; 
    	}
        
        answer = Arrays.stream(reverseArr).mapToInt(Integer::parseInt).toArray();
        return answer;

        
        /* ���� ���ߴ� ���� */
//        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	long n = 11234;
		System.out.println(sol.solution(n));
	}
}
