DROP DATABASE `moviedb`;
CREATE DATABASE /*!32312 IF NOT EXISTS*/ `moviedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `moviedb`;
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `id` varchar(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `year` int NOT NULL,
  `director` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `stars`;
CREATE TABLE `stars` (
  `id` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `birthYear` int,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `stars_in_movies`;
CREATE TABLE `stars_in_movies` (
  `starId` varchar(10) NOT NULL,
  `movieId` varchar(10) NOT NULL,
  KEY `fk_stars_in_movies_starId` (`starId`),
  CONSTRAINT `fk_stars_in_movies_starId` FOREIGN KEY (`starId`) REFERENCES `stars` (`id`),
  KEY `fk_stars_in_movies_movieId` (`movieId`),
  CONSTRAINT `fk_stars_in_movies_movieId` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`)
);


DROP TABLE IF EXISTS `genres`;
CREATE TABLE `genres` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `genres_in_movies`;
CREATE TABLE `genres_in_movies` (
  `genreId` int NOT NULL,
  `movieId` varchar(10) NOT NULL,
  KEY `fk_genres_in_movies_genreId` (`genreId`),
  CONSTRAINT `fk_genres_in_movies_genreId` FOREIGN KEY (`genreId`) REFERENCES `genres` (`id`),
  KEY `fk_genres_in_movies_movieId` (`movieId`),
  CONSTRAINT `fk_genres_in_movies_movieId` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`)
);

DROP TABLE IF EXISTS `creditcards`;
CREATE TABLE `creditcards` (
  `id` varchar(20) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  expiration date NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `ccId` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
   `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customers_ccId` (`ccId`),
  CONSTRAINT `fk_customers_ccId` FOREIGN KEY (`ccId`) REFERENCES `creditcards` (`id`)
);


DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
   `movieId` varchar(10) NOT NULL,
  `saleDate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sales_customerId` (`customerId`),
  CONSTRAINT `fk_sales_customerId` FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`),
  KEY `fk_sales_movieId` (`movieId`),
  CONSTRAINT `fk_sales_movieId` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`)
);

DROP TABLE IF EXISTS `ratings`;
CREATE TABLE `ratings` (
   `movieId` varchar(10) NOT NULL,
   `rating` float NOT NULL,
   `numVotes` int NOT NULL,
  KEY `fk_ratings_movieId` (`movieId`),
  CONSTRAINT `fk_ratings_movieId` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`)
);