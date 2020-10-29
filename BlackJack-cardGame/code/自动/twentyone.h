#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#define TOTAL_MONEY 1000 //ÿ����ҳ�ʼ�ܵĶ��� 
#define MIN_BET 10 //����ÿ����ע����Сֵ��������ʣ����ʵ��ڸ�ֵ���������˳� 
#define THD 3/4 //������ֵ�������Ѿ��ù����˿�������������ֵ������������ϴ�� 
#define SHUFFLE_TIMES 5 //����ϴ�ƴ�������ֵ�������ô�����ֹͣ��Ϸ 
#define ROUNDS 50 //�����ܾ�������ֵ����������ֵ��ֹͣ��Ϸ

/*����洢�����Ϣ�Ľṹ�� */
typedef struct{
	char name[20]; //����ǳ� 
	int account; //�˻�ʣ���Ǯ 
	char mycards[20]; //�����Ѿ��õ����� 
	int count; //�����Ѿ��õ��Ƶ�����
	char state; //��ǰ״̬��i�����գ�h���������ƣ�s��ͣ�ƣ�d���ӱ���u��Ͷ�������������� 
	int mybets; //�����Ѿ��µĶ�ע 
	int points; //�����ƶ�Ӧ�ĵ��� 
	int rounds; //�Ѿ�������� 
}Player;  

/*����洢ׯ����Ϣ�Ľṹ�� */
typedef struct{
	char mycards[20]; //�����Ѿ��õ�����
	int count; //�����Ѿ��õ��Ƶ�����
	char state; //״̬��d���ڶ����ǰ��ƣ�l���ڶ��������� 
	int points; //�����ƶ�Ӧ�ĵ���
}Banker;

void Win();

/*��ʼ��������
*������ 
*		char* cards��ָ���˿���������׵�ַ
*		int N���˿����м��� 
*/
void init_cards(char* cards, int N);

/*ϴ�� 
*������ 
*		char* cards��ָ���˿���������׵�ַ
*		int N���˿����м��� 
*/
void shuffle_cards(char* cards, int N);

/*���� 
*������
*		const char* cards��ָ��ԭʼ�˿��Ƶ�ָ��
*		int* ppos��ԭʼ�˿����Ѿ����ŵ�λ��
*		Banker* pbanker��ָ��ׯ�ҵ�ָ��
*		Player(*pplayers)[]��ָ��������ҵ������ָ��
*		int pNum���ܹ�����Ϸ����������ׯ�ң�
*/ 
void first_deal(const char* cards, int* ppos, Banker* pbanker, Player(*pplayers)[], int pNum);

/*ÿһ�ֵĳ�ʼ��
*������
*		Banker* pbanker��ָ��ׯ�ҵ�ָ��
*		Player(*pplayers)[]��ָ��������ҵ������ָ��
*		int pNum���ܹ�����Ϸ����������ׯ�ң�
*/ 
void round_init(Banker* pbanker, Player(*players)[], int pNum);

/*ץһ����
*������
*		const char* cards��ָ��ԭʼ�˿��Ƶ�ָ�� 
*		int* ppos��ԭʼ�˿����Ѿ����ŵ�λ��
*/
char getcard(const char* cards, int* ppos);

/*��i��������պ���Ҽ�ׯ���������Ķ��� 
*������
*		pbanker��ָ��ׯ�ҵ�ָ��
*		i����i�����
*		Player(*players)[]��ָ����������ָ��
*		tmpcards����ǰ�Ѿ����ŵ��ƴ�ŵ����� 
*/
void insurance(Banker* pbanker, int i, Player(*players)[], char* tmpcards);

/*��i��������� 
*������
*		i����i����� 
*		Player(*players)[]��ָ����������ָ��
*		card���õ�����
*/
void hit(int i, Player(*players)[], char card);

/*��i����Ҽӱ� 
*������
*		i����i����� 
*		Player(*players)[]��ָ����������ָ��
*		card���ӱ�֮���õ�����
*/
void dbl(int i, Player(*players)[], char card);

/*��i�����Ͷ�� 
*������
*		i����i����� 
*		Player(*players)[]��ָ����������ָ��
*/
void surrender(int i, Player(*players)[]);

/*��i����ҷ��棨Υ�棩����עû�� 
*������
*		i����i����� 
*		Player(*players)[]��ָ����������ָ�� 
*/
void foul(int i, Player(*players)[]);

/*�����Ƽ����ܵ��� 
*������
*		mycards����������˿������� 
*		len�����鳤��
*����ֵ������õ��ĵ��� 
*/
int calculate(char(*mycards)[20] , int len);

/*ׯ�ҵĺ�������
*������
*		banker��ָ��ׯ�ҵ�ָ��
*		cards���˿�������
*		ppos��ָ��ǰ�Ѿ����Ƶ�λ�õ�ָ�� 
*/
void banker_continue(Banker* pbanker, const char* cards, int* ppos);

/*�Ƚϴ�С���Զ�ע���з���
*������
*		pbanker��ָ��ׯ�ҵ�ָ��
*		Player(*players)[]��ָ����������ָ��
*		pNum������������ׯ�ң� 
*/ 
void judge(Banker* pbanker, Player(*players)[], int pNum, int* palive, int* ptotal_round);

/*��ʾ�������ƵĽ�����Ȱ��ն������򣬶�����ͬ�İ����ִ����� 
*		Player(*players)[]��ָ����������ָ��
*		pNum������������ׯ�ң� 
*/ 
void show_result(Player(*players)[], int pNum);


