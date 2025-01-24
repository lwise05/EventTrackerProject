-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema comedyeventdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `comedyeventdb` ;

-- -----------------------------------------------------
-- Schema comedyeventdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `comedyeventdb` DEFAULT CHARACTER SET utf8 ;
USE `comedyeventdb` ;

-- -----------------------------------------------------
-- Table `comedy_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comedy_event` ;

CREATE TABLE IF NOT EXISTS `comedy_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `performance_date` DATETIME NULL,
  `rating` INT NOT NULL,
  `venue_id` INT NULL,
  `user_id` INT NULL,
  `comment_id` INT NULL,
  `ticket_price` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS comedylover@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'comedylover'@'localhost' IDENTIFIED BY 'laugh';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'comedylover'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `comedy_event`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `venue_id`, `user_id`, `comment_id`, `ticket_price`) VALUES (DEFAULT, '2025-01-17', 5, NULL, NULL, NULL, NULL);

COMMIT;

