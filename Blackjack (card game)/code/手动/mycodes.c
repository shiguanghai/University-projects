#include "mycodes.h"
#define PERSON //�˻��������Զ����Ŀ���

static int adv; //<���Ƶ�>��2��3��4��5��6����+1�㣬7��8��9��0�㣬10��j��q��k��a��-1��(���ں���show)
static double advs; //<ƽ�����Ƶ�>��adv*(52.0/(N*52-pos)) 
static int adv1_acount,adv2_acount,adv3_acount,adv4_acount,adv5_acount;
static int point_b;//ׯ�����Ƶĵ���2-11
void advantage()
{
	adv=0;
	advs=0;
	adv1_acount=10;
	adv2_acount=10;
	adv3_acount=10;
	adv4_acount=10;
	adv5_acount=10;
} 


//��1�������ע
//������
//	N������һ���м����˿��� 
//����ֵ��
//	����ע�Ľ�� 
int bet1(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //�����˹������� 
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/
	//ʹ�øߵ�������������<����>��ע
	mybet=adv1_acount; //��ʽ����ʱѧ����Ҫ�滻���Լ���ҵ���߼���ͨ��һЩ�ж���������ע�Ĵ�С 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//��2�������ע
//������
//	N������һ���м����˿��� 
//����ֵ��
//	����ע�Ľ�� 
int bet2(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //�����˹������� 
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/
	mybet=adv2_acount; //��ʽ����ʱѧ����Ҫ�滻���Լ���ҵ���߼���ͨ��һЩ�ж���������ע�Ĵ�С 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//��3�������ע
//������
//	N������һ���м����˿��� 
//����ֵ��
//	����ע�Ľ�� 
int bet3(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //�����˹������� 
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/
	mybet=adv3_acount; //��ʽ����ʱѧ����Ҫ�滻���Լ���ҵ���߼���ͨ��һЩ�ж���������ע�Ĵ�С 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//��4�������ע
//������
//	N������һ���м����˿��� 
//����ֵ��
//	����ע�Ľ�� 
int bet4(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //�����˹������� 
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/
	mybet=adv4_acount; //��ʽ����ʱѧ����Ҫ�滻���Լ���ҵ���߼���ͨ��һЩ�ж���������ע�Ĵ�С 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//��5�������ע
//������
//	N������һ���м����˿��� 
//����ֵ��
//	����ע�Ľ�� 
int bet5(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //�����˹������� 
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/
	mybet=adv5_acount; //��ʽ����ʱѧ����Ҫ�滻���Լ���ҵ���߼���ͨ��һЩ�ж���������ע�Ĵ�С 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

/*���1���״η��ƺ�Ķ��� 
*  ������tmpcards����ʱ���飬�����η����� 
*          ��ׯ�ҵ�ÿ����ҵ��ƣ����ׯ�ҵ�
*          ��������X����ʾ�����ǰ���
*        len��������ĳ���
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        i���������գ�
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*        d������ӱ��� 
*        u������Ͷ�� 
*/ 
char first_action1(char* tmpcards, int len){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON
	printf("��ѡ������\nh:���ƣ�i:���գ�s:ͣ�ƣ�d:�ӱ���u:Ͷ��\n");
	c=getche();
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	//���ݰ���21��������Ա�ı�<���Ƹı䣬�����zhuanlan.zhihu.com/p/61030660> 
	//�йر��� ������advs��С ��advs>=0.5ʱ ��ѡ������ ��ʱׯ�������д��ƿ����Դ� 
	int point_1=0;//�мҵĵ��� 
	point_b=0;//ׯ�����Ƶĵ�����ʼ�� 
	//����ׯ������ <point_bΪ��̬ȫ�ֱ��� ֻ��Ҫ��һ�� >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//�����м��� 
	for(int i=2; i<=3; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//��¼��A����ĵ��� Ӳ��Ϊ4-20 ����Ϊ2-10 
	if(tmpcards[2]=='A'&&tmpcards[3]=='A')//A A  ��ׯ��ΪA ���� �����ж��Ƿ��� 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[2]!='A'&&tmpcards[3]!='A')//Ӳ�� ��A  4-20 
	{
		switch(point_b){
			case 2:
				if((point_1>=4&&point_1<=9)||point_1==12) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 3:
				if((point_1>=4&&point_1<=8)||point_1==12) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 4:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 5:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 6:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 7:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 8:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 9:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=15)) c='h';
				if(point_1==16){
					if(adv1_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 10:
				if((point_1>=4&&point_1<=9)||point_1==12||point_1==13) c='h';
				if(point_1==14||point_1==15||point_1==16){
					if(adv1_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 11:
				c='i';
				break; 
		} 
	} 
	else if(tmpcards[2]=='A'||tmpcards[3]=='A')//���� ��һ��A 2-10 
	{
		switch(point_b){
			case 2:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 3:
				if(point_1>=2&&point_1<=5) c='h';
				if(point_1==6||point_1==7) c='d';
				if(point_1>=8) c='s';
				break;
			case 4:
				if(point_1==2||point_1==3) c='h';
				if(point_1>=4&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 5:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 6:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 7:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 8:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 9:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 10:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 11:
				c='i';
				break; 
		}
	}
	printf("���ֶ���Ϊ:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*���2���״η��ƺ�Ķ��� 
*  ������tmpcards����ʱ���飬�����η����� 
*          ��ׯ�ҵ�ÿ����ҵ��ƣ����ׯ�ҵ�
*          ��������X����ʾ�����ǰ���
*        len��������ĳ���
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        i���������գ�
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*        d������ӱ��� 
*        u������Ͷ�� 
*/ 
char first_action2(char* tmpcards, int len){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON
	printf("��ѡ������\nh:���ƣ�i:���գ�s:ͣ�ƣ�d:�ӱ���u:Ͷ��\n");
	c=getche();
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	int point_1=0;//�мҵĵ��� 
	point_b=0;//ׯ�����Ƶĵ�����ʼ�� 
	//����ׯ������ <point_bΪ��̬ȫ�ֱ��� ֻ��Ҫ��һ�� >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//�����м��� 
	for(int i=4; i<=5; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//��¼��A����ĵ��� Ӳ��Ϊ4-20 ����Ϊ2-10 
	if(tmpcards[4]=='A'&&tmpcards[5]=='A')//A A  ��ׯ��ΪA ���� �����ж��Ƿ��� 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[4]!='A'&&tmpcards[5]!='A')//Ӳ�� ��A  4-20 
	{
		switch(point_b){
			case 2:
				if((point_1>=4&&point_1<=9)||point_1==12) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 3:
				if((point_1>=4&&point_1<=8)||point_1==12) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 4:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 5:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 6:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 7:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 8:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 9:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=15)) c='h';
				if(point_1==16){
					if(adv2_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 10:
				if((point_1>=4&&point_1<=9)||point_1==12||point_1==13) c='h';
				if(point_1==14||point_1==15||point_1==16){
					if(adv2_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 11:
				c='i';
				break; 
		} 
	} 
	else if(tmpcards[4]=='A'||tmpcards[5]=='A')//���� ��һ��A 2-10 
	{
		switch(point_b){
			case 2:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 3:
				if(point_1>=2&&point_1<=5) c='h';
				if(point_1==6||point_1==7) c='d';
				if(point_1>=8) c='s';
				break;
			case 4:
				if(point_1==2||point_1==3) c='h';
				if(point_1>=4&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 5:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 6:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 7:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 8:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 9:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 10:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 11:
				c='i';
				break; 
		}
	} 
	printf("���ֶ���Ϊ:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*���3���״η��ƺ�Ķ��� 
*  ������tmpcards����ʱ���飬�����η����� 
*          ��ׯ�ҵ�ÿ����ҵ��ƣ����ׯ�ҵ�
*          ��������X����ʾ�����ǰ���
*        len��������ĳ���
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        i���������գ�
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*        d������ӱ��� 
*        u������Ͷ�� 
*/ 
char first_action3(char* tmpcards, int len){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON
	printf("��ѡ������\nh:���ƣ�i:���գ�s:ͣ�ƣ�d:�ӱ���u:Ͷ��\n");
	c=getche();
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	int point_1=0;//�мҵĵ��� 
	point_b=0;//ׯ�����Ƶĵ�����ʼ�� 
	//����ׯ������ <point_bΪ��̬ȫ�ֱ��� ֻ��Ҫ��һ�� >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//�����м��� 
	for(int i=6; i<=7; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//��¼��A����ĵ��� Ӳ��Ϊ4-20 ����Ϊ2-10 
	if(tmpcards[6]=='A'&&tmpcards[7]=='A')//A A  ��ׯ��ΪA ���� �����ж��Ƿ��� 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[6]!='A'&&tmpcards[7]!='A')//Ӳ�� ��A  4-20 
	{
		switch(point_b){
			case 2:
				if((point_1>=4&&point_1<=9)||point_1==12) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 3:
				if((point_1>=4&&point_1<=8)||point_1==12) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 4:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 5:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 6:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 7:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 8:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 9:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=15)) c='h';
				if(point_1==16){
					if(adv3_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 10:
				if((point_1>=4&&point_1<=9)||point_1==12||point_1==13) c='h';
				if(point_1==14||point_1==15||point_1==16){
					if(adv3_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 11:
				c='i';
				break; 
		} 
	} 
	else if(tmpcards[6]=='A'||tmpcards[7]=='A')//���� ��һ��A 2-10 
	{
		switch(point_b){
			case 2:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 3:
				if(point_1>=2&&point_1<=5) c='h';
				if(point_1==6||point_1==7) c='d';
				if(point_1>=8) c='s';
				break;
			case 4:
				if(point_1==2||point_1==3) c='h';
				if(point_1>=4&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 5:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 6:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 7:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 8:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 9:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 10:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 11:
				c='i';
				break; 
		}
	} 
	printf("���ֶ���Ϊ:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*���4���״η��ƺ�Ķ��� 
*  ������tmpcards����ʱ���飬�����η����� 
*          ��ׯ�ҵ�ÿ����ҵ��ƣ����ׯ�ҵ�
*          ��������X����ʾ�����ǰ���
*        len��������ĳ���
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        i���������գ�
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*        d������ӱ��� 
*        u������Ͷ�� 
*/ 
char first_action4(char* tmpcards, int len){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON
	printf("��ѡ������\nh:���ƣ�i:���գ�s:ͣ�ƣ�d:�ӱ���u:Ͷ��\n");
	c=getche();
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	int point_1=0;//�мҵĵ��� 
	point_b=0;//ׯ�����Ƶĵ�����ʼ�� 
	//����ׯ������ <point_bΪ��̬ȫ�ֱ��� ֻ��Ҫ��һ�� >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//�����м��� 
	for(int i=8; i<=9; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//��¼��A����ĵ��� Ӳ��Ϊ4-20 ����Ϊ2-10 
	if(tmpcards[8]=='A'&&tmpcards[9]=='A')//A A  ��ׯ��ΪA ���� �����ж��Ƿ��� 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[8]!='A'&&tmpcards[9]!='A')//Ӳ�� ��A  4-20 
	{
		switch(point_b){
			case 2:
				if((point_1>=4&&point_1<=9)||point_1==12) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 3:
				if((point_1>=4&&point_1<=8)||point_1==12) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 4:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 5:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 6:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 7:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 8:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 9:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=15)) c='h';
				if(point_1==16){
					if(adv4_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 10:
				if((point_1>=4&&point_1<=9)||point_1==12||point_1==13) c='h';
				if(point_1==14||point_1==15||point_1==16){
					if(adv4_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 11:
				c='i';
				break; 
		} 
	} 
	else if(tmpcards[8]=='A'||tmpcards[9]=='A')//���� ��һ��A 2-10 
	{
		switch(point_b){
			case 2:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 3:
				if(point_1>=2&&point_1<=5) c='h';
				if(point_1==6||point_1==7) c='d';
				if(point_1>=8) c='s';
				break;
			case 4:
				if(point_1==2||point_1==3) c='h';
				if(point_1>=4&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 5:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 6:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 7:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 8:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 9:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 10:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 11:
				c='i';
				break; 
		}
	} 
	printf("���ֶ���Ϊ:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*���5���״η��ƺ�Ķ��� 
*  ������tmpcards����ʱ���飬�����η����� 
*          ��ׯ�ҵ�ÿ����ҵ��ƣ����ׯ�ҵ�
*          ��������X����ʾ�����ǰ���
*        len��������ĳ���
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        i���������գ�
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*        d������ӱ��� 
*        u������Ͷ�� 
*/ 
char first_action5(char* tmpcards, int len){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON
	printf("��ѡ������\nh:���ƣ�i:���գ�s:ͣ�ƣ�d:�ӱ���u:Ͷ��\n");
	c=getche();
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	int point_1=0;//�мҵĵ��� 
	point_b=0;//ׯ�����Ƶĵ�����ʼ�� 
	//����ׯ������ <point_bΪ��̬ȫ�ֱ��� ֻ��Ҫ��һ�� >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//�����м��� 
	for(int i=10; i<=11; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//��¼��A����ĵ��� Ӳ��Ϊ4-20 ����Ϊ2-10 
	if(tmpcards[10]=='A'&&tmpcards[11]=='A')//A A  ��ׯ��ΪA ���� �����ж��Ƿ��� 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[10]!='A'&&tmpcards[11]!='A')//Ӳ�� ��A  4-20 
	{
		switch(point_b){
			case 2:
				if((point_1>=4&&point_1<=9)||point_1==12) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 3:
				if((point_1>=4&&point_1<=8)||point_1==12) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=13) c='s';
				break;
			case 4:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 5:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 6:
				if(point_1>=4&&point_1<=8) c='h';
				if(point_1==9||point_1==10||point_1==11) c='d';
				if(point_1>=12) c='s';
				break;
			case 7:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 8:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=16)) c='h';
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 9:
				if((point_1>=4&&point_1<=9)||(point_1>=12&&point_1<=15)) c='h';
				if(point_1==16){
					if(adv5_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 10:
				if((point_1>=4&&point_1<=9)||point_1==12||point_1==13) c='h';
				if(point_1==14||point_1==15||point_1==16){
					if(adv1_acount>=100) c='h';
					else c='u';
				} 
				if(point_1==10||point_1==11) c='d';
				if(point_1>=17) c='s';
				break;
			case 11:
				c='i';
				break; 
		} 
	} 
	else if(tmpcards[10]=='A'||tmpcards[11]=='A')//���� ��һ��A 2-10 
	{
		switch(point_b){
			case 2:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 3:
				if(point_1>=2&&point_1<=5) c='h';
				if(point_1==6||point_1==7) c='d';
				if(point_1>=8) c='s';
				break;
			case 4:
				if(point_1==2||point_1==3) c='h';
				if(point_1>=4&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 5:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 6:
				if(point_1>=2&&point_1<=7) c='d';
				if(point_1>=8) c='s';
				break;
			case 7:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 8:
				if(point_1>=2&&point_1<=6) c='h';
				if(point_1>=7) c='s';
				break;
			case 9:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 10:
				if(point_1>=2&&point_1<=7) c='h';
				if(point_1>=8) c='s';
				break;
			case 11:
				c='i';
				break; 
		}
	} 
	printf("���ֶ���Ϊ:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*���1�������� 
*  ������ָ��������������ָ�� 
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*/ 
char continue_action1(Player(*players)[]){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON 
	Player* me=&(*players)[0];//�˴�bug�޸�<���õ����������Ϊ��0������Ϊ0��1��2����������Ϊ�յ���״̬��Ϊ��s��> 
	if(me->state=='h'||me->state=='i'){//<�����������> 
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n��ѡ����һ��������\nh:���ƣ�s:ͣ��\n");
		c=getche();
	}else c='s';
	#else
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//�мҵĵ���
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//�����м��� 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //����ж��A����������һ��������ֻ�ܼ���1�� 
			point_1++;
		}
		if(j==1){ //��ʣһ��A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//Ӳ�� ��A ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 3:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 4:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 5:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 6:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 7:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 8:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 9:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 10:
					if(point_1>=4&&point_1<=15) c='h';
					if(point_1>=16) c='s';
					break;
				case 11:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
			} 
		} 
		else //���� ��������һ��A  �����һ��A��11���� ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 3:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 4:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 5:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 6:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 7:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 8:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 9:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 10:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 11:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
			}
		}
		printf("��һ��������%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

/*���2�������� 
*  ������ָ��������������ָ�� 
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*/ 
char continue_action2(Player(*players)[]){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n��ѡ����һ��������\nh:���ƣ�s:ͣ��\n");
		c=getche();
	}else c='s';
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//�мҵĵ���
		int Acnt=0; 
		int i,j,flag;
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//�����м��� 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //����ж��A����������һ��������ֻ�ܼ���1�� 
			point_1++;
		}
		if(j==1){ //��ʣһ��A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//Ӳ�� ��A ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 3:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 4:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 5:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 6:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 7:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 8:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 9:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 10:
					if(point_1>=4&&point_1<=15) c='h';
					if(point_1>=16) c='s';
					break;
				case 11:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
			} 
		} 
		else //���� ��������һ��A  �����һ��A��11���� ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 3:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 4:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 5:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 6:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 7:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 8:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 9:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 10:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 11:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
			}
		}
		printf("��һ��������%c",c);		
	}
	else c='s';	
	#endif
	/******************************/
	return c; 
} 

/*���3�������� 
*  ������ָ��������������ָ�� 
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*/ 
char continue_action3(Player(*players)[]){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n��ѡ����һ��������\nh:���ƣ�s:ͣ��\n");
		c=getche();
	}else c='s';
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//�мҵĵ���
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//�����м��� 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //����ж��A����������һ��������ֻ�ܼ���1�� 
			point_1++;
		}
		if(j==1){ //��ʣһ��A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//Ӳ�� ��A ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 3:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 4:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 5:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 6:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 7:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 8:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 9:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 10:
					if(point_1>=4&&point_1<=15) c='h';
					if(point_1>=16) c='s';
					break;
				case 11:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
			} 
		} 
		else //���� ��������һ��A  �����һ��A��11���� ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 3:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 4:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 5:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 6:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 7:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 8:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 9:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 10:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 11:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
			}
		}
		printf("��һ��������%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

/*���4�������� 
*  ������ָ��������������ָ�� 
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*/ 
char continue_action4(Player(*players)[]){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n��ѡ����һ��������\nh:���ƣ�s:ͣ��\n");
		c=getche();
	}else c='s';
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//�мҵĵ���
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//�����м��� 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //����ж��A����������һ��������ֻ�ܼ���1�� 
			point_1++;
		}
		if(j==1){ //��ʣһ��A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//Ӳ�� ��A ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 3:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 4:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 5:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 6:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 7:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 8:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 9:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 10:
					if(point_1>=4&&point_1<=15) c='h';
					if(point_1>=16) c='s';
					break;
				case 11:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
			} 
		} 
		else //���� ��������һ��A  �����һ��A��11���� ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 3:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 4:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 5:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 6:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 7:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 8:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 9:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 10:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 11:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
			}
		}
		printf("��һ��������%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

/*���5�������� 
*  ������ָ��������������ָ�� 
*  ����ֵ������ÿ����Ҹ����Ķ�����
*        h������������ƣ� 
*        s������ͣ�ƣ� 
*/ 
char continue_action5(Player(*players)[]){
	char c; //�ñ��������ڷ��ز�ͬ״̬���ַ�
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n��ѡ����һ��������\nh:���ƣ�s:ͣ��\n");
		c=getche();
	}else c='s';
	#else
	/***����Ӧ�����Լ���ҵ���߼�***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//�мҵĵ���
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n���%s��ǰ���е���Ϊ��", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//�����м��� 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //����ж��A����������һ��������ֻ�ܼ���1�� 
			point_1++;
		}
		if(j==1){ //��ʣһ��A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;//��A��11�� flag=1 
			}
		}
		if(flag==0)//Ӳ�� ��A ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 3:
					if(point_1>=4&&point_1<=12) c='h';
					if(point_1>=13) c='s';
					break;
				case 4:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 5:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 6:
					if(point_1>=4&&point_1<=11) c='h';
					if(point_1>=12) c='s';
					break;
				case 7:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 8:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 9:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
				case 10:
					if(point_1>=4&&point_1<=15) c='h';
					if(point_1>=16) c='s';
					break;
				case 11:
					if(point_1>=4&&point_1<=16) c='h';
					if(point_1>=17) c='s';
					break;
			} 
		} 
		else //���� ��������һ��A  �����һ��A��11���� ע����������Ϊ���� ��ֻ��h��s 
		{
			switch(point_b){
				case 2:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 3:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 4:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 5:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 6:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 7:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 8:
					if(point_1>=13&&point_1<=17) c='h';
					if(point_1>=18) c='s';
					break;
				case 9:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 10:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
				case 11:
					if(point_1>=13&&point_1<=18) c='h';
					if(point_1>=19) c='s';
					break;
			}
		}
		printf("��һ��������%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

//���1�������˵���
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		Player(*players)[]��ָ����������ָ��
//		pNum������������ׯ�ң� 
void show1(Banker* pbanker, Player(*players)[], int pNum, int N, int pos){
	//ʹ�øߵ�������������<����>��ע
	//��ռadv�����ƣ���Ǯ����Ϊaccount����ô���Ŷ�ע��b=ad*ac�� 
	Player* me=&(*players)[0];
	for(int i=0; i<me->count; ++i)
	{
		if(me->mycards[i]>='2'&&me->mycards[i]<='6')
		{
			adv++;
			continue;
		} 
		switch(me->mycards[i])
		{
			case 'T': 
				adv--;
				break;
			case 'J': 
				adv--;
				break;
			case 'Q': 
				adv--;
				break;
			case 'K': 
				adv--;
				break;	
			case 'A': 
				adv--;
				break;			
		}
	}
	for(int j=0; j<pbanker->count; ++j)
	{
		if(pbanker->mycards[j]>='2'&&pbanker->mycards[j]<='6')
		{
			adv++;
			continue;
		}
		switch(pbanker->mycards[j])
		{
			case 'T': 
				adv--;
				break;
			case 'J': 
				adv--;
				break;
			case 'Q': 
				adv--;
				break;
			case 'K': 
				adv--;
				break;	
			case 'A': 
				adv--;
				break;			
		}			
	}
	advs=adv*(52.0/(N*52-pos));
	if(advs>0&&advs<=0.5)//�м�1.Ԥ������ �޶�����ֵ100 300 500 �Լ�����0.1,0.25,0.5�������� 
		adv1_acount=0.1*advs*me->account;
		if(adv1_acount>=100)
			adv1_acount=100;
	if(advs>0.5&&advs<=1)
		adv1_acount=0.25*advs*me->account;
		if(adv1_acount>=300)
			adv1_acount=300; 
	if(advs>1)
		adv1_acount=0.5*advs*me->account;
		if(adv1_acount>=500)
			adv1_acount=500;
	if(advs<=0)
		adv1_acount=10;	
//	printf("\n��ʤ��%d",adv);
//	printf("\nƽ�����Ƶ�%lf",advs);
//	printf("\n���ƶ�ע%d\n",adv1_acount);
	//�˴����Կ������������˵��ƣ��ݴ˿��Ե����Լ��Ĳ��� 
	//���´���ע�Ĳ��ԣ������Ƴ��ֵĸ��ʵ� 
} 

//���2�������˵���
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		Player(*players)[]��ָ����������ָ��
//		pNum������������ׯ�ң� 
void show2(Banker* pbanker, Player(*players)[], int pNum, int N, int pos){
	Player* me=&(*players)[1];
	for(int i=0; i<me->count; ++i)
	{
		if(me->mycards[i]>='2'&&me->mycards[i]<='6')
		{
			adv++;
			continue;
		} 
		switch(me->mycards[i])
		{
			case 'T': 
				adv--;
				break;
			case 'J': 
				adv--;
				break;
			case 'Q': 
				adv--;
				break;
			case 'K': 
				adv--;
				break;	
			case 'A': 
				adv--;
				break;			
		}
	}
	advs=adv*(52.0/(N*52-pos));
	if(advs>0&&advs<=0.5)//�м�2.���� �޶�����ֵ300 ����0.5 
		adv2_acount=0.5*advs*me->account;
		if(adv2_acount>=300)
			adv2_acount=300;
	if(advs>0.5)
		adv2_acount=0.25*me->account;
		if(adv2_acount>=300)
			adv2_acount=300;
	if(advs<=0)
		adv2_acount=10;
//	printf("\n��ʤ��%d",adv);
//	printf("\nƽ�����Ƶ�%lf\n",advs);
	//�˴����Կ������������˵��ƣ��ݴ˿��Ե����Լ��Ĳ��� 
	//���´���ע�Ĳ��ԣ������Ƴ��ֵĸ��ʵ� 
} 

//���3�������˵���
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		Player(*players)[]��ָ����������ָ��
//		pNum������������ׯ�ң� 
void show3(Banker* pbanker, Player(*players)[], int pNum, int N, int pos){
	Player* me=&(*players)[2];
	for(int i=0; i<me->count; ++i)
	{
		if(me->mycards[i]>='2'&&me->mycards[i]<='6')
		{
			adv++;
			continue;
		} 
		switch(me->mycards[i])
		{
			case 'T': 
				adv--;
				break;
			case 'J': 
				adv--;
				break;
			case 'Q': 
				adv--;
				break;
			case 'K': 
				adv--;
				break;	
			case 'A': 
				adv--;
				break;			
		}
	}
	advs=adv*(52.0/(N*52-pos));
	if(advs>0&&advs<=0.5)//�м�3.ð�� ���޶�����ֵ  ����1.0 
		adv3_acount=advs*me->account;
	if(advs>0.5)
		adv3_acount=0.25*me->account; 
	if(advs<=0)
		adv3_acount=10;
//	printf("\n��ʤ��%d",adv);
//	printf("\nƽ�����Ƶ�%lf\n",advs);
	//�˴����Կ������������˵��ƣ��ݴ˿��Ե����Լ��Ĳ��� 
	//���´���ע�Ĳ��ԣ������Ƴ��ֵĸ��ʵ� 
} 

//���4�������˵���
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		Player(*players)[]��ָ����������ָ��
//		pNum������������ׯ�ң� 
void show4(Banker* pbanker, Player(*players)[], int pNum, int N, int pos){
	Player* me=&(*players)[3];
	for(int i=0; i<me->count; ++i)
	{
		if(me->mycards[i]>='2'&&me->mycards[i]<='6')
		{
			adv++;
			continue;
		} 
		switch(me->mycards[i])
		{
			case 'T': 
				adv--;
				break;
			case 'J': 
				adv--;
				break;
			case 'Q': 
				adv--;
				break;
			case 'K': 
				adv--;
				break;	
			case 'A': 
				adv--;
				break;			
		}
	}
	advs=adv*(52.0/(N*52-pos));
	if(advs>0&&advs<=0.5)//�м�4.�޶�����ֵ500  ����1.0
		adv4_acount=advs*me->account;
		if(adv4_acount>=500)
			adv4_acount=500;
	if(advs>0.5)
		adv4_acount=0.5*me->account;
		if(adv4_acount>=500)
			adv4_acount=500; 
	if(advs<=0)
		adv4_acount=10;
//	printf("\n��ʤ��%d",adv);
//	printf("\nƽ�����Ƶ�%lf\n",advs);
	//�˴����Կ������������˵��ƣ��ݴ˿��Ե����Լ��Ĳ��� 
	//���´���ע�Ĳ��ԣ������Ƴ��ֵĸ��ʵ� 
} 

//���5�������˵���
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		Player(*players)[]��ָ����������ָ��
//		pNum������������ׯ�ң� 
void show5(Banker* pbanker, Player(*players)[], int pNum, int N, int pos){
	Player* me=&(*players)[4];
	for(int i=0; i<me->count; ++i)
	{
		if(me->mycards[i]>='2'&&me->mycards[i]<='6')
		{
			adv++;
			continue;
		} 
		switch(me->mycards[i])
		{
			case 'T': 
				adv--;
				break;
			case 'J': 
				adv--;
				break;
			case 'Q': 
				adv--;
				break;
			case 'K': 
				adv--;
				break;	
			case 'A': 
				adv--;
				break;			
		}
	}
	advs=adv*(52.0/(N*52-pos));
	if(advs>0&&advs<=0.5)//�м�5.������ �޶�����ֵ100 �Լ�����0.1 
		adv5_acount=0.1*advs*me->account;
		if(adv5_acount>=100)
			adv5_acount=100;
	if(advs>0.5)
		adv5_acount=0.05*me->account;
		if(adv5_acount>=100)
			adv5_acount=100; 
	if(advs<=0)
		adv5_acount=10;
//	printf("\n��ʤ��%d",adv);
//	printf("\nƽ�����Ƶ�%lf\n",advs);
	//�˴����Կ������������˵��ƣ��ݴ˿��Ե����Լ��Ĳ��� 
	//���´���ע�Ĳ��ԣ������Ƴ��ֵĸ��ʵ� 
} 
