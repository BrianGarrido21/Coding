-- Active: 1679570069688@@127.0.0.1@3306@Concesionario
CREATE TABLE car (
    car_id int(7) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    brand VARCHAR(20),
    url VARCHAR(30),
    gear VARCHAR(20),
    consume VARCHAR(20),
    pontency VARCHAR(20),
    fuel VARCHAR(20),
    doors VARCHAR(20),
    price int(9),
    color VARCHAR(20),
);

CREATE TABLE user (
    user_id INT(7) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    email VARCHAR(20),
    tel VARCHAR(9),
    pass VARCHAR(12),
    money decimal(7,2),
    creditC VARCHAR(8)
);

CREATE TABLE venta(
    invoice_id int(7),
    car_id int(7),
    user_id int(7),
    invoice_price int(9),
    invoice_date DATE,
    PRIMARY KEY(invoice_id),
    FOREIGN KEY(car_id) REFERENCES car (car_id)
    FOREIGN KEY(user_id) REFERENCES users (user_id)
)

DELIMITER //
DROP PROCEDURE IF EXISTS buy_car//
CREATE PROCEDURE buy_car(par_use_id INT(7),par_money INT(7),par_pri INT(7))
BEGIN
    IF par_money>par_pri THEN
        UPDATE users
        set money=par_money-par_pri
        WHERE user_id=par_use_id;
    ELSE   
        signal SQLSTATE '20003'
        set message_text= 'Error not enough money';
    END IF;
END//

DELIMITER //
DROP PROCEDURE IF EXISTS add_money//
CREATE PROCEDURE add_money(par_use_id INT(7),par_money INT(7),par_creditC varchar(8))
BEGIN
                       
    UPDATE users
    set money=par_money
    WHERE user_id=par_use_id;
    
END//

DELIMITER//
DROP PROCEDURE if EXISTS change_pass//
CREATE PROCEDURE change_pass(par_use_id INT(7), par_pass int(8))
BEGIN
    UPDATE users
    set pass=par_pass
    WHERE user_id= par_use_id
END//

insert into car (name,brand,url,gear,consume,pontency,fuel,doors,price,color)
values
    ('3008','Peugeot','/fotos/3008.jpeg','Manual','135CV','6l/100km','Diesel','5 Puertas',28270,'Rojo'),
    ('Tucson','Hyundai','/fotos/tucson.jpeg','Manual','140CV','5,2l/100km','Diesel','5 Puertas',27125,'Azul'),
    ('Kuga','Ford','/fotos/kuga.jpeg','Automático','125CV','4,9l/100km','Gasolina','5 Puertas',27125,'Rojo'),
    ('Xsara Picasso','Cintroën','/fotos/sxara.jpeg','Manual','90CV','5l/100km','Diesel','5 Puertas',14200,'Gris dorado'),
    ('Corsa','Opel','/fotos/corsa.png','Automático','90CV','4,8l/100km','Diesel','5 Puertas',17300,'Rojo'),
    ('Sian','Lamborghini','/fotos/sian.png','Manual','819CV','19,2l/100km','Diesel','2 Puertas',3000000,'Azul');
