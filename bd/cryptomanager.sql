--
-- Base de datos: `cryptomanager`
--

drop database if exists cryptomanager;
create database cryptomanager;
use cryptomanager;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crypto`
--

CREATE TABLE crypto(
  id varchar(20),
  symbol varchar (10),
  currentPrice decimal(22,15),
  PRIMARY KEY (id)); 

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE users (
  userName varchar(15),
  userPassword varchar(20) DEFAULT NULL,
  email varchar(255) not null,
  PRIMARY KEY (username)); 

-- 
-- Estructura de tabl para la tabla `monedero`
-- 

CREATE TABLE wallet (
	id int unsigned not null,
	userName varchar(15) NOT NULL,
    totalEUR decimal(20,2),
    PRIMARY KEY (id),
	FOREIGN KEY (userName) references users(userName)); 

-- --------------------------------------------------------

-- 
-- Estructura de tabl para la tabla `monedero`
-- 

CREATE TABLE Transactions(
id int auto_increment,
transactionDate Date,
currency varchar(20),
amount decimal(22,15),
userName varchar(15),
PRIMARY KEY (id),
FOREIGN KEY (currency) REFERENCES crypto (id),
FOREIGN KEY (userName) REFERENCES users(userName));

