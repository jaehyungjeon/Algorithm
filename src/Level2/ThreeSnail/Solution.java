package Level2.ThreeSnail;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	���� n�� �Ű������� �־����ϴ�. ���� �׸��� ���� �غ��� ���̿� ���̰� n�� �ﰢ������ �� �� ���������� �ݽð� �������� ������ ä��⸦ ������ ��, 
	ù ����� ������ ����� ��� ������� ��ģ ���ο� �迭�� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. ���������� ������ �̿��ϴ� ���� -> an = a1 + (n-1)d
 * 			   2. i�� ������쿡�� �������� -> �Ʒ�
 * 			   3. i�� 1�� ��쿡�� ���� ���ο��� ���������� �̵��Ѵ� -> ����
 * 			   4. i�� 2�� ��쿡�� �밢������ �̵��Ѵ� -> �밢
 * 			   5. �����ϸ鼭 ī��Ʈ��ŭ ������ ������Ų��.
 * 			   6. answer �迭 �ʱ�ȭ �� ���� �־� return
 * 
 * */

public class Solution {

    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int x = -1;
        int y = 0;
        int cnt = 0;
        for(int i=0; i<n; i++) {
        	for(int j=i; j<n; j++) {
        		if(i % 3 == 0) x++; // �Ʒ�
        		else if(i % 3 == 1) y++; // ������
        		else if(i % 3 == 2) { // �밢��
        			x--;
        			y--;
        		}
        		arr[x][y] = ++cnt;
        	}
        }
        
        answer = new int[cnt];
        int num = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr[i][j] == 0) break;
        		answer[num++] = arr[i][j];
        	}
        }
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}