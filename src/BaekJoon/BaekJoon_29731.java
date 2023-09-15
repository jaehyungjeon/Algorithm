package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/*
	Question : 2033년, 하루나라에서 밈 1위를 결정하고자 하는 투표가 예정되어 있어 1위를 다투고 있는 후보들은 자신들의 독특한 공약을 내세우고 있다. 
	여론조사에 따르면, 'Rick Astley'는 유권자에게 다음과 같은 공약을 내세워 현재 1위라고 한다.

	Never gonna give you up
	Never gonna let you down
	Never gonna run around and desert you
	Never gonna make you cry
	Never gonna say goodbye
	Never gonna tell a lie and hurt you
	Never gonna stop
	하지만 해킹 기술이 너무 발달한 나머지, Rick Astley의 공약을 싫어하는 해커가 그의 공약을 몰래 바꾸고 있다. 
	haru_101은 해커가 Rick Astley의 공약을 바꿨는지 알고 싶다. 주어진 문장 중 하나라도 기존 공약에 속하지 않으면 공약이 바뀐 것으로 본다. 단, 대소문자를 구분한다. 여러분이 haru_101을 도와주자.

	input			 
	3
	Never gonna give you up
	Never gonna say goodbye
	Let you down
	
	output
	Yes
	
	Solution : 1. 리스트에 포함되지 않으면 Yes를 반환하고 프로그램을 종료하도록 구성.
	
*/

public class BaekJoon_29731 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> list = Arrays.asList("Never gonna give you up", "Never gonna let you down", "Never gonna run around and desert you", "Never gonna make you cry",
				"Never gonna say goodbye", "Never gonna tell a lie and hurt you", "Never gonna stop");
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(!list.contains(str)) {
				System.out.println("Yes");
				
				System.exit(0);
			}
		}
		
		System.out.println("No");
	}

}
