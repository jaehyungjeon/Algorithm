package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 동호는 내년에 초등학교를 입학한다. 그래서 동호 어머니는 수학 선행 학습을 위해 쉽게 푸는 문제를 동호에게 주었다.

	이 문제는 다음과 같다. 1을 한 번, 2를 두 번, 3을 세 번, 이런 식으로 1 2 2 3 3 3 4 4 4 4 5 .. 이러한 수열을 만들고 어느 일정한 구간을 주면 그 구간의 합을 구하는 것이다.
	
	하지만 동호는 현재 더 어려운 문제를 푸느라 바쁘기에 우리가 동호를 도와주자.

	input			 
	3 7
	
	output
	15
	
	Solution : 1. n(n+1) / 2

*/

public class BaekJoon_1292 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = 0;

        for(int i=0; i<1000; i++) {
            for(int j=0; j<=i; j++) {
                list.add(i + 1); 
            }
        }

        for(int i=N-1; i<=M-1; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
