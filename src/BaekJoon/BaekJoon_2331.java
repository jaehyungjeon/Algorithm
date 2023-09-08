package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 다음과 같이 정의된 수열이 있다.

	D[1] = A
	D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
	예를 들어 A=57, P=2일 때, 수열 D는 [57, 74(=52+72=25+49), 65, 61, 37, 58, 89, 145, 42, 20, 4, 16, 37, …]이 된다. 그 뒤에는 앞서 나온 수들(57부터가 아니라 58부터)이 반복된다.
	
	이와 같은 수열을 계속 구하다 보면 언젠가 이와 같은 반복수열이 된다. 이때, 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 구하는 프로그램을 작성하시오. 
	위의 예에서는 [57, 74, 65, 61]의 네 개의 수가 남게 된다.

	input			 
	57 2
	
	output
	4
	
	Solution : 1. 자릿수의 n제곱만큼 pow하다가 일치하는 것이 있으면 break 후 해당 값을 리스트에서 지운 뒤 남은 것들을 반환해주면 됨.
			   2. while문으로 계속 반복해주면서 자릿수 값을 더해주다가 동일한 값이 나오면 subList로 리스트를 추린 후, break
			   3. 리턴은 리스트의 사이즈를 리턴해주면 된다.
	
*/

public class BaekJoon_2331 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int deli = Integer.parseInt(st.nextToken());
		List<Long> list = new ArrayList<Long>();
		list.add(Long.parseLong(N));

		int idx = 0;
		boolean check = false;
		while(true) {
			for(int j=idx; j<list.size(); j++) {
				String[] arr = String.valueOf(list.get(idx)).split("");
				long sum = 0;
				for(int i=0; i<arr.length; i++) {
					sum += Math.pow(Integer.parseInt(arr[i]), deli);
				}
				
				if(list.contains(sum)) {
					int index = list.indexOf(sum);
					list = list.subList(0, index);
					check = true;
					break;
				} else {
					list.add(sum);
					idx++;
				}
			}
			
			if(check) break;
		}
		
		System.out.println(list.size());
		
	}

}
