package BaekJoon;

import java.util.Scanner;

/*
	Question : 홍익대학교는 1946년에 개교하였다.

	특정 년도가 주어졌을 때, 그 해가 개교 몇 주년인지 출력하라.
	
	단, 홍익대학교는 없어지지 않는다고 가정한다.
	
	문제는 C, C++, JAVA 또는 Python3을 이용하여 해결한다.
	
	C
	입력
	scanf 사용
	정수 %d, 실수 %f, 문자열 %s 사용
	scanf("%d", &var);
	출력
	정수 %d, 실수 %f, 문자열 %s 사용
	예) printf("%d", var);
	필수 라이브러리 stdio.h
	C++
	입력
	cin 사용
	예) cin >> var;
	출력
	cout 사용
	예) cout << var;
	필수 라이브러리 iostream
	권장사항
	using namespace std;
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	Java
	입력
	Scanner 사용
	Scanner sc = new Scanner(System.in); 정수: sc.nextInt(); 실수: sc.nextDouble(); 문자열: sc.nextLine(); 또는 sc.next();
	출력
	System.out.println(var);
	필수 라이브러리 java.util.Scanner

	input
	2018
	
	output
	72
	
	Solution : 1. (N - 1946)

*/

public class BaekJoon_16394 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(N - 1946);
	}

}
