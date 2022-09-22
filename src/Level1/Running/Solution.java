package Level1.Running;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * Question : 
	������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
	�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��,
	�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 	Solution : 1. HashMap�� ������ ��ü�� �����鼭 ������ 1�� �����Ѵ�.
 * 			   2. ������ for�� �����鼭 ���� ��쿡�� -1 �Ͽ� 0���� �����Ѵ�.
 * 			   3. Map�� for�� �����鼭 Ű���� 0�� �ƴ� ��� answer�� ���� �߰��Ѵ�.
 * */

public class Solution {

	public HashMap<String, Integer> Run = new HashMap<String, Integer>(); 
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for(String a : participant) {
        	Run.put(a, Run.getOrDefault(a, 0) + 1);
        }
        
        for(String b : completion) {
        	Run.put(b, Run.get(b) - 1);
        }
        
        for(Entry<String, Integer> elem : Run.entrySet()) {
        	if (elem.getValue() != 0){
        		answer = elem.getKey();
        		break;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
    	String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(sol.solution(participant, completion));
	}
}