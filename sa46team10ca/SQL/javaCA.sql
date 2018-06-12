DROP SCHEMA sa46team10ca;

CREATE SCHEMA sa46team10ca;

USE sa46team10ca;
  
  CREATE TABLE `sa46team10ca`.`users` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `nric` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `phone` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`));

CREATE TABLE `sa46team10ca`.`facility` (
  `facilityid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`facilityid`));

CREATE TABLE `sa46team10ca`.`timeslots` (
  `timeslotid` INT NOT NULL AUTO_INCREMENT,
  `timeslot` VARCHAR(45) NULL,
  PRIMARY KEY (`timeslotid`));

CREATE TABLE `sa46team10ca`.`maintenance` (
  `maintenanceid` INT NOT NULL AUTO_INCREMENT,
  `facilityid` INT NULL,
  `timeslotid` INT NULL,
  `date` DATE NULL,
  PRIMARY KEY (`maintenanceid`),
  FOREIGN KEY (`facilityid`)
  REFERENCES `sa46team10ca`.`facility` (`facilityid`),
  FOREIGN KEY (`timeslotid`)
  REFERENCES `sa46team10ca`.`timeslots` (`timeslotid`));
    
CREATE TABLE `sa46team10ca`.`booking` (
  `bookingid` INT NOT NULL AUTO_INCREMENT,
  `userid` INT NULL,
  `facilityid` INT NULL,
  `timeslotid` INT NULL,
  `date` DATE NULL,
  `bookingstatus` VARCHAR(45) NULL,
  PRIMARY KEY (`bookingid`),
  FOREIGN KEY (`userid`)
  REFERENCES `sa46team10ca`.`users` (`userid`),
  FOREIGN KEY (`facilityid`)
  REFERENCES `sa46team10ca`.`facility` (`facilityid`),
  FOREIGN KEY (`timeslotid`)
  REFERENCES `sa46team10ca`.`timeslots` (`timeslotid`));
