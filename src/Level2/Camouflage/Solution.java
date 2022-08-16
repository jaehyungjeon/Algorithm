package Level2.Camouflage;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

	���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.
	
	����	�̸�
	��	���׶� �Ȱ�, ���� ���۶�
	����	�Ķ��� Ƽ����
	����	û����
	�ѿ�	�� ��Ʈ
	�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. ������ ����� ���� map�� ����
 * 			   2. key��(����)�� ���� ������ +1 �� ����ؼ� �����ָ�, ��� ����� ��
 * 			   3. ���Դ� ���� ���� �ϱ⶧���� -1
 * 
 * */

public class Solution {

	public int solution(String[][] clothes) {
    	int answer = 1;
    	
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for(String[] str : clothes) {
    		map.put(str[1], map.getOrDefault(str[1], 0) + 1);
    	}
    	
        Set<String> keySet = map.keySet();
        
        for(String key : keySet) {
        	answer *= map.get(key)+1; 
        }
    	
        return answer - 1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(sol.solution(clothes));
	}
}