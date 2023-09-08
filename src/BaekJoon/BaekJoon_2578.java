package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 빙고 게임은 다음과 같은 방식으로 이루어진다.
	먼저 아래와 같이 25개의 칸으로 이루어진 빙고판에 1부터 25까지 자연수를 한 칸에 하나씩 쓴다
	다음은 사회자가 부르는 수를 차례로 지워나간다. 예를 들어 5, 10, 7이 불렸다면 이 세 수를 지운 뒤 빙고판의 모습은 다음과 같다.
	차례로 수를 지워가다가 같은 가로줄, 세로줄 또는 대각선 위에 있는 5개의 모든 수가 지워지는 경우 그 줄에 선을 긋는다.
	
	이러한 선이 세 개 이상 그어지는 순간 "빙고"라고 외치는데, 가장 먼저 외치는 사람이 게임의 승자가 된다.
	철수는 친구들과 빙고 게임을 하고 있다. 철수가 빙고판에 쓴 수들과 사회자가 부르는 수의 순서가 주어질 때, 사회자가 몇 번째 수를 부른 후 철수가 "빙고"를 외치게 되는지를 출력하는 프로그램을 작성하시오.

	input			 
	11 12 2 24 10
	16 1 13 3 25
	6 20 5 21 17
	19 4 8 14 9
	22 15 7 23 18
	5 10 7 16 2
	4 22 8 17 13
	3 18 1 6 25
	12 19 23 14 21
	11 24 9 20 15
	
	output
	15
	
	Solution : 1. for문으로 바둑판의 위치에 -1로 숫자를 변경해준다.
			   2. 가로/세로/대각선(좌-우,우-좌)를 탐색한 뒤 최종 값이 -5(-1의 5번 합계) 이면 count를 증가시킨다.
			   3. count가 3이상이면 answer를 리턴한다.
	
*/

public class BaekJoon_2578 {

	public static Integer[][] board;
	public static int count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board = new Integer[5][5];
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				answer++;
				boardMethod(num);
				bingo();
				// 0으로 변환하는 순간 가로/세로/대각선 라인이 0인지 탐색.
				if(count >= 3) {
					System.out.println(answer);
					
					System.exit(0);
				}
			}
		}
	}
	
	// 바둑판 배열을 0으로
	public static void boardMethod(int M) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(board[i][j].equals(M)) {
					board[i][j] = -1;
					break;
				}
			}
		}
	}
	
	// 카운트를 반환해주는 정수형이어야 할듯.
	private static void bingo() {
		count = 0;
		
		int rowValue = 0;
		int colValue = 0;
		int lrValue = 0;
		int rlValue = 0;
		int index = 0;
		
		for(int i=0; i<5; i++) {
			rowValue = 0;
			colValue = 0;
			for(int j=0; j<5; j++) {
				rowValue += board[i][j];
				colValue += board[j][i];
				
				if(i == j) {
					lrValue += board[i][j];
				}
				
				if(index == i && j == 4 - index) {
					rlValue += board[i][j];
					index++;
				}
			}
			
			if(rowValue == -5) count++;
			if(colValue == -5) count++;
			if(lrValue == -5) count++;
			if(rlValue == -5) count++;
		}
	}
}
