-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Movie_Theater
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Movie_Theater` ;

-- -----------------------------------------------------
-- Schema Movie_Theater
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Movie_Theater` DEFAULT CHARACTER SET utf8 ;
USE `Movie_Theater` ;

-- -----------------------------------------------------
-- Table `Movie_Theater`.`Movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`Movie` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`Movie` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `movie_name` VARCHAR(255) NOT NULL,
  `runtim` TIME NOT NULL,
  `releas` DATE NULL,
  PRIMARY KEY (`movie_id`),
  INDEX `name_index` (`movie_name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`m_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`m_info` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`m_info` (
  `id` INT NOT NULL,
  `description` LONGTEXT NULL,
  `rating` INT(1) ZEROFILL NULL,
  `age` INT NULL,
  `genre` VARCHAR(45) NULL,
  `cast` LONGTEXT NULL,
  `director` TEXT NULL,
  `producer` TEXT NULL,
  `trailer_video` TEXT NULL,
  `trailer_picture` TEXT NULL,
  `status` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_m_info_Movie1`
    FOREIGN KEY (`id`)
    REFERENCES `Movie_Theater`.`Movie` (`movie_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`user` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`user` (
  `email` VARCHAR(255) NOT NULL,
  `fname` VARCHAR(255) NULL,
  `lname` VARCHAR(255) NULL,
  `phone` VARCHAR(16) NULL,
  `password` VARCHAR(50) NOT NULL,
  `birthdate` DATE NOT NULL,
  `email_pref` INT ZEROFILL NOT NULL,
  `status` INT ZEROFILL NOT NULL,
  `street` VARCHAR(255) NULL,
  `city` VARCHAR(255) NULL,
  `state` VARCHAR(255) NULL,
  `zip` VARCHAR(255) NULL,
  `id` VARCHAR(255) NULL,
  PRIMARY KEY (email)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`payment_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`payment_info` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`payment_info` (
  `email_id` VARCHAR(255) NOT NULL,
  `card_name` VARCHAR(225) NOT NULL,
  `card_number` INT NOT NULL,
  `cardholder_name` VARCHAR(255) NOT NULL,
  `exp_date` DATE NOT NULL,
  `street` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`card_name`, `card_number`, `email_id`),
  INDEX `fk_payment_info_user1_idx` (`email_id` ASC),
  CONSTRAINT `fk_payment_info_user1`
    FOREIGN KEY (`email_id`)
    REFERENCES `Movie_Theater`.`user` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`employee` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ssn` INT NOT NULL,
  `fname` VARCHAR(255) NOT NULL,
  `lname` VARCHAR(255) NOT NULL,
  `street` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NOT NULL,
  `zip` INT NOT NULL,
  `stat` INT NOT NULL,
  `designation` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ssn`),
  INDEX `designation_index` (`designation` ASC),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`promo_code`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`promo_code` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`promo_code` (
  `promo_code` VARCHAR(20) NOT NULL,
  `discount_percent` DECIMAL(10,2) NOT NULL,
  `exp_date` DATE NULL)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`movie_date`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`movie_date` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`movie_date` (
  `id` INT NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `capacity` INT NOT NULL,
  `promo_code` VARCHAR(20) NULL,
  PRIMARY KEY (`id`, `date`, `time`),
  INDEX `date2` (`date` ASC),
  INDEX `time2` (`time` ASC),
  INDEX `fk_movie_date_promo_code1_idx` (`promo_code` ASC),
  CONSTRAINT `fk_movie_date_Movie1`
    FOREIGN KEY (`id`)
    REFERENCES `Movie_Theater`.`Movie` (`movie_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`ticket` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`ticket` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `movie_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  PRIMARY KEY (`ticket_id`),
  INDEX `fk_ticket_movie_date1_idx` (`movie_id` ASC),
  INDEX `fk_ticket_movie_date2_idx` (`date` ASC),
  INDEX `fk_ticket_movie_date3_idx` (`time` ASC),
  CONSTRAINT `fk_ticket_movie_date1`
    FOREIGN KEY (`movie_id`)
    REFERENCES `Movie_Theater`.`movie_date` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_movie_date2`
    FOREIGN KEY (`date`)
    REFERENCES `Movie_Theater`.`movie_date` (`date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_movie_date3`
    FOREIGN KEY (`time`)
    REFERENCES `Movie_Theater`.`movie_date` (`time`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`registered_tickets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`registered_tickets` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`registered_tickets` (
  `user_email` VARCHAR(255) NOT NULL,
  `ticket_id` INT NOT NULL,
  PRIMARY KEY (`ticket_id`, `user_email`),
  INDEX `fk_registered_tickets_user1_idx` (`user_email` ASC),
  CONSTRAINT `fk_registered_tickets_user1`
    FOREIGN KEY (`user_email`)
    REFERENCES `Movie_Theater`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registered_tickets_ticket1`
    FOREIGN KEY (`ticket_id`)
    REFERENCES `Movie_Theater`.`ticket` (`ticket_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`employee_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`employee_account` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`employee_account` (
  `emp_id` INT NOT NULL,
  `email` VARCHAR(255) NULL,
  `phone` VARCHAR(16) NULL,
  `password` VARCHAR(50) NULL,
  `promo_pref` INT ZEROFILL NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  PRIMARY KEY (`emp_id`),
  CONSTRAINT `fk_employee_account_employee1`
    FOREIGN KEY (`emp_id`)
    REFERENCES `Movie_Theater`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_employee_account_registered_tickets1`
    FOREIGN KEY (`email`)
    REFERENCES `Movie_Theater`.`registered_tickets` (`user_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`daily_hours_worked`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`daily_hours_worked` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`daily_hours_worked` (
  `emp_id` INT NOT NULL,
  `week` INT NOT NULL,
  `monday` DECIMAL(10,2) NULL,
  `tuesday` DECIMAL(10,2) NULL,
  `wednesday` DECIMAL(10,2) NULL,
  `thursday` DECIMAL(10,2) NULL,
  `friday` DECIMAL(10,2) NULL,
  `saturday` DECIMAL(10,2) NULL,
  `sunday` DECIMAL(10,2) NULL,
  PRIMARY KEY (`emp_id`, `week`),
  CONSTRAINT `fk_daily_hours_worked_employee1`
    FOREIGN KEY (`emp_id`)
    REFERENCES `Movie_Theater`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`admin` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`admin` (
  `admin_id` INT NOT NULL,
  `designation` VARCHAR(10) NOT NULL,
  `admin_email` VARCHAR(70) NOT NULL,
  `admin_password` VARCHAR(45) NOT NULL,
  `status` INT NULL,
  PRIMARY KEY (`admin_id`, `designation`),
  UNIQUE INDEX `admin_email_UNIQUE` (`admin_email` ASC),
  INDEX `fk_admin_employee2_idx` (`designation` ASC),
  CONSTRAINT `fk_admin_employee1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `Movie_Theater`.`employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_admin_employee2`
    FOREIGN KEY (`designation`)
    REFERENCES `Movie_Theater`.`employee` (`designation`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`manager`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`manager` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`manager` (
  `manager_id` INT NOT NULL,
  `designation` VARCHAR(10) NOT NULL,
  `manager_email` VARCHAR(70) NOT NULL,
  `manager_password` VARCHAR(45) NOT NULL,
  `status` INT NULL,
  PRIMARY KEY (`manager_id`, `designation`),
  UNIQUE INDEX `manager_email_UNIQUE` (`manager_email` ASC),
  INDEX `fk_manager_employee2_idx` (`designation` ASC),
  CONSTRAINT `fk_manager_employee1`
    FOREIGN KEY (`manager_id`)
    REFERENCES `Movie_Theater`.`employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_manager_employee2`
    FOREIGN KEY (`designation`)
    REFERENCES `Movie_Theater`.`employee` (`designation`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`regular`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`regular` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`regular` (
  `regular_id` INT NOT NULL,
  `designation` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`regular_id`, `designation`),
  INDEX `fk_regular_employee2_idx` (`designation` ASC),
  CONSTRAINT `fk_regular_employee1`
    FOREIGN KEY (`regular_id`)
    REFERENCES `Movie_Theater`.`employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_regular_employee2`
    FOREIGN KEY (`designation`)
    REFERENCES `Movie_Theater`.`employee` (`designation`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`discounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`discounts` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`discounts` (
  `disc_id` INT NOT NULL,
  `student` DECIMAL(10,2) NULL,
  `military` DECIMAL(10,2) NULL,
  `seniors` DECIMAL(10,2) NULL,
  `adult` DECIMAL(10,2) NULL,
  `under13` DECIMAL(10,2) NULL,
  PRIMARY KEY (`disc_id`),
  UNIQUE INDEX `disc_id_UNIQUE` (`disc_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`reset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`resets` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`resets` (
  `email` VARCHAR(255) NOT NULL,
  `resetID` INT NOT NULL AUTO_INCREMENT,
  UNIQUE INDEX `key_UNIQUE` (`resetID` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  PRIMARY KEY (`email`),
  CONSTRAINT `fk_reset_user1`
    FOREIGN KEY (`email`)
    REFERENCES `Movie_Theater`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movie_Theater`.`verify`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Movie_Theater`.`verify` ;

CREATE TABLE IF NOT EXISTS `Movie_Theater`.`verify` (
  `email` VARCHAR(255) NOT NULL,
  `verifyID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`email`),
  UNIQUE INDEX `verifyID_UNIQUE` (`verifyID` ASC),
  CONSTRAINT `fk_verify_user1`
    FOREIGN KEY (`email`)
    REFERENCES `Movie_Theater`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
