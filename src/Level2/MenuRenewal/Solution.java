package Level2.MenuRenewal;

import java.util.*;

/*
 * Question : 
	��������� ��ϴ� ��ī�Ǵ� �ڷγ�19�� ���� �Ұ�⸦ �غ��ϰ��� �޴��� ���� �����Ϸ��� ����ϰ� �ֽ��ϴ�.
	�������� ��ǰ���θ� �����ϴ� �޴��� �����ؼ� �ڽ��丮 ���·� �籸���ؼ� ���ο� �޴��� �����ϱ�� �����߽��ϴ�. 
	� ��ǰ�޴����� �����ؼ� �ڽ��丮 �޴��� �����ϸ� ���� �� ����ϴ� "��ī��"�� ������ �� �մԵ��� �ֹ��� �� ���� ���� �Բ� �ֹ��� ��ǰ�޴����� �ڽ��丮 �޴��� �����ϱ�� �߽��ϴ�.
	��, �ڽ��丮 �޴��� �ּ� 2���� �̻��� ��ǰ�޴��� �����Ϸ��� �մϴ�. ����, �ּ� 2�� �̻��� �մ����κ��� �ֹ��� ��ǰ�޴� ���տ� ���ؼ��� �ڽ��丮 �޴� �ĺ��� �����ϱ�� �߽��ϴ�.

	���� ���, �մ� 6���� �ֹ��� ��ǰ�޴����� ������ ������ ���ٸ�,
	(�� �մ��� ��ǰ�޴��� 2�� �̻� �ֹ��ؾ� �ϸ�, �� ��ǰ�޴��� A ~ Z�� ���ĺ� �빮�ڷ� ǥ���մϴ�.)

	�մ� ��ȣ	�ֹ��� ��ǰ�޴� ����
	1�� �մ�	A, B, C, F, G
	2�� �մ�	A, C
	3�� �մ�	C, D, E
	4�� �մ�	A, C, D, E
	5�� �մ�	B, C, F, G
	6�� �մ�	A, C, D, E, H
	���� ���� �Բ� �ֹ��� ��ǰ�޴� ���տ� ���� "��ī��"�� ����� �� �ڽ��丮 �޴� ���� �ĺ��� ������ �����ϴ�.

	�ڽ� ����	�޴� ����	����
	�丮 2�� �ڽ�	A, C	1��, 2��, 4��, 6�� �մ����κ��� �� 4�� �ֹ��ƽ��ϴ�.
	�丮 3�� �ڽ�	C, D, E	3��, 4��, 6�� �մ����κ��� �� 3�� �ֹ��ƽ��ϴ�.
	�丮 4�� �ڽ�	B, C, F, G	1��, 5�� �մ����κ��� �� 2�� �ֹ��ƽ��ϴ�.
	�丮 4�� �ڽ�	A, C, D, E	4��, 6�� �մ����κ��� �� 2�� �ֹ��ƽ��ϴ�.
 * 
 * 
 * 	Solution : 1. orders�� ���ں��� �ɰ� �� ������ �����. -> dfs�� �̿��Ͽ� course���ǿ� �����ϴ� �ܾ ����(2 -> 2���ܾ�, 3 -> 3���ܾ�...)
 * 			   2. �޴��� map ���� �� ������ �ִ´�.
 * 			   3. ������������ �޴��� ����(��������)
 * 			   4. ���� �������� �����Ͽ� ���ο� ����Ʈ�� ����
 * 			   5. ��� ������ ���ڿ� ������ ����(A, B, ...)
 * 			   6. �迭 �� RETURN
 *   
 *   		   �� ���ͳ� ����.. -> �ҽ� �м� ��ü�� ok, ������ Ǯ��� ����� ����
 * */

public class Solution {

	static List<String> combi;
	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		combi = new ArrayList<>();
		//�ڽ� �޴������� ��� ����� �� ���ϱ� (dfs)
		for(int i=0; i<orders.length; i++) {
			String[] one = orders[i].split("");
			Arrays.sort(one);

			for(int j=0; j<one.length-1; j++) {
				for(int k=0; k<course.length; k++) {
					dfs(one, j, 1, course[k], one[j]);
				}
			}
		}

		Map<String , Integer> map = new HashMap<>();
		for(String menu : combi) {
			map.put(menu, map.getOrDefault(menu, 0)+1);
		}

		List<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return map.get(o2)-map.get(o1);
			}
		});


		List<String> res = new ArrayList<>();
		for(int i=0; i< course.length; i++) {
			int max = 0;

			// course �������� ���� �α��ִ� ǰ�� ���� 
			for(String courseMenu : list) {
				if(map.get(courseMenu)>1 && courseMenu.length() == course[i]) {
					if(map.get(courseMenu) >= max) {
						res.add(courseMenu);
						max = map.get(courseMenu);
					}
				}
			}
		}

		// ���ڼ� ���� 
		Collections.sort(res);

		answer = res.toArray(new String[res.size()]);
		
		return answer;
	}

	static void dfs(String[] one, int idx, int len, int courseLen, String str) {
		if(len == courseLen) {
			combi.add(str);
		}

		for(int i = idx+1; i<one.length; i++) {
			dfs(one, i, len+1, courseLen, str+one[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		System.out.println(sol.solution(orders, course));
	}
}