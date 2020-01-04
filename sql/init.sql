# Account
CREATE TABLE `account` (
  `account_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` char(1) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `UK_ACCOUNT_ACCOUNT` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `account` (`account`, `name`, `sex`) VALUES ('edward_01', 'Edward', 'M');
INSERT INTO `account` (`account`, `name`, `sex`) VALUES ('andy_02', 'Andy', 'M');
INSERT INTO `account` (`account`, `name`, `sex`) VALUES ('jack_03', 'Jack', 'M');
INSERT INTO `account` (`account`, `name`, `sex`) VALUES ('emma_04', 'Emma', 'F');
INSERT INTO `account` (`account`, `name`, `sex`) VALUES ('isabella_05', 'Isabella', 'F');
INSERT INTO `account` (`account`, `name`, `sex`) VALUES ('sophia_06', 'Sophia', 'F');

# Role
CREATE TABLE `role` (
  `role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `UK_ROLE_NAME` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `role` (`name`) VALUES ('employee');
INSERT INTO `role` (`name`) VALUES ('accounting');
INSERT INTO `role` (`name`) VALUES ('engineer');

# Account_Role
CREATE TABLE `account_role` (
  `account_id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`account_id`,`role_id`),
  FOREIGN KEY `FK_AR_ACCOUNT_ID` (`account_id`) REFERENCES `account` (`account_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  FOREIGN KEY `FK_AR_ROLE_ID` (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('2', '1');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('3', '1');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('4', '1');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('5', '1');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('6', '1');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('1', '3');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('2', '3');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('3', '3');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('4', '2');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('5', '2');
INSERT INTO `account_role` (`account_id`, `role_id`) VALUES ('6', '3');

# Menu
CREATE TABLE `menu` (
  `menu_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `detail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  FOREIGN KEY `FK_MENU_ROLE_ID` (`role_id`) REFERENCES `role` (`role_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `menu` (`role_id`, `detail`) VALUES ('1', 'API-Get_Employee_Information');
INSERT INTO `menu` (`role_id`, `detail`) VALUES ('2', 'API-Get_Company_Money');
INSERT INTO `menu` (`role_id`, `detail`) VALUES ('2', 'API-Withdrawal_Company_Money');
INSERT INTO `menu` (`role_id`, `detail`) VALUES ('3', 'API-Configure_Company_Internet');
INSERT INTO `menu` (`role_id`, `detail`) VALUES ('3', 'API-Adjust_Employee_Permission');
INSERT INTO `menu` (`role_id`, `detail`) VALUES ('3', 'API-Configure_Door_Access_Card');

