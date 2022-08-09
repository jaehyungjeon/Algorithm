package Level2.BracketChange;

import java.util.*;

/*
 * Question : 
	īī���� ���� �����ڷ� �Ի��� "��"�� ���� �����ڷκ��� ���߿��� ��ȭ�� ���� �ٸ� �����ڰ� �ۼ��� �ҽ� �ڵ带 �м��Ͽ� �������� �߰��ϰ� �����϶�� ���� ������ �޾ҽ��ϴ�. 
	�ҽ��� �������Ͽ� �α׸� ���� ��κ� �ҽ� �ڵ� �� �ۼ��� ��ȣ�� ������ ������ ¦�� ���� ���� ���·� �ۼ��Ǿ� ������ ���� ���� �˰� �Ǿ����ϴ�.
	�����ؾ� �� �ҽ� ������ �ʹ� ���Ƽ� ����ϴ� "��"�� �ҽ� �ڵ忡 �ۼ��� ��� ��ȣ�� �̾Ƽ� �ùٸ� ������� ��ġ�� ��ȣ ���ڿ��� �˷��ִ� ���α׷��� ������ ���� �����Ϸ��� �մϴ�.
	
	����� ����
	'(' �� ')' �θ� �̷���� ���ڿ��� ���� ���, '(' �� ������ ')' �� ������ ���ٸ� �̸� �������� ��ȣ ���ڿ��̶�� �θ��ϴ�.
	�׸��� ���⿡ '('�� ')'�� ��ȣ�� ¦�� ��� ���� ��쿡�� �̸� �ùٸ� ��ȣ ���ڿ��̶�� �θ��ϴ�.
	���� ���, "(()))("�� ���� ���ڿ��� "�������� ��ȣ ���ڿ�" ������ "�ùٸ� ��ȣ ���ڿ�"�� �ƴմϴ�.
	�ݸ鿡 "(())()"�� ���� ���ڿ��� "�������� ��ȣ ���ڿ�" �̸鼭 ���ÿ� "�ùٸ� ��ȣ ���ڿ�" �Դϴ�.
	
	'(' �� ')' �θ� �̷���� ���ڿ� w�� "�������� ��ȣ ���ڿ�" �̶�� ������ ���� ������ ���� "�ùٸ� ��ȣ ���ڿ�"�� ��ȯ�� �� �ֽ��ϴ�.
	
	1. �Է��� �� ���ڿ��� ���, �� ���ڿ��� ��ȯ�մϴ�. 
	2. ���ڿ� w�� �� "�������� ��ȣ ���ڿ�" u, v�� �и��մϴ�. ��, u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� �ϸ�, v�� �� ���ڿ��� �� �� �ֽ��ϴ�. 
	3. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�" �̶�� ���ڿ� v�� ���� 1�ܰ���� �ٽ� �����մϴ�. 
	  3-1. ������ ��� ���ڿ��� u�� �̾� ���� �� ��ȯ�մϴ�. 
	4. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�"�� �ƴ϶�� �Ʒ� ������ �����մϴ�. 
	  4-1. �� ���ڿ��� ù ��° ���ڷ� '('�� ���Դϴ�. 
	  4-2. ���ڿ� v�� ���� 1�ܰ���� ��������� ������ ��� ���ڿ��� �̾� ���Դϴ�. 
	  4-3. ')'�� �ٽ� ���Դϴ�. 
	  4-4. u�� ù ��°�� ������ ���ڸ� �����ϰ�, ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ���Դϴ�. 
	  4-5. ������ ���ڿ��� ��ȯ�մϴ�.
	"�������� ��ȣ ���ڿ�" p�� �Ű������� �־��� ��, �־��� �˰����� ������ "�ùٸ� ��ȣ ���ڿ�"�� ��ȯ�� ����� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 
 * 	Solution : 1. ���ͳ� ����..
 * 			   2. u : �����ؾ� �� ��ȣ , v : �������� ��ȣ -> u : �Ϻ��� ���·� ����� ���� �ݺ� ���� �ʿ�
 * 			   3. '(', ')' ���� ���� left, right++ ������ ������ ������ ��ġ�� ��� �ش� �ε����� �������� �����ϱ� ���� return �ǽ�
 * 			   4. ���� ������ ����� index ������ ��ȯ�� + index ������ ������ ������ StringBuilder�� ��� ����� ��������.
 * 
 * */

public class Solution {

	public static int index = 0;
	
    public String solution(String p) {
        String answer = "";
        
        if(p.equals("")) return p;
        
        boolean isCorrect = divide(p);
        String u = p.substring(0, index);
        String v = p.substring(index);
        if(isCorrect) return u+solution(v);
        
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(solution(v)); // �ݺ������� ��ȯ��ų ��
        sb.append(")");
        
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                sb.append(')');
            else
                sb.append('(');
        }

        answer = sb.toString();
        return answer;
    }
    
    public static boolean divide(String p) {
    	boolean isCorrect = true;
    	int left = 0;
    	int right = 0;
    	
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0; i<p.length(); i++) {
    		char c = p.charAt(i);
    		
    		if(c == '(') {
    			stack.add(c);
    			left++;
    		} else {
    			right++;
    			if(!stack.isEmpty() && stack.peek() == '(') {
    				stack.pop();
    			} else {
    				stack.add(c);
    				isCorrect = false;
    			}
    		}
    		
    		if(left == right) {
    			index = i + 1;
    			break;
    		}
    	}
    	
    	return isCorrect;		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String p = "()))((()";
		System.out.println(sol.solution(p));
	}
}