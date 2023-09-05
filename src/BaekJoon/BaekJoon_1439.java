package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 
	다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.

	예를 들어 S=0001100 일 때,
	
	전체를 뒤집으면 1110011이 된다.
	4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
	하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.
	
	문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.

	input			 
	0001100
	
	output
	1
	
	Solution : 1. 1이 발견되는 때와 0이 발견되는 때를 구분하여 min 값을 구해주면 될 듯.
			   2. 유효성 체크를 하여 00000, 11111 인 경우에는 변동이 없으므로 리버스 값인 0이 min이 됨.
			   3. 서로 자리가 바뀔때만 카운트가 변경되며 변경 시점에는 비교 문자를 계속 변경해줌. (바뀌는 시점에만 변경해줘도 무방하긴 함.)

*/

public class BaekJoon_1439 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		char c = arr[0];
		int oneCount = 0;
		int zeroCount = 0;
		
		if(valid(c)) oneCount++;
		else zeroCount++;
		
		for(int i=1; i<arr.length; i++) {
			char t = arr[i];
			if(c == '1' && c != t) {
				oneCount++;
			}
			
			if(c == '0' && c != t) {
				zeroCount++;
			}
			
			c = t;
		}
		
		System.out.println(Math.min(oneCount, zeroCount));
	}
	
	private static boolean valid(char c) {
		if(c == '0') {
			return true;
		}
		
		return false;
	}

}
