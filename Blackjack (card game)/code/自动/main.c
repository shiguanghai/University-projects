#include "mycodes.h"
#define PERSON //�˻��������Զ����Ŀ���<���ִ��ڴ�״̬> 

int main(int argc, char *argv[])
{
	int pos=0; //��¼��ǰ�Ѿ����Ƶ�λ��
	int pNum; //��¼��������ׯ��
	int i;
	int N; //���ٸ��˿���
	int cnt; //��¼��ǰ�ж�����ѡ���������
	int alive; //��¼��ǰ�ж����ˡ����š��������㹻���ʼ�������ȥ
	int turns=0; //��¼��ǰ�Ѿ�ϴ�������� 
	int total_rounds=0; //��¼��ǰ�Ѿ�������ܾ���
	int threshold; //���û�ʣ����������ֵ�����ڸ�ֵ������ϴ�� 
	Banker banker; //ׯ�� 
	printf("��������ٸ����棬��ׯ�ң�2-6����");
	scanf("%d",&pNum);
	alive=pNum-1;
	Player players[pNum-1];
	for(i=0; i<pNum-1; ++i){ //��ʼ��ÿ����ҵ���Ϣ 
		printf("�������%d����ҵ��ǳƣ���Ҫ�пո񣩣�",i+1);
		scanf("%s",players[i].name);
		memset(players[i].mycards,0,sizeof(players[i].mycards)); 
		players[i].rounds=0;
		players[i].account=TOTAL_MONEY;
	}
	printf("��������Ҫ���ٸ��˿��ƣ�4-8����");
	scanf("%d",&N);
	printf("\n--------------------------------\n");
	threshold=N*52*THD; //������ֵ 
	char* cards=malloc(52*N); 
	init_cards(cards, N); //��ʼ���˿��� 
	shuffle_cards(cards, N); //ϴ�� 
	turns++;
	advantage();//��ʼ�����Ƶ� 
	Win();//��ʼ��ʤ�� 
	do{ //�õ�ǰ��ϴ�����˿�������Ϸ 
		printf("\n--------------------------------\n");
		if(turns==SHUFFLE_TIMES) break; //����Ѿ�ϴ��SHUFFLE_TIMES���ƣ���ֹͣ��Ϸ���Ƚ�ʤ����ϵ 
		
		round_init(&banker, &players, pNum); //ÿһ��ׯ�Һ͸�����ҳ�ʼ�� 
		int (*betsarr[])()={bet1,bet2,bet3,bet4,bet5}; //������ע�ĺ���ָ������ 
	
		//�������������ע 
		printf("\n");
		for(i=0; i<pNum-1; ++i){
			if(players[i].account>0){//>0
				#ifdef PERSON
				printf("���%s��ע:",players[i].name);
				#endif
				int mybet=betsarr[i](N);
				if(mybet<MIN_BET) mybet=MIN_BET;
				players[i].mybets=mybet;
				players[i].account-=mybet;
			}
		}
		for(i=0; i<pNum-1; ++i)
			if(players[i].account>0) alive++;//>0
		char tmpcards[alive*2+2]; //���ڴ洢�������˿����״��Ѿ����ŵ��ƣ�������X��ʾ 
		memcpy(tmpcards, &cards[pos], sizeof(tmpcards)); //��Ҫ�����ƴ洢����ʱ������ 
		first_deal(cards, &pos, &banker, &players, pNum); //�״η��� 
		#ifdef PERSON
		/***********��ʾׯ�Һ�ÿ����ҵ�����Ϣ*************/
		printf("\nׯ�ң�%c  ", banker.mycards[0]);
		if(banker.state=='d') 
			printf("X\n");
		else
			printf("%c\n",banker.mycards[1]);
		for(i=0; i<pNum-1; ++i)
			if(players[i].account>0)//>0
				printf("���%s��%c  %c\n",players[i].name,players[i].mycards[0],players[i].mycards[1]);
		printf("Ŀǰ�Ѿ����ŵ���λ�ã�%d\n",pos);
		/**************************************************/
		#endif
		char t=tmpcards[0];
		if(!((t=='T'||t=='J'||t=='Q'||t=='K')&&tmpcards[1]=='A'))
			tmpcards[1]='X'; //���ð���
		char (*first_action_arr[])(char*, int)={first_action1,first_action2,first_action3,
		first_action4,first_action5}; //�����״η��ƺ������ҵĶ�������ָ������ 
		for(i=0; i<pNum-1; ++i){  
			if(players[i].account>0) //�����ŵ���Ҹ��������״ζ���//>0
			{ 
				printf("\n���%s",players[i].name);//�õ�������Ҳ����ԣ��׻���
				players[i].state=first_action_arr[i](tmpcards, sizeof(tmpcards));
			}	
		}
		for(i=0; i<pNum-1; ++i){ 
			if(players[i].account>0){ //�жϻ��ŵ�����״ζ��� //>0
				char c;
				int point=calculate(&players[i].mycards,players[i].count);
				switch (players[i].state){
					case 'i': //���� 
						if(tmpcards[0]!='A'){ 
							players[i].state='w'; //Υ�� 
						}else{
							insurance(&banker, i, &players, tmpcards);
						} 
						break;
					case 'h': //���� 
						c=getcard(cards, &pos);
						hit(i,&players,c);
						point=calculate(&players[i].mycards,players[i].count);
						if(point>21){
							players[i].state='s';
						}
						break;
					case 's': //ͣ�� 
						break;
					case 'd': //�ӱ� 
						c=getcard(cards, &pos);
						dbl(i,&players,c);
						break;
					case 'u': //Ͷ�� 
						surrender(i,&players);
						break;
					default: //Υ�� 
						foul(i,&players); 
						break;
				}
			}
		}
		char (*continue_actions[])()={continue_action1,continue_action2,continue_action3,
		continue_action4,continue_action5}; //�������ÿ����Ҷ����ĺ���ָ������ 
		do{ //�����״η���֮��ʣ��Ķ��� 
			for(i=0; i<pNum-1; ++i){
				if(players[i].account>0){
					char c;
					int point=calculate(&players[i].mycards,players[i].count);
					if(players[i].state=='h'||players[i].state=='i')//<���걣���Ժ���������� >
					{
						players[i].state=continue_actions[i](&players[i]);
					}
					if(point>21){
						players[i].state='s';
					}
					switch (players[i].state){
						case 'h': //���� 
							c=getcard(cards, &pos);
							hit(i,&players,c);
							point=calculate(&players[i].mycards,players[i].count);
							if(point>21){
								players[i].state='s';
							}
							break;
						case 's': //ͣ�� 
							break;
						case 'd': //�ӱ�<���պ����ѡ��ӱ�> 
							c=getcard(cards, &pos);
							dbl(i,&players,c);
							break;
					}
				}
//				char t=players[i].state;
//				printf("\n%d��ҵ�״̬%c:",i,t);//����bug 
			}
			//ͳ������ָ�����������cnt
			cnt=0;
			for(i=0; i<pNum-1; ++i) 
				if(players[i].state=='h') cnt++;
		}while(cnt>0); //�����Ȼ����ѡ��������ƣ������ѭ�� 
		printf("\n");
		
		//ׯ������������
		banker_continue(&banker, cards, &pos);
		
		//����ÿ���˵ĵ���
		for(i=0; i<pNum-1; ++i){
			players[i].points=calculate(&players[i].mycards, players[i].count);
		}
		
		//�Ƚ�ׯ����ÿ���˵ĵ���������ÿ���˵��˻� 
		judge(&banker, &players, pNum, &alive, &total_rounds);
		
		void (*show_arr[])(Banker*, Player(*players)[], int, int ,int)=
			{show1, show2, show3, show4, show5}; //���忴�����˱����Ƶĺ���ָ������ 
		//��ÿ���˿�������Ŀǰ�����˵��� 
		for(i=0; i<pNum-1; ++i){
			show_arr[i](&banker, &players, pNum, N, pos); //<ͨ��N pos ����ƽ�����Ƶ�>
		}
		
		if(pos>=threshold){ //�����ǰʹ�õ��˿�������������ֵ������ϴ�� 
			init_cards(cards, N);
			shuffle_cards(cards, N);
			pos=0;
			turns++;
			advantage();
		}
	}while(alive>0&&total_rounds<ROUNDS*(pNum-1));
	
	//��ʾ����ʤ�����
	printf("\n--------------------------------\n");
	show_result(&players, pNum);
	 
	return 0;
}
