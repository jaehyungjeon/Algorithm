package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	Question : 준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.

	준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
	
	input			 
	5
	1
	2
	1
	2
	1
	
	output
	1
	
	Solution : 1. -2^65 ~ 2^65 이므로 long타입으로 받아주어야 겠다.
			   2. 기존 정렬방식과 동일하게 풀었다.
	
*/

public class BaekJoon_11652 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		for(int i=0; i<N; i++) {
			Long val = Long.parseLong(br.readLine());
			map.put(val, map.getOrDefault(val, Long.parseLong("0")) + 1);
		}
		
		List<Long> list = new ArrayList<Long>(map.keySet());
		Collections.sort(list, (o1, o2) -> {
			if(map.get(o1).equals(map.get(o2))) {
				return o1.compareTo(o2);
			}
			return map.get(o2).compareTo(map.get(o1));
		});
		
		System.out.println(list.get(0));
		
	}

}
