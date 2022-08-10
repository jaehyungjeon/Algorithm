package Level2.ColoringBook;

import java.util.*;

/*
 * Question : 
	출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 
	여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 
	영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

	그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

	위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.
 * 
 * 	output : [4, 5]
 * 
 * 	Solution : 1. BFS는 잘 몰라서 오픈 소스 참고함. 지금은 분석 위주로 진행 후 차후 다시 재코딩 실시
 * 			   2. 상 하 좌 우의 값이랑 같을때는 다시 nr, nc의 값을 offer시켜서 반복 수행
 * */

public class Solution {

 	static int[][] p;
    static boolean [][] check; 
    // 상 하 좌 우
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