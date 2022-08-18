package Level2.ThreeNTiling;

/*
 * Question : 
	가로 길이가 2이고 세로의 길이가 1인 직사각형 모양의 타일이 있습니다. 
	이 직사각형 타일을 이용하여 세로의 길이가 3이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다. 타일을 채울 때는 다음과 같이 2가지 방법이 있습니다

	타일을 가로로 배치 하는 경우
	타일을 세로로 배치 하는 경우
	예를들어서 n이 8인 직사각형은 다음과 같이 채울 수 있습니다.
	
	직사각형의 가로의 길이 n이 매개변수로 주어질 때, 이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. 홀수에서는 구성자체가 이뤄지지 않음 -> 짝수만
 * 			   2. 규칙성을 찾기가 어려워서 오픈 소스 참고
 * 			    
 * */

public class Solution {

    public int solution(int n) {
        return Fibonacci(n);
    }
    
    public static int Fibonacci(int n) {
    	long[] arr = new long[5001]; // 가로의 길이는 5000 이하의 자연수이므로, 5001로 배열 초기화
    	arr[0] = 1;
    	arr[2] = 3;
    	
		for(int i=4; i<=n; i+=2) { // 짝수로 증가
			arr[i] = arr[i-2] * 3;
			for(int j=i-4; j>=0; j-=2) { // 내림차순으로
				arr[i] += arr[j] * 2;
			}
			arr[i] = arr[i] % 1000000007;
		}
    	
    	return (int)arr[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}