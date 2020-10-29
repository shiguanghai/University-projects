/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 29/10/2020 16:43:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`  (
  `id` int(11) NOT NULL,
  `carousel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iframe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES (1, '【时光の海】大学生创业主题采访', 'images/carousel/创业主题访谈.jpg', 'https://www.bilibili.com/video/BV1V4411a7r8', '//player.bilibili.com/player.html?aid=52291490&bvid=BV1V4411a7r8&cid=91520374&page=1');
INSERT INTO `carousel` VALUES (2, '【时光の海】大连英歌石植物园游记', 'images/carousel/大连英歌石植物园游记.png', 'https://www.bilibili.com/video/BV1C441147Xk', '//player.bilibili.com/player.html?aid=50857108&bvid=BV1C441147Xk&cid=89081536&page=1');
INSERT INTO `carousel` VALUES (3, '【时光の海】这是一个吃樱桃的季节', 'images/carousel/这是一个吃樱桃的季节.png', 'https://www.bilibili.com/video/BV1p4411g7uC', '//player.bilibili.com/player.html?aid=56613287&bvid=BV1p4411g7uC&cid=98908071&page=1');

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film`  (
  `id` int(11) NOT NULL,
  `film_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES (1, '时光の海', 'images/fiml_images/1.JPG', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (2, '时光の海', 'images/fiml_images/2.png', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (3, 'LiuGuoxin', 'images/fiml_images/3.png', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (4, '时光の海', 'images/fiml_images/4.png', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (5, 'LiuGuoxin', 'images/fiml_images/5.png', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (6, 'LiuGuoxin', 'images/fiml_images/6.JPG', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (7, 'LiuGuoxin', 'images/fiml_images/7.png', 'javascript:void(0);', 'home');
INSERT INTO `film` VALUES (8, '个人摄影', 'images/fiml_images/8.PNG', 'javascript:void(0);', 'home_left');
INSERT INTO `film` VALUES (9, '个人摄影', 'images/fiml_images/9.png', 'javascript:void(0);', 'home_left');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL,
  `typename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '数码', 'img/shuma.png');
INSERT INTO `type` VALUES (2, '旅行', 'img/lvxing.png');
INSERT INTO `type` VALUES (3, '摄影', 'img/sheying.png');
INSERT INTO `type` VALUES (4, '科技', 'img/keji.png');
INSERT INTO `type` VALUES (5, '搞笑', 'img/gaoxiao.png');
INSERT INTO `type` VALUES (6, '舞蹈', 'img/wudao.png');
INSERT INTO `type` VALUES (7, '科普', 'img/kepu.png');
INSERT INTO `type` VALUES (8, '美食', 'img/meishi.png');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ident` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '0普通用户\r\n1管理员',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique-username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123', '1', '', '');
INSERT INTO `user` VALUES (2, 'user1', '123', '0', '111111', '大连东软信息学院');
INSERT INTO `user` VALUES (28, 'user2', '123', '0', '123456', '河南漯河');
INSERT INTO `user` VALUES (29, 'wzb', '123', '0', '15239537260', '河南省漯河市临颍县');
INSERT INTO `user` VALUES (31, 'wangzibo18', 'wang8852165', '0', '', '');
INSERT INTO `user` VALUES (32, '18001020707', 'wang8852165', '0', '', '');
INSERT INTO `user` VALUES (33, 'wang8852165', 'wang8852165', '0', '', '');
INSERT INTO `user` VALUES (34, '8852165', 'wang8852165', '0', '', '');
INSERT INTO `user` VALUES (36, 'wzbdf', 'ffc66544', '0', '', '');
INSERT INTO `user` VALUES (37, '今生有缘', 'wang991216', '0', '', '');
INSERT INTO `user` VALUES (39, '子野', 'w1234567890', '0', '', '');
INSERT INTO `user` VALUES (42, 'admin.', '111111mm', '0', '', '');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`  (
  `id` int(11) NOT NULL,
  `video_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `iframe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reco` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES (1, '【guanyuhan426】重新开始对未知的探索——香港面基和阿布扎比的冒险', 'images/video_images/【guanyuhan426】重新开始对未知的探索——香港面基和阿布扎比的冒险.png', 'https://www.bilibili.com/video/BV1Pb411g73C?t=652', '//player.bilibili.com/player.html?aid=48254803&bvid=BV1Pb411g73C&cid=84520587&page=1', '023', 0);
INSERT INTO `video` VALUES (2, '【guanyuhan426】一个拍了3年的VLOG，只为了满足我的好奇心', 'images/video_images/【guanyuhan426】一个拍了3年的VLOG，只为了满足我的好奇心.png', 'https://www.bilibili.com/video/BV1W4411t7KS?t=121', '//player.bilibili.com/player.html?aid=51016315&bvid=BV1W4411t7KS&cid=89321981&page=1', '023', 0);
INSERT INTO `video` VALUES (3, '【影视飓风&特效小哥studio】认同感体系+幕后', 'images/video_images/【影视飓风&特效小哥studio】认同感体系+幕后.png', 'https://www.bilibili.com/video/BV1zE41187nD?t=416', '//player.bilibili.com/player.html?aid=74178146&bvid=BV1zE41187nD&cid=126922895&page=1', '03', 1);
INSERT INTO `video` VALUES (4, '【影视飓风&特效小哥studio】相机大战', 'images/video_images/【影视飓风&特效小哥studio】相机大战.png', 'https://www.bilibili.com/video/BV16Z4y1H7NG', '//player.bilibili.com/player.html?aid=371067145&bvid=BV16Z4y1H7NG&cid=201618188&page=1', '013', 0);
INSERT INTO `video` VALUES (5, '【TESTV官方频道】普通人开飞机会怎样', 'images/video_images/【TESTV官方频道】普通人开飞机会怎样.png', 'https://www.bilibili.com/video/BV1qt411M7fe', '//player.bilibili.com/player.html?aid=62348752&bvid=BV1qt411M7fe&cid=108360555&page=1', '047', 1);
INSERT INTO `video` VALUES (6, '【何同学】一看就懂！用水讲明白为什么5G更快', 'images/video_images/【何同学】一看就懂！用水讲明白为什么5G更快.png', 'https://www.bilibili.com/video/BV1T4411m7R7', '//player.bilibili.com/player.html?aid=66210564&bvid=BV1T4411m7R7&cid=114834392&page=1', '047', 0);
INSERT INTO `video` VALUES (7, '【伢伢】是在夏天会心动的女同学～Summertime！', 'images/video_images/【伢伢】是在夏天会心动的女同学～Summertime！.png', 'https://www.bilibili.com/video/BV1KD4y1D7vW', '//player.bilibili.com/player.html?aid=711423840&bvid=BV1KD4y1D7vW&cid=215779564&page=1', '06', 0);
INSERT INTO `video` VALUES (8, '【影视飓风】没有8K的视频旗舰？A7S3深度评测', 'images/video_images/【影视飓风】没有8K的视频旗舰？A7S3深度评测.png', 'https://www.bilibili.com/video/BV11T4y1j72S', '//player.bilibili.com/player.html?aid=926597433&bvid=BV11T4y1j72S&cid=218386620&page=1', '01', 1);
INSERT INTO `video` VALUES (9, '【LKS】售价2万+等身大实体娃娃深度科普', 'images/video_images/【LKS】售价2万+等身大实体娃娃深度科普.png', 'https://www.bilibili.com/video/BV1Q4411w7ap', '//player.bilibili.com/player.html?aid=57767375&bvid=BV1Q4411w7ap&cid=100836387&page=1', '07', 1);
INSERT INTO `video` VALUES (10, '【LKS】UP主把望远镜搬上长城过夜，能拍到怎样的星空？', 'images/video_images/【LKS】UP主把望远镜搬上长城过夜，能拍到怎样的星空？.png', 'https://www.bilibili.com/video/BV1aK4y1v7f5', '//player.bilibili.com/player.html?aid=884114367&bvid=BV1aK4y1v7f5&cid=217785987&page=1', '0237', 0);
INSERT INTO `video` VALUES (11, '【C菌】最适合谈恋爱的城市, 空气里都飘着爱意!', 'images/video_images/【C菌】最适合谈恋爱的城市, 空气里都飘着爱意!.png', 'https://www.bilibili.com/video/BV1MC4y1873P', '//player.bilibili.com/player.html?aid=796608241&bvid=BV1MC4y1873P&cid=220156785&page=1', '023', 1);
INSERT INTO `video` VALUES (12, '【C菌】世界上最幸福的专业, 学校给你买游戏, 瞬间爱上学习!!', 'images/video_images/【C菌】世界上最幸福的专业, 学校给你买游戏, 瞬间爱上学习!!.png', 'https://www.bilibili.com/video/BV1eh411Z7fT', '//player.bilibili.com/player.html?aid=201561326&bvid=BV1eh411Z7fT&cid=220704971&page=1', '07', 1);
INSERT INTO `video` VALUES (13, '【椭奇】氧气少女向你告白~对你青睐 ♡', 'images/video_images/【椭奇】氧气少女向你告白~对你青睐 ♡.png', 'https://www.bilibili.com/video/BV1Tb411E7ws', '//player.bilibili.com/player.html?aid=47167171&bvid=BV1Tb411E7ws&cid=82804828&page=1', '06', 1);
INSERT INTO `video` VALUES (14, '【食贫道】叙利亚孤儿院当暑期工，中国大叔给54个孤儿做饭', 'images/video_images/【食贫道】叙利亚孤儿院当暑期工，中国大叔给54个孤儿做饭.png', 'https://www.bilibili.com/video/BV1St411A74Q', '//player.bilibili.com/player.html?aid=60852261&bvid=BV1St411A74Q&cid=105887572&page=1', '03', 1);
INSERT INTO `video` VALUES (15, '【绵羊料理】卖398一份的米其林招牌菜，自己在家做得花多少钱', 'images/video_images/【绵羊料理】卖398一份的米其林招牌菜，自己在家做得花多少钱.png', 'https://www.bilibili.com/video/BV1Bp4y117LU', '//player.bilibili.com/player.html?aid=967567282&bvid=BV1Bp4y117LU&cid=172150047&page=1', '08', 1);
INSERT INTO `video` VALUES (16, '【醋醋】这就是二次元广场舞吗，真香！彩虹节拍', 'images/video_images/【醋醋】这就是二次元广场舞吗，真香！彩虹节拍.png', 'https://www.bilibili.com/video/BV1w7411T7pi', '//player.bilibili.com/player.html?aid=91996500&bvid=BV1w7411T7pi&cid=157074730&page=1', '06', 0);
INSERT INTO `video` VALUES (17, '【DannyData小丹尼】瑞幸真是割美国韭菜，补贴中国人喝咖啡吗？', 'images/video_images/【DannyData小丹尼】瑞幸真是割美国韭菜，补贴中国人喝咖啡吗？.png', 'https://www.bilibili.com/video/BV1DJ411G7Lm', '//player.bilibili.com/player.html?aid=82738771&bvid=BV1DJ411G7Lm&cid=141556545&page=1', '07', 1);
INSERT INTO `video` VALUES (18, '【艾叔】陆家嘴8000万，中国企业家的豪宅长什么样', 'images/video_images/【艾叔】陆家嘴8000万，中国企业家的豪宅长什么样.png', 'https://www.bilibili.com/video/BV1i7411e7hP', '//player.bilibili.com/player.html?aid=84599855&bvid=BV1i7411e7hP&cid=144710530&page=1', '037', 1);
INSERT INTO `video` VALUES (19, '【★⑥檤轮囬★】和美少女一起开车会发生什么？', 'images/video_images/【★⑥檤轮囬★】和美少女一起开车会发生什么？.png', 'https://www.bilibili.com/video/BV14K411J7Xc', '//player.bilibili.com/player.html?aid=498947412&bvid=BV14K411J7Xc&cid=215285841&page=1', '05', 0);
INSERT INTO `video` VALUES (20, '【漠☆漠】最羞耻的挑战！！我漠漠要走出自闭', 'images/video_images/【漠☆漠】最羞耻的挑战！！我漠漠要走出自闭.png', 'https://www.bilibili.com/video/BV1z4411M79a', '//player.bilibili.com/player.html?aid=54669764&bvid=BV1z4411M79a&cid=95629524&page=1', '05', 0);
INSERT INTO `video` VALUES (21, '【泡芙喵-PuFF】企 业 文 化', 'images/video_images/【泡芙喵-PuFF】企 业 文 化.png', 'https://www.bilibili.com/video/BV1QK411H7io', '//player.bilibili.com/player.html?aid=498338062&bvid=BV1QK411H7io&cid=193917699&page=1', '05', 1);
INSERT INTO `video` VALUES (22, '【TESTV官方频道】别买iPhone SE2 ？', 'images/video_images/【TESTV官方频道】别买iPhone SE2 ？.png', 'https://www.bilibili.com/video/BV1bK411W7Fd', '//player.bilibili.com/player.html?aid=498163141&bvid=BV1bK411W7Fd&cid=191050604&page=1', '01', 0);
INSERT INTO `video` VALUES (23, '【吃土数码汪】2019年B站UP主最喜欢的数码产品是什么？', 'images/video_images/【吃土数码汪】2019年B站UP主最喜欢的数码产品是什么？.png', 'https://www.bilibili.com/video/BV16J41157es', '//player.bilibili.com/player.html?aid=82570165&bvid=BV16J41157es&cid=141275580&page=1', '01', 0);
INSERT INTO `video` VALUES (24, '【二喵的饭】震惊！某女子花20万买了100万活粉丝！采访她的经历竟然是这样…', 'images/video_images/【二喵的饭】震惊！某女子花20万买了100万活粉丝！采访她的经历竟然是这样….png', 'https://www.bilibili.com/video/BV1JJ411j7bf', '//player.bilibili.com/player.html?aid=81846070&bvid=BV1JJ411j7bf&cid=140039436&page=1', '08', 0);
INSERT INTO `video` VALUES (25, '【何同学】脆弱的美好 折叠屏手机深度体验', 'images/video_images/【何同学】脆弱的美好 折叠屏手机深度体验.png', 'https://www.bilibili.com/video/BV1aJ411C7tb', '//player.bilibili.com/player.html?aid=79091085&bvid=BV1aJ411C7tb&cid=135354072&page=1', '014', 0);
INSERT INTO `video` VALUES (26, '【何同学】我就扫个码 更好的手机相机有什么意义？ 苹果iPhone 11系列深度体验', 'images/video_images/【何同学】我就扫个码 更好的手机相机有什么意义？ 苹果iPhone 11系列深度体验.png', 'https://www.bilibili.com/video/BV1mE41187WT', '//player.bilibili.com/player.html?aid=74166406&bvid=BV1mE41187WT&cid=126876528&page=1', '014', 0);
INSERT INTO `video` VALUES (27, '【友曰日谈】我到“地狱”里走了一遭：13岁以下不得入内，人类文明的污点', 'images/video_images/【友曰日谈】我到“地狱”里走了一遭：13岁以下不得入内，人类文明的污点.png', 'https://www.bilibili.com/video/BV12E411o71N', '//player.bilibili.com/player.html?aid=70848722&bvid=BV12E411o71N&cid=122745746&page=1', '023', 0);
INSERT INTO `video` VALUES (28, '【LKs】B站牌面UP探访中国驻欧盟使团丨中国影响力发现之旅丨比利时+荷兰超长旅拍', 'images/video_images/【LKs】B站牌面UP探访中国驻欧盟使团丨中国影响力发现之旅丨比利时+荷兰超长旅拍.png', 'https://www.bilibili.com/video/BV1ZE411S7nj', '//player.bilibili.com/player.html?aid=70081731&bvid=BV1ZE411S7nj&cid=121569103&page=1', '023', 0);
INSERT INTO `video` VALUES (29, '【何同学】有多快？5G在日常使用中的真实体验', 'images/video_images/【何同学】有多快？5G在日常使用中的真实体验.png', 'https://www.bilibili.com/video/BV1f4411M7QC', '//player.bilibili.com/player.html?aid=54737593&bvid=BV1f4411M7QC&cid=95749546&page=1', '047', 0);
INSERT INTO `video` VALUES (30, '【LKs】良心到难以置信的网站推荐第5期丨超长注意', 'images/video_images/【LKs】良心到难以置信的网站推荐第5期丨超长注意.png', 'https://www.bilibili.com/video/BV1a741137NS', '//player.bilibili.com/player.html?aid=88646573&bvid=BV1a741137NS&cid=153840196&page=1', '047', 0);
INSERT INTO `video` VALUES (31, '【敬汉卿】把最新科技人造蛋买来与国产素蛋对比！究竟哪一个更像蛋？', 'images/video_images/【敬汉卿】把最新科技人造蛋买来与国产素蛋对比！究竟哪一个更像蛋？.png', 'https://www.bilibili.com/video/BV1DJ41187qn?from=search&seid=8560191485059083732', '//player.bilibili.com/player.html?aid=81305347&bvid=BV1DJ41187qn&cid=139149889&page=1', '0458', 0);
INSERT INTO `video` VALUES (32, '【波桑吃遍世界】小伙因沉迷动漫，独自探寻《千与千寻》原场景 结果....', 'images/video_images/【波桑吃遍世界】小伙因沉迷动漫，独自探寻《千与千寻》原场景 结果.....png', 'https://www.bilibili.com/video/BV1KE411r7aY', '//player.bilibili.com/player.html?aid=72023173&bvid=BV1KE411r7aY&cid=124795736&page=1', '0235', 0);
INSERT INTO `video` VALUES (33, '【吉原悠一_yui】危险发言！有人说我长得像大力、党妹还有 LexBurner...', 'images/video_images/【吉原悠一_yui】危险发言！有人说我长得像大力、党妹还有 LexBurner....png', 'https://www.bilibili.com/video/BV1S54y1R7ub', '//player.bilibili.com/player.html?aid=840028597&bvid=BV1S54y1R7ub&cid=176431133&page=1', '05', 0);
INSERT INTO `video` VALUES (34, '【吉原悠一_yui】刺激！挑战偷亲女up主，却被说“你好骚啊！”我都不好意思了！', 'images/video_images/【吉原悠一_yui】刺激！挑战偷亲女up主，却被说“你好骚啊！”我都不好意思了！.png', 'https://www.bilibili.com/video/BV1rJ411j7a4', '//player.bilibili.com/player.html?aid=81913003&bvid=BV1rJ411j7a4&cid=140254804&page=1', '05', 0);
INSERT INTO `video` VALUES (35, '【吃素的狮子】得 罪 人 挑 战', 'images/video_images/【吃素的狮子】得 罪 人 挑 战.png', 'https://www.bilibili.com/video/BV1Uk4y1B7uT', '//player.bilibili.com/player.html?aid=753427134&bvid=BV1Uk4y1B7uT&cid=201230829&page=1', '05', 0);
INSERT INTO `video` VALUES (36, '【美食博主黄艾伦】90块钱的汉堡，一口下去满嘴满手都是肉汁，完全顶不住！', 'images/video_images/【美食博主黄艾伦】90块钱的汉堡，一口下去满嘴满手都是肉汁，完全顶不住！.png', 'https://www.bilibili.com/video/BV1Nx411f7jk', '//player.bilibili.com/player.html?aid=58571566&bvid=BV1Nx411f7jk&cid=102146602&page=1', '08', 0);
INSERT INTO `video` VALUES (37, '【孤独的美食基】15000日元一位的日本烤肉，就因为这道菜排队排到爆？男子试吃完后说…', 'images/video_images/【孤独的美食基】15000日元一位的日本烤肉，就因为这道菜排队排到爆？男子试吃完后说….png', 'https://www.bilibili.com/video/BV11V411z7Ry', '//player.bilibili.com/player.html?aid=414130118&bvid=BV11V411z7Ry&cid=221796440&page=1', '08', 0);
INSERT INTO `video` VALUES (38, '【蔡成的菜】一刀切开10000元和牛是什么样的体验？', 'images/video_images/【蔡成的菜】一刀切开10000元和牛是什么样的体验？.png', 'https://www.bilibili.com/video/BV1v64y1T7Rg', '//player.bilibili.com/player.html?aid=582790759&bvid=BV1v64y1T7Rg&cid=181353910&page=1', '08', 0);
INSERT INTO `video` VALUES (39, '【假美食po主】英国的 速食北京烤鸭 BBQ鸡腿 牧羊人派 芝士派 以及我吃过最好吃的瑞士卷', 'images/video_images/【假美食po主】英国的 速食北京烤鸭 BBQ鸡腿 牧羊人派 芝士派 以及我吃过最好吃的瑞士卷.png', 'https://www.bilibili.com/video/BV1Vf4y1R7bo', '//player.bilibili.com/player.html?aid=286305088&bvid=BV1Vf4y1R7bo&cid=211619077&page=1', '08', 0);
INSERT INTO `video` VALUES (40, '【CY】女主角育成计划  4周年生日作  HoneyWorks', 'images/video_images/【CY】女主角育成计划  4周年生日作  HoneyWorks.png', 'https://www.bilibili.com/video/BV1q7411Z7ew', '//player.bilibili.com/player.html?aid=96959623&bvid=BV1q7411Z7ew&cid=165527467&page=1', '06', 0);
INSERT INTO `video` VALUES (41, '【防盗少女团】过年了！！！！！！！！', 'images/video_images/【防盗少女团】过年了！！！！！！！！.png', 'https://www.bilibili.com/video/BV197411a7NK', '//player.bilibili.com/player.html?aid=84787899&bvid=BV197411a7NK&cid=145053387&page=1', '06', 0);
INSERT INTO `video` VALUES (42, '【尾狐】SOLO 万丈高空独舞 惊险又迷人', 'images/video_images/【尾狐】SOLO 万丈高空独舞 惊险又迷人.png', 'https://www.bilibili.com/video/BV174411w7VT', '//player.bilibili.com/player.html?aid=58183574&bvid=BV174411w7VT&cid=101505927&page=1', '06', 0);
INSERT INTO `video` VALUES (43, '【伢伢gagako】今天我终于告白了！', '//i0.hdslb.com/bfs/archive/6c73c69e0aab2b57a2fbbdf46ff358df286fc424.jpg@200w_125h_1c.webp', 'https://www.bilibili.com/video/BV1oi4y1u71z', '//player.bilibili.com/player.html?aid=541685769&bvid=BV1oi4y1u71z&cid=221565728&page=1', '06', 0);
INSERT INTO `video` VALUES (44, '【王师傅】这饭店人均1000只能纯吃素？到底能吃些什么？上海素食店福和慧', '//i1.hdslb.com/bfs/archive/3b65797a2616bdc60ac24ebb92a5298e15d8c0ab.jpg@200w_125h_1c.webp', 'https://www.bilibili.com/video/BV1pa4y177A5?t=744', '//player.bilibili.com/player.html?aid=669309463&bvid=BV1pa4y177A5&cid=228038133&page=1', '08', 0);

SET FOREIGN_KEY_CHECKS = 1;
