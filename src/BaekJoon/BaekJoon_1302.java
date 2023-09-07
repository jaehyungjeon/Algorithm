package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Question : 김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 
	김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.

	오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.

	input			 
	5
	top
	top
	top
	top
	kimtop
	
	output
	top
	
	Solution : 1. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
			   2. 단순 정렬 문제.
			   3. Map에 값을 담고 List로 책의 제목을 넣는 리스트를 구성해준 뒤 sort 해준다.
	
*/

public class BaekJoon_1302 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}
		
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, (o1, o2) -> {
			if(map.get(o1).equals(map.get(o2))) {
				return o1.compareTo(o2);
			}
			return map.get(o2) - map.get(o1);
		});
		
		System.out.println(list.get(0));
	}

}
