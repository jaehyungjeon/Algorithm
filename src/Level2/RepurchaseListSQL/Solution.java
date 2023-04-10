package Level2.RepurchaseListSQL;

import java.util.*;

/*
 * Question : ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 
			  결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.
 * 
 * 	Solution : 1. 중복일 시 SUM으로 DUPL 잡고 GROUP BY
 * 			   2. 서브쿼리 밖에서 DUPL > 1 (2이상) 검색
 * 			   3. 정렬은 USER_ID 오름차순, PRODUCT_ID 내림차순
 *  
 * */

public class Solution {
	SELECT T.USER_ID,
    	   T.PRODUCT_ID
	FROM (SELECT USER_ID,
				 PRODUCT_ID,
				 SUM(1) AS DUPL
	FROM ONLINE_SALE
	GROUP BY USER_ID, PRODUCT_ID) T
	WHERE DUPL > 1
	ORDER BY T.USER_ID ASC, T.PRODUCT_ID DESC
}