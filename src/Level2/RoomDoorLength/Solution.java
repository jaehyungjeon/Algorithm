package Level2.RoomDoorLength;

import java.util.*;

/*
 * Question : 
	게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

	U: 위쪽으로 한 칸 가기

	D: 아래쪽으로 한 칸 가기

	R: 오른쪽으로 한 칸 가기

	L: 왼쪽으로 한 칸 가기

	캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.

	예를 들어, "ULURRDLLU"로 명령했다면

	1번 명령어부터 7번 명령어까지 다음과 같이 움직입니다.

	8번 명령어부터 9번 명령어까지 다음과 같이 움직입니다.

	이때, 우리는 게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하려고 합니다. 예를 들어 위의 예시에서 게임 캐릭터가 움직인 길이는 9이지만, 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다. (8, 9번 명령어에서 움직인 길은 2, 3번 명령어에서 이미 거쳐 간 길입니다)

	단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.

	예를 들어, "LULLLLLLU"로 명령했다면

	1번 명령어부터 6번 명령어대로 움직인 후, 7, 8번 명령어는 무시합니다. 다시 9번 명령어대로 움직입니다.

	이때 캐릭터가 처음 걸어본 길의 길이는 7이 됩니다.

	명령어가 매개변수 dirs로 주어질 때, 게임 캐릭터가 처음 걸어본 길의 길이를 구하여 return 하는 solution 함수를 완성해 주세요.
 * 
 * 	output : 7
 * 
 * 	Solution : 1. 인터넷 참고..
 * 			   2. L, R, U, D에 따라서 다음에 좌표의 값들을 변동시켜준다.(nextX, nextY)
 * 			   3. 길이가 초과하면 무시한다 (-5, 5)
 * 			   4. 이동에 따라 좌표를 String값으로 만든다음 HashSet으로 중복구분 시켜준다.
 * 			   5. HashSet의 사이즈 = 중복되지 않는 경로의 길이
 * 
 * */

public class Solution {

	public String road = "";

	public int solution(String dirs) {
		HashSet<String> s = new HashSet<String>();

		int length = dirs.length();

		int nx = 0;
		int ny = 0;

		for(int i=0; i<length; i++) {
			char c = dirs.charAt(i);
			int nextX = nx;
			int nextY = ny;
			road = "";
			
			switch(c) {
			case 'U' :
				nextY++;
				roadFunc1(nx, ny, nextX, nextY);
				break;
			case 'D' : 
				nextY--;
				roadFunc2(nx, ny, nextX, nextY);
				break;
			case 'R' :
				nextX++;
				roadFunc1(nx, ny, nextX, nextY);
				break;
			case 'L' :
				nextX--;
				roadFunc2(nx, ny, nextX, nextY);
				break;
			}
			
			if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) continue;
			
			s.add(road);
			
			nx = nextX;
			ny = nextY;
		}
		
		return s.size();
	}

	public String roadFunc1(int nx, int ny, int nextX, int nextY) {
		road += nx;
		road += ny;
		road += nextX;
		road += nextY;
		
		return road;
	}

	public String roadFunc2(int nx, int ny, int nextX, int nextY) {
		road += nextX;
		road += nextY;
		road += nx;
		road += ny;
		
		return road;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String dirs = "ULURRDLLU";
		System.out.println(sol.solution(dirs));
	}
}