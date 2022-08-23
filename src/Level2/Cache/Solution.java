package Level2.Cache;

import java.util.*;

/*
 * Question : 
	�������������� �ٹ��ϴ� �������� �������� ���� �̸��� �˻��ϸ� �ش� ���ÿ� ���õ� ���� �Խù����� �����ͺ��̽����� �о� �����ִ� ���񽺸� �����ϰ� �ִ�.
	�� ���α׷��� �׽��� ������ ����ϰ� �ִ� ����ġ�� ���񽺸� �����ϱ� �� �� ������ ���� ���� ������ �����Ͽ��µ�,
	�������� �ۼ��� �κ� �� �����ͺ��̽����� �Խù��� �������� �κ��� ����ð��� �ʹ� ���� �ɸ��ٴ� ���� �˰� �Ǿ���.
	����ġ�� ���������� �ش� ������ �����϶�� �۴��ϱ� �����Ͽ���, �������� DB ĳ�ø� �����Ͽ� ���� ������ �õ��ϰ� ������ ĳ�� ũ�⸦ �󸶷� �ؾ� ȿ�������� ���� ������ ��Ȳ�̴�.
	
	����ġ���� �ô޸��� �������� ����, DB ĳ�ø� ������ �� ĳ�� ũ�⿡ ���� ����ð� ���� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * 
 * 	Solution : 1. ����� �ʾҴ� ����
 * 			   2. cache�� ������ ��ŭ ����Ʈ�� ������ �ִٰ� ���� �� remove & add�� �ݺ��ϸ� ��� ���� ����
 * 
 * 
 * */

public class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> list = new ArrayList<String>();
        if(cacheSize == 0) {
        	return cities.length * 5;
        }
        
        for(int i=0; i<cities.length; i++) {
        	String str = cities[i].toUpperCase();
        	
        	if(list.remove(str)) {
        		answer += 1;
        		list.add(str);
        	} else {
        		answer += 5;
        		if(list.size() >= cacheSize) {
        			list.remove(0);
        		}
        		list.add(str);
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(sol.solution(cacheSize, cities));
	}
}