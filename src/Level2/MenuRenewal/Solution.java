package Level2.MenuRenewal;

import java.util.*;

/*
 * Question : 
	레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
	기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 
	어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
	단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

	예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
	(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)

	손님 번호	주문한 단품메뉴 조합
	1번 손님	A, B, C, F, G
	2번 손님	A, C
	3번 손님	C, D, E
	4번 손님	A, C, D, E
	5번 손님	B, C, F, G
	6번 손님	A, C, D, E, H
	가장 많이 함께 주문된 단품메뉴 조합에 따라 "스카피"가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

	코스 종류	메뉴 구성	설명
	요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
	요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
	요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
	요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
 * 
 * 
 * 	Solution : 1. orders를 문자별로 쪼갠 뒤 조합을 만든다. -> dfs를 이용하여 course조건에 부합하는 단어를 생성(2 -> 2개단어, 3 -> 3개단어...)
 * 			   2. 메뉴명별 map 생성 후 갯수를 넣는다.
 * 			   3. 내림차순으로 메뉴명 정렬(많은순서)
 * 			   4. 가장 많은것을 추출하여 새로운 리스트에 담음
 * 			   5. 담긴 값들을 문자열 순으로 정렬(A, B, ...)
 * 			   6. 배열 값 RETURN
 *   
 *   		   ※ 인터넷 참조.. -> 소스 분석 자체는 ok, 생각을 풀어내는 방법을 연구
 * */

public class Solution {

	static List<String> combi;
	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		combi = new ArrayList<>();
		//코스 메뉴조합의 모든 경우의 수 구하기 (dfs)
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

			// course 갯수별로 가장 인기있는 품목 선정 
			for(String courseMenu : list) {
				if(map.get(courseMenu)>1 && courseMenu.length() == course[i]) {
					if(map.get(courseMenu) >= max) {
						res.add(courseMenu);
						max = map.get(courseMenu);
					}
				}
			}
		}

		// 문자순 정렬 
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