package Level2.Hopscotch;

import java.util.*;

/*
 * Question : 
	�����Ա� ������ �Ϸ��� �մϴ�. �����Ա� ������ ��(land)�� �� N�� 4���� �̷���� �ְ�, ��� ĭ���� ������ ���� �ֽ��ϴ�. 
	1����� ���� ������ �� �྿ ������ ��, �� ���� 4ĭ �� �� ĭ�� �����鼭 �����;� �մϴ�. ��, �����Ա� ���ӿ��� �� �྿ ������ ��, ���� ���� �����ؼ� ���� �� ���� Ư�� ��Ģ�� �ֽ��ϴ�.

	���� ���,
	
	| 1 | 2 | 3 | 5 |
	
	| 5 | 6 | 7 | 8 |
	
	| 4 | 3 | 2 | 1 |
	
	�� ���� �־����ٸ�, 1�࿡�� �׹�° ĭ (5)�� �������, 2���� �׹�° ĭ (8)�� ���� �� �����ϴ�.
	
	������ ����� ��� �������� ��, ���� �� �ִ� ������ �ִ밪�� return�ϴ� solution �Լ��� �ϼ��� �ּ���. 
	�� ���� ���, 1���� �׹�° ĭ (5), 2���� ����° ĭ (7), 3���� ù��° ĭ (4) ���� ��� 16���� �ְ����� �ǹǷ� 16�� return �ϸ� �˴ϴ�.
 * 
 * 
 * 	Solution : 1. dfs�� �����غ�����, ������ �������� �̽�
 * 			   2. �������� �迭���� ������ ���� �ʴ� ��, 0��° �迭 -> 1, 2, 3 ������ �ִ��� �̾� �����͸� �ִ� ������� �迭 ����
 * 			   3. ������������ ���� ��, ���� ������ �� -> max���̹Ƿ� return
 * 
 * */

public class Solution {

    int solution(int[][] land) {
		for(int i=1; i<land.length; i++) {
			land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
			land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
			land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
			land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
		}
        
		int[] answer = land[land.length-1];
		Arrays.sort(answer);
		
        return answer[answer.length-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(sol.solution(land));
	}
}