package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
	Question : 사파리월드는 인터넷으로만 존재하는 미스테리한 나라이다. 
	사파리월드에는 2개의 서브도메인이 seunghwan.royal.gov.sw와 kyuhyun.royal.gov.sw 이 있는데, 이것이 couple.royal.gov.sw으로 합쳐질 것이다. 
	그러나 도메인 관리 센터 SWNIC(센터장: 김동규)에는 엄격한 룰이 있다. 
	두 서브도메인을 합칠 때, 유명도의 차이가 너무 차이나지 않을 경우에만 두 서브도메인을 결혼시키는 것이다. 
	서브도메인의 유명도는 정수이다. 두 서브도메인의 유명도가 주어졌을 때, 그 차이를 구하는 프로그램을 작성하시오.

	input			 
	-2 5
	
	output
	7
	
	Solution : 1. BigInteger를 안쓰면 범위를 벗어나서 안될 듯..? 

*/

public class BaekJoon_2420 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger N = new BigInteger(st.nextToken());
		BigInteger M = new BigInteger(st.nextToken());

		System.out.println(N.subtract(M).abs());
	}

}
