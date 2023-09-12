package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
	Question : 해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 
	예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 
	해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
	
	input			 
	2
	3
	hat headgear
	sunglasses eyewear
	turban headgear
	3
	mask face
	sunglasses face
	makeup face
	
	output
	5
	3
	
	Solution : 1. Map에 type별 개수를 담아준다.
	 		   2. 결국 조합순열을 구하는 것이므로 각 타입별 값 + 1을 곱해준 후 알몸을 제외하기 위한 -1을 해준다.

*/

public class BaekJoon_9375 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) { // TC
			int N = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String wear = st.nextToken();
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			
			int sum = 1;
			for (int val : map.values()) {
				sum *= (val + 1);
			}
			
			sb.append(sum - 1).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
