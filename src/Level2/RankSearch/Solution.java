package Level2.RankSearch;

import java.util.*;

/*
 * Question : 
	īī���� �Ϲݱ� ��� ������ ����ä���� ���� �߿� ������ ���� ������ ������ �ڵ��׽�Ʈ�� ����Ǿ����ϴ�. �̹� ä�뿡�� �����ڴ� ������ �ۼ� �� �Ʒ��� ���� 4���� �׸��� �ݵ�� �����ϵ��� �Ͽ����ϴ�.

	�ڵ��׽�Ʈ ���� ���߾�� �׸� cpp, java, python �� �ϳ��� �����ؾ� �մϴ�.
	���� ���� �׸� backend�� frontend �� �ϳ��� �����ؾ� �մϴ�.
	���� ��±��� �׸� junior�� senior �� �ϳ��� �����ؾ� �մϴ�.
	��ȣ�ϴ� �ҿ�Ǫ��� chicken�� pizza �� �ϳ��� �����ؾ� �մϴ�.
	���翵������ �ٹ��ϰ� �ִ� �ϴ���� �ڵ��׽�Ʈ ����� �м��Ͽ� ä�뿡 ������ �������鿡 �����ϱ� ���� �����ڵ��� ���� ������ �����ϸ� �ش� ���ǿ� �´� �����ڰ� �� ���� �� ���� �� �� �ִ� ������ ����� �ֽ��ϴ�.
	���� ���, ���������� �ñ����ϴ� ���ǻ����� ������ ���� ���°� �� �� �ֽ��ϴ�.
	�ڵ��׽�Ʈ�� java�� ����������, backend ������ �����߰�, junior ����̸鼭, �ҿ�Ǫ��� pizza�� ������ ��� �� �ڵ��׽�Ʈ ������ 50�� �̻� ���� �����ڴ� �� ���ΰ�?

	���� �� �ܿ��� �� �������� ��Ȳ�� ���� �Ʒ��� ���� �پ��� ������ ���ǰ� ���� �� �ֽ��ϴ�.

	�ڵ��׽�Ʈ�� python���� ����������, frontend ������ �����߰�, senior ����̸鼭, �ҿ�Ǫ��� chicken�� ������ ��� �� �ڵ��׽�Ʈ ������ 100�� �̻� ���� ����� ��� �� ���ΰ�?
	�ڵ��׽�Ʈ�� cpp�� ����������, senior ����̸鼭, �ҿ�Ǫ��� pizza�� ������ ��� �� �ڵ��׽�Ʈ ������ 100�� �̻� ���� ����� ��� �� ���ΰ�?
	backend ������ �����߰�, senior ����̸鼭 �ڵ��׽�Ʈ ������ 200�� �̻� ���� ����� ��� �� ���ΰ�?
	�ҿ�Ǫ��� chicken�� ������ ��� �� �ڵ��׽�Ʈ ������ 250�� �̻� ���� ����� ��� �� ���ΰ�?
	�ڵ��׽�Ʈ ������ 150�� �̻� ���� ����� ��� �� ���ΰ�?
	��, ���������� �ñ����ϴ� ������ ������ ���� ���¸� �����ϴ�.

 * [����]�� �����ϴ� ��� �� �ڵ��׽�Ʈ ������ X�� �̻� ���� ����� ��� �� ���ΰ�?
 * 
 * 
 * 	Solution : 1. ���ͳ� ����..
 * 			   2. dfs�� ���� �� �ִ� ��� INFO�� ����� ���� ���Ѵ� -> 1-1�� 1-2�� ��� -> ��� ���̽� ����
 * 			   3. map�� ����� ���� list�� ������������ ���Ľ�Ŵ -> keySet���� ����Ʈ�� �ٷ� �ش� ����Ʈ�� �������� ����(Map to List)
 * 			   4. score ���ϴ� �̺�Ž�� �ǽ� -> ��ü score����Ʈ���� score���� ���� ������ ���̽���ŭ ����
 * 			   5. answer �迭�� ��Ƽ� return
 * 			   6. ó�� ¥�⿡�� ������ �����ؾ��ϰ� ���̵� �ʿ�.. �ڵ� ��ü�� ���ذ� �ȵǴ� ������ �ƴ�.
 * 
 * */

public class Solution {

	public static Map<String, ArrayList<Integer>> allInfo;
	public static ArrayList<Integer> in;
	
	public int[] solution(String[] info, String[] query) {

		int[] answer = new int[query.length];
		allInfo = new HashMap<>();

		// 1. info ��� ����� �� map�� ���� 
		for(int i=0; i<info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}
		
		// 2. map�� ����� ���� list ������������ ���� 	
		List<String> list = new ArrayList<>(allInfo.keySet());
		for(int i=0; i<list.size(); i++) {
			List<Integer> scoreList = allInfo.get(list.get(i));
			Collections.sort(scoreList);
		}

		for(int i=0; i<query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] str = query[i].split(" ");
			int score = Integer.parseInt(str[1]);

			answer[i] = search(str[0], score);
		}
		
		return answer;
	}

	public static void dfs(String pos, int depth, String[] info) {
		if(depth == 4) {
			if(!allInfo.containsKey(pos)) {
				in = new ArrayList<>();
				in.add(Integer.parseInt(info[4]));
				allInfo.put(pos, in);
			}else {
				allInfo.get(pos).add(Integer.parseInt(info[4]));
			}
			return;
		}
		dfs(pos+"-", depth+1, info); // 1-1. "-"���� dfs
		dfs(pos+info[depth], depth+1, info); // 1-2. "-"�� �ƴ� ���� dfs
	}

	// �̺� Ž�� 
	public static int search(String str, int score) {
		if(!allInfo.containsKey(str)) return 0;
		List<Integer> scoreList = allInfo.get(str);
		
		int start = 0, end = scoreList.size()-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(scoreList.get(mid) < score) {
				start = mid+1;	
			}else {
				end = mid-1;
			}
		}
		
		return scoreList.size()-start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(sol.solution(info, query));
	}
}