package Level2.CategoryGoodsFindSQL;

import java.util.*;

/*
 * Question : PRODUCT 테이블에서 상품 카테고리 코드(PRODUCT_CODE 앞 2자리) 별 상품 개수를 출력하는 SQL문을 작성해주세요. 결과는 상품 카테고리 코드를 기준으로 오름차순 정렬해주세요.
 * 
 * 	Solution : 1. SUBSTR로 PRODUCT_CODE의 앞2글자 추출
 * 			   2. 서브쿼리로 말아서 CATEGORY별 GROUP BY 및 COUNT 실시
 * 			   3. CATEGORY로 ASC 정렬
 *  
 * */

public class Solution {
	SELECT T.CATEGORY,
    	   COUNT(T.CATEGORY) AS PRODUCTS
	FROM(SELECT SUBSTR(PRODUCT_CODE, 0, 2) AS CATEGORY
		 FROM   PRODUCT
	 ) T
	GROUP BY T.CATEGORY
	ORDER BY T.CATEGORY
}