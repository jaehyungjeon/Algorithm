package Level2.GoodsOffSalesSQL;

import java.util.*;

/*
 * Question : PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 
			  결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.
 * 
 * 	Solution : 1. 테이블 조인
 * 			   2. (판매수량 * 가격)의 SUM
 * 			   3. GROUP BY로 상품코드 기준 감싸줌
 * 			   4. 정렬 실시
 *  
 * */

public class Solution {
	SELECT A.PRODUCT_CODE,
	       SUM(B.SALES_AMOUNT * A.PRICE) AS SALES
	FROM PRODUCT A,
	  	 OFFLINE_SALE B
	WHERE A.PRODUCT_ID = B.PRODUCT_ID
	GROUP BY A.PRODUCT_CODE
	ORDER BY SUM(B.SALES_AMOUNT * A.PRICE) DESC, A.PRODUCT_CODE
}