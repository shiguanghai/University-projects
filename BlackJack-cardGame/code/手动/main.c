#include "mycodes.h"
#define PERSON //人机交互与自动化的开关<保持处于打开状态> 

int main(int argc, char *argv[])
{
	int pos=0; //记录当前已经发牌的位置
	int pNum; //记录人数，含庄家
	int i;
	int N; //多少副扑克牌
	int cnt; //记录当前有多少人选择继续拿牌
	int alive; //记录当前有多少人“活着”，即有足够赌资继续玩下去
	int turns=0; //记录当前已经洗过几次牌 
	int total_rounds=0; //记录当前已经玩过的总局数
	int threshold; //设置还剩余牌数的阈值，低于该值则重新洗牌 
	Banker banker; //庄家 
	printf("请输入多少个人玩，含庄家（2-6）：");
	scanf("%d",&pNum);
	alive=pNum-1;
	Player players[pNum-1];
	for(i=0; i<pNum-1; ++i){ //初始化每个玩家的信息 
		printf("请输入第%d个玩家的昵称（不要有空格）：",i+1);
		scanf("%s",players[i].name);
		memset(players[i].mycards,0,sizeof(players[i].mycards)); 
		players[i].rounds=0;
		players[i].account=TOTAL_MONEY;
	}
	printf("请输入需要多少副扑克牌（4-8）：");
	scanf("%d",&N);
	printf("\n--------------------------------\n");
	threshold=N*52*THD; //设置阈值 
	char* cards=malloc(52*N); 
	init_cards(cards, N); //初始化扑克牌 
	shuffle_cards(cards, N); //洗牌 
	turns++;
	advantage();//初始化优势点 
	Win();//初始化胜场 
	do{ //用当前新洗过的扑克牌玩游戏 
		printf("\n--------------------------------\n");
		if(turns==SHUFFLE_TIMES) break; //如果已经洗了SHUFFLE_TIMES次牌，则停止游戏，比较胜负关系 
		
		round_init(&banker, &players, pNum); //每一轮庄家和各个玩家初始化 
		int (*betsarr[])()={bet1,bet2,bet3,bet4,bet5}; //用于下注的函数指针数组 
	
		//各个玩家依次下注 
		printf("\n");
		for(i=0; i<pNum-1; ++i){
			if(players[i].account>0){//>0
				#ifdef PERSON
				printf("玩家%s下注:",players[i].name);
				#endif
				int mybet=betsarr[i](N);
				if(mybet<MIN_BET) mybet=MIN_BET;
				players[i].mybets=mybet;
				players[i].account-=mybet;
			}
		}
		for(i=0; i<pNum-1; ++i)
			if(players[i].account>0) alive++;//>0
		char tmpcards[alive*2+2]; //用于存储给所有人看的首次已经发放的牌，暗牌用X表示 
		memcpy(tmpcards, &cards[pos], sizeof(tmpcards)); //把要发的牌存储到临时数组中 
		first_deal(cards, &pos, &banker, &players, pNum); //首次发牌 
		#ifdef PERSON
		/***********显示庄家和每个玩家的牌信息*************/
		printf("\n庄家：%c  ", banker.mycards[0]);
		if(banker.state=='d') 
			printf("X\n");
		else
			printf("%c\n",banker.mycards[1]);
		for(i=0; i<pNum-1; ++i)
			if(players[i].account>0)//>0
				printf("玩家%s：%c  %c\n",players[i].name,players[i].mycards[0],players[i].mycards[1]);
		printf("目前已经发放到的位置：%d\n",pos);
		/**************************************************/
		#endif
		char t=tmpcards[0];
		if(!((t=='T'||t=='J'||t=='Q'||t=='K')&&tmpcards[1]=='A'))
			tmpcards[1]='X'; //设置暗牌
		char (*first_action_arr[])(char*, int)={first_action1,first_action2,first_action3,
		first_action4,first_action5}; //定义首次发牌后各个玩家的动作函数指针数组 
		for(i=0; i<pNum-1; ++i){  
			if(players[i].account>0) //还活着的玩家给出本轮首次动作//>0
			{ 
				printf("\n玩家%s",players[i].name);//得到链表玩家不明显，易混淆
				players[i].state=first_action_arr[i](tmpcards, sizeof(tmpcards));
			}	
		}
		for(i=0; i<pNum-1; ++i){ 
			if(players[i].account>0){ //判断活着的玩家首次动作 //>0
				char c;
				int point=calculate(&players[i].mycards,players[i].count);
				switch (players[i].state){
					case 'i': //保险 
						if(tmpcards[0]!='A'){ 
							players[i].state='w'; //违规 
						}else{
							insurance(&banker, i, &players, tmpcards);
						} 
						break;
					case 'h': //拿牌 
						c=getcard(cards, &pos);
						hit(i,&players,c);
						point=calculate(&players[i].mycards,players[i].count);
						if(point>21){
							players[i].state='s';
						}
						break;
					case 's': //停牌 
						break;
					case 'd': //加倍 
						c=getcard(cards, &pos);
						dbl(i,&players,c);
						break;
					case 'u': //投降 
						surrender(i,&players);
						break;
					default: //违规 
						foul(i,&players); 
						break;
				}
			}
		}
		char (*continue_actions[])()={continue_action1,continue_action2,continue_action3,
		continue_action4,continue_action5}; //定义后续每个玩家动作的函数指针数组 
		do{ //过了首次发牌之后，剩余的动作 
			for(i=0; i<pNum-1; ++i){
				if(players[i].account>0){
					char c;
					int point=calculate(&players[i].mycards,players[i].count);
					if(players[i].state=='h'||players[i].state=='i')//<买完保险以后情况被忽视 >
					{
						players[i].state=continue_actions[i](&players[i]);
					}
					if(point>21){
						players[i].state='s';
					}
					switch (players[i].state){
						case 'h': //拿牌 
							c=getcard(cards, &pos);
							hit(i,&players,c);
							point=calculate(&players[i].mycards,players[i].count);
							if(point>21){
								players[i].state='s';
							}
							break;
						case 's': //停牌 
							break;
						case 'd': //加倍<保险后可能选择加倍> 
							c=getcard(cards, &pos);
							dbl(i,&players,c);
							break;
					}
				}
//				char t=players[i].state;
//				printf("\n%d玩家的状态%c:",i,t);//调试bug 
			}
			//统计拿牌指令个数，存入cnt
			cnt=0;
			for(i=0; i<pNum-1; ++i) 
				if(players[i].state=='h') cnt++;
		}while(cnt>0); //如果仍然有人选择继续拿牌，则继续循环 
		printf("\n");
		
		//庄家做后续处理
		banker_continue(&banker, cards, &pos);
		
		//计算每个人的点数
		for(i=0; i<pNum-1; ++i){
			players[i].points=calculate(&players[i].mycards, players[i].count);
		}
		
		//比较庄家与每个人的点数，更新每个人的账户 
		judge(&banker, &players, pNum, &alive, &total_rounds);
		
		void (*show_arr[])(Banker*, Player(*players)[], int, int ,int)=
			{show1, show2, show3, show4, show5}; //定义看所有人本轮牌的函数指针数组 
		//让每个人看到本轮目前所有人的牌 
		for(i=0; i<pNum-1; ++i){
			show_arr[i](&banker, &players, pNum, N, pos); //<通过N pos 计算平均优势点>
		}
		
		if(pos>=threshold){ //如果当前使用的扑克牌数量超过阈值，重新洗牌 
			init_cards(cards, N);
			shuffle_cards(cards, N);
			pos=0;
			turns++;
			advantage();
		}
	}while(alive>0&&total_rounds<ROUNDS*(pNum-1));
	
	//显示最终胜负结果
	printf("\n--------------------------------\n");
	show_result(&players, pNum);
	 
	return 0;
}
