#include "twentyone.h"
static int win[5];//<�����м�ʤ��>
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

//��ʼ��������
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

//ϴ��
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

//���� 
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

//ÿһ�ֵĳ�ʼ��
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

//ץһ����
char getcard(const char* cards, int* ppos){
	return cards[(*ppos)++];
} 

//��i��������պ���Ҽ�ׯ���������Ķ��� 
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		i����i�����
//		Player(*players)[]��ָ����������ָ��
//		tmpcards����ǰ�Ѿ����ŵ��ƴ�ŵ����� 
void insurance(Banker* pbanker, int i, Player(*players)[], char* tmpcards){
	Player* me=&(*players)[i];
	if(me->account>=me->mybets/2){ //ʣ����ʻ������յ� 
		me->account-=me->mybets/2; //�۳����ս� 
		char t=pbanker->mycards[1]; //��ȡׯ�ҵĵڶ����� 
		if(t=='T'||t=='J'||t=='Q'||t=='K') { //��������������Ϊ���� 
			tmpcards[1]=pbanker->mycards[1];
			pbanker->state='l';
			me->account+=me->mybets*2;
		}
	}else{
		me->state='w'; //�������գ�ת�����״̬ 
	}
} 

//��i��������� 
//������
//		i����i����� 
//		Player(*players)[]��ָ����������ָ��
//		card���õ�����
void hit(int i, Player(*players)[], char card){
	Player* me=&(*players)[i]; 
	me->mycards[me->count++]=card;
} 

//��i����Ҽӱ� 
//������
//		i����i����� 
//		Player(*players)[]��ָ����������ָ��
//		card���ӱ�֮���õ�����
void dbl(int i, Player(*players)[], char card){
	Player* me=&(*players)[i]; 
	if(me->account>0){
		me->account-=me->mybets;
		me->mybets*=2;
		me->mycards[me->count++]=card;
		me->state='s';
	}
} 

//��i�����Ͷ�� 
//������
//		i����i����� 
//		Player(*players)[]��ָ����������ָ��
void surrender(int i, Player(*players)[]){
	Player* me=&(*players)[i]; 
	if(me->account>0){
		me->account+=me->mybets/2;
		me->mybets=0;
		me->state='u';
	}
} 

//��i����ҷ��棨Υ�棩����עû�� 
//������
//		i����i����� 
//		Player(*players)[]��ָ����������ָ�� 
void foul(int i, Player(*players)[]){
	Player* me=&(*players)[i];
	if(me->account>0){
		me->mybets=0;
		me->state='w';
	}
} 

//�����Ƽ����ܵ��� 
//������
//		mycards����������˿������� 
//		len�����鳤��
//����ֵ������õ��ĵ��� 
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
	for(i=Acnt; i>1; --i){ //����ж��A����������һ��������ֻ�ܼ���1�� 
		point++;
	}
	if(i==1){ //��ʣһ��A 
		if(point<=10) {
			point+=11;
		}else{
			point++;
		}
	}
	return point;
}

//ׯ�ҵĺ�������
//������
//		banker��ָ��ׯ�ҵ�ָ��
//		cards���˿�������
//		ppos��ָ��ǰ�Ѿ����Ƶ�λ�õ�ָ�� 
void banker_continue(Banker* pbanker, const char* cards, int* ppos){
	pbanker->count=2;
	while(calculate(&pbanker->mycards, pbanker->count)<17){
		pbanker->mycards[pbanker->count++]=getcard(cards, ppos);
	}
	pbanker->points=calculate(&(pbanker->mycards), pbanker->count);
}

//�Ƚϴ�С���Զ�ע���з���
//������
//		pbanker��ָ��ׯ�ҵ�ָ��
//		Player(*players)[]��ָ����������ָ��
//		pNum������������ׯ�ң� 
void judge(Banker* pbanker, Player(*players)[], int pNum, int* palive, int* ptotal_round){
	int i,dead=0; 
	*ptotal_round++;
	for(i=0; i<pNum-1; ++i){
		Player* me=&(*players)[i];
		while(1)//<ͨ��whileѭ�����break����forѭ������,��continueͬ��>
		{
			if(me->account>0){
				me->rounds++;
				if(me->state!='s'){ //ͣ��֮���������籣�ա��ӱ���Ͷ����Υ�� <���� ���ų�> 
					break;//�������� <breakֱ���������1���º������ֱ����> 
				}
				if(me->points>21){ //��ұ��� 
					break;
				}else if(pbanker->points>21){ //���û����ׯ�ұ������Ӯ 
					me->account+=me->mybets*2;
					win[i]++;//<�м�iʤ> 
					break;
				}else{ //��û�����ȴ�С 
					if(me->points>pbanker->points){ 
						me->account+=me->mybets*2;
						win[i]++;//<�м�iʤ> 
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
		printf("���%sʤ%d��\n",me->name,win[i]);
	}
	*palive=pNum-1-dead;
	
	printf("\nׯ�ұ����������£�\n");
	for(i=0; i<pbanker->count; ++i){
		printf("%c ", pbanker->mycards[i]);
	}
	printf("\n");
	
	for(i=0; i<pNum-1; ++i){ //��ʾÿ����ұ��ֽ�� 
		Player* me=&(*players)[i];
		if(me->account>0){
			printf("%s���ֽ�����£�\n",me->name);
			printf("ʣ����ʣ�%d\n�������£�\n", me->account);
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
	if(player1->account>0&&player2->account>0)//<1��-1�Ե� �Ը�Ϊ��ȷ˳��> 
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

//��ʾ�������ƵĽ�����Ȱ��ն������򣬶�����ͬ�İ����ִ����� 
void show_result(Player(*players)[], int pNum){//<������ ���������޸�> 
	int i;
	for(i=0; i<pNum-1; ++i)
	{
		Player* me=&(*players)[i];
		printf("���%s�˻���ʣ����ʣ�%d\n",me->name,me->account);
		printf("�Ѿ�����%d�֣�ʤ%d����\n\n", me->rounds,win[i]);//ʤ���Ѽ��� ����鿴
	} 
	printf("\n-------------�����-------------\n");
	qsort((*players),pNum-1,sizeof(Player),cmp);
	for(i=0; i<pNum-1; ++i){
		Player* me=&(*players)[i];
		printf("���%s������%d���ɼ����£�\n", me->name, i+1);
		printf("�˻���ʣ����ʣ�%d\n", me->account);
		printf("�Ѿ�����%d�֡�\n\n", me->rounds);
		
	}
}

