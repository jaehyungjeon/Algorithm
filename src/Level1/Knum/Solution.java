package Knum;

import java.util.Arrays;

/*
 * Question : 
	�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

	���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��
	
	array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
	1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
	2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
	�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��,
	commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 	Solution : 1. ���� -> 0��°, �� -> 1��°, �ε��� -> 2��°�� ����.
 * 			   2. �迭�� ���� -1, ���� ����, ����Ʈ ���� -1
 * 			   3. Arrays�Լ��� �̿��Ͽ� start ~ end ũ��� �ɰ��� �迭 ����(arr)
 * 			   4. ������������ ����
 *			   5. �ش� ���� �� �����Ͽ� �迭�� ����. -> return �� ��ȯ
 * */

public class Solution {
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
        	int start = commands[i][0] - 1;
        	int end = commands[i][1];
        	int point = commands[i][2] - 1;
        	int[] arr = Arrays.copyOfRange(array, start, end);
        	Arrays.sort(arr); // �������� ����
        	answer[i] = arr[point];
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] array = {1, 5, 2, 6, 3, 7, 4};
    	int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(sol.solution(array, commands));
	}
}
