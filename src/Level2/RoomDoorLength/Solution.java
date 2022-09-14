package Level2.RoomDoorLength;

import java.util.*;

/*
 * Question : 
	���� ĳ���͸� 4���� ��ɾ ���� �����̷� �մϴ�. ��ɾ�� ������ �����ϴ�.

	U: �������� �� ĭ ����

	D: �Ʒ������� �� ĭ ����

	R: ���������� �� ĭ ����

	L: �������� �� ĭ ����

	ĳ���ʹ� ��ǥ����� (0, 0) ��ġ���� �����մϴ�. ��ǥ����� ���� ���� ��(-5, 5), ���� �Ʒ�(-5, -5), ������ ��(5, 5), ������ �Ʒ�(5, -5)�� �̷���� �ֽ��ϴ�.

	���� ���, "ULURRDLLU"�� ����ߴٸ�

	1�� ��ɾ���� 7�� ��ɾ���� ������ ���� �����Դϴ�.

	8�� ��ɾ���� 9�� ��ɾ���� ������ ���� �����Դϴ�.

	�̶�, �츮�� ���� ĳ���Ͱ� ������ �� �� ĳ���Ͱ� ó�� �ɾ ���� ���̸� ���Ϸ��� �մϴ�. ���� ��� ���� ���ÿ��� ���� ĳ���Ͱ� ������ ���̴� 9������, ĳ���Ͱ� ó�� �ɾ ���� ���̴� 7�� �˴ϴ�. (8, 9�� ��ɾ�� ������ ���� 2, 3�� ��ɾ�� �̹� ���� �� ���Դϴ�)

	��, ��ǥ����� ��踦 �Ѿ�� ��ɾ�� �����մϴ�.

	���� ���, "LULLLLLLU"�� ����ߴٸ�

	1�� ��ɾ���� 6�� ��ɾ��� ������ ��, 7, 8�� ��ɾ�� �����մϴ�. �ٽ� 9�� ��ɾ��� �����Դϴ�.

	�̶� ĳ���Ͱ� ó�� �ɾ ���� ���̴� 7�� �˴ϴ�.

	��ɾ �Ű����� dirs�� �־��� ��, ���� ĳ���Ͱ� ó�� �ɾ ���� ���̸� ���Ͽ� return �ϴ� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 	output : 7
 * 
 * 	Solution : 1. ���ͳ� ����..
 * 			   2. L, R, U, D�� ���� ������ ��ǥ�� ������ ���������ش�.(nextX, nextY)
 * 			   3. ���̰� �ʰ��ϸ� �����Ѵ� (-5, 5)
 * 			   4. �̵��� ���� ��ǥ�� String������ ������� HashSet���� �ߺ����� �����ش�.
 * 			   5. HashSet�� ������ = �ߺ����� �ʴ� ����� ����
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