-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: miguel84_mento
-- ------------------------------------------------------
-- Server version	5.6.31-log

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
-- Table structure for table `tbl_course`
--

DROP TABLE IF EXISTS `tbl_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_course` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HIERARCHY_ID` int(11) DEFAULT NULL,
  `NAME` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RESUME` text COLLATE utf8_spanish_ci,
  `PROFILE` text COLLATE utf8_spanish_ci,
  `DESCRIPTION` text COLLATE utf8_spanish_ci,
  `ALIAS` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CONTENT` text COLLATE utf8_spanish_ci,
  `RANKING` smallint(6) DEFAULT NULL,
  `PUBLISHED_PRICE` decimal(10,0) DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_7` (`HIERARCHY_ID`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`HIERARCHY_ID`) REFERENCES `tbl_mentoring_hyerarchy` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_course`
--

LOCK TABLES `tbl_course` WRITE;
/*!40000 ALTER TABLE `tbl_course` DISABLE KEYS */;
INSERT INTO `tbl_course` VALUES (14,24,'Java desde cero','Es un curso orientado a aquellos que se quieren iniciar en el uso de java como lenguaje de programación de aplicaciones WEB y de escritorio.','Se recomienda que el alumno tenga conocimientos en lógica de programación para que aproveche mejor el contenido del curso.','<h3>30 Horas.  6 Sábados de 9:00 a 2:00 pm y de 2:30 a 6:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nEntorno de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Eclipse Ultima version</li>\r\n</ol>\r\n\r\n<ul>\r\n  <li>\r\ncompilador: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>      Java SE 7</li>\r\n</ol>\r\n<br />\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo.\r\n\r\n','Curso Java desde cero','<ul>\r\n	<li>Modulo 1:</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Visi&oacute;n general de java como lenguaje de programaci&oacute;n y plataforma de desarrollo.</li>\r\n	<li>Java Runtime Environment (la maquina virtual de java) y la administraci&oacute;n de memoria (Garbage Collector).</li>\r\n	<li>Vistas y Perspectivas de Eclipse.</li>\r\n	<li>Visi&oacute;n general Maven 3.0 (que es y para que sirve) y creaci&oacute;n de proyecto standalone.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 2:</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Conceptos de programaci&oacute;n orientada a objetos.</li>\r\n	<li>Palabras reservadas, control de flujo, tipos de datos y arreglos.</li>\r\n	<li>Modificadores de acceso (private, protected, public).</li>\r\n	<li>Operadores l&oacute;gicos, relacionales y aritm&eacute;ticos.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 3</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Dise&ntilde;o de clases y caracter&iacute;sticas avanzadas de clases.</li>\r\n	<li>Herencia, Interfaces y Polimorfismo.</li>\r\n	<li>Sobrecarga (constructores) y sobre-escritura (m&eacute;todos y constructores).</li>\r\n	<li>Tratamiento de excepciones.</li>\r\n	<li>Colecciones y Gen&eacute;ricos.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 4</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Acceso a base de datos con JDBC.</li>\r\n	<li>Statements vs PreparedStatements.</li>\r\n	<li>Patrones de dise&ntilde;o Singleton, DAO&#39;S, DTO&#39;S.</li>\r\n	<li>Pruebas Unitarias con JUnit 4 y aserciones.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 5</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Conceptos b&aacute;sicos de flujos de entrada y salida a consola y archivos.</li>\r\n	<li>Introducci&oacute;n a SWING.</li>\r\n	<li>Construcci&oacute;n de interfaces graficas con Window Builder plugin.</li>\r\n	<li>Layouts de contenedores y&nbsp;uso de Paneles, Menus y Grids.</li>\r\n	<li>Implementaci&oacute;n de Slog4j.</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n',5,5500,1),(16,26,'PHP & MySQL desde cero','Curso orientado a quienes inician en el desarrollo de aplicaciones Web, PHP es una opción bastante efectiva en la construcción rápida de paginas Web dinámicas, actualmente es orientado a objetos, cuenta con una amplia cantidad de Frameworks y su uso en Internet es dominante respecto a otras tecnologías. PHP es un lenguaje indispensable para el desarrollo web.','Se requiere conocimientos básicos de programación.','<h3>30 Horas. Modalidad en Sabatino y Modalidad de Lunes a Viernes</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Dream Weaver / Eclipse  </li>\r\n</ol>\r\n\r\n<ul>\r\n  <li>\r\ncompilador: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>      APP Server / WAMP ultima versión</li>\r\n</ol>\r\n<br />\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo.\r\n','Curso PHP & MySQL desde cero','<ul>\r\n	<li>M&oacute;dulo 1:&nbsp; Visi&oacute;n general de PHP</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Revisi&oacute;n general de aplicaciones Web.</li>\r\n	<li>Caracteristicas principales de PHP</li>\r\n	<li>PHP vs Otras tecnologias Web.</li>\r\n	<li>Instalaci&oacute;n de servidor e ambiente integrado de desarrollo IDE</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 2: Primeros pasos en PHP</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Estructura b&aacute;sica de un programa en PHP</li>\r\n	<li>Documento HTML y su estructura b&aacute;sica.</li>\r\n	<li>Sintaxis PHP, variables, funciones, comentarios</li>\r\n	<li>Estructuras de control (if,while, for, switch) y operadores l&oacute;gicos</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 3: Formularios</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Envio de informaci&oacute;n al sevidor por formularios</li>\r\n	<li>Validaci&oacute;n de campos de entrada (email, tel&eacute;fono, etc)</li>\r\n	<li>Uso de librerias y hojas de estilo.</li>\r\n	<li>Validaci&oacute;n y formateo de fechas</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 4: PHP Orientado a objetos</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Clases y Objetos</li>\r\n	<li>Sobrecarca y sobre escritura de m&eacute;todos</li>\r\n	<li>Patrones de dise&ntilde;o (DAO, VO, Singleton)</li>\r\n	<li>Herencia y Polimorfismo</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 5: Integraci&oacute;n PHP - MySQL</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Altas, bajas, cambios y consultas a base de datos con PHP</li>\r\n	<li>Creaci&oacute;n de listas, menus y tablas</li>\r\n	<li>Autenticaci&oacute;n de aplicaci&oacute;n WEB a base de datos</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 6: Creaci&oacute;n de Aplicaci&oacute;n del curso</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Manejo de Sesiones</li>\r\n	<li>Manejo de usuarios autenticados</li>\r\n	<li>Navegaci&oacute;n WEB con menus</li>\r\n	<li>Integraci&oacute;n de widgets Jquery (Calendar, Table, ComboBox)</li>\r\n</ol>\r\n',1,4500,1),(18,33,'Java  Web Services ','La interoperabilidad de aplicaciones frente a diferentes dispositivo y plataformas obliga al desarrollo de software a la búsqueda de soluciones para la comunicación estándar, la mejor solución esta en los WebServices y Java ofrece API\'s muy potentes para su desarrollo rápido, en este curso te especializamos en JAX-WS y Apache Axis. ','Se recomiendan conocimientos básicos de J2SE, aplicaciones WEB y XML.','<h3>30 Horas. 6 Sábados de 9:00 a 2:00 pm</h3>\r\n<ul>Las herramientas utilizadas en el curso son:</ul>\r\n<ol>\r\n<li>Eclipse Version Kepler.</li>\r\n<li>Apache Axis 2 y JAX-WS.</li>\r\n<li>MySQL 5.1. (Motor de base de datos).</li>\r\n<li>J2EE</li>\r\n</ol>		','Curso Java WebServices','<ul>\r\n	<li>Modulo 1\r\n	<ol>\r\n		<li>&iquest;Que son los WebServices?</li>\r\n		<li>Conceptos&nbsp;XML, SOA, SOAP, WSDL, UDDI</li>\r\n		<li>Tipos de WebServices y cual me conviene utilizar.</li>\r\n	</ol>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li>Modulo 2\r\n	<ol>\r\n		<li>Visi&oacute;n general de Apache Axis 2 y JAX-WS.</li>\r\n		<li>Construyendo WebServices JAX-WS, JAX-RS,&nbsp;RestFul.</li>\r\n		<li>WebServices desde Java &amp; WebService&nbsp;&nbsp;desde WSDL.</li>\r\n		<li>Respondiendo con datos formato JSON.</li>\r\n	</ol>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li>Modulo 3</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>WebServices e integraci&oacute;n con JAXB.</li>\r\n	<li>Web Services con Apache Axis 2.</li>\r\n	<li>Deploy de WebServices.</li>\r\n	<li>Construcci&oacute;n&nbsp;de clientes WebServices.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 4</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Invocando WebServices desde JAVA y PHP.</li>\r\n	<li>Invocaci&oacute;n de WebServices con SOAP UI.</li>\r\n	<li>Pool de pruebas &amp; stress testcase con SOAP UI.</li>\r\n</ol>\r\n',5,7500,1),(19,34,'Reportes con JasperReport','Al finalizar el curso tendrás los conocimientos necesarios para crear reportes PDF y Excel dinámicos y complejos, en todos nuestros módulos realizamos ejemplos prácticos.','<ol>\r\n<li>Concomientos básicos de lógica de programación.</li>\r\n<li>Concomientos básicos en SQL.</li>\r\n</ol>','<h3>30 Horas. 6 Sábados de 9:00 a 2:00 pm</h3>\r\n<ul>Las herramientas utilizadas en el curso son:</ul>\r\n<ol>\r\n<li>IReport Designer Versión 5.</li>\r\n<li>MySQL 5.1. (Motor de báse de datos).</li>\r\n<li>Eclipse Juno (Entorno de desarrollo).</li>\r\n<li>jdk 1.7 como compilador Java.</li>\r\n</ol>','Curso Reportes PDF con JasperReport','<ul>\r\n	<li>Modulo 1</li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Visi&oacute;n general y ciclo de vida de un reporte.</li>\r\n	<li>Conociendo IReport.</li>\r\n	<li>Integraci&oacute;n con datasets y datasources.</li>\r\n	<li>Incrustando l&oacute;gica de programaci&oacute;n en los reportes.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 2</li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Qu&eacute; son y como funcionan las expresiones.</li>\r\n	<li>Agregando marcos, lineas, rect&aacute;ngulos, tablas e im&aacute;genes.</li>\r\n	<li>Secciones, sub-reportes y paginado.</li>\r\n	<li>Incrustando l&oacute;gica de programaci&oacute;n en los reportes.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 3</li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Gr&aacute;ficas y sus diferentes tipos.</li>\r\n	<li>Grupos.</li>\r\n	<li>Fuentes y Estilos.</li>\r\n	<li>Internacionalizaci&oacute;n de reportes.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 4</li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Conecci&oacute;n a base de datos desde Java (JDBC).</li>\r\n	<li>Statements y PreparedStatements.</li>\r\n	<li>DAO&#39;s y DTO&#39;s.</li>\r\n	<li>ArrayList y ResultSet.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 5</li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Envio de par&aacute;metros desde Java.</li>\r\n	<li>Obteniendo datos desde ValueObjects/DTOS.</li>\r\n	<li>Guardando reportes a disco duro.</li>\r\n	<li>Envi&oacute; de reportes al navegador.</li>\r\n</ol>\r\n',5,4500,1),(20,34,'Aplicaciones Java Web ','Al finalizar el curso tendrás conocimientos sólidos sobre como funcionan las aplicaciones WEB en Java y como estas se integran desde el navegador hasta la base de datos, el curso se termina con la el desarrollo terminado de una aplicación WEB con acceso a base de datos, la interfaz gráfica tiene soporte ajax y esta basada en EXT JS.','<ol>\r\n<li>Conocimientos básicos de Java.</li>\r\n<li>Conocimientos básicos de SQL.</li>\r\n<ol>','<h3>35 Horas. 7 Sábados de 9:00 a 2:00 pm</h3>\r\nLas herramientas utilizadas en el curso son:\r\n\r\n<ol>\r\n<li>Eclipse Última Versión (Entorno de desarrollo)</li>\r\n<li>Java EE Última Versión (Compilador y API java)</li>\r\n<li>Apache Tomcat Última Versión (Servidor de aplicaciones)</li>\r\n</ol>','Curso Java WEB','<ul>\r\n	<li><span style=\"font-size:14px\"><strong>M&oacute;dulo 1. Visi&oacute;n general de las aplicaciones WEB</strong></span></li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Introducci&oacute;n a las aplicaciones WEB y el protocolo HTTP.</li>\r\n	<li>Patr&oacute;n de Arquitectura Modelo - Vista - Controlador (MVC).</li>\r\n	<li>Servidores de aplicaciones WEB, los m&aacute;s utilizados y caracter&iacute;sticas generales.</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>M&oacute;dulo 2. Gesti&oacute;n de aplicaciones Java Web &nbsp;y sus componentes.</strong></span></li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Maven 3.0 y creaci&oacute;n de arquetipos WEB en eclipse.</li>\r\n	<li>Aplicaciones Java WEB, descriptores de despliegue.</li>\r\n	<li>Tipos de empaquetado desde Maven (war, jar).</li>\r\n	<li>Servlets&nbsp;&amp; JSP&#39;s 3.0.</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>M&oacute;dulo 3. Spring IoC y patrones de dise&ntilde;o</strong></span></li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Que es la Programaci&oacute;n en capas con&nbsp;patrones de dise&ntilde;o, DAO&#39;s, DTO&#39;s y Singleton.</li>\r\n	<li>Introducci&oacute;n a Spring y su m&oacute;dulo de IoC (Inyecci&oacute;n de Dependencias).</li>\r\n	<li>Inyecci&oacute;n de dependencias y ciclo de vida de los beans.</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">M&oacute;dulo 4. Pruebas Unitarias y bitacoreo con log4j2</span></strong></li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>JUnit 4, &nbsp;log4j y mejores pr&aacute;cticas en tratamiento de excepciones.</li>\r\n	<li>Acceso a base de datos (DAO&#39;s y DTO&#39;s).</li>\r\n	<li>Configuraci&oacute;n de pool de conexiones en el servidor.</li>\r\n	<li>Manejo de Sesiones.</li>\r\n	<li>ABC&nbsp;a base de datos desde JSP con componentes HTML.</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>M&oacute;dulo 5. Intefaces gr&aacute;ficas con HTML, JS y EXT JS</strong></span></li>\r\n</ul>\r\n\r\n<ol>\r\n	<li>Manejo de jstl y componentes JSP.</li>\r\n	<li>Integraci&oacute;n de componentes EXT-JS como interfaz gr&aacute;fica.</li>\r\n	<li>Peticiones Ajax y datos en formato JSON.</li>\r\n	<li>Integraci&oacute;n de gr&aacute;ficas de barras y l&iacute;neas.</li>\r\n</ol>\r\n',5,6000,1),(21,24,'Lógica de programación','El curso de lógica de programación esta orientado a personas que se quieren iniciar en el área de desarrollo de software o QA Tester que requieren de conocimientos básicos en programación. La programación que se realiza en este curso es completamente estructurada y se inicia desde conceptos básicos.	','<ol>\r\n<li>Interés por aprender.</li>\r\n<li>Conocimientos básicos en computación.</li>\r\n</ol>','<h3>30 Horas. 6 Sábados de 9:00 a 2:00 pm</h3>\r\n<h4>Herramientas utilizadas en el curso:</h4>	\r\n<ol>\r\n  <li>Compilador JDK 1.7.</li>\r\n  <li>Eclipse IDE Última versión estable</li>\r\n</ol>\r\n','Curso Lógica de programación','<p>Modulo 1: Fundamentos de programaci&oacute;n</p>\r\n\r\n<ul>\r\n	<li>&iquest;Que es un lenguaje de programaci&oacute;n?</li>\r\n	<li>Diagramas de flujo.</li>\r\n	<li>Lenguajes de alto nivel.</li>\r\n	<li>Herramientas de desarrollo , IDE&#39;s.</li>\r\n	<li>Instalaci&oacute;n de JDK y Eclipse.</li>\r\n</ul>\r\n\r\n<p>Modulo 2:&nbsp; Codificando nuestro primer programa.</p>\r\n\r\n<ul>\r\n	<li>Partes esenciales de un programa.</li>\r\n	<li>C&oacute;digo fuente y c&oacute;digo objeto.</li>\r\n	<li>Creando, compilando y ejecutando nuestro primer programa.</li>\r\n	<li>An&aacute;lisis detallado de la estructura y funcionamiento de un programa.</li>\r\n	<li>Debugger&nbsp; y breakpoints.</li>\r\n</ul>\r\n\r\n<p>Modulo 3:&nbsp; L&oacute;gica de Programaci&oacute;n</p>\r\n\r\n<ul>\r\n	<li>Que es una variable y para que la puedo utilizar.</li>\r\n	<li>Tipos de datos que se pueden almacenar en una variable.</li>\r\n	<li>Operaciones aritm&eacute;ticas&nbsp; y operadores de asignacion.</li>\r\n	<li>Operadores l&oacute;gicos y de comparaci&oacute;n.</li>\r\n	<li>Creando ciclos y tomando decisiones&nbsp; (if, else, switch, for, while, do while, ...).</li>\r\n</ul>\r\n\r\n<p><br />\r\nModulo 4:&nbsp; Arreglos y M&eacute;todos (funciones)</p>\r\n\r\n<ul>\r\n	<li>Que son los arreglos y como los puedo utilizar.</li>\r\n	<li>Manipulaci&oacute;n de los elementos de un arreglo.</li>\r\n	<li>Que son las funciones y ventajas de su uso.</li>\r\n	<li>Enviando par&aacute;metros a las funciones.</li>\r\n</ul>\r\n\r\n<p><br />\r\nModulo 5:&nbsp; Librerias propias y de terceros</p>\r\n\r\n<ul>\r\n	<li>Que son y como utilizar las librerias.</li>\r\n	<li>Crear nuestras propias librerias.</li>\r\n	<li>Ejecutar un programa dentro de otro programa.</li>\r\n	<li>Optimizaci&oacute;n de nuestro c&oacute;digo.</li>\r\n</ul>\r\n',5,3500,1),(22,35,'Integración Spring, Struts 2 & Hibernate','En nuestro curso se muestran las ventajas de una arquitectura robusta implementada con estos Frameworks, analizamos el cuando y como nos conviene mas implementar este tipo de arquitectura así como las ventajas sobre arquitecturas tradicionales.','Se recomienda que se tengan conocimientos basicos de Aplicaciones WEB con Java (JSP\'s y Servlets)  para que el alumno pueda apreciar y aprovechar las ventajas que le proporcionara el curso.','<h3>35 Horas. 7 Sábados de 9:00 a 2:00 pm</h3>\r\nLas herramientas utilizadas en el curso son:\r\n<ol>\r\n<li>Eclipse Kepler(Entorno de desarrollo)</li>\r\n<li>jdk 1.7 & j2EE (Compilador y API java)</li>\r\n<li>Apache Tomcat 7 (Servidor de aplicaciones)</li>\r\n<li>MySQL 5.1 (Servidor de base de datos)</li>\r\n</ol>','Curso de Spring, Struts 2 & Hibernate','<ul>\r\n	<li>M&oacute;dulo 1</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Visi&oacute;n general de los frameworks a utilizar.</li>\r\n	<li>Maven para gestionar el proyecto.</li>\r\n	<li>Creando distintos tipos de proyectos con Maven.</li>\r\n	<li>Integrando Maven y Eclipse.</li>\r\n	<li>Tareas en Maven.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo &nbsp;2</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Que es Spring y sus diferentes m&oacute;dulos.</li>\r\n	<li>Integrando Spring plugins&nbsp;en Eclipse.</li>\r\n	<li>Inyecci&oacute;n de dependencias con Spring 4.</li>\r\n	<li>Pruebas unitarias JUnit 4 &amp; Spring.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 3</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Qu&eacute; es Hibernate, ventajas y desventajas de su uso.</li>\r\n	<li>Integrando Hibernate plugins en Eclipse.</li>\r\n	<li>Creando Mapeos en Hibernate.</li>\r\n	<li>Joins, Criteria,&nbsp;Restrictions &amp; Transactions en Hibernate.</li>\r\n	<li>Integraci&oacute;n con Spring y uso de m&eacute;todos&nbsp;transaccionales.</li>\r\n	<li>Implementaci&oacute;n b&aacute;sica de AOP.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 4\r\n	<ol>\r\n		<li>Que es Struts 2 y porque nos conviene utilizar este framework.</li>\r\n		<li>Integraci&oacute;n de Struts 2 , Spring y Hibernate.</li>\r\n		<li>Creaci&oacute;n, configuraci&oacute;n e implementaci&oacute;n de&nbsp;Interceptores.</li>\r\n		<li>Integraci&oacute;n de Struts 2 y Spring.</li>\r\n	</ol>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li>Modulo 5</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Componentes JQuery.</li>\r\n	<li>Integrando JQuery y Struts 2.</li>\r\n	<li>Peticiones Ajax y manejo de informaci&oacute;n en formato JSON.</li>\r\n	<li>Paginado de datos en JQuery Grid.</li>\r\n</ol>\r\n',5,6500,1),(24,44,'Aplicaciones WEB Flex - Java','Flex es una de las herramientas mas potentes para la creación de interfaces gráficas y su integración con Java permite la creación de aplicaciones de alto desempeño tanto visual como de manipulación de grandes cantidades de datos, Flex proporciona características de usabilidad e interactividad que ninguna otra tecnología puede igualar.','Se recomienda que el alumno tenga conocimientos en lógica de programación y nociones básicas de aplicaciones WEB en cualquier lenguaje.','<h3>35 Horas.  7 Sábados de 9:00 a 2:00 pm / Lunes a Jueves de 7 a 9 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Eclipse,  Versión: Última estable</li>\r\n<li>     plugin de flex para eclipse</li>\r\n</ol>\r\n\r\n<ul>\r\n  <li>\r\nversión de compilador:\r\n</li>\r\n</ul>\r\n<ol>\r\n<li>      Java SE 7</li>\r\n<li>      Flex 3.5 y 4</li>\r\n</ol>\r\n<br />\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo.','Curso Flex Java Web Applications','<ul>\r\n	<li>Descripci&oacute;n breve de la plataforma FLASH.\r\n	<ul>\r\n		<li>Evoluci&oacute;n de la plataforma FLASH.</li>\r\n		<li>AVM2 la m&aacute;quina virtual de Flash Player para ActionScript.</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li>Explorando Flash Builder 4 como entorno de desarrollo.\r\n	<ul>\r\n		<li>Vistas de dise&ntilde;o y c&oacute;digo en Flash Builder.</li>\r\n		<li>Running de aplicaciones Flex en Flash Builder.</li>\r\n		<li>Debugging de aplicaciones locales y remotas.</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li>Componentes nativos y personalizados, distribuci&oacute;n de controles en la interfaz.\r\n	<ul>\r\n		<li>Uso de controles propios del sdk de Flex(Formularios, DataGrid, ComboBox)</li>\r\n		<li>Creaci&oacute;n de componentes personalizados.</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li>Componentes SPARK\r\n	<ul>\r\n		<li>Manejando y extendiendo eventos en FLEX.</li>\r\n		<li>Manejo de eventos de sistema y de usuario.</li>\r\n		<li>Creando y lanzando eventos personalizados.</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li>Integraci&oacute;n con datos (LCDS) en servidor de aplicaciones por medio de JAVA.\r\n	<ul>\r\n		<li>Integraci&oacute;n con JAVA por medio de Remote Objects(CRUD A DB).</li>\r\n		<li>Formateo de datos XML con E4X.</li>\r\n		<li>Mapeo Value Objects(VO) vs Data Transfer Object(DTO)</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li>Implementaci&oacute;n de estilos(CSS3).\r\n	<ul>\r\n		<li>Skinning de componentes gr&aacute;ficos.</li>\r\n		<li>Uso de CSS3.</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n',1,7500,1),(25,47,'Android aplicaciones móviles, Nivel Básico.','Proporcionamos al alumno bases sólidas en el desarrollo de aplicaciones móviles  con Android. \r\n<br/>Comenzamos el curso desde la instalación y configuración del ambiente de desarrollo y terminamos con la publicación de nuestra aplicación en Google Play.\r\n<br/>Con la finalización satisfactoria de este primer nivel en el desarrollo de aplicaciones móviles el alumno ya es capaz de continuar el desarrollo en esta plataforma por su cuenta, o si lo desea continuar con los niveles intermedio y avanzado de nuestros cursos de aplicaciones Android.','Conocimientos previos en Java Básico.','<h3>30 Horas.  6 Sábados de 9:00 a 2:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Android Studio (última versión estable)</li>\r\n</ol>\r\n\r\n<ul>\r\n  <li>\r\ncompilador: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>      SDK (Ultima versión estable) </li>\r\n</ol>\r\n<br />\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo.','Curso desarrollo Android aplicaciones móviles, Nivel Básico.','<ul>\r\n	<li>Modulo 1: El desarrollo m&oacute;vil y la plataforma Android.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Tendencias del desarrollo m&oacute;vil y caracter&iacute;sticas de Android.</li>\r\n	<li>Android Studio y recursos de desarrollo.</li>\r\n	<li>Instalaci&oacute;n y administraci&oacute;n de SDK.</li>\r\n	<li>Compatibilidad de versiones y dispositivos.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 2:&nbsp;Iniciando con nuestra aplicaci&oacute;n del curso.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Desarrollo y pruebas en emuladores y en nuestros dispositivos.</li>\r\n	<li>Carpetas, distribuci&oacute;n y tipos de recursos de nuestra aplicaci&oacute;n.</li>\r\n	<li>M&uacute;ltiples pantallas en la aplicaci&oacute;n (Activities y Layouts).</li>\r\n	<li>Soporte de nuestra aplicaci&oacute;n para m&uacute;ltiples pantallas.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 3:&nbsp;Interacci&oacute;n del usuario con nuestra aplicaci&oacute;n.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Eventos de usuario y de sistema.</li>\r\n	<li>Manejo de eventos.</li>\r\n	<li>Uso de ActionBar y Menus.</li>\r\n	<li>Navegaci&oacute;n con ActionBar y Dispositivo.</li>\r\n	<li>Despliegue de datos e im&aacute;genes utilizando diferentes layouts.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 4:&nbsp;Componentes gr&aacute;ficos en Android.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Uso de estilos en componentes visuales.</li>\r\n	<li>EditText, Etiquetas, botones, ListView, etc.</li>\r\n	<li>Uso de la c&aacute;mara de nuestro dispositivo.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 5:&nbsp;Almacenando, editando y eliminando contactos de nuestra agenda.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Almacenamiento de datos en el dispositivo.</li>\r\n	<li>Shared Preferences, SQLite y archivos.</li>\r\n	<li>Modelado de datos (DAO, DTO, DataSource).</li>\r\n	<li>Notificaciones y configuraci&oacute;n de la aplicaci&oacute;n.</li>\r\n	<li>Integraci&oacute;n de c&aacute;mara y Servicios de e-mail.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 6:&nbsp;Distribuci&oacute;n de la aplicaci&oacute;n en Play Store.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Certificaci&oacute;n y empaquetado.</li>\r\n	<li>Configuraci&oacute;n de idioma.</li>\r\n	<li>Recursos gr&aacute;ficos.</li>\r\n	<li>Informaci&oacute;n de contacto.</li>\r\n</ol>\r\n',5,4500,1),(26,50,'Python desde cero','Python es un lenguaje fácil de utilizar y muy poderoso. Tiene un alto nivel de estructura en el lenguaje y un muy efectivo enfoque de la programación orientada a objetos. Es un lenguaje de escritura muy elegante y tipeado dinámico, permite el desarrollo de aplicaciones de forma rápida gracias a su naturaleza de scripting.','Pueden aprender Python programadores experimentados en otros lenguajes, se sugiere que se tengan bases de programación orientada a objetos.','<h3>30 Horas.  6 Sábados de 9:00 a 2:00 pm y de 2:30 a 6:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li> Ninja-IDE </li>\r\n</ol>','Curso Python desde cero','<ul>\r\n	<li>M&oacute;dulo 1: Introducci&oacute;n.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&iquest;Qu&eacute; es Python?<br />\r\nLenguajes interpretados vs compilados.<br />\r\nVersiones de Python.<br />\r\nInstalaci&oacute;n y configuraci&oacute;n de Python 2.7.<br />\r\nShell interactiva.<br />\r\nExtensiones &ldquo;.PY&ldquo; y .&rdquo;PYC&rdquo;.<br />\r\nEditores de texto e IDE.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 2: Estructura y elementos del lenguaje.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Variables.<br />\r\nTipos de datos.<br />\r\nOperadores.<br />\r\nComentarios.<br />\r\nTipos de datos complejos (tuplas, listas, diccionarios).<br />\r\nEstructuras de control de flujo.<br />\r\nFunciones.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 3: Programaci&oacute;n orientada a objetos.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Pensando en objetos.<br />\r\nElementos de la programaci&oacute;n orientada a objetos.</p>\r\n\r\n<p style=\"margin-left:80px\">Clases.<br />\r\nPropiedades.<br />\r\nM&eacute;todos.<br />\r\nObjetos.<br />\r\nHerencia.<br />\r\nM&oacute;dulos y paquetes.<br />\r\nUsando paquetes existentes.<br />\r\nInstalando nuevos paquetes.<br />\r\nCreando paquetes.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 4: Archivos.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Usando archivos.<br />\r\nDirectorios y utilidades.<br />\r\nArchivos separados por coma.<br />\r\nArchivos YAML, JSON y XML.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 5: Creando Apps para la Web.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Flask, Django, y otros Frameworks.<br />\r\nCreando una aplicaci&oacute;n con Flask.<br />\r\nGenerando p&aacute;ginas a partir de plantillas.<br />\r\nDesplegando p&aacute;gina en Apache.</p>\r\n',5,4500,1),(27,52,'Curso Sitios responsivos con HTML5 ','Obtén las bases en CSS y JavaScript para poder crear páginas WEB HTML 5 con un contenido visual de alta calidad, aprende a manipular una pagina WEB con JavaScript y darle presentación con hojas de estilo. JS y CSS son fundamentales para explotar y entender al máximo JQuery, EXT JS,  Bootstrap y otras librerias.','Se recomienda que el alumno tenga conocimientos básicos en lógica de programación y aplicaciones WEB para que aproveche mejor el contenido del curso.','<h3>35 Horas.  7 Sábados de 9:00 a 2:00 pm y de 2:30 a 6:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Dreamweaver, Sublime Text</li>\r\n</ol>\r\n\r\n<ul>\r\n  <li>\r\nNavegador WEB: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>      IExplore, Chrome y Firefox</li>\r\n</ol>\r\n<br />\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo.\r\n','Curso Sitios responsivos con HTML5 ','<ul>\r\n	<li>Modulo 1:&nbsp;Visi&oacute;n general de la WEB 2.0</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Que es la WEB 2.0.</li>\r\n	<li>HTML 5 y la estructura de un documento.</li>\r\n	<li>Para que me sirve CSS.</li>\r\n	<li>JavaScript &nbsp;y lo que puede hacer.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 2:&nbsp;JavaScript a fondo.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>DOM (Document Object Model).</li>\r\n	<li>Como manipular un documento HTML 5.</li>\r\n	<li>Variables, Funciones y objetos en JavaScript.</li>\r\n	<li>Registro y ejecuci&oacute;n de scripts mediante eventos.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 3:&nbsp;Hojas de estilo (Cascade Style Sheet).</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Selectores.</li>\r\n	<li>Especificidad de selectores.</li>\r\n	<li>Clases.</li>\r\n	<li>Herencia en CSS.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 4:&nbsp;Integrando HTML 5, CSS y JavaScript.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Agregar y distribuir componentes en una p&aacute;gina HTML 5.</li>\r\n	<li>Carga din&aacute;mica de recursos y hojas de estilo.</li>\r\n	<li>Aplicando estilos a contenidos, etiquetas y botones.</li>\r\n	<li>Transparencias y degradados en colores e im&aacute;genes.</li>\r\n	<li>&nbsp;Layouts y navegaci&oacute;n.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 5:&nbsp;&nbsp;Layouts responsivos.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>CSS para componentes responsivos.</li>\r\n	<li>Media Queries.</li>\r\n	<li>Animaci&oacute;nes.</li>\r\n	<li>Afinando &uacute;ltimos detalles de nuestro proyecto.</li>\r\n</ol>\r\n\r\n<p>&nbsp;</p>\r\n',5,5500,1),(28,54,'Desarrollo de Aplicaciones Móviles con Appcelerator Studio',' El alumno conocerá a detalle el API de desarrollo Appcelerator para realizar conexiones a  WebServices,  navegación  entre  ventanas,  almacenamiento  en  Bases  de  datos  locales  (SQLite), uso de cámara, integración con servicios de geo localización (GPS), entre otros.','Se sugiere que el alumno tenga conocimientos básicos de JavaScript.','<h3>30 Horas.  6 Sábados de 9:00 a 2:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Appcelerator Studio(última versión estable)</li>\r\n</ol>\r\n\r\n<ul>\r\n  <li>\r\ncompilador: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>      Android SDK (última estable)</li>\r\n<li>      XCode 6.3 o superior para iOS</li>\r\n<li>      OSX 10.8, y 4GB de RAM mínimo para iOS</li>\r\n</ol>\r\n<br />\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo (solo Windows, para MAC el alumno debe llevar su propio equipo).','Curso de Aplicaciones Móviles con Appcelerator Studio','<ul>\r\n	<li>Modulo 1: El desarrollo m&oacute;vil y Appcelerator.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Introducci&oacute;n a Appcelerator Studio.</li>\r\n	<li>Instalaci&oacute;n y Configuraci&oacute;n de Appcelerator Studio en Windows / Linux / Mac.</li>\r\n	<li>Instalaci&oacute;n y Configuraci&oacute;n de Android SDK, XCode.</li>\r\n	<li>Introducci&oacute;n a UI M&oacute;vil (Window, View, Layout, Button, TextField, TextArea, ImageView, Camera, WebView, TableView...).</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 2:&nbsp;Integraci&oacute;n con datos y otros servicios.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Almacenando datos locales con SQLite.</li>\r\n	<li>Conexiones a Datos Remotos (WebServices).</li>\r\n	<li>Manejo de peticiones HTTP POST, GET.</li>\r\n	<li>Conexiones Webservice API REST JSON.</li>\r\n	<li>Conexiones Webservice API REST SOAP.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 3:&nbsp;Interacci&oacute;n con otras API&#39;s.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Servicios de Geolocalizaci&oacute;n.</li>\r\n	<li>MapView en Android.</li>\r\n	<li>MapView en iOS.</li>\r\n	<li>Comunicaci&oacute;n con Redes Sociales (Facebook y Twitter).</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 4:&nbsp;Correo electr&oacute;nico.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Creaci&oacute;n y env&iacute;o de correo electr&oacute;nico.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Modulo 5:&nbsp;Distribuci&oacute;n de la aplicaci&oacute;n.</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Requerimientos para publicar en AppStore (iOS).</li>\r\n	<li>Requerimientos para publicar en PlayStore (Android).</li>\r\n	<li>Generaci&oacute;n de APK para android.</li>\r\n	<li>Generaci&oacute;n de iPA para iOS.</li>\r\n</ol>\r\n',5,6000,1),(29,55,'Spring Web MVC','Spring es un Framework muy popular en la comunidad de desarrollo Java EE, permite el desarrollo fácil y rápido de aplicaciones Web altamente desacopladas. Spring Web MVC permite la integración de diversas tecnologías en la construcción del front end.','Se requiere que el alumno tenga conocimientos previos en Java EE.','<h3>40 Horas. 8 Sábados de 9:00 a 2:00 pm</h3>\r\n<ul>Las herramientas utilizadas en el curso son:</ul>\r\n<ol>\r\n<li>Spring Tool Suite (Última versión estable).</li>\r\n<li>Hibernate (Última versión estable)</li>\r\n<li>Spring Framework 4.1.</li>\r\n<li>Java EE</li>\r\n</ol>	','Curso Spring Web MVC','<p>Modulo 1: Visi&oacute;n General de Spring</p>\r\n\r\n<ol>\r\n	<li>Ventajas del uso de Spring Web MVC</li>\r\n	<li>Que es y como funciona DispatcherServlet.</li>\r\n	<li>Configuraci&oacute;n de Spring mediante anotaciones.</li>\r\n	<li>Creando nuestro primer Controller.​</li>\r\n</ol>\r\n\r\n<p>Modulo 2: Spring MVC</p>\r\n\r\n<ol>\r\n	<li>Ciclo de peticiones y respuestas.</li>\r\n	<li>URL Mappings</li>\r\n	<li>Handlers y Adapters.</li>\r\n	<li>Interceptores.</li>\r\n	<li>Configuraci&oacute;n de mensajes.</li>\r\n</ol>\r\n\r\n<p>Modulo 3: Manejo de peticiones con Controllers</p>\r\n\r\n<ol>\r\n	<li>Env&iacute;o de par&aacute;metros por URL y uso de @RequestParam.</li>\r\n	<li>Acceso a parametros @PathVariable vs @RequestParam.</li>\r\n	<li>Creando y accediendo al model (Model).</li>\r\n	<li>Manejo de Vistas y tipos de vistas soportadas por Spring.</li>\r\n</ol>\r\n\r\n<p>Modulo 4: Resoluci&oacute;n de vistas (View Resolvers)</p>\r\n\r\n<ol>\r\n	<li>Configuraci&oacute;n de vistas (front end).</li>\r\n	<li>Layouts y componentes reusables con Tiles.</li>\r\n	<li>Formularios, Listas, Grids.</li>\r\n	<li>Entrega de informaci&oacute;n en formato JSON, Excel, XML.</li>\r\n	<li>Administraci&oacute;n de entrega de contenido al cliente por par&aacute;metros y extensiones en URL.</li>\r\n</ol>\r\n\r\n<p>Modulo 5: Internacionalizaci&oacute;n, Validaci&oacute;n y mensajes de error</p>\r\n\r\n<ol>\r\n	<li>Soporte de internacionalizaci&oacute;n.</li>\r\n	<li>cambio de temas y estilos.</li>\r\n	<li>Validaci&oacute;n en vistas y en Beans.</li>\r\n</ol>\r\n\r\n<p>Modulo 6: Spring Web Flow</p>\r\n\r\n<ol>\r\n	<li>Que es Web Flow.</li>\r\n	<li>Como funciona Web Flow.</li>\r\n	<li>Integraci&oacute;n de Spring MVC y Web Flow.</li>\r\n	<li>Vistas y transiciones.</li>\r\n</ol>\r\n\r\n<p>Modulo 7: Spring Security&nbsp;</p>\r\n\r\n<ol>\r\n	<li>Visi&oacute;n general de Spring Security.</li>\r\n	<li>Ventajas de Spring Security.</li>\r\n	<li>Integrando Spring Security</li>\r\n	<li>Configurando autenticaci&oacute;n y roles.</li>\r\n</ol>\r\n',5,7500,1),(30,59,'Valuación de Bonos del Sector Financiero Mexicano','introducción','Perfil del Usuario','Descripción de curso Valuación de Bonos del Sector Financiero Mexicano','Valuación de Bonos del Sector Financiero Mexicano','<p>Valuaci&oacute;n de Bonos del Sector Financiero Mexicano</p>\r\n',1,8000,1),(31,50,'Python Intermedio','Adéntrate en Python para hacer las cosas de forma más óptima y rápida, aprende algunos trucos y detalles que los usuarios básicos de Python aún no conocen.','El alumno deberá ya tener conocimientos básicos del lenguaje como sintáxis, programación orientada a objetos y manejo de archivos archivos.','<h3>35 Horas.  Sábados de 9:00 a 2:00 pm o entre semana  de 19:00 a 21:00 horas de Lunes a Jueves</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li> Ninja-IDE </li>\r\n</ol>','Curso Python Nivel Intermedio','<ul>\r\n	<li>M&oacute;dulo 1: Introducci&oacute;n.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&iquest;C&oacute;mo y cu&aacute;ndo usar Python adecuadamente?.<br />\r\nRetomando ideas del lenguaje.<br />\r\nObtenci&oacute;n de software de terceros (librer&iacute;as).</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 2: Manejo de excepciones.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Sintaxis para lanzar, capturar y manipular excepciones.<br />\r\nCasos de uso comunes.<br />\r\nExtendiendo excepciones est&aacute;ndares.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 3: Facilidades de la sintaxis.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Iteradores.<br />\r\nGeneradores.<br />\r\nDecoradores.<br />\r\nSintaxis comprimida.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 5: Expresiones regulares.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Recordando las expresiones regulares.<br />\r\nUso y sintaxis en Python.<br />\r\nCasos de uso pr&aacute;cticos.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 6: Bases de datos.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Introducci&oacute;n.<br />\r\nEl API para bases de datos de Python.<br />\r\nORMs y la capa de persistencia.<br />\r\nBases de datos no relacionales.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 7: Utilidad para base de datos.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Introduciendo el problema.<br />\r\nCreando un Script en Python.<br />\r\nCreando un trabajo para la ejecuci&oacute;n programada.</p>\r\n',3,5000,1),(32,50,'Python Avanzado','Usa Python como todo un maestro, aplica las mejores prácticas y ponle azúcar a tu código. Prepárate para extender el lenguaje y sus límites.','Tener conocimientos en programación orientada a objetos y manejo de archivos, XML\'s y despliegue de aplicaciones en Apache.','<h3>35 Horas.  6 Sábados de 9:00 a 2:00 pm y de 19:00 a 21:00 horas entre semana de Lunes a Jueves</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nIDE de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li> Ninja-IDE </li>\r\n</ol>','Curso Python Avanzado','<ul>\r\n	<li>M&oacute;dulo 1: Midiendo el rendimiento de python.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Conociendo el manejo de memoria.<br />\r\nUtilidades y medidores para el rendimiento.<br />\r\nM&eacute;tricas.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 2: Programaci&oacute;n con Hilos.</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Hilos y procesos.<br />\r\nLos m&oacute;dulos de Threading &amp; Thread.<br />\r\nComparando ejecuciones con y sin hilos.<br />\r\nArquitectura consumidor-productor.</p>\r\n\r\n<p style=\"margin-left:40px\">M&oacute;dulo 3: Extendiendo Python.</p>\r\n\r\n<p style=\"margin-left:80px\">Usando extensiones.<br />\r\nEscribiendo una extensi&oacute;n.<br />\r\nEjemplos relacionados.</p>\r\n\r\n<p style=\"margin-left:40px\">M&oacute;dulo 4: Usando Office con Python.</p>\r\n\r\n<p style=\"margin-left:80px\">Comunicaci&oacute;n COM con Python.<br />\r\nEjemplos de uso con Office.</p>\r\n\r\n<p style=\"margin-left:40px\">M&oacute;dulo 5: Poniendo las cosas juntas.</p>\r\n\r\n<p style=\"margin-left:80px\">Analizando la estructura de proyectos profesionales.<br />\r\nCreando y publicando una librer&iacute;a.<br />\r\nOtros proyectos y temas de inter&eacute;s.</p>\r\n',2,6000,1),(33,61,'AutoCad 2D y 3D','En este curso se abarcan conceptos del dibujo técnico, mecánico, industrial y arquitectónico. Así mismo, se desarrollarán prácticas y ejercicios en 2D y 3D los cuáles están documentados con sus respectivas dimensiones, anotaciones, texto, capas, cortes, etc. Que un trabajo profesional debe contener.','Curso orientado a estudiantes y profesionales (Ingenieros, Arquitectos, Diseñadores ) que requieren modelar o diseñar objetos.','<h3>30 Horas.  6 Sábados de 9:00 a 2:00 pm y de 2:30 a 6:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nAutoCad Última Versión: \r\n</li>\r\n</ul>\r\nNota: Las herramientas las proporcionamos en el centro de capacitación, en caso de que lo requieras también te proporcionamos el equipo de computo.','Curso AutoCad 2D y 3D desde cero','<p>M&oacute;dulo 1: Iniciando con AutoCAD</p>\r\n\r\n<ul>\r\n	<li>Conceptos de uso para Autocad&nbsp;</li>\r\n	<li>Comandos de Dibujo&nbsp;</li>\r\n	<li>Comandos de Edici&oacute;n y Modificaci&oacute;n&nbsp;</li>\r\n	<li>Capas (Layers)&nbsp;</li>\r\n</ul>\r\n\r\n<p>M&oacute;dulo 2: Bloques y Objetos</p>\r\n\r\n<ul>\r\n	<li>Acotaciones y Dimensiones&nbsp;</li>\r\n	<li>Texto y tablas&nbsp;</li>\r\n	<li>Manejo de Object Snap (Objetos de referencia)&nbsp;</li>\r\n	<li>Creaci&oacute;n de Bloques&nbsp;</li>\r\n	<li>Rayado a objetos y bloques (Hatch)&nbsp;</li>\r\n</ul>\r\n\r\n<p>M&oacute;dulo 3: Objetos 3D y S&oacute;lidos</p>\r\n\r\n<ul>\r\n	<li>Uso de espacios de modelos y espacio del papel Layout&nbsp;</li>\r\n	<li>Vistas de objetos en 3D&nbsp;</li>\r\n	<li>Dibujos Isom&eacute;tricos y Creaci&oacute;n de objetos en 3D&nbsp;</li>\r\n	<li>Modificaci&oacute;n de objetos Tridimensionales&nbsp;</li>\r\n	<li>Modificaci&oacute;n de s&oacute;lidos por sus caras&nbsp;</li>\r\n</ul>\r\n\r\n<p>M&oacute;dulo 4: Mallas y Superficies</p>\r\n\r\n<ul>\r\n	<li>Operaciones Boleanas&nbsp;</li>\r\n	<li>Creaci&oacute;n de mallas&nbsp;</li>\r\n	<li>Regiones y Superficies 3D&nbsp;</li>\r\n	<li>Objetos de Revoluci&oacute;n&nbsp;</li>\r\n</ul>\r\n\r\n<p>M&oacute;dulo 5: Materiales, Renderizado y Luces</p>\r\n\r\n<ul>\r\n	<li>Agregado y Creaci&oacute;n de Materiales&nbsp;</li>\r\n	<li>Ajuste de Materiales (Mapping)&nbsp;</li>\r\n	<li>Sistema coordenado (UCS)&nbsp;</li>\r\n	<li>Renderizado y&nbsp;Luces&nbsp;</li>\r\n</ul>\r\n',1,3500,1),(34,65,'Excel Avanzado con Macros','En este curso, los participantes tendrán la capacidad de automatizar cualquier tipo de tarea en Excel, a través de la programación de comandos en lenguaje Visual Basic aplicados sobre la plataforma de Excel.','A todas aquellas personas que requieren reducir tiempos en sus procesos de emisión de reportes, análisis o cualquier otra actividad que realicen en Excel. No es necesario saber programar.','<h3>25 Horas. 5 Sábados de 9:00 a 2:00 pm, de Lunes a Jueves de 7 a 9 pm</h3>\r\n<ul>Las herramientas utilizadas en el curso son:</ul>\r\n<ol>\r\n<li>Excel con soporte para Macros 2010 o superior</li>\r\n</ol>		','Curso Excel Avanzado para Contadores, Financieros y Administradores','<ul>\r\n	<li>M&oacute;dulo 1. PROGRAMACI&Oacute;N ESTRUCTURADA</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&nbsp;Algoritmos<br />\r\n&nbsp;Diagramas de flujo</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 2. PROGRAMACI&Oacute;N DE MACROS</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&nbsp;Objetos<br />\r\n&nbsp;propiedades<br />\r\n&nbsp;M&eacute;todos<br />\r\n&nbsp;Eventos</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 3. VISUAL BASIC PARA EXCEL</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&nbsp;Variables y sus identificadores<br />\r\n&nbsp;Variables y constantes<br />\r\n&nbsp;Nombres de variables<br />\r\n&nbsp;Tipos de datos<br />\r\n&nbsp;Elecci&oacute;n del tipo de una variable<br />\r\n&nbsp;Declaraci&oacute;n expl&iacute;cita de variables<br />\r\n&nbsp;&Aacute;mbito de las variables y los procedimientos.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 5. MACROS</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&nbsp;Definici&oacute;n<br />\r\n&nbsp;Grabar y ejecutar Macros<br />\r\n&nbsp;Manipular Macros<br />\r\n&nbsp;Tipos de Macros en Excel<br />\r\n&nbsp;Objetos : Libro, Hoja y celda.</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 6. OPERADORES Y SENTENCIAS DE CONTROL</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&nbsp;Sentencia IF, THEN, ELSE<br />\r\n&nbsp;Sentencia SELECT CASE<br />\r\n&nbsp;Sentencia FOR - NEXT<br />\r\n&nbsp;Sentencia DO - LOOP<br />\r\n&nbsp;Sentencia FOR EACH - NEXT</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 7. FUNCIONES Y PROCEDIMIENTOS</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">&nbsp;Conceptos generales sobre funciones<br />\r\n&nbsp;Funciones y procedimientos Sub en Visual Basic<br />\r\n&nbsp;Funciones (function)<br />\r\n&nbsp;Procedimientos Sub<br />\r\n&nbsp;Argumentos por referencia y por valor<br />\r\n&nbsp;Procedimientos recursivos<br />\r\n&nbsp;Funciones para manejo de cadenas de caracteres<br />\r\n&nbsp;Funciones Matem&aacute;ticas<br />\r\n&nbsp;Cajas de di&aacute;logo Inputbox y Msgbox<br />\r\n&nbsp;Insertar funciones de Excel desde Visual Basic</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 8. EVENTOS PROPIEDADES Y CONTROLES DE VISUAL BASIC</li>\r\n</ul>\r\n\r\n<p style=\"margin-left:80px\">Botones de comando (Command Button)<br />\r\nBotones de opci&oacute;n (Option Button)<br />\r\nCasillas de verificaci&oacute;n (Check Box)<br />\r\nBarras de desplazamiento (Scroll Bar)<br />\r\nEtiquetas (Label)<br />\r\nCuadros de texto (Text Box)<br />\r\nCuadros de lista (List Box)<br />\r\nCuadros combinados (Combo Box)<br />\r\nBotones de n&uacute;mero (Spin Button)<br />\r\nOtros controles</p>\r\n\r\n<ul>\r\n	<li>M&oacute;dulo 9. DEPURACI&Oacute;N DE ERRORES</li>\r\n</ul>\r\n',1,3500,1),(35,68,'Aplicaciones Visual Basic .NET','En nuestro curso obtendrás los conocimientos necesarios para crear aplicaciones Windows con acceso a base de datos y soporte para crear reportes en CrystalReports y mostrarlos adecuadamente dentro de tus aplicaciones .NET.','<ol>\r\n<li>Conocimientos básicos de lógica de programación.</li>\r\n<li>Conocimientos básicos en SQL Server.</li>\r\n</ol>','<h3>30 Horas. 6 Sábados de 9:00 a 2:00 pm</h3>\r\n<ul>Las herramientas utilizadas en el curso son:</ul>\r\n<ol>\r\n<li>Visual Studio Última Versión estable</li>\r\n<li>SQL Server Última Versión estable</li>\r\n<li>Visual Studio .NET Última Versión estable</li>\r\n</ol>','Curso Visual Basic .NET','<ul>\r\n	<li>El lenguaje Visual Basic .NET\r\n	<ol>\r\n		<li>Introducci&oacute;n a plataforma de desarrollo Visual Basic.NET</li>\r\n		<li>Entorno Integrado de Desarrollo</li>\r\n	</ol>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li>Fundamentos de programaci&oacute;n</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Variables y&nbsp;&nbsp; tipo de datos</li>\r\n	<li>operadores, conversi&oacute;n impl&iacute;cita y expl&iacute;cita, expresiones l&oacute;gicas.</li>\r\n	<li>Matrices y estructuras de control.</li>\r\n	<li>Procedimientos</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Fundamentos de Programaci&oacute;n Orientada a Objetos</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Conceptos fundamentales de objetos</li>\r\n	<li>C&oacute;mo crear objetos.</li>\r\n	<li>Tipos de datos como clases</li>\r\n	<li>Concepto de visibilidad. y propiedades de s&oacute;lo lectura o escritura.</li>\r\n	<li>Herencia, clases abstractas, interfaces y los espacios de nombres.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Aplicaciones Windows</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Introducci&oacute;n a aplicaciones Windows .NET</li>\r\n	<li>Formularios, men&uacute;s y Barras de herramientas</li>\r\n	<li>Cuadros de di&aacute;logo Etiquetas, Cuadros de Texto, GroupBox y Tipos de botones</li>\r\n	<li>Eventos de rat&oacute;n y teclado</li>\r\n	<li>Aplicaciones MDI</li>\r\n	<li>Excepciones</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Acceso a bases de datos</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Introducci&oacute;n a tecnolog&iacute;a ADO .NET</li>\r\n	<li>El lenguaje SQL (operaciones CRUD a base de datos)</li>\r\n	<li>Connection, DataAdapter y DataSet.</li>\r\n	<li>Conjuntos de datos</li>\r\n	<li>Diferencia entre proveedores y consumidores de datos</li>\r\n	<li>Controles sencillos de la interfaz de usuario con el conjunto de datos.</li>\r\n	<li>TabControl y el acceso a m&aacute;s de una tabla estableciendo relaciones en el conjunto de datos.</li>\r\n	<li>Campos de b&uacute;squeda y consultas con par&aacute;metros</li>\r\n	<li>CRUD a base de datos con ADO .NET</li>\r\n	<li>Estructura del DataSet y su programaci&oacute;n.</li>\r\n	<li>Objetos Command y DataReader.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Crystal Reports</li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Creaci&oacute;n de reportes a partir de la informaci&oacute;n almacenada en una base de datos.</li>\r\n	<li>Visualizar un reporte creado con Crystal Reports desde una aplicaci&oacute;n Windows de Visual Basic .NET.</li>\r\n	<li>Configurar el reporte para utilizar la tecnolog&iacute;a ADO .NET como origen de la informaci&oacute;n almacenada.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li>Empaquetado de una aplicaci&oacute;n .NET para su instalaci&oacute;n.</li>\r\n</ul>\r\n\r\n<p>&nbsp;</p>\r\n',5,6500,1),(36,65,'Diplomado en Excel desde básico hasta avanzado','Presentamos el más completo diplomado para aprender a manejar esta poderosa hoja de Cálculo, donde descubrirá partiendo de sencillos ejemplos como manejar funciones, a usar las distintas herramientas de análisis de datos, realizar distintos tipos de gráficos, crear Tablas dinámicas, y con el uso de macros descubrirá como crear sus aplicaciones a la medida a través del uso del código VBA de Excel.','Experiencia previa en el uso de la computadora','<h3>80 Horas. Modalidad Sabatina o de Lunes a Jueves</h3>\r\n<ul>Las herramientas utilizadas en el curso son:</ul>\r\n<ol>\r\n<li>Excel con soporte para Macros 2010 o superior</li>\r\n</ol>		','Diplomado en Excel desde básico hasta avanzado','<h2>M&oacute;dulo I (24 horas)</h2>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Conceptos Te&oacute;ricos Generales</strong></span>\r\n\r\n	<ul>\r\n		<li>Para qu&eacute; sirve una planilla electr&oacute;nica</li>\r\n		<li>Elementos de la ventana principal</li>\r\n		<li>Conceptos b&aacute;sicos de Excel</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Comenzando con la Pr&aacute;ctica</span></strong>\r\n\r\n	<ul>\r\n		<li>Formas de desplazarse en una hoja y en un libro</li>\r\n		<li>Trabajar con archivos&nbsp;(crear, guardar, cerrar y abrir libros)</li>\r\n		<li>Ingreso y edici&oacute;n de datos</li>\r\n		<li>Selecci&oacute;n de celdas adyacentes y no adyacentes</li>\r\n		<li>Copiar, cortar y pegar; pegado especial</li>\r\n		<li>Rellenar rangos</li>\r\n		<li>Series</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Aumentando la Productividad</strong></span>\r\n\r\n	<ul>\r\n		<li>Atajos de teclado &uacute;tiles</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Acomodando los Datos</span></strong>\r\n\r\n	<ul>\r\n		<li>Ordenar datos</li>\r\n		<li>Filtrar datos</li>\r\n		<li>Buscar y reemplazar</li>\r\n		<li>Formatos num&eacute;ricos&nbsp;(General, N&uacute;mero, Moneda, Contabilidad, Fecha, Hora, Porcentaje, Fracci&oacute;n)</li>\r\n		<li>Formatos de fuente&nbsp;(Tipo, Tama&ntilde;o, Negrita, Cursiva, Subrayado, Tachado, Sub&iacute;ndice, Super&iacute;ndice, Color, Resaltado)</li>\r\n		<li>Agregar bordes a las celdas</li>\r\n		<li>Alineaci&oacute;n del contenido</li>\r\n		<li>Ajustar texto; combinar y centrar</li>\r\n		<li>Copiar formato</li>\r\n		<li>Borrar datos</li>\r\n		<li>Estilos de celda</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Modificando la Estructura</span></strong>\r\n\r\n	<ul>\r\n		<li>Seleccionar celdas, filas y columnas</li>\r\n		<li>Insertar celdas, filas y columnas</li>\r\n		<li>Copiar y Mover caldas, filas y columnas</li>\r\n		<li>Eliminar celdas, filas y columnas</li>\r\n		<li>Ocultar y mostrar filas y columnas</li>\r\n		<li>Ajustar manualmente y autoajustar filas y columnas</li>\r\n		<li>Insertar, copiar, mover y eliminar hojas</li>\r\n		<li>Modificar nombre y cambiar color de etiqueta de una hoja</li>\r\n		<li>Ocultar y mostrar hojas</li>\r\n		<li>Seleccionar varias hojas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Operando con los Datos</span></strong>\r\n\r\n	<ul>\r\n		<li>Tipos de datos&nbsp;(constantes y f&oacute;rmulas)</li>\r\n		<li>F&oacute;rmulas</li>\r\n		<li>Operadores aritm&eacute;ticos</li>\r\n		<li>Referencias relativas, absolutas y mixtas</li>\r\n		<li>Asignaci&oacute;n de nombres</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Trabajando con Funciones</strong></span>\r\n\r\n	<ul>\r\n		<li>Caracter&iacute;sticas de las funciones</li>\r\n		<li>SUMA&nbsp;(Autosuma),&nbsp;PROMEDIO,&nbsp;CONTAR,&nbsp;MAX&nbsp;y&nbsp;MIN</li>\r\n		<li>SUMAR.SI, CONTARA, CONTAR.SI</li>\r\n		<li>Formas de insertar una funci&oacute;n</li>\r\n		<li>Funciones de Texto:&nbsp;CONCATENAR, IZQUIERDA, DERECHA, EXTRAE</li>\r\n		<li>Funciones de Fecha y Hora:&nbsp;HOY, AHORA, DIA, MES, A&Ntilde;O, HORA, MINUTO, SEGUNDO</li>\r\n		<li>Las funciones&nbsp;BUSCARV Y BUSCARH (en Excel 2010 = CONSULTAV&nbsp;y&nbsp;CONSULTAH)</li>\r\n		<li>La funci&oacute;n&nbsp;SI&nbsp;y otras funciones l&oacute;gicas&nbsp;(VERDADERO, FALSO, Y, O, NO, SI.ERROR)</li>\r\n		<li>Funciones anidadas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Insertando Elementos</span></strong>\r\n\r\n	<ul>\r\n		<li>Im&aacute;genes</li>\r\n		<li>Formas</li>\r\n		<li>Gr&aacute;ficos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Estableciendo un Dise&ntilde;o de P&aacute;gina</strong></span>\r\n\r\n	<ul>\r\n		<li>Configurar la p&aacute;gina</li>\r\n		<li>Imprimir</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<h2>M&oacute;dulo II (24 horas)</h2>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Empleando Estilos Avanzados</strong></span>\r\n\r\n	<ul>\r\n		<li>Formato condicional</li>\r\n		<li>Diferencia entre rangos y tablas en Excel</li>\r\n		<li>Dar formato como tabla</li>\r\n		<li>Ventajas de las tablas de Excel sobre los rangos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Trabajando con Gr&aacute;ficos</span></strong>\r\n\r\n	<ul>\r\n		<li>Creaci&oacute;n de gr&aacute;ficos personalizados</li>\r\n		<li>Minigr&aacute;ficos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Trabajando con m&aacute;s Funciones</strong></span>\r\n\r\n	<ul>\r\n		<li>Texto:&nbsp;LARGO, ENCONTRAR, MAYUSC, MINUSC, NOMPROPIO, SUSTITUIR</li>\r\n		<li>Fecha y Hora:&nbsp;FECHA, NSHORA, SIFECHA, DIASEM, NUM.DE.SEMANA</li>\r\n		<li>B&uacute;squeda y Referencia:&nbsp;COINCIDIR, COLUMNA, COLUMNAS, FILA, FiILAS, DESREF, DIRECCION, ELEGIR, INDICE, INDIRECTO</li>\r\n		<li>Matem&aacute;ticas:&nbsp;ABS, ALEATORIO, ALEATORIO.ENTRE, COCIENTE, RESIDUO, PRODUCTO, RAIZ, COMBINAT, REDONDEAR, REDONDEAR.MAS, REDONDEAR.MENOS, TRUNCAR, ENTERO, SIGNO</li>\r\n		<li>Otras funciones &uacute;tiles:&nbsp;PROMEDIO.SI, ESBLANCO, ESERR, ESERROR, ESTEXTO, ESNUMERO</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Aprendiendo a usar Tablas y Gr&aacute;ficos Din&aacute;micos</strong></span>\r\n\r\n	<ul>\r\n		<li>Creaci&oacute;n y manejo de tablas din&aacute;micas</li>\r\n		<li>Creaci&oacute;n y manejo de gr&aacute;ficos din&aacute;micos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Manejo Avanzado de Datos</strong></span>\r\n\r\n	<ul>\r\n		<li>Creaci&oacute;n de listas personalizadas</li>\r\n		<li>Distribuir texto en varias columnas</li>\r\n		<li>Quitar datos duplicados</li>\r\n		<li>Validaci&oacute;n de datos</li>\r\n		<li>Consolidar</li>\r\n		<li>Importar datos externos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Agregando Comentarios</strong></span>\r\n\r\n	<ul>\r\n		<li>Insertar, modificar y eliminar un comentario</li>\r\n		<li>Mostrar y ocultar un comentario</li>\r\n		<li>Dar formato al comentario</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Revisando el Texto</span></strong>\r\n\r\n	<ul>\r\n		<li>Revisar Ortograf&iacute;a, Referencia y Sin&oacute;nimos; Traducir</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Protegiendo los Datos</span></strong>\r\n\r\n	<ul>\r\n		<li>Proteger hoja</li>\r\n		<li>Proteger libro</li>\r\n		<li>Compartir libro</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Trabajando con Ventanas</strong></span>\r\n\r\n	<ul>\r\n		<li>Inmovilizar paneles</li>\r\n		<li>Duplicar ventana&nbsp;(Nueva Ventana)</li>\r\n		<li>Organizar las ventanas abiertas</li>\r\n		<li>Cambiar ventanas</li>\r\n		<li>Dividir una ventana</li>\r\n		<li>Ver en paralelo</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Insertando otros Elementos</strong></span>\r\n\r\n	<ul>\r\n		<li>Tratamiento avanzado de Im&aacute;genes</li>\r\n		<li>Capturas de pantalla</li>\r\n		<li>SmartArt</li>\r\n		<li>Hiperv&iacute;nculo</li>\r\n		<li>Cuadro de texto</li>\r\n		<li>Encabezado y pie de p&aacute;gina</li>\r\n		<li>WordArt</li>\r\n		<li>Ecuaciones</li>\r\n		<li>S&iacute;mbolos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Tipos de Operadores</span></strong>\r\n\r\n	<ul>\r\n		<li>Operadores aritm&eacute;ticos</li>\r\n		<li>Operadores de comparaci&oacute;n</li>\r\n		<li>Operadores de texto</li>\r\n		<li>Operadores de referencia</li>\r\n		<li>Orden de precedencia de los operadores</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Tipos de Referencia</span></strong>\r\n\r\n	<ul>\r\n		<li>Referencias relativas, absolutas y mixtas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Asignaci&oacute;n de Nombres</span></strong>\r\n\r\n	<ul>\r\n		<li>Ventajas de utilizar nombres de celda y rango</li>\r\n		<li>Asignar, modificar y eliminar nombres de celda y rango</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Manejando los Errores</span></strong>\r\n\r\n	<ul>\r\n		<li>Diferentes tipos de errores en Excel</li>\r\n		<li>Pasos para detectar y corregir r&aacute;pidamente los errores</li>\r\n		<li>Buenas pr&aacute;cticas para minimizar los errores</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Trabajando con Funciones</span></strong>\r\n\r\n	<ul>\r\n		<li>Importancia de las funciones</li>\r\n		<li>Elementos y estructura de una funci&oacute;n</li>\r\n		<li>Formas de insertar una funci&oacute;n</li>\r\n		<li>Ayudas que provee Excel al usar funciones</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Funciones B&aacute;sicas</span></strong>\r\n\r\n	<ul>\r\n		<li>SUMA / Autosuma (repaso de las m&uacute;ltiples formas de insertar sumas)</li>\r\n		<li>Las funciones m&aacute;s b&aacute;sicas:&nbsp;PROMEDIO, CONTAR, MAX y MIN</li>\r\n		<li>Otras funciones b&aacute;sicas:&nbsp;SUMAR.SI, CONTARA, CONTAR.SI</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Funciones de Fecha y Hora</span></strong>\r\n\r\n	<ul>\r\n		<li>C&oacute;mo maneja internamente Excel las fechas y las horas</li>\r\n		<li>Operaciones b&aacute;sicas con fechas</li>\r\n		<li>Funciones de fecha y hora m&aacute;s comunes&nbsp;(HOY, AHORA, DIA, MES, A&Ntilde;O, HORA, MINUTO, SEGUNDO)</li>\r\n		<li>La funci&oacute;n&nbsp;SIFECHA</li>\r\n		<li>Otras funciones de fecha y hora&nbsp;(DIASEM, NUM.DE.SEMANA, FECHA, NSHORA)</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Funciones de Texto</span></strong>\r\n\r\n	<ul>\r\n		<li>Concatenaci&oacute;n b&aacute;sica</li>\r\n		<li>Funciones de texto m&aacute;s usadas:&nbsp;CONCATENAR, LARGO, IZQUIERDA, DERECHA, EXTRAE, ENCONTRAR, IGUAL, ESPACIOS, MAYUSC, MINUSC, NOMPROPIO, CARACTER, CODIGO, SUSTITUIR</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Anidaci&oacute;n de Funciones</span></strong>\r\n\r\n	<ul>\r\n		<li>Qu&eacute; es una funci&oacute;n anidada</li>\r\n		<li>Ejemplos pr&aacute;cticos de funciones anidadas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">La Funci&oacute;n SI</span></strong>\r\n\r\n	<ul>\r\n		<li>Importancia y uso de la funci&oacute;n&nbsp;SI</li>\r\n		<li>Estructura de la funci&oacute;n&nbsp;SI</li>\r\n		<li>Funciones&nbsp;SI&nbsp;anidadas</li>\r\n		<li>C&oacute;mo determinar si es necesario anidar o no</li>\r\n		<li>Claves para resolver&nbsp;SI&nbsp;anidadas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Otras Funciones L&oacute;gicas</span></strong>\r\n\r\n	<ul>\r\n		<li>Las funciones:&nbsp;VERDADERO, FALSO, Y, O, NO y SI.ERROR</li>\r\n		<li>Evaluaciones m&uacute;ltiples: la ventaja de usar&nbsp;Y&nbsp;y&nbsp;O&nbsp;en la condici&oacute;n de un&nbsp;SI, en vez de variasSI&nbsp;anidadas</li>\r\n		<li>Las Funciones BUSCARV y BUSCARH&nbsp;(en Excel 2010 = CONSULTAV y CONSULTAH)</li>\r\n		<li>Importancia y uso de las funciones&nbsp;BUSCARV&nbsp;y&nbsp;BUSCARH</li>\r\n		<li>Estructura de las funciones&nbsp;BUSCARV&nbsp;y&nbsp;BUSCARH</li>\r\n		<li>Cu&aacute;ndo conviene usar las funciones&nbsp;BUSCARV&nbsp;y&nbsp;BUSCARH</li>\r\n		<li>La ventaja de usar matrices con nombre asignado</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Otras Funciones de B&uacute;squeda y Referencia</span></strong>\r\n\r\n	<ul>\r\n		<li>Funciones de b&uacute;squeda y referencia m&aacute;s usadas:&nbsp;COINCIDIR, COLUMNA, COLUMNAS, FILA, FILAS, DESREF, DIRECCION, ELEGIR, INDICE, INDIRECTO</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Otras Funciones de Uso Frecuente</span></strong>\r\n\r\n	<ul>\r\n		<li>Matem&aacute;ticas:&nbsp;ABS, ALEATORIO, ALEATORIO.ENTRE, COCIENTE, RESIDUO, PRODUCTO, RAIZ, COMBINAT, REDONDEAR, REDONDEAR.MAS, REDONDEAR.MENOS, TRUNCAR, ENTERO, SIGNO, SUMAPRODUCTO</li>\r\n		<li>Otras funciones &uacute;tiles:&nbsp;SUMAR.SI.CONJUNTO, CONTAR.SI.CONJUNTO, PROMEDIO.SI, PROMEDIO.SI.CONJUNTO, ESBLANCO, ESERR, ESERROR, ESTEXTO, ESNUMERO, K.ESIMO.MAYOR, K.ESIMO.MENOR, MEDIANA, MODA.UNO, MODA.VARIOS<br />\r\n		&nbsp;</li>\r\n	</ul>\r\n	</li>\r\n	<li><strong><span style=\"font-size:14px\">Herramientas de Control Avanzadas</span></strong>\r\n	<ul>\r\n		<li>Rastrear precedentes y dependientes</li>\r\n		<li>Mostrar f&oacute;rmulas</li>\r\n		<li>Opciones de c&aacute;lculo autom&aacute;tico y manual</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2>Modulo III&nbsp; (32 horas)</h2>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Visual Basic&nbsp;(VB)&nbsp;y Visual Basic para Aplicaciones&nbsp;(VBA)</span></strong>\r\n\r\n	<ul>\r\n		<li>Para qu&eacute; sirve Visual Basic para Aplicaciones</li>\r\n		<li>Qu&eacute; son las macros</li>\r\n		<li>Qu&eacute; es la Programaci&oacute;n Orientada a Objetos&nbsp;(POO)</li>\r\n		<li>Objetos</li>\r\n		<li>Colecciones</li>\r\n		<li>Propiedades, m&eacute;todos y eventos</li>\r\n		<li>C&oacute;mo agregar la ficha Programador en Excel</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>El Editor de Visual Basic para Excel</strong></span>\r\n\r\n	<ul>\r\n		<li>&iquest;Qu&eacute; es el Editor de Visual Basic?</li>\r\n		<li>El entorno de VBE</li>\r\n		<li>La barra de men&uacute;</li>\r\n		<li>La barra de herramientas</li>\r\n		<li>El Explorador de Proyectos</li>\r\n		<li>La ventana C&oacute;digo</li>\r\n		<li>La ventana Propiedades</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Trabajando con Formularios</span></strong>\r\n\r\n	<ul>\r\n		<li>Insertar un formulario</li>\r\n		<li>Propiedades de los formularios</li>\r\n		<li>M&eacute;todos de los formularios</li>\r\n		<li>Eventos de los formularios</li>\r\n		<li>Usar un formulario en una hoja de c&aacute;lculo</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Controles del Formulario</strong></span>\r\n\r\n	<ul>\r\n		<li>Etiqueta&nbsp;(Label)</li>\r\n		<li>Cuadro de texto&nbsp;(TextBox)</li>\r\n		<li>Cuadro de lista&nbsp;(ListBox)</li>\r\n		<li>Cuadro combinado&nbsp;(ComboBox)</li>\r\n		<li>Bot&oacute;n de comando&nbsp;(CommandButton)</li>\r\n		<li>Marco&nbsp;(Frame)</li>\r\n		<li>Casilla de verificaci&oacute;n&nbsp;(CheckBox)</li>\r\n		<li>Bot&oacute;n de opci&oacute;n&nbsp;(OptionButton)</li>\r\n		<li>Imagen&nbsp;(Image)</li>\r\n		<li>P&aacute;gina m&uacute;ltiple&nbsp;(MultiPage)</li>\r\n		<li>Barra de desplazamiento&nbsp;(ScrollBar)</li>\r\n		<li>Bot&oacute;n de n&uacute;mero&nbsp;(SpinButton)</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Procedimientos en VBA</span></strong>\r\n\r\n	<ul>\r\n		<li>Qu&eacute; son los procedimientos</li>\r\n		<li>&Aacute;mbito de los procedimientos</li>\r\n		<li>Los procedimientos Sub</li>\r\n		<li>Los procedimientos Function</li>\r\n		<li>Trabajar con los procedimientos</li>\r\n		<li>Insertar y eliminar m&oacute;dulos</li>\r\n		<li>Crear procedimientos Sub</li>\r\n		<li>Crear procedimientos Function</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Conceptos B&aacute;sicos del C&oacute;digo</strong></span>\r\n\r\n	<ul>\r\n		<li>Reglas de asignaci&oacute;n de nombres</li>\r\n		<li>Dividir una instrucci&oacute;n en varias l&iacute;neas</li>\r\n		<li>Indentaci&oacute;n&nbsp;(Sangr&iacute;as)</li>\r\n		<li>Agregar comentarios al c&oacute;digo</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Ejecutando un Procedimiento</strong></span>\r\n\r\n	<ul>\r\n		<li>Ejecutar un procedimiento desde otro procedimiento</li>\r\n		<li>Ejecutar un procedimiento desde el Editor de VBA</li>\r\n		<li>Ejecutar un procedimiento desde la ventana de Excel</li>\r\n		<li>Ejecutar el procedimiento con una tecla de acceso directo</li>\r\n		<li>Ejecutar el procedimiento utilizando objetos</li>\r\n		<li>Ejecutar una funci&oacute;n desde una hoja de c&aacute;lculo</li>\r\n		<li>Ejecutar una funci&oacute;n desde otro procedimiento</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Manejo de Datos en VBA</strong></span>\r\n\r\n	<ul>\r\n		<li>Las variables</li>\r\n		<li>Declaraci&oacute;n de variables&nbsp;(Option Explicit)</li>\r\n		<li>&Aacute;mbito de las variables&nbsp;(Nivel de procedimiento, de m&oacute;dulo y de proyecto)</li>\r\n		<li>Tipos de variables</li>\r\n		<li>Tipos num&eacute;ricos:&nbsp;Byte, Integer, Long, Single, Double, Currency</li>\r\n		<li>Otros tipos:&nbsp;Date (de fecha y hora), String (de texto), Boolean (booleanos), Variant (tipo por defecto), Object (de Objeto)</li>\r\n		<li>Las constantes</li>\r\n		<li>Los operadores&nbsp;(Aritm&eacute;ticos, comparativos y l&oacute;gicos)</li>\r\n		<li>Arrays&nbsp;(Matrices)</li>\r\n		<li>Declaraci&oacute;n de arrays</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Funciones Provistas por VBA</span></strong>\r\n\r\n	<ul>\r\n		<li>Funciones&nbsp;InputBox&nbsp;y&nbsp;MsgBox</li>\r\n		<li>Funciones de conversi&oacute;n de tipo&nbsp;(CBool, CByte, CCur, CDate, CDbl, CDec, CInt, CLng, CSng, CStr, CVar, Val)</li>\r\n		<li>Funciones de comprobaci&oacute;n&nbsp;(IsDate, IsNumeric, IsNull, IsEmpty, IsObject)</li>\r\n		<li>Funciones matem&aacute;ticas&nbsp;(Abs, Int, Fix, Rnd, Sqr)</li>\r\n		<li>Funciones de cadenas&nbsp;(Asc, Chr, Len, Left, Right, Mid, LTrim, RTrim, Trim, Ucase, LCase, InStr, Replace)</li>\r\n		<li>Funciones de fecha y hora&nbsp;(Date, Now, Time, DateDiff)</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><span style=\"font-size:14px\"><strong>Estructuras de Programaci&oacute;n</strong></span>\r\n\r\n	<ul>\r\n		<li>Estructuras condicionales</li>\r\n		<li>If&hellip;Then</li>\r\n		<li>If&hellip;Then&hellip;Else</li>\r\n		<li>If&hellip;Then&hellip;ElseIf</li>\r\n		<li>Estructuras&nbsp;If&nbsp;anidadas</li>\r\n		<li>Select Case</li>\r\n		<li>With&hellip;End With</li>\r\n		<li>Estructuras de ciclo</li>\r\n		<li>For&hellip;Next</li>\r\n		<li>For Each&hellip;Next</li>\r\n		<li>Salir de las estructuras&nbsp;For...Next&nbsp;y&nbsp;For Each...Next</li>\r\n		<li>Do&hellip;Loop</li>\r\n		<li>While&hellip;Wend</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong><span style=\"font-size:14px\">Principales Objetos de Excel</span></strong>\r\n\r\n	<ul>\r\n		<li>Modelo de objetos de Excel</li>\r\n		<li>El objeto&nbsp;Application</li>\r\n		<li>Propiedades del objeto&nbsp;Application</li>\r\n		<li>M&eacute;todos del objeto&nbsp;Application</li>\r\n		<li>El objeto&nbsp;Workbooks</li>\r\n		<li>Propiedades de los objetos&nbsp;Workbooks&nbsp;y&nbsp;Workbook</li>\r\n		<li>M&eacute;todos de los objetos&nbsp;Workbooks&nbsp;y&nbsp;Workbook</li>\r\n		<li>El objeto&nbsp;Worksheet</li>\r\n		<li>Propiedades del objeto&nbsp;Worksheet</li>\r\n		<li>M&eacute;todos de los objetos&nbsp;Worksheets&nbsp;y&nbsp;Worksheet</li>\r\n		<li>El objeto&nbsp;Range</li>\r\n		<li>Propiedades de los objetos&nbsp;Range</li>\r\n		<li>M&eacute;todos del objeto&nbsp;Range</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n',1,10000,1),(37,71,'Curso para la certificación Java programmer','Es un curso orientado a programadores que desean certificarse en Java (Oracle Certified Java Programmer), nuestra metodología de entrenamiento consiste en colocar al alumno como punto central de la capacitación y llevarlo de la mano en todo el proceso de aprendizaje. Nuestros instructores están calificados para proporcionar un entrenamiento de alto nivel','Se sugiere que el alumno tenga conocimientos de Java, al menos debe dominar los temas que se exponen en nuestro curso de Java desde cero.','<h3>30 Horas.  Sábados de 9:00 a 2:00 pm y de 2:30 a 6:00 pm</h3>\r\nLas herramientas recomendadas para este curso son las siguientes:\r\n<ul>\r\n  <li>\r\nEntorno de desarrollo: \r\n</li>\r\n</ul>\r\n<ol>\r\n<li>     Eclipse Ultima versión</li>\r\n</ol>','Curso para la certificación Java programmer','<ul>\r\n	<li><strong>M&oacute;dulo 1. Generalidades de Java</strong>\r\n	<ul>\r\n		<li>Objetivos del curso</li>\r\n		<li>Recursos adicionales de estudio</li>\r\n		<li>&iquest;Qu&eacute; es la tecnolog&iacute;a Java?</li>\r\n		<li>Caracter&iacute;sticas principales</li>\r\n		<li>Garbage Collector y administraci&oacute;n de memoria</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 2. JRE</strong>\r\n\r\n	<ul>\r\n		<li>&iquest;C&oacute;mo funciona la m&aacute;quina virtual de Java?</li>\r\n		<li>Nuestro primer programa</li>\r\n		<li>Compilaci&oacute;n y ejecuci&oacute;n de un programa</li>\r\n		<li>Errores comunes de compilaci&oacute;n</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 3. Programaci&oacute;n Orientada a Objetos</strong>\r\n\r\n	<ul>\r\n		<li>Ingenier&iacute;a de software</li>\r\n		<li>Las fases de an&aacute;lisis y dise&ntilde;o</li>\r\n		<li>Abstracci&oacute;n</li>\r\n		<li>Clases como blueprints para la creaci&oacute;n de objetos</li>\r\n		<li>Declaraci&oacute;n de Clases, atributos y m&eacute;todos</li>\r\n		<li>Acceso a miembros del objeto</li>\r\n		<li>Como ocultar informaci&oacute;n</li>\r\n		<li>Encapsulaci&oacute;n</li>\r\n		<li>Constructores</li>\r\n		<li>Estructura de un archivo java</li>\r\n		<li>Paquetes</li>\r\n		<li>Sentencias package e import</li>\r\n		<li>Compilando con el argumento -d</li>\r\n		<li>Ejecuci&oacute;n de un aplicaci&oacute;n</li>\r\n		<li>Uso de la API de Java</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 4. Identificadores, palabras reservadas y tipos de datos</strong>\r\n\r\n	<ul>\r\n		<li>Comentarios,&nbsp;</li>\r\n		<li>Sentencias, bloques y espacios en blanco</li>\r\n		<li>Identificadores</li>\r\n		<li>Palabras reservadas</li>\r\n		<li>Tipos primitivos</li>\r\n		<li>Variables, declaraci&oacute;n y asignaciones</li>\r\n		<li>Tipos de referencia</li>\r\n		<li>Construyendo e inicializando objetos</li>\r\n		<li>Asignaci&oacute;n y distribuci&oacute;n de memoria</li>\r\n		<li>Inicializaci&oacute;n explicita</li>\r\n		<li>Ejecutando el constructor</li>\r\n		<li>Asignaci&oacute;n de referencias</li>\r\n		<li>Paso por valor</li>\r\n		<li>La referencia this</li>\r\n		<li>Convenciones de programaci&oacute;n en Java</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 5. Expresiones y control de flujo</strong>\r\n\r\n	<ul>\r\n		<li>Variables</li>\r\n		<li>Variables and su alcance</li>\r\n		<li>Inicializaci&oacute;n de variables</li>\r\n		<li>Operadores y su precedencia</li>\r\n		<li>Operadores l&oacute;gicos</li>\r\n		<li>Concatenaci&oacute;n con +&nbsp;</li>\r\n		<li>Casting de tipos</li>\r\n		<li>Promoci&oacute;n y casting de expreciones</li>\r\n		<li>Sentencias if &ndash; else</li>\r\n		<li>Sentencia switch</li>\r\n		<li>Sentencias de iteraci&oacute;n for, while, do/while</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 6. Arreglos</strong>\r\n\r\n	<ul>\r\n		<li>Declaraci&oacute;n, creaci&oacute;n e inicializaci&oacute;n de arreglos</li>\r\n		<li>Arreglos multidimensionales</li>\r\n		<li>L&iacute;mites de los arreglos</li>\r\n		<li>Uso del for mejorado</li>\r\n		<li>Redimensionamiento de arreglos</li>\r\n		<li>Copiando arreglos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 7. Dise&ntilde;o de clases</strong>\r\n\r\n	<ul>\r\n		<li>Subclases y herencia</li>\r\n		<li>Control de acceso</li>\r\n		<li>Sobre escritura de m&eacute;todos</li>\r\n		<li>Invocaci&oacute;n de m&eacute;todo sobre-escritos</li>\r\n		<li>Polimorfismo</li>\r\n		<li>Invocaci&oacute;n virtual de m&eacute;todos</li>\r\n		<li>Colecciones heterogeneas</li>\r\n		<li>Argumentos polimorficos</li>\r\n		<li>El operador instanceof</li>\r\n		<li>Casteo de objetos</li>\r\n		<li>Sobrecarga de m&eacute;todos</li>\r\n		<li>Variables como argumentos</li>\r\n		<li>Sobrecarga de constructores</li>\r\n		<li>Invocando los constructores</li>\r\n		<li>La clase Object</li>\r\n		<li>Los m&eacute;todos equals y toString</li>\r\n		<li>Clases envoltorio (wrappers)</li>\r\n		<li>Autoboxing de tipos primitivos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 8. Caracter&iacute;sticas avanzadas de clases</strong>\r\n\r\n	<ul>\r\n		<li>La palabra reservada static</li>\r\n		<li>Atributos y m&eacute;todos</li>\r\n		<li>Inicializaci&oacute;n de variables estaticas</li>\r\n		<li>La palabra reservada final</li>\r\n		<li>Clases, m&eacute;todos y variables Final</li>\r\n		<li>Viejos y nuevos tipos enumerados&nbsp;</li>\r\n		<li>Tipos enumerados avanzados</li>\r\n		<li>Imports estaticos</li>\r\n		<li>Clases abstractas</li>\r\n		<li>Interfaces</li>\r\n		<li>Uso de multiples interfaces</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulon9. Excepciones y assertions</strong>\r\n\r\n	<ul>\r\n		<li>Ejemplo de excepciones</li>\r\n		<li>La sentencia try - catch</li>\r\n		<li>La sentencia finally</li>\r\n		<li>Categor&iacute;as de excepciones&nbsp;</li>\r\n		<li>Excepciones comunes</li>\r\n		<li>Manejo y declaraci&oacute;n de excepciones</li>\r\n		<li>Creando tus propias excepciones</li>\r\n		<li>Manejo y lanzamiento de excepciones personalizadas</li>\r\n		<li>Assertions y donde utilizarlas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 10. Colecciones y Genericos</strong>\r\n\r\n	<ul>\r\n		<li>La API de las colecciones</li>\r\n		<li>Implementaci&oacute;n de colecciones</li>\r\n		<li>Set, List y Map</li>\r\n		<li>Ordenando colecciones</li>\r\n		<li>Comparable y Comparator</li>\r\n		<li>Uso de gen&eacute;ricos con Map y Set</li>\r\n		<li>Tipos de par&aacute;metros en Gen&eacute;ricos</li>\r\n		<li>Iterators</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 11. Fundamentos de flujos de entrada y salida (I/O)</strong>\r\n\r\n	<ul>\r\n		<li>Argumentos desde la l&iacute;nea de comandos</li>\r\n		<li>Propiedades de sistema</li>\r\n		<li>La clase Properties</li>\r\n		<li>Fundamentos de Flujos de entrada y salida</li>\r\n		<li>InputStream y sus m&eacute;todos</li>\r\n		<li>OutputStream y sus m&eacute;todos</li>\r\n		<li>Flujos de caracteres</li>\r\n		<li>Reader, Writer y sus m&eacute;todos</li>\r\n		<li>Buffered Streams</li>\r\n		<li>Clases para el manejo de flujo de bytes</li>\r\n		<li>FileInputStream y FileOutputStream</li>\r\n		<li>BufferedInputStream y BufferedOutputStream</li>\r\n		<li>PipedInputStream y PipedOutputStream</li>\r\n		<li>DataInputStream y DataOutputStream</li>\r\n		<li>ObjectInputStream y ObjectOutputStream</li>\r\n		<li>InputStreamReader y OutputStreamWriter</li>\r\n		<li>Conversiones de Byte y Character</li>\r\n		<li>FileReader y FileWriter</li>\r\n		<li>BufferedReader y BufferedWriter</li>\r\n		<li>StringReader y StringWriter</li>\r\n		<li>PipedReader y PipedWriter&nbsp;</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 12. Console I/ O and File I/O</strong>\r\n\r\n	<ul>\r\n		<li>Enviando datos a la salida est&aacute;ndar&nbsp;</li>\r\n		<li>Leyendo datos desde la entrada est&aacute;ndar</li>\r\n		<li>Lectura y escritura de Directorios y Archivos</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 13. Creaci&oacute;n de interfaces gr&aacute;ficas con SWING</strong>\r\n\r\n	<ul>\r\n		<li>Look and Feel de Swing</li>\r\n		<li>Arquitectura Swing</li>\r\n		<li>Paquetes Swing&nbsp;</li>\r\n		<li>Componentes de Java GUI&nbsp;</li>\r\n		<li>Contenedores Swing</li>\r\n		<li>Jerarqu&iacute;a de componentes en Swing</li>\r\n		<li>Layout Managers&nbsp;</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 14. Manejo de eventos</strong>\r\n\r\n	<ul>\r\n		<li>Que es un evento</li>\r\n		<li>El modelo de eventos den Java</li>\r\n		<li>Delegados&nbsp;</li>\r\n		<li>Ejemplo de un listener</li>\r\n		<li>Tipos y categor&iacute;as de eventos</li>\r\n		<li>M&uacute;ltiples listeners</li>\r\n		<li>Creando listeners</li>\r\n		<li>Clases internas y an&oacute;nimas&nbsp;</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 15. Aplicaciones gr&aacute;ficas&nbsp;</strong>\r\n\r\n	<ul>\r\n		<li>Formularios</li>\r\n		<li>Paneles</li>\r\n		<li>Menus</li>\r\n		<li>Tablas</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 16. Threads</strong>\r\n\r\n	<ul>\r\n		<li>Ciclo de vida de los Threads</li>\r\n		<li>Creando y probando Threads</li>\r\n		<li>Diferentes formas de crear Threads</li>\r\n		<li>Utilizando la palabra reservada synchronized</li>\r\n		<li>M&eacute;todos wait y notify&nbsp;</li>\r\n		<li>Sincronizaci&oacute;n de Threads</li>\r\n		<li>El Thread Producer&nbsp;</li>\r\n		<li>El Thread Consumer&nbsp;</li>\r\n		<li>La clase SyncStack</li>\r\n		<li>Ejemplo de SyncTest&nbsp;</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 17. Comunicaci&oacute;n en red&nbsp;</strong>\r\n\r\n	<ul>\r\n		<li>Sockets</li>\r\n		<li>Creando una conexi&oacute;n</li>\r\n		<li>Puertos</li>\r\n		<li>Modelo cliente servidor</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 18. Programaci&oacute;n avanzada en Java&nbsp;</strong>\r\n\r\n	<ul>\r\n		<li>Introducci&oacute;n a la arquitectura en capas</li>\r\n		<li>Introducci&oacute;n a JDBC</li>\r\n		<li>Drivers JDBC &nbsp;y el puente JDBC &ndash;ODBC&nbsp;</li>\r\n		<li>RMI&nbsp;</li>\r\n		<li>CORBA&nbsp;</li>\r\n		<li>El modelo de componentes JavaBeans</li>\r\n		<li>Archivos JAR&nbsp;</li>\r\n		<li>Uso de javadoc&nbsp;</li>\r\n		<li>Comentarios javadoc</li>\r\n	</ul>\r\n	</li>\r\n</ul>\r\n',5,6500,1),(38,52,'Curso HTML 5 CSS3 y JS','Se trata de una nueva versión de HTML, con nuevos elementos, atributos y comportamientos. Contiene un conjunto más amplio de tecnologías que permite a los sitios Web y a las aplicaciones ser más diversas y de gran alcance. A este conjunto se le llama HTML5 y amigos, a menudo reducido a HTML5.','Tras la conclusión exitosa del curso, los alumnos serán capaces de lo siguiente:\r\nDiseñar sitios web fluidos con la nueva sintaxis de la estructura que ofrece HTML5.\r\n<ul>\r\n <li>\r\nCrear páginas web responsivas, las cuales se adaptan a cualquier resolución de pantalla, abarcando PC y dispositivos móviles.\r\n<li>\r\nCrear elementos de páginas web más intuitivos para que la experiencia del usuario final sea más grata.\r\n</li>\r\n</ul>','<h3>30 Horas.  6 Sábados de 9:00 a 2:00 <br /> 7 Sábados de 2:30 a 6:30 pm</h3>\r\n','Curso HTML 5 CSS3 y JS','<ul>\r\n	<li><strong>M&oacute;dulo 1.&nbsp;</strong><strong>Introducci&oacute;n a HTML5.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Conceptos b&aacute;sicos.</li>\r\n	<li>Compatibilidad y soporte con navegadores.</li>\r\n	<li>Etiquetas de HTML5.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 2.&nbsp;Introducci&oacute;n a CSS3.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>La evoluci&oacute;n que representa CSS3.</li>\r\n	<li>Nuevos selectores CSS3.</li>\r\n	<li>Esquinas redondeadas y sombras.</li>\r\n	<li>Colores.</li>\r\n	<li>Gradientes de color.</li>\r\n	<li>Incrustaci&oacute;n de fuentes.</li>\r\n	<li>D&oacute;nde obtener fuentes.</li>\r\n	<li>M&uacute;ltiples im&aacute;genes de fondo.</li>\r\n	<li>Transiciones.</li>\r\n	<li>Transformaciones.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 3.</strong>&nbsp;<strong>Formularios.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Nuevos campos.</li>\r\n	<li>validaci&oacute;n de cliente.</li>\r\n	<li>atributo.</li>\r\n	<li>Type.</li>\r\n	<li>Estilos.</li>\r\n	<li>Tags y metatags.</li>\r\n	<li>EL OBJETO FORM.</li>\r\n	<li>Formularios HTML.</li>\r\n	<li>El conjunto forms.</li>\r\n	<li>La propiedad elements.</li>\r\n	<li>Validar la informaci&oacute;n.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 4.&nbsp;</strong><strong>Introducci&oacute;n a Java Script.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Fundamentos de Programaci&oacute;n.</li>\r\n	<li>Estructuras de decisi&oacute;n.</li>\r\n	<li>Expresiones l&oacute;gicas y&nbsp;de repetici&oacute;n.</li>\r\n	<li>Definir y llamar funciones.</li>\r\n	<li>&Aacute;mbito de las variables.</li>\r\n	<li>Validaci&oacute;n avanzada de formularios</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 5.&nbsp;</strong><strong>Video y audio en HTML5.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Reproducci&oacute;n sin plugin.</li>\r\n	<li>La etiqueta.</li>\r\n	<li>Formatos y c&oacute;decs de v&iacute;deo.</li>\r\n	<li>C&oacute;decs de audio.</li>\r\n	<li>La etiqueta.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 6</strong>.&nbsp;<strong>Canvas y dibujado.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>API de canvas.</li>\r\n	<li>Im&aacute;genes.</li>\r\n	<li>Gradientes.</li>\r\n	<li>canvas.</li>\r\n	<li>Aplicaciones de uso.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 7.</strong>&nbsp;<strong>Manipulaci&oacute;n de DOM.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>Modificar el valor de los nodos.</li>\r\n	<li>Recorrer el &aacute;rbol del documento.</li>\r\n	<li>Crear, eliminar y reemplazar nodos.</li>\r\n	<li>El m&eacute;todo innerHTML.</li>\r\n	<li>Modificar el formato din&aacute;micamente.</li>\r\n</ol>\r\n\r\n<ul>\r\n	<li><strong>M&oacute;dulo 8.</strong>&nbsp;<strong>Geolocalizaci&oacute;n.</strong></li>\r\n</ul>\r\n\r\n<ol style=\"margin-left:40px\">\r\n	<li>API de geolocalizaci&oacute;n.</li>\r\n	<li>Detectar la ubicaci&oacute;n.</li>\r\n	<li>Insertar marcadores en el mapa.</li>\r\n	<li>Agregar ventanas emergentes con informaci&oacute;n.</li>\r\n	<li>Cuestionario y actividad integradora.</li>\r\n</ol>\r\n',1,4000,1);
/*!40000 ALTER TABLE `tbl_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer`
--

DROP TABLE IF EXISTS `tbl_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `EMAIL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ADDRESS` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `BIRTH_DATE` date DEFAULT NULL,
  `TAX_ADDRESS` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TAX_ADDRESS_2` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RFC` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `GENDER` smallint(6) DEFAULT NULL,
  `CURP` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer`
--

LOCK TABLES `tbl_customer` WRITE;
/*!40000 ALTER TABLE `tbl_customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_customer_purchase`
--

DROP TABLE IF EXISTS `tbl_customer_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_customer_purchase` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SALE_PROMOTION_ID` int(11) DEFAULT NULL,
  `CUSTOMER_ID` int(11) DEFAULT NULL,
  `PRODUCT_ID` int(11) DEFAULT NULL,
  `PURCHASE_DATE` datetime DEFAULT NULL,
  `PRICE_CUSTOMER_PAID` decimal(10,0) DEFAULT NULL,
  `ANOTHER_DETAIL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SALE_PROMOTION_ID` (`SALE_PROMOTION_ID`),
  KEY `CUSTOMER_ID` (`CUSTOMER_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `tbl_customer_purchase_ibfk_1` FOREIGN KEY (`SALE_PROMOTION_ID`) REFERENCES `tbl_sale_promotion` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `tbl_customer_purchase_ibfk_2` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `tbl_customer` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `tbl_customer_purchase_ibfk_3` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `tbl_product` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_customer_purchase`
--

LOCK TABLES `tbl_customer_purchase` WRITE;
/*!40000 ALTER TABLE `tbl_customer_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_customer_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_document`
--

DROP TABLE IF EXISTS `tbl_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_document` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) DEFAULT NULL,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DOCUMENT_TYPE` smallint(6) DEFAULT NULL,
  `DESCRIPTION` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PATH` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SIZE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `THUMBNAIL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_URL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_8` (`COURSE_ID`),
  CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`COURSE_ID`) REFERENCES `tbl_course` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_document`
--

LOCK TABLES `tbl_document` WRITE;
/*!40000 ALTER TABLE `tbl_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_document_methodology`
--

DROP TABLE IF EXISTS `tbl_document_methodology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_document_methodology` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `METHODOLOGY_ID` int(11) DEFAULT NULL,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DOCUMENT_TYPE` smallint(6) DEFAULT NULL,
  `DESCRIPTION` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PATH` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SIZE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `THUMBNAIL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_URL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `METHODOLOGY_ID` (`METHODOLOGY_ID`),
  CONSTRAINT `METHODOLOGY_ID` FOREIGN KEY (`METHODOLOGY_ID`) REFERENCES `tbl_methodology` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_document_methodology`
--

LOCK TABLES `tbl_document_methodology` WRITE;
/*!40000 ALTER TABLE `tbl_document_methodology` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_document_methodology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_document_promotion`
--

DROP TABLE IF EXISTS `tbl_document_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_document_promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROMOTION_ID` int(11) DEFAULT NULL,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DOCUMENT_TYPE` smallint(6) DEFAULT NULL,
  `DESCRIPTION` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PATH` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SIZE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `THUMBNAIL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_URL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PROMOTION_ID` (`PROMOTION_ID`),
  CONSTRAINT `tbl_document_promotion_ibfk_1` FOREIGN KEY (`PROMOTION_ID`) REFERENCES `tbl_sale_promotion` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_document_promotion`
--

LOCK TABLES `tbl_document_promotion` WRITE;
/*!40000 ALTER TABLE `tbl_document_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_document_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_hierarchy_level`
--

DROP TABLE IF EXISTS `tbl_hierarchy_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_hierarchy_level` (
  `LEVEL_NUMBER` int(11) NOT NULL,
  `NAME` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPTION` text COLLATE utf8_spanish_ci,
  PRIMARY KEY (`LEVEL_NUMBER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_hierarchy_level`
--

LOCK TABLES `tbl_hierarchy_level` WRITE;
/*!40000 ALTER TABLE `tbl_hierarchy_level` DISABLE KEYS */;
INSERT INTO `tbl_hierarchy_level` VALUES (10,'TECNOLOGÍA','Tecnologías  que se utilizaran en los cursos'),(100,'BRANCH','Ramas principales de las tecnologías'),(1000,'CURSO','CURSOS Por impartir'),(2000,'TUTORIAL','Tutoriales que ofreceremos al publico'),(3000,'Metodología','Nivel para categorizar todas las metodologías');
/*!40000 ALTER TABLE `tbl_hierarchy_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_keyword`
--

DROP TABLE IF EXISTS `tbl_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_keyword` (
  `WORD` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`WORD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_keyword`
--

LOCK TABLES `tbl_keyword` WRITE;
/*!40000 ALTER TABLE `tbl_keyword` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_keyword_course`
--

DROP TABLE IF EXISTS `tbl_keyword_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_keyword_course` (
  `COURSE_ID` int(11) DEFAULT NULL,
  `WORD` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  KEY `FK_REFERENCE_2` (`COURSE_ID`),
  KEY `FK_REFERENCE_3` (`WORD`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`COURSE_ID`) REFERENCES `tbl_course` (`ID`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`WORD`) REFERENCES `tbl_keyword` (`WORD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_keyword_course`
--

LOCK TABLES `tbl_keyword_course` WRITE;
/*!40000 ALTER TABLE `tbl_keyword_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_keyword_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_keyword_tutorial`
--

DROP TABLE IF EXISTS `tbl_keyword_tutorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_keyword_tutorial` (
  `TUTORIAL_ID` int(11) NOT NULL DEFAULT '0',
  `WORD` varchar(100) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`TUTORIAL_ID`,`WORD`),
  KEY `WORD` (`WORD`),
  CONSTRAINT `tbl_keyword_tutorial_ibfk_1` FOREIGN KEY (`TUTORIAL_ID`) REFERENCES `tbl_tutorial` (`ID`),
  CONSTRAINT `tbl_keyword_tutorial_ibfk_2` FOREIGN KEY (`WORD`) REFERENCES `tbl_keyword` (`WORD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_keyword_tutorial`
--

LOCK TABLES `tbl_keyword_tutorial` WRITE;
/*!40000 ALTER TABLE `tbl_keyword_tutorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_keyword_tutorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_mentoring_hyerarchy`
--

DROP TABLE IF EXISTS `tbl_mentoring_hyerarchy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_mentoring_hyerarchy` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STAFF_ID` int(11) DEFAULT NULL,
  `LEVEL_NUMBER` int(11) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPTION` text COLLATE utf8_spanish_ci,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_4` (`STAFF_ID`),
  KEY `FK_REFERENCE_5` (`LEVEL_NUMBER`),
  KEY `FK_REFERENCE_6` (`PARENT_ID`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`STAFF_ID`) REFERENCES `tbl_staff` (`ID`),
  CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`LEVEL_NUMBER`) REFERENCES `tbl_hierarchy_level` (`LEVEL_NUMBER`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`PARENT_ID`) REFERENCES `tbl_mentoring_hyerarchy` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_mentoring_hyerarchy`
--

LOCK TABLES `tbl_mentoring_hyerarchy` WRITE;
/*!40000 ALTER TABLE `tbl_mentoring_hyerarchy` DISABLE KEYS */;
INSERT INTO `tbl_mentoring_hyerarchy` VALUES (0,NULL,NULL,NULL,'ROOT',NULL,1),(18,1,10,0,'JAVA','Lenguaje de programacion orientado a objetos',1),(19,1,10,0,'PHP','Lenguaje de programacion interpretado',1),(20,1,10,0,'.NET','Lenguaje de programacion de Microsoft',1),(22,1,100,18,'Java Básico','Los cursos básicos son los mas importantes para aquellos programadores que están interesados en aprender una nueva tecnología para el desarrollo de software, en JAVA es de suma importancia conocer la bases  debido a la gran cantidad de FRAMEWORKS que se utilizan en la industria.',1),(23,1,100,18,'Java Intermedio','Java Intermedio es la antesala de la implementación de arquitecturas serias en aplicaciones empresariales, por eso es que en esta categoría vemos a fondo las características que J2EE nos proporciona en el desarrollo de aplicaciones web como lo son MVC y patrones de diseño.',1),(24,1,1000,22,'Java Básico','Desarrollo de aplicaciones con j2se',1),(25,1,100,19,'PHP Básico','PHP es un lenguaje de scripting que nació para el desarrollo de aplicaciones Web, es Open Source y actualmente es el mas utilizado en la creación de páginas WEB. Sus últimas versiones tienen amplio soporte de la POO, existen Frameworks que facilitan el desarrollo de grandes aplicaciones.',1),(26,1,1000,25,'PHP & JQuery','Integracion PHP 5.0 y JQuery en la implementacion de aplicacion MVC con acceso de BD.',1),(27,1,10,0,'Mobile','Tecnologias para el desarrollo de aplicaciones que funcionen en dispositivos mobiles como tablets y smartphones',1),(28,1,10,0,'Web Design','Tecnologías utilizadas para realizar diseño e implementación de layouts y plantillas de sitios WEB.',1),(29,1,10,0,'Administración de Riesgos','Cursos especializados en las principales metodologías para la valuación de los distintos instrumentos  financieros y el calculo de los riesgos asociados a estos.',1),(30,1,10,0,'Modelado','Tecnologias para el modelado en 2D y 3D.',1),(32,1,100,18,'Java Avanzado','Cursos avanzados, requieren bases solidas de J2SE.',1),(33,1,1000,32,'Java WebServices','',1),(34,1,1000,23,'Java Intermedio','aquí agregaremos todos los cursos de java intermedio',1),(35,1,1000,32,'Spring & Struts Integration','',1),(38,1,2000,23,'TUTORIALES JAVA INTERMEDIO','Tutoriales de Java intermedio',1),(39,1,2000,22,'TUTORIALES JAVA BASICO','Tutoriales intemedios relacionados NIO',1),(40,1,2000,32,'TUTORIALES JAVA AVANZADO','Tutoriales para java de avanzada',1),(41,2,3000,0,'Metodología Desarrollo','Metodologías para desarrollo de Software',1),(42,1,10,0,'Adobe ','Integración de Flex con tecnologias del backend',1),(43,1,100,42,'Integración Flex-Java ','Integración de Flex y Java para el desarrollo de Aplicaciones WEB 2.0',1),(44,1,1000,43,'Aplicaciones WEB Flex - Java','En este curso el alumno aprenderá a realizar una integración entre tecnologias del front -end en este caso Flex y Java como tecnología banck end. ',1),(45,1,2000,46,'Tutoriales Android Básico','Primero proyecto Android',1),(46,1,100,27,'Android','Aprende a desarrollar aplicaciones móviles Android, este sistema operativo actualmente es predominante en el mercado de dispositivos móviles y su tienda de aplicaciones crece de manera exponencial.No te quedes fuera  aquí te proporcionamos capacitación de alto nivel, de nivel básico a experto.',1),(47,1,1000,46,'Android aplicaciones móviles, Nivel Básico.','En este curso proporcionamos al alumno bases sólidas en el desarrollo de aplicaciones móviles utilizando la plataforma Android. Comenzamos el curso desde la instalación y configuración del ambiente de desarrollo y terminamos con la publicación de de nuestra aplicación en Google Play.',1),(48,1,10,0,'Otras tecnologías','Otras tecnologías de programación',1),(49,1,100,48,'Phyton','Es un lenguaje de programación que permite el desarrollo rápido y una efectiva integración de sistemas. Programadores  de otros lenguajes pueden aprender Phyton de forma rápida, y aquellos que inician en la programación encontrarán un lenguaje limpio y bien estructurado.',1),(50,1,1000,49,'Python Básico ','',1),(51,1,100,28,'HTML 5 , CSS y JavaScript','Un sólido conocimiento en CSS y JavaScript es fundamental para permanecer vigentes en el área del desarrollo WEB, sitios responsivos y adaptables a diferentes dispositivos exigen un alto conocimiento en ambas tecnologías. Ven y aprende con nosotros.',1),(52,1,1000,51,'CSS, JavaScript y HTML 5','Obtén las bases en CSS y JavaScript para crear páginas HTML 5  con un contenido visual de calidad, aprende a manipular una pagina WEB con JavaScript y darle presentación con hojas de estilo. JS y CSS son fundamentales para explotar y entender al máximo JQuery, EXT JS,  Bootstrap y otras librerias.',1),(53,1,100,27,'Appcelerator Studio','Aprende a desarrollar aplicaciones móviles con Appcelerator Studio, desde aplicaciones básicas hasta realizar conexiones a WebServices, Base de datos SQLite e integración con API\'s de google y Facebook. Aprovecha Appcelerator, programa solo una vez  y exporta tu aplicaciones para Android e iOS.',1),(54,1,1000,53,'Appcelerator Studio','Este curso va enfocado a todo aquel interesado en adquirir los conocimientos desde nivel básico \r\npara  el  desarrollo  de  Aplicaciones  Móviles  para  plataformas  Android  e  iOS  usando  JavaScript  y \r\nAppcelerator Studio.',1),(55,1,1000,32,'Spring WEB MVC','Desarrollo de aplicaciones WEB utilizando Spring Web MVC',1),(56,1,2000,25,'PHP Básico','Los mejores tutoriales de PHP desde cero, disfrútenlos.',1),(57,1,100,29,'Mercado de dinero','Análisis de riesgo en el Mercado Mexicano',1),(59,1,1000,57,'Valuación de Bonos tasa cero, variable y cupon','Mercado de Dinero',1),(60,1,100,30,'AutoCad','Curso orientado para que que el alumno aprenda a diseñar y dar forma al mundo que lo rodea con poderosas herramientas de diseño conectadas en el software AutoCAD. Cree sorprendentes diseños en 2D y 3D. Presente propuestas elegantes y profesionales con lo aprendido en nuestros cursos.',1),(61,1,1000,60,'AutoCad 2D y 3D','AutoCad 2d y 3D',1),(62,1,10,0,'Computación y Ofimática','Cursos de computación y ofimática orientados a formar profesionales para su integración al mundo laboral. Entrénate con nuestros instructores expertos, aprende desde cero con nuestros cursos prácticos.',1),(63,1,100,62,'Computación','Aprende a utilizar la computadora como un experto, conoce que partes la componen y como funcionan. Ya no dependas más y realiza todas tus actividades que requieren su uso.',1),(64,1,100,62,'Ofimática','Cursos de ofimática orientados a formar profesionales para su integración al mundo laboral. Entrénate con nuestros instructores expertos en toda la suite de Microsoft Office desde nivel básico hasta avanzado. Nuestros cursos están garantizados.\r\n',1),(65,1,1000,64,'Excel','Curso orientado a toda aquella persona que quiera aprender desde nivel básico hasta avanzado el uso de Microsoft Excel.',1),(66,1,2000,63,'TUTORIALES DE COMPUTACIÓN ','Estos tutoriales te van a servir para poder comprender mejor las partes y el uso de la computadora, desde nivel básico hasta avanzado.\r\n',1),(67,1,100,20,'Visual Studio .NET Básico','',1),(68,1,1000,67,'VISUAL BASIC .NET','',1),(69,1,10,0,'Certificaciones','Cursos orientados a entrenar al alumno para certificarse en diferentes tecnologías',1),(70,1,100,69,'Java','Cursos orientados a certificarse en diferentes niveles de la tecnología Java',1),(71,1,1000,70,'Oracle Certified Java Programmer','En MentoringIT tenemos un entrenamiento especializado para que el alumno pueda certificarse como Java Programmer, nuestro curso está enfocado en el aprendizaje real del alumno.',1),(72,1,2000,51,'HTML-CSS y JavaScript','Tutoriales para aprender a utilizar JavaScript como lenguaje de programación en desarrollo de aplicaciones FullStack',1);
/*!40000 ALTER TABLE `tbl_mentoring_hyerarchy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_methodology`
--

DROP TABLE IF EXISTS `tbl_methodology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_methodology` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HIERARCHY_ID` int(11) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL,
  `NAME` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RESUME` text COLLATE utf8_spanish_ci,
  `DESCRIPTION` text COLLATE utf8_spanish_ci,
  `ALIAS` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RANK` smallint(6) DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_METHO_HIERARCHY` (`HIERARCHY_ID`),
  KEY `FK_SELF_METHO_HIERARCHY` (`PARENT_ID`),
  CONSTRAINT `FK_REFERENCE_METHO_HIERARCHY` FOREIGN KEY (`HIERARCHY_ID`) REFERENCES `tbl_mentoring_hyerarchy` (`ID`),
  CONSTRAINT `FK_SELF_METHO_HIERARCHY` FOREIGN KEY (`PARENT_ID`) REFERENCES `tbl_methodology` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_methodology`
--

LOCK TABLES `tbl_methodology` WRITE;
/*!40000 ALTER TABLE `tbl_methodology` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_methodology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_payment`
--

DROP TABLE IF EXISTS `tbl_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_payment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL,
  `NUM_PAYMENT` int(11) DEFAULT NULL,
  `AMOUNT_PAYMENT` decimal(10,0) DEFAULT NULL,
  `TYPE_PAYMENT` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DATE_PAYMENT` datetime DEFAULT NULL,
  `TOTAL_COURSE` decimal(10,0) DEFAULT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `STUDENT_ID` (`STUDENT_ID`),
  KEY `COURSE_ID` (`COURSE_ID`),
  CONSTRAINT `tbl_payment_ibfk_1` FOREIGN KEY (`STUDENT_ID`) REFERENCES `tbl_student` (`ID`),
  CONSTRAINT `tbl_payment_ibfk_2` FOREIGN KEY (`COURSE_ID`) REFERENCES `tbl_course` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_payment`
--

LOCK TABLES `tbl_payment` WRITE;
/*!40000 ALTER TABLE `tbl_payment` DISABLE KEYS */;
INSERT INTO `tbl_payment` VALUES (1,6,14,1,500,'Efectivo','2017-02-02 00:00:00',3000,0),(2,6,14,2,1000,'Efectivo','2017-02-02 00:00:00',3000,0),(3,6,14,3,500,'Efectivo','2017-02-02 00:00:00',3000,0),(4,6,14,4,500,'Efectivo','2017-02-02 00:00:00',3000,0),(5,7,14,1,1000,'Efectivo','2017-02-02 00:00:00',3000,3000),(6,7,14,2,500,'Efectivo','2017-02-02 00:00:00',3000,3000),(7,7,14,3,500,'Efectivo','2017-02-02 00:00:00',3000,3000);
/*!40000 ALTER TABLE `tbl_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_ID` int(11) DEFAULT NULL,
  `NAME` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPTION` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `START_DATE` date DEFAULT NULL,
  `TOTAL_PEOPLE` smallint(6) DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  `RECOMMENDED_RETAIL_PRICE` decimal(10,0) DEFAULT NULL,
  `ANOTHER_DETAILS` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `COURSE_ID` (`COURSE_ID`),
  CONSTRAINT `tbl_product_ibfk_1` FOREIGN KEY (`COURSE_ID`) REFERENCES `tbl_course` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=892349 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (1,14,'Curso Java desde cero','Curso en Zona Rosa, Londres 114','2016-02-27',5,1,5800,'curso java desde cero de 8 a 10 pm'),(2,14,'java desde cero','java desde cero','2016-04-23',5,1,4500,'curso planeado para iniciar 27 de octubre 2014'),(3,21,'logica de programacion','logica de programacion','2016-08-20',5,1,0,'logica de programacion orientada a programadores principiantes y testers'),(101,20,'Curso Java web','','2017-02-04',6,1,4500,'Inicia curso Edgar, Ivan, Carolina, Miguel, '),(1000,22,'integracion de frameworks java ee','curso avanzado, se requieren conocimientos nivel intermedio en la tecnologia y aplicaciones WEB','2016-05-14',NULL,1,6500,''),(1002,20,'Aplicaciones Java Web','curso java web','2016-08-06',5,1,5000,''),(2000,25,'Curso Básico Android','Curso Android','2015-06-06',5,1,4500,'para zona rosa de lunes a jueves'),(2001,27,'Curso JS, CSS y HTML','','2015-07-04',5,1,4500,'nuevo curso'),(3000,21,'Lógica de Programación','Curso orientado a principiantes en programacion','2016-08-22',5,1,3500,''),(9032,22,'Curso de Frameworks','El alumno lo quiere sabatino de 1 a 6 pm','2015-03-15',4,1,6500,'se requiere mínimo 50% de anticipo'),(12345,18,'Java web services 2','Segundo curso de java web services','2014-07-26',6,1,3000,'ninguno'),(34561,18,'Java web services 1','test','2014-09-06',1,1,2000,'test'),(892345,20,'Aplicaciones Java Web','test','2015-10-24',1,1,2000,'ninguno'),(892346,22,'curso frameworks','curso de frameworks','2015-04-11',6,1,6500,'precio por persona'),(892347,29,'Spring Web','Curso Spring Web','2016-02-29',5,1,7500,''),(892348,29,'Curso Spring Web MVC','','2016-02-27',5,1,7500,'');
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_profiles`
--

DROP TABLE IF EXISTS `tbl_profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_profiles` (
  `user_id` int(11) NOT NULL,
  `lastname` varchar(50) NOT NULL DEFAULT '',
  `firstname` varchar(50) NOT NULL DEFAULT '',
  `birthday` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_profiles`
--

LOCK TABLES `tbl_profiles` WRITE;
/*!40000 ALTER TABLE `tbl_profiles` DISABLE KEYS */;
INSERT INTO `tbl_profiles` VALUES (1,'Admin','Administrator','0000-00-00'),(8,'Culqui Culqui','Fernando Fabián','1965-01-20');
/*!40000 ALTER TABLE `tbl_profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_profiles_fields`
--

DROP TABLE IF EXISTS `tbl_profiles_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_profiles_fields` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `varname` varchar(50) NOT NULL,
  `title` varchar(255) NOT NULL,
  `field_type` varchar(50) NOT NULL,
  `field_size` int(3) NOT NULL DEFAULT '0',
  `field_size_min` int(3) NOT NULL DEFAULT '0',
  `required` int(1) NOT NULL DEFAULT '0',
  `match` varchar(255) NOT NULL DEFAULT '',
  `range` varchar(255) NOT NULL DEFAULT '',
  `error_message` varchar(255) NOT NULL DEFAULT '',
  `other_validator` varchar(5000) NOT NULL DEFAULT '',
  `default` varchar(255) NOT NULL DEFAULT '',
  `widget` varchar(255) NOT NULL DEFAULT '',
  `widgetparams` varchar(5000) NOT NULL DEFAULT '',
  `position` int(3) NOT NULL DEFAULT '0',
  `visible` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `varname` (`varname`,`widget`,`visible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_profiles_fields`
--

LOCK TABLES `tbl_profiles_fields` WRITE;
/*!40000 ALTER TABLE `tbl_profiles_fields` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_profiles_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_registration`
--

DROP TABLE IF EXISTS `tbl_registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_registration` (
  `COURSE_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) NOT NULL,
  `STATUS` smallint(6) NOT NULL,
  `DATE_JOINED` datetime DEFAULT NULL,
  `COMMENT` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`COURSE_ID`,`STUDENT_ID`),
  KEY `FK_REFERENCE_8` (`COURSE_ID`),
  KEY `FK_REFERENCE_9` (`STUDENT_ID`),
  CONSTRAINT `FK_REFERENCE_10` FOREIGN KEY (`STUDENT_ID`) REFERENCES `tbl_student` (`ID`),
  CONSTRAINT `FK_REFERENCE_12` FOREIGN KEY (`STUDENT_ID`) REFERENCES `tbl_student` (`ID`),
  CONSTRAINT `FK_REFERENCE_13` FOREIGN KEY (`COURSE_ID`) REFERENCES `tbl_course` (`ID`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`COURSE_ID`) REFERENCES `tbl_course` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_registration`
--

LOCK TABLES `tbl_registration` WRITE;
/*!40000 ALTER TABLE `tbl_registration` DISABLE KEYS */;
INSERT INTO `tbl_registration` VALUES (14,6,1,'2000-01-01 00:00:00','it is good'),(14,7,1,'2000-01-01 00:00:00','it is good'),(14,8,1,'2000-01-01 00:00:00','it is good'),(14,19,1,'2000-02-01 00:00:00','it is good'),(14,20,1,'2000-02-01 00:00:00','it is good'),(14,21,1,'2000-02-01 00:00:00','it is good'),(14,28,1,'2015-12-01 00:00:00','it is good'),(16,7,1,'2000-01-01 00:00:00','it is good'),(16,8,1,'2000-01-01 00:00:00','it is good'),(16,9,1,'2000-01-01 00:00:00','it is good'),(16,22,1,'2000-02-01 00:00:00','it is good'),(16,23,1,'2000-02-01 00:00:00','it is good'),(16,24,1,'2000-02-01 00:00:00','it is good'),(18,10,1,'2000-01-01 00:00:00','it is good'),(18,11,1,'2000-01-01 00:00:00','it is good'),(18,12,1,'2000-01-01 00:00:00','it is good'),(18,25,1,'2000-03-01 00:00:00','it is good'),(18,26,1,'2000-03-01 00:00:00','it is good'),(18,27,1,'2000-03-01 00:00:00','it is good'),(18,29,1,'2017-12-01 00:00:00','it is good'),(19,13,1,'2000-01-01 00:00:00','it is good'),(19,14,1,'2000-01-01 00:00:00','it is good'),(19,15,1,'2000-01-01 00:00:00','it is good'),(20,16,1,'2000-01-01 00:00:00','it is good'),(20,17,1,'2000-01-01 00:00:00','it is good'),(20,18,1,'2000-01-01 00:00:00','it is good'),(20,30,1,'2017-01-25 00:00:00','it is good'),(20,31,1,'2017-01-25 13:46:45','it is good');
/*!40000 ALTER TABLE `tbl_registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sale_promotion`
--

DROP TABLE IF EXISTS `tbl_sale_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_sale_promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  `NAME` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESCRIPTION` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sale_promotion`
--

LOCK TABLES `tbl_sale_promotion` WRITE;
/*!40000 ALTER TABLE `tbl_sale_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_sale_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_staff`
--

DROP TABLE IF EXISTS `tbl_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `GENDER` smallint(6) DEFAULT NULL,
  `DATE_JOINED` date DEFAULT NULL,
  `DATE_LEFT` date DEFAULT NULL,
  `DATE_BIRTH` date DEFAULT NULL,
  `ROLE` smallint(6) DEFAULT NULL,
  `PHOTO_FILENAME` varchar(500) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_staff`
--

LOCK TABLES `tbl_staff` WRITE;
/*!40000 ALTER TABLE `tbl_staff` DISABLE KEYS */;
INSERT INTO `tbl_staff` VALUES (1,'Miguel Angel',1,'2011-01-01','2011-01-01','2011-01-01',1,'test',1),(2,'Jose de Jesus',1,'2014-08-29','2014-08-24','2014-08-15',1,'',1);
/*!40000 ALTER TABLE `tbl_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_student`
--

DROP TABLE IF EXISTS `tbl_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PHONE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ADDRESS` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` smallint(6) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=345 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_student`
--

LOCK TABLES `tbl_student` WRITE;
/*!40000 ALTER TABLE `tbl_student` DISABLE KEYS */;
INSERT INTO `tbl_student` VALUES (6,'jjnataren@hotmail.com','test234','56234','',1),(7,'mangelg1984@gmail.com','miguel angel garcia','5558553769','',1),(8,'ingwillianpaternina2101@gmail.com','Willian alberto paternina romo','6674233',NULL,1),(9,'brayan_26_1993@hotmail.com','brayan trujillo nieto','944268280',NULL,1),(10,'Nahum.Olves@gmail.com','Nahum Efe Olves','',NULL,1),(11,'jjbenavidez@yahoo.es','benavidez jose','003456899123',NULL,1),(12,'alonso.atoneyra@gmail.com','Alonso Ato Neyra','941443811',NULL,1),(13,'erikskate1994@hotmail.com','erik joel peimbert cabrera','5547827736',NULL,1),(14,'cdiaz@sistemasmir.com','carlos diaz','3146537866',NULL,1),(15,'ale.siug23@hotmail.com','Guisela Fernandez','0983169816','',1),(16,'gallegorh@hotmail.com','REINEL GALLEGO HANSSON','3185206707',NULL,1),(17,'gdaza85@gmail.com','Gerardo Daza','5555555555555','',1),(18,'filipo120@hotmail.com','oscar dario ortiz','3134993184',NULL,1),(19,'mangelg@intercam.com.mx','Miguel Angel Garcia','5511472903',NULL,1),(20,'marco_zoni28@hotmail.com','Marco Antonio ','4331037028',NULL,1),(21,'checito_tho_pepito@hotmail.com','Jose Angel Carrera','5539836830',NULL,1),(22,'lulu_0520@hotmail.com','Lourdes Galvan','0445541944552',NULL,1),(23,'prueba@prueba.com','alfonso lopez guajardo','8787878787',NULL,1),(24,'aldoaxe@hotmail.com','Al hp ','',NULL,1),(25,'santiago2393@hotmail.com','Santiago Andres Herrera Valencia','3005623144',NULL,1),(26,'montufargustavo31@gmail.com','Gustavo Montufar Bravo ','+56959948146 ',NULL,1),(27,'ram_facu@hotmail.com','José Ramon Cabrera Facundo','-',NULL,1),(28,'dragon_jhf@hotmail.com','Deybis Juarez Hernandez','55 42 29 48 63',NULL,1),(29,'mguevara@zabyca.com','Mauricio Guevara','0994432542',NULL,1),(30,'manuelmiranda202@gmail.com','manuel isaias miranda jarquin','+505 87155996',NULL,1),(31,'ing.heriberto.garcia@gmail.com','Heriberto Garcia Zamora','5545732171',NULL,1),(32,'canchito27@yahoo.com','Emilio Gonzalez Ramirez','012452134565',NULL,1),(33,'laraaa_aided@hotmail.com','carmen lar','5591646137',NULL,1),(34,'hernandezg.880@gmail.com','Gabriel Hernandez Anaya','5534377540',NULL,1),(35,'omar.lara79@gmail.com','Omar LAra','10838000',NULL,1),(36,'asielscorp@hotmail.com','Asiel Jimenez Oropeza','2381099939',NULL,1),(37,'darel233455@gmail.com','luidji','59408489854',NULL,1),(38,'klark2d4@gmail.com','klark','21537242713',NULL,1),(39,'kevin.s.9932@hotmail.com','kevin serrano','',NULL,1),(40,'casz21@hotmail.com','CARLOS ANDRES SANTACRUZ ZAMBRANO','',NULL,1),(41,'aggf2014@gmail.com','Angel Guamán','',NULL,1),(42,'johnes180@hotmail.com','John Roldan','3122660581',NULL,1),(43,'marloncastro1515@gmail.com','marlon castro','+505 89307828',NULL,1),(44,'dvjfiremix@gmail.com','krizthian enrique','',NULL,1),(45,'yaha_gonza@hotmail.com','yahaira Glez','',NULL,1),(46,'pablo_perez_lucia@hotmail.com','Lucia Pablo Perez ','5520232419',NULL,1),(47,'fede.polo.p@gmail.com','Federico Polo Pascual','55 6577 5617',NULL,1),(48,'m.angel.osorio.p@gmail.com','Miguel Angel Osorio Pulido','5540442468',NULL,1),(49,'smallvillejav@hotmail.com','javier hernandez sandoval','5525709776',NULL,1),(50,'anakaren2390@hotmail.com','ANA KAREN D\' SANTILLANA AVILA','0445517848481',NULL,1),(51,'cero25@hotmail.es','Pedro Cruz Rivas','9171132828',NULL,1),(52,'jennyferlopezllanten@gmail.com','jennyfer cecilia lopez llanten','3113113471',NULL,1),(53,'jorge.diaz.t@gmail.com','Jorge Diaz','962383640',NULL,1),(54,'surfer_jfktournament@hotmail.com','Jesus Francisco Perez Saavedra','',NULL,1),(55,'darktoro127@hotmail.com','carlos toro','',NULL,1),(56,'lic2012abra@hotmail.com','Jose Abrahan Araiza Gutierrez','',NULL,1),(57,'fd_apolo@gmail.com','Federico Polo  Pascual','55 6577 5617',NULL,1),(58,'werokrush@gmail.com','Daniel Ortega Careaga','+527225128842',NULL,1),(59,'jose_1985c@hotmail.com','Jose Hugo','',NULL,1),(60,'daniel.mendez@cimat.mx','Daniel Méndez Cruz','9612766271',NULL,1),(61,'amairani10693d@gmail.com','Jessica Amairani Diaz Basurto','55 6231 9201',NULL,1),(62,'alberto@ideashappy.com','Alberto Luebbert','5531321143',NULL,1),(63,'lucas2d44@gmail.com','Bradley','22590304265',NULL,1),(64,'juan_amaya28@yahoo.com','juan alberto amaya','',NULL,1),(65,'niche_3010@hotmail.com','Eunice Ramirez Sosa','',NULL,1),(66,'lsofiadelapena@gmail.com','de la peña sofia','5520739827',NULL,1),(67,'carrier_6@hotmail.com','Christian Torres','',NULL,1),(68,'cirfly69@gmail.com','Carlos Cortés Bazán','5522694154',NULL,1),(69,'moisesdwgibson777@gmail.com','Melvin Moisés Sierra Dubon','87977999',NULL,1),(70,'isma19_mayito_90@hotmail.es','carlos','7772720130',NULL,1),(71,'eleaa_2793@hotmail.com','Eleazar Mendoza Gomez','8114143509',NULL,1),(72,'michole77@hotmail.com','Miguel Angel Menchú Xoyón','57200828',NULL,1),(73,'wjr1984@gmail.com','wolfgang jose rodriguez','04120884172',NULL,1),(74,'ivanbetaipnnms@gmail.com','Elias Ivan Carrillo González','47561923',NULL,1),(75,'jorhs_55@hotmail.com','Jonathan Rodríguez ','5541455912',NULL,1),(76,'manuelespinozacc@gmail.com','Manuel Leoncio Espinoza Catachunga','941936083',NULL,1),(77,'winftc@gmail.com','Wilber Torres','940170199',NULL,1),(78,'jhomohxd@gmail.com','Jhon Verde Jara','967731860',NULL,1),(79,'Jorgee.0203@hotmail.com','Jorge','',NULL,1),(80,'jose_pumista@hotmail.com','Juarez Castillo Jose Antonio ','5564220080',NULL,1),(81,'eliosnieto17@hotmail.com','Elios nieto','',NULL,1),(82,'robertoglzr@gmail.com','roberto gonzalez','',NULL,1),(83,'joslcontreras@yahoo.com','JOSÉ LUIS CONTRERAS ALVAREZ','3007822339',NULL,1),(84,'mauro.sam1989@gmail.com','maurico samboni','320127621',NULL,1),(85,'jairoacosta_@hotmail.com','jairo enrique acosta quintero','02612115849',NULL,1),(86,'sysnets@Ice.co.cr','Gerardo Mora','506-88842254',NULL,1),(87,'rolandovalenciag@gmail.com','rolando valencia garcia','3157489419',NULL,1),(88,'salmoran1985@hotmail.com','Eloy Sanchez Salmoran','9531097572',NULL,1),(89,'wiska_66@hotmail.com','virginia guadalupe ortega valverde','5528958659',NULL,1),(90,'cr7_beto_flores_luna@live.com','norberto flores luna','7711166211',NULL,1),(91,'jobh88@hotmail.com','José Becerra Herrera','',NULL,1),(92,'yeyen_kc20@hotmail.com','KEREN SANCHEZ SALINAS ','5545876298',NULL,1),(93,'elverde_6_are@hotmail.com','manuel moreno rios','7471491008',NULL,1),(94,'inganuarraad@hotmail.com','Anuar de Jesus Raad Licona','3006346457',NULL,1),(95,'rabm_82@hotmail.com','pedro','31245678',NULL,1),(96,'jferian@hotmail.com','Jose Feria Narvaez','9161211324',NULL,1),(97,'escandon1992@hotmail.com','escandon gonzales bismark marcos','0969411546',NULL,1),(98,'escandon1992@gmail.com','marcos bismark escandon gonzales ','0979596954',NULL,1),(99,'branchoas@hotmail.com','brandon sanchez','+573168435592',NULL,1),(100,'raul.diaz.elias@hotmail.com','Telesforo Raul Diaz Elias','2227755815',NULL,1),(101,'ercheco@hotmail.com','Erik Sergio Guzman Contreras','0445535293171',NULL,1),(102,'raul.pina.vazquez@gmail.com','raul pina vazquez','7121818904',NULL,1),(103,'itachihatake@gmail.com','angel gonzalez cervantes','',NULL,1),(104,'sidlord@hotmail.com','Juan Manuel Hernandez','015545202650',NULL,1),(105,'FJVM60@gmail.com','Francisco Vega ','7',NULL,1),(106,'crlsgnzlzbnd@gmail.com','Carlos Gonzalez','0984253207',NULL,1),(107,'ravage40@gmail.com','Abril Gomez Carlos Alberto','59862437',NULL,1),(108,'maharba_siul@hotmail.com','Luis Abraham Aguilar Ruiz','',NULL,1),(109,'carloskinto16@gmail.com','Carlos Hip Garcia','47667009',NULL,1),(110,'HOL_PRODUCCIONES@HOTMAIL.COM','HUMBERTO ORTIZ LOPEZ','5517097447',NULL,1),(111,'mark357177@hotmail.com','Mark','37548030836',NULL,1),(112,'unaesperanza22@yahoo.com','Julio Sandoval','87174724',NULL,1),(113,'nagatotagan@gmail.com','Daniel Sanchez','9511212910',NULL,1),(114,'lamsitolam@gmail.com','Ángel Francisco Fernández Lam','9611688817',NULL,1),(115,'ManuelRex188@gmail.com','Manuel Chaidez','6181881795',NULL,1),(116,'gossweed420@gmail.com','Goss martin','+51931438676',NULL,1),(117,'oalejandro08@hotmail.com','Oscar Alejandro Monedero Posso','',NULL,1),(118,'palomares_jocker@hotmail.com','Juan Antonio Romero Palomares','7771102793',NULL,1),(119,'noeconde1@gmail.com','Noe Conde Cuamatzi','5563333310',NULL,1),(120,'rony_tk_10@hotmail.com','gregorio tomas castro alvarez','970782139',NULL,1),(121,'javis_barsan@hotmail.com','Javier Barrientos Sanchez','5527828714',NULL,1),(122,'edithnovoavilla@hotmail.com','Edith Novoa Villa','',NULL,1),(123,'jsbonilla2600@gmail.com','John Bonila','3163996743',NULL,1),(124,'ahmescorpio67@gmail.com','Armando Hernandez Miranda','5535536426',NULL,1),(125,'fanthonymiguel@hotmail.com','Miguel Jazael Faubla','093351359',NULL,1),(126,'andresmeji@gmail.com','Andrés Mejía.','4938600',NULL,1),(127,'alexvazdroid@gmail.com','Guillermo Alexander Vasquez Rodriguez','+50376032548',NULL,1),(128,'ing_yraad@hotmail.com','YESID RAAD ROMERO','3014610882',NULL,1),(129,'antoniojose558@gmail.com','Jose Antonio Parra Almazan','72957248',NULL,1),(130,'j-rojas12345@hotmail.com','jose luis capote','1234567',NULL,1),(131,'mer@hotmail.com','342135642','55634259678r',NULL,1),(132,'hg@hoymail.com','*******************************','hfhshckdkfkdfkkdsffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff',NULL,1),(133,'alcocerdavidbb@gmail.com','Alcocer Cañete David Bryan','957314311',NULL,1),(134,'edgargfernandez29@gmail.com','Edgar Gómez','',NULL,1),(135,'carferagus15@hotmail.com','carlos agustin','',NULL,1),(136,'j_h_unior17@hotmail.com','Julio Bellido Aranibar ','+59175438607',NULL,1),(137,'diegormoralesv@yahoo.com','Diego Morales ','3134702962',NULL,1),(138,'elgalom@gmail.com','Gal Men','',NULL,1),(139,'lopezruizisidro@gmail.com','ISIDRO LOPEZ RUIZ','9711042675',NULL,1),(140,'jahazielcampos@gmail.com','David Jahaziel Campos Vázquez','3131011734',NULL,1),(141,'isc_robert92@hotmail.com','roberto deaquino abril','2361063061',NULL,1),(142,'bellidoj17@gmail.com','Julio Bellido Aranibar','+59175438607',NULL,1),(143,'elius_05@hotmail.com','Abraham Elius Buensuceso Calderón','0445516999230',NULL,1),(144,'leduardocs91@gmail.com','Luis Eduardo Colin Sierra','7721419888',NULL,1),(145,'riverazarateomar@gmail.com','omar rivera zarate','949510239',NULL,1),(146,'josemanuelclaudio12612@gmail.com','José Manuel Claudio Hernández','41276803',NULL,1),(147,'fass92@misena.edu.co','Fabio Sanchez','',NULL,1),(148,'profesional_quiquesistemas@hotmail.com','Mario Enrique Jaimes Malvaez','4492765029',NULL,1),(149,'epclice_1994@hotmail.com','miguel  angel ','',NULL,1),(150,'betin18@live.com.mx','Roberto Hernández Reyes','',NULL,1),(151,'heribertobazan@gmail.com','ricardo valentino bazan','',NULL,1),(152,'hroger02@hotmail.com','Roger Aguilar Alvarez','995320633',NULL,1),(153,'andersonpp9@hotmail.com','Victor Perea','+51992735084',NULL,1),(154,'lucho_fely@hotmail.com','Luis Torres','0991911389',NULL,1),(155,'garynet79@hotmail.com','Gabriel Colque Choque','72489478',NULL,1),(156,'jdavidg0825@gmail.com','José David García','3216036090',NULL,1),(157,'freddylarios@hotmail.com','Fredy Larios','505+84748670',NULL,1),(158,'chaarly@live.com','charly martinez','3314266051',NULL,1),(159,'byroncholca@hotmail.com','Byron Cholca','0994910959',NULL,1),(160,'luischavezmaita9313@gmail.com','Luis Chávez','2371621',NULL,1),(161,'alpezg@gmail.com','Adelfo López Gorostieta','4431351449',NULL,1),(162,'uzielmercado11@hotmail.es','Uziel Esau Mercado Pérez ','34410375',NULL,1),(163,'clarin14@hotmail.com','Luisa Cerón Perea','5533483422',NULL,1),(164,'marine.dark@gmail.com','Joel Patricio Hilario','2491359394',NULL,1),(165,'sagiraldosa@unal.edu.ci','santiago','3225007315',NULL,1),(166,'dan.h.vargas.lopez@gmail.com','daniel vargas lopez','',NULL,1),(167,'thorhecescom@hotmail.com','Hector Alvarez Arciga','68414346',NULL,1),(168,'yasuhiro_meza@hotmail.com','yasuhiro georgno meza cantaro','987588104',NULL,1),(169,'ingebionic569z@outlook.com','Martín Sánchez','',NULL,1),(170,'diealetrejos@utp.edu.co','Diego Alejandro Trejos Estrada','+57 3207775219',NULL,1),(171,'jos_oh_@hotmail.com','Josue Olivera Hernandez','',NULL,1),(172,'roberto.toro@i3linkstech.com','Roberto L. Toro','',NULL,1),(173,'lizelpantoja@yahoo.com.mx','Lizbeth Pantoja Rodriguez','',NULL,1),(174,'luiguimon_03_05@hotmail.com','José Luis López Domínguez ','5535234083',NULL,1),(175,'gustavo0326@gmail.com','gustavo arcos','',NULL,1),(176,'cableger@live.com.mx','Pablo Germán Merino Mendoza','5560090971',NULL,1),(177,'mangelg@gmail.com','miguel angel','58354545',NULL,1),(178,'isaac.i.montes@gmail.com','Israel Isaac Montes de Oca Solis','5512863018',NULL,1),(179,'dalondoo@misena.edu.co','alejandor londoño c','3104599669',NULL,1),(180,'marisol_navarro@live.com.mx','Marisol Navarro','',NULL,1),(181,'rogerticonanina@gmail.com','Roger Ticona','993761313',NULL,1),(182,'gmix12gh@gmail.com','gmix','',NULL,1),(183,'edwin_58_@hotmail.com','edwin','',NULL,1),(184,'luisblanco93@hotmail.com','Luis','',NULL,1),(185,'oscarcaalrodriguez@hotmail.com','Oscar Caal','+502 41894667',NULL,1),(186,'njerazo@hotmail.com','nestor jairo erazo','3177779266',NULL,1),(187,'franz_cajahuanca@usmp.pe','Franz Irvin Cajahuanca Aquino','+51 964785576',NULL,1),(188,'c.r_sumer_10@hotmail.com','crmx','',NULL,1),(189,'luis.bellido2010@gmail.com','Luis Bellido','954741436',NULL,1),(190,'max.vcampos@outlook.com','Maximiliano Alexis Campos Vasquez','79584411',NULL,1),(191,'oliverio1901@hotmail.com','Oliverio Silvano Ruiz','5568741656',NULL,1),(192,'geovannyr15@hotmail.com','Geovanny Cáceres','0998271248',NULL,1),(193,'luvacho@gmail.com','Luis Valle','65682838',NULL,1),(194,'roberto.placido.mtz@gmail.com','Roberto Placido Martinez','8123277902',NULL,1),(195,'anll_12@yahoo.es','allphonse','',NULL,1),(196,'camello.9999@gmail.com','vladimir suncion ','943583898',NULL,1),(197,'emmandeb@gmail.com','emmanuel ramirez','6271212135',NULL,1),(198,'Jesusmiranda92@gmail.com','Jesus','5539086022',NULL,1),(199,'encusanchez97@gmail.com','Aarón Enrique Cuesta Sánchez','3318218124',NULL,1),(200,'rodolfomartin77@gmail.com','Rodolfo Ruiz','0971554217',NULL,1),(201,'salmeanvicente@gmail.com','Vicente Salmeán','5548630346',NULL,1),(202,'Antonyo.saucedo@outlook.com','Antonyo','',NULL,1),(203,'cisnerosia@outlook.com','Iván Alejandro Cisneros Gonzalez','5534899042',NULL,1),(204,'DokoForbidden@gmail.com','Shamir Moscoso Hernandez','9612580709',NULL,1),(205,'chamisimo@gmail.com','francisco aristizabal ','',NULL,1),(206,'alex963@gmail.com','Álvaro Alejandro Urquidi Anaya','+591 79417073',NULL,1),(207,'jajomato.cuellar@hotmail.com','Jairo Jorge Mauricio Toledo Cuellar','3143306236',NULL,1),(208,'elleon_1994@hotmail.com','Rene Leonardo solis pochet','8299211475',NULL,1),(209,'fculqui@gmail.com','Fernando Culqui','59342186677',NULL,1),(210,'aldemarprins@hotmail.com','aldemarprins@hotmail.com','3013907938',NULL,1),(211,'Miguel17_02@outlook.com','Abdias Berrospi Miguel','968441149',NULL,1),(212,'pinedaborges.josealejandro@gmail.com','Jose Pine','+58 414-1453704',NULL,1),(213,'memo_daddy15@hotmail.com','Guillermo Cruz Avendaño','5549208901',NULL,1),(214,'guamanga2206@gmail.com','David Garcia','',NULL,1),(215,'miguelangelgarciaagm1@gmail.com','Miguel Angel Garcia','5558553776',NULL,1),(216,'Jlmejia-es@udabol.edu.bo','JOSE LUIS MEJIA ZENTENO','76919556',NULL,1),(217,'fevece_2006@hotmail.com','FERNANDO VELASQUEZ CARRANZA','51961618157',NULL,1),(218,'princesagm13@hotmail.com','Adriana Maribel Gomez Moreno','0449671300163',NULL,1),(219,'karlitharodriguez030696@gmail.com','karla mendez rodriguez','5570466835',NULL,1),(220,'luiseduardoronquillo@hotmail.com','Luis Ronquillo','',NULL,1),(221,'armandobaptista09@hotmail.com','carlos armando baptista','04269085897',NULL,1),(222,'felix19.fa@gmail.com','felix antonio arteaga paez ','3207248551',NULL,1),(223,'mapesaav3dra@gmail.com','MANUEL SAAVEDRA','+584127916519',NULL,1),(224,'fernan96@live.com','Fernando Chávez Ramos','+52 732 107 6074',NULL,1),(225,'samuel.olvher@gmail.com','samuel','5573365840',NULL,1),(226,'aguilafer_1@hotmail.com','erny fernandez paco','72552734',NULL,1),(227,'arceguadalupe2311@gmail.com','guadalupe arce zahuantitla','5523989418',NULL,1),(228,'dsantillan_0012@hotmail.com','José Domingo Santillán Rodríguez','+525564067695',NULL,1),(229,'carlosca.1994@gmail.com','Carlos Alfredo Caraguay','0969527853',NULL,1),(230,'fabidick22@hotmail.es','Dickson Armijos','593989752112',NULL,1),(231,'edgf83@gmail.com','Edwin orlando gonzalez Funes','503 61856060',NULL,1),(232,'ugellampa@hotmail.com','MAURO CATACORA RODRIGUEZ','931239337',NULL,1),(233,'anahi.markz@gmail.com','Anahi Márquez alor','5539863248',NULL,1),(234,'antuan1508@live.com','César Antuan Garcia Aguilar ','5521137692',NULL,1),(235,'evelasquezvallejos@gmail.com','Erikson Damián Velásquez Vallejos','982103235',NULL,1),(236,'Crisvn07@gmail.com','Cristian vazquez ','5514696280',NULL,1),(237,'jorge_56298@hotmail.com','jorge armando hernandez saldivar','7221128027',NULL,1),(238,'ing.sistema1001@hotmail.com','Daniel','04161054782',NULL,1),(239,'bairombernal263@gmail.com','Barrón Felipe Bernal González ','3174495255',NULL,1),(240,'marval01181975@gmail.com','maro valdez','5524985081',NULL,1),(241,'taniamendieta@hotmail.es','tnia miuta','0989157528',NULL,1),(242,'japtheb@gmail.com','Jenniffer anzola ','3015279676',NULL,1),(243,'mathius.wow@gmail.com','elvis montaño','65714040',NULL,1),(244,'jmbonifaz@hotmail.com','jose manuel bonifaz','951323975',NULL,1),(245,'marcos-alm@hotmail.com','marcos leon mendoza','961906590',NULL,1),(246,'myriale02@gmail.com','Myriam Alexandra Chiran Labre','',NULL,1),(247,'katyverit@hotmail.com','Katy Veronica Avila Rocha','0985828164',NULL,1),(248,'mhenaro@unifin.com.mx','Mauro Etzael Henaro Sánchez ','5548130738',NULL,1),(249,'sebasgb123@gmail.com','Sebastián Gamboa Bautista','',NULL,1),(250,'tellez_9004@hotmail.com','David Tellez','3017436792',NULL,1),(251,'felixurrieta@hotmail.com','Felix Urrieta Velazquez','',NULL,1),(252,'jhoan.111@hotmail.com','Jhoan Sebastian Almeida Caicedo','3057214856',NULL,1),(253,'jhoans.almeidac@utadeo.edu.co','Jhoan Sebastian Almeida Caicedo','3057214856',NULL,1),(254,'darkmapemo12@gmail.com','Mario Perez Mora','5582667586',NULL,1),(255,'clibombon@hotmail.com','Claudia Ivon Gonzalez Ferreira','554909-2734 ',NULL,1),(256,'reyes0421_nasis@hotmail.com','Severiano Reyes Remigio','',NULL,1),(257,'Gargola-101@hotmail.com','Elver hernando aguirre zapata ','3057066308',NULL,1),(258,'jhon.albert.montero@gmail.com','Jhon Albert Montero','3186987847',NULL,1),(259,'nh445827@gmail.com','Nelson Addiel Hernández Delcid  ','99063341 ',NULL,1),(260,'abraham111968@hotmail.com','abraham millan','04147724769',NULL,1),(261,'electrico19.sm@gmail.com','santiago Alexanders montero andrade','',NULL,1),(262,'arriaga.gnu@gmail.com','Josue Arriaga','99999999',NULL,1),(263,'alejandrokno17@gmail.com','Luis Alejandro Cano Monroy ','3006473366',NULL,1),(264,'joctaviorivera@hotmail.com','Juan Octavio Rivera de Leon','8294225578',NULL,1),(265,'huajef@gmail.com','yeferson garcia','3046447759',NULL,1),(266,'ramrayo@hotmail.com','Ronaldo Martinez','',NULL,1),(267,'norbelv@hotmail.com','Norbel Villaverde','054974215670',NULL,1),(268,'magefra9@hotmail.com','magdiel efrain palacios rivera','012881251860',NULL,1),(269,'ronald.arroyo.c@hotmail.com','Ronald Arroyo Condori','+59176077407',NULL,1),(270,'isaac_sierra@ymail.com','Harold Isaac Sierra Valladares','8822-7592',NULL,1),(271,'olgerchuchullo.yo@gmail.com','Olger Chuchullo Tarifa','988 885 875',NULL,1),(272,'bryan.izquierdo17@hotmail.com','Bryan Asencios Izquierdo','932842419',NULL,1),(273,'osver_rs_28@hotmail.com','Osber Nene Ruiz Segura','966893095',NULL,1),(274,'arguijo87@gmail.com','Gerardo Antonio Arguijo Valenzuela','+50494996555',NULL,1),(275,'alex.kyza.19@Gmail.com','Alejandro','',NULL,1),(276,'eloyfloresgalicia@gmail.com','Eloy Gabriel Flores Galicia','5512401711',NULL,1),(277,'ico.jose.villa@gmail.com','Jose Maria Villa Alcantara','5521372892',NULL,1),(278,'luisgmartinezh@gmail.com','luis','',NULL,1),(279,'racf7722@gmail.com','fernando angel ruiz cortes','',NULL,1),(280,'fgonzalezjarquin@gmail.com','Felix Pedro González Jarquin','+50585267246',NULL,1),(281,'fredyalzatemesa@hotmail.com','John Fredy Alzate Mesa','3002008185',NULL,1),(282,'karojuliet_06@hotmail.com','julieta carolina monroy juárez ','',NULL,1),(283,'rodriguez.hernandez204@gmail.com','Jose Alberto Rodriguez Hernandez','5525089004',NULL,1),(284,'jimenezsara10@hotmail.com','sara','',NULL,1),(285,'edgari_forever@hotmail.com','Edgari ibarra ','5540699748',NULL,1),(286,'isaac.sick.18@hotmail.com','isaac filiberto garcia zaragoza','5539495781',NULL,1),(287,'agencia_spider@live.com.mx','Ricardo Peña Vargas','',NULL,1),(288,'samr950404@hotmail.com','René de Jesús Sánchez Miranda','',NULL,1),(289,'Cornejojimenezav@hotmail.com','David Jiménez','5563698230',NULL,1),(290,'daniellecalle@hotmail.com','daniel calle','3002259004',NULL,1),(291,'saidmc@gmail.com','Said Muñoz','5516942712',NULL,1),(292,'kirito_13@outlook.es','Efrain Granados Zavala','2781161586',NULL,1),(293,'Miguelangel.hdez@gmail.com','Miguel Ángel Hernández ','55 6192 9042 ',NULL,1),(294,'guiller681@gmail.com','Angel Guillermo Flores','931451711',NULL,1),(295,'Jahazielm3@gmail.com','Jahaziel Martinez','5545541033',NULL,1),(296,'miguel_perezsantos@yahoo.com.mx','Miguel Perez Santos','',NULL,1),(297,'allanmaleman@gmail.com','Allan Mendoza','87706281',NULL,1),(298,'c8m5l0@hotmail.com','ivan c lucumi g','3117586075',NULL,1),(299,'atolex-04@hotmail.com','jose arturo','2226265084',NULL,1),(300,'cristianalexis-10@hotmail.com','cristian rendon','3126395864',NULL,1),(301,'hector.roba11@gmail.com','Hector Ivan Rodriguez Barrera','5516912386',NULL,1),(302,'tikim723@gmail.com','Eutiquio Javier Ortega Flores','3310758018',NULL,1),(303,'basoaltofabian@gmail.com','Fabian David Basoalto Garnica','0996370724',NULL,1),(304,'ricardosxky@gmail.com','Ricardo Pérez','04261872114',NULL,1),(305,'smanuelider@gmail.com','Manuel Gil','04263650719',NULL,1),(306,'ccggomez9@hotmail.com','Carlos Saul','3125958775',NULL,1),(307,'avm050281@yahoo.com.mx','Mario Eduardo Alvarez Vargas ','5534968910',NULL,1),(308,'luis-781@hotmail.com','Luis Alberto Acosta Hernandez','019931121547',NULL,1),(309,'micniklisoso@gmail.com','lisoso','5591889213',NULL,1),(310,'ramiro.vargassalas@gmail.com','Ramiro Vargas Salas','3142250882',NULL,1),(311,'cesarchavez_94@hotmail.com','cesar jose Chavez tampoa','04161543897',NULL,1),(312,'pelusa1102@gmail.com','lourdes diaz ','5545180775',NULL,1),(313,'nicolasdc7010@gmail.com','nicolas perez juan carlos','556423186',NULL,1),(314,'cristofer9628@hotmail.com','roni calsin','950311891',NULL,1),(315,'fabioricardo.senai@gmail.com','fabio ricardo moraes da silva','6299520444',NULL,1),(316,'kenyerling@gmail.com','kenyerling medina ','04267342745',NULL,1),(317,'stgo_1989@hotmail.com','adan santiago flores','7831087793',NULL,1),(318,'lic.eduardo_mex@hotmail.com','Eduardo Mex','','',1),(319,'david_alva16@outlook.email','David Álvarez Carrillo','55 5144 6979',NULL,1),(320,'guarnerosalan@hotmail.com','Alan guarneros','6535515480',NULL,1),(321,'wmpoli_cym20@hotmail.com','Michel Alan Lopez Lara','015554556544',NULL,1),(322,'Antaboyts@gmail.com','Antonio aboytes flores','5543396658',NULL,1),(323,'sabterc@gmail.com','Jonathan Calzada','5523144399',NULL,1),(324,'noemigp@outlook.es','Noemi GP','',NULL,1),(325,'ppjosh.77@gmail.com','Jose Erasmo Matias Reyes','5519288406',NULL,1),(326,'alejandrocominachacaliaza@gmail.com','alejandro comina','923154945',NULL,1),(327,'edgardavismx@yahoo.com.mx','edgar omar chaverri davis','5570521108',NULL,1),(328,'garciacruz961@yahoo.com','jose cruz garcia','5538364638',NULL,1),(329,'onicna@hotmail.com','Adriana Colinabarranco Cancino','5522520448',NULL,1),(330,'rafael.glez@gmail.com','Rafael González','5540597638',NULL,1),(331,'eycontreraas@ccicsa.com.mx','edith yolanda contreras juarez ','5526908994',NULL,1),(332,'rodroab88@gmail.com','Rodrigo Aguilar Baltazar','5522055763',NULL,1),(333,'ghaby_estrada_150292@hotmail.com','Gabriela Estrdaa','',NULL,1),(334,'C@h.com','V','V',NULL,1),(335,'juanangel59@live.com.mx','Juan Espinoza ','',NULL,1),(336,'qcd_bariones@hotmail.com','Francisco Javier Pérez Domínguez','2281765442',NULL,1),(337,'angel01210820@gmail.com','ANGEL','',NULL,1),(338,'princesskari46@hotmail.com','karina mendoza','5524047800',NULL,1),(339,'Angel-Sanchez-SR@hotmail.com','Angel Sanchez Castro','58554003',NULL,1),(340,'daverock94@hotmail.com','David Hernández Lopez','5549543864',NULL,1),(341,'jfvynms4281rt@hotmail.com','Barnypok','64169647536',NULL,1),(342,'ivanr.hernad@hotmail.com','Rodrigo Gonzalez','5526032025',NULL,1),(343,'ivanapps18@gmail.com','Ivan Cardenas','56581111',NULL,1),(344,'angelo_1992_16@hotmail.com','Miguel Ángel Rodríguez Arellano','5543758564',NULL,1);
/*!40000 ALTER TABLE `tbl_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tutorial`
--

DROP TABLE IF EXISTS `tbl_tutorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tutorial` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `HIERARCHY_ID` int(11) DEFAULT NULL,
  `NAME` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `RESUME` text COLLATE utf8_spanish_ci,
  `DESCRIPTION` text COLLATE utf8_spanish_ci,
  `ALIAS` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CONTENT` text COLLATE utf8_spanish_ci,
  `RANKING` smallint(6) DEFAULT NULL,
  `PUBLISHED_DATE` date DEFAULT NULL,
  `AUTHOR` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `REF` text COLLATE utf8_spanish_ci,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_7` (`HIERARCHY_ID`),
  CONSTRAINT `FK_REFERENCE_TUTORIAL_1` FOREIGN KEY (`HIERARCHY_ID`) REFERENCES `tbl_mentoring_hyerarchy` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tutorial`
--

LOCK TABLES `tbl_tutorial` WRITE;
/*!40000 ALTER TABLE `tbl_tutorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tutorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tutorial_document`
--

DROP TABLE IF EXISTS `tbl_tutorial_document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tutorial_document` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TUTORIAL_ID` int(11) DEFAULT NULL,
  `NAME` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DOCUMENT_TYPE` smallint(6) DEFAULT NULL,
  `DESCRIPTION` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PATH` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SIZE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `THUMBNAIL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_TYPE` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEL_URL` varchar(300) COLLATE utf8_spanish_ci DEFAULT NULL,
  `STATUS` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `TUTORIAL_ID` (`TUTORIAL_ID`),
  CONSTRAINT `tbl_tutorial_document_ibfk_1` FOREIGN KEY (`TUTORIAL_ID`) REFERENCES `tbl_tutorial` (`ID`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tutorial_document`
--

LOCK TABLES `tbl_tutorial_document` WRITE;
/*!40000 ALTER TABLE `tbl_tutorial_document` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tutorial_document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_oauth`
--

DROP TABLE IF EXISTS `tbl_user_oauth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user_oauth` (
  `user_id` int(11) NOT NULL,
  `provider` varchar(45) NOT NULL,
  `identifier` varchar(64) NOT NULL,
  `profile_cache` text,
  `session_data` text,
  PRIMARY KEY (`provider`,`identifier`),
  UNIQUE KEY `unic_user_id_name` (`user_id`,`provider`),
  KEY `oauth_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_oauth`
--

LOCK TABLES `tbl_user_oauth` WRITE;
/*!40000 ALTER TABLE `tbl_user_oauth` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_user_oauth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `activkey` varchar(128) NOT NULL DEFAULT '',
  `createtime` int(10) NOT NULL DEFAULT '0',
  `lastvisit` int(10) NOT NULL DEFAULT '0',
  `superuser` int(1) NOT NULL DEFAULT '0',
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `status` (`status`),
  KEY `superuser` (`superuser`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES (1,'admin','3fc9a732d99ed073918370c4c1de0c65','miguelangelgarciaagm1@gmail.com','8142a2daf365271fbd92ee36bf8f799f',1261146094,1484095011,1,1),(8,'fculqui','786aef590c529afa7d0bc2dc4230f8b6','fculqui@gmail.com','ff184225abe7dfc81398ef0f9b56ba81',1463716557,1463716722,0,1),(9,'olgerct','','olgerchuchullo.yo@gmail.com','54ff845e5c1d481824956ae804341d51',0,0,0,0);
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-04  9:56:38
