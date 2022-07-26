package FailPercent;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Question : 
 * 	슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
	이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
	역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.
	실패율은 다음과 같이 정의한다.
	스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
	실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 * 
 * 
 * Solution : 1. 값을 받아서 스테이지 별, 값 셋팅
 * 			  2. 키값을 조회해서 스테이지 도달 별 비율을 담는 맵 셋팅
 * 			  3. 내림차순 정렬
 * 			  4. key값 빼옴
 * 
 * */

class Solution {
	
	public Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
	public Map<Integer, Double> map = new HashMap<Integer, Double>(); 
	
    public int[] solution(int N, int[] stages) {
        int[] answer;
        int totCount = stages.length;
        
        for(int i=0; i<stages.length; i++) {
        	cntMap.put(stages[i], cntMap.getOrDefault(stages[i], 0) + 1);
        }
        
        for(int i=1; i<N+1; i++) {
        	for(Entry<Integer, Integer> key : cntMap.entrySet()) {
        		if(i == key.getKey()) {
        			map.put(key.getKey(), (double)key.getValue()/totCount);
        			totCount -= key.getValue();
        			break;
        		} else {
        			map.put(i, (double)0);
        		}
        	}
        }
        
        List<Map.Entry<Integer, Double>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        answer = new int[entries.size()];
        for(int i=0; i<entries.size(); i++) {
        	answer[i] = entries.get(i).getKey();
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int N = 5;
    	int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		System.out.println(sol.solution(N, stages));
	}
}