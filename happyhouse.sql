-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse` ;

-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`baseaddress` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(30) NOT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `guguncode` VARCHAR(30) NULL DEFAULT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3626
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`commercial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`commercial` (
  `no` INT NOT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `branch` VARCHAR(30) NULL DEFAULT NULL,
  `category` VARCHAR(30) NULL DEFAULT NULL,
  `guguncode` VARCHAR(30) NULL DEFAULT NULL,
  `address` VARCHAR(30) NULL DEFAULT NULL,
  `lng` DOUBLE NULL DEFAULT NULL,
  `lat` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongcode` TEXT NULL DEFAULT NULL,
  `city` TEXT NULL DEFAULT NULL,
  `gugun` TEXT NULL DEFAULT NULL,
  `dong` TEXT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`user` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `addres` VARCHAR(30) NULL DEFAULT NULL,
  `tel` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3628
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`favorit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`favorit` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `user_no` INT NOT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `gu` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `user_no` (`user_no` ASC) VISIBLE,
  CONSTRAINT `favorit_ibfk_1`
    FOREIGN KEY (`user_no`)
    REFERENCES `happyhouse`.`user` (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3626
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`favorite` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `user_no` INT NOT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `gu` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `user_no` (`user_no` ASC) VISIBLE,
  CONSTRAINT `favorite_ibfk_1`
    FOREIGN KEY (`user_no`)
    REFERENCES `happyhouse`.`user` (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3629
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`guguncode` (
  `guguncode` VARCHAR(10) NOT NULL,
  `gugunname` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`guguncode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`hospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital` (
  `no` INT NULL DEFAULT NULL,
  `sido` TEXT NULL DEFAULT NULL,
  `gungu` TEXT NULL DEFAULT NULL,
  `name` TEXT NULL DEFAULT NULL,
  `address` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `tel` TEXT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`hospital2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`hospital2` (
  `no` INT NULL DEFAULT NULL,
  `sido` TEXT NULL DEFAULT NULL,
  `gungu` TEXT NULL DEFAULT NULL,
  `name` TEXT NULL DEFAULT NULL,
  `address` TEXT NULL DEFAULT NULL,
  `type` TEXT NULL DEFAULT NULL,
  `tel` TEXT NULL DEFAULT NULL,
  `guguncode` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `guguncode` VARCHAR(30) NOT NULL,
  `dealAmount` VARCHAR(50) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealMonth` VARCHAR(30) NULL DEFAULT NULL,
  `dealDay` VARCHAR(30) NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `guguncode` VARCHAR(30) NOT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `img` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 5990
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`sidocode` (
  `sidocode` VARCHAR(10) NOT NULL,
  `sidoname` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sidocode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`user` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NULL DEFAULT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `addres` VARCHAR(30) NULL DEFAULT NULL,
  `tel` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3628
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`favorite` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `user_no` INT NOT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `gu` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`no`),
  INDEX `user_no` (`user_no` ASC) VISIBLE,
  CONSTRAINT `favorite_ibfk_1`
    FOREIGN KEY (`user_no`)
    REFERENCES `happyhouse`.`user` (`no`))
ENGINE = InnoDB
AUTO_INCREMENT = 3629
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `happyhouse`.`commercial_has_favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`commercial_has_favorite` (
  `dongcode` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NULL,
  PRIMARY KEY (`dongcode`),
  INDEX `fk_commercial_has_favorite_favorite1_idx` (`gugun` ASC) VISIBLE,
  INDEX `fk_commercial_has_favorite_commercial1_idx` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `fk_commercial_has_favorite_commercial1`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`commercial` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commercial_has_favorite_favorite1`
    FOREIGN KEY (`gugun`)
    REFERENCES `happyhouse`.`favorite` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
