package Level1.StringRandomSort;

import java.util.*;

/*
 * Question : 
	���ڿ��� ������ ����Ʈ strings��, ���� n�� �־����� ��, �� ���ڿ��� �ε��� n��° ���ڸ� �������� �������� �����Ϸ� �մϴ�. 
	���� ��� strings�� ["sun", "bed", "car"]�̰� n�� 1�̸� �� �ܾ��� �ε��� 1�� ���� "u", "e", "a"�� strings�� �����մϴ�.
 * 
 * 	Solution : 1. ������ ��¦ �򰥷ȴ� ����.. ���� ���ڿ��� �������� �ε��� ���� �ϳ� ������ش�.
 * 			   2. ���� ����Ʈ���� keySet�� �������� �ϳ��� ����Ʈ ���¸� ����
 * 			   3. ������������ �������ش�. -> compareTo
 * 			   4. list�� String �迭�� ��ȯ �� ����
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
