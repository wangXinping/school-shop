/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : lex

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 13/11/2023 19:55:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buy_goods
-- ----------------------------
DROP TABLE IF EXISTS `buy_goods`;
CREATE TABLE `buy_goods`  (
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品编号',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `goos_photoId` int(11) NULL DEFAULT NULL COMMENT '外键，商品图片编号',
  `category_id` int(11) NOT NULL COMMENT '外键，商品类型编号',
  ` present` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品介绍',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`goods_id`) USING BTREE,
  UNIQUE INDEX `goods_id`(`goods_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods_images
-- ----------------------------
DROP TABLE IF EXISTS `goods_images`;
CREATE TABLE `goods_images`  (
  `images_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `images_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外键 商品id',
  PRIMARY KEY (`images_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `goods_images_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `sell_goods` (`goods_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_images
-- ----------------------------
INSERT INTO `goods_images` VALUES (100, '2865c025-5e81-469e-aa5a-ad012e096b15.jpg', 'g11111111135');
INSERT INTO `goods_images` VALUES (101, '1b58c32b-eec5-4985-bc12-517fd8b630c4.jpg', 'g11111111149');
INSERT INTO `goods_images` VALUES (102, '53c618e7-45fa-418e-aeca-f53e557a5ac0.jpg', 'g11111111141');
INSERT INTO `goods_images` VALUES (103, 'cfc3564d-0377-46b8-9bb2-be3c5788f347.jpg', 'g11111111125');
INSERT INTO `goods_images` VALUES (104, 'd3f8cd55-f336-4a27-936e-f0ec2bcf8d9c.jpg', 'g11111111124');
INSERT INTO `goods_images` VALUES (105, 'd4712760-464f-44fe-997c-71dd1a6e69c2.jpg', 'g11111111121');
INSERT INTO `goods_images` VALUES (106, 'da7a366a-375d-4c0b-af0f-14c899b0dae2.jpg', 'g11111111120');
INSERT INTO `goods_images` VALUES (107, '536a570d-855e-499c-b86d-e43965e07879.jpg', 'g11111111137');
INSERT INTO `goods_images` VALUES (108, 'e4d4856a-60be-43be-9631-7f442a6df1db.jpg', 'g11111111113');
INSERT INTO `goods_images` VALUES (109, 'a4bc8dd8-64e3-44a3-a0f2-a8f6148c7c53.jpg', 'g11111111130');
INSERT INTO `goods_images` VALUES (110, 'fae366d9-ddfb-4a63-a538-45846e9d3372.jpg', 'g11111111118');
INSERT INTO `goods_images` VALUES (111, '4a434406-8390-49db-9f40-f6922f053d32.jpg', 'g11111111151');
INSERT INTO `goods_images` VALUES (112, 'dc8a7696-2e57-4793-add4-981672954514.jpg', 'g11111111115');
INSERT INTO `goods_images` VALUES (113, 'df5cb985-77c0-4d73-9cf1-25f3b672eb99.jpg', 'g11111111115');
INSERT INTO `goods_images` VALUES (114, 'e3a44a96-3fc2-4ae5-930b-c6dd01b1b765.jpg', 'g11111111114');
INSERT INTO `goods_images` VALUES (115, 'fa58af52-f08d-4b94-86bc-82c12b3ba750.jpg', 'g11111111119');
INSERT INTO `goods_images` VALUES (116, '9ab5e14d-8431-4cbb-98a8-dbb2e09a1292.jpg', 'g11111111147');
INSERT INTO `goods_images` VALUES (117, '429736c7-750c-41a5-b41d-cadc6cce71aa.jpg', 'g11111111133');
INSERT INTO `goods_images` VALUES (118, '611a28ab-44cd-48df-a1f7-6653d470492d.jpg', 'g11111111136');
INSERT INTO `goods_images` VALUES (119, 'd11b163d-370d-45b1-ab3f-8b4939301a0d.jpg', 'g11111111122');
INSERT INTO `goods_images` VALUES (120, 'e836761d-059d-4e6c-88ad-0e125d66a0f3.jpg', 'g11111111112');
INSERT INTO `goods_images` VALUES (121, 'ad200250-3cb9-483a-a074-83014e748c62.jpg', 'g11111111128');
INSERT INTO `goods_images` VALUES (122, '23df2bfd-2d06-4023-8114-517bcfdd7a91.jpg', 'g11111111145');
INSERT INTO `goods_images` VALUES (123, 'b413abcc-6030-4761-a40b-715a7d3a25b7.jpg', 'g11111111126');
INSERT INTO `goods_images` VALUES (124, '213a1b73-97d6-498a-b399-27c928b5ae88.jpg', 'g11111111138');
INSERT INTO `goods_images` VALUES (125, '3fbd919e-40b1-43df-951f-25b51af56588.jpg', 'g11111111150');
INSERT INTO `goods_images` VALUES (126, '37e5cb90-58ec-426e-9dc3-27b197404e2a.jpg', 'g11111111144');
INSERT INTO `goods_images` VALUES (127, '6315422f-a384-41a6-b822-a8b2e3334128.jpg', 'g11111111132');
INSERT INTO `goods_images` VALUES (128, '46f06cb0-c693-4889-bee3-0f4ff50c088d.jpg', 'g11111111142');
INSERT INTO `goods_images` VALUES (129, '8c3be17f-fd73-4737-ad71-6995e727bd42.jpg', 'g11111111148');
INSERT INTO `goods_images` VALUES (130, '9525c75c-bdce-403f-a75c-a44b53773d92.jpg', 'g11111111134');
INSERT INTO `goods_images` VALUES (131, 'a67373f2-3dc5-472f-906f-ba5735998706.jpg', 'g11111111154');
INSERT INTO `goods_images` VALUES (132, '54affd06-7d25-469d-881e-b51b18ff69b9.jpg', 'g11111111140');
INSERT INTO `goods_images` VALUES (133, '129ee1c6-49c1-4c11-9720-ef7702c84bfe.jpg', 'g11111111139');
INSERT INTO `goods_images` VALUES (134, '5adf35ad-2f60-4cec-8d5d-c3c9cb8b48f3.jpg', 'g11111111152');
INSERT INTO `goods_images` VALUES (135, 'a1edee7f-f133-4bad-baf7-02ddbf1e4c04.jpg', 'g11111111131');
INSERT INTO `goods_images` VALUES (136, 'adfb1ff1-5536-4335-aee3-dea40555b216.jpg', 'g11111111127');
INSERT INTO `goods_images` VALUES (137, 'a4ea546d-fb46-43a8-b972-c2934b86b4b4.jpg', 'g11111111129');
INSERT INTO `goods_images` VALUES (138, 'd7d76f15-d0a2-409d-8519-1089376d4d29.jpg', 'g11111111123');
INSERT INTO `goods_images` VALUES (139, 'ffb8f7b5-0733-4f03-886e-f7ef45065546.jpg', 'g11111111117');
INSERT INTO `goods_images` VALUES (140, '0041dcc4-2747-4acb-b6c5-82fb0169ae2b.jpg', 'g11111111143');
INSERT INTO `goods_images` VALUES (141, 'de99b83c-2258-4799-9438-27ac7d9d11d9.jpg', 'g11111111116');
INSERT INTO `goods_images` VALUES (142, '9f6627e7-fb6f-4213-ad85-250fdec83e30.jpg', 'g11111111146');
INSERT INTO `goods_images` VALUES (143, '7ac65ed2-b986-4798-8e93-0705ab3b68c4.jpg', 'g11111111153');
INSERT INTO `goods_images` VALUES (144, 'fa29f404-0571-4019-ae19-d05aaa9b0a21.jpg', 'g11111111111');

-- ----------------------------
-- Table structure for sell_goods
-- ----------------------------
DROP TABLE IF EXISTS `sell_goods`;
CREATE TABLE `sell_goods`  (
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品编号',
  `goods_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外键 用户id',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '外键，商品类型编号',
  `present` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品介绍',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  UNIQUE INDEX `goods_id`(`goods_id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `sell_goods_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`category_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `sell_goods_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sell_goods
-- ----------------------------
INSERT INTO `sell_goods` VALUES ('g11111111111', '手工剪刀', 9.90, 'l379426525037', 1002, '手工剪纸专用剪刀家用锋利小号大号剪刘海专用剪刀', '2023-11-08 19:50:36');
INSERT INTO `sell_goods` VALUES ('g11111111112', '五彩墨水', 5.50, 'l255494837252', 1000, '使用佳能墨水，只用过一次，颜色正，打印很流畅，便宜出', '2023-11-08 19:50:41');
INSERT INTO `sell_goods` VALUES ('g11111111113', '风油精', 2.00, 'l379426525036', 1003, '全新的，没使用过的', '2023-11-08 19:47:14');
INSERT INTO `sell_goods` VALUES ('g11111111114', '物联网专业的书', 8.00, 'l379426525043', 1005, '一本8块，要的私聊我', '2023-11-07 19:49:11');
INSERT INTO `sell_goods` VALUES ('g11111111115', '影巨人水民无线蓝牙耳机', 35.50, 'l379426525039', 1003, '全新，高雅黑，降噪5.3', '2023-11-07 19:51:56');
INSERT INTO `sell_goods` VALUES ('g11111111116', '发卡发夹', 1.00, 'l379426525036', 1000, '发卡夹刘海夹碎发一字侧边碎发夹夹后脑勺', '2023-09-12 20:10:59');
INSERT INTO `sell_goods` VALUES ('g11111111117', '会计专业书', 5.00, 'l379426525035', 1005, '会计专业的书，自取，5元一本', '2023-09-01 21:28:03');
INSERT INTO `sell_goods` VALUES ('g11111111118', '床上折叠小桌子', 7.00, 'l379426525037', 1002, '床上电脑桌可折叠，可用作笔记本电脑桌', '2023-10-30 21:30:35');
INSERT INTO `sell_goods` VALUES ('g11111111119', '计算机科学与技术专业的书', 6.00, 'l379426525038', 1005, '计算机科学与技术专业书籍，一本6元', '2023-11-06 21:32:53');
INSERT INTO `sell_goods` VALUES ('g11111111120', '浴球', 3.00, 'l379426525039', 1006, '可爱浴球全新3元', '2023-09-25 21:34:43');
INSERT INTO `sell_goods` VALUES ('g11111111121', '蓝色水桶', 3.00, 'l379426525042', 1000, '蓝色水桶可以当脏衣篓', '2023-11-06 21:36:31');
INSERT INTO `sell_goods` VALUES ('g11111111122', '床上桌', 10.00, 'l379426525043', 1002, '床上折叠桌，不占空间', '2023-11-06 21:40:18');
INSERT INTO `sell_goods` VALUES ('g11111111123', '拉链网格袋', 2.00, 'l379426525037', 1005, '拉链网格袋一共15个，可单买，2元一个，5元三个', '2023-11-06 22:03:12');
INSERT INTO `sell_goods` VALUES ('g11111111124', '圆规', 2.00, 'l379426525037', 1005, '晨光圆规全新未使用过', '2023-10-17 22:26:50');
INSERT INTO `sell_goods` VALUES ('g11111111125', '锁加钥匙', 2.00, 'l379426525038', 1000, '每把锁带两把钥匙', '2023-10-30 22:44:14');
INSERT INTO `sell_goods` VALUES ('g11111111126', '减压笔', 5.00, 'l379426525037', 1005, '减压笔无根自取', '2023-11-06 22:45:26');
INSERT INTO `sell_goods` VALUES ('g11111111127', '水卡', 5.00, 'l379426525042', 1000, '沧州交通学院水卡内有1元', '2023-11-06 22:47:48');
INSERT INTO `sell_goods` VALUES ('g11111111128', '手机支架', 8.00, 'l379426525038', 1003, '手机支架可以伸缩', '2023-11-06 22:59:02');
INSERT INTO `sell_goods` VALUES ('g11111111129', '上衣加裙子', 75.80, 'l379426525036', 1008, '全新的衣服，只试过一次', '2023-10-02 23:10:23');
INSERT INTO `sell_goods` VALUES ('g11111111130', '隆力奇蛇油护手霜', 5.00, 'l659567914588', 1004, '隆力奇护手霜一个50g', '2023-11-09 23:12:13');
INSERT INTO `sell_goods` VALUES ('g11111111131', '不锈钢晾衣架', 20.00, 'l604512690326', 1002, '晾衣架落地可折叠可伸缩', '2023-09-04 23:15:58');
INSERT INTO `sell_goods` VALUES ('g11111111132', '速溶黑咖啡', 15.00, 'l379426525035', 1001, '黑咖啡已经拆开了，有12袋', '2023-11-07 23:18:10');
INSERT INTO `sell_goods` VALUES ('g11111111133', '四级耳机', 15.00, 'l379426525041', 1003, '四级耳机可FM调频可连接红外线', '2023-11-08 23:19:45');
INSERT INTO `sell_goods` VALUES ('g11111111134', '行策纸', 1.00, 'l379426525039', 1005, '行测纸印刷很清楚', '2023-10-31 23:21:44');
INSERT INTO `sell_goods` VALUES ('g11111111135', '考研公式速记', 4.00, 'l379426525038', 1005, '考研数学公式速记', '2023-11-08 23:23:03');
INSERT INTO `sell_goods` VALUES ('g11111111136', '晾衣架', 4.00, 'l379426525035', 1000, '晾衣架便宜卖', '2023-11-03 23:24:25');
INSERT INTO `sell_goods` VALUES ('g11111111137', '网状收纳框', 3.00, 'l379426525038', 1009, '收纳筐可以悬挂', '2023-11-07 23:26:35');
INSERT INTO `sell_goods` VALUES ('g11111111138', '封口器', 1.00, 'l379426525037', 1009, '零食封口器袋子封口器', '2023-11-04 23:28:06');
INSERT INTO `sell_goods` VALUES ('g11111111139', '镜子带抽屉收纳', 16.00, 'l379426525040', 1004, '化妆镜带抽屉收纳一体式', '2023-09-01 23:31:30');
INSERT INTO `sell_goods` VALUES ('g11111111140', '补光灯手机支架', 25.00, 'l379426525036', 1003, '补光灯手机支架直播拍摄录视频', '2023-09-07 23:33:51');
INSERT INTO `sell_goods` VALUES ('g11111111141', '扑克牌', 3.00, 'l379426525042', 1006, '扑克牌有两副', '2023-09-12 23:35:01');
INSERT INTO `sell_goods` VALUES ('g11111111142', '手机屏幕放大器', 1.00, 'l379426525037', 1003, '追剧必备手机屏幕放大器', '2023-09-13 23:36:51');
INSERT INTO `sell_goods` VALUES ('g11111111143', '火爆拉丝魔鬼拉丝', 4.00, 'l379426525035', 1001, '香辣味和魔鬼味两种口味，125g/包', '2023-10-10 23:38:41');
INSERT INTO `sell_goods` VALUES ('g11111111144', '切菜板套装', 5.00, 'l379426525039', 1002, '切菜板套装迷你版，全新', '2023-11-01 23:40:57');
INSERT INTO `sell_goods` VALUES ('g11111111145', '数据线', 1.00, 'l379426525038', 1003, '安卓、苹果、Type-C都可用', '2023-11-06 23:42:29');
INSERT INTO `sell_goods` VALUES ('g11111111146', '钥匙链挂件挂饰', 2.00, 'l379426525036', 1009, '全新钥匙链', '2023-11-09 08:20:54');
INSERT INTO `sell_goods` VALUES ('g11111111147', '照片墙', 5.00, 'l255494837252', 1006, '照片墙带小夹子', '2023-09-21 23:47:24');
INSERT INTO `sell_goods` VALUES ('g11111111148', '有线键盘', 35.00, 'l379426525042', 1003, '有线键盘打游戏带劲', '2023-11-06 23:50:08');
INSERT INTO `sell_goods` VALUES ('g11111111149', '空调遥控器', 5.00, 'l379426525040', 1003, '通用的空调遥控器', '2023-10-30 23:51:42');
INSERT INTO `sell_goods` VALUES ('g11111111150', '手机支架', 1.00, 'l379426525039', 1003, '手机支架夹子可升降', '2023-11-13 23:53:14');
INSERT INTO `sell_goods` VALUES ('g11111111151', '床上折叠桌子', 7.00, 'l379426525044', 1002, '床上桌可以折叠', '2023-09-25 23:54:37');
INSERT INTO `sell_goods` VALUES ('g11111111152', '不锈钢晾衣架', 15.00, 'l379426525038', 1002, '85*140的不锈钢晾衣架', '2023-10-30 23:56:23');
INSERT INTO `sell_goods` VALUES ('g11111111153', '三丽鸥帕恰狗挂件挂饰', 5.00, 'l255494837252', 1006, '全新的帕恰狗玩偶挂件', '2023-11-09 08:21:01');
INSERT INTO `sell_goods` VALUES ('g11111111154', '姿色隔离', 18.00, 'l379426525038', 1004, '只用了一次，正品，假一赔三', '2023-11-07 00:00:03');
INSERT INTO `sell_goods` VALUES ('g11111111155', '名创优品化妆棉', 8.00, 'l379426525038', 1004, '全新未拆封', '2023-11-06 08:23:14');

-- ----------------------------
-- Table structure for shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car`  (
  `shoppingcar_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `goods_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`shoppingcar_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `goods_id`(`goods_id`) USING BTREE,
  CONSTRAINT `shopping_car_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `shopping_car_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `sell_goods` (`goods_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------
INSERT INTO `shopping_car` VALUES (112, 'l379426525036', 'g11111111117');
INSERT INTO `shopping_car` VALUES (123, 'l379426525035', 'g11111111125');
INSERT INTO `shopping_car` VALUES (124, 'l379426525035', 'g11111111119');
INSERT INTO `shopping_car` VALUES (125, 'l379426525035', 'g11111111120');
INSERT INTO `shopping_car` VALUES (157, 'l103622424735', 'g11111111129');
INSERT INTO `shopping_car` VALUES (165, 'l103622424735', 'g11111111114');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类型编号',
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型名',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1010 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (1000, '日用品类');
INSERT INTO `t_category` VALUES (1001, '食品类');
INSERT INTO `t_category` VALUES (1002, '家具用品类');
INSERT INTO `t_category` VALUES (1003, '数码产品类');
INSERT INTO `t_category` VALUES (1004, '化妆用品类');
INSERT INTO `t_category` VALUES (1005, '学习用品类');
INSERT INTO `t_category` VALUES (1006, '文体娱乐类');
INSERT INTO `t_category` VALUES (1007, '植物花卉类');
INSERT INTO `t_category` VALUES (1008, '服饰鞋包类');
INSERT INTO `t_category` VALUES (1009, '其他类');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '乐享账号',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `phone` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '手机号',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '密码',
  `sex` enum('未填','男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '未填' COMMENT '性别 ',
  `user_face` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `isVip` enum('是','否') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '否' COMMENT '是否为vip',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个人介绍',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE COMMENT '用户账号必须唯一',
  UNIQUE INDEX `phone`(`phone`) USING BTREE COMMENT '手机号必须唯一'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('l103622424735', 'admin', '15833187355', 'e10adc3949ba59abbe56e057f20f883e', '男', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '我是管理员');
INSERT INTO `t_user` VALUES ('l255494837252', '淘淘', '15673249856', 'e10adc3949ba59abbe56e057f20f883e', '男', 'https://pic.imeitou.com/uploads/allimg/230108/8-23010Q51Q8.jpg', '否', '我爱购物');
INSERT INTO `t_user` VALUES ('l379426525035', '小张', '15845211562', 'e10adc3949ba59abbe56e057f20f883e', '女', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '有钱有颜值');
INSERT INTO `t_user` VALUES ('l379426525036', '萌萌兔', '15845211563', 'e10adc3949ba59abbe56e057f20f883e', '女', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '珍惜当下，感恩拥有。');
INSERT INTO `t_user` VALUES ('l379426525037', '奶油小饼', '15845211564', 'e10adc3949ba59abbe56e057f20f883e', '男', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '阳光明媚，心情好。');
INSERT INTO `t_user` VALUES ('l379426525038', '糖果小妖精', '15845211565', 'e10adc3949ba59abbe56e057f20f883e', '女', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '感恩每一天。');
INSERT INTO `t_user` VALUES ('l379426525039', '小熊熊', '15845211566', 'e10adc3949ba59abbe56e057f20f883e', '男', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '热爱生活，享受当下。');
INSERT INTO `t_user` VALUES ('l379426525040', '甜甜糯糯', '15845211567', 'e10adc3949ba59abbe56e057f20f883e', '女', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '坚持梦想，永不放弃。');
INSERT INTO `t_user` VALUES ('l379426525041', '快乐小星星', '15845211568', 'e10adc3949ba59abbe56e057f20f883e', '女', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '累并快乐着。');
INSERT INTO `t_user` VALUES ('l379426525042', '独行侠', '15845211569', 'e10adc3949ba59abbe56e057f20f883e', '男', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '拥抱变化，迎接未来。');
INSERT INTO `t_user` VALUES ('l379426525043', '梦幻星辰', '15845211570', 'e10adc3949ba59abbe56e057f20f883e', '男', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '加油，明天更美好。');
INSERT INTO `t_user` VALUES ('l379426525044', '飘渺仙子', '15845211571', 'e10adc3949ba59abbe56e057f20f883e', '女', '81be2033-011d-49dd-af82-2da6846947c4.jpeg', '否', '积极向上，努力前行。');
INSERT INTO `t_user` VALUES ('l604512690326', '莎莎', '15833187354', 'e10adc3949ba59abbe56e057f20f883e', '未填', NULL, '否', NULL);
INSERT INTO `t_user` VALUES ('l659567914588', '妮妮子', '13645267895', 'e10adc3949ba59abbe56e057f20f883e', '未填', NULL, '否', NULL);

SET FOREIGN_KEY_CHECKS = 1;
