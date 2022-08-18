package Level2.ErosionMax;

import java.util.*;

/*
 * Question : 
	IT 벤처 회사를 운영하고 있는 라이언은 매년 사내 해커톤 대회를 개최하여 우승자에게 상금을 지급하고 있습니다.
	이번 대회에서는 우승자에게 지급되는 상금을 이전 대회와는 다르게 다음과 같은 방식으로 결정하려고 합니다.
	해커톤 대회에 참가하는 모든 참가자들에게는 숫자들과 3가지의 연산문자(+, -, *) 만으로 이루어진 연산 수식이 전달되며, 
	참가자의 미션은 전달받은 수식에 포함된 연산자의 우선순위를 자유롭게 재정의하여 만들 수 있는 가장 큰 숫자를 제출하는 것입니다.
	단, 연산자의 우선순위를 새로 정의할 때, 같은 순위의 연산자는 없어야 합니다. 즉, + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 
	+,* > - 또는 * > +,-처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다. 
	수식에 포함된 연산자가 2개라면 정의할 수 있는 연산자 우선순위 조합은 2! = 2가지이며, 연산자가 3개라면 3! = 6가지 조합이 가능합니다.
	만약 계산된 결과가 음수라면 해당 숫자의 절댓값으로 변환하여 제출하며 제출한 숫자가 가장 큰 참가자를 우승자로 선정하며, 우승자가 제출한 숫자를 우승상금으로 지급하게 됩니다.
	
	예를 들어, 참가자 중 네오가 아래와 같은 수식을 전달받았다고 가정합니다.
	
	"100-200*300-500+20"
	
	일반적으로 수학 및 전산학에서 약속된 연산자 우선순위에 따르면 더하기와 빼기는 서로 동등하며 곱하기는 더하기, 빼기에 비해 우선순위가 높아 * > +,- 로 우선순위가 정의되어 있습니다.
	대회 규칙에 따라 + > - > * 또는 - > * > + 등과 같이 연산자 우선순위를 정의할 수 있으나 +,* > - 또는 * > +,- 처럼 2개 이상의 연산자가 동일한 순위를 가지도록 연산자 우선순위를 정의할 수는 없습니다.
	수식에 연산자가 3개 주어졌으므로 가능한 연산자 우선순위 조합은 3! = 6가지이며, 그 중 + > - > * 로 연산자 우선순위를 정한다면 결괏값은 22,000원이 됩니다.
	반면에 * > + > - 로 연산자 우선순위를 정한다면 수식의 결괏값은 -60,420 이지만, 규칙에 따라 우승 시 상금은 절댓값인 60,420원이 됩니다.
	
	참가자에게 주어진 연산 수식이 담긴 문자열 expression이 매개변수로 주어질 때, 우승 시 받을 수 있는 가장 큰 상금 금액을 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. * > + > -, * > - > +, + > * > -, + > - > *, - > * > +, - > + > * = 6가지
 * 			   2. 특수문자와 숫자를 따로 리스트에 담는다.
 * 			   3. 우선순위에 맞는 계산을 진행한다. -> dfs로 진행하여 visit boolean 방문여부 파악
 * 			   4. 없을때의 경우 -> count + 1 -> count == 3 : + / - / * 모두 진행했을 경우
 * 			   5. 계산을 진행하고 숫자의 리스트에서 해당 지점에 변환 값 셋팅 및 remove 실시
 * 			   6. Math.max를 통해 abs의 절댓값의 최대를 구한다.
 * 
 * */

public class Solution {
	public static List<Long> q = new ArrayList<>();
	public static List<String> exp = new ArrayList<String>();
	public static boolean[] checked = new boolean[3];
	public static String[] prior = {"+", "-", "*"};
	
	public static long answer;
    public long solution(String expression) {
        answer = 0;
        
        String s = "";
        for(int i=0; i<expression.length(); i++) {
        	if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
        		q.add(Long.parseLong(s));
        		exp.add(String.valueOf(expression.charAt(i)));
        		s = "";
        	} else {
        		s += expression.charAt(i);
        	}
        }
        
        q.add(Long.parseLong(s));
        dfs(0, new String[3]);
        
        return answer;
    }

    public static long calc(long a, long b, String cal) {
    	long sum = 0;
    	
    	if(cal == "*") {
    		sum = a * b;
    	} else if(cal == "+") {
    		sum = a + b;
    	} else if(cal == "-") {
    		sum = a - b;
    	}
    	
    	return sum;
    }
    
    public static void dfs(int count, String[] p) {
    	if(count == 3) {
    		ArrayList<Long> cNums = new ArrayList<>(q);
    		ArrayList<String> cOps = new ArrayList<>(exp);
    		System.out.println(cNums);
    		for(int i=0; i<p.length; i++) {
    			for(int j=0; j<cOps.size(); j++) {
    				if(p[i].equals(cOps.get(j))) {
    					Long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
    					cNums.add(j, res);
    					cOps.remove(j);
    					j--;
    				}
    			}
    		}
    			
    		answer = Math.max(answer, Math.abs(cNums.get(0))); // 절댓값의 MAX
    		return;
    	}
    	
    	for(int i=0; i<3; i++) {
    		if(!checked[i]) {
    			checked[i] = true;
    			p[count] = prior[i];
    			dfs(count+1, p);
    			checked[i] = false;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String expression = "100-200*300-500+20";
		System.out.println(sol.solution(expression));
	}
}