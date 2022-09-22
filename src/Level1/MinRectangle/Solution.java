package Level1.MinRectangle;

import java.util.*;

/*
 * Question : 
	���� ������ ����� ȸ�翡�� ������ ũ�⸦ ���Ϸ��� �մϴ�. �پ��� ���� ũ���� ���Ե��� ��� ������ �� �����鼭, �۾Ƽ� ��� �ٴϱ� ���� ������ ������ �մϴ�. 
	�̷��� ����� �����ϴ� ������ ����� ���� ���������� ��� ������ ���� ���̿� ���� ���̸� �����߽��ϴ�.
	
	�Ʒ� ǥ�� 4���� ������ ���� ���̿� ���� ���̸� ��Ÿ���ϴ�.
	
	���� ��ȣ	���� ����	���� ����
	1	60	50
	2	30	70
	3	60	30
	4	80	40
	���� �� ���� ���̿� ���� ���̰� ���� 80, 70�̱� ������ 80(����) x 70(����) ũ���� ������ ����� ��� ���Ե��� ������ �� �ֽ��ϴ�. 
	������ 2�� ������ ���η� ���� �����Ѵٸ� 80(����) x 50(����) ũ���� �������� ��� ���Ե��� ������ �� �ֽ��ϴ�. �̶��� ���� ũ��� 4000(=80 x 50)�Դϴ�.
	
	��� ������ ���� ���̿� ���� ���̸� ��Ÿ���� 2���� �迭 sizes�� �Ű������� �־����ϴ�. 
	��� ������ ������ �� �ִ� ���� ���� ������ ���� ��, ������ ũ�⸦ return �ϵ��� solution �Լ��� �ϼ����ּ���.

 * 
 * 	Solution : 1. MIN, MAX�� ���� ������, MAX�� �⺻������ ��ü������ ���� ū ��
 * 			   2. MIN�� [0]��°�� [1]��°�� ���ؼ� ���� ���� �������� �����Ͽ� �� �߿��� ���� ū ���� �̵��� ��.
 * */

public class Solution {
	
	public static HashMap<String, Integer> map = new HashMap<String, Integer>();
	
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int tmp = 0;
        for(int i=0; i<sizes.length; i++) {
        	for(int j=0; j<sizes[i].length; j++) {
        		map.put("MAX", Math.max(sizes[i][j], map.getOrDefault("MAX", 0))); // �ִ�
        		tmp = Math.min(sizes[i][0], sizes[i][1]);
        	}
        	
        	if(map.getOrDefault("MIN", 0) < tmp) {
        		map.put("MIN", tmp);
        	}
        }
        
        answer = map.get("MAX") * map.get("MIN");
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(sol.solution(sizes));
	}
}