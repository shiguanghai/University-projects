#include "twentyone.h"
static int win[5];//<计算闲家胜场>
void Win()
{
	win[0]=0;
	win[1]=0;
	win[2]=0;
	win[3]=0;
	win[4]=0;
}

void swap(char* a, char* b){
	char t;
	t=*a;
	*a=*b;
	*b=t;
}

//初始化牌数组
void init_cards(char* cards, int N){
	int i,j,k;
	for(i=0; i<N; ++i){
		for(k=0; k<4; ++k){
			cards[i*52+k*13]='A';
			for(j=1; j<9; ++j)
				cards[i*52+k*13+j]='1'+j;
			cards[i*52+k*13+9]='T';
			cards[i*52+k*13+10]='J';
			cards[i*52+k*13+11]='Q';
			cards[i*52+k*13+12]='K';
		}
	}
}

//洗牌
void shuffle_cards(char* cards, int N){
	srand((unsigned) time(NULL));
	int i;
	for(i=0; i<N*52; ++i){
		int pa, pb;
		pa=rand()%(N*52);
		pb=rand()%(N*52);
		swap(&cards[pa],&cards[pb]);
	}
}

//发牌 
void first_deal(const char* cards, int* ppos, Banker* pbanker, Player(*pplayers)[], int pNum){
	pbanker->mycards[0]=cards[(*ppos)++];
	pbanker->mycards[1]=cards[(*ppos)++];
	pbanker->count=2; 
	pbanker->state='d';
	int i;
	for(i=0; i<pNum-1; ++i){
		if((*pplayers)[i].account>0){//>0
			(*pplayers)[i].mycards[0]=cards[(*ppos)++];
			(*pplayers)[i].mycards[1]=cards[(*ppos)++];
			(*pplayers)[i].count=2;
		}
	}
} 

//每一轮的初始化
void round_init(Banker* pbanker, Player(*players)[], int pNum){
	pbanker->count=0;
	pbanker->points=0;
	pbanker->state='d';
	memset(pbanker->mycards,0,sizeof(pbanker->mycards));
	
	int i;
	for(i=0; i<pNum-1; ++i){
		Player* me=&(*players)[i];
		me->count=0;
		memset(me->mycards,0,sizeof(me->mycards));
		me->mybets=0;
		me->points=0;
		me->state=0;
	}
}

//抓一张牌
char getcard(const char* cards, int* ppos){
	return cards[(*ppos)++];
} 

//第i个玩家买保险后，玩家及庄家所需做的动作 
//参数：
//		pbanker，指向庄家的指针
//		i，第i个玩家
//		Player(*players)[]，指向玩家数组的指针
//		tmpcards，当前已经发放的牌存放的数组 
void insurance(Banker* pbanker, int i, Player(*players)[], char* tmpcards){
	Player* me=&(*players)[i];
	if(me->account>=me->mybets/2){ //剩余赌资还够买保险的 
		me->account-=me->mybets/2; //扣除保险金 
		char t=pbanker->mycards[1]; //获取庄家的第二张牌 
		if(t=='T'||t=='J'||t=='Q'||t=='K') { //满足条件则设置为明牌 
			tmpcards[1]=pbanker->mycards[1];
			pbanker->state='l';
			me->account+=me->mybets*2;
		}
	}else{
		me->state='w'; //不够买保险，转入错误状态 
	}
} 

//第i个玩家拿牌 
//参数：
//		i，第i个玩家 
//		Player(*players)[]，指向玩家数组的指针
//		card，拿到的牌
void hit(int i, Player(*players)[], char card){
	Player* me=&(*players)[i]; 
	me->mycards[me->count++]=card;
} 

//第i个玩家加倍 
//参数：
//		i，第i个玩家 
//		Player(*players)[]，指向玩家数组的指针
//		card，加倍之后拿到的牌
void dbl(int i, Player(*players)[], char card){
	Player* me=&(*players)[i]; 
	if(me->account>0){
		me->account-=me->mybets;
		me->mybets*=2;
		me->mycards[me->count++]=card;
		me->state='s';
	}
} 

//第i个玩家投降 
//参数：
//		i，第i个玩家 
//		Player(*players)[]，指向玩家数组的指针
void surrender(int i, Player(*players)[]){
	Player* me=&(*players)[i]; 
	if(me->account>0){
		me->account+=me->mybets/2;
		me->mybets=0;
		me->state='u';
	}
} 

//第i个玩家犯规（违规），赌注没收 
//参数：
//		i，第i个玩家 
//		Player(*players)[]，指向玩家数组的指针 
void foul(int i, Player(*players)[]){
	Player* me=&(*players)[i];
	if(me->account>0){
		me->mybets=0;
		me->state='w';
	}
} 

