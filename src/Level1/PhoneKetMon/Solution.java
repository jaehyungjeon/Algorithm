package Level1.PhoneKetMon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/*
 * Question : 
	����� ���ϸ��� ��� ���� ���� ���� ����, ȫ �ڻ���� �����ǿ� �����߽��ϴ�. ȫ �ڻ���� ��ſ��� �ڽ��� �����ǿ� �ִ� �� N ������ ���ϸ� �߿��� N/2������ �������� ���ٰ� �߽��ϴ�.
	ȫ �ڻ�� �������� ���ϸ��� ������ ���� ��ȣ�� �ٿ� �����մϴ�. ���� ���� ������ ���ϸ��� ���� ��ȣ�� ������ �ֽ��ϴ�. 
	���� ��� �����ǿ� �� 4������ ���ϸ��� �ְ�, �� ���ϸ��� ���� ��ȣ�� [3��, 1��, 2��, 3��]�̶�� �̴� 3�� ���ϸ� �� ����, 1�� ���ϸ� �� ����, 2�� ���ϸ� �� ������ ������ ��Ÿ���ϴ�. 
	�̶�, 4������ ���ϸ� �� 2������ ���� ����� ������ ���� 6������ �ֽ��ϴ�.
	
	ù ��°(3��), �� ��°(1��) ���ϸ��� ����
	ù ��°(3��), �� ��°(2��) ���ϸ��� ����
	ù ��°(3��), �� ��°(3��) ���ϸ��� ����
	�� ��°(1��), �� ��°(2��) ���ϸ��� ����
	�� ��°(1��), �� ��°(3��) ���ϸ��� ����
	�� ��°(2��), �� ��°(3��) ���ϸ��� ����
	�̶�, ù ��°(3��) ���ϸ�� �� ��°(3��) ���ϸ��� �����ϴ� ����� �� ����(3�� ���ϸ� �� ����)�� ���ϸ� ���� �� ������, 
	�ٸ� ������� ��� �� ������ ���ϸ��� ���� �� �ֽ��ϴ�. ���� �� ���ÿ��� ���� �� �ִ� ���ϸ� ���� ���� �ִ��� 2�� �˴ϴ�.
	����� �ִ��� �پ��� ������ ���ϸ��� ������ ���ϱ� ������, �ִ��� ���� ������ ���ϸ��� �����ؼ� N/2������ �����Ϸ� �մϴ�. 
	N���� ���ϸ��� ���� ��ȣ�� ��� �迭 nums�� �Ű������� �־��� ��, 
	N/2������ ���ϸ��� �����ϴ� ��� ��, ���� ���� ������ ���ϸ��� �����ϴ� ����� ã��, �׶��� ���ϸ� ���� ��ȣ�� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
 * 
 * 	Solution : 1. ó������ ��ư� �����߾���.. -> key, value�� map�� ���� ��Ƽ� value ���� ���� ���� entry ���� ������ default�� ���� �����ϰ�, �迭�� ��ȸ�ϰ��� �Ͽ���.
 * 			   2. HashSet���� �ߺ� ����
 * 			   3. ���� ������ ���� �� �Է� �����Ѵ�. 
 * */

public class Solution {
	
	public HashSet<Integer> set = new HashSet<Integer>();
	
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int num : nums) {
        	set.add(num);
        }
        
        int tot = nums.length;
        if(set.size() > (tot/2)) {
        	answer = tot/2;
        } else {
        	answer = set.size();
        }
        return answer;
    }
    
    /* ��� �� ���ߵ��̳�.. */
    public int solution2(int[] nums) {
    	return Arrays.stream(nums).boxed().collect(Collectors.collectingAndThen(Collectors.toSet(),
    			phonekemons -> Integer.min(phonekemons.size(), nums.length/2)));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] nums = {3,3,3,2,2,4};
		System.out.println(sol.solution(nums));
		System.out.println(sol.solution2(nums));
	}
}