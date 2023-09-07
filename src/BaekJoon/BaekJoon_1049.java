package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다. 따라서 새로운 줄을 사거나 교체해야 한다. 
	강토는 되도록이면 돈을 적게 쓰려고 한다. 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.

	끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 
	낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.

	input			 
	4 2
	12 3
	15 4
	
	output
	12
	
	Solution : 1. 6개 묶음의 가격이 첫번째 배열, 낱개가 2번째 배열이다.
			   2. Min값을 구해주는 프로그램을 만들면 된다.
			   3. 6개 묶음 중 최소로 나누고 나머지 낱개도 최소로 더해준 금액과 낱개의 최소로 개수만큼 구매했을때 누가 더 최소인지를 파악하면 될 듯.
			   4. 패키지만 샀을경우, 낱개만 샀을경우, 패키지 + 낱개를 샀을 경우 3가지 경우의 최솟값을 구하여 리턴해주면 된다.
	
*/

public class BaekJoon_1049 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer Min = Integer.MAX_VALUE;
		
		int count = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		Integer[] pkg = new Integer[N];
		Integer[] indi = new Integer[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pkg[i] = Integer.parseInt(st.nextToken());
			indi[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각각 오름차순으로 정렬
		Arrays.sort(pkg);
		Arrays.sort(indi);

		// Min값 비교(패키만 샀을 경우, 낱개만 샀을 경우, 패키지와 낱개를 섞어서 샀을 경우)
		Min = Math.min(((count/6) * pkg[0] + (count%6) * indi[0]), (count * indi[0]));
		Min = Math.min(((count/6)+1) * pkg[0], Min);
		
		System.out.println(Min);
	}

}
