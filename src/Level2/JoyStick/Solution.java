package Level2.JoyStick;

import java.util.*;

/*
 * Question : 
	조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
	ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
	
	조이스틱을 각 방향으로 움직이면 아래와 같습니다.
	
	▲ - 다음 알파벳
	▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
	◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
	▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
	예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.
	
	- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
	- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
	- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
	따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
	만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
 * 
 * 	output : 56
 * 
 * 	Solution : 1. J : A B C D E F G H I J : 9
 * 			   2. A : <- : 1
 * 			   3. Z : -> : 1
 * 			   4. 9 + 1 + 1 = 11
 * 			   5. 'Z' - '현재 위치' = DIST1 // '현재 위치' - 'A' = DIST2
 * 			   6. 접근이 어렵네.. -> 좌/우 이동의 횟수를 먼저 파악해서 이동만큼 +해주는게 어려움..
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