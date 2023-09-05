package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 준규가 사는 나라는 우리가 사용하는 연도와 다른 방식을 이용한다. 준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다. 각각의 수는 지구, 태양, 그리고 달을 나타낸다.

	지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M이라고 했을 때, 이 세 수는 서로 다른 범위를 가진다. (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
	
	우리가 알고있는 1년은 준규가 살고있는 나라에서는 1 1 1로 나타낼 수 있다. 1년이 지날 때마다, 세 수는 모두 1씩 증가한다. 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.
	
	예를 들어, 15년은 15 15 15로 나타낼 수 있다. 하지만, 1년이 지나서 16년이 되면 16 16 16이 아니라 1 16 16이 된다. 이유는 1 ≤ E ≤ 15 라서 범위를 넘어가기 때문이다.
	
	E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때, 준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.
	
	input			 
	1 2 3
	
	output
	5266
	
	Solution : 1. 어렵게 생각하지 않고 while문으로 각 년도를 증감시켜주면 된다.
			   2. 최종년도를 반환할 year를 증가시키고 E와 S, M이 각각 최대에 도달하면 다시 1로 초기화 해주는 방식을 반복하면 된다.
			   3. E,S,M과 E,S,M의 값이 같아질 경우에 반복문을 break 시킨다.

*/

public class BaekJoon_1476 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken()); // Max 15
		int S = Integer.parseInt(st.nextToken()); // Max 28
		int M = Integer.parseInt(st.nextToken()); // Max 19
		
		int EValue = 0;
		int SValue = 0;
		int MValue = 0;
		int year = 0;
		
		while(true) {
			year++;
			EValue++;
			SValue++;
			MValue++;
			if(EValue==16) EValue = 1;
			if(SValue==29) SValue = 1;
			if(MValue==20) MValue = 1;
			
			if(E == EValue && S == SValue && M == MValue) break;
		}
		
		System.out.println(year);
	}

}
