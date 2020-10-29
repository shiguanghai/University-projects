#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#define TOTAL_MONEY 1000 //每个玩家初始总的赌资 
#define MIN_BET 10 //设置每次下注的最小值，若手中剩余赌资低于该值，则该玩家退出 
#define THD 3/4 //设置阈值比例，已经用过的扑克牌数量超过阈值比例，则重新洗牌 
#define SHUFFLE_TIMES 5 //设置洗牌次数的阈值，超过该次数则停止游戏 
#define ROUNDS 50 //设置总局数的阈值，超过该阈值则停止游戏

/*定义存储玩家信息的结构体 */
typedef struct{
	char name[20]; //玩家昵称 
	int account; //账户剩余金钱 
	char mycards[20]; //本轮已经拿到的牌 
	int count; //本轮已经拿到牌的数量
	char state; //当前状态；i，买保险；h，继续拿牌；s，停牌；d，加倍；u，投降；其他，错误 
	int mybets; //本轮已经下的赌注 
	int points; //本轮牌对应的点数 
	int rounds; //已经玩的轮数 
}Player;  

/*定义存储庄家信息的结构体 */
typedef struct{
	char mycards[20]; //本轮已经拿到的牌
	int count; //本轮已经拿到牌的数量
	char state; //状态；d，第二张是暗牌；l，第二张是明牌 
	int points; //本轮牌对应的点数
}Banker;

void Win();

/*初始化牌数组
*参数： 
*		char* cards，指向扑克牌数组的首地址
*		int N，扑克牌有几副 
*/
void init_cards(char* cards, int N);

/*洗牌 
*参数： 
*		char* cards，指向扑克牌数组的首地址
*		int N，扑克牌有几副 
*/
void shuffle_cards(char* cards, int N);

/*发牌 
*参数：
*		const char* cards，指向原始扑克牌的指针
*		int* ppos，原始扑克牌已经发放的位置
*		Banker* pbanker，指向庄家的指针
*		Player(*pplayers)[]，指向所有玩家的数组的指针
*		int pNum，总共玩游戏的人数（含庄家）
*/ 
void first_deal(const char* cards, int* ppos, Banker* pbanker, Player(*pplayers)[], int pNum);

/*每一轮的初始化
*参数：
*		Banker* pbanker，指向庄家的指针
*		Player(*pplayers)[]，指向所有玩家的数组的指针
*		int pNum，总共玩游戏的人数（含庄家）
*/ 
void round_init(Banker* pbanker, Player(*players)[], int pNum);

/*抓一张牌
*参数：
*		const char* cards，指向原始扑克牌的指针 
*		int* ppos，原始扑克牌已经发放的位置
*/
char getcard(const char* cards, int* ppos);

/*第i个玩家买保险后，玩家及庄家所需做的动作 
*参数：
*		pbanker，指向庄家的指针
*		i，第i个玩家
*		Player(*players)[]，指向玩家数组的指针
*		tmpcards，当前已经发放的牌存放的数组 
*/
void insurance(Banker* pbanker, int i, Player(*players)[], char* tmpcards);

/*第i个玩家拿牌 
*参数：
*		i，第i个玩家 
*		Player(*players)[]，指向玩家数组的指针
*		card，拿到的牌
*/
void hit(int i, Player(*players)[], char card);

/*第i个玩家加倍 
*参数：
*		i，第i个玩家 
*		Player(*players)[]，指向玩家数组的指针
*		card，加倍之后拿到的牌
*/
void dbl(int i, Player(*players)[], char card);

/*第i个玩家投降 
*参数：
*		i，第i个玩家 
*		Player(*players)[]，指向玩家数组的指针
*/
void surrender(int i, Player(*players)[]);

/*第i个玩家犯规（违规），赌注没收 
*参数：
*		i，第i个玩家 
*		Player(*players)[]，指向玩家数组的指针 
*/
void foul(int i, Player(*players)[]);

/*根据牌计算总点数 
*参数：
*		mycards，待计算的扑克牌数组 
*		len，数组长度
*返回值：计算得到的点数 
*/
int calculate(char(*mycards)[20] , int len);

/*庄家的后续处理
*参数：
*		banker，指向庄家的指针
*		cards，扑克牌数组
*		ppos，指向当前已经发牌的位置的指针 
*/
void banker_continue(Banker* pbanker, const char* cards, int* ppos);

/*比较大小，对赌注进行分配
*参数：
*		pbanker，指向庄家的指针
*		Player(*players)[]，指向玩家数组的指针
*		pNum，总人数（含庄家） 
*/ 
void judge(Banker* pbanker, Player(*players)[], int pNum, int* palive, int* ptotal_round);

/*显示最终玩牌的结果，先按照赌资排序，赌资相同的按照轮次排序 
*		Player(*players)[]，指向玩家数组的指针
*		pNum，总人数（含庄家） 
*/ 
void show_result(Player(*players)[], int pNum);


