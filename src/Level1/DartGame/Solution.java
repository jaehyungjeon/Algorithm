package Level1.DartGame;

import java.util.*;

/*
 * Question : 
	카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
	
	Game Star
	
	카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
	갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
	
	다트 게임은 총 3번의 기회로 구성된다.
	각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
	점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
	옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
	스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
	스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
	스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
	스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 * 
 * 	Solution : 1. 들어오는 숫자를 판별 -> charAt으로 글자마다 비교
 * 			   2. 임시 스트링을 하나 만들어 놓고, 숫자일 경우에는 계속해서 스트링 값을 이어서 받음
 * 			   3. S, D, T는 숫자 바로 뒤에 붙는 형식이므로 else if로 분기처리해주고 case 별로 제곱수를 넣어줌
 * 			   4. #일 경우 -1을 곱하고 *일 경우 *2를 해줌으로 형식을 처리 해주는데, *2는 idx - 2가 0이상일 경우에도 처리를 해줌
 * 			   5. 값을 answer에 담아 return
 * */

public class Solution {
    public static boolean isNumeric(char s) {
        if (s < '0' || s > '9') {
            return false;
        }
        
        return true;
    }
	
    public int solution(String dartResult) {
        int answer = 0;
        int[] arr = new int[3];
        int idx = 0;
        String tempString = "";
        int tempNum = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
        	char tmp = dartResult.charAt(i);
        	
        	if(isNumeric(tmp)) { // 숫자일 때,
        		tempString += String.valueOf(tmp);
        	} else if(tmp == 'S' || tmp == 'D' || tmp == 'T') {
        		tempNum = Integer.parseInt(tempString);
        		switch(tmp) {
        			case 'S' :
        				tempNum = (int)Math.pow(tempNum, 1);
        				break;
        			case 'D' :
        				tempNum = (int)Math.pow(tempNum, 2);
        				break;
        			case 'T' :
        				tempNum = (int)Math.pow(tempNum, 3);
        				break;
        		}
        		arr[idx++] = tempNum;
        		tempString = "";
        	} else {
        		if(tmp == '#') {
        			arr[idx - 1] *= -1;
        		} else {
        			arr[idx - 1] *= 2;
        			if(idx - 2 >= 0) {
        				arr[idx - 2] *= 2;
        			}
        		}
        	}
        }
        
        for(int val : arr) {
        	answer += val;
        }
        
        return answer;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String dartResult = "1S*2T*3S";
		System.out.println(sol.solution(dartResult));
	}
}
