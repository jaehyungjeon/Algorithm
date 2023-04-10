package Level2.MaximumPriceSQL;

import java.util.*;

/*
 * Question : FOOD_PRODUCT 테이블에서 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문을 작성해주세요.
 * 
 * 	Solution : 1. 가격 기준 내림차순 후 ROWNUM 처리
 *  
 * */

public class Solution {
	SELECT *
	FROM (SELECT PRODUCT_ID,
	       PRODUCT_NAME,
	       PRODUCT_CD,
	       CATEGORY,
	       PRICE
	FROM FOOD_PRODUCT
	ORDER BY PRICE DESC) A
	WHERE ROWNUM = 1
}