//根据牌计算总点数 
//参数：
//		mycards，待计算的扑克牌数组 
//		len，数组长度
//返回值：计算得到的点数 
int calculate(char(*mycards)[20] , int len){
	int i, point=0, Acnt=0;
	for(i=0; i<len; ++i){
		if((*mycards)[i]>='2'&&(*mycards)[i]<='9')
			point+=(*mycards)[i]-'0';
		else if((*mycards)[i]=='T'||(*mycards)[i]=='J'||(*mycards)[i]=='Q'||(*mycards)[i]=='K')
			point+=10;
		else if((*mycards)[i]=='A')
			Acnt++;
	}
	for(i=Acnt; i>1; --i){ //如果有多个A，则除了最后一个，其他只能记作1点 
		point++;
	}
	if(i==1){ //还剩一个A 
		if(point<=10) {
			point+=11;
		}else{
			point++;
		}
	}
	return point;
}

//庄家的后续处理
//参数：
//		banker，指向庄家的指针
//		cards，扑克牌数组
//		ppos，指向当前已经发牌的位置的指针 
void banker_continue(Banker* pbanker, const char* cards, int* ppos){
	pbanker->count=2;
	while(calculate(&pbanker->mycards, pbanker->count)<17){
		pbanker->mycards[pbanker->count++]=getcard(cards, ppos);
	}
	pbanker->points=calculate(&(pbanker->mycards), pbanker->count);
}

//比较大小，对赌注进行分配
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
void judge(Banker* pbanker, Player(*players)[], int pNum, int* palive, int* ptotal_round){
	int i,dead=0; 
	*ptotal_round++;
	for(i=0; i<pNum-1; ++i){
		Player* me=&(*players)[i];
		while(1)//<通过while循环解决break跳出for循环问题,用continue同理>
		{
			if(me->account>0){
				me->rounds++;
				if(me->state!='s'){ //停牌之外的情况，如保险、加倍、投降、违规 <保险 已排除> 
					break;//存在问题 <break直接跳出玩家1导致后续玩家直接输> 
				}
				if(me->points>21){ //玩家爆掉 
					break;
				}else if(pbanker->points>21){ //玩家没爆，庄家爆，玩家赢 
					me->account+=me->mybets*2;
					win[i]++;//<闲家i胜> 
					break;
				}else{ //都没爆，比大小 
					if(me->points>pbanker->points){ 
						me->account+=me->mybets*2;
						win[i]++;//<闲家i胜> 
						} 
					else if(me->points==pbanker->points)
						me->account+=me->mybets;
					break;
				}
			}else{
				me->account=0;
				dead++;
			}
			break; 
		}
		printf("玩家%s胜%d场\n",me->name,win[i]);
	}
	*palive=pNum-1-dead;
	
	printf("\n庄家本轮牌型如下：\n");
	for(i=0; i<pbanker->count; ++i){
		printf("%c ", pbanker->mycards[i]);
	}
	printf("\n");
	
	for(i=0; i<pNum-1; ++i){ //显示每个玩家本轮结果 
		Player* me=&(*players)[i];
		if(me->account>0){
			printf("%s本轮结果如下：\n",me->name);
			printf("剩余赌资：%d\n牌型如下：\n", me->account);
			int j;
			for(j=0; j<me->count; ++j)
				printf("%c ", me->mycards[j]);	
			printf("\n");
		}
	}
}

int cmp(const void* p1, const void* p2){
	Player* player1=(Player*)p1;
	Player* player2=(Player*)p2;
	if(player1->account>0&&player2->account>0)//<1和-1对调 以改为正确顺序> 
	{
		if(player1->account>player2->account) return -1;
		else if(player1->account<player2->account) return 1;
		else if(player1->account==player2->account){
			if(player1->rounds>player2->rounds) return -1;
			else if(player1->rounds<player2->rounds) return 1;
			else if(player1->rounds==player2->rounds) return 0;
		}
	}else if(player1->account>0) return -1;
	else if(player2->account>0) return 1;
	else{
		if(player1->rounds>player2->rounds) return -1;
		else if(player1->rounds<player2->rounds) return 1;
		else return 0;
	}
}

//显示最终玩牌的结果，先按照赌资排序，赌资相同的按照轮次排序 
void show_result(Player(*players)[], int pNum){//<有问题 排序反了已修改> 
	int i;
	for(i=0; i<pNum-1; ++i)
	{
		Player* me=&(*players)[i];
		printf("玩家%s账户中剩余赌资：%d\n",me->name,me->account);
		printf("已经玩了%d轮，胜%d场。\n\n", me->rounds,win[i]);//胜场已加入 方便查看
	} 
	printf("\n-------------排序后-------------\n");
	qsort((*players),pNum-1,sizeof(Player),cmp);
	for(i=0; i<pNum-1; ++i){
		Player* me=&(*players)[i];
		printf("玩家%s排名第%d，成绩如下：\n", me->name, i+1);
		printf("账户中剩余赌资：%d\n", me->account);
		printf("已经玩了%d轮。\n\n", me->rounds);
		
	}
}

