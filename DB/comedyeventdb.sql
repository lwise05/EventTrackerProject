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
  `notes` VARCHAR(500) NULL,
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
  `notes` VARCHAR(500) NULL,
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
INSERT INTO `venue` (`id`, `name`, `image_url`, `street`, `street2`, `city`, `state`, `postal_code`, `country`) VALUES (DEFAULT, 'Comedy Works Downtown', 'https://upload.wikimedia.org/wikipedia/commons/6/61/Comedy_Works_entrance_in_Denver_2.jpg', '1226 15th St', NULL, 'Denver', 'Colorado', 80202, 'US');
INSERT INTO `venue` (`id`, `name`, `image_url`, `street`, `street2`, `city`, `state`, `postal_code`, `country`) VALUES (DEFAULT, 'Comedy Works South', 'https://live.staticflickr.com/7401/16406999439_90d31bb3c0_w.jpg', '5345 Landmark Pl', NULL, 'Greenwood Village', 'Colorado', 80111, 'US');
INSERT INTO `venue` (`id`, `name`, `image_url`, `street`, `street2`, `city`, `state`, `postal_code`, `country`) VALUES (DEFAULT, 'Paramount Theatre', 'https://s3-media0.fl.yelpcdn.com/bphoto/UF5aOuIQw0LtDH8OoVlrxw/348s.jpg', '1621 Glenarm Pl', NULL, 'Denver', 'Colorado', 80202, 'US');
INSERT INTO `venue` (`id`, `name`, `image_url`, `street`, `street2`, `city`, `state`, `postal_code`, `country`) VALUES (DEFAULT, 'Broadmoor World Arena', 'https://www.peakradar.com/wp-content/uploads/sites/www.peakradar.com/images/2017/06/World-Arena.jpg', '3185 Venetucci Blvd', NULL, 'Colorado Springs', 'Colorado', 80906, 'US');

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `category` (`id`, `name`) VALUES (DEFAULT, 'Anecdotal (story telling)');
INSERT INTO `category` (`id`, `name`) VALUES (DEFAULT, 'Observational (everyday life humor)');
INSERT INTO `category` (`id`, `name`) VALUES (DEFAULT, 'Deadpan (sarcastic)');
INSERT INTO `category` (`id`, `name`) VALUES (DEFAULT, 'Topical (social commentary)');
INSERT INTO `category` (`id`, `name`) VALUES (DEFAULT, 'Insult (crowd work)');

COMMIT;


-- -----------------------------------------------------
-- Data for table `comedian`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Beth', 'Stelling', 'https://thecomedystore.com/wp-content/uploads/2023/06/Beth-Stelling-Bio-Photo-Edit.jpg', 'She is laidback and sarcastic. She tells life scenarios with punchy jokes.', 3);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Joel Kim', 'Booster', 'https://media.glamour.com/photos/60ac0d49e72b0c49cd96cd5b/4:3/w_5504,h_4128,c_limit/joelkimbooster.jpg', 'He talks about a variety of topics and does crowd work.', 4);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Chris ', 'Red', 'https://i.ticketweb.com/i/00/07/97/69/21/Original.jpg?v=5?v=6', 'He likes to tell stories about growing up compared to what his life looks like currently.', 2);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Brian', 'Simpson', 'https://images.ctfassets.net/qzo6ooq9c21v/3chZWlDinuXBLj97HRks3T/74da17f677b39ac16b0eed95e62f7c2e/NIAJ24_Raw_BrianSimpson_1200x1000_v2.png', 'His comedy likes to poke fun at current culture and social climate issues.', 4);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Josh', 'Johnson', 'https://www.ocregister.com/wp-content/uploads/2023/02/OCR-L-TV-JOHNSON-0212-01.jpg?w=1800&resize=1800,1800', 'His comedy revolves around current issues and focuses on finding the absurdity in everyday life. ', 4);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Ralph', 'Barbosa', 'https://www.madisoncomedy.com/wp-content/uploads/ralph.barbosa.web_.jpg', 'He tells relatable stories about being an adult.', 2);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Nate', 'Jackson', 'https://www.stgpresents.org/wp-content/uploads/2024/11/Nate-Jackson-2025-Showpage.jpg', 'His comedy focuses on crowd work.', 5);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'Ali', 'Siddiq', 'https://i.ticketweb.com/i/00/07/68/10/89_Original.jpg?v=11', 'He enjoys telling stories about his past and comparing how different it is to his current life and the obstacles that come from fame and fatherhood.', 1);
INSERT INTO `comedian` (`id`, `first_name`, `last_name`, `image_url`, `notes`, `category_id`) VALUES (DEFAULT, 'John', 'Mulaney', 'https://pbs.twimg.com/media/GXDlCvUWAAEtwxI?format=jpg&name=large', 'He likes telling punchy and self depricating jokes.', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comedy_event`
-- -----------------------------------------------------
START TRANSACTION;
USE `comedyeventdb`;
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2025-01-17', 5, 53.00, 'Great set! She seemed to be working on new material which was exciting.', 1, 1);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-11-24', 5, 43.00, 'Amazing crowd work and discussed his new life events.  Definitely will get closer seats next time.', 1, 2);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-06-28', 4, 57.00, 'He had local openers which I really enjoyed, as well as his set.', 1, 3);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-07-12', 5, 47.50, 'SO FUNNY! His set was perfectly crafted and had a joke for everyone. Great crowd participation.', 1, 4);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-07-27', 5, 38.50, 'Great social commentary!', 2, 5);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-02-25', 5, 38.50, 'His openers were great and he had fresh material.', 2, 6);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-06-15', 3, 73.50, 'Since he focuses on crowdwork, there were good moments but the quanity/quality of jokes wasn\'t consistent.', 3, 7);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2024-09-28', 3, 88.00, 'The audio was horrible which made it difficult to hear him and they never attempted to fix it.', 3, 8);
INSERT INTO `comedy_event` (`id`, `performance_date`, `rating`, `ticket_price`, `notes`, `venue_id`, `comedian_id`) VALUES (DEFAULT, '2022-10-23', 5, 0.00, 'I won free tickets to the show and it was 10/10! He dove into his current controversies in a really smart and funny way.', 4, 9);

COMMIT;

