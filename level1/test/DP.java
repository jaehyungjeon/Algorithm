package test;

public class DP {
	
	static int[] topDown;
	static int[] bottomTop;
	
	public static void main(String[] args) {
		int n = 30;
		topDown = new int[n+1];
		bottomTop = new int[n+1];
		
		long startTime = System.currentTimeMillis();
		System.out.println(naiveRecursion(n));
		long endTime = System.currentTimeMillis();
		System.out.println("일반 재귀 함수 소요 시간 : " + (endTime - startTime));
		
		System.out.println();
		
		startTime = System.currentTimeMillis();
		System.out.println(topDown(n));
		endTime = System.currentTimeMillis();
		System.out.println("Top-Down 소요 시간 : " + (endTime - startTime));
		
		System.out.println();
		
		startTime = System.currentTimeMillis();
		System.out.println(bottomTop(n));
		endTime = System.currentTimeMillis();
		System.out.println("Bottom-Top 소요 시간 : " + (endTime - startTime));
	}
	
	// Fibonacci
	public static int naiveRecursion(int n) {
		if(n <= 1) {
			return n;
		}
		
		return naiveRecursion(n-1) + naiveRecursion(n-2);
	}
	
	// TopDown
	public static int topDown(int n) {
		if(n<2) return topDown[n] = n;
		
		if(topDown[n] > 0) return topDown[n];
		
		topDown[n] = topDown(n-1) + topDown(n-2);
		
		return topDown[n];
	}
	
	// BottomTop
	public static int bottomTop(int n) {
		bottomTop[0] = 0;
		bottomTop[1] = 1;
		
		for(int i=2; i<=n; i++) {
			bottomTop[i] = bottomTop[i-1] + bottomTop[i-2]; 
		}
		
		return bottomTop[n];
	}
}
