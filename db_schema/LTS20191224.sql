-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.27 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for localtestingschema
CREATE DATABASE IF NOT EXISTS `localtestingschema` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `localtestingschema`;

-- Dumping structure for table localtestingschema.ingredient
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id` varchar(4) NOT NULL,
  `name` varchar(25) NOT NULL,
  `type` varchar(10) NOT NULL,
  UNIQUE KEY `ingredient_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Contains list of ingredients available';

-- Dumping data for table localtestingschema.ingredient: ~10 rows (approximately)
DELETE FROM `ingredient`;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` (`id`, `name`, `type`) VALUES
	('CARN', 'Carnitas', 'Proteins'),
	('CHED', 'Cheddar', 'Cheese'),
	('COTO', 'Corn Tortilla', 'Wrap'),
	('FLTO', 'Flour Tortilla', 'Wrap'),
	('GRBF', 'Ground Beef', 'Proteins'),
	('JACK', 'Monterrey Jack', 'Cheese'),
	('LETC', 'Lettuce', 'Veggies'),
	('SLSA', 'Salsa', 'Sauce'),
	('SRCR', 'Sour Cream', 'Sauce'),
	('TMTO', 'Diced Tomatoes', 'Veggies');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;

-- Dumping structure for table localtestingschema.taco
CREATE TABLE IF NOT EXISTS `taco` (
  `id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  UNIQUE KEY `taco_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table localtestingschema.taco: ~10 rows (approximately)
DELETE FROM `taco`;
/*!40000 ALTER TABLE `taco` DISABLE KEYS */;
INSERT INTO `taco` (`id`, `name`, `created_at`, `updated_at`) VALUES
	('4028b8816f36243c016f362487d20000', 'SecondTaco', '2019-12-24', NULL),
	('4028b8816f363f20016f364041ea0001', 'ThirdTaco', '2019-12-24', NULL),
	('4028b8816f363f20016f364a84ff0002', 'ordertesting', '2019-12-24', '2019-12-24'),
	('4028b8816f36a711016f36a790df0000', 'ordertesting2', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f36d195c50000', 'ordertesting3', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f36d384170001', 'ordertesting4', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f36d47db90003', 'ordertesting5', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f37141fcd0005', 'ordertesting6', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f3715648f0007', 'ordertesting7', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f371628d80009', 'ordertesting8', '2019-12-24', '2019-12-24'),
	('4028b8816f36d116016f3716f616000b', 'ordertesting9', '2019-12-24', '2019-12-24');
/*!40000 ALTER TABLE `taco` ENABLE KEYS */;

-- Dumping structure for table localtestingschema.taco_ingredient
CREATE TABLE IF NOT EXISTS `taco_ingredient` (
  `ingredient_id` varchar(100) DEFAULT NULL,
  `taco_id` varchar(100) DEFAULT NULL,
  KEY `ingredient_id` (`ingredient_id`),
  KEY `taco_id` (`taco_id`),
  CONSTRAINT `taco_ingredient_ibfk_1` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredient` (`id`),
  CONSTRAINT `taco_ingredient_ibfk_2` FOREIGN KEY (`taco_id`) REFERENCES `taco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table localtestingschema.taco_ingredient: ~29 rows (approximately)
DELETE FROM `taco_ingredient`;
/*!40000 ALTER TABLE `taco_ingredient` DISABLE KEYS */;
INSERT INTO `taco_ingredient` (`ingredient_id`, `taco_id`) VALUES
	('COTO', '4028b8816f36243c016f362487d20000'),
	('CHED', '4028b8816f36243c016f362487d20000'),
	('TMTO', '4028b8816f36243c016f362487d20000'),
	('COTO', '4028b8816f363f20016f364041ea0001'),
	('CHED', '4028b8816f363f20016f364041ea0001'),
	('JACK', '4028b8816f363f20016f364041ea0001'),
	('LETC', '4028b8816f363f20016f364041ea0001'),
	('COTO', '4028b8816f363f20016f364a84ff0002'),
	('CHED', '4028b8816f363f20016f364a84ff0002'),
	('JACK', '4028b8816f363f20016f364a84ff0002'),
	('LETC', '4028b8816f363f20016f364a84ff0002'),
	('FLTO', '4028b8816f36a711016f36a790df0000'),
	('GRBF', '4028b8816f36a711016f36a790df0000'),
	('JACK', '4028b8816f36a711016f36a790df0000'),
	('CARN', '4028b8816f36d116016f36d195c50000'),
	('LETC', '4028b8816f36d116016f36d195c50000'),
	('TMTO', '4028b8816f36d116016f36d195c50000'),
	('SLSA', '4028b8816f36d116016f36d195c50000'),
	('CHED', '4028b8816f36d116016f36d384170001'),
	('JACK', '4028b8816f36d116016f36d384170001'),
	('LETC', '4028b8816f36d116016f36d384170001'),
	('TMTO', '4028b8816f36d116016f36d384170001'),
	('CARN', '4028b8816f36d116016f36d47db90003'),
	('SLSA', '4028b8816f36d116016f37141fcd0005'),
	('SRCR', '4028b8816f36d116016f37141fcd0005'),
	('CHED', '4028b8816f36d116016f3715648f0007'),
	('JACK', '4028b8816f36d116016f3715648f0007'),
	('LETC', '4028b8816f36d116016f371628d80009'),
	('TMTO', '4028b8816f36d116016f371628d80009'),
	('CARN', '4028b8816f36d116016f3716f616000b'),
	('JACK', '4028b8816f36d116016f3716f616000b'),
	('LETC', '4028b8816f36d116016f3716f616000b');
/*!40000 ALTER TABLE `taco_ingredient` ENABLE KEYS */;

-- Dumping structure for table localtestingschema.taco_order
CREATE TABLE IF NOT EXISTS `taco_order` (
  `id` varchar(100) DEFAULT NULL,
  `delivery_name` varchar(50) NOT NULL,
  `delivery_city` varchar(50) NOT NULL,
  `delivery_state` varchar(20) NOT NULL,
  `cc_number` varchar(16) NOT NULL,
  `cc_expiration` varchar(10) NOT NULL,
  `cc_cvv` varchar(3) NOT NULL,
  `placed_at` date DEFAULT NULL,
  UNIQUE KEY `tacoOrder_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table localtestingschema.taco_order: ~0 rows (approximately)
