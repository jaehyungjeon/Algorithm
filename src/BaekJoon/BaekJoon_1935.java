package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
	Question : 후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.

	input			 
	5
	ABC*+DE/-
	1
	2
	3
	4
	5
	
	output
	6.20
	
	Solution : 1. 대문자와 변환할 타입에 대해 map으로 정의해준다.
			   2. stack에 담았다 빼는 동작을 반복하면서 연속된 연산을 add시켜준다.
			   3. 마지막 스택에 남은 값이 최종적으로 계산된 값이다.
			   4. 소숫점 2자리까지 나와야 하므로 String.format 함수를 사용한다.

*/

public class BaekJoon_1935 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String formula = br.readLine();
		Map<String, Double> map = new HashMap<String, Double>();
		Stack<Double> stack = new Stack<Double>();
		
		for(int i=0; i<N; i++) {
			map.put(Character.toString('A'+i), Double.parseDouble(br.readLine()));
		}
		
		double a = 0;
		double b = 0;		
		for(int i=0; i<formula.length(); i++) {
			Character c = formula.charAt(i);

			if(c == '+' || c == '-' || c == '*' || c == '/') { // 수식인 경우
				if(!stack.isEmpty()) {
					switch (c) {
					case '+' :
						a = stack.pop();
						b = stack.pop();
						stack.add(b + a);
						break;
					case '-' :
						a = stack.pop();
						b = stack.pop();
						stack.add(b - a);
						break;
					case '*' :
						a = stack.pop();
						b = stack.pop();
						stack.add(b * a);
						break;
					case '/' : 
						a = stack.pop();
						b = stack.pop();
						stack.add(b / a);
					default:
						break;
					}
				}
			} else {
				stack.add(map.get(String.valueOf(c)));
			}
		}
		
		System.out.println(String.format("%.2f", stack.pop()));
	}

}
