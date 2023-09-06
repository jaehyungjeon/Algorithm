package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
	Question : 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

	아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
	
	아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

	input			 
	20
	7
	23
	19
	10
	15
	25
	8
	13
	
	output
	7
	8
	10
	13
	19
	20
	23
	
	Solution : 1. 브루트포스 알고리즘으로 구현.
			   2. 2명의 합이 100이 될 때 오름차순 정렬 후 출력.
	
*/

public class BaekJoon_2309 {

	 public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	sum += arr[i];
        }
        
        for (int i = 0; i < 8; i++) {
        	for (int j = i+1; j < 9; j++) {
        		if (sum - arr[i] - arr[j] == 100) {
        			arr[i] = 0;
        			arr[j] = 0;
        			Arrays.sort(arr);
        			for (int k = 2; k < 9; k++) {
        				System.out.println(arr[k]);
        			}
        			return;
        		}
            }
        }
    }
}
