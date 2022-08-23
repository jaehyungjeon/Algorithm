package Level2.RankSearch;

import java.util.*;

/*
 * Question : 
	카카오는 하반기 경력 개발자 공개채용을 진행 중에 있으며 현재 지원서 접수와 코딩테스트가 종료되었습니다. 이번 채용에서 지원자는 지원서 작성 시 아래와 같이 4가지 항목을 반드시 선택하도록 하였습니다.

	코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
	지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
	지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
	선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.
	인재영입팀에 근무하고 있는 니니즈는 코딩테스트 결과를 분석하여 채용에 참여한 개발팀들에 제공하기 위해 지원자들의 지원 조건을 선택하면 해당 조건에 맞는 지원자가 몇 명인 지 쉽게 알 수 있는 도구를 만들고 있습니다.
	예를 들어, 개발팀에서 궁금해하는 문의사항은 다음과 같은 형태가 될 수 있습니다.
	코딩테스트에 java로 참여했으며, backend 직군을 선택했고, junior 경력이면서, 소울푸드로 pizza를 선택한 사람 중 코딩테스트 점수를 50점 이상 받은 지원자는 몇 명인가?

	물론 이 외에도 각 개발팀의 상황에 따라 아래와 같이 다양한 형태의 문의가 있을 수 있습니다.

	코딩테스트에 python으로 참여했으며, frontend 직군을 선택했고, senior 경력이면서, 소울푸드로 chicken을 선택한 사람 중 코딩테스트 점수를 100점 이상 받은 사람은 모두 몇 명인가?
	코딩테스트에 cpp로 참여했으며, senior 경력이면서, 소울푸드로 pizza를 선택한 사람 중 코딩테스트 점수를 100점 이상 받은 사람은 모두 몇 명인가?
	backend 직군을 선택했고, senior 경력이면서 코딩테스트 점수를 200점 이상 받은 사람은 모두 몇 명인가?
	소울푸드로 chicken을 선택한 사람 중 코딩테스트 점수를 250점 이상 받은 사람은 모두 몇 명인가?
	코딩테스트 점수를 150점 이상 받은 사람은 모두 몇 명인가?
	즉, 개발팀에서 궁금해하는 내용은 다음과 같은 형태를 갖습니다.

 * [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?
 * 
 * 
 * 	Solution : 1. 인터넷 참고..
 * 			   2. dfs로 만들 수 있는 모든 INFO의 경우의 수를 구한다 -> 1-1과 1-2를 재귀 -> 모든 케이스 도출
 * 			   3. map에 저장된 점수 list를 오름차순으로 정렬시킴 -> keySet으로 리스트를 꾸려 해당 리스트의 오름차순 정렬(Map to List)
 * 			   4. score 비교하는 이분탐색 실시 -> 전체 score리스트에서 score보다 낮은 점수인 케이스만큼 차감
 * 			   5. answer 배열에 담아서 return
 * 			   6. 처음 짜기에는 생각을 많이해야하고 아이디어가 필요.. 코드 자체는 이해가 안되는 수준은 아님.
 * 
 * */

public class Solution {

	public static Map<String, ArrayList<Integer>> allInfo;
	public static ArrayList<Integer> in;
	
	public int[] solution(String[] info, String[] query) {

		int[] answer = new int[query.length];
		allInfo = new HashMap<>();

		// 1. info 모든 경우의 수 map에 저장 
		for(int i=0; i<info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}
		
		// 2. map에 저장된 점수 list 오름차순으로 정렬 	
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
		dfs(pos+"-", depth+1, info); // 1-1. "-"형태 dfs
		dfs(pos+info[depth], depth+1, info); // 1-2. "-"가 아닌 형태 dfs
	}

	// 이분 탐색 
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