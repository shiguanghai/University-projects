#include "mycodes.h"
#define PERSON //人机交互与自动化的开关

static int adv; //<优势点>：2，3，4，5，6都算+1点，7，8，9算0点，10，j，q，k，a算-1点(用于函数show)
static double advs; //<平均优势点>：adv*(52.0/(N*52-pos)) 
static int adv1_acount,adv2_acount,adv3_acount,adv4_acount,adv5_acount;
static int point_b;//庄家亮牌的点数2-11
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


//第1个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet1(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //用于人工玩的情况 
	#else
	/***这里应该有自己的业务逻辑***/
	//使用高低算牌术来进行<最优>下注
	mybet=adv1_acount; //正式发布时学生需要替换成自己的业务逻辑，通过一些判断来决定下注的大小 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//第2个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet2(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //用于人工玩的情况 
	#else
	/***这里应该有自己的业务逻辑***/
	mybet=adv2_acount; //正式发布时学生需要替换成自己的业务逻辑，通过一些判断来决定下注的大小 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//第3个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet3(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //用于人工玩的情况 
	#else
	/***这里应该有自己的业务逻辑***/
	mybet=adv3_acount; //正式发布时学生需要替换成自己的业务逻辑，通过一些判断来决定下注的大小 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//第4个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet4(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //用于人工玩的情况 
	#else
	/***这里应该有自己的业务逻辑***/
	mybet=adv4_acount; //正式发布时学生需要替换成自己的业务逻辑，通过一些判断来决定下注的大小 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

//第5个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet5(int N){
	int mybet;
	#ifdef PERSON
	scanf("%d",&mybet); //用于人工玩的情况 
	#else
	/***这里应该有自己的业务逻辑***/
	mybet=adv5_acount; //正式发布时学生需要替换成自己的业务逻辑，通过一些判断来决定下注的大小 
	printf("%d\n",mybet);
	/******************************/
	#endif
	return mybet;
} 

