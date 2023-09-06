package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 일 년 동안 세계일주를 하던 영식이는 여행을 하다 너무 피곤해서 근처에 있는 코레스코 콘도에서 하룻밤 잠을 자기로 하고 방을 잡았다.

	코레스코 콘도에 있는 방은 NxN의 정사각형모양으로 생겼다. 방 안에는 옮길 수 없는 짐들이 이것저것 많이 있어서 영식이의 누울 자리를 차지하고 있었다. 
	영식이는 이 열악한 환경에서 누울 수 있는 자리를 찾아야 한다. 영식이가 누울 수 있는 자리에는 조건이 있다. 
	똑바로 연속해서 2칸 이상의 빈 칸이 존재하면 그 곳에 몸을 양 옆으로 쭉 뻗으면서 누울 수 있다. 가로로 누울 수도 있고 세로로 누울 수도 있다. 
	누울 때는 무조건 몸을 쭉 뻗기 때문에 반드시 벽이나 짐에 닿게 된다. (중간에 어정쩡하게 눕는 경우가 없다.)
	
	....X
	..XX.
	.....
	.XX..
	X....
	
	만약 방의 구조가 위의 그림처럼 생겼다면, 가로로 누울 수 있는 자리는 5개이고, 세로로 누울 수 있는 자리는 4개 이다. 
	방의 크기 N과 방의 구조가 주어졌을 때, 가로로 누울 수 있는 자리와 세로로 누울 수 있는 자리의 수를 구하는 프로그램을 작성하시오.

	input			 
	5
	....X
	..XX.
	.....
	.XX..
	X....
	
	output
	5 4
	
	Solution : 1. 연속되어 있어야 하며 연속된 뒤에 X가 들어와야 함. 

*/

public class BaekJoon_1652 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] room = new char[N][N];
		int rowCount = 0;
		int colCount = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				room[i][j] = str.charAt(j);
			}
		}
		
		// 탐색
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i+1 < N) {
					if (room[i][j] == '.' && room[i+1][j] == '.' && (i+2 >= N || room[i+2][j] == 'X')) {
                    	colCount += 1;
					}
				}
                
				if(j+1 < N) {
					if (room[i][j] == '.' && room[i][j+1] == '.' && (j+2 >= N || room[i][j+2] == 'X')) {
						rowCount += 1;
					}
                }
			}
		}

		sb.append(rowCount).append(' ').append(colCount);
		
		System.out.println(sb.toString());
	}

}
