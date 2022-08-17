package Level2.NLCM;

/*
 * Question : 
	두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 
	예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
	n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 * 
 * 
 * 	Solution : 1. 최대공약수를 구하는 gcd
 * 			   2. 곱한 값을 최대 공배수로 나누어 준것들을 곱한다. -> 최소 공배수
 * 
 * */

public class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
        	int gcd = gcd(answer, arr[i]);
        	
        	answer = answer * arr[i] / gcd;
        }
        
        return answer;
    }
    
    public static int gcd(int a, int b) {
    	int x = Math.max(a, b);
    	int y = Math.min(a, b);
    	
    	while(x % y != 0) {
    		int r = x % y;
    		x = y;
    		y = r;
    	}
    	
    	return y;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] arr = {1,2,3};
		System.out.println(sol.solution(arr));
	}
}