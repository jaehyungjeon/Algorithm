package Level2.SectionPriceSQL;

import java.util.*;

/*
 * Question : PRODUCT 테이블에서 만원 단위의 가격대 별로 상품 개수를 출력하는 SQL 문을 작성해주세요. 
  			  이때 컬럼명은 각각 컬럼명은 PRICE_GROUP, PRODUCTS로 지정해주시고 가격대 정보는 각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시해주세요. 
  			  결과는 가격대를 기준으로 오름차순 정렬해주세요.
 * 
 * 	Solution : 1. TRUNC를 이용하여 가격별 구간 측정
 * 			   2. 서브쿼리로 감싼 뒤 PRODUCT_CODE의 COUNT 계산
 * 			   3. 이때 GROUP BY로 가격 구간별로 감쌈
 * 			   4. 정렬 실시
 *  
 * */

public class Solution {
	SELECT T.PRICE_GROUP,
    	   COUNT(T.PRODUCT_CODE) AS PRODUCTS
	FROM(SELECT TRUNC(PRICE, -4) AS PRICE_GROUP,
				PRODUCT_CODE
	FROM PRODUCT) T
	GROUP BY T.PRICE_GROUP
	ORDER BY T.PRICE_GROUP
}