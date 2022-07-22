package test;

import java.util.Scanner;

/*

 "OOXXOXXOOO"�� ���� OX������ ����� �ִ�. O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. ������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�. 
 ���� ���, 10�� ������ ������ 3�� �ȴ�.

"OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.

OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 
*/


public class OX {
	
	public static String[] arr;
	public static int[] val;
	public static int totCount;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String result = scan.nextLine();
		
		arr = result.split("");
		val = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			if("O".equals(arr[i])) {
				val[i] = 1;
				if((i > 0) && arr[i].equals(arr[i-1])) {
					val[i] = val[i-1] + 1;  
				}
			} else {
				val[i] = 0;
			}
			
			totCount += val[i];
		}
		
		System.out.println(totCount);
	}
}