DELETE FROM `taco_order`;
/*!40000 ALTER TABLE `taco_order` DISABLE KEYS */;
INSERT INTO `taco_order` (`id`, `delivery_name`, `delivery_city`, `delivery_state`, `cc_number`, `cc_expiration`, `cc_cvv`, `placed_at`) VALUES
	('4028b8816f36d116016f37171b79000c', 'minato', 'hidden leaf', 'fire nation', '123456', '123457', '123', '2019-12-24');
/*!40000 ALTER TABLE `taco_order` ENABLE KEYS */;

-- Dumping structure for table localtestingschema.taco_order_tacos
CREATE TABLE IF NOT EXISTS `taco_order_tacos` (
  `tacoOrder_id` varchar(20) NOT NULL,
  `taco_id` varchar(20) NOT NULL,
  KEY `tacoOrder_id` (`tacoOrder_id`),
  KEY `taco_id` (`taco_id`),
  CONSTRAINT `taco_order_tacos_ibfk_1` FOREIGN KEY (`tacoOrder_id`) REFERENCES `taco_order` (`id`),
  CONSTRAINT `taco_order_tacos_ibfk_2` FOREIGN KEY (`taco_id`) REFERENCES `taco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table localtestingschema.taco_order_tacos: ~0 rows (approximately)
DELETE FROM `taco_order_tacos`;
/*!40000 ALTER TABLE `taco_order_tacos` DISABLE KEYS */;
/*!40000 ALTER TABLE `taco_order_tacos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
