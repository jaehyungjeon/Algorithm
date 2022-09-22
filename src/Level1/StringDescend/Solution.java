package Level1.StringDescend;

import java.util.*;

/*
 * Question : 
	���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
	s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.
 * 
 * 	Solution : 1. ���������ε� ������ �ִ� ������ �����ؼ� ��� Ʋ�ȴ�..
 * 			   2. �빮�ڰ� �ҹ��ں��� ���������� �����Ѵٰ� �ϴ� �ҹ��� ���� �������� sort�� �� �빮�� �������� sort�� �����ϴ� ������ �����Ͽ���.
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
