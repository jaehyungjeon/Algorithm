package AllRecordSearch;

/*
 * Question : 
	ANIMAL_INS ���̺��� ���� ��ȣ�ҿ� ���� ������ ������ ���� ���̺��Դϴ�. ANIMAL_INS ���̺� ������ ������ ������, 
	ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE�� 
	���� ������ ���̵�, ���� ��, ��ȣ ������, ��ȣ ���� �� ����, �̸�, ���� �� �߼�ȭ ���θ� ��Ÿ���ϴ�.
	
	NAME	TYPE	NULLABLE
	ANIMAL_ID	VARCHAR(N)	FALSE
	ANIMAL_TYPE	VARCHAR(N)	FALSE
	DATETIME	DATETIME	FALSE
	INTAKE_CONDITION	VARCHAR(N)	FALSE
	NAME	VARCHAR(N)	TRUE
	SEX_UPON_INTAKE	VARCHAR(N)	FALSE
	���� ��ȣ�ҿ� ���� ��� ������ ������ ANIMAL_ID������ ��ȸ�ϴ� SQL���� �ۼ����ּ���. SQL�� �����ϸ� ������ ���� ��µǾ�� �մϴ�.
	
	ANIMAL_ID	ANIMAL_TYPE	DATETIME	INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
	A349996	Cat	2018-01-22 14:32:00	Normal	Sugar	Neutered Male
	A350276	Cat	2017-08-13 13:50:00	Normal	Jewel	Spayed Female
	A350375	Cat	2017-03-06 15:01:00	Normal	Meo	Neutered Male
	A352555	Dog	2014-08-08 04:20:00	Normal	Harley	Spayed Female
	..���� ����
 * 
 * 	Solution : 1. �̰� sql ������..
 * 			   2. ���� ����??
 * */

public class Solution {
	SELECT *
	FROM ANIMAL_INS
	ORDER BY ANIMAL_ID;
}