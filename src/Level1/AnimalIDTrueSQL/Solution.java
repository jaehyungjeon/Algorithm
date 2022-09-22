package Level1.AnimalIDTrueSQL;

/*
 * Question : 
	ANIMAL_INS ���̺��� ���� ��ȣ�ҿ� ���� ������ ������ ���� ���̺��Դϴ�. 
	ANIMAL_INS ���̺� ������ ������ ������, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE�� 
	���� ������ ���̵�, ���� ��, ��ȣ ������, ��ȣ ���� �� ����, �̸�, ���� �� �߼�ȭ ���θ� ��Ÿ���ϴ�.
	
	NAME	TYPE	NULLABLE
	ANIMAL_ID	VARCHAR(N)	FALSE
	ANIMAL_TYPE	VARCHAR(N)	FALSE
	DATETIME	DATETIME	FALSE
	INTAKE_CONDITION	VARCHAR(N)	FALSE
	NAME	VARCHAR(N)	TRUE
	SEX_UPON_INTAKE	VARCHAR(N)	FALSE
	���� ��ȣ�ҿ� ���� ���� ��, �̸��� �ִ� ������ ID�� ��ȸ�ϴ� SQL ���� �ۼ����ּ���. ��, ID�� �������� ���ĵǾ�� �մϴ�.
	
	����
	���� ��� ANIMAL_INS ���̺��� ������ ���ٸ�
	
	ANIMAL_ID	ANIMAL_TYPE	DATETIME	INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
	A434523	Cat	2015-11-20 14:18:00	Normal	NULL	Spayed Female
	A562649	Dog	2014-03-20 18:06:00	Sick	NULL	Spayed Female
	A524634	Dog	2015-01-02 18:54:00	Normal	*Belle	Intact Female
	A465637	Dog	2017-06-04 08:17:00	Injured	*Commander	Neutered Male
	�̸��� �ִ� ������ ID�� A524634�� A465637�Դϴ�. ���� SQL�� �����ϸ� ������ ���� ��µǾ�� �մϴ�.
	
	ANIMAL_ID
	A465637
	A524634
 * 
 * 	Solution : 1. NAME �� NULL �� �� ���
 * */

public class Solution {
	SELECT ANIMAL_ID
	FROM   ANIMAL_INS
	WHERE  NAME IS NOT NULL
	ORDER BY ANIMAL_ID ASC
}