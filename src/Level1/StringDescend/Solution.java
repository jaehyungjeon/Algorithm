package Level1.StringDescend;

import java.util.*;

/*
 * Question : 
	문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
	s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 * 
 * 	Solution : 1. 내림차순인데 역으로 넣는 것으로 생각해서 몇번 틀렸다..
 * 			   2. 대문자가 소문자보다 작은것으로 간주한다고 하니 소문자 먼저 내림차순 sort한 뒤 대문자 내림차순 sort를 머지하는 것으로 생각하였다.
 *  
 * */

public class Solution {

	public List<String> LowerList = new ArrayList<String>();
	public List<String> UpperList = new ArrayList<String>();
	public List<String> gbList = new ArrayList<String>();
	
    public String solution(String s) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++) {
        	if(Character.isUpperCase(s.charAt(i))) {
        		UpperList.add(String.valueOf(s.charAt(i)));
        	} else {
        		LowerList.add(String.valueOf(s.charAt(i)));
        	}
        }

        LowerList.sort(Comparator.reverseOrder());
        UpperList.sort(Comparator.reverseOrder());
        
        gbList.addAll(LowerList);
        gbList.addAll(UpperList);
        
        for(String a : gbList) {
        	answer += a;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String s = "Zbcdefg";
		System.out.println(sol.solution(s));
	}
}
