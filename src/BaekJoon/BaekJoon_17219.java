package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
	Question : 2019 HEPC - MAVEN League의 "비밀번호 만들기"와 같은 방식으로 비밀번호를 만든 경민이는 한 가지 문제점을 발견하였다. 
	비밀번호가 랜덤으로 만들어져서 기억을 못 한다는 것이었다! 그래서 경민이는 메모장에 사이트의 주소와 비밀번호를 저장해두기로 했다. 
	하지만 컴맹인 경민이는 메모장에서 찾기 기능을 활용하지 못하고 직접 눈으로 사이트의 주소와 비밀번호를 찾았다. 
	메모장에 저장된 사이트의 수가 늘어나면서 경민이는 비밀번호를 찾는 일에 시간을 너무 많이 쓰게 되었다. 
	이를 딱하게 여긴 문석이는 경민이를 위해 메모장에서 비밀번호를 찾는 프로그램을 만들기로 결심하였다! 
	문석이를 도와 경민이의 메모장에서 비밀번호를 찾아주는 프로그램을 만들어보자.

	input			 
	16 4
	noj.am IU
	acmicpc.net UAENA
	startlink.io THEKINGOD
	google.com ZEZE
	nate.com VOICEMAIL
	naver.com REDQUEEN
	daum.net MODERNTIMES
	utube.com BLACKOUT
	zum.com LASTFANTASY
	dreamwiz.com RAINDROP
	hanyang.ac.kr SOMEDAY
	dhlottery.co.kr BOO
	duksoo.hs.kr HAVANA
	hanyang-u.ms.kr OBLIVIATE
	yd.es.kr LOVEATTACK
	mcc.hanyang.ac.kr ADREAMER
	startlink.io
	acmicpc.net
	noj.am
	mcc.hanyang.ac.kr
	
	output
	THEKINGOD
	UAENA
	IU
	ADREAMER
	
	Solution : 1. 문제를 보자마자 생각한건 Map을 이용하겠다는 것이다.
	
*/

public class BaekJoon_17219 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, String> map = new HashMap<String, String>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		while(M-- > 0) {
			String findStr = br.readLine();
			
			sb.append(map.get(findStr)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
