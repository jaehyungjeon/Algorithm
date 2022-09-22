package Level1.ProcessionSum;

import java.util.*;

/*
 * Question : 
	����� ������ ��� ���� ũ�Ⱑ ���� �� ����� ���� ��, ���� ���� ���� ���� ���� ����� �˴ϴ�.
	2���� ��� arr1�� arr2�� �Է¹޾�, ��� ������ ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.

 * 
 * 	Solution : 1. �迭�� �ʱ�ȭ �ϵ�, ù���� �迭���� array ��ü�� ������ 2��° �迭���� array �ϳ��� �����ִ� ��������� ���� �ʱ�ȭ
 * 			   2. for�� ���鼭 answer �迭�� ���� ���� �־���.
 * */

public class Solution {
	
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        
        for(int i=0; i<arr1.length; i++) {
        	for(int j=0; j<arr1[i].length; j++) {
        		answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[][] arr1 = {{1, 2}, {2, 3}};
    	int[][] arr2 = {{3, 4}, {5, 6}};
		System.out.println(sol.solution(arr1, arr2));
	}
}