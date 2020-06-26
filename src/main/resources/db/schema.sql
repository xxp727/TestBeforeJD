DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100),
  `type` varchar(100),
  `description` varchar(256),
  `serial` varchar(100),
  PRIMARY KEY (`id`)
)