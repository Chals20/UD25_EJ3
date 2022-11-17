DROP TABLE IF EXISTS almacen;
DROP TABLE IF EXISTS caja;

CREATE TABLE almacen(
	id INT AUTO_INCREMENT PRIMARY KEY,
	lugar varchar(100),
    capacidad int
);

CREATE TABLE caja(
	id INT AUTO_INCREMENT PRIMARY KEY,
    contenido varchar(100),
    valor int,
    almacen int,
    FOREIGN KEY (almacen) REFERENCES almacen(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO almacen (lugar, capacidad) VALUES ('Tarragona', 110), ('Salou', 220);
INSERT INTO caja (contenido, valor, almacen) VALUES ('Muebles', 250, 1), ('Electrodomesticos', 390, 2);