/*玩家1在首次发牌后的动作 
*  参数：tmpcards，临时数组，存依次放首轮 
*          从庄家到每个玩家的牌，如果庄家第
*          二张牌是X，表示该牌是暗牌
*        len，该数组的长度
*  返回值，代表每个玩家给出的动作，
*        i，代表买保险，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*        d，代表加倍， 
*        u，代表投降 
*/ 
char first_action1(char* tmpcards, int len){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON
	printf("请选择动作：\nh:拿牌；i:买保险；s:停牌；d:加倍；u:投降\n");
	c=getche();
	#else
	/***这里应该有自己的业务逻辑***/ 
	//根据澳门21点基本策略表改编<分牌改变，详见：zhuanlan.zhihu.com/p/61030660> 
	//有关保险 将根据advs大小 当advs>=0.5时 将选择买保险 此时庄家手中有大牌可能性大 
	int point_1=0;//闲家的点数 
	point_b=0;//庄家亮牌的点数初始化 
	//计算庄家明牌 <point_b为静态全局变量 只需要算一次 >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//计算闲家牌 
	for(int i=2; i<=3; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//记录除A以外的点数 硬牌为4-20 软牌为2-10 
	if(tmpcards[2]=='A'&&tmpcards[3]=='A')//A A  且庄不为A 拿牌 否则判断是否保险 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[2]!='A'&&tmpcards[3]!='A')//硬牌 无A  4-20 
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
	else if(tmpcards[2]=='A'||tmpcards[3]=='A')//软牌 有一个A 2-10 
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
	printf("首轮动作为:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*玩家2在首次发牌后的动作 
*  参数：tmpcards，临时数组，存依次放首轮 
*          从庄家到每个玩家的牌，如果庄家第
*          二张牌是X，表示该牌是暗牌
*        len，该数组的长度
*  返回值，代表每个玩家给出的动作，
*        i，代表买保险，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*        d，代表加倍， 
*        u，代表投降 
*/ 
char first_action2(char* tmpcards, int len){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON
	printf("请选择动作：\nh:拿牌；i:买保险；s:停牌；d:加倍；u:投降\n");
	c=getche();
	#else
	/***这里应该有自己的业务逻辑***/ 
	int point_1=0;//闲家的点数 
	point_b=0;//庄家亮牌的点数初始化 
	//计算庄家明牌 <point_b为静态全局变量 只需要算一次 >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//计算闲家牌 
	for(int i=4; i<=5; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//记录除A以外的点数 硬牌为4-20 软牌为2-10 
	if(tmpcards[4]=='A'&&tmpcards[5]=='A')//A A  且庄不为A 拿牌 否则判断是否保险 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[4]!='A'&&tmpcards[5]!='A')//硬牌 无A  4-20 
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
	else if(tmpcards[4]=='A'||tmpcards[5]=='A')//软牌 有一个A 2-10 
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
	printf("首轮动作为:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*玩家3在首次发牌后的动作 
*  参数：tmpcards，临时数组，存依次放首轮 
*          从庄家到每个玩家的牌，如果庄家第
*          二张牌是X，表示该牌是暗牌
*        len，该数组的长度
*  返回值，代表每个玩家给出的动作，
*        i，代表买保险，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*        d，代表加倍， 
*        u，代表投降 
*/ 
char first_action3(char* tmpcards, int len){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON
	printf("请选择动作：\nh:拿牌；i:买保险；s:停牌；d:加倍；u:投降\n");
	c=getche();
	#else
	/***这里应该有自己的业务逻辑***/ 
	int point_1=0;//闲家的点数 
	point_b=0;//庄家亮牌的点数初始化 
	//计算庄家明牌 <point_b为静态全局变量 只需要算一次 >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//计算闲家牌 
	for(int i=6; i<=7; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//记录除A以外的点数 硬牌为4-20 软牌为2-10 
	if(tmpcards[6]=='A'&&tmpcards[7]=='A')//A A  且庄不为A 拿牌 否则判断是否保险 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[6]!='A'&&tmpcards[7]!='A')//硬牌 无A  4-20 
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
	else if(tmpcards[6]=='A'||tmpcards[7]=='A')//软牌 有一个A 2-10 
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
	printf("首轮动作为:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*玩家4在首次发牌后的动作 
*  参数：tmpcards，临时数组，存依次放首轮 
*          从庄家到每个玩家的牌，如果庄家第
*          二张牌是X，表示该牌是暗牌
*        len，该数组的长度
*  返回值，代表每个玩家给出的动作，
*        i，代表买保险，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*        d，代表加倍， 
*        u，代表投降 
*/ 
char first_action4(char* tmpcards, int len){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON
	printf("请选择动作：\nh:拿牌；i:买保险；s:停牌；d:加倍；u:投降\n");
	c=getche();
	#else
	/***这里应该有自己的业务逻辑***/ 
	int point_1=0;//闲家的点数 
	point_b=0;//庄家亮牌的点数初始化 
	//计算庄家明牌 <point_b为静态全局变量 只需要算一次 >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//计算闲家牌 
	for(int i=8; i<=9; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//记录除A以外的点数 硬牌为4-20 软牌为2-10 
	if(tmpcards[8]=='A'&&tmpcards[9]=='A')//A A  且庄不为A 拿牌 否则判断是否保险 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[8]!='A'&&tmpcards[9]!='A')//硬牌 无A  4-20 
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
	else if(tmpcards[8]=='A'||tmpcards[9]=='A')//软牌 有一个A 2-10 
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
	printf("首轮动作为:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*玩家5在首次发牌后的动作 
*  参数：tmpcards，临时数组，存依次放首轮 
*          从庄家到每个玩家的牌，如果庄家第
*          二张牌是X，表示该牌是暗牌
*        len，该数组的长度
*  返回值，代表每个玩家给出的动作，
*        i，代表买保险，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*        d，代表加倍， 
*        u，代表投降 
*/ 
char first_action5(char* tmpcards, int len){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON
	printf("请选择动作：\nh:拿牌；i:买保险；s:停牌；d:加倍；u:投降\n");
	c=getche();
	#else
	/***这里应该有自己的业务逻辑***/ 
	int point_1=0;//闲家的点数 
	point_b=0;//庄家亮牌的点数初始化 
	//计算庄家明牌 <point_b为静态全局变量 只需要算一次 >
	if(tmpcards[0]>='2'&&tmpcards[0]<='9')
		point_b+=tmpcards[0]-'0';
	else if(tmpcards[0]=='T'||tmpcards[0]=='J'||tmpcards[0]=='Q'||tmpcards[0]=='K')	 
		point_b+=10;
	else if(tmpcards[0]=='A')
		point_b+=11;
	//计算闲家牌 
	for(int i=10; i<=11; ++i)
		{
			if(tmpcards[i]>='2'&&tmpcards[i]<='9')
				point_1+=tmpcards[i]-'0';
			else if(tmpcards[i]=='T'||tmpcards[i]=='J'||tmpcards[i]=='Q'||tmpcards[i]=='K')	
				point_1+=10;
		}//记录除A以外的点数 硬牌为4-20 软牌为2-10 
	if(tmpcards[10]=='A'&&tmpcards[11]=='A')//A A  且庄不为A 拿牌 否则判断是否保险 
	{
		if(point_b==11&&advs>=0.5) c='i';
		else c='h';
	}	 
	else if(tmpcards[10]!='A'&&tmpcards[11]!='A')//硬牌 无A  4-20 
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
	else if(tmpcards[10]=='A'||tmpcards[11]=='A')//软牌 有一个A 2-10 
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
	printf("首轮动作为:%c",c); 
	/******************************/
	#endif
	return c; 
} 

/*玩家1后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action1(Player(*players)[]){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON 
	Player* me=&(*players)[0];//此处bug修改<调用的五个函数都为【0】而不为0、1、2。。。否则将为空导致状态变为‘s’> 
	if(me->state=='h'||me->state=='i'){//<保险情况加上> 
		printf("\n玩家%s当前持有的牌为：", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n请选择下一步动作：\nh:拿牌；s:停牌\n");
		c=getche();
	}else c='s';
	#else
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//闲家的点数
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n玩家%s当前持有的牌为：", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//计算闲家牌 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //如果有多个A，则除了最后一个，其他只能记作1点 
			point_1++;
		}
		if(j==1){ //还剩一个A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//硬牌 无A 注：考虑首轮为保险 且只有h或s 
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
		else //软牌 有至少有一个A  且最后一个A以11加入 注：考虑首轮为保险 且只有h或s 
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
		printf("下一步动作：%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

/*玩家2后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action2(Player(*players)[]){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n玩家%s当前持有的牌为：", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n请选择下一步动作：\nh:拿牌；s:停牌\n");
		c=getche();
	}else c='s';
	#else
	/***这里应该有自己的业务逻辑***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//闲家的点数
		int Acnt=0; 
		int i,j,flag;
		printf("\n玩家%s当前持有的牌为：", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//计算闲家牌 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //如果有多个A，则除了最后一个，其他只能记作1点 
			point_1++;
		}
		if(j==1){ //还剩一个A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//硬牌 无A 注：考虑首轮为保险 且只有h或s 
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
		else //软牌 有至少有一个A  且最后一个A以11加入 注：考虑首轮为保险 且只有h或s 
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
		printf("下一步动作：%c",c);		
	}
	else c='s';	
	#endif
	/******************************/
	return c; 
} 

/*玩家3后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action3(Player(*players)[]){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n玩家%s当前持有的牌为：", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n请选择下一步动作：\nh:拿牌；s:停牌\n");
		c=getche();
	}else c='s';
	#else
	/***这里应该有自己的业务逻辑***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//闲家的点数
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n玩家%s当前持有的牌为：", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//计算闲家牌 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //如果有多个A，则除了最后一个，其他只能记作1点 
			point_1++;
		}
		if(j==1){ //还剩一个A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//硬牌 无A 注：考虑首轮为保险 且只有h或s 
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
		else //软牌 有至少有一个A  且最后一个A以11加入 注：考虑首轮为保险 且只有h或s 
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
		printf("下一步动作：%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

/*玩家4后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action4(Player(*players)[]){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n玩家%s当前持有的牌为：", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n请选择下一步动作：\nh:拿牌；s:停牌\n");
		c=getche();
	}else c='s';
	#else
	/***这里应该有自己的业务逻辑***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//闲家的点数
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n玩家%s当前持有的牌为：", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//计算闲家牌 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //如果有多个A，则除了最后一个，其他只能记作1点 
			point_1++;
		}
		if(j==1){ //还剩一个A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;
			}
		}
		if(flag==0)//硬牌 无A 注：考虑首轮为保险 且只有h或s 
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
		else //软牌 有至少有一个A  且最后一个A以11加入 注：考虑首轮为保险 且只有h或s 
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
		printf("下一步动作：%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

/*玩家5后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action5(Player(*players)[]){
	char c; //该变量是用于返回不同状态的字符
	#ifdef PERSON 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i'){
		printf("\n玩家%s当前持有的牌为：", me->name);
		int i;
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		printf("\n请选择下一步动作：\nh:拿牌；s:停牌\n");
		c=getche();
	}else c='s';
	#else
	/***这里应该有自己的业务逻辑***/ 
	Player* me=&(*players)[0];
	if(me->state=='h'||me->state=='i')
	{
		int point_1=0;//闲家的点数
		int Acnt=0; 
		int i,j,flag=0;
		printf("\n玩家%s当前持有的牌为：", me->name);
		for(i=0;i<me->count;++i)
			printf("%c ", me->mycards[i]);
		//计算闲家牌 
		for(i=0; i<=me->count; ++i)
		{
			if(me->mycards[i]>='2'&&me->mycards[i]<='9')
				point_1+=me->mycards[i]-'0';
			else if(me->mycards[i]=='T'||me->mycards[i]=='J'||me->mycards[i]=='Q'||me->mycards[i]=='K')	
				point_1+=10;
			else if(me->mycards[i]=='A')
				Acnt++;	
		}
		for(j=Acnt; j>1; --j){ //如果有多个A，则除了最后一个，其他只能记作1点 
			point_1++;
		}
		if(j==1){ //还剩一个A 
			if(point_1<=10) {
				point_1+=11;
				flag=1;
			}else{
				point_1++;//有A算11点 flag=1 
			}
		}
		if(flag==0)//硬牌 无A 注：考虑首轮为保险 且只有h或s 
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
		else //软牌 有至少有一个A  且最后一个A以11加入 注：考虑首轮为保险 且只有h或s 
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
		printf("下一步动作：%c",c);		
	}
	else c='s';
	#endif
	/******************************/
	return c; 
} 

//玩家1看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
void show1(Banker* pbanker, Player(*players)[], int pNum, int N, int pos){
	//使用高低算牌术来进行<最优>下注
	//你占adv的优势，本钱总数为account，那么最优赌注是b=ad*ac。 
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
	if(advs>0&&advs<=0.5)//闲家1.预估最优 限定最大赌值100 300 500 以及倍率0.1,0.25,0.5三个档次 
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
//	printf("\n优胜点%d",adv);
//	printf("\n平均优势点%lf",advs);
//	printf("\n优势赌注%d\n",adv1_acount);
	//此处可以看到本轮所有人的牌，据此可以调整自己的策略 
	//如下次下注的策略，各种牌出现的概率等 
} 

//玩家2看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
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
	if(advs>0&&advs<=0.5)//闲家2.正常 限定最大赌值300 倍率0.5 
		adv2_acount=0.5*advs*me->account;
		if(adv2_acount>=300)
			adv2_acount=300;
	if(advs>0.5)
		adv2_acount=0.25*me->account;
		if(adv2_acount>=300)
			adv2_acount=300;
	if(advs<=0)
		adv2_acount=10;
//	printf("\n优胜点%d",adv);
//	printf("\n平均优势点%lf\n",advs);
	//此处可以看到本轮所有人的牌，据此可以调整自己的策略 
	//如下次下注的策略，各种牌出现的概率等 
} 

//玩家3看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
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
	if(advs>0&&advs<=0.5)//闲家3.冒险 不限定最大赌值  倍率1.0 
		adv3_acount=advs*me->account;
	if(advs>0.5)
		adv3_acount=0.25*me->account; 
	if(advs<=0)
		adv3_acount=10;
//	printf("\n优胜点%d",adv);
//	printf("\n平均优势点%lf\n",advs);
	//此处可以看到本轮所有人的牌，据此可以调整自己的策略 
	//如下次下注的策略，各种牌出现的概率等 
} 

//玩家4看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
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
	if(advs>0&&advs<=0.5)//闲家4.限定最大赌值500  倍率1.0
		adv4_acount=advs*me->account;
		if(adv4_acount>=500)
			adv4_acount=500;
	if(advs>0.5)
		adv4_acount=0.5*me->account;
		if(adv4_acount>=500)
			adv4_acount=500; 
	if(advs<=0)
		adv4_acount=10;
//	printf("\n优胜点%d",adv);
//	printf("\n平均优势点%lf\n",advs);
	//此处可以看到本轮所有人的牌，据此可以调整自己的策略 
	//如下次下注的策略，各种牌出现的概率等 
} 

//玩家5看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
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
	if(advs>0&&advs<=0.5)//闲家5.保守型 限定最大赌值100 以及倍率0.1 
		adv5_acount=0.1*advs*me->account;
		if(adv5_acount>=100)
			adv5_acount=100;
	if(advs>0.5)
		adv5_acount=0.05*me->account;
		if(adv5_acount>=100)
			adv5_acount=100; 
	if(advs<=0)
		adv5_acount=10;
//	printf("\n优胜点%d",adv);
//	printf("\n平均优势点%lf\n",advs);
	//此处可以看到本轮所有人的牌，据此可以调整自己的策略 
	//如下次下注的策略，各种牌出现的概率等 
} 
