package Level2.ErosionMax;

import java.util.*;

/*
 * Question : 
	IT ��ó ȸ�縦 ��ϰ� �ִ� ���̾��� �ų� �系 ��Ŀ�� ��ȸ�� �����Ͽ� ����ڿ��� ����� �����ϰ� �ֽ��ϴ�.
	�̹� ��ȸ������ ����ڿ��� ���޵Ǵ� ����� ���� ��ȸ�ʹ� �ٸ��� ������ ���� ������� �����Ϸ��� �մϴ�.
	��Ŀ�� ��ȸ�� �����ϴ� ��� �����ڵ鿡�Դ� ���ڵ�� 3������ ���깮��(+, -, *) ������ �̷���� ���� ������ ���޵Ǹ�, 
	�������� �̼��� ���޹��� ���Ŀ� ���Ե� �������� �켱������ �����Ӱ� �������Ͽ� ���� �� �ִ� ���� ū ���ڸ� �����ϴ� ���Դϴ�.
	��, �������� �켱������ ���� ������ ��, ���� ������ �����ڴ� ����� �մϴ�. ��, + > - > * �Ǵ� - > * > + ��� ���� ������ �켱������ ������ �� ������ 
	+,* > - �Ǵ� * > +,-ó�� 2�� �̻��� �����ڰ� ������ ������ �������� ������ �켱������ ������ ���� �����ϴ�. 
	���Ŀ� ���Ե� �����ڰ� 2����� ������ �� �ִ� ������ �켱���� ������ 2! = 2�����̸�, �����ڰ� 3����� 3! = 6���� ������ �����մϴ�.
	���� ���� ����� ������� �ش� ������ �������� ��ȯ�Ͽ� �����ϸ� ������ ���ڰ� ���� ū �����ڸ� ����ڷ� �����ϸ�, ����ڰ� ������ ���ڸ� ��»������ �����ϰ� �˴ϴ�.
	
	���� ���, ������ �� �׿��� �Ʒ��� ���� ������ ���޹޾Ҵٰ� �����մϴ�.
	
	"100-200*300-500+20"
	
	�Ϲ������� ���� �� �����п��� ��ӵ� ������ �켱������ ������ ���ϱ�� ����� ���� �����ϸ� ���ϱ�� ���ϱ�, ���⿡ ���� �켱������ ���� * > +,- �� �켱������ ���ǵǾ� �ֽ��ϴ�.
	��ȸ ��Ģ�� ���� + > - > * �Ǵ� - > * > + ��� ���� ������ �켱������ ������ �� ������ +,* > - �Ǵ� * > +,- ó�� 2�� �̻��� �����ڰ� ������ ������ �������� ������ �켱������ ������ ���� �����ϴ�.
	���Ŀ� �����ڰ� 3�� �־������Ƿ� ������ ������ �켱���� ������ 3! = 6�����̸�, �� �� + > - > * �� ������ �켱������ ���Ѵٸ� �ᱣ���� 22,000���� �˴ϴ�.
	�ݸ鿡 * > + > - �� ������ �켱������ ���Ѵٸ� ������ �ᱣ���� -60,420 ������, ��Ģ�� ���� ��� �� ����� ������ 60,420���� �˴ϴ�.
	
	�����ڿ��� �־��� ���� ������ ��� ���ڿ� expression�� �Ű������� �־��� ��, ��� �� ���� �� �ִ� ���� ū ��� �ݾ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. * > + > -, * > - > +, + > * > -, + > - > *, - > * > +, - > + > * = 6����
 * 			   2. Ư�����ڿ� ���ڸ� ���� ����Ʈ�� ��´�.
 * 			   3. �켱������ �´� ����� �����Ѵ�. -> dfs�� �����Ͽ� visit boolean �湮���� �ľ�
 * 			   4. �������� ��� -> count + 1 -> count == 3 : + / - / * ��� �������� ���
 * 			   5. ����� �����ϰ� ������ ����Ʈ���� �ش� ������ ��ȯ �� ���� �� remove �ǽ�
 * 			   6. Math.max�� ���� abs�� ������ �ִ븦 ���Ѵ�.
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
    			
    		answer = Math.max(answer, Math.abs(cNums.get(0))); // ������ MAX
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