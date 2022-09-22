package Level1.Divisor;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Question : 
	�� ���� left�� right�� �Ű������� �־����ϴ�. 
	left���� right������ ��� ���� �߿���, ����� ������ ¦���� ���� ���ϰ�, ����� ������ Ȧ���� ���� �� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. ������ �޾Ƽ� Ű���� ���� ���� ���� -> �������� 0�̸� ����ϰŴϱ� �׶� ����
 * 			   2. map�� ���� value�� ¦�� -> Ű�� ���ϰ� �ƴϸ� ����.
 * 
 * */

public class Solution {

	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
        	for(int j=1; j<=i; j++) {
        		int num2 = i%j;
        		if(num2 == 0) {
        			map.put(i, map.getOrDefault(i, 0)+1);
        		} else {
        			map.put(i, map.getOrDefault(i, 0));
        		}
        	}
        }

        for(Entry<Integer, Integer> key : map.entrySet()) {
        	if(key.getValue()%2 == 0) { // ¦��
        		answer += key.getKey();
        	} else { // Ȧ��
        		answer -= key.getKey();
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int left = 13;
    	int right = 17;
		System.out.println(sol.solution(left, right));
	}
}
