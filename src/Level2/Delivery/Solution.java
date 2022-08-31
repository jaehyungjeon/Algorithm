package Level2.Delivery;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	N���� ������ �̷���� ���� �ֽ��ϴ�. �� ������ �� �������� 1���� N������ ��ȣ�� ���� �ϳ��� �ο��Ǿ� �ֽ��ϴ�. 
	�� ������ ��������� ������ �� �ִ� ���η� ����Ǿ� �ִµ�, ���� �ٸ� ���� ���� �̵��� ���� �� ���θ� ������ �մϴ�. ���θ� ���� �� �ɸ��� �ð��� ���κ��� �ٸ��ϴ�. 
	���� 1�� ������ �ִ� ���������� �� ������ ���� ����� �Ϸ��� �մϴ�. �� �����κ��� ���� �ֹ��� �������� �ϴµ�, N���� ���� �߿��� K �ð� ���Ϸ� ����� ������ ���������� �ֹ��� �������� �մϴ�. 

	�� �׸����� 1�� ������ �ִ� �������� [1, 2, 4, 5] �� ���������� 3 ������ �ð��� ����� �� �ֽ��ϴ�. 
	�׷��� 3�� ���������� 3�ð� �̳��� ����� �� �ִ� ��ΰ� �����Ƿ� 3�� ���������� �ֹ��� ���� �ʽ��ϴ�. ���� 1�� ������ �ִ� �������� ��� �ֹ��� ���� �� �ִ� ������ 4���� �˴ϴ�.
	������ ���� N, �� ������ �����ϴ� ������ ���� road, ���� ����� ������ �ð� K�� �Ű������� �־��� ��, ���� �ֹ��� ���� �� �ִ� ������ ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. ��� ������ ��ġ�� �˰��� - �÷��̵� �ͼ� �˰���
 * 			   2. ���� ������ ��� �迭�� �ʱ�ȭ ���� �־��ش�.
 * 			   3. ������ ������ �������ִ� ��
 * 			   4. ���ο� �ٸ��� ������ �ִ� �ٸ����� ũ�� �ѱ��, ������ �����Ѵ�.
 * 			   5. �÷��̵� �ͼ��� �̿��� map ���� ��´�.
 * 			   6. K���� ������ answer++;
 * 
 * */

public class Solution {

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] map = new int [N][N];
        
        // �ʱ�ȭ
        for(int i=0; i<map.length; i++) {
        	for(int j=0; j<map[0].length; j++) {
        		if (i==j) continue;
        		map[i][j] = 500001;
        	}
        }
        
        for(int[] dt : road) {
        	if(map[dt[0] - 1][dt[1] - 1] < dt[2]) continue;
        	
        	map[dt[0]-1][dt[1]-1] = dt[2];
        	map[dt[1]-1][dt[0]-1] = dt[2];
        }
        
        for(int i=0; i<map.length; i++) {
        	for(int j=0; j<map.length; j++) {
        		for(int k=0; k<map.length; k++) {
        			if(map[j][k] > map[j][i] + map[i][k])
                        map[j][k] = map[j][i] + map[i][k];
        		}
        	}
        }
        
        for(int i=0; i<map[0].length; i++) {
        	if (map[0][i] <= K) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int N = 5;
		int [][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
		int K = 3;
		System.out.println(sol.solution(N, road, K));
	}
}