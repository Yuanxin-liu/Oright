/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : oright

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2021-03-18 17:28:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('3', '12', '12', '123@qq.com', '12345678900');
INSERT INTO `author` VALUES ('4', '123', '123', '123@qq.com', '13511986875');
INSERT INTO `author` VALUES ('5', 'clara', 'clara', 'claranix@shu.edu.cn', '18785083168');
INSERT INTO `author` VALUES ('6', 'nix', 'nix', '123456@qq.com', '18536487521');
INSERT INTO `author` VALUES ('7', '任豪', '123', '14526857@qq.com', '18545657588');
INSERT INTO `author` VALUES ('8', '有远见的尾巴', '123', '18616134018@163.com', '18616134018');
INSERT INTO `author` VALUES ('9', 'test', '123', '1354@163.com', '18790010000');
INSERT INTO `author` VALUES ('10', '111', '111', '111@163.com', '18785083168');
INSERT INTO `author` VALUES ('11', '12345', '12345', '125@163.com', '18275373598');

-- ----------------------------
-- Table structure for concern
-- ----------------------------
DROP TABLE IF EXISTS `concern`;
CREATE TABLE `concern` (
  `cid` int NOT NULL,
  `fans_id` int DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `fans` (`fans_id`),
  KEY `author` (`author_id`),
  CONSTRAINT `concern_ibfk_1` FOREIGN KEY (`fans_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `concern_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of concern
-- ----------------------------
INSERT INTO `concern` VALUES ('1', '5', '6');
INSERT INTO `concern` VALUES ('4', '3', '4');
INSERT INTO `concern` VALUES ('5', '5', '4');
INSERT INTO `concern` VALUES ('6', '4', '3');
INSERT INTO `concern` VALUES ('7', '6', '4');
INSERT INTO `concern` VALUES ('8', '8', '4');
INSERT INTO `concern` VALUES ('9', '8', '6');
INSERT INTO `concern` VALUES ('10', '8', '3');
INSERT INTO `concern` VALUES ('11', '9', '4');
INSERT INTO `concern` VALUES ('12', '4', '4');
INSERT INTO `concern` VALUES ('13', '4', '6');
INSERT INTO `concern` VALUES ('14', '11', '4');

-- ----------------------------
-- Table structure for concern2
-- ----------------------------
DROP TABLE IF EXISTS `concern2`;
CREATE TABLE `concern2` (
  `cid` int NOT NULL,
  `fans_id` int DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `fans_id` (`fans_id`),
  KEY `author_id` (`author_id`),
  CONSTRAINT `concern2_ibfk_1` FOREIGN KEY (`fans_id`) REFERENCES `firm` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `concern2_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of concern2
-- ----------------------------
INSERT INTO `concern2` VALUES ('2', '2', '5');
INSERT INTO `concern2` VALUES ('3', '2', '6');
INSERT INTO `concern2` VALUES ('4', '2', '3');
INSERT INTO `concern2` VALUES ('5', '2', '4');

-- ----------------------------
-- Table structure for favourite
-- ----------------------------
DROP TABLE IF EXISTS `favourite`;
CREATE TABLE `favourite` (
  `fid` int NOT NULL,
  `aid` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `aid` (`aid`),
  KEY `pid` (`pid`),
  CONSTRAINT `favourite_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favourite_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `passage` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of favourite
-- ----------------------------
INSERT INTO `favourite` VALUES ('1', '6', '5');
INSERT INTO `favourite` VALUES ('2', '6', '4');
INSERT INTO `favourite` VALUES ('5', '4', '5');

-- ----------------------------
-- Table structure for favourite2
-- ----------------------------
DROP TABLE IF EXISTS `favourite2`;
CREATE TABLE `favourite2` (
  `fid` int NOT NULL,
  `firm_id` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`fid`),
  KEY `firm_id` (`firm_id`),
  KEY `pid` (`pid`),
  CONSTRAINT `favourite2_ibfk_1` FOREIGN KEY (`firm_id`) REFERENCES `firm` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favourite2_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `passage` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of favourite2
-- ----------------------------
INSERT INTO `favourite2` VALUES ('1', '2', '6');
INSERT INTO `favourite2` VALUES ('2', '2', '7');

-- ----------------------------
-- Table structure for firm
-- ----------------------------
DROP TABLE IF EXISTS `firm`;
CREATE TABLE `firm` (
  `id` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of firm
-- ----------------------------
INSERT INTO `firm` VALUES ('2', '考研君', '123', '18875456524', 'kaoyan@shu.edu.cn');

-- ----------------------------
-- Table structure for passage
-- ----------------------------
DROP TABLE IF EXISTS `passage`;
CREATE TABLE `passage` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `aid` int NOT NULL,
  `content` varchar(10000) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `aid` (`aid`),
  CONSTRAINT `passage_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `author` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of passage
-- ----------------------------
INSERT INTO `passage` VALUES ('4', '4', '<p><span style=\"color: rgb(0, 0, 0);\">王荆公介甫，退居金陵。一天，他头裹一块绢，拄着手杖行走，独自游览山寺，遇见几个人在那里高谈阔论文史，议论纷纷。王安石坐在他们旁边，没人注意到他。有一个客人慢慢问他说：“你也懂得文书?”王安石含糊地应答。人家再问他姓名，王安石拱拱手回答说：“我姓王，叫安石。”那群人惶恐，惭愧的低着头离开。</span></p>', '王荆公旁听文史', '2021-03-09 20:13:22', '短篇', '生活学习');
INSERT INTO `passage` VALUES ('5', '3', '<p class=\"ql-align-justify\"><strong>我看见这活鲜鲜的早晨，就像看见了你最初的柔情和柔情之下的笑颜，伴着绿色的风漫过我虔诚的视线。</strong></p><p class=\"ql-align-justify\"><strong>婆娑的树林在朝阳的诱惑下摇曳。</strong></p><p class=\"ql-align-justify\"><strong>我看见这活鲜鲜的早晨，就像看见了鸽子，看见了草坪。看见了你深情的含笑花般张开的盈盈脸庞和瀑布般沿肩倾泻的秀发……</strong></p><p><br></p>', '晨曦', '2021-03-09 20:18:03', '随笔', '生活学习');
INSERT INTO `passage` VALUES ('6', '6', '<p>	<span class=\"ql-size-large\">习近平总书记强调，今年我们将开始实施“十四五”规划，开启全面建设社会主义现代化国家新征程，向第二个百年奋斗目标迈进，我们要继续齐心协力干、加油好好干，努力干成一番新事业，干出一片新天地</span></p><p><span class=\"ql-size-large\">	“十四五”时期是我国全面建成小康社会、实现第一个百年奋斗目标之后，乘势而上开启全面建设社会主义现代化国家新征程、向第二个百年奋斗目标进军的第一个五年。代表委员聚焦“十四五”规划纲要制定和实施，表示要始终坚持以人民为中心的发展思想，完整准确全面贯彻新发展理念，乘势而上、再接再厉、接续奋斗，确保“十四五”时期我国发展的目标任务落到实处。</span></p><p><span class=\"ql-size-large\">	坚持以人民为中心的发展思想</span></p><p><span class=\"ql-size-large\">	“一项项关乎人民健康的惠民政策陆续出台，体现了人民至上、生命至上。”湖南省郴州市第一人民医院急诊科主任徐自强委员介绍，他所在的医院致力于提升接诊效率，减少非医疗环节，初步实现抢救环节高效衔接，挽救了许多宝贵生命。奋进“十四五”，要办好民生事业，进一步提高基层医疗卫生水平，建立健全医疗保障制度，让人民群众享有公平可及、系统连续的健康服务。</span></p><p><span class=\"ql-size-large\">	“用心用情用力解决好群众‘急难愁盼’问题，让他们有实实在在的获得感。”重庆市荣昌区委书记曹清尧代表说，“十三五”期间，荣昌区着力改善民生福祉，提高人民生活品质，全区8806户建档立卡贫困户全部脱贫，153个村(社区)全部通硬化公路，20万条农户水泥便民道通到每家院坝，家庭医生签约全覆盖，群众的获得感幸福感安全感与日俱增。落实“十四五”目标任务，要始终以百姓心为心，让发展成果更多更公平惠及全体人民。</span></p><p><span class=\"ql-size-large\">	“积极参与全面推进乡村振兴的时代任务，助力广大农民共享数字经济发展红利。”腾讯公司董事会主席、首席执行官马化腾代表表示，近年来，公司不断探索通过数字科技和互联网公益参与扶贫，为乡村打造低门槛、易操作的村庄数字化开放平台，助力农村地区疫情防控、春耕备耕等情况的精准分析。下一步将聚焦农民所需，加强新型农业技能培训，夯实乡村振兴的人才基础，为实现“十四五”宏伟蓝图添砖加瓦。</span></p><p><span class=\"ql-size-large\">	完整准确全面贯彻新发展理念</span></p><p><span class=\"ql-size-large\">	“新发展理念是发展的指挥棒，必须贯彻到经济社会发展全过程和各领域。”山东省泰安市委书记崔洪刚代表表示，近年来在全市范围内开展勇做新时代泰山“挑山工”主题实践活动，激励广大党员干部像挑山工一样，挑担不畏难、登山不畏险、重压不歇肩，在改革攻坚中打头阵、高质量发展上当先锋、为民服务上作表率，奋力推进创新发展、协调发展、绿色发展、开放发展、共享发展，确保“十四五”开好局起好步。</span></p><p><span class=\"ql-size-large\">	“全面建成小康社会不是终点，乡亲的日子要一天比一天红火。”河南省辉县市裴寨社区党总支书记裴春亮代表表示，社区近年来通过免费提供厂房和基础设施、减免水电费等措施，引进服装企业，让周边群众挣钱顾家两不误、全面小康有基础。“十四五”时期，裴寨社区要从根本宗旨把握新发展理念，更加注重共同富裕问题，满足乡亲日益增长的美好生活需要。</span></p><p><span class=\"ql-size-large\">	“贯彻新发展理念，共绘‘十四五’蓝图，要坚持系统观念，坚持问题导向。”海尔集团公司董事局副主席周云杰代表表示，工业互联网被视为“互联网下半场”，作为全球工业门类最齐全的国家，我国的工业互联网起步早、起点高，为经济发展注入了新动能。下一个五年，要立足国内，放眼世界，围绕增强创新能力等重点领域和关键环节，继续把改革推向深入，实现工业互联网与消费互联网的有机融合，推动高质量发展。</span></p><p><span class=\"ql-size-large\">	实干兴邦实干惠民 奋力实现目标任务</span></p><p><span class=\"ql-size-large\">	“只要是对群众有益的事情，就必须埋头苦干，干实干好。”广东省鹤山市古劳镇下六村党总支书记温艳嫦代表表示，过去一年，下六村努力做好巩固拓展脱贫攻坚成果同乡村振兴有效衔接各项工作，疏河道、治洪涝，多措并举推进平安乡村建设;筹资上百万元，拓宽乡村道路，便利村民出行，提升村容村貌，获得群众认可。建议继续深入推进农村改革，完善盘活农村存量建设用地相关政策和操作细则，助力乡村振兴。</span></p><p><span class=\"ql-size-large\">	“让更多科技创新成果从‘书架’走向‘货架’，赋能经济社会发展。”民建北京市委主委、北京市科协常务副主席司马红委员介绍，市科协充分发挥组织优势，团结引领广大科技工作者锐意进取、真抓实干，力争把更多科技创新成果转化为经济发展动力，以高质量科技供给服务高质量发展，为“十四五”开好局起好步提供有力支撑。建议通过改革的方式更好激发科技创新活力，优化科研环境，推动科研成果质量实现跃升。</span></p><p><span class=\"ql-size-large\">	“征途漫漫，惟有奋斗。坚持苦干实干，才能做好民生这篇大文章。”西藏自治区那曲市委书记敖刘全委员表示，去年那曲市农村居民和城镇居民人均可支配收入实现两位数增长，县县通柏油路、大电网，安全饮水全覆盖，民生事业和公共服务逐渐从“有没有”向“好不好”转变。接下来将继续保持真抓实干的奋斗韧劲，坚持产业引领，加快推动太阳能、风能等清洁能源建设，带动旅游业和畜牧业发展，把资源优势转化为经济优势、发展优势。<span class=\"ql-cursor\">﻿</span></span></p>', '干成一番新事业 干出一番新天地', '2021-03-09 20:23:15', '短篇', '政治新闻');
INSERT INTO `passage` VALUES ('7', '8', '<p><span style=\"color: rgb(0, 0, 0);\">       这是一首借古论今之作。多景楼，在镇江北固山上甘露寺内，北临长江。这首词的写作背景是孝宗淳熙十五年（1188）春天，陈亮到建康和镇江考察形势，准备向朝廷</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/3514.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">陈述</a><span style=\"color: rgb(0, 0, 0);\">北伐的策略 。词的内容以议论形势、陈述政见为主，正是与此行目的息息相通的。</span></p><p><span style=\"color: rgb(0, 0, 0);\">开头两句，凌空而起。撇开登临感怀之作先写望中景物的俗套，大笔挥洒，直抒胸臆：登楼极目四望，不觉百感交集，可叹自己的这番心意，古往今来，又有几人能够理解呢？因为所感不止一端，先将“此意”虚提，总摄下文。南宋乾道年间镇江知府</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/5496.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">陈天麟</a><span style=\"color: rgb(0, 0, 0);\">《多景楼记 》说 ：“至天清日明，一目万里，神州赤县，未归舆地，使人慨然有恢复意 。”对于以经济之略自负的词人来说 ，“恢复意”正是这首词所要表达的主题思想，围绕这个主题思想的还有对南北形势及整个抗金局势的看法。以下抒写作者认为“今古几人</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/10376.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">曾会</a><span style=\"color: rgb(0, 0, 0);\">”的登临意。“今古”一语，暗示了本篇是借古论今。</span></p><p><span style=\"color: rgb(0, 0, 0);\">接下来两句，从江山形势的奇险引出对“天限南疆北界”主张的抨击。“鬼设神施”，是形容镇江一带的山川形势极其险要，简直是鬼斧神工，非人力所能致。然而这样险要的江山却不被当作进取的凭藉，而是都看成了天设的南疆北界。当时南宋统治者不思进取，苟且偷安，将长江作为拒守金人南犯的天限，作者所抨击的，正是这种藉天险以求苟安的主张 。“浑认作”三字，亦讽亦慨，笔端带有强烈感情。</span></p><p><span style=\"color: rgb(0, 0, 0);\">        “一水横陈，连岗三面，做出争雄势 。”镇江北面横贯着波涛汹涌的长江，东、西、南三面都连接着起伏的山岗。这样的地理形势，正是进可以攻，退可以守，足以与北方强敌争雄的形胜之地 。“做出”一语，表达了词人目击山川形势时兴会淋漓的感受。在词人眼中 ，山川仿佛有了灵气和生命，活动起来了。</span></p><p><span style=\"color: rgb(0, 0, 0);\">他在《戊申再上孝宗皇帝书》中写道 ：“京口连岗三面，而大江横陈，江旁极目千里，其势大略如虎之出穴，而非若穴之藏虎也。”所谓“虎之出穴”，也正是“做出争雄势”的一种形象化说明。这里对镇江山川形势的描绘，本身便是对“天限南疆北界”这种苟安论调的否定 。在作者看来，山川形势足以北向争雄，问题在于统治者缺乏争雄的远大抱负与勇气 。因此，下面紧接着就借批判六朝统治者，来揭示现实中当权者苟安论调的思想实质：“六朝何事，只成门户私计？”</span></p><p><span style=\"color: rgb(0, 0, 0);\">前一句是愤慨的斥责与质问，后一句则是对统治者划江自守的苟安政策的揭露批判，——原来这一切全不过是为少数私家大族的狭隘利益打算！词锋犀利，入木三分。</span></p><p><span style=\"color: rgb(0, 0, 0);\">换头“因笑”二字，承上片结尾对六朝统治者的批判，顺势而下，使上下片成为浑然一体。前三句用新亭对泣故事 ，“王谢诸人”概括东晋世家大族的上层人物，说他们空洒英雄之泪，却无克服神州的实际行动，借以讽刺南宋上层统治集团中有些人空有慷慨激昂的言辞，而无北伐的行动。“也学英雄涕”，讽刺尖刻辛辣，鞭辟入里。</span></p><p><span style=\"color: rgb(0, 0, 0);\">“凭却长江，管不到、河洛腥膻无际 。”他们依仗着长江天险，自以为可以长保偏安，哪里管得到广大的中原地区，长久为异族势力所盘踞，广大人民呻吟辗转于铁蹄之下呢？这是对统治者“只成门户私计”的进一步批判 。“管不到”三字，可谓诛心之笔。到这里，由江山形势引出的对当权者的揭露批判已达极致，下面转面承上“争雄”，进一步正面发挥登临意。“正好长驱，不须反顾，寻取中流誓。”中流誓，用祖逖统兵北伐，渡江击楫而誓的故实。在词人看来，凭借这样有利的江山形势，正可长驱北伐，无须前怕狼，后怕虎，应该象当年的祖逖那样，中流击水，收复中原。这几句词情由前面的愤郁转向豪放，意气风发，辞采飞扬，充分显示出词人豪迈朗爽的胸襟气度。</span></p><p><span style=\"color: rgb(0, 0, 0);\">        歇拍二句 ，承上“长驱”，进一步抒写必胜的乐观信念。“小儿破贼”见《世说新语·雅量》。淝水之战，</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/9628.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">谢安之</a><span style=\"color: rgb(0, 0, 0);\">侄谢玄等击败苻坚大军，捷报送达，谢安方与客围棋，看书毕，缄默无语，依旧对局。客问淮上利害，答曰：“小儿辈大破贼。”“强对”，强大的对手 ，即强敌 。《三国志·陆逊传》：“刘备天下知名，</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/39.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">曹操</a><span style=\"color: rgb(0, 0, 0);\">所惮，今在境界，此强对也 。”作者认为，南方并不乏运筹帷幄、决胜千里的统帅，也不乏披坚执锐、冲锋陷阵的猛将，完全应该象往日的谢安一样，对打败北方强敌具有充分信心，一旦有利之形势已成，便当长驱千里，扫清河洛，收复国土，何须顾虑对方的强大呢 ？作者《上孝宗皇帝第一书》中曾言：“常以江淮之师为虏人侵轶之备 ，而精择一人之沈鸷有谋、开豁无他者，委以荆襄之任 ，宽其文法，听其废置，抚摩振厉于三数年之间 ，则国家之势成矣。”词中之“势成”亦同此意。作者的主</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/10642.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">张在</a><span style=\"color: rgb(0, 0, 0);\">当时能否实现，可以置而不论，但这几句豪言壮语，是可以“起顽立懦”的。到这里，一开头提出的“今古几人曾会”的“此意”已经尽情发挥，全词也就在破竹之势中收笔。</span></p><p><span style=\"color: rgb(0, 0, 0);\">同样是登临抒慨之作，陈亮的这首《念奴娇·登多景楼》和他的挚友</span><a href=\"https://www.shicimingju.com/chaxun/zuozhe/44.html\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(195, 153, 102);\">辛弃疾</a><span style=\"color: rgb(0, 0, 0);\">的《水龙吟·登建康赏心亭》便显出不同的艺术风格。辛词也深慨于“无人会登临意”，但通篇于豪迈雄放之中深寓沉郁盘结之情，读来别具一种回肠荡气、抑塞低回之感；而陈词则纵论时弊，痛快淋漓，充分显示其词人兼政论家的性格。从艺术的含蕴、情味的深厚来说，陈词自然不如辛词，但这种大气磅礴、开拓万古心胸的强音，是足以催人奋进的。</span></p>', '念奴娇赏析', '2021-03-09 21:05:08', '随笔', '生活学习');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', '12', '12', 'a');
INSERT INTO `user` VALUES ('6', '123', '123', 'a');
INSERT INTO `user` VALUES ('7', 'clara', 'clara', 'a');
INSERT INTO `user` VALUES ('8', 'nix', 'nix', 'a');
INSERT INTO `user` VALUES ('9', '任豪', '123', 'a');
INSERT INTO `user` VALUES ('12', '考研君', '123', 'f');
INSERT INTO `user` VALUES ('13', '有远见的尾巴', '123', 'a');
INSERT INTO `user` VALUES ('14', 'test', '123', 'a');
INSERT INTO `user` VALUES ('15', '111', '111', 'a');
INSERT INTO `user` VALUES ('16', '12345', '12345', 'a');
DROP TRIGGER IF EXISTS `addUserA`;
DELIMITER ;;
CREATE TRIGGER `addUserA` BEFORE INSERT ON `author` FOR EACH ROW insert into user(username,password,role) values(new.username,new.password,"a")
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `addUserF`;
DELIMITER ;;
CREATE TRIGGER `addUserF` BEFORE INSERT ON `firm` FOR EACH ROW insert into user(username,password,role) values(new.username,new.password,"f")
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `deleteUserF`;
DELIMITER ;;
CREATE TRIGGER `deleteUserF` BEFORE DELETE ON `firm` FOR EACH ROW delete from user where username=old.username
;;
DELIMITER ;
