package FailPercent;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Question : 
 * 	���� ���� ������ �������� ū ��ο� ������. �׳డ ���� ������ ��õ���� �뼺���� �ŵ�����, ���� �ű� ������� ���� �ް��� ���̴�. ������ �ű� ����ڿ� ���� ����� ���̿� �������� ���̰� �ʹ� ū ���� ��������.
	�� ������ ��� �ұ� ��� �� �׳�� �������� ���� �ð��� �÷��� ���̵��� �����ϱ�� �ߴ�. 
	���� ���� �����ڶ� ��κ��� ������ ���� ����������, �������� ���ϴ� �κп��� ���⿡ ������ ���Ҵ�. �������� ���� �������� ���ϴ� �ڵ带 �ϼ��϶�.
	�������� ������ ���� �����Ѵ�.
	���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
	��ü ���������� ���� N, ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages�� �Ű������� �־��� ��, 
	�������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭�� return �ϵ��� solution �Լ��� �ϼ��϶�.
 * 
 * 
 * Solution : 1. ���� �޾Ƽ� �������� ��, �� ����
 * 			  2. Ű���� ��ȸ�ؼ� �������� ���� �� ������ ��� �� ����
 * 			  3. �������� ����
 * 			  4. key�� ����
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