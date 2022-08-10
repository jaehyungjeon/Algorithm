package Level2.ColoringBook;

import java.util.*;

/*
 * Question : 
	���ǻ��� �������� ����ġ�� �׿����� �÷����Ͽ� �� ��ȭ�� �׷��޶�� ��Ź�Ͽ� ���� ���� �׸��� �޾Ҵ�. 
	���� ���� �׸��� ���̵� ������ �÷����Ͽ� �ְ� �;��� ����ġ�� 
	������ ������ ��ĥ�ϱⰡ ��ٷο� ��������ٴ� ����� �߰��ϰ� �׸��� ���̵��� ������ ���� �����Ͽ���. (�����̶� �����¿�� ����� ���� ������ ������ �ǹ��Ѵ�.)

	�׸��� �� ���� ������ �ִ����� ���� ū ������ ���̴� ������ ����ϴ� ���α׷��� �ۼ��غ���.

	���� �׸��� �� 12�� �������� �̷���� ������, ���� ���� ������ ����ġ�� �󱼸����� ���̴� 120�̴�.
 * 
 * 	output : [4, 5]
 * 
 * 	Solution : 1. BFS�� �� ���� ���� �ҽ� ������. ������ �м� ���ַ� ���� �� ���� �ٽ� ���ڵ� �ǽ�
 * 			   2. �� �� �� ���� ���̶� �������� �ٽ� nr, nc�� ���� offer���Ѽ� �ݺ� ����
 * */

public class Solution {

 	static int[][] p;
    static boolean [][] check; 
    // �� �� �� ��
    static int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    static int bfs(int row, int col, int m, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row,col});

        int count = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            
            int r = tmp[0];
            int c = tmp[1];
            if(check[r][c])
                continue;
            check[r][c] = true;
            count++;

            for(int[] d : dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !check[nr][nc] && p[nr][nc] == p[r][c]){
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return count;
    }
	
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        p = picture;
        check = new boolean[m][n];

        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                if(check[r][c] || picture[r][c] == 0)
                    continue;
                maxSizeOfOneArea = Math.max(bfs(r,c,m,n), maxSizeOfOneArea);
                numberOfArea++;
            }
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int m = 6;
    	int n = 4;
    	int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(sol.solution(m, n, picture));
	}
}