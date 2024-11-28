DROP TABLE IF EXISTS T_LINEA_ESTACION;
DROP TABLE IF EXISTS T_ACCESO;
DROP TABLE IF EXISTS T_TREN;
DROP TABLE IF EXISTS T_COLOR;
DROP TABLE IF EXISTS T_COCHERA;
DROP TABLE IF EXISTS T_LINEA;
DROP TABLE IF EXISTS T_ESTACION;
/* */
# Crear la tabla T_COCHERA
CREATE TABLE IF NOT EXISTS T_COCHERA(
	cod_cochera INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(255) NOT NULL,
	direccion VARCHAR(255) NOT NULL,
	deposito BOOL, -- Valores 1  y 0
	CONSTRAINT PRIMARY KEY (cod_cochera)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

# Crear la tabla T_LINEA
CREATE TABLE IF NOT EXISTS T_LINEA(
	cod_linea INT AUTO_INCREMENT NOT NULL,
	nombre_corto VARCHAR(50) NOT NULL,
	nombre_largo VARCHAR(100) NOT NULL,
	fecha_inauguracion DATE NULL,
	kilometros FLOAT(5,2) NOT NULL,
	CONSTRAINT PRIMARY KEY (cod_linea)		
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


# Crear la tabla T_COLOR
CREATE TABLE IF NOT EXISTS T_COLOR(
	cod_color INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	cod_hexadecimal VARCHAR(7) NOT NULL,
	cod_linea INT NOT NULL,
	CONSTRAINT PRIMARY KEY (cod_color),
	CONSTRAINT UNIQUE (cod_linea),
	CONSTRAINT FK_COLOR_LINEA
	  FOREIGN KEY (cod_linea) REFERENCES T_LINEA(cod_linea)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

# Crear la tabla T_ESTACION
CREATE TABLE IF NOT EXISTS T_ESTACION(
	cod_estacion INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	direccion VARCHAR(255) NOT NULL,
	CONSTRAINT PRIMARY KEY (cod_estacion)		
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

	
# Crear la tabla T_ACCESO
CREATE TABLE IF NOT EXISTS T_ACCESO(
	cod_acceso INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	acceso_discapacidad BOOL NOT NULL, -- 1 y 0
	cod_estacion INT NOT NULL,	
	CONSTRAINT PRIMARY KEY (cod_acceso),		
	CONSTRAINT FK_ACCESO_ESTACION
	  FOREIGN KEY (cod_estacion) REFERENCES T_ESTACION(cod_estacion)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


# Crear la tabla T_TREN
CREATE TABLE IF NOT EXISTS T_TREN(
	cod_tren INT AUTO_INCREMENT NOT NULL,
	modelo VARCHAR(100) NOT NULL,
	empresa_constructora VARCHAR(255) NOT NULL,
	fecha_incorporacion DATE ,
	cod_cochera INT NOT NULL,	
	cod_linea INT NOT NULL,
	CONSTRAINT PRIMARY KEY (cod_tren),				
	CONSTRAINT FK_TREN_COCHERA
		FOREIGN KEY (cod_cochera) REFERENCES T_COCHERA(cod_cochera),	
	CONSTRAINT FK_TREN_LINEA
		FOREIGN KEY (cod_linea) REFERENCES T_LINEA(cod_linea)	
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;



# Crear la tabla T_LINEA_ESTACION
CREATE TABLE IF NOT EXISTS T_LINEA_ESTACION(
	cod_linea INT NOT NULL,	
	cod_estacion INT NOT NULL,	
	orden INT NOT NULL,	
	CONSTRAINT PRIMARY KEY (cod_linea, cod_estacion),
	CONSTRAINT FK_LINEAESTACION_LINEA
	  FOREIGN KEY (cod_linea) REFERENCES T_LINEA(cod_linea),	
	CONSTRAINT FK_LINEAESTACION_ESTACION
	  FOREIGN KEY (cod_estacion) REFERENCES T_ESTACION(cod_estacion)	
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


/* INFORMACIÓN */
-- Tabla T_LINEA --
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (1, 'Ramal', 'Ópera - Principe Pío',  0.75);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (2, 'Línea 1', 'Pinar de Chamartín - Valdecarros',  12.25);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (3, 'Línea 2' , 'Las Rosas - Cuatro Caminos', 9.54);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (4, 'Línea 3', 'Villaverde Alto - Moncloa', 8.34);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (5, 'Línea 4', 'Arguelles - Pinar de Chamartín', 7.5);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (6, 'Línea 5', 'Alameda de Osuna - Casa de Campo', 6.5);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (7, 'Línea 6', 'Circular', 17.75);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (8, 'Línea 7', 'Hospital del Henares -  Pitis', 15);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (9, 'Línea 8', 'Nuevos Ministerios - Aeropuerto', 7.45);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (10, 'Línea 9', 'Paco de Lucía -  Arganda del Rey', 10.75);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (11, 'Línea 10', 'Hospital Infanta Sofía - Puerta del Sur', 12.75);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (12, 'Línea 11', 'Plaza Elíptica -  La Fortuna', 3.75);
INSERT INTO T_LINEA (cod_linea,nombre_corto, nombre_largo,kilometros) values (13, 'Línea 12', 'Metrosur', 10.75);


-- Tabla T_COLOR --
INSERT INTO T_COLOR VALUES (1, 'Azul', '#438dc0', 2);
INSERT INTO T_COLOR VALUES (2, 'Rojo', '#fc3738', 3);
INSERT INTO T_COLOR VALUES (3, 'Amarillo', '#fec128', 4);
INSERT INTO T_COLOR VALUES (4, 'Marrón', '#741013', 5);
INSERT INTO T_COLOR VALUES (5, 'Verde', '#83b41c', 6);
INSERT INTO T_COLOR VALUES (6, 'Gris', '#939493', 7);
INSERT INTO T_COLOR VALUES (7, 'Naranja', '#fd9924', 8);
INSERT INTO T_COLOR VALUES (8, 'Rosa', '#f5418e', 9);
INSERT INTO T_COLOR VALUES (9, 'Morado', '#8a026b', 10);
INSERT INTO T_COLOR VALUES (10, 'Azul marino', '#09117e', 11);
INSERT INTO T_COLOR VALUES (11, 'Verde oscuro', '#065a16', 12);
INSERT INTO T_COLOR VALUES (13, 'Blanco ramal', '#fff3ff', 1);
INSERT INTO T_COLOR VALUES (14, 'Ocre oscuro', '#ffffff', 13);


-- Tabla T_COCHERA --
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (1, 1, 'PUERTA DE ARGANDA', 'CARRETERA M-203 KM 2,300 (CAMINO DE VALLECAS A MEJORADA)');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (2, 1, 'UNIVERSIDAD REY JUAN CARLOS', 'AVENIDA ALCALDE DE MÓSTOLES Nº 35');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (3, 1, 'EL BERCIAL', 'PRÓXIMO A CARRETERA DE TURQUÍA (BARRIO DE EL BERCIAL)');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (4, 1, 'ARGANZUELA - PLANETARIO', 'C/ BRONCE Nº 1');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (5, 1, 'CIUDAD UNIVERSITARIA', 'PLAZA RAMÓN Y CAJAL');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (6, 1, 'MIGUEL HERNANDEZ', 'AVENIDA DE LA ALBUFERA ESQ. CALLE RAFAEL ALBERTI');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (7, 1, 'ARGÜELLES', 'C/ PRINCESA Nº 56');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (8, 1, 'ALMENDRALES', 'AVENIDA DE CÓRDOBA, 21');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (9, 1, 'MONCLOA', 'C/ PRINCESA, 96');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (10, 1, 'NUEVOS MINISTERIOS', 'PASEO DE LA CASTELLANA Nº 67');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (11, 0, 'CUATRO CAMINOS', 'VIRGEN DE NIEVA S/N');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (12, 0, 'VENTAS', 'ALMERÍA 6');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (13, 0, 'PLAZA DE CASTILLA', 'SAN BENITO S/N');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (14, 0, 'CANILLEJAS', 'NECTAR S/N');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (15, 0, 'ALUCHE', 'AVDA. DE LOS POBLADOS Nº 11');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (16, 0, 'FUENCARRAL', 'AVENIDA CAMPO DE CALATRAVA Nº 86');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (17, 0, 'SACEDAL', 'VENTISQUERO DE LA CONDESA S/N');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (18, 0, 'LAGUNA', 'GOTAREDURA Nº 3');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (19, 0, 'HORTALEZA', 'C/ MANUEL AZAÑA');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (20, 0, 'CUATRO VIENTOS', 'CRTA. DE CANALEJAS S/N');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (21, 0, 'LORANCA', 'AVDA. DE LA ALEGRÍA (FUENLABRADA)');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (22, 0, 'VALDECARROS', 'AVENIDA CERRO MILANO 0103 ENSANCHE DE VALLECAS, 73 ');
INSERT INTO T_COCHERA (cod_cochera, deposito ,nombre, direccion) VALUES (23, 0, 'VILLAVERDE', 'AVENIDA REAL DE PINTO');
