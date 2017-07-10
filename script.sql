use jpa;
drop table if EXISTS Car;
drop table if EXISTS Model;
drop table if EXISTS Manufacturer;
DROP TABLE IF EXISTS Category;

CREATE TABLE Manufacturer (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name varchar(15) NOT NULL
)engine=innodb;

CREATE TABLE Model (
  id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(15) NOT NULL,
  manufacturer int NOT NULL,
  FOREIGN KEY (manufacturer) REFERENCES Manufacturer(id)
)engine=innodb;

CREATE TABLE Car (
  id    INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  vin   VARCHAR(17) NOT NULL,
  model INT         NOT NULL,
  FOREIGN KEY (model) REFERENCES Model(id)
)engine=innodb;

CREATE TABLE Category (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(50) NOT NULL,
  url VARCHAR(50),
  parent_id INT
)ENGINE=innodb;

/*INSERT INTO Car VALUES(1, 'Company1', 'Audi', 52642);
INSERT INTO Car VALUES(2, 'Company2','Mercedes', 57127);
INSERT INTO Car VALUES(3, 'Company3','Skoda', 9000);
INSERT INTO Car VALUES(4, 'Company4','Volvo', 29000);
INSERT INTO Car VALUES(5, 'Company5','Bentley', 350000);
INSERT INTO Car VALUES(6, 'Company6','Citroen', 21000);
INSERT INTO Car VALUES(7, 'Company7','Hummer', 41400);
INSERT INTO Car VALUES(8, 'Company8','Volkswagen', 21600);*/

INSERT INTO manufacturer (name) VALUES ('Ford');
INSERT INTO manufacturer (name) VALUES ('General Motors');
INSERT INTO manufacturer (name) VALUES ('Toyota');

INSERT INTO model (name, manufacturer)
VALUES (
  'Camry',
  (SELECT manufacturer.id FROM manufacturer
  WHERE manufacturer.name = 'Toyota'
   ));

INSERT INTO model (name, manufacturer)
VALUES (
  'Fusion',
  (SELECT manufacturer.id FROM manufacturer
  WHERE manufacturer.name= 'Ford'
   ));

INSERT INTO model (name, manufacturer)
VALUES (
  'Buick Regal',
  (SELECT manufacturer.id FROM manufacturer
  WHERE manufacturer.name= 'General Motors'
   ));


INSERT INTO car (vin, model)
VALUES (
  '0123456789abcdefg',
  (SELECT model.id FROM model
  WHERE model.name = 'Camry'
));

INSERT INTO car (vin, model)
VALUES (
  'abcdefg0123456789',
  (SELECT model.id
   FROM model
   WHERE model.name = 'Buick Regal'
));

INSERT INTO Category (id, name, description, url, parent_id) VALUES (1, "Tutorials", "Tutorials Menu", NULL , NULL );
INSERT INTO Category (name, description, url, parent_id) VALUES ("PHP", "PHP Tutorials", "#", 1);
INSERT INTO Category (name, description, url, parent_id) VALUES ("Java", "Java Tutorials", "#", 1);
INSERT INTO Category (name, description, url, parent_id) VALUES ("CSS", "CSS Tutorials", "#", 1);