package Level2.OpenChattingRoom;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	카카오톡 오픈채팅방에서는 친구가 아닌 사람들과 대화를 할 수 있는데, 본래 닉네임이 아닌 가상의 닉네임을 사용하여 채팅방에 들어갈 수 있다.
	
	신입사원인 김크루는 카카오톡 오픈 채팅방을 개설한 사람을 위해, 다양한 사람들이 들어오고, 나가는 것을 지켜볼 수 있는 관리자창을 만들기로 했다. 
	채팅방에 누군가 들어오면 다음 메시지가 출력된다.
	
	"[닉네임]님이 들어왔습니다."
	
	채팅방에서 누군가 나가면 다음 메시지가 출력된다.
	
	"[닉네임]님이 나갔습니다."
	
	채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
	
	채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
	채팅방에서 닉네임을 변경한다.
	닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다.
	
	예를 들어, 채팅방에 "Muzi"와 "Prodo"라는 닉네임을 사용하는 사람이 순서대로 들어오면 채팅방에는 다음과 같이 메시지가 출력된다.
	
	"Muzi님이 들어왔습니다."
	"Prodo님이 들어왔습니다."
	
	채팅방에 있던 사람이 나가면 채팅방에는 다음과 같이 메시지가 남는다.
	
	"Muzi님이 들어왔습니다."
	"Prodo님이 들어왔습니다."
	"Muzi님이 나갔습니다."
	
	Muzi가 나간후 다시 들어올 때, Prodo 라는 닉네임으로 들어올 경우 기존에 채팅방에 남아있던 Muzi도 Prodo로 다음과 같이 변경된다.
	
	"Prodo님이 들어왔습니다."
	"Prodo님이 들어왔습니다."
	"Prodo님이 나갔습니다."
	"Prodo님이 들어왔습니다."
	
	채팅방은 중복 닉네임을 허용하기 때문에, 현재 채팅방에는 Prodo라는 닉네임을 사용하는 사람이 두 명이 있다. 
	이제, 채팅방에 두 번째로 들어왔던 Prodo가 Ryan으로 닉네임을 변경하면 채팅방 메시지는 다음과 같이 변경된다.
	
	"Prodo님이 들어왔습니다."
	"Ryan님이 들어왔습니다."
	"Prodo님이 나갔습니다."
	"Prodo님이 들어왔습니다."
	
	채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
	모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return 하도록 solution 함수를 완성하라.
 * 
 * 	Solution : 1. Map을 이용하여 최신화된 id값과 그에 따른 네이밍 출력을 보여주는 문제였다.
 * 			   2. 소스를 작성하다 느낀건, 만약 순서에 대한 이슈가 고려된다고 보았을 때 주석처리를 한 Entry의 키값과 현재 record의 id값이 동일할 때, 담아주는게 맞다고 생각한다.
 * 			   3. 근데, 저렇게 작성을 할 경우 for문을 여러번 거치기에 시간적인 소요가 발생한다.
 * 			   4. 어차피 record를 따로 건드리지 않기 때문에 해당 이슈를 바로 처리하고 마무리 지었다.
 * 
 * */

public class Solution {
	
	public Map<String, String> idMap = new HashMap<String, String>();
	
    public String[] solution(String[] record) {
        String[] answer = {};

        int count = 0;
        for(int i=0; i<record.length; i++) {
        	char c = record[i].charAt(0);
        	if(c != 'C') {
        		count++;
        	}
        	
        	if(c != 'L') {
        		idMap.put(record[i].split(" ")[1], record[i].split(" ")[2]);
        	}
        }
        
        int idx = 0;
        answer = new String[count];
        
    	for(int j=0; j<record.length; j++) {
    		char oStatus = record[j].charAt(0);
    		String key = record[j].split(" ")[1];
    		if(oStatus != 'C') {
	    		if (oStatus == 'E') {
	    			answer[idx++] = idMap.get(key)+"님이 들어왔습니다.";
	//				for(Entry<String, String> k : idMap.entrySet()) {
	//					if(key.equals(k.getKey())) {
	//						answer[idx++] = k.getValue()+"님이 들어왔습니다.";
	//					}
	//				}
				} else {
					answer[idx++] = idMap.get(key)+"님이 나갔습니다.";
	//				for(Entry<String, String> k : idMap.entrySet()) {
	//					if(key.equals(k.getKey())) {
	//						answer[idx++] = k.getValue()+"님이 나갔습니다.";
	//					}
	//				}
				}
	    	}
    	}
    	
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		System.out.println(sol.solution(record));
	}
}
