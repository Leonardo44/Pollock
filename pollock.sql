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
INSERT INTO `autor` VALUES ('A0001','Jackson','Pollock','1956-08-11','USA'),('A0002','Diego','Velásquez','1599-06-05','ESP'),('A0003','Pablo','Picasso','1881-10-25','ESP'),('A0004','Vincent','van Gogh','1983-07-29','NLD'),('A0005','Claude','Monet','1840-10-14','FRA'),('A0006','Salvador','Dalí','1904-05-11','ESP'),('A0007','Leonardo','da Vinci','1452-04-15','ITA'),('A0008','Rembrandt','Harmenszoon van Rijn','1606-07-15','NLD'),('A0009','Francisco','de Goya y Lucientes','1756-03-30','ESP'),('A0010','Pierre-Auguste','Renoir','1841-02-25','FRA');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idComentario` int(11) NOT NULL AUTO_INCREMENT,
  `texto` mediumtext COLLATE utf8_spanish2_ci NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idObra` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idComentario`),
  KEY `FK_Comentario_Obra` (`idObra`),
  CONSTRAINT `FK_Comentario_Obra` FOREIGN KEY (`idObra`) REFERENCES `obra` (`idObra`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obra`
--

DROP TABLE IF EXISTS `obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obra` (
  `idObra` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` longtext COLLATE utf8_spanish2_ci NOT NULL,
  `imagen` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `calificacion` decimal(10,2) DEFAULT '0.00',
  `idAutor` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
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
INSERT INTO `obra` VALUES ('O0001','Postes Azules','En el origen de esta idea se encuentra una revolución moral: en una sociedad que acepta el genocidio, los campos de exterminio y la bomba atómica, no son posibles los actos de creación. La guerra se había convertido en el aspecto culminante de la destrucción sistemática y organizada, en un hacer para destruir dentro de una sociedad que se autodefine como de consumo. Un arte que se consume al disfrutarlo, puede ser arte o no serlo, pero en cualquier caso será totalmente distinto de todo el arte del pasado. Lo Informal es una situación de crisis: se renuncia al lenguaje para reducirlo a puro acto.','O0001.jpg',3.60,'A0001'),('O0002','Las Meninas','El tema central es el retrato de la infanta Margarita de Austria, colocada en primer plano, rodeada por sus sirvientes, \n«las meninas», aunque la pintura representa también otros personajes. En el lado izquierdo se observa parte de un gran lienzo, \ny detrás de este el propio Velázquez se autorretrata trabajando en él. El artista resolvió con gran habilidad todos los problemas \nde composición del espacio, gracias al dominio que tenía del color y a la gran facilidad para caracterizar a los personajes. \nEl punto de fuga de la composición se encuentra cerca del personaje que aparece al fondo abriendo una puerta, donde la colocación \nde un foco de luz demuestra, de nuevo, la maestría del pintor, que consigue hacer recorrer la vista de los espectadores por toda \nsu representación. Un espejo colocado al fondo refleja las imágenes del rey Felipe IV y su esposa Mariana de Austria, medio del \nque se valió el pintor para dar a conocer ingeniosamente lo que estaba pintando, según Palomino, aunque algunos historiadores han \ninterpretado que se trataría del reflejo de los propios reyes entrando a la sesión de pintura o, según otros, posando para ser \nretratados por Velázquez: en este caso, la infanta Margarita y sus acompañantes estarían visitando al pintor en su taller','O0002.jpg',5.00,'A0002'),('O0003','Guernica','En la década de 1940, puesto que en España se había instaurado la dictadura militar del general Franco, Picasso optó por dejar que el cuadro fuese custodiado por el Museo de Arte Moderno de Nueva York, aunque expresó su voluntad de que fuera devuelto a España cuando volviese al país la democracia. En 1981 la obra llegó finalmente a España. Se expuso al público primero en el Casón del Buen Retiro, y luego, desde 1992, en el Museo Reina Sofía de Madrid, donde se encuentra en exhibición permanente.\n\nSu interpretación en profundidad es objeto de controversia, ya que varias figuras son simbólicas y suscitan opiniones dispares; pero su valor artístico está fuera de discusión. No solo es considerado una de las obras más importantes del arte del siglo XX, sino que se ha convertido en un auténtico \"icono del siglo XX\", símbolo de los terribles sufrimientos que la guerra inflige a los seres humanos.','O0003.jpg',0.00,'A0003'),('O0004','La Noche Estrellada','Es la obra maestra del pintor postimpresionista Vincent van Gogh. El cuadro lo realizó en el sanatorio Saint-Rémy-de-Provence, donde se recluyó hacia el final de su vida. Fue pintada a mediados de 1889, trece meses antes de la muerte de van Gogh. Desde 1941 forma parte de la colección permanente del Museo de Arte Moderno de Nueva York. Considerado como el magnum opus de van Gogh, el cuadro ha sido reproducido en numerosas ocasiones y es conocida como una de las pinturas mas famosas de la historia. Usó óleo humedecido y pinceles finos para realizar la obra.','O0004.jpg',0.00,'A0004'),('O0005','Lirios','Los lirios fueron una de las primeras obras realizadas mientras Vincent van Gogh vivía en el asilo del Monasterio de Saint-Paul-de-Mausole en Saint-Rémy-de-Provence, Francia, en el último año antes de su muerte en 1890.\n\nLo pintó antes de su primer ataque en el asilo. Falta la alta tensión que se ve en sus obras posteriores. Llamó a la pintura \"el pararrayos para mi enfermedad\" porque sentía que podía evitar volverse loco al seguir pintando.\n\nLa obra está influenciada por el patrón decorativo de las impresiones xilográficas japonesas ukiyo-e, como muchas de sus obras y las de otros artistas de su época. Las semejanzas se presentan con los bordes bien definidos, puntos de vista inusuales, incluyendo vistas en primer plano, de cerca. El color es aplanado, no modelado de acuerdo con la caída de la luz, aplicando los consejos proporcionados por Paul Gauguin sobre las tonalidades del color.\n\nEl artista consideraba a esta pintura un estudio, y es así, probablemente, porque no hay dibujos conocidos de ella, aunque Theo, su hermano, se lo pensó mejor y rápidamente presentó la obra a la exposición anual de la Société des Artistes Indépendants en septiembre de 1889, junto con Noche estrellada sobre el Ródano. Sobre la exposición, le escribió a Vicente: \"Saltan a la vista desde lejos. Los lirios son un hermoso estudio lleno de aire y vida.','O0005.jpg',0.00,'A0004'),('O0006','Jirafa en Llamas','El primer cuadro donde aparecen la jirafas en llamas es La invención de los monstruos, un óleo sobre tela que empezó a pintar en su taller de la calle Tombe-Issoire de París y que terminó en la estación de esquí de Semmering, cerca de Viena. Mientras Dalí estaba trabajando en esta tela, premonitoria de la Guerra Mundial, se produjo el trágico accidente del dirigible alemán Hindenburg en Lakehurst, Nueva Jersey, EEUU. Esta noticia dio la vuelta al mundo y pronto los periódicos reflejarían las escalofriantes imágenes de la aeronave en llamas. Según la teoría del historiador de arte Linus Klumpner, Dalí fuertemente impresionado por las imágenes que vio publicadas del zepelín incendiado al lado del embarcador, aplicó su método paranoico-crítico y lo transformó en las jirafas en llamas que el mismo pintor calificó como una representación de los monstruos del apocalipsis.\n\nOtra obra donde aparece la jirafa es la titulada Jirafa en llamas que según Dalí también era una premonición de la inminente Segunda Guerra Mundial.','O0006.jpg',0.00,'A0006'),('O0007','Aníbal vencedor contempla por primera vez Italia desde los Alpes','La composición inicial pudo inspirarse en el bajorrelieve de José Arias, La construcción del puente de Alcántara en Toledo que el autor había presentado en 1766 al concurso de segunda clase de escultura convocado por la Real Academia de San Fernando, y que obtuvo el primer premio de su categoría. En este concurso, en la modalidad de pintura tomó Goya parte tembién, por lo que es muy probable que el aragonés hubiera tomado apuntes del relieve de Arias que luego reutilizó en el diseño del personaje de Aníbal (enormemente coincidente, incluso en la postura con el Trajano que centra la composición del escultor) y en las líneas generales de la composición del cuadro.\n\nEn cuanto al cromatismo, dominan los azules suaves, los rosas y el gris perla, lo que se ha visto como expresión del carácter clásico e irreal de la escena, que adquiere así tintes heroicos.','O0007.jpg',0.00,'A0009');
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
INSERT INTO `tipos_usuario` VALUES ('B','Bibliotecario','Posee el acceso total a la aplicacion'),('U','Usuario','Posee el acceso total a las obras');
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
  `username` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `password` varchar(300) COLLATE utf8_spanish2_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `tipoUsuario` varchar(1) COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `U_Usuario_Username` (`username`),
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
INSERT INTO `usuario` VALUES ('B0001','Jasson Alexander','Lopez Soriano','jasson_alex99@hotmail.com','1999-07-10','B0001','84472/74362/10143*109123-112163-66282!80432/72342*',1,'B'),('B0002','Franklin Armando','Esquivel Guevara','franklin.esquivel@outlook.com','1998-10-09','B0002','50a2*48e2/49l2!53L2!48e2!49l2*50a2/54F2*',1,'B'),('U0003','Diego Alberto','Lemus Torres','ciegolem7@gmail.es','1998-09-18','U0003','57p2!121253-10473/66282/76382*51y2*88512-9702/',1,'U'),('U0004','Marta Carolina','Rosado Pérez','marta.rope@gmail.com','1998-08-12','U0004','10693-51y2*56o2/65272-68302-115193!111153!10363!',1,'U'),('U0005','Leonarlo Elenilson','Lopez Cañas','lopezleonardo44@gmail.com','1999-04-09','U0005','75372-10693-66282/116203-84472!49l2/70322-56o2!',1,'U');
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

-- Dump completed on 2018-04-11  2:20:59
