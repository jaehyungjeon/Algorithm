package Level1.ProcessionSum;

import java.util.*;

/*
 * Question : 
	행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
	2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

 * 
 * 	Solution : 1. 배열을 초기화 하되, 첫번재 배열에는 array 전체의 갯수를 2번째 배열에는 array 하나에 속해있는 구성요소의 갯수 초기화
 * 			   2. for문 돌면서 answer 배열에 덧셈 값을 넣어줌.
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