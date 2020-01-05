-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.18 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

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

-- Dumping data for table localtestingschema.sample_table: ~0 rows (approximately)
DELETE FROM `sample_table`;
/*!40000 ALTER TABLE `sample_table` DISABLE KEYS */;
INSERT INTO `sample_table` (`id`, `name`, `type`) VALUES
	(0, 'pranav', 'brilliant');
/*!40000 ALTER TABLE `sample_table` ENABLE KEYS */;

-- Dumping data for table localtestingschema.taco: ~11 rows (approximately)
DELETE FROM `taco`;
/*!40000 ALTER TABLE `taco` DISABLE KEYS */;
INSERT INTO `taco` (`id`, `name`, `ingredient_list`, `created_at`, `updated_at`) VALUES
	('4028b8816f36243c016f362487d20000', 'SecondTaco', NULL, '2019-12-24 00:00:00', NULL),
	('4028b8816f363f20016f364041ea0001', 'ThirdTaco', NULL, '2019-12-24 00:00:00', NULL),
	('4028b8816f363f20016f364a84ff0002', 'ordertesting', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36a711016f36a790df0000', 'ordertesting2', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f36d195c50000', 'ordertesting3', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f36d384170001', 'ordertesting4', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f36d47db90003', 'ordertesting5', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f37141fcd0005', 'ordertesting6', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f3715648f0007', 'ordertesting7', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f371628d80009', 'ordertesting8', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('4028b8816f36d116016f3716f616000b', 'ordertesting9', NULL, '2019-12-24 00:00:00', '2019-12-24 00:00:00'),
	('40286c816f5c799e016f5c7b0acc0000', 'RestTesting4', NULL, '2019-12-31 20:32:45', '2019-12-31 20:32:45'),
	('40286c816f5c799e016f5c8aec3a0001', 'RestTesting4', NULL, '2019-12-31 20:50:06', '2019-12-31 20:50:06');
/*!40000 ALTER TABLE `taco` ENABLE KEYS */;

-- Dumping data for table localtestingschema.taco_ingredient: ~32 rows (approximately)
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
	('LETC', '4028b8816f36d116016f3716f616000b'),
	('JACK', '40286c816f5c799e016f5c7b0acc0000'),
	('LETC', '40286c816f5c799e016f5c7b0acc0000'),
	('JACK', '40286c816f5c799e016f5c8aec3a0001'),
	('LETC', '40286c816f5c799e016f5c8aec3a0001');
/*!40000 ALTER TABLE `taco_ingredient` ENABLE KEYS */;

-- Dumping data for table localtestingschema.taco_order: ~0 rows (approximately)
DELETE FROM `taco_order`;
/*!40000 ALTER TABLE `taco_order` DISABLE KEYS */;
INSERT INTO `taco_order` (`id`, `delivery_name`, `delivery_city`, `delivery_state`, `cc_number`, `cc_expiration`, `cc_cvv`, `placed_at`) VALUES
	('4028b8816f36d116016f', 'minato', 'hidden leaf', 'fi', '123456', '12345', '123', '2019-12-24 00:00:00');
/*!40000 ALTER TABLE `taco_order` ENABLE KEYS */;

-- Dumping data for table localtestingschema.taco_order_tacos: ~0 rows (approximately)
DELETE FROM `taco_order_tacos`;
/*!40000 ALTER TABLE `taco_order_tacos` DISABLE KEYS */;
/*!40000 ALTER TABLE `taco_order_tacos` ENABLE KEYS */;

-- Dumping data for table localtestingschema.taco_user: ~2 rows (approximately)
DELETE FROM `taco_user`;
/*!40000 ALTER TABLE `taco_user` DISABLE KEYS */;
INSERT INTO `taco_user` (`id`, `username`, `pwd`, `created_at`) VALUES
	(1, 'pranav', 'pranav', '2019-12-27 18:03:25'),
	(2, 'karthik', 'karthik', '2019-12-27 18:03:25');
/*!40000 ALTER TABLE `taco_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
