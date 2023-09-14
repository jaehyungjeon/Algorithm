package BaekJoon;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
	Question : 서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.

	input			 
	
	output
	2015-01-24
	
	Solution : 1. Date 객체 활용하면 된다.

*/

public class BaekJoon_10699 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(format.format(date));
	}

}
