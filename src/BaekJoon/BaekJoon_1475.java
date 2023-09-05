package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
	Question : 다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

	다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
	다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
	
	input			 
	9999
	
	output
	2
	
	Solution : 1. map으로 구성하면 쉬울것 같아서 구성하였다.
			   2. 6과 9는 동일한 기능으로 보고 6에다가 같이 합산하였다.
			   3. 6과 9의 개수가 홀수일 경우는 나눈다음 +1을 하여 최소의 개수를 구해준다.
			   4. 다른 값들과 비교하여 Max의 값을 도출해준다.

*/

public class BaekJoon_1475 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int Max = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("6") || arr[i].equals("9")) {
				map.put("6", map.getOrDefault("6", 0) + 1);
			} else {
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			}
		}
		
		for(String str : map.keySet()) {
			int tmp = map.get(str);
			if(str.equals("6")) {
				if(tmp%2 == 0) {
					tmp /= 2;
				} else {
					tmp = tmp/2 + 1;
				}
			}
			
			Max = Math.max(tmp, Max);
		}
		
		System.out.println(Max);
	}

}
