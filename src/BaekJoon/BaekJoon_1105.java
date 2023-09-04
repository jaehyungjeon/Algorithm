package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : L과 R이 주어진다. 이때, L보다 크거나 같고, R보다 작거나 같은 자연수 중에 8이 가장 적게 들어있는 수에 들어있는 8의 개수를 구하는 프로그램을 작성하시오. 
	 	
	input			 
	8808 8880
	
	output
	2
	
	Solution : 1. 단순하게 자릿수가 같을 경우 각 자리에 8이 들어갈 때가 최소인 순간이다.
			   2. 따라서, 들어오는 값을 배열로 구성해준 2개의 배열이 동일하면서, 8인 순간일때만 카운트를 증가시키면 된다.
*/

public class BaekJoon_1105 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] str1 = st.nextToken().toCharArray();
		char[] str2 = st.nextToken().toCharArray();
		int count = 0;
		
		if(str1.length == str2.length) {
			for(int i=0; i<str1.length; i++) {
				if(str1[i] == str2[i] && str1[i] == '8') {
					count++;
				} else if(str1[i] != str2[i]) {
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
