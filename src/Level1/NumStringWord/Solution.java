package Level1.NumStringWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	�׿��� ���ε��� ���ڳ��̸� �ϰ� �ֽ��ϴ�. �׿��� ���ε����� ���ڸ� �ǳ� �� �Ϻ� �ڸ����� ���ܾ�� �ٲ� ī�带 �ǳ��ָ� ���ε��� ���� ���ڸ� ã�� �����Դϴ�.
	
	������ ������ �Ϻ� �ڸ����� ���ܾ�� �ٲٴ� �����Դϴ�.
	
	1478 �� "one4seveneight"
	234567 �� "23four5six7"
	10203 �� "1zerotwozero3"
	�̷��� ������ �Ϻ� �ڸ����� ���ܾ�� �ٲ�����ų�, Ȥ�� �ٲ��� �ʰ� �״���� ���ڿ� s�� �Ű������� �־����ϴ�. s�� �ǹ��ϴ� ���� ���ڸ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	����� �� ���ڿ� �����Ǵ� ���ܾ�� ���� ǥ�� �����ϴ�.
	
	����	���ܾ�
	0	zero
	1	one
	2	two
	3	three
	4	four
	5	five
	6	six
	7	seven
	8	eight
	9	nine
 */

public class Solution {
	
	public static Map<String, Integer> numMap = new HashMap<String, Integer>();
	public static List<Integer> arr = new ArrayList<Integer>();
	
    public int solution(String s) {
        int answer = 0;
        StringBuilder st = new StringBuilder();
        
        numMap.put("zero", 0);
        numMap.put("one", 1);
        numMap.put("two", 2);
        numMap.put("three", 3);
        numMap.put("four", 4);
        numMap.put("five", 5);
        numMap.put("six", 6);
        numMap.put("seven", 7);
        numMap.put("eight", 8);
        numMap.put("nine", 9);
        
        for(int i=0; i<s.length(); i++) {
        	st.append(s.charAt(i));
        	String a = st.toString();
        	if(!('0' <= s.charAt(i) && s.charAt(i) <='9')) { // ����
        		for(String num : numMap.keySet()) {
        			if(a.equals(num)){
        				arr.add(numMap.get(num));
        				st.replace(0, num.length(), "");
        			}
        		}
        	} else {
        		arr.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        		st.replace(0, 1, "");
        	}
        }
        
        
        StringBuilder a = new StringBuilder();
        for(int i=0; i<arr.size(); i++) {
        	a.append(arr.get(i));
        }

        answer = Integer.parseInt(a.toString());
        return answer;
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
    	String id = "one4seveneight";
		System.out.println(sol.solution(id));
	}
}
