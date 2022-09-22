package Level1.�Ű����ޱ�;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Question : 
 * ���Ի�� ������ �Խ��� �ҷ� �̿��ڸ� �Ű��ϰ� ó�� ����� ���Ϸ� �߼��ϴ� �ý����� �����Ϸ� �մϴ�. ������ �����Ϸ��� �ý����� ������ �����ϴ�.

	�� ������ �� ���� �� ���� ������ �Ű��� �� �ֽ��ϴ�.
	�Ű� Ƚ���� ������ �����ϴ�. ���� �ٸ� ������ ����ؼ� �Ű��� �� �ֽ��ϴ�.
	�� ������ ���� �� �Ű��� ���� ������, ������ ������ ���� �Ű� Ƚ���� 1ȸ�� ó���˴ϴ�.
	k�� �̻� �Ű�� ������ �Խ��� �̿��� �����Ǹ�, �ش� ������ �Ű��� ��� �������� ���� ����� ���Ϸ� �߼��մϴ�.
	������ �Ű��� ��� ������ �����Ͽ� �������� �Ѳ����� �Խ��� �̿� ������ ��Ű�鼭 ���� ������ �߼��մϴ�.
	������ ��ü ���� ����� ["muzi", "frodo", "apeach", "neo"]�̰�, k = 2(��, 2�� �̻� �Ű���ϸ� �̿� ����)�� ����� �����Դϴ�.
	
	���� ID	������ �Ű��� ID	����
	"muzi"	"frodo"	"muzi"�� "frodo"�� �Ű��߽��ϴ�.
	"apeach"	"frodo"	"apeach"�� "frodo"�� �Ű��߽��ϴ�.
	"frodo"	"neo"	"frodo"�� "neo"�� �Ű��߽��ϴ�.
	"muzi"	"neo"	"muzi"�� "neo"�� �Ű��߽��ϴ�.
	"apeach"	"muzi"	"apeach"�� "muzi"�� �Ű��߽��ϴ�.
	�� �������� �Ű���� Ƚ���� ������ �����ϴ�.
	
	���� ID	�Ű���� Ƚ��
	"muzi"	1
	"frodo"	2
	"apeach"	0
	"neo"	2
	�� ���ÿ����� 2�� �̻� �Ű���� "frodo"�� "neo"�� �Խ��� �̿��� �����˴ϴ�. �̶�, �� �������� �Ű��� ���̵�� ������ ���̵� �����ϸ� ������ �����ϴ�.
	
	���� ID	������ �Ű��� ID	������ ID
	"muzi"	["frodo", "neo"]	["frodo", "neo"]
	"frodo"	["neo"]	["neo"]
	"apeach"	["muzi", "frodo"]	["frodo"]
	"neo"	����	����
	���� "muzi"�� ó�� ��� ������ 2ȸ, "frodo"�� "apeach"�� ���� ó�� ��� ������ 1ȸ �ް� �˴ϴ�.
	
	�̿����� ID�� ��� ���ڿ� �迭 id_list, �� �̿��ڰ� �Ű��� �̿����� ID ������ ��� ���ڿ� �迭 report, ���� ������ �Ǵ� �Ű� Ƚ�� k�� �Ű������� �־��� ��, �� �������� ó�� ��� ������ ���� Ƚ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * Solution : 1. id_list�� �Ű� ���� Ƚ���� Map �����.
 * 			  2. count�� �� �� �ִ� Map�� �ϳ� �� �߰��Ѵ�. -> k�� ������ ���� �����ϱ� ����
 * 			  3. �Ű���� id�� ���� map ���� �����Ѵ�.
 * 			  4. k��° �̻��� ���, �ش� id�� ���õ� ���� 1�� ������Ų��.
 * 
 * */

class Solution {
	public HashMap<String, HashSet<String>> idMap = new HashMap<String, HashSet<String>>();
	public HashMap<String, Integer> reportMap = new HashMap<String, Integer>();
	
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        for(int i=0; i<id_list.length; i++) {
        	HashSet<String> a = new HashSet<String>();
        	
        	idMap.put(id_list[i], a);
        	
        	reportMap.put(id_list[i], 0);
        }
        
        for(String a : report) {
        	String[] reportId = a.split(" ");
    		idMap.get(reportId[1]).add(reportId[0]);
        }
	    
        
        for(String id : idMap.keySet()) {
        	HashSet<String> t = idMap.get(id);
        	if(t.size() >= k) {
        		for(String b : t) {
        			reportMap.put(b, reportMap.get(b)+1);
        		}
        	}
        }
        
        answer = new int[id_list.length];
        for(int i=0; i<reportMap.size(); i++) {
        	answer[i] = reportMap.get(id_list[i]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    	String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(sol.solution(id_list, report, 2));
	}
}