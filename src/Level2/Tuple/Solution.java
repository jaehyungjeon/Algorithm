package Level2.Tuple;

import java.util.*;

/*
 * Question : 
	�����ִ� ������ �����ִ� ���� �Ǵ� � ������ ������ ��ҵ��� ������ Ʃ��(tuple)�̶�� �մϴ�. n���� ��Ҹ� ���� Ʃ���� n-Ʃ��(n-tuple)�̶�� �ϸ�, ������ ���� ǥ���� �� �ֽ��ϴ�.
	
	(a1, a2, a3, ..., an)
	Ʃ���� ������ ���� ������ ������ �ֽ��ϴ�.
	
	�ߺ��� ���Ұ� ���� �� �ֽ��ϴ�. ex : (2, 3, 1, 2)
	���ҿ� ������ ������ ������, ������ ������ �ٸ��� ���� �ٸ� Ʃ���Դϴ�. ex : (1, 2, 3) �� (1, 3, 2)
	Ʃ���� ���� ������ �����մϴ�.
	������ ������ n���̰�, �ߺ��Ǵ� ���Ұ� ���� Ʃ�� (a1, a2, a3, ..., an)�� �־��� ��(��, a1, a2, ..., an�� �ڿ���), �̴� ������ ���� ���� ��ȣ '{', '}'�� �̿��� ǥ���� �� �ֽ��ϴ�.
	
	{{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
	���� ��� Ʃ���� (2, 1, 3, 4)�� ��� �̴�
	
	{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
	�� ���� ǥ���� �� �ֽ��ϴ�. �̶�, ������ ������ ������ �ٲ� ��������Ƿ�
	
	{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
	{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
	{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
	�� ��� ���� Ʃ�� (2, 1, 3, 4)�� ��Ÿ���ϴ�.
	
	Ư�� Ʃ���� ǥ���ϴ� ������ ��� ���ڿ� s�� �Ű������� �־��� ��, s�� ǥ���ϴ� Ʃ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. String�� �ɰ��°� �ٽ�
 * 			   2. ���� �� �������� sort
 * 			   3. ���ø� �ϸ鼭 ����Ʈ�� �� �� ������ �ֱ�(������ ���̺��� ���ϱ� 1���� �� ����)
 * 			   4. ����Ʈ -> array ��ȯ
 * 
 * */

public class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String str = s.substring(2, s.length() - 2);
        str = str.replace("},{", " ");
        String[] strArr = str.split(" ");
        
		Arrays.sort(strArr, new Comparator<String>() { // ���� �� ��������
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		
		List<Integer> tmp = new ArrayList<>();
        for(String t : strArr) {
        	String[] temp = t.split(",");
        	
        	for(int i=0; i<temp.length; i++) {
        		int num = Integer.parseInt(temp[i]);
        		
        		if(!tmp.contains(num)) { // ������ �ֱ�
        			tmp.add(num);
        		}
        	}
        }
        
        answer = tmp.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(sol.solution(s));
	}
}