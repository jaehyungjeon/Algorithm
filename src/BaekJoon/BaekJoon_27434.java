package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
	Question : 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

	input			 
	10

	output
	3628800
	
	Solution : 1. 기본적인 팩토리얼 함수
	
*/

public class BaekJoon_27434 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        System.out.println(fact(1, N));
    }
	
    private static BigInteger fact(int a, int n){
        BigInteger ret = BigInteger.valueOf(a);
        if(a < n) {
            int b = (a + n) / 2;
            ret = fact(a, b).multiply(fact(b+1 , n));
        }
        return ret;
    }

}
