-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2021 a las 12:16:46
-- Versión del servidor: 5.6.15-log
-- Versión de PHP: 5.4.24



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

CREATE TABLE IF NOT EXISTS `crypto` (
  `id` int unsigned auto_increment,
  `nombre` varchar(20) NOT NULL,
  `precio_actual` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*
03/06/2021
se ha añadido la columna id y la primary key ahora es la id en vez de el nombre
*/

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int unsigned auto_increment,
  `usuario` varchar(15) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(255) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*
03/06/2021
se ha añadido la columna id y la primary key ahora es la id en vez de el nombre
04/06/2021
Se ha añadido la columna email
*/

-- 
-- Estructura de tabl para la tabla `monedero`
-- 

CREATE TABLE IF NOT EXISTS `monedero` (
	`id_usuario` int unsigned not null,
    `id_crypto` int unsigned not null,
    `cantidad_en_monedero` decimal(20,10),
    PRIMARY KEY (`cantidad_en_monedero`),
    CONSTRAINT monedero_ibfk_1 FOREIGN KEY (`id_usuario`) references `usuario`(`id`),
    CONSTRAINT monedero_ibfk_2 FOREIGN KEY (`id_crypto`) REFERENCES `crypto`(`id`)
); 
/*
03/06/2021
Se ha creado la tabla monedero, y se le han añadido foreign keys referenciando las tablas: (id, crypto)
*/

-- --------------------------------------------------------

-- 
--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `password`) VALUES
('pruebas', 'pruebas');



select * from usuario;
