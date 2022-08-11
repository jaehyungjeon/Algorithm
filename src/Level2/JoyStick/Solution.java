package Level2.JoyStick;

import java.util.*;

/*
 * Question : 
	���̽�ƽ���� ���ĺ� �̸��� �ϼ��ϼ���. �� ó���� A�θ� �̷���� �ֽ��ϴ�.
	ex) �ϼ��ؾ� �ϴ� �̸��� �� ���ڸ� AAA, �� ���ڸ� AAAA
	
	���̽�ƽ�� �� �������� �����̸� �Ʒ��� �����ϴ�.
	
	�� - ���� ���ĺ�
	�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
	�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
	�� - Ŀ���� ���������� �̵� (������ ��ġ���� ���������� �̵��ϸ� ù ��° ���ڿ� Ŀ��)
	���� ��� �Ʒ��� ������� "JAZ"�� ���� �� �ֽ��ϴ�.
	
	- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
	- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
	- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
	���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.
	������� �ϴ� �̸� name�� �Ű������� �־��� ��, �̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.
 * 
 * 	output : 56
 * 
 * 	Solution : 1. J : A B C D E F G H I J : 9
 * 			   2. A : <- : 1
 * 			   3. Z : -> : 1
 * 			   4. 9 + 1 + 1 = 11
 * 			   5. 'Z' - '���� ��ġ' = DIST1 // '���� ��ġ' - 'A' = DIST2
 * 			   6. ������ ��Ƴ�.. -> ��/�� �̵��� Ƚ���� ���� �ľ��ؼ� �̵���ŭ +���ִ°� �����..
 * */

public class Solution {

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;
        
        for(int i=0; i<name.length(); i++) {
        	answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
        	if(i < name.length() - 1 && name.charAt(i+1) == 'A') {
        		int end = i + 1;
        		while(end < name.length() && name.charAt(end) == 'A') {
        			end++;
        		}
        		
        		move = Math.min(move, i*2 + (name.length() - end));
        		move = Math.min(move, i	+ (name.length() - end) * 2);
        	}
        }
        
        answer += move;
        return answer;
    }
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String name = "BCAAAE";
		System.out.println(sol.solution(name));
	}
}