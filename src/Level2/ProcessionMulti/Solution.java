package Level2.ProcessionMulti;

import java.util.*;

/*
 * Question : 
	2���� ��� arr1�� arr2�� �Է¹޾�, arr1�� arr2�� ���� ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.
 * 
 *	output : [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
 * 
 * 	Solution : 1. 10 + 12 + 2 = 22 / 8 + 12 + 2 = 22 / 6 + 3 + 2 = 11
 * 			   2. ���� * ����
 * 
 * 	2 3 2   5 4 3
 * 	4 2 4	2 4 1
 * 	3 1 4	3 1 1
 * 
 * */

public class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr2[0].length; j++) {
                for (int n = 0; n < arr1[0].length; n++) {
                    answer[i][j] += (arr1[i][n] * arr2[n][j]);
                }
                System.out.println();
            }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}};
		int[][] arr2 = {{5,4,3}, {2,4,1}, {3,1,1}};
		System.out.println(sol.solution(arr1, arr2));
	}
}