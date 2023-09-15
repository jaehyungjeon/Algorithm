package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 당신은 싸이컴을 향해 절을 하려고 합니다. 하지만, 당신이 싸이컴에 들어오고 싶어서 절을 한 번 할 수도 있고, 싸이컴을 매우 싫어해 절을 두 번 할 수도 있습니다.

	당신이 절을 할 횟수가 주어질 때, 그 횟수만큼 절하는 프로그램을 작성하세요. 실제로 프로그램을 이용해 절을 할 수는 없기 때문에, 대신 “SciComLove”를 출력하도록 합니다.

	input			 
	1
	
	output
	SciComLove
	
	Solution : 1. 반복문 출력
	
*/

public class BaekJoon_21598 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			System.out.println("SciComLove");
		}
	}

}
