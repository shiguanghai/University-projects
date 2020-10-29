#include "twentyone.h"

//优势点静态全局变量设置为0 
void advantage();

//第1个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet1(int N);

//第2个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet2(int N);

//第3个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet3(int N);

//第4个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet4(int N);

//第5个玩家下注
//参数：
//	N，代表一共有几副扑克牌 
//返回值：
//	所下注的金额 
int bet5(int N);

/*玩家1首轮动作 
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
char first_action1(char* tmpcards, int len);

/*玩家2首轮动作 
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
char first_action2(char* tmpcards, int len);

/*玩家3首轮动作 
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
char first_action3(char* tmpcards, int len);

/*玩家4首轮动作 
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
char first_action4(char* tmpcards, int len);

/*玩家5首轮动作 
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
char first_action5(char* tmpcards, int len);

/*玩家1后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action1(Player(*players)[]);

/*玩家2后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action2(Player(*players)[]);

/*玩家3后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action3(Player(*players)[]);

/*玩家4后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action4(Player(*players)[]);

/*玩家5后续动作 
*  参数：指向所有玩家数组的指针 
*  返回值，代表每个玩家给出的动作，
*        h，代表继续拿牌， 
*        s，代表停牌， 
*/ 
char continue_action5(Player(*players)[]);

//玩家1看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家）
//		N， 牌的副数
//		pos，发牌的位置   
void show1(Banker* pbanker, Player(*players)[], int pNum, int N, int pos);

//玩家2看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家）
//		N， 牌的副数
//		pos，发牌的位置  
void show2(Banker* pbanker, Player(*players)[], int pNum, int N, int pos);

//玩家3看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
//		N， 牌的副数
//		pos，发牌的位置  
void show3(Banker* pbanker, Player(*players)[], int pNum, int N, int pos);

//玩家4看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
//		N， 牌的副数
//		pos，发牌的位置  
void show4(Banker* pbanker, Player(*players)[], int pNum, int N, int pos);

//玩家5看所有人的牌
//参数：
//		pbanker，指向庄家的指针
//		Player(*players)[]，指向玩家数组的指针
//		pNum，总人数（含庄家） 
//		N， 牌的副数
//		pos，发牌的位置  
void show5(Banker* pbanker, Player(*players)[], int pNum, int N, int pos);

