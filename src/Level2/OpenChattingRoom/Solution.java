package Level2.OpenChattingRoom;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	īī���� ����ä�ù濡���� ģ���� �ƴ� ������ ��ȭ�� �� �� �ִµ�, ���� �г����� �ƴ� ������ �г����� ����Ͽ� ä�ù濡 �� �� �ִ�.
	
	���Ի���� ��ũ��� īī���� ���� ä�ù��� ������ ����� ����, �پ��� ������� ������, ������ ���� ���Ѻ� �� �ִ� ������â�� ������ �ߴ�. 
	ä�ù濡 ������ ������ ���� �޽����� ��µȴ�.
	
	"[�г���]���� ���Խ��ϴ�."
	
	ä�ù濡�� ������ ������ ���� �޽����� ��µȴ�.
	
	"[�г���]���� �������ϴ�."
	
	ä�ù濡�� �г����� �����ϴ� ����� ������ ���� �� �����̴�.
	
	ä�ù��� ���� ��, ���ο� �г������� �ٽ� ����.
	ä�ù濡�� �г����� �����Ѵ�.
	�г����� ������ ���� ������ ä�ù濡 ��µǾ� �ִ� �޽����� �г��ӵ� ���� ����ȴ�.
	
	���� ���, ä�ù濡 "Muzi"�� "Prodo"��� �г����� ����ϴ� ����� ������� ������ ä�ù濡�� ������ ���� �޽����� ��µȴ�.
	
	"Muzi���� ���Խ��ϴ�."
	"Prodo���� ���Խ��ϴ�."
	
	ä�ù濡 �ִ� ����� ������ ä�ù濡�� ������ ���� �޽����� ���´�.
	
	"Muzi���� ���Խ��ϴ�."
	"Prodo���� ���Խ��ϴ�."
	"Muzi���� �������ϴ�."
	
	Muzi�� ������ �ٽ� ���� ��, Prodo ��� �г������� ���� ��� ������ ä�ù濡 �����ִ� Muzi�� Prodo�� ������ ���� ����ȴ�.
	
	"Prodo���� ���Խ��ϴ�."
	"Prodo���� ���Խ��ϴ�."
	"Prodo���� �������ϴ�."
	"Prodo���� ���Խ��ϴ�."
	
	ä�ù��� �ߺ� �г����� ����ϱ� ������, ���� ä�ù濡�� Prodo��� �г����� ����ϴ� ����� �� ���� �ִ�. 
	����, ä�ù濡 �� ��°�� ���Դ� Prodo�� Ryan���� �г����� �����ϸ� ä�ù� �޽����� ������ ���� ����ȴ�.
	
	"Prodo���� ���Խ��ϴ�."
	"Ryan���� ���Խ��ϴ�."
	"Prodo���� �������ϴ�."
	"Prodo���� ���Խ��ϴ�."
	
	ä�ù濡 ������ �����ų�, �г����� ������ ����� ��� ���ڿ� �迭 record�� �Ű������� �־��� ��, 
	��� ����� ó���� ��, ���������� ���� ������ ����� ���� �Ǵ� �޽����� ���ڿ� �迭 ���·� return �ϵ��� solution �Լ��� �ϼ��϶�.
 * 
 * 	Solution : 1. Map�� �̿��Ͽ� �ֽ�ȭ�� id���� �׿� ���� ���̹� ����� �����ִ� ��������.
 * 			   2. �ҽ��� �ۼ��ϴ� ������, ���� ������ ���� �̽��� ����ȴٰ� ������ �� �ּ�ó���� �� Entry�� Ű���� ���� record�� id���� ������ ��, ����ִ°� �´ٰ� �����Ѵ�.
 * 			   3. �ٵ�, ������ �ۼ��� �� ��� for���� ������ ��ġ�⿡ �ð����� �ҿ䰡 �߻��Ѵ�.
 * 			   4. ������ record�� ���� �ǵ帮�� �ʱ� ������ �ش� �̽��� �ٷ� ó���ϰ� ������ ������.
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
	    			answer[idx++] = idMap.get(key)+"���� ���Խ��ϴ�.";
	//				for(Entry<String, String> k : idMap.entrySet()) {
	//					if(key.equals(k.getKey())) {
	//						answer[idx++] = k.getValue()+"���� ���Խ��ϴ�.";
	//					}
	//				}
				} else {
					answer[idx++] = idMap.get(key)+"���� �������ϴ�.";
	//				for(Entry<String, String> k : idMap.entrySet()) {
	//					if(key.equals(k.getKey())) {
	//						answer[idx++] = k.getValue()+"���� �������ϴ�.";
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
