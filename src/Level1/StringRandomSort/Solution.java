package Level1.StringRandomSort;

import java.util.*;

/*
 * Question : 
	문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
	예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 * 
 * 	Solution : 1. 접근이 살짝 헷갈렸던 문제.. 먼저 문자열을 기준으로 인덱스 맵을 하나 만들어준다.
 * 			   2. 받은 리스트에서 keySet을 기준으로 하나의 리스트 형태를 구현
 * 			   3. 오름차순으로 정렬해준다. -> compareTo
 * 			   4. list를 String 배열로 변환 후 리턴
 * 
 * */

public class Solution {

	public Map<String, String> map = new TreeMap<String, String>();
	
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        for(int i=0; i<strings.length; i++) {
        	map.put(strings[i], String.valueOf(strings[i].charAt(n)));
        }
        
        List<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o1).compareTo(map.get(o2)));

        answer = list.stream().toArray(String[]::new);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String[] strings = {"abce", "abcd", "cdx"};
    	int n = 2;
		System.out.println(sol.solution(strings, n));
	}
}
