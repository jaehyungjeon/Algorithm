package Level2.Compression;

import java.util.*;

/*
 * Question : 
	신입사원 어피치는 카카오톡으로 전송되는 메시지를 압축하여 전송 효율을 높이는 업무를 맡게 되었다. 메시지를 압축하더라도 전달되는 정보가 바뀌어서는 안 되므로, 압축 전의 정보를 완벽하게 복원 가능한 무손실 압축 알고리즘을 구현하기로 했다.

	어피치는 여러 압축 알고리즘 중에서 성능이 좋고 구현이 간단한 LZW(Lempel–Ziv–Welch) 압축을 구현하기로 했다. LZW 압축은 1983년 발표된 알고리즘으로, 이미지 파일 포맷인 GIF 등 다양한 응용에서 사용되었다.
	
	LZW 압축은 다음 과정을 거친다.
	
	길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
	사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
	w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
	입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
	단계 2로 돌아간다.
	압축 알고리즘이 영문 대문자만 처리한다고 할 때, 사전은 다음과 같이 초기화된다. 사전의 색인 번호는 정수값으로 주어지며, 1부터 시작한다고 하자.
	
	색인 번호	1	2	3	...	24	25	26
	단어	A	B	C	...	X	Y	Z
	예를 들어 입력으로 KAKAO가 들어온다고 하자.
	
	현재 사전에는 KAKAO의 첫 글자 K는 등록되어 있으나, 두 번째 글자까지인 KA는 없으므로, 첫 글자 K에 해당하는 색인 번호 11을 출력하고, 다음 글자인 A를 포함한 KA를 사전에 27 번째로 등록한다.
	두 번째 글자 A는 사전에 있으나, 세 번째 글자까지인 AK는 사전에 없으므로, A의 색인 번호 1을 출력하고, AK를 사전에 28 번째로 등록한다.
	세 번째 글자에서 시작하는 KA가 사전에 있으므로, KA에 해당하는 색인 번호 27을 출력하고, 다음 글자 O를 포함한 KAO를 29 번째로 등록한다.
	마지막으로 처리되지 않은 글자 O에 해당하는 색인 번호 15를 출력한다.
	현재 입력(w)	다음 글자(c)	출력	사전 추가(w+c)
	K	A	11	27: KA
	A	K	1	28: AK
	KA	O	27	29: KAO
	O		15	
	이 과정을 거쳐 다섯 글자의 문장 KAKAO가 4개의 색인 번호 [11, 1, 27, 15]로 압축된다.
	
	입력으로 TOBEORNOTTOBEORTOBEORNOT가 들어오면 다음과 같이 압축이 진행된다.
	
	현재 입력(w)	다음 글자(c)	출력	사전 추가(w+c)
	T			O			20	27: TO
	O			B			15	28: OB
	B			E			2	29: BE
	E			O			5	30: EO
	O			R			15	31: OR
	R			N			18	32: RN
	N			O			14	33: NO
	O			T			15	34: OT
	T			T			20	35: TT
	TO			B			27	36: TOB
	BE			O			29	37: BEO
	OR			T			31	38: ORT
	TOB			E			36	39: TOBE
	EO			R			30	40: EOR
	RN			O			32	41: RNO
	OT						34	
 * 
 * 
 * 	Solution : 1. map에다가 A to Z의 값을 셋팅
 * 			   2. 단어의 갯수만큼 돌린다음, while문으로 단어를 조합해 나갈 때 map에 해당 단어가 없을 때 word를 구성
 * 			   3. 끝까지 탐색했으면 리스트에 단어를 담아주고, 맵에는 조합된 단어와 index를 넣어줌
 * 			   4. 순서를 유지하기 위해 i-- 실시
 * 			   5. 순서에 대한 이해가 필요했던 문제
 * 
 * */

public class Solution {
	
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        int num = 1;
        for(char i='A'; i<='Z'; i++) {
        	map.put(i+"", num++);
        }

        int idx = 27;
        boolean check = false;
        
        for(int i=0; i<msg.length(); i++) {
        	String word = msg.charAt(i)+"";
        	
        	while(map.containsKey(word)) {
        		i++;
        		if(i == msg.length()) {
        			check = true;
        			break;
        		}
        		
        		word += msg.charAt(i);
        	}
        	
        	if(check) {
        		list.add(map.get(word));
        		break;
        	}
        	
        	list.add(map.get(word.substring(0, word.length() - 1)));
        	map.put(word, idx++);
        	
        	i--;
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String msg = "KAKAO";
		System.out.println(sol.solution(msg));
	}
}