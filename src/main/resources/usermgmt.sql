-- MySQL Script generated by MySQL Workbench
-- Fri Jan 18 17:12:44 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lnto_usermgmt
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lnto_usermgmt
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lnto_usermgmt` DEFAULT CHARACTER SET utf8 ;
USE `lnto_usermgmt` ;

-- -----------------------------------------------------
-- Table `lnto_usermgmt`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lnto_usermgmt`.`Person` (
  `PersonID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(128) NOT NULL,
  `LastName` VARCHAR(128) NOT NULL,
  `MiddleName` VARCHAR(128) NULL,
  `Gender` VARCHAR(6) NULL,
  `Birthday` DATETIME NOT NULL,
  `Title` VARCHAR(128) NULL,
  `Suffix` VARCHAR(128) NULL,
  `IsActive` TINYINT NOT NULL,
  PRIMARY KEY (`PersonID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lnto_usermgmt`.`Phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lnto_usermgmt`.`Phone` (
  `PhoneID` INT NOT NULL AUTO_INCREMENT,
  `AddressType` VARCHAR(45) NOT NULL,
  `PhoneNumber` VARCHAR(20) NULL,
  `PersonID` INT NOT NULL,
  `IsDefault` TINYINT NOT NULL,
  PRIMARY KEY (`PhoneID`, `PersonID`),
  CONSTRAINT `fk_Phone_Person`
    FOREIGN KEY (`PersonID`)
    REFERENCES `lnto_usermgmt`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lnto_usermgmt`.`Email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lnto_usermgmt`.`Email` (
  `EmailID` INT NOT NULL AUTO_INCREMENT,
  `AddressType` VARCHAR(45) NOT NULL,
  `EmailAddress` VARCHAR(128) NULL,
  `PersonID` INT NOT NULL,
  `IsDefault` TINYINT NOT NULL,
  PRIMARY KEY (`EmailID`, `PersonID`),
  CONSTRAINT `fk_Phone_Person0`
    FOREIGN KEY (`PersonID`)
    REFERENCES `lnto_usermgmt`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lnto_usermgmt`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lnto_usermgmt`.`Address` (
  `AddressID` INT NOT NULL AUTO_INCREMENT,
  `AddressType` VARCHAR(45) NOT NULL,
  `PersonID` INT NOT NULL,
  `IsDefault` TINYINT NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  `ZipPostCode` VARCHAR(45) NULL,
  `ProvinceStateCounty` VARCHAR(128) NULL,
  `CityTownVillage` VARCHAR(128) NOT NULL,
  `StreetRoadBlock` VARCHAR(128) NOT NULL,
  `HouseBuilding` VARCHAR(128) NOT NULL,
  `Other` VARCHAR(512) NULL,
  `Longitude` DECIMAL(11,8) NULL,
  `Latitude` DECIMAL(11,8) NULL,
  PRIMARY KEY (`AddressID`, `PersonID`),
  CONSTRAINT `fk_Phone_Person00`
    FOREIGN KEY (`PersonID`)
    REFERENCES `lnto_usermgmt`.`Person` (`PersonID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
