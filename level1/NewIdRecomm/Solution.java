package NewIdRecomm;
/*
 * �ű� ���̵� ��õ
 * 
 * Question : īī���� �Ի��� ���� ������ �׿��� "īī������������"�� ��ġ�Ǿ�, īī�� ���񽺿� �����ϴ� �������� ���̵� �����ϴ� ������ ����ϰ� �Ǿ����ϴ�. "�׿�"���� �־��� ù ������ ���� �����ϴ� �������� īī�� ���̵� ��Ģ�� ���� �ʴ� ���̵� �Է����� ��, �Էµ� ���̵�� �����ϸ鼭 ��Ģ�� �´� ���̵� ��õ���ִ� ���α׷��� �����ϴ� ���Դϴ�.
	������ īī�� ���̵��� ��Ģ�Դϴ�.
	
	���̵��� ���̴� 3�� �̻� 15�� ���Ͽ��� �մϴ�.
	���̵�� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.) ���ڸ� ����� �� �ֽ��ϴ�.
	��, ��ħǥ(.)�� ó���� ���� ����� �� ������ ���� �������� ����� �� �����ϴ�.
	"�׿�"�� ������ ���� 7�ܰ��� �������� ó�� ������ ���� �ű� ������ �Է��� ���̵� īī�� ���̵� ��Ģ�� �´� �� �˻��ϰ� ��Ģ�� ���� ���� ��� ��Ģ�� �´� ���ο� ���̵� ��õ�� �ַ��� �մϴ�.
	�ű� ������ �Է��� ���̵� new_id ��� �Ѵٸ�,
	
	1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
	2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
	3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
	4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
	5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
	6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
	     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
	7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
	���� ���, new_id ���� "...!@BaT#*..y.abcdefghijklm" ���, �� 7�ܰ踦 ��ġ�� ���� new_id�� �Ʒ��� ���� ����˴ϴ�.
	
	1�ܰ� �빮�� 'B'�� 'T'�� �ҹ��� 'b'�� 't'�� �ٲ�����ϴ�.
	"...!@BaT#*..y.abcdefghijklm" �� "...!@bat#*..y.abcdefghijklm"
	
	2�ܰ� '!', '@', '#', '*' ���ڰ� ���ŵǾ����ϴ�.
	"...!@bat#*..y.abcdefghijklm" �� "...bat..y.abcdefghijklm"
	
	3�ܰ� '...'�� '..' �� '.'�� �ٲ�����ϴ�.
	"...bat..y.abcdefghijklm" �� ".bat.y.abcdefghijklm"
	
	4�ܰ� ���̵��� ó���� ��ġ�� '.'�� ���ŵǾ����ϴ�.
	".bat.y.abcdefghijklm" �� "bat.y.abcdefghijklm"
	
	5�ܰ� ���̵� �� ���ڿ��� �ƴϹǷ� ��ȭ�� �����ϴ�.
	"bat.y.abcdefghijklm" �� "bat.y.abcdefghijklm"
	
	6�ܰ� ���̵��� ���̰� 16�� �̻��̹Ƿ�, ó�� 15�ڸ� ������ ������ ���ڵ��� ���ŵǾ����ϴ�.
	"bat.y.abcdefghijklm" �� "bat.y.abcdefghi"
	
	7�ܰ� ���̵��� ���̰� 2�� ���ϰ� �ƴϹǷ� ��ȭ�� �����ϴ�.
	"bat.y.abcdefghi" �� "bat.y.abcdefghi"
	
	���� �ű� ������ �Է��� new_id�� "...!@BaT#*..y.abcdefghijklm"�� ��, �׿��� ���α׷��� ��õ�ϴ� ���ο� ���̵�� "bat.y.abcdefghi" �Դϴ�.
	
	[����]
	�ű� ������ �Է��� ���̵� ��Ÿ���� new_id�� �Ű������� �־��� ��, "�׿�"�� ������ 7�ܰ��� ó�� ������ ��ģ ���� ��õ ���̵� return �ϵ��� solution �Լ��� �ϼ��� �ּ���. 
 * 
 *
 */

public class Solution {
	
    public String solution(String new_id) {
        String answer = "";
        
        /* 1�ܰ� : �ҹ��� ��ȯ */
        String convertId = new_id.toLowerCase();
        System.out.println("1�ܰ� : " + new_id + " -> " + convertId);
        
        /* 2�ܰ� : Ư������ ���� */
        String secondId = convertId;
        convertId = convertId.replaceAll("[^a-z0-9-_.]","");
        System.out.println("2�ܰ� : " + secondId + " -> " + convertId);
        
        /* 3�ܰ� : '...'�� '..' -> '.' */
        String thirdId = convertId;
        convertId = convertId.replaceAll("[.]{2,}", ".");
        System.out.println("3�ܰ� : " + thirdId + " -> " + convertId);
        
        /* 4�ܰ� : ù�ܰ� '.' ���� */
        String fourthId = convertId;
        convertId = convertId.replaceAll("^(\\.)", "");
    	System.out.println("4�ܰ� : " + fourthId + " -> " + convertId);
    	
    	/* 5�ܰ� : ���̵� �� ���ڿ��� �ƴϹǷ� ��ȭx */
    	String fifthId = convertId;
    	if(convertId.isEmpty()) {
    		convertId = "a";
    	}
    	System.out.println("5�ܰ� : " + fifthId + " -> " + convertId);
        
    	/* 6�ܰ� : ���̵��� ���̰� 16�� �̻��� ��, ó�� 15�ڸ� ������ ������ ���� ���� */
    	String sixthId = convertId;
    	if(convertId.length() >= 16) {
    		convertId = convertId.substring(0, 15).replaceAll("(\\.)$", "");
    	}
    	System.out.println("6�ܰ� : " + sixthId + " -> " + convertId);
    	
    	/* 7�ܰ� : ���̵��� ���̰� 2�� ���϶��, ���̵��� ������ ���ڸ� ���̵��� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�. */
    	String seventhId = convertId;
    	if(convertId.length() <= 2) {
	    	for(int i = convertId.length(); i<3; i++) {
	    		convertId += convertId.charAt(convertId.length()-1);
	    	}
    	}
    	System.out.println("7�ܰ� : " + seventhId + " -> " + convertId);
    	
    	answer = convertId;
    	
        return answer;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
    	String id = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(sol.solution(id));
	}
}
