CREATE DATABASE  IF NOT EXISTS `pollock` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci */;
USE `pollock`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pollock
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `idAutor` varchar(6) COLLATE utf8_spanish2_ci NOT NULL,
  `nombres` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidos` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `idPais` varchar(3) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idAutor`),
  KEY `FK_Autor_Pais` (`idPais`),
  CONSTRAINT `FK_Autor_Pais` FOREIGN KEY (`idPais`) REFERENCES `pais` (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calificacion` (
  `puntaje` int(11) NOT NULL,
  `idObra` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `idUsuario` varchar(6) COLLATE utf8_spanish2_ci NOT NULL,
  UNIQUE KEY `U_Calificacion_idObra` (`idObra`),
  UNIQUE KEY `U_Calificacion_idUsuario` (`idUsuario`),
  CONSTRAINT `FK_Calificacion_Obra` FOREIGN KEY (`idObra`) REFERENCES `obra` (`idObra`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Calificacion_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra`
--

DROP TABLE IF EXISTS `obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obra` (
  `idObra` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_spanish2_ci NOT NULL,
  `imagen` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `idAutor` varchar(6) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idObra`),
  UNIQUE KEY `U_Obra_Nombre` (`nombre`),
  KEY `FK_Obra_Autor` (`idAutor`),
  CONSTRAINT `FK_Obra_Autor` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obra`
--

LOCK TABLES `obra` WRITE;
/*!40000 ALTER TABLE `obra` DISABLE KEYS */;
/*!40000 ALTER TABLE `obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `idPais` varchar(3) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES ('ABW','Aruba'),('AFG','Afganistán'),('AGO','Angola'),('AIA','Anguila'),('ALA','Islas de Åland'),('ALB','Albania'),('AND','Andorra'),('ANT','Antillas Neerlandesas'),('ARE','Emiratos Árabes Unidos'),('ARG','Argentina'),('ARM','Armenia'),('ASM','Samoa Americana'),('ATA','Antártida'),('ATF','Territorios Australes y Antárticas Franceses'),('ATG','Antigua y Barbuda'),('AUS','Australia'),('AUT','Austria'),('AZE','Azerbayán'),('BDI','Burundi'),('BEL','Bélgica'),('BEN','Benín'),('BFA','Burkina Faso'),('BGD','Bangladesh'),('BGR','Bulgaria'),('BHR','Bahrein'),('BHS','Bahamas'),('BIH','Bosnia y Herzegovina'),('BLM','San Bartolomé'),('BLR','Bielorrusia'),('BLZ','Belice'),('BMU','Islas Bermudas'),('BOL','Bolivia'),('BRA','Brasil'),('BRB','Barbados'),('BRN','Brunéi'),('BTN','Bhután'),('BVT','Isla Bouvet'),('BWA','Botsuana'),('CAF','República Centroafricana'),('CAN','Canadá'),('CCK','Islas Cocos (Keeling)'),('CIV','Costa de Marfil'),('CMR','Camerún'),('COD','Congo'),('COG','Congo'),('COK','Islas Cook'),('COL','Colombia'),('COM','Comoras'),('CPV','Cabo Verde'),('CRI','Costa Rica'),('CUB','Cuba'),('CXR','Isla de Navidad'),('CYM','Islas Caimán'),('CYP','Chipre'),('CZE','República Checa'),('CHE','Suiza'),('CHL','Chile'),('CHN','China'),('DEU','Alemania'),('DJI','Yibuti'),('DMA','Dominica'),('DNK','Dinamarca'),('DOM','República Dominicana'),('DZA','Algeria'),('ECU','Ecuador'),('EGY','Egipto'),('ERI','Eritrea'),('ESH','Sahara Occidental'),('ESP','España'),('EST','Estonia'),('ETH','Etiopía'),('FIN','Finlandia'),('FJI','Fiyi'),('FLK','Islas Malvinas'),('FRA','Francia'),('FRO','Islas Feroe'),('FSM','Micronesia'),('GAB','Gabón'),('GBR','Reino Unido'),('GEO','Georgia'),('GGY','Guernsey'),('GHA','Ghana'),('GIB','Gibraltar'),('GIN','Guinea'),('GLP','Guadalupe'),('GMB','Gambia'),('GNB','Guinea-Bissau'),('GNQ','Guinea Ecuatorial'),('GRC','Grecia'),('GRD','Granada'),('GRL','Groenlandia'),('GTM','Guatemala'),('GUF','Guayana Francesa'),('GUM','Guam'),('GUY','Guyana'),('HKG','Hong kong'),('HMD','Islas Heard y McDonald'),('HND','Honduras'),('HRV','Croacia'),('HTI','Haití'),('HUN','Hungría'),('IDN','Indonesia'),('IMN','Isla de Man'),('IND','India'),('IOT','Territorio Británico del Océano Índico'),('IRL','Irlanda'),('IRN','Irán'),('IRQ','Irak'),('ISL','Islandia'),('ISR','Israel'),('ITA','Italia'),('JAM','Jamaica'),('JEY','Jersey'),('JOR','Jordania'),('JPN','Japón'),('KAZ','Kazajistán'),('KEN','Kenia'),('KGZ','Kirgizstán'),('KHM','Camboya'),('KIR','Kiribati'),('KNA','San Cristóbal y Nieves'),('KOR','Corea del Sur'),('KWT','Kuwait'),('LAO','Laos'),('LBN','Líbano'),('LBR','Liberia'),('LBY','Libia'),('LCA','Santa Lucía'),('LIE','Liechtenstein'),('LKA','Sri lanka'),('LSO','Lesoto'),('LTU','Lituania'),('LUX','Luxemburgo'),('LVA','Letonia'),('MAC','Macao'),('MAF','San Martín (Francia)'),('MAR','Marruecos'),('MCO','Mónaco'),('MDA','Moldavia'),('MDG','Madagascar'),('MDV','Islas Maldivas'),('MEX','México'),('MHL','Islas Marshall'),('MKD','Macedônia'),('MLI','Mali'),('MLT','Malta'),('MMR','Birmania'),('MNE','Montenegro'),('MNG','Mongolia'),('MNP','Islas Marianas del Norte'),('MOZ','Mozambique'),('MRT','Mauritania'),('MSR','Montserrat'),('MTQ','Martinica'),('MUS','Mauricio'),('MWI','Malawi'),('MYS','Malasia'),('MYT','Mayotte'),('NAM','Namibia'),('NCL','Nueva Caledonia'),('NER','Niger'),('NFK','Isla Norfolk'),('NGA','Nigeria'),('NIC','Nicaragua'),('NIU','Niue'),('NLD','Países Bajos'),('NOR','Noruega'),('NPL','Nepal'),('NRU','Nauru'),('NZL','Nueva Zelanda'),('OMN','Omán'),('PAK','Pakistán'),('PAN','Panamá'),('PCN','Islas Pitcairn'),('PER','Perú'),('PHL','Filipinas'),('PLW','Palau'),('PNG','Papúa Nueva Guinea'),('POL','Polonia'),('PRI','Puerto Rico'),('PRK','Corea del Norte'),('PRT','Portugal'),('PRY','Paraguay'),('PSE','Palestina'),('PYF','Polinesia Francesa'),('QAT','Qatar'),('REU','Reunión'),('ROU','Rumanía'),('RUS','Rusia'),('RWA','Ruanda'),('SAU','Arabia Saudita'),('SDN','Sudán'),('SEN','Senegal'),('SGP','Singapur'),('SGS','Islas Georgias del Sur y Sandwich del Sur'),('SHN','Santa Elena'),('SJM','Svalbard y Jan Mayen'),('SLB','Islas Salomón'),('SLE','Sierra Leona'),('SLV','El Salvador'),('SMR','San Marino'),('SOM','Somalia'),('SPM','San Pedro y Miquelón'),('SRB','Serbia'),('STP','Santo Tomé y Príncipe'),('SUR','Surinám'),('SVK','Eslovaquia'),('SVN','Eslovenia'),('SWE','Suecia'),('SWZ','Swazilandia'),('SYC','Seychelles'),('SYR','Siria'),('TCA','Islas Turcas y Caicos'),('TCD','Chad'),('TGO','Togo'),('THA','Tailandia'),('TJK','Tadjikistán'),('TKL','Tokelau'),('TKM','Turkmenistán'),('TLS','Timor Oriental'),('TON','Tonga'),('TTO','Trinidad y Tobago'),('TUN','Tunez'),('TUR','Turquía'),('TUV','Tuvalu'),('TWN','Taiwán'),('TZA','Tanzania'),('UGA','Uganda'),('UKR','Ucrania'),('UMI','Islas Ultramarinas Menores de Estados Unidos'),('URY','Uruguay'),('USA','Estados Unidos de América'),('UZB','Uzbekistán'),('VAT','Ciudad del Vaticano'),('VCT','San Vicente y las Granadinas'),('VEN','Venezuela'),('VG','Islas Vírgenes Británicas'),('VIR','Islas Vírgenes de los Estados Unidos'),('VNM','Vietnam'),('VUT','Vanuatu'),('WLF','Wallis y Futuna'),('WSM','Samoa'),('YEM','Yemen'),('ZAF','Sudáfrica'),('ZMB','Zambia'),('ZWE','Zimbabue');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_usuario`
--

DROP TABLE IF EXISTS `tipos_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipos_usuario` (
  `idTipoUsuario` varchar(1) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idTipoUsuario`),
  UNIQUE KEY `U_Pais_Nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_usuario`
--

LOCK TABLES `tipos_usuario` WRITE;
/*!40000 ALTER TABLE `tipos_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` varchar(6) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(60) COLLATE utf8_spanish2_ci NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `password` varchar(300) COLLATE utf8_spanish2_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `tipoUsuario` varchar(1) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `U_Usuario_Correo` (`correo`),
  KEY `FK_Usuario_TipoUsuario` (`tipoUsuario`),
  CONSTRAINT `FK_Usuario_TipoUsuario` FOREIGN KEY (`tipoUsuario`) REFERENCES `tipos_usuario` (`idTipoUsuario`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-03 20:21:42
