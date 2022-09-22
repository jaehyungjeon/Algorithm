package Level1.Running;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Question : 
	수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
	완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 	Solution : 1. HashMap에 참가자 전체를 받으면서 정수값 1로 셋팅한다.
 * 			   2. 도착자 for문 돌리면서 있을 경우에는 -1 하여 0으로 셋팅한다.
 * 			   3. Map을 for문 돌리면서 키값이 0이 아닐 경우 answer에 값을 추가한다.
 * */

public class Solution {

	public HashMap<String, Integer> Run = new HashMap<String, Integer>(); 
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for(String a : participant) {
        	Run.put(a, Run.getOrDefault(a, 0) + 1);
        }
        
        for(String b : completion) {
        	Run.put(b, Run.get(b) - 1);
        }
        
        for(Entry<String, Integer> elem : Run.entrySet()) {
        	if (elem.getValue() != 0){
        		answer = elem.getKey();
        		break;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    	String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(sol.solution(participant, completion));
	}
}