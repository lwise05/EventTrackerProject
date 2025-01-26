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
-- Table `venue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `venue` ;

CREATE TABLE IF NOT EXISTS `venue` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  `street` VARCHAR(60) NULL,
  `street2` VARCHAR(60) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `postal_code` INT NULL,
  `country` VARCHAR(2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comedian`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comedian` ;

CREATE TABLE IF NOT EXISTS `comedian` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  `notes` VARCHAR(45) NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comedian_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_comedian_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comedy_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comedy_event` ;

CREATE TABLE IF NOT EXISTS `comedy_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `performance_date` DATE NULL,
  `rating` INT NOT NULL,
  `ticket_price` DECIMAL NULL,
  `venue_id` INT NOT NULL,
  `comedian_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comedy_event_venue_idx` (`venue_id` ASC) VISIBLE,
  INDEX `fk_comedy_event_comedian1_idx` (`comedian_id` ASC) VISIBLE,
  CONSTRAINT `fk_comedy_event_venue`
    FOREIGN KEY (`venue_id`)
    REFERENCES `venue` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comedy_event_comedian1`
    FOREIGN KEY (`comedian_id`)
    REFERENCES `comedian` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `venue`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `venue` (`id`, `name`, `image_url`, `street`, `street2`, `city`, `state`, `postal_code`, `country`) VALUES (DEFAULT, 'Comedy Works', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `category` (`id`, `name`) VALUES (DEFAULT, 'story telling');

COMMIT;


-- -----------------------------------------------------
-- Data for table `comedian`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Beth', 'Stelling', NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comedy_event`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2025-01-17', 5, 53.00, 1, 1);

COMMIT;

