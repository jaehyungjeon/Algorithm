package Level1.LackMoneyCal;

import java.util.*;

/*
 * Question : 
	���� ���� ���̱ⱸ�� �αⰡ �ſ� ���� ���� ������ �ʽ��ϴ�. 
	�� ���̱ⱸ�� ���� �̿��� price�� �ε�, ���̱ⱸ�� N �� ° �̿��Ѵٸ� ���� �̿���� N�踦 �ޱ�� �Ͽ����ϴ�.
	��, ó�� �̿�ᰡ 100�̾��ٸ� 2��°���� 200, 3��°���� 300���� ����� �λ�˴ϴ�.
	���̱ⱸ�� count�� Ÿ�� �Ǹ� ���� �ڽ��� ������ �ִ� �ݾ׿��� �󸶰� ���ڶ������ return �ϵ��� solution �Լ��� �ϼ��ϼ���.
	��, �ݾ��� �������� ������ 0�� return �ϼ���.
	
 * 
 * 	Solution : 1. Ǯ�� ��ü�� ����� �ʾ�����, ������ long Ÿ���̶�� ���� �����Ͽ� �ڵ��� �Ͽ���� ��.
 * 			   2. ��ü�� ��� ������ int�� �� ��� longŸ�� ������ �񱳰� ������ �� �ֱ� ������ long���� �����Ͽ� ��갪 �־� ����ؾ� ��.
 * 
 * */

public class Solution {

    public long solution(int price, int money, int count) {
        long answer = 0;

        long tot = 0;
        for(int i=1; i<=count; i++) {
        	tot += (price * i);
        }
        
        if(tot > money) answer = tot - money;
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int price = 3;
    	int money = 20;
    	int count = 4;
		System.out.println(sol.solution(price, money, count));
	}
}
